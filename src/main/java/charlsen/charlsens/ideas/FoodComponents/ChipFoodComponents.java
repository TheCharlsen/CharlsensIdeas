package charlsen.charlsens.ideas.FoodComponents;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ChipFoodComponents {
    
   public static final FoodComponent CHIP = (new FoodComponent.Builder()).hunger(2).saturationModifier((float) .1).statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 600, 0), 1.0F).snack().build();

}
