package charlsen.charlsens.ideas;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class CharlsensideasCallbackEvents {

    public static final Identifier CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/desert_pyramid");

    public static void callbackEventsInit(){

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(CharlsensideasItems.Da_Coconut_nut_Music_Disc));

                supplier.pool(poolBuilder);
            }
        });
  }
}
