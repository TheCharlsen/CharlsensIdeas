package charlsen.charlsens.ideas.mixin;

import charlsen.charlsens.ideas.CharlsensideasEnchantments;
import charlsen.charlsens.ideas.CharlsensideasStatusEffects;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;


@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected int randomXZ(Random random){
        return MathHelper.nextInt(random, -2, 2);
    }
    private double randomD(Random random){
        return MathHelper.nextDouble(random, -3, 3);
    }
    private int tickCounter = 0;
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
 }

    @Inject(at = @At("TAIL"), method = "tick()V")
    public void onTick(CallbackInfo ci) {

        ItemStack itemStack = this.getEquippedStack(EquipmentSlot.FEET);
        if (itemStack != null) {
            int x = EnchantmentHelper.getLevel(CharlsensideasEnchantments.FlowerWalker, itemStack);
            tickCounter++;
            if ((x > 0) && (tickCounter >= 30)) {
                tickCounter = 0;
            if (this.world.getBlockState(this.getBlockPos().down()).getBlock().equals(Blocks.GRASS_BLOCK)) {
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.ALLIUM.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.AZURE_BLUET.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.DANDELION.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.POPPY.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.BLUE_ORCHID.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.LILY_OF_THE_VALLEY.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.PINK_TULIP.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.WHITE_TULIP.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.ORANGE_TULIP.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.RED_TULIP.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.CORNFLOWER.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.OXEYE_DAISY.getDefaultState());

                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double) getPos().getX() + randomD(random), (double) getPos().getY() + randomD(random), (double) getPos().getZ() + randomD(random), randomD(random), randomD(random), randomD(random));
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double) getPos().getX() + randomD(random), (double) getPos().getY() + randomD(random), (double) getPos().getZ() + randomD(random), randomD(random), randomD(random), randomD(random));
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double) getPos().getX() + randomD(random), (double) getPos().getY() + randomD(random), (double) getPos().getZ() + randomD(random), randomD(random), randomD(random), randomD(random));

                System.out.println("Grasssss");
                System.out.println(x);

                }
            }
        }
        tickCounter++;
        if (this.hasStatusEffect(CharlsensideasStatusEffects.Blossomed) & tickCounter >= 30) {
            tickCounter = 0;
            if (this.world.getBlockState(this.getBlockPos().down()).getBlock().equals(Blocks.GRASS_BLOCK)) {
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.ALLIUM.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.AZURE_BLUET.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.DANDELION.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.POPPY.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.BLUE_ORCHID.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.LILY_OF_THE_VALLEY.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.PINK_TULIP.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.WHITE_TULIP.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.ORANGE_TULIP.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.RED_TULIP.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.CORNFLOWER.getDefaultState());
                world.setBlockState(this.getBlockPos().add(randomXZ(random), 0, randomXZ(random)), Blocks.OXEYE_DAISY.getDefaultState());

                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double) getPos().getX() + randomD(random), (double) getPos().getY() + randomD(random), (double) getPos().getZ() + randomD(random), randomD(random), randomD(random), randomD(random));
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double) getPos().getX() + randomD(random), (double) getPos().getY() + randomD(random), (double) getPos().getZ() + randomD(random), randomD(random), randomD(random), randomD(random));
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, (double) getPos().getX() + randomD(random), (double) getPos().getY() + randomD(random), (double) getPos().getZ() + randomD(random), randomD(random), randomD(random), randomD(random));

                System.out.println("GrasssssB");
            }
        }
    }
} /*Bigggggg Thanks To Accieo and Kaloyan on the Suitedllama Discord and my friend Emil for the Idea*/