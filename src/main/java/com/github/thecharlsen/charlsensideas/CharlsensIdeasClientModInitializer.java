package com.github.thecharlsen.charlsensideas;

import com.github.thecharlsen.charlsensideas.Items.MusicPlayerGuiItem;
import com.github.thecharlsen.charlsensideas.Models.Entitys.CubeEntityModel;
import com.github.thecharlsen.charlsensideas.Render.Entitys.CubeEntityRenderer;
import com.github.thecharlsen.charlsensideas.Render.TenebrisSkyRenderer;
import com.github.thecharlsen.charlsensideas.World.Dimension.TenebrisDimension;
import io.github.waterpicker.openworlds.OpenWorlds;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.*;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockRenderView;

import java.util.function.Function;

@Environment(EnvType.CLIENT)
public class CharlsensIdeasClientModInitializer implements ClientModInitializer {

    public static Item MUSICPLAYER = new MusicPlayerGuiItem(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_MUSIC).maxCount(1));

    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier("charlsensideas", "cube"), "main");

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(CharlsensideasBlocks.PineSapling, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CharlsensideasBlocks.Pompon, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CharlsensideasBlocks.CloudBlock, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(CharlsensideasBlocks.Alpine_Strawberry_Bush, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CharlsensideasBlocks.Weird_Grass_Block, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CharlsensideasBlocks.Umbra_Sapling, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CharlsensideasBlocks.Ancient_Groats, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CharlsensideasBlocks.TenebrisPortal, RenderLayer.getTranslucent());

        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "musicplayer"), MUSICPLAYER);

        EntityRendererRegistry.INSTANCE.register(CharlsensideasEntitys.CUBE, (context) -> {
            return new CubeEntityRenderer(context);
        });

        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, CubeEntityModel::getTextureModelData);

        SkyProperties tenebris = new SkyProperties(255.0F, true, SkyProperties.SkyType.NORMAL, false, false) {
            @Override
            public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
                return color;
            }

            @Override
            public boolean useThickFog(int camX, int camY) {
                return false;
            }
        };

        OpenWorlds.registerSkyProperty(TenebrisDimension.TENEBRIS_DIMENSION_TYPE_KEY, tenebris);
        OpenWorlds.registerSkyRenderer(TenebrisDimension.TENEBRIS_DIMENSION_TYPE_KEY, new TenebrisSkyRenderer());
        OpenWorlds.registerCloudRenderer(TenebrisDimension.TENEBRIS_DIMENSION_TYPE_KEY, (client, matrices, matrix4f, tickDelta, cameraX, cameraY, cameraZ) -> {});

        ColorProviderRegistry.BLOCK.register((state , view, pos, tintIndex) ->
        view != null && pos != null
                ? BiomeColors.getFoliageColor(view, pos)
                : FoliageColors.getDefaultColor(), CharlsensideasBlocks.Weird_Grass_Block);

        ColorProviderRegistry.BLOCK.register((state , view, pos, tintIndex) ->
                view != null && pos != null
                        ? BiomeColors.getFoliageColor(view, pos)
                        : FoliageColors.getDefaultColor(), CharlsensideasBlocks.Umbra_Leaves);


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
            public void reload(ResourceManager resourceManager) {
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