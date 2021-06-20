package charlsen.charlsens.ideas.Utils;

import charlsen.charlsens.ideas.Charlsensideas;
import charlsen.charlsens.ideas.Generators.Structures.BarnHouseGenerator;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.world.biome.SpawnSettings;

public class StructureUtils {

    public static final Pool<SpawnSettings.SpawnEntry> BARN_HOUSE_SPAWNS = Pool.of(new SpawnSettings.SpawnEntry(EntityType.COW, 1, 2, 5), new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 1, 3, 6), new SpawnSettings.SpawnEntry(EntityType.SHEEP, 1, 3, 4));

    public static final Identifier BARN_HOUSE = Charlsensideas.id("barn_house");

    public static void initPools() {
        BarnHouseGenerator.init();
    }
}
