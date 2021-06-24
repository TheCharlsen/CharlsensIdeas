package charlsen.charlsens.ideas;

import charlsen.charlsens.ideas.ProtectedAcces.CrackParticles;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.item.ItemStack;

public class CharlsensideasParticleFactories extends ParticleFactories {

    public static void initialize() {
        ParticleFactoryRegistry.getInstance().register(Charlsensideas.spark, ((parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> new CrackParticles(world, x, y, z, new ItemStack(CharlsensideasBlocks.Pompon))));
    }
}
