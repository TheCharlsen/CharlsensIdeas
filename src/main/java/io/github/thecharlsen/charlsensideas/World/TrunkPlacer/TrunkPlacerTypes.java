package io.github.thecharlsen.charlsensideas.World.TrunkPlacer;

import com.mojang.serialization.Codec;
import io.github.thecharlsen.charlsensideas.Charlsensideas;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TrunkPlacerTypes {
    public static TrunkPlacerType<RankTrunkPlacer> OVERGROWN_TRUNK;
    private static Constructor<FoliagePlacerType> foliageConstructor;
    private static Constructor<TrunkPlacerType> trunkConstructor;

    static {
        try {
            foliageConstructor = FoliagePlacerType.class.getDeclaredConstructor(Codec.class);
            foliageConstructor.setAccessible(true);
            trunkConstructor = TrunkPlacerType.class.getDeclaredConstructor(Codec.class);
            trunkConstructor.setAccessible(true);
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }
    }

    public static <P extends FoliagePlacer> FoliagePlacerType<P> registerFoliage(String name, Codec<P> codec) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return Registry.register(Registry.FOLIAGE_PLACER_TYPE, Charlsensideas.locate(name), foliageConstructor.newInstance(codec));
    }

    public static <P extends TrunkPlacer> TrunkPlacerType<P> registerTrunk(String name, Codec<P> codec) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return Registry.register(Registry.TRUNK_PLACER_TYPE, Charlsensideas.locate(name), trunkConstructor.newInstance(codec));
    }

    public static void init() {
        try {
            OVERGROWN_TRUNK = registerTrunk("overgrown_trunk_placer", RankTrunkPlacer.CODEC);
            foliageConstructor.setAccessible(false);
            trunkConstructor.setAccessible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
