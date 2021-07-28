package charlsen.charlsens.ideas.Blocks;

import charlsen.charlsens.ideas.CharlsensideasBlockProperties;
import charlsen.charlsens.ideas.CharlsensideasBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

import java.util.Random;

public class DeepAndDirtBlock extends Block {
    public static final BooleanProperty DirtOTP;

    public DeepAndDirtBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(DirtOTP, false));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.UP ? (BlockState)state.with(DirtOTP, isDirt(neighborState)) : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().up());
        return (BlockState)this.getDefaultState().with(DirtOTP, isDirt(blockState));
    }

    private static boolean isDirt(BlockState state) {
        return state.isIn(CharlsensideasBlockTags.Dirtotp);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{DirtOTP});
    }

    static {
        DirtOTP = CharlsensideasBlockProperties.DirtOTP;
    }
}