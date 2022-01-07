package io.github.thecharlsen.charlsensideas.Blocks;

import io.github.thecharlsen.charlsensideas.Blocks.BlockEntitys.TenebrisDataHandler;
import io.github.thecharlsen.charlsensideas.Charlsensideas;
import io.github.thecharlsen.charlsensideas.CharlsensideasBlocks;
import io.github.thecharlsen.charlsensideas.World.Dimension.TenebrisDimension;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.Tag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TenebrisGatewayBlock extends Block implements BlockEntityProvider {

    public TenebrisGatewayBlock(Settings properties) {
        super(properties);
    }

    @SuppressWarnings({"ConstantConditions", "NullableProblems"})
    @Override
    public ActionResult onUse(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit) {
        if (!TenebrisDimension.isTenebrisDimension(worldIn)) {
            if(!worldIn.isClient) {
                ServerWorld tenebris =  player.getServer().getWorld(TenebrisDimension.TENEBRIS_WORLD_KEY);
                ServerWorld overWorld = player.getServer().getWorld(Charlsensideas.getOverworldKey());
                tenebris.getBlockState(pos);
                BlockEntity entity = worldIn.getBlockEntity(pos);
                TenebrisDataHandler dataHandler = (TenebrisDataHandler) entity;
                BlockPos atlantisPos;
                BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable(0, 0, 0);

                if (dataHandler.getDestination() != null) {
                    Vec3d vector3d = new Vec3d(dataHandler.getDestination().getX(), dataHandler.getDestination().getY(), dataHandler.getDestination().getZ());
                    sendPlayerToDimension((ServerPlayerEntity) player, tenebris, vector3d);
                    player.sendMessage(Text.of(dataHandler.toString()), true);
                    return ActionResult.SUCCESS;
                }

                for (int y = 0; y < 255; y++) {
                    for (int x = (int) player.getX() - 6; x < (int) player.getX() + 6; x++) {
                        for (int z = (int) player.getZ() - 6; z < (int) player.getZ() + 6; z++) {
                            mutableBlockPos.set(x, y, z);
                            if (tenebris.getBlockState(mutableBlockPos).getBlock() == this.asBlock() && isPortalAt(tenebris, mutableBlockPos)) {
                                atlantisPos = mutableBlockPos.add(0, 1, 0);
                                dataHandler.setDestination(atlantisPos);
                                Vec3d vector3d = new Vec3d(atlantisPos.getX(), atlantisPos.getY(), atlantisPos.getZ());
                                sendPlayerToDimension((ServerPlayerEntity) player, tenebris, vector3d);
                                player.sendMessage(Text.of(dataHandler.toString()), true);
                                return ActionResult.SUCCESS;
                            } else {
                                tenebris.setBlockState(pos, this.asBlock().getDefaultState(), 2);
                                if (tenebris.getBlockState(mutableBlockPos).getBlock() == this.asBlock() && isPortalAt(tenebris, mutableBlockPos)) {
                                    atlantisPos = mutableBlockPos.add(0, 1, 0);
                                    dataHandler.setDestination(atlantisPos);
                                    Vec3d vector3d = new Vec3d(atlantisPos.getX(), atlantisPos.getY(), atlantisPos.getZ());
                                    sendPlayerToDimension((ServerPlayerEntity) player, tenebris, vector3d);
                                    player.sendMessage(Text.of(dataHandler.toString()), true);
                                    return ActionResult.SUCCESS;
                                }
                            }
                        }
                    }
                }
                worldIn.setBlockState(pos, this.asBlock().getDefaultState(), 2);
            } else {
                player.sendMessage(new TranslatableText("Blue Screen Engaging"), true);
                return ActionResult.FAIL;
            }
        } else {
            if (!worldIn.isClient) {
                ServerWorld tenebris =  worldIn.getServer().getWorld(TenebrisDimension.TENEBRIS_WORLD_KEY);
                ServerWorld overWorld = worldIn.getServer().getWorld(Charlsensideas.getOverworldKey());
                if (worldIn != null) {
                    overWorld.getBlockState(pos);
                    BlockEntity entity = worldIn.getBlockEntity(pos);
                    TenebrisDataHandler dataStorage = (TenebrisDataHandler) entity;
                    BlockPos overWorldPos;
                    BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable(0, 0, 0);

                    if (dataStorage.getDestination() != null) {
                        Vec3d vector3d = new Vec3d(dataStorage.getDestination().getX(), dataStorage.getDestination().getY(), dataStorage.getDestination().getZ());
                        sendPlayerToDimension((ServerPlayerEntity) player, overWorld, vector3d);
                        player.sendMessage(new TranslatableText("We Hope You Enjoyed Tenebris, Come Back Soon!"), true);
                        return ActionResult.SUCCESS;
                    }

                    for (int y = 0; y < 255; y++) {
                        for (int x = (int) player.getX() - 6; x < (int) player.getX() + 6; x++) {
                            for (int z = (int) (player.getZ() - 6); z < (int) player.getZ() + 6; z++) {
                                mutableBlockPos.set(x, y, z);
                                if (overWorld.getBlockState(mutableBlockPos).getBlock() == this.asBlock() && isPortalAt(overWorld, mutableBlockPos)) {
                                    overWorldPos = mutableBlockPos.add(0, 1, 0);
                                    dataStorage.setDestination(overWorldPos);
                                    sendPlayerToDimension((ServerPlayerEntity) player, overWorld, new Vec3d(overWorldPos.getX(), overWorldPos.getY(), overWorldPos.getZ()));
                                    player.sendMessage(new TranslatableText("We Hope You Enjoyed Tenebris, Come Back Soon!"), true);
                                    return ActionResult.SUCCESS;
                                } else {
                                    overWorld.setBlockState(pos, this.asBlock().getDefaultState(), 2);
                                    if(overWorld.getBlockState(mutableBlockPos).getBlock() == this.asBlock() && isPortalAt(overWorld, mutableBlockPos)) {
                                        overWorldPos = mutableBlockPos.add(0, 1, 0);
                                        dataStorage.setDestination(overWorldPos);
                                        sendPlayerToDimension((ServerPlayerEntity) player, overWorld, new Vec3d(overWorldPos.getX(), overWorldPos.getY(), overWorldPos.getZ()));
                                        player.sendMessage(new TranslatableText("shhhhhhhhhhhhhhhhhhhhhhzzzzzzzzzzzz"), true);
                                        return ActionResult.SUCCESS;
                                    }
                                }
                            }
                        }
                    }
                    worldIn.setBlockState(pos, this.asBlock().getDefaultState(), 2);
                } else {
                    player.sendMessage(new TranslatableText("Nope"), true);
                    return ActionResult.FAIL;
                }
            }
        }
        player.sendMessage(new TranslatableText("We Hope You Enjoyed Tenebris, Come Back Soon!"), true);
        return ActionResult.PASS;
    }

    private boolean isPortalAt(ServerWorld world, BlockPos pos) {
        return world.getBlockState(pos).isIn(getPortal());
    }

    public Tag<Block> getPortal(){
        Tag<Block> portal = new Tag<Block>() {
            @Override
            public boolean contains(Block element) {
                return true;
            }

            @Override
            public List<Block> values() {
                List<Block> portal2 = new ArrayList<Block>();
                portal2.add(CharlsensideasBlocks.TenebrisPortal);
                return portal2;
            }
        };
        return portal;
    }

    public static RegistryKey<World> getOverworldKey() {
        Identifier OVERWORLD_ID = DimensionOptions.OVERWORLD.getValue();
        return RegistryKey.of(Registry.WORLD_KEY, OVERWORLD_ID);
    }

    public static void sendPlayerToDimension(ServerPlayerEntity serverPlayer, ServerWorld targetWorld, Vec3d targetVec) {
        // ensure destination chunk is loaded before we put the player in it
        targetWorld.getChunk(new BlockPos(targetVec));
        serverPlayer.teleport(targetWorld, targetVec.getX(), targetVec.getY(), targetVec.getZ(), serverPlayer.getYaw(), serverPlayer.getPitch());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TenebrisDataHandler(pos, state);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView worldIn, BlockPos pos) {
        return 1.0F;
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView reader, BlockPos pos) {
        return true;
    }

    @Override
    public VoxelShape getCameraCollisionShape(BlockState state, BlockView reader, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }
}
