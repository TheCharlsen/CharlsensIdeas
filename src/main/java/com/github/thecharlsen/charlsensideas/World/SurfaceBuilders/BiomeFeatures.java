package com.github.thecharlsen.charlsensideas.World.SurfaceBuilders;

import com.github.thecharlsen.charlsensideas.World.CharlsensideasConfiguredFeatures;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;

public class BiomeFeatures {
    public BiomeFeatures() {
    }

    public static void addUmbraTrees(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CharlsensideasConfiguredFeatures.UMBRA_TREE);
    }

    public static void addAlpineBushes(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, CharlsensideasConfiguredFeatures.ALPINE_BUSH_PATCH);

    }
    public static void addGlowLichens(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.GLOW_LICHEN);
    }
    public static void addPrototypeGlowLichens(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.PROTOTYPE_GLOW_LICHEN);
    }
}
