package io.github.thecharlsen.charlsensideas.World.SurfaceBuilders;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class TenebrisSurfacesBuilderRegistery {

    public static final SurfaceBuilder<TernarySurfaceConfig> TENEBRIS_SURFACE_BUILDER = new TenebrisSurfaceBuilder(TernarySurfaceConfig.CODEC);

    public static void registerSurfaceBuilders() {

        Registry.register(Registry.SURFACE_BUILDER, new Identifier("charlsensideas", "tenebris_surface_builder"), TENEBRIS_SURFACE_BUILDER);
    }
}
