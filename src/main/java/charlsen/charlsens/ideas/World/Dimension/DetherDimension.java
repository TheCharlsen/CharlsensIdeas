package charlsen.charlsens.ideas.World.Dimension;

import charlsen.charlsens.ideas.Charlsensideas;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class DetherDimension {
    public static final RegistryKey<World> DETHER_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY, Charlsensideas.MOD_DIMENSION_ID);

    public static void setupDimension() {
        DetherChunkGenerator.registerChunkgenerator();
        DetherBiomeProvider.registerBiomeProvider();

        DetherSurfaceBuilder.registerSurfaceBuilders();
    }
}
