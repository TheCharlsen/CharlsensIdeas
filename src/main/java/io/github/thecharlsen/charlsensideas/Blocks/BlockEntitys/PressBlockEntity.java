package io.github.thecharlsen.charlsensideas.Blocks.BlockEntitys;

import io.github.thecharlsen.charlsensideas.CharlsensideasBlockEntitys;
import io.github.thecharlsen.charlsensideas.Items.Inventory.CharlsensideasImplementedInventory;
import io.github.thecharlsen.charlsensideas.Recipe.PressRecipe;
import io.github.thecharlsen.charlsensideas.Screens.PressScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PressBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, CharlsensideasImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    // How many ticks it will take to craft the item (divide by twenty to get seconds count)
    // In our case this should be even divisible by 21 as that's our pixel count for our progress arrow
    private int maxProgress = 460;


    public PressBlockEntity(BlockPos pos, BlockState state) {
        super(CharlsensideasBlockEntitys.PRESS_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return PressBlockEntity.this.progress;
                    case 1: return PressBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: PressBlockEntity.this.progress = value; break;
                    case 1: PressBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("block.charlsensideas.press");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new PressScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
    }

    public static void tick(World world, BlockPos pos, BlockState state, PressBlockEntity entity) {
        if(hasRecipe(entity)) {
            entity.progress++;
            if(entity.progress > entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(PressBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<PressRecipe> match = world.getRecipeManager()
                .getFirstMatch(PressRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && evaluateTime(match.get().getTime(), world)
                && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(PressBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<PressRecipe> match = world.getRecipeManager()
                .getFirstMatch(PressRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(0,1);
            entity.removeStack(1,1);
            entity.setStack(2, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(2).getCount() + 1));

            if(!world.isClient() && match.get().getTime() == PressRecipe.Time.NIGHT && match.get().getTime() == PressRecipe.Time.DAY) {
                EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, null, null, null, entity.pos,
                        SpawnReason.TRIGGERED, true, true);
            }

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(2).getItem() == output.getItem() || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }

    public static boolean evaluateTime(PressRecipe.Time time, World world) {
        boolean matches = false;

        if(time == PressRecipe.Time.DAY && world.getTimeOfDay() % 24000L < 13000) {
            matches = true;
        }

        if(time == PressRecipe.Time.NIGHT && world.getTimeOfDay() % 24000L > 13000) {
            matches = true;
        }

        if(time == PressRecipe.Time.BOTH && world.getTimeOfDay() % 24000L >= 0) {
            matches = true;
        }

        return matches;
    }
}
