package io.github.thecharlsen.charlsensideas.Fluids;

import io.github.thecharlsen.charlsensideas.CharlsensideasBlocks;
import io.github.thecharlsen.charlsensideas.CharlsensideasFluids;
import io.github.thecharlsen.charlsensideas.CharlsensideasItems;
import io.github.thecharlsen.charlsensideas.CharlsensideasParticleTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Random;

public class OilFluid extends FlowableFluid {

        /**
        * @return whether the given fluid an instance of this fluid
        */

        @Override
        public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
}

        @Override
        public Fluid getFlowing() {
            return CharlsensideasFluids.Flowing_Oil;
        }

        @Override
        public Fluid getStill() {
            return CharlsensideasFluids.Still_Oil;
        }

        /**
         * @return whether the fluid infinite like water
         */
        @Override
        protected boolean isInfinite() {
            return false;
        }

        /**
         * Perform actions when fluid flows into a replaceable block. Water drops
         * the block's loot table. Lava plays the "block.lava.extinguish" sound.
         */
        @Override
        protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
            final BlockEntity blockEntity = state.hasBlockEntity()? world.getBlockEntity(pos) : null;
            Block.dropStacks(state, world, pos, blockEntity);
        }

        @Override
        public Item getBucketItem() {
            return CharlsensideasFluids.Bucket_Of_Oil;
        }

        /**
         * Lava returns true if its FluidState is above a certain height and the
         * Fluid is Water.
         *
         * @return whether the given Fluid can flow into this FluidState
         */
        @Override
        protected boolean canBeReplacedWith(FluidState fluidState, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction) {
            return false;
        }

        public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
            BlockPos blockPos = pos.up();
            if (world.getBlockState(blockPos).isAir() && !world.getBlockState(blockPos).isOpaqueFullCube(world, blockPos)) {
                if (random.nextInt(100) == 0) {
                    double d = (double)pos.getX() + random.nextDouble();
                    double e = (double)pos.getY() + 1.0D;
                    double f = (double)pos.getZ() + random.nextDouble();
                    world.addParticle(CharlsensideasParticleTypes.Oil_Pop, d, e, f, 0.0D, 0.0D, 0.0D);
                    world.playSound(d, e, f, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
                }

                if (random.nextInt(200) == 0) {
                    world.playSound((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
                }
            }

        }
        /**
         * Possibly related to the distance checks for flowing into nearby holes?
         * Water returns 4. Lava returns 2 in the Overworld and 4 in the Nether.
         */
        @Override
        protected int getFlowSpeed(WorldView worldView) {
            return 4;
        }

        /**
         * Water returns 1. Lava returns 2 in the Overworld and 1 in the Nether.
         */
        @Override
        protected int getLevelDecreasePerBlock(WorldView worldView) {
            return 1;
        }

        /**
         * Water returns 5. Lava returns 30 in the Overworld and 10 in the Nether.
         */
        @Override
        public int getTickRate(WorldView worldView) {
            return 5;
        }

        /**
         * Water and Lava both return 100.0F.
         */
        @Override
        protected float getBlastResistance() {
            return 100.0F;
        }

        @Override
        protected BlockState toBlockState(FluidState state) {
            return CharlsensideasBlocks.Oil.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }

        @Override
        public int getLevel(FluidState state) {
            return 0;
        }
}

