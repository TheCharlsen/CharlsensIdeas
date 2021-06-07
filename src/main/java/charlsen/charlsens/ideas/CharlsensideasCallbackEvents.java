package charlsen.charlsens.ideas;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.BinomialLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class CharlsensideasCallbackEvents {

    public static final Identifier DESERT_CHESTS_LOOT_TABLE_ID = new Identifier("minecraft", "chests/desert_pyramid");
    public static final Identifier JUNGLE_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/jungle_temple");
    public static final Identifier BURIED_TREASURE_LOOT_TABLE_ID = new Identifier("minecraft", "chests/buried_treasure");
    public static final Identifier SIMPLE_DUNGEON_LOOT_TABLE_ID = new Identifier("minecraft", "chests/simple_dungeon");

    public static void callbackEventsInit(){

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (DESERT_CHESTS_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(BinomialLootTableRange.create(1, 0.3f))
                        .with(ItemEntry.builder(CharlsensideasItems.Da_Coconut_nut_Music_Disc));

                supplier.pool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (JUNGLE_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(BinomialLootTableRange.create(1, 0.5f))
                        .with(ItemEntry.builder(CharlsensideasItems.Revenge_Music_Disc));

                supplier.pool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (BURIED_TREASURE_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(BinomialLootTableRange.create(1, 0.5f))
                        .with(ItemEntry.builder(CharlsensideasItems.Discord_Remix_Music_Disc));

                supplier.pool(poolBuilder);
            }
        });

        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (SIMPLE_DUNGEON_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(BinomialLootTableRange.create(1, 0.6f))
                        .with(ItemEntry.builder(CharlsensideasItems.Dog_Music_Disc));

                supplier.pool(poolBuilder);
            }
        });
  }
}
