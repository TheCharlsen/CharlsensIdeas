package charlsen.charlsens.ideas.tools;

import charlsen.charlsens.ideas.charlsensideas;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BornitePickaxeMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 1200;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 100.0F;
    }

    @Override
    public float getAttackDamage() {
        return 3.0F;
    }

    @Override
    public int getMiningLevel() {
        return 20;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(charlsensideas.Bornite_Pickaxe);
    }

    public static final BornitePickaxeMaterial INSTANCEBOPICK = new BornitePickaxeMaterial();

}
