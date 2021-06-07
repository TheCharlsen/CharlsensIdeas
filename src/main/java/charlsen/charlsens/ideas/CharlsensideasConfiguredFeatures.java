package charlsen.charlsens.ideas;

import charlsen.charlsens.ideas.Features.StoneSpiralFeature;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class CharlsensideasConfiguredFeatures {

    private static final Feature<DefaultFeatureConfig> STONE_SPIRAL = new StoneSpiralFeature(DefaultFeatureConfig.CODEC);

    private static final ConfiguredFeature<?, ?> BORNITE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, CharlsensideasBlocks.Bornite_Ore.getDefaultState(), 4)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 20))).spreadHorizontally().repeat(7);
    private static final ConfiguredFeature<?, ?> DEEPSTONE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, CharlsensideasBlocks.DeepStone.getDefaultState(), 60)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 25))).repeat(60);
    public static final ConfiguredFeature<?, ?> STONE_SPIRAL_CONFIGURED = STONE_SPIRAL.configure(FeatureConfig.DEFAULT).decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(40)));
    public static final ConfiguredFeature<?, ?> PINE_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.PineLog.getDefaultState()), new SimpleBlockStateProvider(CharlsensideasBlocks.PineLeaves.getDefaultState()),new BlobFoliagePlacer(UniformIntDistribution.of(3), UniformIntDistribution.of(4), 5), new StraightTrunkPlacer(4, 2, 2), new TwoLayersFeatureSize(1, 4, 6))).build());
    public static final ConfiguredFeature<?, ?> PINE_FLORES = Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(PINE_TREE.withChance(0.0F), PINE_TREE.withChance(0.2F), PINE_TREE.withChance(0)), PINE_TREE)).decorate(Decorator.DARK_OAK_TREE.configure(DecoratorConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> TALL_PINE_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.PineLog.getDefaultState()), new SimpleBlockStateProvider(CharlsensideasBlocks.PineLeaves.getDefaultState()),new BlobFoliagePlacer(UniformIntDistribution.of(3), UniformIntDistribution.of(4), 5), new StraightTrunkPlacer(4, 2, 15), new TwoLayersFeatureSize(1, 1, 1))).build());
    public static final ConfiguredFeature<?, ?> TALL_PINE_FLORES = Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(TALL_PINE_TREE.withChance(0.6F), TALL_PINE_TREE.withChance(0.3F), PINE_TREE.withChance(0.2F)), TALL_PINE_TREE)).decorate(Decorator.DARK_OAK_TREE.configure(DecoratorConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> WEIRDLY_DEEPSTONE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, CharlsensideasBlocks.WeirdlyDeepStone.getDefaultState(), 4)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 15))).spreadHorizontally().repeat(7);
    public static final ConfiguredFeature<?, ?> POMPON_PATCH_FEATURE = Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider().addState(CharlsensideasBlocks.Pompon.getDefaultState(), 4), SimpleBlockPlacer.INSTANCE)).tries(7).build());

    public static void configuredFeaturesInit(){

        RegistryKey<ConfiguredFeature<?,?>> borniteOreOverwolrd = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas","bornite_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, borniteOreOverwolrd.getValue(), BORNITE_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, borniteOreOverwolrd);

        RegistryKey<ConfiguredFeature<?,?>> deepStoneOreOverwolrd = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas","deepstone"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, deepStoneOreOverwolrd.getValue(), DEEPSTONE_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, deepStoneOreOverwolrd);

        RegistryKey<ConfiguredFeature<?, ?>> stoneSpiral = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas", "stone_spiral"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, stoneSpiral.getValue(), STONE_SPIRAL_CONFIGURED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.PINE_FOREST_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, stoneSpiral);

        RegistryKey<ConfiguredFeature<?, ?>> pineTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas","pine_tree"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, pineTreeOverworld.getValue(), PINE_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.PINE_FOREST_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, pineTreeOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> pineFloresTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas","pine_tree_flores"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, pineFloresTreeOverworld.getValue(), PINE_FLORES);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.PINE_FOREST_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, pineFloresTreeOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> tallPineTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas","tall_pine_tree"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tallPineTreeOverworld.getValue(), TALL_PINE_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.TALL_PINE_FOREST_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, tallPineTreeOverworld);

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("charlsensideas", "tall_pine_forest_surface_builder"), CharlsensideasBiomes.TALL_PINE_FOREST_SURFACE_BUILDER);
        RegistryKey<ConfiguredFeature<?, ?>> tallPineFloresTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas","tall_pine_tree_flores"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tallPineFloresTreeOverworld.getValue(), TALL_PINE_FLORES);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.TALL_PINE_FOREST_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, tallPineFloresTreeOverworld);

        RegistryKey<ConfiguredFeature<?,?>> weirdlyDeepStoneOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas","weirdly_deep_stone"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, weirdlyDeepStoneOreOverworld.getValue(), WEIRDLY_DEEPSTONE_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, weirdlyDeepStoneOreOverworld);

        Registry.register(Registry.FEATURE, new Identifier("charlsensideas", "stone_spiral"), STONE_SPIRAL);

        RegistryKey<ConfiguredFeature<?, ?>> pomponPatchGen = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas","pompon"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, pomponPatchGen.getValue(), POMPON_PATCH_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.VEGETAL_DECORATION, pomponPatchGen);

    }
}
