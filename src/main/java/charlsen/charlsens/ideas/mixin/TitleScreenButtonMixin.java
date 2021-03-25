package charlsen.charlsens.ideas.mixin;

import charlsen.charlsens.ideas.MusicPlayer.MusicPlayerScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenButtonMixin extends Screen {

    protected TitleScreenButtonMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "initWidgetsNormal")
    private void addCustomButton(int y, int spacingY, CallbackInfo ci) {
        this.addButton(new ButtonWidget(this.width / 2 - 100, 152, 200, 20, Text.of("CharlsensIdeas!"), (buttonWidget) -> {
           MinecraftClient.getInstance().openScreen(new SelectWorldScreen(this));
        }));
    }
}

