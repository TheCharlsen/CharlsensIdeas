package io.github.thecharlsen.charlsensideas;

import io.github.thecharlsen.charlsensideas.Screens.PressScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class CharlsensideasScreenHandlers {

    public static ScreenHandlerType<PressScreenHandler> PRESS_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(Charlsensideas.MOD_ID, "press"),
                    PressScreenHandler::new);
}
