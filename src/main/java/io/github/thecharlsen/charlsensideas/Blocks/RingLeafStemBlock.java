package io.github.thecharlsen.charlsensideas.Blocks;

import io.github.thecharlsen.charlsensideas.CharlsensideasBlocks;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.*;

import java.util.Optional;
import java.util.Random;

public class RingLeafStemBlock extends HorizontalFacingBlock implements Fertilizable, Waterloggable {
    private static final BooleanProperty WATERLOGGED;
    private static final int field_31021 = 6;
    protected static final VoxelShape NORTH_SHAPE;
    protected static final VoxelShape SOUTH_SHAPE;
    protected static final VoxelShape EAST_SHAPE;
    protected static final VoxelShape WEST_SHAPE;

    public RingLeafStemBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(FACING, Direction.NORTH));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch(state.get(FACING)) {
            case SOUTH:
                return SOUTH_SHAPE;
            case NORTH:
            default:
                return NORTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
                return EAST_SHAPE;
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{WATERLOGGED, FACING});
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        BlockState blockState2 = world.getBlockState(pos.up());
        return (blockState.isOf(this) || blockState.isSideSolidFullSquare(world, blockPos, Direction.UP)) && (blockState2.isOf(this) || blockState2.isOf(CharlsensideasBlocks.RingLeaf));
    }

    protected static boolean placeStemAt(WorldAccess world, BlockPos pos, FluidState fluidState, Direction direction) {
        BlockState blockState = CharlsensideasBlocks.RingLeafStem.getDefaultState().with(WATERLOGGED, fluidState.isEqualAndStill(Fluids.WATER)).with(FACING, direction);
        return world.setBlockState(pos, blockState, 3);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if ((direction == Direction.DOWN || direction == Direction.UP) && !state.canPlaceAt(world, pos)) {
            world.getBlockTickScheduler().isTicking(pos, this);
        }

        if (state.get(WATERLOGGED)) {
            world.getFluidTickScheduler().isTicking(pos, Fluids.WATER);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.canPlaceAt(world, pos)) {
            world.breakBlock(pos, true);
        }

    }

    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        Optional<BlockPos> optional = BlockLocating.findColumnEnd(world, pos, state.getBlock(), Direction.UP, Blocks.BIG_DRIPLEAF);
        if (!optional.isPresent()) {
            return false;
        } else {
            BlockPos blockPos = optional.get().up();
            BlockState blockState = world.getBlockState(blockPos);
            return RingLeafBlock.canGrowInto(world, blockPos, blockState);
        }
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        Optional<BlockPos> optional = BlockLocating.findColumnEnd(world, pos, state.getBlock(), Direction.UP, Blocks.BIG_DRIPLEAF);
        if (optional.isPresent()) {
            BlockPos blockPos = optional.get();
            BlockPos blockPos2 = blockPos.up();
            Direction direction = state.get(FACING);
            placeStemAt(world, blockPos, world.getFluidState(blockPos), direction);
            RingLeafBlock.placeDripleafAt(world, blockPos2, world.getFluidState(blockPos2), direction);
        }
    }

    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(CharlsensideasBlocks.RingLeaf);
    }

    static {
        WATERLOGGED = Properties.WATERLOGGED;
        NORTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        SOUTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        EAST_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        WEST_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}