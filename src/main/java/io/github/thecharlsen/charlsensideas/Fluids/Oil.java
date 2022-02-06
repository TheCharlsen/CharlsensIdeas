package io.github.thecharlsen.charlsensideas.Fluids;

import io.github.thecharlsen.charlsensideas.CharlsensideasBlocks;
import io.github.thecharlsen.charlsensideas.CharlsensideasFluids;
import io.github.thecharlsen.charlsensideas.CharlsensideasItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public class Oil extends OilFluid {
    @Override
    public Fluid getStill() {
        return CharlsensideasFluids.Still_Oil;
    }

    @Override
    public Fluid getFlowing() {
        return CharlsensideasFluids.Flowing_Oil;
    }

    @Override
    public Item getBucketItem() {
        return CharlsensideasFluids.Bucket_Of_Oil;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        // method_15741 converts the LEVEL_1_8 of the fluid state to the LEVEL_15 the fluid block uses
        return CharlsensideasBlocks.Oil.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    public static class Flowing extends Oil {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends Oil {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}