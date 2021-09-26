package io.github.thecharlsen.charlsensideas.World;


import io.github.thecharlsen.charlsensideas.Charlsensideas;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class CharlsensideasStructureFeature {

        public static ConfiguredStructureFeature<?, ?> CONFIGURED_DIAMOND_CASCADE = CharlsensideasStructures.DIAMOND_CASCADE.configure(DefaultFeatureConfig.DEFAULT);
        public static ConfiguredStructureFeature<?, ?> CONFIGURED_ILFTY_HOUSE = CharlsensideasStructures.ILFTY_HOUSE.configure(DefaultFeatureConfig.DEFAULT);

    public static void registerConfiguredStructures() {

        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new Identifier(Charlsensideas.MODID, "configured_diamond_cascade"), CONFIGURED_DIAMOND_CASCADE);
        Registry.register(registry, new Identifier(Charlsensideas.MODID, "configured_ilfty_house"), CONFIGURED_ILFTY_HOUSE);

    }
}
