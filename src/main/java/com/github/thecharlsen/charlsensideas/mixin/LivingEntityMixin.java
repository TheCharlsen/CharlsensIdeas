package com.github.thecharlsen.charlsensideas.mixin;

import com.github.thecharlsen.charlsensideas.CharlsensideasBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    protected LivingEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }


    protected boolean jumping;
    private Optional<BlockPos> climbingPos;
    private boolean canEnterTrapdoor(BlockPos pos, BlockState state) {
        if ((Boolean)state.get(TrapdoorBlock.OPEN)) {
            BlockState blockState = this.world.getBlockState(pos.down());
            if (blockState.isOf(Blocks.LADDER) && blockState.get(LadderBlock.FACING) == state.get(TrapdoorBlock.FACING)) {
                return true;
            }
        }
        return false;
    }
    public boolean isClimbing() {
        if (this.isSpectator()) {
            return false;
        } else {
            BlockPos blockPos = this.getBlockPos();
            BlockState blockState = this.getBlockStateAtPos();
            if (blockState.isIn(BlockTags.CLIMBABLE)) {
                this.climbingPos = Optional.of(blockPos);
                return true;
            } else if (blockState.getBlock() instanceof TrapdoorBlock && this.canEnterTrapdoor(blockPos, blockState)) {
                this.climbingPos = Optional.of(blockPos);
                return true;
            } else {
                return false;
            }
        }
    }
    Vec3d vec3d2 = this.getVelocity();

    @Inject(at = @At("TAIL"), method = "method_26318")
    public void  method_26318(Vec3d vec3d, float f, CallbackInfoReturnable<Vec3d> cir) {
        if ((this.horizontalCollision || this.jumping) && (this.isClimbing() || this.getBlockStateAtPos().isOf(CharlsensideasBlocks.CloudBlock))) {
            vec3d2 = new Vec3d(vec3d2.x, 0.2D, vec3d2.z);
            System.out.println("CHID ERROR");
        }
    }
}
