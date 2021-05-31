package charlsen.charlsens.ideas.Features;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class StoneSpiralFeature extends Feature<DefaultFeatureConfig> {
    public StoneSpiralFeature(Codec<DefaultFeatureConfig> config) {
        super(config);
    }



    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos,
                            DefaultFeatureConfig config) {
        BlockPos topPos = world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos);
        Direction offset = Direction.NORTH;

        for (int y = 0; y <= 6; y++) {
            world.setBlockState(topPos.up(y).offset(offset), Blocks.DIAMOND_BLOCK.getDefaultState(), 1);
        }
        for (int x = 1; x <= 20; x++){
            world.setBlockState(topPos.add(1 ,6, 2).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int z = 1; z <= 20; z++){
            world.setBlockState(topPos.add(1 ,6, 1).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int q = 1; q <= 20; q++){
            world.setBlockState(topPos.add(2 ,6, 1).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int w = 1; w <= 20; w++){
            world.setBlockState(topPos.add(-1 ,6, 2).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int e = 1; e <= 20; e++){
            world.setBlockState(topPos.add(-1 ,6, 1).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int r = 1; r <= 20; r++){
            world.setBlockState(topPos.add(-2 ,6, 1).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int t = 1; t <= 20; t++){
            world.setBlockState(topPos.add(-1 ,6, -2).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int z = 1; z <= 20; z++){
            world.setBlockState(topPos.add(-1 ,6, -1).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int u = 1; u <= 20; u++){
            world.setBlockState(topPos.add(-2 ,6, -1).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int i = 1; i <= 20; i++){
            world.setBlockState(topPos.add(1 ,6, -2).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int o = 1; o <= 20; o++){
            world.setBlockState(topPos.add(1 ,6, -1).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int p = 1; p <= 20; p++){
            world.setBlockState(topPos.add(2 ,6, -1).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int f = 1; f <= 20; f++){
            world.setBlockState(topPos.add(0 ,6, 1).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int g = 1; g <= 20; g++){
            world.setBlockState(topPos.add(0 ,6, 2).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int h = 1; h <= 20; h++){
            world.setBlockState(topPos.add(-1 ,6, 0).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int j = 1; j <= 20; j++){
            world.setBlockState(topPos.add(-2 ,6, 0).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int h = 1; h <= 20; h++){
            world.setBlockState(topPos.add(0 ,6, -1).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int j = 1; j <= 20; j++){
            world.setBlockState(topPos.add(0 ,6, -2).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int h = 1; h <= 20; h++){
            world.setBlockState(topPos.add(1 ,6, 0).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int j = 1; j <= 20; j++){
            world.setBlockState(topPos.add(2 ,6, 0).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int j = 1; j <= 20; j++){
            world.setBlockState(topPos.add(0 ,7, 0).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int j = 1; j <= 20; j++){
            world.setBlockState(topPos.add(-1 ,7, 0).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int j = 1; j <= 20; j++){
            world.setBlockState(topPos.add(1 ,7, 0).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int j = 1; j <= 20; j++){
            world.setBlockState(topPos.add(0 ,7, 1).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        for (int j = 1; j <= 20; j++){
            world.setBlockState(topPos.add(0 ,7, -1).offset(offset), Blocks.LAPIS_BLOCK.getDefaultState(), 10);
        }
        return true;
    }

}
