package com.github.thecharlsen.charlsensideas.mixin;

import com.github.thecharlsen.charlsensideas.Screens.CharlsensideasCreditsScreen;
import com.google.common.util.concurrent.Runnables;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Text title, boolean doBackgroundFade) {
        super(title);
        this.doBackgroundFade = doBackgroundFade;
    }
    @Shadow
    private int copyrightTextWidth;
    @Shadow
    private int copyrightTextX;
    @Shadow
    private final boolean doBackgroundFade;
    @Shadow
    private long backgroundFadeStart;
    @Inject(at = @At("TAIL"), method = "render")
    private void render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        String string = "Charlsensideas Beta 0.2.3";
        float f = this.doBackgroundFade ? (float) (Util.getMeasuringTimeMs() - this.backgroundFadeStart) / 1000.0F : 1.0F;
        float g = this.doBackgroundFade ? MathHelper.clamp(f - 1.0F, 0.0F, 1.0F) : 1.0F;
        int l = MathHelper.ceil(g * 255.0F) << 24;
        drawStringWithShadow(matrices, this.textRenderer, string, 2, this.height - 20, 16777215 | l);
        drawStringWithShadow(matrices, this.textRenderer, "Charlsensideas! Licensed with AGPL-3.0", this.copyrightTextX, this.height - 20, 16777215 | l);
        if (mouseX > this.copyrightTextX && mouseX < this.copyrightTextX + this.copyrightTextWidth && mouseY > this.height - 20 && mouseY < this.height - 10) {
            fill(matrices, this.copyrightTextX, this.height - 11, this.copyrightTextX + this.copyrightTextWidth, this.height -12, 16777215 | l);
        }
    }
    @Inject(at = @At("TAIL"), method = "mouseClicked")
    private void mouseClicked(double mouseX, double mouseY, int button, CallbackInfoReturnable<Boolean> cir){
        if (mouseX > (double)this.copyrightTextX && mouseX < (double)(this.copyrightTextX + this.copyrightTextWidth) && mouseY > (double)(this.height - 20) && mouseY < (double)this.height - 10) {
            this.client.setScreen(new CharlsensideasCreditsScreen(false, Runnables.doNothing()));
        }
    }
}

