package charlsen.charlsens.ideas.Generators;

import charlsen.charlsens.ideas.World.CharlsensideasConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class UmbraTreeGenerator extends SaplingGenerator {
    public UmbraTreeGenerator() {

    }

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bl) {
        return (ConfiguredFeature<TreeFeatureConfig, ?>) CharlsensideasConfiguredFeatures.UMBRA_TREESAP;
    }
}