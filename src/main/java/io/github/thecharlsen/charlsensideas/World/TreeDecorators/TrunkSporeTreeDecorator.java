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
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.treedecorator.CocoaBeansTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class TrunkSporeTreeDecorator extends TreeDecorator {
    public static final Codec<TrunkSporeTreeDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(TrunkSporeTreeDecorator::new, (decorator) -> {
        return decorator.probability;
    }).codec();
    private final float probability;

    public TrunkSporeTreeDecorator(float probability) {
        this.probability = probability;
    }

    protected TreeDecoratorType<?> getType() {
        return ChidTreeDecoratorTypes.SPORE_TRUNK;
    }

    public void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, List<BlockPos> logPositions, List<BlockPos> leavesPositions) {
        if (!(random.nextFloat() >= this.probability)) {
            int i = ((BlockPos)logPositions.get(0)).getY();
            logPositions.stream().filter((pos) -> {
                return pos.getY() - i <= 2;
            }).forEach((pos) -> {
                Iterator var4 = Direction.Type.HORIZONTAL.iterator();

                while(var4.hasNext()) {
                    Direction direction = (Direction)var4.next();
                    if (random.nextFloat() <= 0.25F) {
                        Direction direction2 = direction.getOpposite();
                        BlockPos blockPos = pos.add(direction2.getOffsetX(), 0, direction2.getOffsetZ());
                        if (Feature.isAir(world, blockPos)) {
                            replacer.accept(blockPos, (BlockState)((BlockState) CharlsensideasBlocks.Spore.getDefaultState()).with(SporeWallBlock.FACING, direction));
                        }
                    }
                }
            });
        }
    }
}
