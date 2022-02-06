package io.github.thecharlsen.charlsensideas.mixin;

import net.minecraft.client.render.entity.CatEntityRenderer;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CatEntityRenderer.class)
public abstract class CatEntityRendererMixin {

    private static final Identifier MARLEY_TEXTURE = new Identifier("charlsensideas", "textures/entity/cat/marley.png");

    @Inject(at = @At("HEAD"), method = "getTexture(Lnet/minecraft/entity/passive/CatEntity;)Lnet/minecraft/util/Identifier;", cancellable = true)
    public void getTexture(CatEntity catEntity, CallbackInfoReturnable<Identifier> cir) {
        String string = Formatting.strip(catEntity.getName().getString());
        if (string != null && "Marley".equals(string)) {
            cir.setReturnValue(MARLEY_TEXTURE);
        }
    }
}