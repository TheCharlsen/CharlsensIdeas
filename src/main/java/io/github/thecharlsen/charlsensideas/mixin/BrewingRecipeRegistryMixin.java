package io.github.thecharlsen.charlsensideas.mixin;

import io.github.thecharlsen.charlsensideas.CharlsensideasItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(BrewingRecipeRegistry.class)
public abstract class BrewingRecipeRegistryMixin {
    @Shadow @Final private static List<BrewingRecipeRegistry.Recipe<Potion>> POTION_RECIPES;

    @Inject(method = "registerDefaults", at = @At("TAIL"), cancellable = true)
    private static void hook_registerDefaults(CallbackInfo ci) {
        hook_registerPotionRecipe(Potions.AWKWARD, CharlsensideasItems.Pompon, CharlsensideasItems.Potion_Of_Blossom);
    }

    private static void hook_registerPotionRecipe(Potion input, Item item, Potion output) {
        POTION_RECIPES.add(new BrewingRecipeRegistry.Recipe(input, Ingredient.ofItems(new ItemConvertible[]{item}), output));
    }
}
