package com.github.thecharlsen.charlsensideas.StatusEffects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class BlossomedStatusEffect extends StatusEffect {
    public BlossomedStatusEffect() {
        super(StatusEffectType.BENEFICIAL, 0x98D982);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
