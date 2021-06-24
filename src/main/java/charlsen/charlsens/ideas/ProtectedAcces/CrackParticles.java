package charlsen.charlsens.ideas.ProtectedAcces;

import net.minecraft.client.particle.CrackParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;

public class CrackParticles extends CrackParticle {
    public CrackParticles(ClientWorld world, double x, double y, double z, ItemStack stack) {
        super(world, x, y, z, stack);
    }
}
