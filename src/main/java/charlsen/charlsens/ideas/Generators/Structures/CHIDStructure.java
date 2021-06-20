package charlsen.charlsens.ideas.Generators.Structures;

import charlsen.charlsens.ideas.Utils.StructureUtils;
import charlsen.charlsens.ideas.World.CharlsensideasStructureFeature;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class CHIDStructure extends StructureFeature<StructurePoolFeatureConfig> {
    final boolean field_25836;
    final boolean surface;
    private final int structureStartY;

    public CHIDStructure() {
        this(0);
    }

    public CHIDStructure(int structureStartY) {
        this(structureStartY, true, true);
    }

    public CHIDStructure(int structureStartY, boolean field_25836, boolean surface) {
        super(StructurePoolFeatureConfig.CODEC);
        this.structureStartY = structureStartY;
        this.field_25836 = field_25836;
        this.surface = surface;
    }


    @Override
    public StructureStartFactory<StructurePoolFeatureConfig> getStructureStartFactory() {
        return CHIDStructure.Start::new;
    }

    @SuppressWarnings("ObjectAllocationInLoop")
    @Override
    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long worldSeed, ChunkRandom random, ChunkPos pos, Biome biome, ChunkPos chunkPos, StructurePoolFeatureConfig config, HeightLimitView world) {

        //cannot be near other specified structure
        StructureConfig configBarnHouse = chunkGenerator.getStructuresConfig().getForType(CharlsensideasStructureFeature.BARN_HOUSE_SF);

              if (configBarnHouse != null) {
                    ChunkPos possibleBarnhousePos = CharlsensideasStructureFeature.BARN_HOUSE_SF.getStartChunk(configBarnHouse, worldSeed, random, k, m);
                    if (k == possibleBarnhousePos.x && m == possibleBarnhousePos.z && this != CharlsensideasStructureFeature.BARN_HOUSE_SF) {
                        return false;
                    }
                }

        return true;
    }

    public static class Start extends MarginedStructureStart<StructurePoolFeatureConfig> {
        public Start(StructureFeature<StructurePoolFeatureConfig> s, ChunkPos c, int i, long l) {
            super(s, c, i, l);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, ChunkPos pos, Biome biome, StructurePoolFeatureConfig config, HeightLimitView world) {
            CHIDStructure structure = (CHIDStructure) this.getFeature();
            StructureUtils.initPools();
            StructurePoolBasedGenerator.method_30419(registryManager, config, PoolStructurePiece::new, chunkGenerator, manager, new BlockPos(pos.x << 4, structure.structureStartY, pos.z << 4), this, this.random, structure.field_25836, structure.surface, world);
            this.setBoundingBoxFromChildren();
        }
    }

}
