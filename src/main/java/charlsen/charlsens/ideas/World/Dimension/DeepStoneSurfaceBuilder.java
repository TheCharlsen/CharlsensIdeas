package charlsen.charlsens.ideas.World.Dimension;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class DeepStoneSurfaceBuilder  extends SurfaceBuilder<TernarySurfaceConfig> {
    public DeepStoneSurfaceBuilder(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }

    @Override
    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int minSurfaceLevel, long seed, TernarySurfaceConfig config) {
        //creates the default surface normally
        SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, minSurfaceLevel, seed, config);

        int xpos = x & 15;
        int zpos = z & 15;
        BlockPos.Mutable blockpos$Mutable = new BlockPos.Mutable();
        int depth = 0;

        // Adds underwater surface blocks that default surface builder cant do.
        for (int ypos = startHeight; ypos >= minSurfaceLevel; --ypos) {
            blockpos$Mutable.set(xpos, ypos, zpos);
            BlockState currentBlockState = chunkIn.getBlockState(blockpos$Mutable);

            if (currentBlockState.getMaterial() != Material.AIR && currentBlockState.getFluidState().isEmpty()) {

                if (ypos <= seaLevel + 2 + Math.max(noise, 0) + random.nextInt(2)) {
                    /*
                    if (depth == 0 &&
                            ModChecker.beeBetterPresent &&
                            noise + random.nextInt(2) < -1)
                    {
                        chunkIn.setBlockState(blockpos$Mutable, BeeBetterRedirection.getBeeswaxBlock(), false);
                    }
                    else
                    */

                    if (currentBlockState == config.getTopMaterial() || currentBlockState == config.getUnderMaterial()) {
                        chunkIn.setBlockState(blockpos$Mutable, config.getUnderwaterMaterial(), false);
                    }
                }

                depth++;
            }
            else{
                depth = 0;
            }
        }
    }
}
