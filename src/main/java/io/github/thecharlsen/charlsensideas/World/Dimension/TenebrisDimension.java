package io.github.thecharlsen.charlsensideas.World.Dimension;

import io.github.thecharlsen.charlsensideas.Charlsensideas;
import io.github.thecharlsen.charlsensideas.World.Biomes.TenebrisBiomeSource;
import io.github.thecharlsen.charlsensideas.World.SurfaceBuilders.TenebrisSurfacesBuilderRegistery;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class TenebrisDimension {

    public static final RegistryKey<World> TENEBRIS_WORLD = RegistryKey.of(Registry.WORLD_KEY, new Identifier("charlsensideas:tenebris"));
    public static final RegistryKey<DimensionType> TENEBRIS_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, new Identifier("charlsensideas:tenebris"));

    public static DimensionType TENEBRIS_TYPE;

    public static ServerWorld TENEBRIS_DIMENSION;

    public static boolean isTenebrisDimension(World world) {
        return world != null && world.getRegistryKey().equals(TENEBRIS_WORLD);
    }

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            TenebrisDimension.TENEBRIS_TYPE = server.getRegistryManager().get(Registry.DIMENSION_TYPE_KEY).get(TENEBRIS_DIMENSION_TYPE_KEY);
            TenebrisDimension.TENEBRIS_DIMENSION = server.getWorld(TENEBRIS_WORLD);
        });
    }

    public static void setupSurfaceBuilders(){
        TenebrisSurfacesBuilderRegistery.registerSurfaceBuilders();
    }

    public static void registerBiomeSources() {
        Registry.register(Registry.BIOME_SOURCE, new Identifier(Charlsensideas.MODID, "tenebris_biome_source"), TenebrisBiomeSource.CODEC);
    }
}
