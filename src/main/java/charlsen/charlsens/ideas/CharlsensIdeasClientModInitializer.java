package charlsen.charlsens.ideas;

import charlsen.charlsens.ideas.MusicPlayer.MusicPlayerGuiItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class  CharlsensIdeasClientModInitializer implements ClientModInitializer {

    public static Item MUSICPLAYER = new MusicPlayerGuiItem(new Item.Settings().group(Item_Group.ITEM_GROUP_MUSIC).maxCount(1));

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(charlsensideas.TestSapling, RenderLayer.getCutout());
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "musicplayer"), MUSICPLAYER);
    }
}
