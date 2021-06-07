package charlsen.charlsens.ideas;

import charlsen.charlsens.ideas.Blocks.BlockEntitys.BoxBlockEntity;
import charlsen.charlsens.ideas.Blocks.BoxBlock;
import charlsen.charlsens.ideas.Screens.BoxScreen;
import charlsen.charlsens.ideas.Items.MusicPlayerGuiItem;
import charlsen.charlsens.ideas.Screens.BoxScreenHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.*;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.world.BlockRenderView;

import java.util.function.Function;

@Environment(EnvType.CLIENT)
public class CharlsensIdeasClientModInitializer implements ClientModInitializer {

    public static Item MUSICPLAYER = new MusicPlayerGuiItem(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_MUSIC).maxCount(1));

    public static final Identifier BOX = new Identifier("charlsensideas", "box_block");

    public static final Block BOX_BLOCK;

    public static final BlockItem BOX_BLOCK_ITEM;
    public static final BlockEntityType<BoxBlockEntity> BOX_BLOCK_ENTITY;
    public static final ScreenHandlerType<BoxScreenHandler> BOX_SCREEN_HANDLER;


    static {
        BOX_BLOCK = Registry.register(Registry.BLOCK, BOX, new BoxBlock(FabricBlockSettings.of(Material.SHULKER_BOX).strength(2.0f, 2.0f).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES)));
        BOX_BLOCK_ITEM = Registry.register(Registry.ITEM, BOX, new BlockItem(BOX_BLOCK, new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_SECCHESTS)));
        BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BOX, BoxScreenHandler::new);
        BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, BOX, BlockEntityType.Builder.create(BoxBlockEntity::new, BOX_BLOCK).build(null));
    }

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(CharlsensideasBlocks.PineSapling, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CharlsensideasBlocks.Pompon, RenderLayer.getCutout());


        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "musicplayer"), MUSICPLAYER);

        ScreenRegistry.register(CharlsensIdeasClientModInitializer.BOX_SCREEN_HANDLER, BoxScreen::new);


      //Weird Water
        setupFluidRendering(CharlsensideasFluids.Still_Weird_Water, CharlsensideasFluids.Flowing_Weird_Water, new Identifier("charlsensideas", "weird_water"), 0x2f6854 );
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), CharlsensideasFluids.Still_Weird_Water, CharlsensideasFluids.Flowing_Weird_Water);

        // ...
    }

    public static void setupFluidRendering(final Fluid still, final Fluid flowing, final Identifier textureFluidId, final int color) {
        final Identifier stillSpriteId = new Identifier(textureFluidId.getNamespace(), "block/" + textureFluidId.getPath() + "_still");
        final Identifier flowingSpriteId = new Identifier(textureFluidId.getNamespace(), "block/" + textureFluidId.getPath() + "_flow");

        // If they're not already present, add the sprites to the block atlas
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(stillSpriteId);
            registry.register(flowingSpriteId);
        });

        final Identifier fluidId = Registry.FLUID.getId(still);
        final Identifier listenerId = new Identifier(fluidId.getNamespace(), fluidId.getPath() + "_reload_listener");

        final Sprite[] fluidSprites = { null, null };

        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
            @Override
            public Identifier getFabricId() {
                return listenerId;
            }

            /**
             * Get the sprites from the block atlas when resources are reloaded
             */
            @Override
            public void apply(ResourceManager resourceManager) {
                final Function<Identifier, Sprite> atlas = MinecraftClient.getInstance().getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
                fluidSprites[0] = atlas.apply(stillSpriteId);
                fluidSprites[1] = atlas.apply(flowingSpriteId);
            }
        });

        // The FluidRenderer gets the sprites and color from a FluidRenderHandler during rendering
        final FluidRenderHandler renderHandler = new FluidRenderHandler()
        {
            @Override
            public Sprite[] getFluidSprites(BlockRenderView view, BlockPos pos, FluidState state) {
                return fluidSprites;
            }

            @Override
            public int getFluidColor(BlockRenderView view, BlockPos pos, FluidState state) {
                return color;
            }
        };

        FluidRenderHandlerRegistry.INSTANCE.register(still, renderHandler);
        FluidRenderHandlerRegistry.INSTANCE.register(flowing, renderHandler);
    }


}