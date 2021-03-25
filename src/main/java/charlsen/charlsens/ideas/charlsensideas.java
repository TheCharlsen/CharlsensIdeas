package charlsen.charlsens.ideas;

import charlsen.charlsens.ideas.FoodComponents.ChipFoodComponents;
import charlsen.charlsens.ideas.Generators.TestTreeGenerator;
import charlsen.charlsens.ideas.MusicPlayer.MusicPlayerGuiItem;
import charlsen.charlsens.ideas.Ores.BorniteOreBlock;
import charlsen.charlsens.ideas.features.StoneSpiralFeature;
import charlsen.charlsens.ideas.protectedacces.MusicDiscItems;
import charlsen.charlsens.ideas.protectedacces.SaplingBlocks;
import charlsen.charlsens.ideas.tools.BornitePickaxeItem;
import charlsen.charlsens.ideas.tools.BornitePickaxeMaterial;
import com.google.common.collect.ImmutableList;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.item.Item.Settings;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;



public class charlsensideas implements ModInitializer {

	public static final Identifier Dog = new Identifier("charlsensideas:dog");
	public static final Identifier Discord_Special_Call_Music = new Identifier("charlsensideas:discord_special_call_music");
	public static final Identifier Da_Coconut_nut = new Identifier("charlsensideas:da_coconut_nut");
	public static final Identifier Revenge = new Identifier("charlsensideas:revenge");

	public static SoundEvent Dog_Sound_Event = new SoundEvent(Dog);
	public static SoundEvent Discord_Special_Call_Music_Sound_Event = new SoundEvent(Discord_Special_Call_Music);
	public static final SoundEvent Da_Coconut_nut_Sound_Event = new SoundEvent(Da_Coconut_nut);
	public static SoundEvent Revenge_Sound_Event = new SoundEvent(Revenge);

	public static final Item Secure_Chest_Module = new Item(new Settings().group(Item_Group.ITEM_GROUP_SECCHESTS));
	public static final Item Bornite = new Item(new Settings().group(Item_Group.ITEM_GROUP_ORES));
    public static final Item CHIP = new Item(new Item.Settings().group(Item_Group.ITEM_GROUP_FOOD).food(ChipFoodComponents.CHIP));
	public static Item MUSICPLAYER = new MusicPlayerGuiItem(new Item.Settings().group(Item_Group.ITEM_GROUP_MUSIC).maxCount(1));
	public static final MusicDiscItem Dog_Music_Disc = new MusicDiscItems(14, charlsensideas.Dog_Sound_Event, new FabricItemSettings().group(Item_Group.ITEM_GROUP_MUSIC).maxCount(1).rarity(Rarity.RARE));
	public static final MusicDiscItem Discord_Remix_Music_Disc = new MusicDiscItems(15, Discord_Special_Call_Music_Sound_Event, new FabricItemSettings().group(Item_Group.ITEM_GROUP_MUSIC).maxCount(1).rarity(Rarity.RARE));
	public static final MusicDiscItem Revenge_Music_Disc = new MusicDiscItems(15, charlsensideas.Revenge_Sound_Event, new FabricItemSettings().group(Item_Group.ITEM_GROUP_MUSIC).maxCount(1).rarity(Rarity.RARE));
	public static final MusicDiscItem Da_Coconut_nut_Music_Disc = new MusicDiscItems(15, charlsensideas.Da_Coconut_nut_Sound_Event, new FabricItemSettings().group(Item_Group.ITEM_GROUP_MUSIC).maxCount(1).rarity(Rarity.EPIC));

