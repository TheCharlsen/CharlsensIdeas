package com.github.thecharlsen.charlsensideas;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class CharlsensideasFoodComponents {

    public static final FoodComponent CHIP = (new FoodComponent.Builder()).hunger(2).saturationModifier((float) .1).statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 600, 0), 1.0F).snack().build();
    public static final FoodComponent Alpine_Strawberry = (new FoodComponent.Builder()).hunger(3).saturationModifier((float).1).snack().build();

}
