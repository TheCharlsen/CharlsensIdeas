package charlsen.charlsens.ideas;

import charlsen.charlsens.ideas.Generators.MyTestPiece;
import charlsen.charlsens.ideas.Features.TestFeature;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class CharlsensideasStructures {

    public static final StructurePieceType MY_TEST_PIECE = MyTestPiece::new;

    private static final StructureFeature<DefaultFeatureConfig> MY_STRUCTURE = new TestFeature(DefaultFeatureConfig.CODEC);

    private static final ConfiguredStructureFeature<?, ?> MY_CONFIGURED = MY_STRUCTURE.configure(DefaultFeatureConfig.DEFAULT);

    public static void structuresInit(){

        Registry.register(Registry.STRUCTURE_PIECE, new Identifier("charlsensideas", "my_piece"), MY_TEST_PIECE);

        FabricStructureBuilder.create(new Identifier("charlsensideas", "my_structure"), MY_STRUCTURE).step(GenerationStep.Feature.SURFACE_STRUCTURES).defaultConfig(32, 8, 12345).adjustsSurface().register();

        RegistryKey<ConfiguredStructureFeature<?, ?>> myConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN, new Identifier("charlsensideas", "my_structure"));

        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, myConfigured.getValue(), MY_CONFIGURED);

        BiomeModifications.addStructure(BiomeSelectors.all(), myConfigured);

    }
}
