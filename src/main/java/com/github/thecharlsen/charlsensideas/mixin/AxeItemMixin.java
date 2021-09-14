package com.github.thecharlsen.charlsensideas.mixin;

import com.github.thecharlsen.charlsensideas.CharlsensideasBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashMap;
import java.util.Map;

@Mixin(AxeItem.class)
public abstract class AxeItemMixin {

    @Shadow
    @Final
    @Mutable
    protected static Map<Block, Block> STRIPPED_BLOCKS;

    static {
        STRIPPED_BLOCKS = new HashMap<>(STRIPPED_BLOCKS);
        STRIPPED_BLOCKS.put(CharlsensideasBlocks.Umbra_Log, CharlsensideasBlocks.Stripped_Umbra_Log);

    }

}
