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

    public static TrunkPlacerType<RankTrunkPlacer> RANK_TRUNK_PLACER_TYPE;
    private static Constructor<TrunkPlacerType> trunkConstructor;

    static {
        try {
            trunkConstructor = TrunkPlacerType.class.getDeclaredConstructor(Codec.class);
            trunkConstructor.setAccessible(true);
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }
    }

    public static <P extends TrunkPlacer> TrunkPlacerType<P> registerTrunk(String name, Codec<P> codec) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return Registry.register(Registry.TRUNK_PLACER_TYPE, Charlsensideas.locate(name), trunkConstructor.newInstance(codec));
    }

    public static void init() {
        try {
            RANK_TRUNK_PLACER_TYPE = registerTrunk("rank_trunk_placer_type", RankTrunkPlacer.CODEC);
            trunkConstructor.setAccessible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}