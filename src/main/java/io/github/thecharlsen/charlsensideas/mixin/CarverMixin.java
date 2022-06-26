package io.github.thecharlsen.charlsensideas.mixin;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import io.github.thecharlsen.charlsensideas.CharlsensideasBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.carver.CarverConfig;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(Carver.class)
public abstract class CarverMixin<C extends CarverConfig> {

    @Shadow protected Set<Block> alwaysCarvableBlocks;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void addCustomCarvableBlocks(CallbackInfo ci) {
        alwaysCarvableBlocks =
                ImmutableSet.<Block>builder()
                        .addAll(alwaysCarvableBlocks)
                        .add(CharlsensideasBlocks.Cobbled_Black_Tourmaline_Stone)
                        .build();
    }
}
