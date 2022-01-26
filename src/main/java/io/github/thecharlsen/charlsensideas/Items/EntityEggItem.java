package io.github.thecharlsen.charlsensideas.Items;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.MobSpawnerLogic;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class EntityEggItem extends Item {
        private static final Map<EntityType<? extends MobEntity>, EntityEggItem> SPAWN_EGGS = Maps.newIdentityHashMap();
        private final EntityType<?> type;

        public EntityEggItem(EntityType<? extends MobEntity> type, Item.Settings settings) {
            super(settings);
            this.type = type;
            SPAWN_EGGS.put(type, this);
        }

        public ActionResult useOnBlock(ItemUsageContext context) {
            World world = context.getWorld();
            if (!(world instanceof ServerWorld)) {
                return ActionResult.SUCCESS;
            } else {
                ItemStack itemStack = context.getStack();
                BlockPos blockPos = context.getBlockPos();
                Direction direction = context.getSide();
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.isOf(Blocks.SPAWNER)) {
                    BlockEntity blockEntity = world.getBlockEntity(blockPos);
                    if (blockEntity instanceof MobSpawnerBlockEntity) {
                        MobSpawnerLogic mobSpawnerLogic = ((MobSpawnerBlockEntity)blockEntity).getLogic();
                        EntityType<?> entityType = this.getEntityType(itemStack.getNbt());
                        mobSpawnerLogic.setEntityId(entityType);
                        blockEntity.markDirty();
                        world.updateListeners(blockPos, blockState, blockState, 3);
                        itemStack.decrement(1);
                        return ActionResult.CONSUME;
                    }
                }

                BlockPos blockEntity;
                if (blockState.getCollisionShape(world, blockPos).isEmpty()) {
                    blockEntity = blockPos;
                } else {
                    blockEntity = blockPos.offset(direction);
                }

                EntityType<?> mobSpawnerLogic = this.getEntityType(itemStack.getNbt());
                if (mobSpawnerLogic.spawnFromItemStack((ServerWorld)world, itemStack, context.getPlayer(), blockEntity, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockPos, blockEntity) && direction == Direction.UP) != null) {
                    itemStack.decrement(1);
                    world.emitGameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);
                }

                return ActionResult.CONSUME;
            }
        }

        public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            ItemStack itemStack = user.getStackInHand(hand);
            HitResult hitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
            if (hitResult.getType() != HitResult.Type.BLOCK) {
                return TypedActionResult.pass(itemStack);
            } else if (!(world instanceof ServerWorld)) {
                return TypedActionResult.success(itemStack);
            } else {
                BlockHitResult blockHitResult = (BlockHitResult)hitResult;
                BlockPos blockPos = blockHitResult.getBlockPos();
                if (!(world.getBlockState(blockPos).getBlock() instanceof FluidBlock)) {
                    return TypedActionResult.pass(itemStack);
                } else if (world.canPlayerModifyAt(user, blockPos) && user.canPlaceOn(blockPos, blockHitResult.getSide(), itemStack)) {
                    EntityType<?> entityType = this.getEntityType(itemStack.getNbt());
                    if (entityType.spawnFromItemStack((ServerWorld)world, itemStack, user, blockPos, SpawnReason.SPAWN_EGG, false, false) == null) {
                        return TypedActionResult.pass(itemStack);
                    } else {
                        if (!user.getAbilities().creativeMode) {
                            itemStack.decrement(1);
                        }

                        user.incrementStat(Stats.USED.getOrCreateStat(this));
                        world.emitGameEvent(GameEvent.ENTITY_PLACE, user);
                        return TypedActionResult.consume(itemStack);
                    }
                } else {
                    return TypedActionResult.fail(itemStack);
                }
            }
        }

        public boolean isOfSameEntityType(@Nullable NbtCompound nbt, EntityType<?> type) {
            return Objects.equals(this.getEntityType(nbt), type);
        }

        @Nullable
        public static EntityEggItem forEntity(@Nullable EntityType<?> type) {
            return (EntityEggItem)SPAWN_EGGS.get(type);
        }

        public static Iterable<EntityEggItem> getAll() {
            return Iterables.unmodifiableIterable(SPAWN_EGGS.values());
        }

        public EntityType<?> getEntityType(@Nullable NbtCompound nbt) {
            if (nbt != null && nbt.contains("EntityTag", 10)) {
                NbtCompound nbtCompound = nbt.getCompound("EntityTag");
                if (nbtCompound.contains("id", 8)) {
                    return (EntityType)EntityType.get(nbtCompound.getString("id")).orElse(this.type);
                }
            }

            return this.type;
        }

        public Optional<MobEntity> spawnBaby(PlayerEntity user, MobEntity entity, EntityType<? extends MobEntity> entityType, ServerWorld world, Vec3d pos, ItemStack stack) {
            if (!this.isOfSameEntityType(stack.getNbt(), entityType)) {
                return Optional.empty();
            } else {
                MobEntity mobEntity;
                if (entity instanceof PassiveEntity) {
                    mobEntity = ((PassiveEntity)entity).createChild(world, (PassiveEntity)entity);
                } else {
                    mobEntity = (MobEntity)entityType.create(world);
                }

                if (mobEntity == null) {
                    return Optional.empty();
                } else {
                    mobEntity.setBaby(true);
                    if (!mobEntity.isBaby()) {
                        return Optional.empty();
                    } else {
                        mobEntity.refreshPositionAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0.0F, 0.0F);
                        world.spawnEntityAndPassengers(mobEntity);
                        if (stack.hasCustomName()) {
                            mobEntity.setCustomName(stack.getName());
                        }

                        if (!user.getAbilities().creativeMode) {
                            stack.decrement(1);
                        }

                        return Optional.of(mobEntity);
                    }
                }
            }
        }
}