package com.github.thecharlsen.charlsensideas.Blocks;

import com.github.thecharlsen.charlsensideas.CharlsensideasBlockProperties;
import com.github.thecharlsen.charlsensideas.CharlsensideasBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CloudBlock extends TransparentBlock {
    private static final BooleanProperty DOUBLE_DROPS = CharlsensideasBlockProperties.DOUBLE_DROPS;
    protected static VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 0.01, 16.0);

    public CloudBlock(Settings properties) {
        super(properties.solidBlock(CharlsensideasBlocks::never).suffocates(CharlsensideasBlocks::never).blockVision(CharlsensideasBlocks::never));
        this.setDefaultState(this.getDefaultState().with(DOUBLE_DROPS, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(DOUBLE_DROPS);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.fallDistance = 0.0F;

        if (entity.getVelocity().y < 0.0) {
            entity.setVelocity(entity.getVelocity().multiply(1.0, 0.005, 1.0));
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView worldIn, BlockPos pos) {
        return 1.0F;
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView reader, BlockPos pos) {
        return true;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCameraCollisionShape(BlockState state, BlockView reader, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }
}