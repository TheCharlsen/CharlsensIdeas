package io.github.thecharlsen.charlsensideas.Blocks;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.ibm.icu.impl.locale.XCldrStub;
import io.github.thecharlsen.charlsensideas.Blocks.Enums.Tilt;
import io.github.thecharlsen.charlsensideas.CharlsensideasBlocks;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Util;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.*;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Random;

public class RingLeafBlock extends HorizontalFacingBlock implements Fertilizable, Waterloggable {
    private static final BooleanProperty WATERLOGGED;
    private static final EnumProperty<Tilt> TILT;
    private static final int field_31015 = -1;
    private static final Object2IntMap<Tilt> NEXT_TILT_DELAYS;
    private static final int field_31016 = 5;
    private static final int field_31017 = 6;
    private static final int field_31018 = 11;
    private static final int field_31019 = 13;
    private static final Map<Tilt, VoxelShape> SHAPES_FOR_TILT;
    private static final VoxelShape BASE_SHAPE;
    private static final Map<Direction, VoxelShape> SHAPES_FOR_DIRECTION;
    private final Map<BlockState, VoxelShape> shapes;

    public RingLeafBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH).with(TILT, Tilt.NONE));
        this.shapes = this.getShapesForStates(RingLeafBlock::getShapeForState);
    }

    private static VoxelShape getShapeForState(BlockState state) {
        return VoxelShapes.union(SHAPES_FOR_TILT.get(state.get(TILT)), SHAPES_FOR_DIRECTION.get(state.get(FACING)));
    }

    public static void grow(WorldAccess world, Random random, BlockPos pos, Direction direction) {
        int i = MathHelper.nextInt(random, 2, 5);
        BlockPos.Mutable mutable = pos.mutableCopy();
        int j = 0;

        while(j < i && canGrowInto(world, mutable, world.getBlockState(mutable))) {
            ++j;
            mutable.move(Direction.UP);
        }

        int k = pos.getY() + j - 1;
        mutable.setY(pos.getY());

        while(mutable.getY() < k) {
            RingLeafStemBlock.placeStemAt(world, mutable, world.getFluidState(mutable), direction);
            mutable.move(Direction.UP);
        }

        placeDripleafAt(world, mutable, world.getFluidState(mutable), direction);
    }

    private static boolean canGrowInto(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) || state.isOf(Blocks.SMALL_DRIPLEAF);
    }

    protected static boolean canGrowInto(HeightLimitView world, BlockPos pos, BlockState state) {
        return !world.isOutOfHeightLimit(pos) && canGrowInto(state);
    }

    protected static boolean placeDripleafAt(WorldAccess world, BlockPos pos, FluidState fluidState, Direction direction) {
        BlockState blockState = CharlsensideasBlocks.RingLeaf.getDefaultState().with(WATERLOGGED, fluidState.isEqualAndStill(Fluids.WATER)).with(FACING, direction);
        return world.setBlockState(pos, blockState, 3);
    }

    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        this.changeTilt(state, world, hit.getBlockPos(), Tilt.FULL, SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_DOWN);
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isOf(CharlsensideasBlocks.RingLeafStem) || blockState.isOf(this) || blockState.isSideSolidFullSquare(world, blockPos, Direction.UP);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.DOWN && !state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            if (state.get(WATERLOGGED)) {
                world.getFluidTickScheduler().isTicking(pos, Fluids.WATER);
            }

            return direction == Direction.UP && neighborState.isOf(this) ? CharlsensideasBlocks.RingLeafStem.getStateWithProperties(state) : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
    }

    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        BlockState blockState = world.getBlockState(pos.up());
        return canGrowInto(blockState);
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        if (canGrowInto(world, blockPos, blockState)) {
            Direction direction = state.get(FACING);
            RingLeafStemBlock.placeStemAt(world, pos, state.getFluidState(), direction);
            placeDripleafAt(world, blockPos, blockState.getFluidState(), direction);
        }

    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient) {
            if (state.get(TILT) == Tilt.NONE && isEntityAbove(pos, entity) && !world.isReceivingRedstonePower(pos)) {
                this.changeTilt(state, world, pos, Tilt.UNSTABLE, null);
            }

        }
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.isReceivingRedstonePower(pos)) {
            resetTilt(state, world, pos);
        } else {
            Tilt tilt = state.get(TILT);
            if (tilt == Tilt.UNSTABLE) {
                this.changeTilt(state, world, pos, Tilt.UNDERSTABLE, SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_DOWN);
            } else if (tilt == Tilt.UNDERSTABLE) {
                this.changeTilt(state, world, pos, Tilt.UNDERESTIMATED, SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_DOWN);
            } else if (tilt == Tilt.UNDERESTIMATED) {
                this.changeTilt(state, world, pos, Tilt.PARTIAL, SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_DOWN);
            } else if (tilt == Tilt.PARTIAL) {
                this.changeTilt(state, world, pos, Tilt.UNACCEPTABLE, SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_DOWN);
            } else if (tilt == Tilt.UNACCEPTABLE) {
                this.changeTilt(state, world, pos, Tilt.UNPARTIAL, SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_DOWN);
            } else if (tilt == Tilt.UNPARTIAL) {
               this.changeTilt(state, world, pos, Tilt.FULL, SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_DOWN);
            } else if (tilt == Tilt.FULL) {
                resetTilt(state, world, pos);
            }

        }
    }

    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (entity.bypassesLandingEffects()) {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        } else {
            entity.handleFallDamage(fallDistance, 0.0F, DamageSource.FALL);
        }

    }

    public void onEntityLand(BlockView world, Entity entity) {
        if (entity.bypassesLandingEffects()) {
            super.onEntityLand(world, entity);
        } else {
            this.bounce(entity);
        }

    }

    private void bounce(Entity entity) {
        Vec3d vec3d = entity.getVelocity();
        if (vec3d.y < 0.0D) {
            double d = entity instanceof LivingEntity ? 1.0D : 0.8D;
            entity.setVelocity(vec3d.x, -vec3d.y * d, vec3d.z);
        }

    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (world.isReceivingRedstonePower(pos)) {
            resetTilt(state, world, pos);
        }

    }

    private static void playTiltSound(World world, BlockPos pos, SoundEvent soundEvent) {
        float f = MathHelper.nextBetween(world.random, 0.8F, 1.2F);
        world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, f);
    }

    private static boolean isEntityAbove(BlockPos pos, Entity entity) {
        return entity.isOnGround() && entity.getPos().y > (double)((float)pos.getY() + 0.6875F);
    }

    private void changeTilt(BlockState state, World world, BlockPos pos, Tilt tilt, @Nullable SoundEvent sound) {
        changeTilt(state, world, pos, tilt);
        if (sound != null) {
            playTiltSound(world, pos, sound);
        }

        int i = NEXT_TILT_DELAYS.getInt(tilt);
        if (i != -1) {
            world.getBlockTickScheduler().isTicking(pos, this);
        }

    }

    private static void resetTilt(BlockState state, World world, BlockPos pos) {
        changeTilt(state, world, pos, Tilt.NONE);
        if (state.get(TILT) != Tilt.NONE) {
            playTiltSound(world, pos, SoundEvents.BLOCK_BIG_DRIPLEAF_TILT_UP);
        }

    }

    private static void changeTilt(BlockState state, World world, BlockPos pos, Tilt tilt) {
        world.setBlockState(pos, state.with(TILT, tilt), 2);
        if (tilt.isStable()) {
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos);
        }

    }

    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES_FOR_TILT.get(state.get(TILT));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.shapes.get(state);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().down());
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean bl = blockState.isOf(CharlsensideasBlocks.RingLeaf) || blockState.isOf(CharlsensideasBlocks.RingLeafStem);
        return this.getDefaultState().with(WATERLOGGED, fluidState.isEqualAndStill(Fluids.WATER)).with(FACING, bl ? blockState.get(FACING) : ctx.getPlayerFacing().getOpposite());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{WATERLOGGED, FACING, TILT});
    }

    static {
        WATERLOGGED = Properties.WATERLOGGED;
        TILT = BlockProperties.TILT;
        NEXT_TILT_DELAYS = (Object2IntMap) Util.make(new Object2IntArrayMap(), (delays) -> {
            delays.defaultReturnValue(-1);
            delays.put(Tilt.UNSTABLE, 10);
            delays.put(Tilt.UNDERSTABLE, 10);
            delays.put(Tilt.UNDERESTIMATED, 10);
            delays.put(Tilt.PARTIAL, 10);
            delays.put(Tilt.UNACCEPTABLE, 10);
            delays.put(Tilt.UNPARTIAL, 10);
            delays.put(Tilt.FULL, 100);
        });
        SHAPES_FOR_TILT = Map.of(Tilt.NONE, Block.createCuboidShape(0.0D, 13.0D, 0.0D, 16.0D, 15.0D, 16.0D), Tilt.UNSTABLE, Block.createCuboidShape(0.0D, 13.0D, 0.0D, 16.0D, 15.0D, 16.0D), Tilt.UNDERSTABLE, Block.createCuboidShape(0.0D, 12.0D, 0.0D, 16.0D, 14.0D, 16.0D), Tilt.UNDERESTIMATED, Block.createCuboidShape(0.0D, 11.0D, 0.0D, 16.0D, 13.0D, 16.0D), Tilt.PARTIAL, Block.createCuboidShape(0.0D, 10.0D, 0.0D, 16.0D, 12.0D, 16.0D), Tilt.UNACCEPTABLE, Block.createCuboidShape(0.0D, 9.0D, 0.0D, 16.0D, 11.0D, 16.0D), Tilt.UNPARTIAL, Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 10.0D, 16.0D), Tilt.FULL, Block.createCuboidShape(0.0D, 7.0D, 0.0D, 16.0D, 9.0D, 16.0D));
        BASE_SHAPE = Block.createCuboidShape(0.0D, 13.0D, 0.0D, 16.0D, 16.0D, 16.0D);
        SHAPES_FOR_DIRECTION = ImmutableMap.of(Direction.NORTH, VoxelShapes.combine(RingLeafStemBlock.NORTH_SHAPE, BASE_SHAPE, BooleanBiFunction.ONLY_FIRST), Direction.SOUTH, VoxelShapes.combine(RingLeafStemBlock.SOUTH_SHAPE, BASE_SHAPE, BooleanBiFunction.ONLY_FIRST), Direction.EAST, VoxelShapes.combine(RingLeafStemBlock.EAST_SHAPE, BASE_SHAPE, BooleanBiFunction.ONLY_FIRST), Direction.WEST, VoxelShapes.combine(RingLeafStemBlock.WEST_SHAPE, BASE_SHAPE, BooleanBiFunction.ONLY_FIRST));
    }
}
