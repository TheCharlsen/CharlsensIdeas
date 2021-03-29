package charlsen.charlsens.ideas.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PlayerEntity.class)
public abstract class FlowerWalkerMixin extends LivingEntity {



    protected FlowerWalkerMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

  @Inject(method = "tick()V", at = @At("TAIL"))
  public void onTick(CallbackInfo ci){
  this.world.getBlockState(this.getBlockPos().down()).getBlock().equals(Blocks.GRASS);

    }
}