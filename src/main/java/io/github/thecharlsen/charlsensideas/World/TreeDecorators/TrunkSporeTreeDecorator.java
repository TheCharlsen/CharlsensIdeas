package io.github.thecharlsen.charlsensideas.World.TreeDecorators;

import com.mojang.serialization.Codec;
import io.github.thecharlsen.charlsensideas.Blocks.SporeWallBlock;
import io.github.thecharlsen.charlsensideas.CharlsensideasBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CocoaBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.treedecorator.CocoaBeansTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class TrunkSporeTreeDecorator extends TreeDecorator {
    public static final Codec<TrunkSporeTreeDecorator> CODEC = Codec.floatRange(0.0F, 0.05F).fieldOf("probability").xmap(TrunkSporeTreeDecorator::new, (decorator) -> {
        return decorator.probability;
    }).codec();
    private final float probability;

    public TrunkSporeTreeDecorator(float probability) {
        this.probability = probability;
    }

    protected TreeDecoratorType<?> getType() {
        return ChidTreeDecoratorTypes.SPORE_TRUNK;
    }

    @Override
    public void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, List<BlockPos> logPositions, List<BlockPos> leavesPositions) {
        ChunkRegion world1 = (ChunkRegion) world;

        for (BlockPos pos : logPositions) {
            Direction dir = Direction.fromHorizontal(random.nextInt(4));

            if (world1.getBlockState(pos.offset(dir)).isAir()) {
                world1.setBlockState(pos.offset(dir), CharlsensideasBlocks.Spore.getDefaultState().with(SporeWallBlock.FACING, dir), 3);
            }
        }
    }
}
