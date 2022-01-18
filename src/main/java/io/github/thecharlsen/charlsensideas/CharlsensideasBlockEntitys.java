package io.github.thecharlsen.charlsensideas;

import io.github.thecharlsen.charlsensideas.Blocks.BlockEntitys.PressBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CharlsensideasBlockEntitys {

    public static BlockEntityType<PressBlockEntity> PRESS_BLOCK_ENTITY =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Charlsensideas.MOD_ID, "press"),
                    FabricBlockEntityTypeBuilder.create(PressBlockEntity::new,
                            CharlsensideasBlocks.Press).build(null));
}
