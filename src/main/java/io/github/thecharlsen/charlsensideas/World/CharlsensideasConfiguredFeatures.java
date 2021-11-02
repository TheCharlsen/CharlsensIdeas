package io.github.thecharlsen.charlsensideas.World;

import com.google.common.collect.ImmutableList;
import io.github.thecharlsen.charlsensideas.Charlsensideas;
import io.github.thecharlsen.charlsensideas.CharlsensideasBiomes;
import io.github.thecharlsen.charlsensideas.CharlsensideasBlocks;
import io.github.thecharlsen.charlsensideas.Configs.CloudBlockConfig;
import io.github.thecharlsen.charlsensideas.World.Features.Features;
import io.github.thecharlsen.charlsensideas.World.SurfaceBuilders.BiomeFeatures;
import io.github.thecharlsen.charlsensideas.World.TreeDecorators.TrunkSporeTreeDecorator;
import io.github.thecharlsen.charlsensideas.World.TrunkPlacer.RankTrunkPlacer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.placer.DoublePlantPlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.treedecorator.CocoaBeansTreeDecorator;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.Optional;
import java.util.OptionalInt;

public class CharlsensideasConfiguredFeatures extends ConfiguredFeatures{

    private static final ConfiguredFeature<?, ?> BORNITE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, CharlsensideasBlocks.Bornite_Ore.getDefaultState(), 4)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(20)))).spreadHorizontally().repeat(7));
    private static final ConfiguredFeature<?, ?> DEEPSTONE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, CharlsensideasBlocks.Black_Tourmaline_Stone.getDefaultState(), 60)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(25)))).repeat(60));
    public static final ConfiguredFeature<?, ?> PINE_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.PineLog.getDefaultState()), new StraightTrunkPlacer(4, 2, 2), new SimpleBlockStateProvider(CharlsensideasBlocks.PineLeaves.getDefaultState()), new SimpleBlockStateProvider(CharlsensideasBlocks.PineSapling.getDefaultState()), new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(4), 5), new TwoLayersFeatureSize(1, 4, 6))).build()).decorate(ConfiguredFeatures.Decorators.TOP_SOLID_HEIGHTMAP).spreadHorizontally().repeatRandomly(30);
    public static final ConfiguredFeature<?, ?> TALL_PINE_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.PineLog.getDefaultState()), new StraightTrunkPlacer(4, 2, 15), new SimpleBlockStateProvider(CharlsensideasBlocks.PineLeaves.getDefaultState()), new SimpleBlockStateProvider(CharlsensideasBlocks.PineSapling.getDefaultState()),new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(4), 5), new TwoLayersFeatureSize(1, 1, 1))).decorators(ImmutableList.of(new TrunkSporeTreeDecorator(0.02F))).ignoreVines().build()).decorate(ConfiguredFeatures.Decorators.TOP_SOLID_HEIGHTMAP).spreadHorizontally().repeatRandomly(30);;
    public static final ConfiguredFeature<?, ?> WEIRDLY_DEEPSTONE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, CharlsensideasBlocks.Weirdly_Black_Tourmaline_Stone.getDefaultState(), 4)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(15)))).spreadHorizontally().repeat(7));
    public static final ConfiguredFeature<?, ?> POMPON_PATCH_FEATURE = Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.Pompon.getDefaultState()), SimpleBlockPlacer.INSTANCE)).tries(7).build());
    public static final ConfiguredFeature<?, ?> ALPINE_BUSH_PATCH = Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.Alpine_Strawberry_Bush.getDefaultState()), SimpleBlockPlacer.INSTANCE)).tries(64).build()).decorate(ConfiguredFeatures.Decorators.TOP_SOLID_HEIGHTMAP).spreadHorizontally();
    public static final ConfiguredFeature<?, ?> UMBRA_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.Umbra_Log.getDefaultState()), new BendingTrunkPlacer(4,5, 2, 4, ConstantIntProvider.create(2)), new SimpleBlockStateProvider(CharlsensideasBlocks.Umbra_Leaves.getDefaultState()), new SimpleBlockStateProvider(CharlsensideasBlocks.Umbra_Sapling.getDefaultState()), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(3), ConstantIntProvider.create(4), 80), new TwoLayersFeatureSize(3, 4, 5))).build()).decorate(ConfiguredFeatures.Decorators.TOP_SOLID_HEIGHTMAP).spreadHorizontally().repeatRandomly(30);
    public static final ConfiguredFeature<?, ?> UMBRA_TREESAP = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(CharlsensideasBlocks.Umbra_Log.getDefaultState()), new BendingTrunkPlacer(4,5, 2, 4, ConstantIntProvider.create(2)), new SimpleBlockStateProvider(CharlsensideasBlocks.Umbra_Leaves.getDefaultState()), new SimpleBlockStateProvider(CharlsensideasBlocks.Umbra_Sapling.getDefaultState()), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(3), ConstantIntProvider.create(4), 80), new TwoLayersFeatureSize(3, 4, 5))).build());
    public static final ConfiguredFeature<?, ?> Cloud = Features.CLOUD.configure((new CloudBlockConfig(CharlsensideasBlocks.CloudBlock.getDefaultState(), Optional.empty(), false, 1, 22))).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(250))))).applyChance(1);
    public static ConfiguredFeature<?, ?> Tree;

    public static void configuredFeaturesInit(){

        Tree = register("tree10", Feature.RANDOM_SELECTOR.configure(Configs.SHIELD_TREES_CONFIG).decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(6)))).spreadHorizontally().repeatRandomly(5);

        RegistryKey<ConfiguredFeature<?,?>> borniteOreOverwolrd = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","bornite_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, borniteOreOverwolrd.getValue(), BORNITE_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, borniteOreOverwolrd);

        RegistryKey<ConfiguredFeature<?,?>> deepStoneOreOverwolrd = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","deepstone"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, deepStoneOreOverwolrd.getValue(), DEEPSTONE_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, deepStoneOreOverwolrd);

        RegistryKey<ConfiguredFeature<?, ?>> pineTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","pine_tree"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, pineTreeOverworld.getValue(), PINE_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.PINE_FOREST_KEY), GenerationStep.Feature.VEGETAL_DECORATION, pineTreeOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> tallPineTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("charlsensideas","tall_pine_tree"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tallPineTreeOverworld.getValue(), TALL_PINE_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.TALL_PINE_FOREST_KEY), GenerationStep.Feature.VEGETAL_DECORATION, tallPineTreeOverworld);
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("charlsensideas", "tall_pine_forest_surface_builder"), CharlsensideasBiomes.TALL_PINE_FOREST_SURFACE_BUILDER);

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
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CharlsensideasBiomes.UMBRA_FOREST_KEY), GenerationStep.Feature.RAW_GENERATION, cloud);

    }

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Charlsensideas.locate(id), configuredFeature);
    }

    public static class Configs {

        public static final TreeFeatureConfig MOTTLED_SKYROOT_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new RankTrunkPlacer(5, 10, 0, new SimpleBlockStateProvider(CharlsensideasBlocks.Spore.getDefaultState()), 1 / 14F), new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()), new SimpleBlockStateProvider(Blocks.BIRCH_SAPLING.getDefaultState()), new BlobFoliagePlacer(UniformIntProvider.create(2, 3), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
        public static final TreeFeatureConfig DWARF_MOTTLED_SKYROOT_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new BendingTrunkPlacer(5, 3, 2, 4, UniformIntProvider.create(1, 3)), new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()), new SimpleBlockStateProvider(Blocks.BIRCH_SAPLING.getDefaultState()), new RandomSpreadFoliagePlacer(UniformIntProvider.create(3, 4), ConstantIntProvider.create(0), ConstantIntProvider.create(3), 68), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();

        public static final RandomFeatureConfig SHIELD_TREES_CONFIG = new RandomFeatureConfig(
                ImmutableList.of(Feature.TREE.configure(DWARF_MOTTLED_SKYROOT_CONFIG).withChance(0.15F)),
                Feature.TREE.configure(Configs.MOTTLED_SKYROOT_CONFIG)
        );
    }
}
