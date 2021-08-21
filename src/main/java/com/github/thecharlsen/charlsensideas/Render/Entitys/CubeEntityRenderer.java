package com.github.thecharlsen.charlsensideas.Render.Entitys;

import com.github.thecharlsen.charlsensideas.CharlsensIdeasClientModInitializer;
import com.github.thecharlsen.charlsensideas.Entitys.CubeEntity;
import com.github.thecharlsen.charlsensideas.Models.Entitys.CubeEntityModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CubeEntityRenderer extends MobEntityRenderer<CubeEntity, CubeEntityModel> {

    public CubeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CubeEntityModel(context.getPart(CharlsensIdeasClientModInitializer.MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(CubeEntity entity) {
        return new Identifier("charlsensideas", "textures/entity/cube/cube.png");
    }
}
