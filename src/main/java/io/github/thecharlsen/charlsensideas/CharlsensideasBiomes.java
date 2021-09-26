package io.github.thecharlsen.charlsensideas;

import io.github.thecharlsen.charlsensideas.World.SurfaceBuilders.BiomeFeatures;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class CharlsensideasBiomes {

    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> PINE_FOREST_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.STONE.getDefaultState()));
    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> TALL_PINE_FOREST_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), CharlsensideasBlocks.MuddedDirt.getDefaultState()));
    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> UMBRA_FOREST_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(CharlsensideasBlocks.Weird_Grass_Block.getDefaultState(), Blocks.DIRT.getDefaultState(), CharlsensideasBlocks.Weird_Dirt.getDefaultState()));

    private static final Biome PINE_FOREST = createPineForest();
    private static final Biome TALL_PINE_FOREST = createTallPineForest();
    private static final Biome UMBRA_FOREST = createUmbraForest();

    private static Biome createPineForest() {

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addMonsters(spawnSettings, 95, 5, 100);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(PINE_FOREST_SURFACE_BUILDER);
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
        DefaultBiomeFeatures.addInfestedStone(generationSettings);


        return (new Biome.Builder()).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.TAIGA).depth(0.035F).scale(0.05F).temperature(1.1F).downfall(0.4F).effects((new BiomeEffects.Builder()).waterColor(0x2cd0f5).waterFogColor(0xb1e4f0).fogColor(0xbbd1f0).skyColor(0x52bdf2).build()).spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    private static Biome createTallPineForest() {

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addMonsters(spawnSettings, 95, 5, 100);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(TALL_PINE_FOREST_SURFACE_BUILDER);
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
        DefaultBiomeFeatures.addInfestedStone(generationSettings);
        DefaultBiomeFeatures.addLargeFerns(generationSettings);
        DefaultBiomeFeatures.addMossyRocks(generationSettings);

        return (new Biome.Builder()).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.TAIGA).depth(0.005F).scale(0.03F).temperature(1.1F).downfall(0.4F).effects((new BiomeEffects.Builder()).waterColor(0x2cd0f5).waterFogColor(0xb1e4f0).fogColor(0xbbd1f0).skyColor(0x52bdf2).build()).spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    private static Biome createUmbraForest() {

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addMonsters(spawnSettings, 95, 5, 100);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(UMBRA_FOREST_SURFACE_BUILDER);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addSweetBerryBushes(generationSettings);
        DefaultBiomeFeatures.addDefaultLakes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultFlowers(generationSettings);
        DefaultBiomeFeatures.addForestGrass(generationSettings);
        BiomeFeatures.addUmbraTrees(generationSettings);
        BiomeFeatures.addAlpineBushes(generationSettings);
        BiomeFeatures.addGlowLichens(generationSettings);
        BiomeFeatures.addPrototypeGlowLichens(generationSettings);


        return (new Biome.Builder()).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.NONE).depth(0.035F).scale(0.05F).temperature(1.1F).downfall(0.4F).effects((new BiomeEffects.Builder()).waterColor(0x2cd0f5).waterFogColor(0xb1e4f0).fogColor(0xbbd1f0).skyColor(0x52bdf2).grassColor(0xCBC3E3).foliageColor(0xCBC3E3).build()).spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static final RegistryKey<Biome> PINE_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("charlsensideas", "pine_forest"));
    public static final RegistryKey<Biome> TALL_PINE_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("charlsensideas", "tall_pine_forest"));
    public static final RegistryKey<Biome> UMBRA_FOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("charlsensideas", "umbra_forest"));
    public static final RegistryKey<Biome> ILFTY_HILLS_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("charlsensideas", "ilfty_hills"));

    public static void biomesInit(){

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("charlsensideas", "pine_forest_surface_builder"), PINE_FOREST_SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, PINE_FOREST_KEY.getValue(), PINE_FOREST);
        OverworldBiomes.addContinentalBiome(PINE_FOREST_KEY, OverworldClimate.TEMPERATE, 2D);
        OverworldBiomes.addContinentalBiome(PINE_FOREST_KEY, OverworldClimate.COOL, 2D);

        Registry.register(BuiltinRegistries.BIOME, TALL_PINE_FOREST_KEY.getValue(), TALL_PINE_FOREST);
        OverworldBiomes.addContinentalBiome(TALL_PINE_FOREST_KEY, OverworldClimate.TEMPERATE, 2D);
        OverworldBiomes.addContinentalBiome(TALL_PINE_FOREST_KEY, OverworldClimate.COOL, 2D);

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("charlsensideas", "umbra_forest_surface_builder"), UMBRA_FOREST_SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, UMBRA_FOREST_KEY.getValue(), UMBRA_FOREST);

    }
}
