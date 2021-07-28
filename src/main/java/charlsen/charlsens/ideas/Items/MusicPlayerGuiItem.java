package charlsen.charlsens.ideas.Items;

import charlsen.charlsens.ideas.Gui.MusicPlayerGui;
import charlsen.charlsens.ideas.Screens.MusicPlayerScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MusicPlayerGuiItem extends Item {

    public MusicPlayerGuiItem(Settings settings) {
        super(settings);
       
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            MinecraftClient.getInstance().setScreen(new MusicPlayerScreen(new MusicPlayerGui()));
        }
        return super.use(world, user, hand);
    }

}
