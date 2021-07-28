package charlsen.charlsens.ideas.World.SurfaceBuilders;

import charlsen.charlsens.ideas.CharlsensideasBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class TenebrisSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {
    public TenebrisSurfaceBuilder(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }

    @Override
    public void generate(Random random, Chunk chunk, Biome biome, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int minSurfaceLevel, long seed, TernarySurfaceConfig surfaceConfig) {
        SurfaceBuilder.DEFAULT.generate(random, chunk, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, minSurfaceLevel, seed, surfaceConfig);

        int xpos = x & 15;
        int zpos = z & 15;

        for (int ypos = startHeight; ypos >= minSurfaceLevel; --ypos) {
            BlockPos blockpos = new BlockPos(xpos, ypos, zpos);
            BlockState currentBlockState = chunk.getBlockState(blockpos);

            if (ypos >= 30 && ypos <= 31){
                chunk.setBlockState(blockpos, CharlsensideasBlocks.Cobbled_Black_Tourmaline_Stone.getDefaultState(), false);
            }
        }
    }
}
