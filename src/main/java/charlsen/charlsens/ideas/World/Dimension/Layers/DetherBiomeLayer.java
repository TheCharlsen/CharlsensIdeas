package charlsen.charlsens.ideas.World.Dimension.Layers;

import charlsen.charlsens.ideas.Charlsensideas;
import charlsen.charlsens.ideas.World.Dimension.DetherBiomeProvider;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.OctaveSimplexNoiseSampler;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import net.minecraft.world.gen.ChunkRandom;

import java.util.stream.IntStream;

public enum DetherBiomeLayer implements InitLayer {
    INSTANCE;

        private static final Identifier SUGAR_WATER = new Identifier(Charlsensideas.MODID, "sugar_water_floor");
        private static final Identifier HIVE_WALL = new Identifier(Charlsensideas.MODID, "hive_wall");

        private static OctaveSimplexNoiseSampler perlinGen;
//	private double max = -100;
//	private double min = 100;

        @Override
        public int sample (LayerRandomnessSource noise,int x, int z){
            double perlinNoise = perlinGen.sample((double) x * 0.1D, (double) z * 0.0001D, false);
//
//		max = Math.max(max, perlinNoise);
//		min = Math.min(min, perlinNoise);
//		Bumblezone.LOGGER.log(Level.INFO, "Max: " + max +", Min: "+min + ", perlin: "+perlinNoise);

            if (Math.abs(perlinNoise) % 0.1D < 0.07D) {
                return DetherBiomeProvider.layersBiomeRegistry.getRawId(DetherBiomeProvider.layersBiomeRegistry.get(HIVE_WALL));
            } else {
                return DetherBiomeProvider.layersBiomeRegistry.getRawId(DetherBiomeProvider.layersBiomeRegistry.get(SUGAR_WATER));
            }
        }


        public static void setSeed ( long seed){
            if (perlinGen == null) {
                ChunkRandom sharedseedrandom = new ChunkRandom(seed);
                perlinGen = new OctaveSimplexNoiseSampler(sharedseedrandom, IntStream.rangeClosed(-1, 0));
            }
        }
    }
