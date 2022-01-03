package io.github.thecharlsen.charlsensideas.Blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Random;

public class PowerCoreBlock extends Block {
    public PowerCoreBlock(Settings settings) {
        super(settings);
    }

    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            Direction direction = Direction.random(random);
            if (direction != Direction.UP) {
                BlockPos blockPos = pos.offset(direction);
                BlockState blockState = world.getBlockState(blockPos);
                if (!state.isOpaque() || !blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite())) {
                    double d = direction.getOffsetX() == 0 ? random.nextDouble() : 0.5D + (double)direction.getOffsetX() * 0.6D;
                    double e = direction.getOffsetY() == 0 ? random.nextDouble() : 0.5D + (double)direction.getOffsetY() * 0.6D;
                    double f = direction.getOffsetZ() == 0 ? random.nextDouble() : 0.5D + (double)direction.getOffsetZ() * 0.6D;
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 1.0D, 1.0D, 2.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 2.0D, 1.0D, 1.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 3.0D, 2.0D, 3.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 1.0D, 1.0D, 1.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 2.0D, 3.0D, 2.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 3.0D, 1.0D, 1.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 1.0D, 1.0D, 3.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 2.0D, 2.0D, 1.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 3.0D, 1.0D, 2.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 1.0D, 1.0D, 1.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 2.0D, 3.0D, 3.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 3.0D, 1.0D, 1.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 1.0D, 1.0D, 2.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 2.0D, 2.0D, 1.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 3.0D, 1.0D, 3.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 1.0D, 1.0D, 1.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 2.0D, 3.0D, 2.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 3.0D, 1.0D, 1.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 1.0D, 1.0D, 3.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 2.0D, 2.0D, 1.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 3.0D, 1.0D, 2.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 1.0D, 1.0D, 1.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 2.0D, 3.0D, 3.0D);
                    world.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d, (double)pos.getY() + e, (double)pos.getZ() + f, 3.0D, 1.0D, 1.0D);

                }
            }
        }
    }
}