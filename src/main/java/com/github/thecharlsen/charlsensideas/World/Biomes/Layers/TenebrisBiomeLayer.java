package com.github.thecharlsen.charlsensideas.World.Biomes.Layers;

import com.github.thecharlsen.charlsensideas.World.Biomes.TenebrisBiomeSource;
import net.minecraft.util.math.noise.OctaveSimplexNoiseSampler;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import net.minecraft.world.gen.ChunkRandom;

import java.util.stream.IntStream;

public class TenebrisBiomeLayer implements InitLayer {

    private final Registry<Biome> dynamicRegistry;
    private static OctaveSimplexNoiseSampler perlinGen;

    public TenebrisBiomeLayer(long seed, Registry<Biome> dynamicRegistry){
        this.dynamicRegistry = dynamicRegistry;

        if (perlinGen == null)
        {
            ChunkRandom sharedseedrandom = new ChunkRandom(seed);
            perlinGen = new OctaveSimplexNoiseSampler(sharedseedrandom, IntStream.rangeClosed(0, 0));
        }
    }

    public int sample(LayerRandomnessSource noise, int x, int z) {
        double perlinNoise = perlinGen.sample(x * 0.055D, z * 0.055D, false);

        if(perlinNoise > 0.30) {
            return this.dynamicRegistry.getRawId(this.dynamicRegistry.get(TenebrisBiomeSource.Umbra));
        }
        else {
            return this.dynamicRegistry.getRawId(this.dynamicRegistry.get(TenebrisBiomeSource.Ilfty));
        }
    }

    public static void setSeed(long seed) {
        ChunkRandom sharedseedrandom = new ChunkRandom(seed);
        System.out.println(sharedseedrandom);
    }
}
