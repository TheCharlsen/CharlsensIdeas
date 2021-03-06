package com.github.thecharlsen.charlsensideas;

import com.github.thecharlsen.charlsensideas.Items.FilledJamJarItem;
import com.github.thecharlsen.charlsensideas.ProtectedAcces.MusicDiscItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class CharlsensideasItems {

    public static final Item Secure_Chest_Module = new Item(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_SECCHESTS));
    public static final Item Bornite = new Item(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_ORES));
    public static final Item CHIP = new Item(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_FOOD).food(CharlsensideasFoodComponents.CHIP));
    public static final MusicDiscItem Dog_Music_Disc = new MusicDiscItems(14, CharlsensideasSoundEvents.Dog_Sound_Event, new FabricItemSettings().group(CharlsensideasItemGroup.ITEM_GROUP_MUSIC).maxCount(1).rarity(Rarity.RARE));
    public static final MusicDiscItem Discord_Remix_Music_Disc = new MusicDiscItems(15,CharlsensideasSoundEvents.Discord_Special_Call_Music_Sound_Event, new FabricItemSettings().group(CharlsensideasItemGroup.ITEM_GROUP_MUSIC).maxCount(1).rarity(Rarity.RARE));
    public static final MusicDiscItem Revenge_Music_Disc = new MusicDiscItems(15, CharlsensideasSoundEvents.Revenge_Sound_Event, new FabricItemSettings().group(CharlsensideasItemGroup.ITEM_GROUP_MUSIC).maxCount(1).rarity(Rarity.RARE));
    public static final MusicDiscItem Da_Coconut_nut_Music_Disc = new MusicDiscItems(15, CharlsensideasSoundEvents.Da_Coconut_nut_Sound_Event, new FabricItemSettings().group(CharlsensideasItemGroup.ITEM_GROUP_MUSIC).maxCount(1).rarity(Rarity.EPIC));
    public static final Potion Potion_Of_Blossom = new Potion(new StatusEffectInstance(CharlsensideasStatusEffects.Blossomed, 3600));
    public static final Item Alpine_Strawberry = new AliasedBlockItem(CharlsensideasBlocks.Alpine_Strawberry_Bush, (new Item.Settings()).group(CharlsensideasItemGroup.ITEM_GROUP_FOOD).food(CharlsensideasFoodComponents.Alpine_Strawberry));
    public static final Item Black_Tourmaline_Gem = new Item(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_ORES));
    public static Item Pompon;
    public static final Item Jar = new Item(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_FOOD));
    public static final Item Alpine_Strawberry_Jam_Jar = new FilledJamJarItem(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_FOOD));
    public static final Item CUBE_SPAWN_EGG = new SpawnEggItem(CharlsensideasEntitys.CUBE, 1238, 2849, new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_NATURE));
    public static final Item Ancient_Meal = new Item(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_FOOD));
    public static final Item Ancient_Bread = new Item(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_FOOD).food(CharlsensideasFoodComponents.Ancient_Bread));

    private static Item register(Block block, ItemGroup group) {
        return register(new BlockItem(block, (new Item.Settings()).group(group)));
    }
    private static Item register(BlockItem item) {
        return register((Block)item.getBlock(), (Item)item);
    }

    protected static Item register(Block block, Item item) {
        return register(Registry.BLOCK.getId(block), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return (Item)Registry.register(Registry.ITEM, id, item);
    }

    public static void itemsInit(){

        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "secure_chest_module"), Secure_Chest_Module);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "bornite"), Bornite);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "chip"), CHIP);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas","dog_music_disc"), Dog_Music_Disc);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "discord_remix_music_disc"), Discord_Remix_Music_Disc);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "revenge_music_disc"), Revenge_Music_Disc);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "da_coconut_nut_music_disc"), Da_Coconut_nut_Music_Disc);
        Registry.register(Registry.POTION, new Identifier("charlsensideas", "potion_of_blossom"), Potion_Of_Blossom);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "alpine_strawberry"), Alpine_Strawberry);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "black_tourmaline_gem"), Black_Tourmaline_Gem);
        Pompon = register(CharlsensideasBlocks.Pompon, CharlsensideasItemGroup.ITEM_GROUP_NATURE);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "jar"), Jar);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "alpine_strawberry_jam_jar"), Alpine_Strawberry_Jam_Jar);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "cube_spawn_egg"), CUBE_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "ancient_meal"), Ancient_Meal);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "ancient_bread"), Ancient_Bread);

    }
}
