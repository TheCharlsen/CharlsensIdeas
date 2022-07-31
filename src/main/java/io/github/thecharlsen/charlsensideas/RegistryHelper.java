package io.github.thecharlsen.charlsensideas;

import net.minecraft.util.Identifier;


public class RegistryHelper {

    public static Identifier id(String path) {
        return new Identifier(Charlsensideas.MOD_ID, path);
    }


}
