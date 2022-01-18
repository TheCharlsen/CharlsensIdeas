package io.github.thecharlsen.charlsensideas.Recipe;

import io.github.thecharlsen.charlsensideas.Charlsensideas;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CharlsensideasRecipes {

    public static void init() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Charlsensideas.MOD_ID, PressRecipe.Serializer.ID), PressRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(Charlsensideas.MOD_ID, PressRecipe.Type.ID), PressRecipe.Type.INSTANCE);
    }

}
