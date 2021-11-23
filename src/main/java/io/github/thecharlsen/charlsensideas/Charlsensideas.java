package io.github.thecharlsen.charlsensideas;

import com.glisco.owo.itemgroup.OwoItemGroup;
import io.github.thecharlsen.charlsensideas.Blocks.BlockEntitys.DummyDataStorage;
import io.github.thecharlsen.charlsensideas.World.CharlsensideasConfiguredFeatures;
import io.github.thecharlsen.charlsensideas.World.CharlsensideasStructureFeature;
import io.github.thecharlsen.charlsensideas.World.CharlsensideasStructures;
import io.github.thecharlsen.charlsensideas.World.Dimension.TenebrisDimension;
import io.github.thecharlsen.charlsensideas.World.TreeDecorators.ChidTreeDecoratorTypes;
import io.github.thecharlsen.charlsensideas.World.TrunkPlacer.TrunkPlacerTypes;
import io.github.thecharlsen.charlsensideas.mixin.StructuresConfigAccessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.loader.ModContainer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Charlsensideas implements ModInitializer {

/*
    @Override
    public @NotNull String getVersion() {
        return metadata.getVersion().getFriendlyString();
    }

    public @NotNull String getPrefixedVersion() {
        String version = getVersion().trim();
        if (version.startsWith("version")) {
            version = "v" + version.substring("version".length());
        } else if (version.startsWith("ver")) {
            version = "v" + version.substring("ver".length());
        } else if (!version.startsWith("v")) {
            version = "v" + version;
        }
        return version.trim();
    }*/

    public static final String MOD_ID = "charlsensideas";
    public static final String VERSION = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().toString(); //year/build/day/month
    public static final OwoItemGroup MAIN = new CharlsensideasItemGroup(RegistryHelper.id("main"));
    public static Identifier locate(String location) {
        return new Identifier(MOD_ID, location);
    }

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[0m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    @Deprecated@SuppressWarnings({"unused"})
    private static final MinecraftServer server = null;
    public static final Logger LOGGER = LogManager.getLogger("charlsensideas");

    @NotNull
    @Deprecated
    public static MinecraftServer getServer() {
      throw new UnsupportedOperationException();
  }

    public static final BlockEntityType<DummyDataStorage> DUMMY_DATA_STORAGE;
    static {
        DUMMY_DATA_STORAGE = Registry.register(
                Registry.BLOCK_ENTITY_TYPE, "atlantis:dummydatastorage",
                FabricBlockEntityTypeBuilder.create(
                        DummyDataStorage::new, CharlsensideasBlocks.TenebrisPortal).build(null));
    }

    public static RegistryKey<World> getOverworldKey() {
        Identifier OVERWORLD_ID = DimensionOptions.OVERWORLD.getValue();
        return RegistryKey.of(Registry.WORLD_KEY, OVERWORLD_ID);
    }

    public static final String MODID = "charlsensideas";

    @Override
    @SuppressWarnings("deprecation")
	public void onInitialize() {

        CharlsensideasBlocks.blocksInit();
        CharlsensideasItems.itemsInit();
        CharlsensideasFluids.fluidsInit();
        CharlsensideasSoundEvents.soundEventsInit();
        CharlsensideasEnchantments.enchantmentsInit();
        CharlsensideasTools.toolsInit();
        CharlsensideasStatusEffects.statusEffectsInit();
        CharlsensideasBiomes.biomesInit();
        CharlsensideasCallbackEvents.callbackEventsInit();
        io.github.thecharlsen.charlsensideas.World.CharlsensideasStructures.setupAndRegisterStructureFeatures();
        CharlsensideasStructureFeature.registerConfiguredStructures();
        CharlsensideasConfiguredFeatures.configuredFeaturesInit();
        CharlsensideasBlockTags.initBlockTags();
        TenebrisDimension.init();
        TenebrisDimension.setupSurfaceBuilders();
        TenebrisDimension.registerBiomeSources();
        CharlsensideasEntitys.entityInit();
        MAIN.initialize();
        TrunkPlacerTypes.init();
        ChidTreeDecoratorTypes.init();

        LOGGER.info(ANSI_BLACK_BACKGROUND + "[Charlsensideas]: version " + ANSI_YELLOW + VERSION + ANSI_WHITE + ANSI_BLACK_BACKGROUND + " is now initialized");

        BiomeModifications.create(new Identifier(MODID, "diamond_cascade_addition"))
                .add(   // Describes what we are doing. SInce we are adding a structure, we choose ADDITIONS.
                        ModificationPhase.ADDITIONS,

                        // Add our structure to all biomes including other modded biomes.
                        // You can filter to certain biomes based on stuff like temperature, scale, precipitation, mod id.
                        BiomeSelectors.all(),

                        // context is basically the biome itself. This is where you do the changes to the biome.
                        // Here, we will add our ConfiguredStructureFeature to the biome.
                        context -> {
                            context.getGenerationSettings().addBuiltInStructure(CharlsensideasStructureFeature.CONFIGURED_DIAMOND_CASCADE);
                        });


        BiomeModifications.create(new Identifier(MODID, "ilfty_house_addition"))
                .add(
                        ModificationPhase.ADDITIONS,
                        BiomeSelectors.includeByKey(CharlsensideasBiomes.ILFTY_HILLS_KEY),
                        context -> {
                            context.getGenerationSettings().addBuiltInStructure(CharlsensideasStructureFeature.CONFIGURED_ILFTY_HOUSE);
                        });


    }

    /**
	  * || OPTIONAL ||
            *  This is optional as Fabric API already adds your structure to all dimension.
            *  But if you want to do dimension based blacklisting, you will need to both
            *  manually remove your structure from the chunkgenerator's structure spacing map.
            * If the spacing or our structure is not added, the structure doesn't spawn in that dimension.
            */
     public static void removeStructureSpawningFromSelectedDimension() {
        // Controls the dimension blacklisting
        ServerWorldEvents.LOAD.register((MinecraftServer minecraftServer, ServerWorld serverWorld)->{

            // Need temp map as some mods use custom chunk generators with immutable maps in themselves.

            Map<StructureFeature<?>, StructureConfig> tempMap = new HashMap<>(serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig().getStructures());

            // Make absolutely sure modded dimension cannot spawn our structures.
            // New dimensions under the minecraft namespace will still get it (datapacks might do this)
            if(!serverWorld.getRegistryKey().getValue().getNamespace().equals("minecraft")) {
                tempMap.keySet().remove(CharlsensideasStructures.DIAMOND_CASCADE);
            }

            // Set the new modified map of structure spacing to the dimension's chunkgenerator.
            ((StructuresConfigAccessor)serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig()).setStructures(tempMap);
        });

    }
}
