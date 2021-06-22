package charlsen.charlsens.ideas;

import charlsen.charlsens.ideas.Enchantments.FlowerWalkerEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CharlsensideasEnchantments {

    public static Enchantment FlowerWalker = Registry.register(Registry.ENCHANTMENT, new Identifier("charlsensideas", "flower_walker"), new FlowerWalkerEnchantment());

    public static void enchantmentsInit(){

    }
}
