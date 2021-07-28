package charlsen.charlsens.ideas.World.Features;

import charlsen.charlsens.ideas.Configs.CloudBlockConfig;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class Features<FC extends FeatureConfig> {

    public static final Feature<CloudBlockConfig> CLOUD;

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return (F) Registry.register(Registry.FEATURE, name, feature);
    }

    static {
        CLOUD = register("cloud", new CloudFeature());
    }
}