	public static final Block MuddedDirt = new Block(FabricBlockSettings.of(Material.SOIL).strength(1F, 1F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block HardenedMuddedDirt = new Block(FabricBlockSettings.of(Material.STONE).strength(2F, 2F).sounds(BlockSoundGroup.STONE));
	public static final Block Bornite_Ore = new BorniteOreBlock(FabricBlockSettings.of(Material.STONE).strength(1F, 1F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
	public static final Block Adrian_Block = new Block(FabricBlockSettings.of(Material.CAKE).strength(5F, 5F).sounds(BlockSoundGroup.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
	public static final Block Charlie_Block = new Block(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(5F, 5F).sounds(BlockSoundGroup.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
	public static final Block Julian_Block = new Block(FabricBlockSettings.of(Material.PISTON).strength(5F, 5F).sounds(BlockSoundGroup.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
	public static final Block Emil_Block = new Block(FabricBlockSettings.of(Material.CACTUS).strength(5F, 5F).sounds(BlockSoundGroup.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
	public static final Block DeepStone = new Block(FabricBlockSettings.of(Material.STONE).strength(13F, 12F).sounds(BlockSoundGroup.STONE));
	public static final Block PineLeaves = new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).strength(1.0F, 1.0F).nonOpaque());
	public static final SaplingBlock TestSapling = new SaplingBlocks(new TestTreeGenerator(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block PineLog = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(1.5F, 1.5F).sounds(BlockSoundGroup.WOOD));

	public static final ToolItem Bornite_Pickaxe = new BornitePickaxeItem(BornitePickaxeMaterial.INSTANCEBOPICK, 3, 7.0F, new Item.Settings().group(Item_Group.ITEM_GROUP_TOOLS));

	private static final Feature<DefaultFeatureConfig> STONE_SPIRAL = new StoneSpiralFeature(DefaultFeatureConfig.CODEC);

	private static ConfiguredFeature<?, ?> BORNITE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Bornite_Ore.getDefaultState(), 4)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 20))).spreadHorizontally().repeat(7);
	private static final ConfiguredFeature<?, ?> DEEPSTONE_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, DeepStone.getDefaultState(), 60)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 25))).repeat(60);
	public static final ConfiguredFeature<?, ?> STONE_SPIRAL_CONFIGURED = STONE_SPIRAL.configure(FeatureConfig.DEFAULT).decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(40)));
	public static final ConfiguredFeature<?, ?> AZALEA_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(charlsensideas.PineLog.getDefaultState()), new SimpleBlockStateProvider(charlsensideas.PineLeaves.getDefaultState()),new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 2), new StraightTrunkPlacer(2, 2, 2), new TwoLayersFeatureSize(1, 3, 0))).build());
	public static final ConfiguredFeature<?, ?> AZALEA_FLORES = Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(AZALEA_TREE.withChance(0.0F), AZALEA_TREE.withChance(0.2F), AZALEA_TREE.withChance(0)), AZALEA_TREE)).decorate(Decorator.DARK_OAK_TREE.configure(DecoratorConfig.DEFAULT));

	private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> OBSIDIAN_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.LAPIS_BLOCK.getDefaultState()));

	private static final Biome OBSILAND = createObsiland();

	private static Biome createObsiland() {

		SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
		DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
		DefaultBiomeFeatures.addMonsters(spawnSettings, 95, 5, 100);

		GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
		generationSettings.surfaceBuilder(OBSIDIAN_SURFACE_BUILDER);
		DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
		DefaultBiomeFeatures.addLandCarvers(generationSettings);
		DefaultBiomeFeatures.addSweetBerryBushes(generationSettings);
		DefaultBiomeFeatures.addDefaultDisks(generationSettings);
		DefaultBiomeFeatures.addDefaultLakes(generationSettings);
		DefaultBiomeFeatures.addDungeons(generationSettings);
		DefaultBiomeFeatures.addMineables(generationSettings);
		DefaultBiomeFeatures.addDefaultDisks(generationSettings);
		DefaultBiomeFeatures.addSprings(generationSettings);
		DefaultBiomeFeatures.addDefaultFlowers(generationSettings);
		DefaultBiomeFeatures.addForestGrass(generationSettings);

		return (new Biome.Builder()).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.JUNGLE).depth(0.125F).scale(0.05F).temperature(1.1F).downfall(0.4F).effects((new BiomeEffects.Builder()).waterColor(0x2cd0f5).waterFogColor(0xb1e4f0).fogColor(0xbbd1f0).skyColor(0x52bdf2).build()).spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
	}

	public static final RegistryKey<Biome> OBSILAND_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("charlsensideas", "mixed_forest"));


	@Override
	public void onInitialize() {
		
		Registry.register(Registry.ITEM, new Identifier("charlsensideas", "secure_chest_module"), Secure_Chest_Module);

		Registry.register(Registry.ITEM, new Identifier("charlsensideas", "bornite"), Bornite);

		Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "bornite_ore"), Bornite_Ore);
		Registry.register(Registry.ITEM, new Identifier("charlsensideas", "bornite_ore"), new BlockItem(Bornite_Ore, new Settings().group(Item_Group.ITEM_GROUP_ORES)));

	    Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "adrian_block"), Adrian_Block);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "adrian_block"), new BlockItem(Adrian_Block, new Settings().group(Item_Group.ITEM_GROUP_MEME)));

		Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "charlie_block"), Charlie_Block);
	    Registry.register(Registry.ITEM, new Identifier("charlsensideas", "charlie_block"), new BlockItem(Charlie_Block, new Settings().group(Item_Group.ITEM_GROUP_MEME)));
	
		Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "julian_block"), Julian_Block);
	    Registry.register(Registry.ITEM, new Identifier("charlsensideas", "julian_block"), new BlockItem(Julian_Block, new Settings().group(Item_Group.ITEM_GROUP_MEME)));
	    
		Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "emil_block"), Emil_Block);
		Registry.register(Registry.ITEM, new Identifier("charlsensideas", "emil_block"), new BlockItem(Emil_Block, new Settings().group(Item_Group.ITEM_GROUP_MEME)));

        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "chip"), CHIP);

        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "musicplayer"), MUSICPLAYER);

		RegistryKey<ConfiguredFeature<?,?>> borniteOreOverwolrd = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas","bornite_ore"));
	    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, borniteOreOverwolrd.getValue(), BORNITE_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, borniteOreOverwolrd);

		Registry.register(Registry.SOUND_EVENT, charlsensideas.Dog, Dog_Sound_Event);
		Registry.register(Registry.SOUND_EVENT, charlsensideas.Discord_Special_Call_Music, Discord_Special_Call_Music_Sound_Event);

		Registry.register(Registry.ITEM, new Identifier("charlsensideas","dog_music_disc"), Dog_Music_Disc);

        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "discord_remix_music_disc"), Discord_Remix_Music_Disc);

        Registry.register(Registry.SOUND_EVENT, charlsensideas.Revenge, Revenge_Sound_Event);

        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "revenge_music_disc"), Revenge_Music_Disc);

        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "mudded_dirt"), MuddedDirt);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "mudded_dirt"), new BlockItem(MuddedDirt, new Settings().group(Item_Group.ITEM_GROUP_NATURE)));

		Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "hardened_mudded_dirt"), HardenedMuddedDirt);
		Registry.register(Registry.ITEM, new Identifier("charlsensideas", "hardened_mudded_dirt"), new BlockItem(HardenedMuddedDirt, new Settings().group(Item_Group.ITEM_GROUP_NATURE)));

		Registry.register(Registry.SOUND_EVENT, charlsensideas.Da_Coconut_nut, Da_Coconut_nut_Sound_Event);
		Registry.register(Registry.ITEM, new Identifier("charlsensideas", "da_coconut_nut_music_disc"), Da_Coconut_nut_Music_Disc);

        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "deepstone"), DeepStone);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "deepstone"), new BlockItem(DeepStone, new Settings().group(Item_Group.ITEM_GROUP_NATURE)));

		RegistryKey<ConfiguredFeature<?,?>> deepStoneOreOverwolrd = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas","deepstone"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, deepStoneOreOverwolrd.getValue(), DEEPSTONE_ORE_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, deepStoneOreOverwolrd);

		Registry.register(Registry.ITEM, new Identifier("charlsensideas", "bornite_pickaxe"), Bornite_Pickaxe);

		Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("charlsensideas", "mxfo_surface_builder"), OBSIDIAN_SURFACE_BUILDER);
		Registry.register(BuiltinRegistries.BIOME, OBSILAND_KEY.getValue(), OBSILAND);
		OverworldBiomes.addContinentalBiome(OBSILAND_KEY, OverworldClimate.TEMPERATE, 2D);
		OverworldBiomes.addContinentalBiome(OBSILAND_KEY, OverworldClimate.COOL, 2D);

		Registry.register(Registry.FEATURE, new Identifier("charlsensideas", "stone_spiral"), STONE_SPIRAL);

		RegistryKey<ConfiguredFeature<?, ?>> stoneSpiral = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas", "stone_spiral"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, stoneSpiral.getValue(), STONE_SPIRAL_CONFIGURED);

		BiomeModifications.addFeature(BiomeSelectors.includeByKey(charlsensideas.OBSILAND_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, stoneSpiral);
		CustomPortalApiRegistry.addPortal(charlsensideas.Adrian_Block, PortalIgnitionSource.FluidSource(Fluids.LAVA), new Identifier("charlsensideas", "void"), 51, 52, 49);
		CustomPortalApiRegistry.addPortal(Blocks.DIAMOND_BLOCK, PortalIgnitionSource.FluidSource(Fluids.WATER), new Identifier("charlsensideas", "testdim"), 0, 255, 255);

		RegistryKey<ConfiguredFeature<?, ?>> azaleaTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas","azalea_tree"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, azaleaTreeOverworld.getValue(), AZALEA_TREE);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(charlsensideas.OBSILAND_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, azaleaTreeOverworld);


		RegistryKey<ConfiguredFeature<?, ?>> azaleaFloweresTreeOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("charlsensideas","azalea_tree_flo"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, azaleaFloweresTreeOverworld.getValue(), AZALEA_FLORES);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(charlsensideas.OBSILAND_KEY), GenerationStep.Feature.SURFACE_STRUCTURES, azaleaFloweresTreeOverworld);

		Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "test_sapling"), TestSapling);
		Registry.register(Registry.ITEM, new Identifier("charlsensideas", "test_sapling"), new BlockItem(TestSapling, new Settings().group(Item_Group.ITEM_GROUP_NATURE)));

		Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "pine_leaves"), PineLeaves);
		Registry.register(Registry.ITEM, new Identifier("charlsensideas", "pine_leaves"), new BlockItem(PineLeaves, new Settings().group(Item_Group.ITEM_GROUP_NATURE)));

	    Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "pine_log"), PineLog);
	    Registry.register(Registry.ITEM, new Identifier("charlsensideas", "pine_log"), new BlockItem(PineLog, new Settings().group(Item_Group.ITEM_GROUP_NATURE)));
	}

}