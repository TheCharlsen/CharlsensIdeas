package io.github.thecharlsen.charlsensideas.World.Dimension;

import io.github.thecharlsen.charlsensideas.CharlsensideasBlocks;
import io.github.thecharlsen.charlsensideas.CharlsensideasFluids;
import io.github.thecharlsen.charlsensideas.CharlsensideasSoundEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.kyrptonaught.customportalapi.util.CPASoundEventData;
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

        CustomPortalBuilder.beginPortal()
                .frameBlock(CharlsensideasBlocks.Black_Tourmaline_Stone_Bricks)
                .customPortalBlock(CharlsensideasBlocks.TenebrisPortal)
                .destDimID(new Identifier("charlsensideas", "tenebris"))
                .tintColor(55, 89, 195)
                .customIgnitionSource(PortalIgnitionSource.FluidSource(CharlsensideasFluids.Still_Weird_Water))
                .onlyLightInOverworld()
                .registerInPortalAmbienceSound(player -> new CPASoundEventData(CharlsensideasSoundEvents.Block_Tenebris_Portal_Trigger, player.getRandom().nextFloat() * 0.4F + 0.8F, 0.25F))
                .registerPostTPPortalAmbience(player -> new CPASoundEventData(CharlsensideasSoundEvents.Block_Tenebris_Portal_Travel, player.getRandom().nextFloat() * 0.4F + 0.8F, 0.25F))
                .registerPortal();
    }
}
