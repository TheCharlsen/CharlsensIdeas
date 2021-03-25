package charlsen.charlsens.ideas.Generators;

import charlsen.charlsens.ideas.charlsensideas;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class TestTreeGenerator extends SaplingGenerator {
public TestTreeGenerator() {

}

    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return (ConfiguredFeature<TreeFeatureConfig, ?>) charlsensideas.AZALEA_TREE;
    }
}
