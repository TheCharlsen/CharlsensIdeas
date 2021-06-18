package charlsen.charlsens.ideas.World.Dimension;

import charlsen.charlsens.ideas.Charlsensideas;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class DetherSurfaceBuilder {
    public static final SurfaceBuilder<TernarySurfaceConfig> HONEY_SURFACE_BUILDER = new DeepStoneSurfaceBuilder(TernarySurfaceConfig.CODEC);

    public static void registerSurfaceBuilders() {
        Registry.register(Registry.SURFACE_BUILDER, new Identifier(Charlsensideas.MODID, "honey_surface_builder"), HONEY_SURFACE_BUILDER);
    }
}
