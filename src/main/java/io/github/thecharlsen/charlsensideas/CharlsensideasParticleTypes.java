package io.github.thecharlsen.charlsensideas;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CharlsensideasParticleTypes {

    public static final DefaultParticleType Oil_Pop = FabricParticleTypes.simple();

    public static void init() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier(Charlsensideas.MOD_ID, "oil_pop"), Oil_Pop);
    }

    public static void initClient() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(Charlsensideas.MOD_ID, "particle/oil_pop"));
        }));

        ParticleFactoryRegistry.getInstance().register(Oil_Pop, FlameParticle.Factory::new);
    }
}
