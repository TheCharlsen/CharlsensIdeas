package charlsen.charlsens.ideas.World;

import charlsen.charlsens.ideas.Generators.Structures.CHIDStructure;
import charlsen.charlsens.ideas.Utils.RegUtils;
import charlsen.charlsens.ideas.Utils.StructureUtils;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class CharlsensideasStructureFeature {

    public static final StructureFeature<StructurePoolFeatureConfig> BARN_HOUSE_SF = new CHIDStructure();

    public static void registerStructures() {
        RegUtils.registerStructure(StructureUtils.BARN_HOUSE, BARN_HOUSE_SF, CharlsensideasConfiguredFeatures.BARN_HOUSE);
    }
}
