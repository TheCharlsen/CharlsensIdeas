package com.github.thecharlsen.charlsensideas.World.Features;

import com.github.thecharlsen.charlsensideas.Configs.CloudBlockConfig;
import net.minecraft.world.gen.feature.Feature;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.util.FeatureContext;
import com.github.thecharlsen.charlsensideas.DynamicConfiguration;

import java.util.Random;

public class CloudFeature extends Feature<CloudBlockConfig> {
    private static final Codec<CloudBlockConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockState.CODEC.fieldOf("state").forGetter(CloudBlockConfig::getState),
            Codec.STRING.optionalFieldOf("genType").forGetter(CloudBlockConfig::getGenString),
            Codec.BOOL.fieldOf("flat").forGetter(CloudBlockConfig::isFlat),
            Codec.INT.fieldOf("maxRadius").forGetter(CloudBlockConfig::maxSegments),
            Codec.INT.fieldOf("y").forGetter(CloudBlockConfig::getY)
    ).apply(instance, CloudBlockConfig::new));

    public CloudFeature() {
        super(CODEC);
    }

    @Override
    public boolean generate(FeatureContext<CloudBlockConfig> context) {
        if (context.getConfig().getGenType() == DynamicConfiguration.GeneratorType.LEGACY) {
            return createLegacyBlob(context.getWorld(), context.getRandom(), context.getConfig().state, context.getOrigin());
        } else {
            return (createCloudBlob(context.getWorld(), context.getConfig().state, context.getRandom(), context.getOrigin(), 3, 10, context.getOrigin()) || createCloudBlob(context.getWorld(), context.getConfig().state, context.getRandom(), context.getOrigin().north(3).east(), 3, 8, context.getOrigin()));
        }
    }

    private int randomSign(Random random) {
        int ran = random.nextInt(2);
        if (ran == 0) {
            return -1;
        } else {
            return 1;
        }
    }

    private boolean createLegacyBlob(StructureWorldAccess reader, Random rand, BlockState state, BlockPos pos) {
        BlockPos origin = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos position = new BlockPos(origin.getX() + 8, origin.getY(), origin.getZ() + 8);

        for (int amount = 0; amount < 16; ++amount) {
            int xOffset = rand.nextInt(2);
            int yOffset = (rand.nextBoolean() ? rand.nextInt(3) - 1 : 0);
            int zOffset = rand.nextInt(2);

            position = position.add(xOffset, yOffset, zOffset);

            for (int x = position.getX(); x < position.getX() + rand.nextInt(2) + 3; ++x) {
                for (int y = position.getY(); y < position.getY() + rand.nextInt(1) + 2; ++y) {
                    for (int z = position.getZ(); z < position.getZ() + rand.nextInt(2) + 3; ++z) {
                        BlockPos newPosition = new BlockPos(x, y, z);

                        if (reader.isAir(newPosition)) {
                            if (Math.abs(x - position.getX()) + Math.abs(y - position.getY()) + Math.abs(z - position.getZ()) < 4 + rand.nextInt(2)) {
                                this.setBlockState(reader, newPosition, state);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean createCloudBlob(StructureWorldAccess world, BlockState state, Random random, BlockPos center, int sizex, int sizez, BlockPos origin) {
        for (BlockPos blockPos : BlockPos.iterate(center.add(-sizex * 0.3, -sizex * 0.3, -sizez * 0.3), center.add(sizex * 0.3, sizex * 0.3, sizez * 0.3))) {
            if (testElipsoid(sizex, sizex, sizez, blockPos, center) && (!(world.isAir(blockPos) || world.getBlockState(blockPos) == state.getBlock().getDefaultState()))) {
                return false;
            }
        }
        if (sizex > 0 && sizez > 1) {
            for (int z = -sizez; z <= sizez; z++) {
                int stuffsize = Math.round(sizex*(1f/(Math.max(Math.abs(((float)z)/7), 1))));
                for (int x = center.getX() - stuffsize; x <= center.getX() + stuffsize; x++) {
                    for (int y = center.getY() - Math.round(stuffsize*0.7f); y <= center.getY() + Math.round(stuffsize*0.7f); y++) {
                        if (!((x == center.getX() - stuffsize || x == center.getX() + stuffsize) && (y == center.getY() - stuffsize + 1 || y == center.getY() + stuffsize - 1))) {
                            if (world.getBlockState(new BlockPos(x, y, center.getZ() + z)).isOf(Blocks.AIR)) {
                                if(origin.isWithinDistance(new BlockPos(x, y, center.getZ() + z), 16))
                                    world.setBlockState(new BlockPos(x, y, center.getZ() + z), state, 2);
                            }
                        }
                    }
                }
            }
            center = center.down((random.nextInt(1)+1)*randomSign(random));
            center = center.east((random.nextInt(3)+3)*randomSign(random));
            center = center.north((random.nextInt(3)+3)*randomSign(random));
            createCloudBlob(world, state, random, center, sizex-random.nextInt(1), sizez-random.nextInt(1)-1, origin);
        }

        return true;
    }

    private boolean testElipsoid(int a, int b, int c, BlockPos test, BlockPos center) {
        int x = Math.abs(test.getX() - center.getX());
        int y = Math.abs(test.getY() - center.getY());
        int z = Math.abs(test.getZ() - center.getZ());
        return Math.pow(x, 2) / Math.pow(a, 2) + Math.pow(y, 2) / Math.pow(b, 2) + Math.pow(z, 2) / Math.pow(c, 2)  <= 1;
    }
}
/*
everything in CloudFeature and CloudBlockConfig and DynamicConfiguration belongs to the devs-immortal/The-Aether project.
i am not trying to steal their code i am just using it. I hope i can use it :)
 */
