package io.github.thecharlsen.charlsensideas;

import io.github.thecharlsen.charlsensideas.Blocks.BlockEntitys.DummyDataStorage;
import io.github.thecharlsen.charlsensideas.Recipe.CharlsensideasRecipes;
import io.github.thecharlsen.charlsensideas.World.Dimension.TenebrisDimension;
import io.github.thecharlsen.charlsensideas.World.TreeDecorators.ChidTreeDecoratorTypes;
import io.github.thecharlsen.charlsensideas.World.TrunkPlacer.TrunkPlacerTypes;
import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class Charlsensideas implements ModInitializer {

    public static final String MOD_ID = "charlsensideas";
    public static final String VERSION = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().toString(); //year/build/day/month
    public static Identifier locate(String location) {
        return new Identifier(MOD_ID, location);
    }

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[0m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    //OwoItemGroup
    public static final OwoItemGroup CHARLSENSIDEAS_ITG = new OwoItemGroup(new Identifier("charlsensideas", "charlsensideas_itg")) {

        @Override
        protected void setup() {
            this.setCustomTexture(CharlsensideasIdentifiers.ITEM_GROUP_BACKGROUND);
            this.setStackHeight(6);

            this.addTab(Icon.of(CharlsensideasItems.Dog_Music_Disc), "items", null);
            this.addTab(Icon.of(CharlsensideasBlocks.Black_Tourmaline_Stone_Bricks), "blocks", null);
            this.addTab(Icon.of(CharlsensideasTools.Bornite_Pickaxe), "tools", null);
            this.addTab(Icon.of(Items.AIR), "armor", null);
            this.addTab(Icon.of(CharlsensideasItems.Bornite), "ores", null);
            this.addTab(Icon.of(CharlsensideasItems.CHIP), "food", null);

            this.addButton(ItemGroupButton.github("https://github.com/TheCharlsen/CharlsensIdeas"));
            this.addButton(ItemGroupButton.curseforge("https://www.curseforge.com/minecraft/mc-mods/charlsensideas"));
            this.addButton(ItemGroupButton.modrinth("https://modrinth.com/mod/charlsensideas"));
            this.addButton(ItemGroupButton.discord("https://discord.gg/fPZgf2y3eB"));
            this.addButton(ItemGroupButton.link(Icon.of(CharlsensideasIdentifiers.ITEM_GROUP_BUTTON_ICONS, 0, 0, 64, 64), "youtube", "https://www.youtube.com/channel/UCzBj08FS4tDr3Lyf9zWM3kg"));
            this.addButton(ItemGroupButton.link(Icon.of(CharlsensideasIdentifiers.ITEM_GROUP_BUTTON_ICONS, 16, 64, 64, 64), "tcgithubio", "https://thecharlsen.github.io/"));
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(CharlsensideasItems.Black_Tourmaline_Gem);
        }
    };

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
        CharlsensideasCallbackEvents.callbackEventsInit();
        TenebrisDimension.init();
        CharlsensideasEntitys.entityInit();
        TrunkPlacerTypes.init();
        ChidTreeDecoratorTypes.init();
        CharlsensideasRecipes.init();
        CharlsensideasParticleTypes.init();

        CHARLSENSIDEAS_ITG.initialize();

        LOGGER.info(ANSI_BLACK_BACKGROUND + "[Charlsensideas]: version " + ANSI_YELLOW + VERSION + ANSI_WHITE + ANSI_BLACK_BACKGROUND + " is now initialized");

    }
}
