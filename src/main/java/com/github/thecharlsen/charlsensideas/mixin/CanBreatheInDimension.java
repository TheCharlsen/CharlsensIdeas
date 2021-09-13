package com.github.thecharlsen.charlsensideas.mixin;

import com.github.thecharlsen.charlsensideas.World.Dimension.TenebrisDimension;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tag.FluidTags;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class CanBreatheInDimension extends LivingEntity {

    @Shadow
    protected boolean isSubmergedInWater;

    private CanBreatheInDimension(EntityType<? extends LivingEntity> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void atlantisTick(CallbackInfo ci) {
        if (world.getRegistryKey() == TenebrisDimension.TENEBRIS_WORLD) {
            if (this.isAlive() && this.isSubmergedInWater) {
                this.setAir(this.getMaxAir());
            }
        }

    }
}
