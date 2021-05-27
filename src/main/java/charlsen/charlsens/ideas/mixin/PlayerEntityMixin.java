package charlsen.charlsens.ideas.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {


    private int tickCounter = 0;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("TAIL"), method = "tick()V")
    public void onTick(CallbackInfo ci) {
        tickCounter++;
        if (attackingPlayer.hasStatusEffect(StatusEffects.GLOWING) & tickCounter >= 20) {
            tickCounter = 0;
            if (this.world.getBlockState(this.getBlockPos().down()).getBlock().equals(Blocks.GRASS_BLOCK)) {
                world.setBlockState(this.getBlockPos().down(), Blocks.ACACIA_PLANKS.getDefaultState());
                System.out.println("Grasssss");

            }
        }
    }
}