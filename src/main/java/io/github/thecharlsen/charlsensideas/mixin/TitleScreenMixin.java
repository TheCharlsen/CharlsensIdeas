package io.github.thecharlsen.charlsensideas.mixin;

import io.github.thecharlsen.charlsensideas.Charlsensideas;
import io.github.thecharlsen.charlsensideas.Screens.CharlsensideasCreditsScreen;
import com.google.common.util.concurrent.Runnables;
import net.minecraft.client.gui.screen.CreditsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.PressableTextWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.checkerframework.checker.units.qual.A;
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
    private int copyrightTextWidth;

    private int copyrightTextX;
    @Shadow
    private final boolean doBackgroundFade;
    @Shadow
    private long backgroundFadeStart;

    private static final Text AGPL = new LiteralText("Charlsensideas! Licensed with AGPL-3.0");

    @Inject(at = @At("TAIL"), method = "init")
    protected void init(CallbackInfo callbackInfo) {
        int i = this.textRenderer.getWidth(AGPL);
        int j = this.width - i - 1;

        this.addDrawableChild(new PressableTextWidget(j, this.height - 20, i, 10, AGPL, (button) -> {
            assert this.client != null;
            this.client.setScreen(new CharlsensideasCreditsScreen(false, Runnables.doNothing()));
        }, this.textRenderer));
    }
    @Inject(at = @At("TAIL"), method = "render")
    private void render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        String string = "Charlsensideas " + Charlsensideas.VERSION;
        float f = this.doBackgroundFade ? (float) (Util.getMeasuringTimeMs() - this.backgroundFadeStart) / 1000.0F : 1.0F;
        float g = this.doBackgroundFade ? MathHelper.clamp(f - 1.0F, 0.0F, 1.0F) : 1.0F;
        int l = MathHelper.ceil(g * 255.0F) << 24;
        drawStringWithShadow(matrices, this.textRenderer, string, 2, this.height - 20, 16777215 | l);
    }
}

