package charlsen.charlsens.ideas.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
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