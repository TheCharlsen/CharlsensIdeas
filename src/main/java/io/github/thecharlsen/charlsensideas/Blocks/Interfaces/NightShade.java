package io.github.thecharlsen.charlsensideas.Blocks.Interfaces;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

import java.util.function.ToIntFunction;

public interface NightShade {
    IntProperty AGE = Properties.AGE_1;;

    static ToIntFunction<BlockState> getLuminanceSupplier(int luminance) {
        return (state) -> state.get(AGE) == 1 ? luminance : 0;
    }
}