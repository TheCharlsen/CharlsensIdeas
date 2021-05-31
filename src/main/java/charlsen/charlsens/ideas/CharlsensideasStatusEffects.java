package charlsen.charlsens.ideas;

import charlsen.charlsens.ideas.StatusEffects.BlossomedStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CharlsensideasStatusEffects {

    public static final StatusEffect Blossomed = new BlossomedStatusEffect();

    public static void statusEffectsInit(){

        Registry.register(Registry.STATUS_EFFECT, new Identifier("charlsensideas", "blossomed"), Blossomed);
    }
}
