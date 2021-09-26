package io.github.thecharlsen.charlsensideas;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class CharlsensideasFoodComponents {

    public static final FoodComponent CHIP = (new FoodComponent.Builder()).hunger(2).saturationModifier((float) .1).statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 600, 0), 1.0F).snack().build();
    public static final FoodComponent Alpine_Strawberry = (new FoodComponent.Builder()).hunger(3).saturationModifier((float).1).snack().build();
    public static final FoodComponent Ancient_Bread = (new FoodComponent.Builder()).hunger(7).saturationModifier((float).1).statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 150, 2), 1.0F).build();

}
