package charlsen.charlsens.ideas.World;

import charlsen.charlsens.ideas.CharlsensideasBiomes;
import charlsen.charlsens.ideas.CharlsensideasBlocks;
import charlsen.charlsens.ideas.Configs.CloudBlockConfig;
import charlsen.charlsens.ideas.World.Features.CloudFeature;
import charlsen.charlsens.ideas.World.Features.Features;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.Optional;

public class CharlsensideasConfiguredFeatures {

    private static final ConfiguredFeature<?, ?> BORNITE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, CharlsensideasBlocks.Bornite_Ore.getDefaultState(), 4)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(20)))).spreadHorizontally().repeat(7));
    private static final ConfiguredFeature<?, ?> DEEPSTONE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, CharlsensideasBlocks.Black_Tourmaline_Stone.getDefaultState(), 60)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(25)))).repeat(60));
    public static final ConfiguredFeature<?, ?> PINE_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.PineLog.getDefaultState()), new StraightTrunkPlacer(4, 2, 2), new SimpleBlockStateProvider(CharlsensideasBlocks.PineLeaves.getDefaultState()), new SimpleBlockStateProvider(CharlsensideasBlocks.PineSapling.getDefaultState()), new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(4), 5), new TwoLayersFeatureSize(1, 4, 6))).build());
    public static final ConfiguredFeature<?, ?> PINE_FLORES = Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(PINE_TREE.withChance(0.0F), PINE_TREE.withChance(0.2F), PINE_TREE.withChance(0)), PINE_TREE)).decorate(Decorator.DARK_OAK_TREE.configure(DecoratorConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> TALL_PINE_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.PineLog.getDefaultState()), new StraightTrunkPlacer(4, 2, 15), new SimpleBlockStateProvider(CharlsensideasBlocks.PineLeaves.getDefaultState()), new SimpleBlockStateProvider(CharlsensideasBlocks.PineSapling.getDefaultState()),new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(4), 5), new TwoLayersFeatureSize(1, 1, 1))).ignoreVines().build());
    public static final ConfiguredFeature<?, ?> TALL_PINE_FLORES = Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(TALL_PINE_TREE.withChance(0.6F), TALL_PINE_TREE.withChance(0.3F), PINE_TREE.withChance(0.2F)), TALL_PINE_TREE)).decorate(Decorator.DARK_OAK_TREE.configure(DecoratorConfig.DEFAULT));
    public static final ConfiguredFeature<?, ?> WEIRDLY_DEEPSTONE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, CharlsensideasBlocks.Weirdly_Black_Tourmaline_Stone.getDefaultState(), 4)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(15)))).spreadHorizontally().repeat(7));
    public static final ConfiguredFeature<?, ?> POMPON_PATCH_FEATURE = Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.Pompon.getDefaultState()), SimpleBlockPlacer.INSTANCE)).tries(7).build());
    public static final ConfiguredFeature<?, ?> ALPINE_BUSH_PATCH = Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.Alpine_Strawberry_Bush.getDefaultState()), SimpleBlockPlacer.INSTANCE)).tries(64).build()).decorate(ConfiguredFeatures.Decorators.TOP_SOLID_HEIGHTMAP).spreadHorizontally();
    public static final ConfiguredFeature<?, ?> UMBRA_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.Umbra_Log.getDefaultState()), new BendingTrunkPlacer(4,5, 2, 4, ConstantIntProvider.create(2)), new SimpleBlockStateProvider(CharlsensideasBlocks.Umbra_Leaves.getDefaultState()), new SimpleBlockStateProvider(CharlsensideasBlocks.Umbra_Sapling.getDefaultState()), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(3), ConstantIntProvider.create(4), 80), new TwoLayersFeatureSize(3, 4, 5))).build()).decorate(ConfiguredFeatures.Decorators.TOP_SOLID_HEIGHTMAP).spreadHorizontally().repeatRandomly(30);
    public static final ConfiguredFeature<?, ?> UMBRA_TREESAP = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.Umbra_Log.getDefaultState()), new BendingTrunkPlacer(4,5, 2, 4, ConstantIntProvider.create(2)), new SimpleBlockStateProvider(CharlsensideasBlocks.Umbra_Leaves.getDefaultState()), new SimpleBlockStateProvider(CharlsensideasBlocks.Umbra_Sapling.getDefaultState()), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(3), ConstantIntProvider.create(4), 80), new TwoLayersFeatureSize(3, 4, 5))).build());
    public static final ConfiguredFeature<?, ?> Cloud = Features.CLOUD.configure((new CloudBlockConfig(CharlsensideasBlocks.CloudBlock.getDefaultState(), Optional.empty(), false, 1, 22))).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(250))))).applyChance(1);

    public static void configuredFeaturesInit(){

        RegistryKey<ConfiguredFeature<?,?>> borniteOreOverwolrd = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","bornite_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, borniteOreOverwolrd.getValue(), BORNITE_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, borniteOreOverwolrd);

        RegistryKey<ConfiguredFeature<?,?>> deepStoneOreOverwolrd = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","deepstone"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, deepStoneOreOverwolrd.getValue(), DEEPSTONE_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, deepStoneOreOverwolrd);

        RegistryKey<ConfiguredFeature<?, ?>> pineTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","pine_tree"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, pineTreeOverworld.getValue(), PINE_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.PINE_FOREST_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, pineTreeOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> pineFloresTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","pine_tree_flores"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, pineFloresTreeOverworld.getValue(), PINE_FLORES);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.PINE_FOREST_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, pineFloresTreeOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> tallPineTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","tall_pine_tree"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tallPineTreeOverworld.getValue(), TALL_PINE_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.TALL_PINE_FOREST_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, tallPineTreeOverworld);

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("charlsensideas", "tall_pine_forest_surface_builder"), CharlsensideasBiomes.TALL_PINE_FOREST_SURFACE_BUILDER);
        RegistryKey<ConfiguredFeature<?, ?>> tallPineFloresTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","tall_pine_tree_flores"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tallPineFloresTreeOverworld.getValue(), TALL_PINE_FLORES);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.TALL_PINE_FOREST_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, tallPineFloresTreeOverworld);

        RegistryKey<ConfiguredFeature<?,?>> weirdlyDeepStoneOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","weirdly_deep_stone"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, weirdlyDeepStoneOreOverworld.getValue(), WEIRDLY_DEEPSTONE_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, weirdlyDeepStoneOreOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> pomponPatchGen = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","pompon"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, pomponPatchGen.getValue(), POMPON_PATCH_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.VEGETAL_DECORATION, pomponPatchGen);

        RegistryKey<ConfiguredFeature<?, ?>> alpine_bush_gen = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","alpine_bush"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, alpine_bush_gen.getValue(), ALPINE_BUSH_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.UMBRA_FOREST_KEY), GenerationStep.Feature.VEGETAL_DECORATION, alpine_bush_gen);
        
        RegistryKey<ConfiguredFeature<?, ?>> umbraTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","umbra_tree"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, umbraTreeOverworld.getValue(), UMBRA_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.UMBRA_FOREST_KEY), GenerationStep.Feature.VEGETAL_DECORATION, umbraTreeOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> umbraTreeSapOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","umbra_treesap"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, umbraTreeSapOverworld.getValue(), UMBRA_TREESAP);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.UMBRA_FOREST_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, umbraTreeSapOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> cloud = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","cloud"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, cloud.getValue(), Cloud);
        BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.RAW_GENERATION, cloud);

    }
}
