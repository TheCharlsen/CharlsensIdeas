package io.github.thecharlsen.charlsensideas.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class FlowerWalkerEnchantment extends Enchantment {
    public FlowerWalkerEnchantment() {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[] {EquipmentSlot.FEET});
    }

    public int getMinPower(int level) {
        return 1;
    }

    public int getMaxPower(int level) {
        return  3;
    }
    public boolean isTreasure() {
        return true;
    }

    public int getMaxLevel() {
        return 1;
    }

}

