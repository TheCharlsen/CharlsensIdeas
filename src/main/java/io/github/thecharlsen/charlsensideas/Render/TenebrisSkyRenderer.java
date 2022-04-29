package io.github.thecharlsen.charlsensideas.Render;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.thecharlsen.charlsensideas.World.Dimension.TenebrisDimension;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class TenebrisSkyRenderer implements ClientModInitializer {

    private static final Identifier SUN_TEXTURES = new Identifier("charlsensideas:textures/environment/charlsensideas/sun.png");
    private static final Identifier MOON_PHASES_TEXTURES = new Identifier("charlsensideas:textures/environment/charlsensideas/moon_phases.png");
    private static final Identifier SKY = new Identifier("textures/block/dirt.png");

    public static void render(WorldRenderContext context) {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        RenderSystem.setShaderTexture(0, SKY);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();

        Matrix4f matrix4f = context.matrixStack().peek().getPositionMatrix();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        bufferBuilder.vertex(matrix4f, -100.0f, -100.0f, -100.0f).texture(0.0F, 0.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, -100.0f, -100.0f, 100.0f).texture(0.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0f, -100.0f, 100.0f).texture(1.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0f, -100.0f, -100.0f).texture(1.0F, 0.0F).color(255, 255, 255, 255).next();

        bufferBuilder.vertex(matrix4f, -100.0f, 100.0f, -100.0f).texture(0.0F, 0.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, -100.0f, -100.0f, -99.0f).texture(0.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0f, -100.0f, -99.0f).texture(1.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0f, 100.0f, -100.0f).texture(1.0F, 0.0F).color(255, 255, 255, 255).next();

        bufferBuilder.vertex(matrix4f, -100.0f, -100.0f, 100.0f).texture(0.0F, 0.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, -100.0f, 100.0f, 100.0f).texture(0.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0f, 100.0f, 100.0f).texture(1.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0f, -100.0f, 100.0f).texture(1.0F, 0.0F).color(255, 255, 255, 255).next();

        bufferBuilder.vertex(matrix4f, -100.0f, 100.0f, 101.0f).texture(0.0F, 0.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, -100.0f, 100.0f, -100.0f).texture(0.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0f, 100.0f, -100.0f).texture(1.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0f, 100.0f, 100.0f).texture(1.0F, 0.0F).color(255, 255, 255, 255).next();

        bufferBuilder.vertex(matrix4f, 100.0f, -100.0f, -100.0f).texture(0.0F, 0.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0f, -100.0f, 100.0f).texture(0.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0f, 100.0f, 100.0f).texture(1.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, 100.0f, 100.0f, -100.0f).texture(1.0F, 0.0F).color(255, 255, 255, 255).next();

        bufferBuilder.vertex(matrix4f, -100.0f, 100.0f, -100.0f).texture(0.0F, 0.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, -100.0f, 100.0f, 100.0f).texture(0.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, -100.0f, -100.0f, 100.0f).texture(1.0F, 1.0F).color(255, 255, 255, 255).next();
        bufferBuilder.vertex(matrix4f, -100.0f, -100.0f, -100.0f).texture(1.0F, 0.0F).color(255, 255, 255, 255).next();
        tessellator.draw();

        RenderSystem.depthMask(true);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }

    @Override
    public void onInitializeClient() {
        DimensionRenderingRegistry.registerSkyRenderer(TenebrisDimension.TENEBRIS_WORLD, TenebrisSkyRenderer::render);
        DimensionRenderingRegistry.registerDimensionEffects(new Identifier("charlsensideas", "tenebris"), new DimensionEffects.End());
    }
}
