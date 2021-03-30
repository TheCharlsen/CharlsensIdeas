package charlsen.charlsens.ideas;

import charlsen.charlsens.ideas.MusicPlayer.MusicPlayerGui;
import charlsen.charlsens.ideas.MusicPlayer.MusicPlayerGuiItem;
import charlsen.charlsens.ideas.MusicPlayer.MusicPlayerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class  CharlsensIdeasClientModInitializer implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(charlsensideas.TestSapling, RenderLayer.getCutout());

    }


}