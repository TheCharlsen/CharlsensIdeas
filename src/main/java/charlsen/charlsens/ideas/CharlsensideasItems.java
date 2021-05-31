package charlsen.charlsens.ideas;

import charlsen.charlsens.ideas.FoodComponents.ChipFoodComponents;
import charlsen.charlsens.ideas.ProtectedAcces.MusicDiscItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class CharlsensideasItems {

    public static final Item Secure_Chest_Module = new Item(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_SECCHESTS));
    public static final Item Bornite = new Item(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_ORES));
    public static final Item CHIP = new Item(new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_FOOD).food(ChipFoodComponents.CHIP));
    public static final MusicDiscItem Dog_Music_Disc = new MusicDiscItems(14, CharlsensideasSoundEvents.Dog_Sound_Event, new FabricItemSettings().group(CharlsensideasItemGroup.ITEM_GROUP_MUSIC).maxCount(1).rarity(Rarity.RARE));
    public static final MusicDiscItem Discord_Remix_Music_Disc = new MusicDiscItems(15,CharlsensideasSoundEvents.Discord_Special_Call_Music_Sound_Event, new FabricItemSettings().group(CharlsensideasItemGroup.ITEM_GROUP_MUSIC).maxCount(1).rarity(Rarity.RARE));
    public static final MusicDiscItem Revenge_Music_Disc = new MusicDiscItems(15, CharlsensideasSoundEvents.Revenge_Sound_Event, new FabricItemSettings().group(CharlsensideasItemGroup.ITEM_GROUP_MUSIC).maxCount(1).rarity(Rarity.RARE));
    public static final MusicDiscItem Da_Coconut_nut_Music_Disc = new MusicDiscItems(15, CharlsensideasSoundEvents.Da_Coconut_nut_Sound_Event, new FabricItemSettings().group(CharlsensideasItemGroup.ITEM_GROUP_MUSIC).maxCount(1).rarity(Rarity.EPIC));

    public static void itemsInit(){

        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "secure_chest_module"), Secure_Chest_Module);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "bornite"), Bornite);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "chip"), CHIP);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas","dog_music_disc"), Dog_Music_Disc);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "discord_remix_music_disc"), Discord_Remix_Music_Disc);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "revenge_music_disc"), Revenge_Music_Disc);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "da_coconut_nut_music_disc"), Da_Coconut_nut_Music_Disc);

    }
}
