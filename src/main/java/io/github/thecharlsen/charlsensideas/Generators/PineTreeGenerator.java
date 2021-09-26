package io.github.thecharlsen.charlsensideas.Generators;


import io.github.thecharlsen.charlsensideas.World.CharlsensideasConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class PineTreeGenerator extends SaplingGenerator {
public PineTreeGenerator() {

}

    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bl) {
        return (ConfiguredFeature<TreeFeatureConfig, ?>) CharlsensideasConfiguredFeatures.PINE_TREE;
    }
}
