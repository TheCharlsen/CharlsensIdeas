package io.github.thecharlsen.charlsensideas;

import com.glisco.owo.itemgroup.OwoItemSettings;
import io.github.thecharlsen.charlsensideas.Blocks.*;
import io.github.thecharlsen.charlsensideas.Blocks.Interfaces.NightShade;
import io.github.thecharlsen.charlsensideas.Generators.PineTreeGenerator;
import io.github.thecharlsen.charlsensideas.Generators.UmbraTreeGenerator;
import io.github.thecharlsen.charlsensideas.ProtectedAcces.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import net.minecraft.util.dynamic.RegistryOps;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import static net.minecraft.block.Blocks.NETHER_PORTAL;

public class CharlsensideasBlocks {

    public static final Block MuddedDirt = new Block(FabricBlockSettings.of(Material.SOIL).strength(1F, 1F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block HardenedMuddedDirt = new Block(FabricBlockSettings.of(Material.STONE).strength(2F, 2F).sounds(BlockSoundGroup.STONE));
    public static final Block Bornite_Ore = new BorniteOreBlock(FabricBlockSettings.of(Material.STONE).strength(1F, 1F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().luminance((state) -> { return 15;}));
    public static final Block Black_Tourmaline_Stone = new Block(FabricBlockSettings.of(Material.STONE).strength(6F, 6F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block PineLeaves = new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).strength(0.5F, 0.5F).nonOpaque());
    public static final SaplingBlock PineSapling = new SaplingBlocks(new PineTreeGenerator(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block PineLog = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(1.5F, 1.5F).sounds(BlockSoundGroup.WOOD));
    public static final Block Weirdly_Black_Tourmaline_Stone = new WeirdlyDeepStoneBlock(FabricBlockSettings.of(Material.STONE).strength(14F, 13F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).luminance((state) -> { return 4;}));
    public static Block Weird_Water;
    public static final Block Pompon = new FlowerBlock(CharlsensideasStatusEffects.Blossomed, 9, FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block CloudBlock = new CloudBlock(FabricBlockSettings.of(Material.WOOL).strength(1F, 1F).sounds(BlockSoundGroup.SNOW).noCollision());
    public static final Block Cobbled_Black_Tourmaline_Stone = new DeepAndDirtBlock(FabricBlockSettings.copyOf(Blocks.STONE).of(Material.STONE).strength(6F, 6F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block Weird_Grass_Block = new WeirdGrassBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(1F, 1F).sounds(BlockSoundGroup.GRASS).ticksRandomly());
    public static final Block Umbra_Log = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(3F, 2.5F).sounds(BlockSoundGroup.WOOD).breakByHand(false).breakByTool(FabricToolTags.AXES, 3));
    public static final Block Umbra_Leaves = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).of(Material.LEAVES).strength(0.5F, 0.5F).sounds(BlockSoundGroup.GRASS).nonOpaque().breakByHand(false).breakByTool(FabricToolTags.SHEARS));
    public static final SaplingBlock Umbra_Sapling = new UmbraSaplingBlock(new UmbraTreeGenerator(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block Alpine_Strawberry_Bush = new AlpineStrawberryBushBlock(FabricBlockSettings.of(Material.PLANT).ticksRandomly().breakInstantly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).nonOpaque());
    public static final Block Weird_Dirt = new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(1.5F, 0.5F).sounds(BlockSoundGroup.CROP));
    public static final Block Chiseled_Black_Tourmaline_Stone = new Block(FabricBlockSettings.of(Material.STONE).strength(6F, 6F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block Black_Tourmaline_Stone_Bricks = new Block(FabricBlockSettings.of(Material.STONE).strength(6F, 6F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block Cracked_Black_Tourmaline_Stone_Bricks = new Block(FabricBlockSettings.of(Material.STONE).strength(6F, 6F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block Polished_Black_Tourmaline_Stone = new Block(FabricBlockSettings.of(Material.STONE).strength(6F, 6F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block Cobbled_Black_Tourmaline_Stone_Stairs = new StairsBlocks(Cobbled_Black_Tourmaline_Stone.getDefaultState(), AbstractBlock.Settings.copy(Cobbled_Black_Tourmaline_Stone));
    public static final Block Polished_Black_Tourmaline_Stone_Stairs = new StairsBlocks(Polished_Black_Tourmaline_Stone.getDefaultState(), AbstractBlock.Settings.copy(Polished_Black_Tourmaline_Stone));
    public static final Block Chiseled_Black_Tourmaline_Stone_Stairs = new StairsBlocks(Chiseled_Black_Tourmaline_Stone.getDefaultState(), AbstractBlock.Settings.copy(Chiseled_Black_Tourmaline_Stone));
    public static final Block Black_Tourmaline_Stone_Brick_Stairs = new StairsBlocks(Black_Tourmaline_Stone_Bricks.getDefaultState(), AbstractBlock.Settings.copy(Black_Tourmaline_Stone_Bricks));
    public static final Block Black_Tourmaline_Stone_Cracked_Brick_Stairs = new StairsBlocks(Cracked_Black_Tourmaline_Stone_Bricks.getDefaultState(), AbstractBlock.Settings.copy(Cracked_Black_Tourmaline_Stone_Bricks));
    public static final Block Black_Tourmaline_Stone_Pillar = new PillarBlock(FabricBlockSettings.of(Material.STONE).strength(6F, 6F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block Cobbled_Black_Tourmaline_Stone_Slab = new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(6F, 6F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block Polished_Black_Tourmaline_Stone_Slab = new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(6F, 6F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block Chiseled_Black_Tourmaline_Stone_Slab = new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(6F, 6F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block Black_Tourmaline_Stone_Brick_Slab = new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(6F, 6F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block Black_Tourmaline_Stone_Cracked_Brick_Slab = new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(6F, 6F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2));
    public static final Block Alpine_Strawberry_Cake = new CakeBlocks(FabricBlockSettings.of(Material.CAKE).strength(0.5F).sounds(BlockSoundGroup.WOOL));
    public static final TenebrisGatewayBlock TenebrisGateway = new TenebrisGatewayBlock(FabricBlockSettings.of(Material.PORTAL).strength(0.1F).sounds(BlockSoundGroup.STONE).breakByHand(true).nonOpaque());
    public static final Block Ancient_Groats = new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(0.7F, 1.0F).sounds(BlockSoundGroup.CROP).breakByHand(true));
    public static final Block Umbra_Planks = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Stripped_Umbra_Wood = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Lavender = new TallFlowerBlock(FabricBlockSettings.of(Material.PLANT).strength(0.2F, 0.2F).sounds(BlockSoundGroup.GRASS).noCollision());
    public static final Block Spore = new SporeWallBlock(FabricBlockSettings.of(Material.PLANT).strength(0.1F, 0.1F).sounds(BlockSoundGroup.MOSS_BLOCK).noCollision());
    public static final TenebrisPortalBlock TenebrisPortal = new TenebrisPortalBlock(FabricBlockSettings.copyOf(NETHER_PORTAL).of(Material.GLASS).strength(1000F, 10F).blockVision(CharlsensideasBlocks::never).mapColor(MapColor.GREEN).noCollision());
    public static final Block RingLeaf = new RingLeafBlock(FabricBlockSettings.of(Material.PLANT).strength(0.01F).sounds(BlockSoundGroup.BIG_DRIPLEAF));
    public static final Block RingLeafStem = new RingLeafStemBlock(FabricBlockSettings.of(Material.PLANT).strength(0.01F).sounds(BlockSoundGroup.BIG_DRIPLEAF));
    public static final Block Press = new PressBlock(FabricBlockSettings.of(Material.METAL));
    public static final Block Steel_Ore = new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(3F, 2F));
    public static Block Oil;
    public static final Block NightShadeBlock = new NightShadeBlock(FabricBlockSettings.of(Material.PLANT).sounds(BlockSoundGroup.MOSS_BLOCK).strength(0.5F, 0.5F).nonOpaque().noCollision().ticksRandomly().luminance(NightShade.getLuminanceSupplier(12)));
    public static final Block ClayStone = new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(3.5F, 4F));
    public static final Block Thorns = new ThornsBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.LILY_PAD));
    public static final Block ThornsPlant = new ThornsPlantBlock(FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.LILY_PAD));
    public static final Block Stripped_Umbra_Log = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Umbra_Wood = new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD).of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Ilfty_Log = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Bebusn_Log = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Ginkgo_Log = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Naveli_Log = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Umbra_Slab = new SlabBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F));
    public static final Block Umbra_Stairs = new StairsBlocks(Umbra_Planks.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Umbra_Fence = new FenceBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Umbra_Fence_Gate = new FenceGateBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Bebusn_Planks = new Block(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Stripped_Bebusn_Log = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Stripped_Bebusn_Wood = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Bebusn_Wood = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Bebusn_Leaves = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).of(Material.LEAVES).strength(0.5F, 0.5F).sounds(BlockSoundGroup.GRASS).breakByHand(false).breakByTool(FabricToolTags.SHEARS).nonOpaque());
    public static final Block Umbra_Button = new WoodenButtonBlocks(FabricBlockSettings.of(Material.WOOD).strength(0.5F).sounds(BlockSoundGroup.WOOD).noCollision());
    public static final Block Umbra_Pressure_Plate = new PressurePlateBlocks(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.WOOD).strength(0.5F).sounds(BlockSoundGroup.WOOD).noCollision());
    public static final Block Bebusn_Door = new DoorBlocks(FabricBlockSettings.of(Material.WOOD).strength(3.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block Bebusn_Trapdoor = new TrapdoorBlocks(FabricBlockSettings.of(Material.WOOD).strength(3.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block Bebusn_Slab = new SlabBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0F, 2.0F));
    public static final Block Bebusn_Stairs = new StairsBlocks(Bebusn_Planks.getDefaultState(), FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Bebusn_Fence = new FenceBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Bebusn_Fence_Gate = new FenceGateBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F, 2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block Bebusn_Button = new WoodenButtonBlocks(FabricBlockSettings.of(Material.WOOD).strength(0.5F).sounds(BlockSoundGroup.WOOD).noCollision());
    public static final Block Bebusn_Pressure_Plate = new PressurePlateBlocks(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.WOOD).strength(0.5F).sounds(BlockSoundGroup.WOOD).noCollision());
    public static final CharlsensideasSignBlock Bebusn_Standing_Sign = new CharlsensideasSignBlock(new Identifier("charlsensideas", "entity/sign/bebusn"), FabricBlockSettings.copyOf(Blocks.OAK_SIGN));
    public static final Block Bebusn_Wall_Sign = new CharlsensideasWallSignBlock(new Identifier("charlsensideas", "entity/sign/bebusn"), FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN));
    public static final CharlsensideasSignBlock Umbra_Standing_Sign = new CharlsensideasSignBlock(new Identifier("charlsensideas", "entity/sign/umbra"), FabricBlockSettings.copyOf(Blocks.OAK_SIGN));
    public static final Block Umbra_Wall_Sign = new CharlsensideasWallSignBlock(new Identifier("charlsensideas", "entity/sign/umbra"), FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN));

    public static boolean never(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        return false;
    }

    public static void blocksInit() {

        //Flammable
        FlammableBlockRegistry.getDefaultInstance().add(Umbra_Wood, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Umbra_Log, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Umbra_Planks, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Stripped_Umbra_Log, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Stripped_Umbra_Wood, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Umbra_Leaves, 8, 10);
        FlammableBlockRegistry.getDefaultInstance().add(Umbra_Slab, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Umbra_Stairs, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Umbra_Fence, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Umbra_Fence_Gate, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Bebusn_Planks, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Stripped_Bebusn_Log, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Stripped_Bebusn_Wood, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Bebusn_Wood, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Bebusn_Log, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(Bebusn_Leaves, 8, 10);


        //Blocks
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "bornite_ore"), Bornite_Ore);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "mudded_dirt"), MuddedDirt);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "hardened_mudded_dirt"), HardenedMuddedDirt);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "black_tourmaline_stone"), Black_Tourmaline_Stone);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "pine_sapling"), PineSapling);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "pine_leaves"), PineLeaves);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "pine_log"), PineLog);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "weirdly_black_tourmaline_stone"), Weirdly_Black_Tourmaline_Stone);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "pompon"), Pompon);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "cloud_block"), CloudBlock);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "alpine_strawberry_bush"), Alpine_Strawberry_Bush);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "weird_grass_block"), Weird_Grass_Block);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "cobbled_black_tourmaline_stone"), Cobbled_Black_Tourmaline_Stone);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "umbra_log"), Umbra_Log);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "umbra_leaves"), Umbra_Leaves);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "umbra_sapling"), Umbra_Sapling);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "weird_dirt"), Weird_Dirt);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "chiseled_black_tourmaline_stone"), Chiseled_Black_Tourmaline_Stone);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "black_tourmaline_stone_bricks"), Black_Tourmaline_Stone_Bricks);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "cracked_black_tourmaline_stone_bricks"), Cracked_Black_Tourmaline_Stone_Bricks);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "polished_black_tourmaline_stone"), Polished_Black_Tourmaline_Stone);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "cobbled_black_tourmaline_stone_stairs"), Cobbled_Black_Tourmaline_Stone_Stairs);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "polished_black_tourmaline_stone_stairs"), Polished_Black_Tourmaline_Stone_Stairs);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "chiseled_black_tourmaline_stone_stairs"), Chiseled_Black_Tourmaline_Stone_Stairs);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "black_tourmaline_stone_brick_stairs"), Black_Tourmaline_Stone_Brick_Stairs);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "black_tourmaline_stone_cracked_brick_stairs"), Black_Tourmaline_Stone_Cracked_Brick_Stairs);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "black_tourmaline_stone_pillar"), Black_Tourmaline_Stone_Pillar);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "cobbled_black_tourmaline_stone_slab"), Cobbled_Black_Tourmaline_Stone_Slab);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "polished_black_tourmaline_stone_slab"), Polished_Black_Tourmaline_Stone_Slab);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "chiseled_black_tourmaline_stone_slab"), Chiseled_Black_Tourmaline_Stone_Slab);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "black_tourmaline_stone_brick_slab"), Black_Tourmaline_Stone_Brick_Slab);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "black_tourmaline_stone_cracked_brick_slab"), Black_Tourmaline_Stone_Cracked_Brick_Slab);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "alpine_strawberry_cake"), Alpine_Strawberry_Cake);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "tenebris_portal_block"), TenebrisGateway);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "ancient_groats"), Ancient_Groats);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "stripped_umbra_wood"), Stripped_Umbra_Wood);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "umbra_planks"), Umbra_Planks);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "lavender"), Lavender);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "spore"), Spore);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "tenebris_portal"), TenebrisPortal);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "ringleaf"), RingLeaf);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "ringleaf_stem"), RingLeafStem);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "press"), Press);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "steel_ore"), Steel_Ore);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "nightshade"), NightShadeBlock);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "clay_stone"), ClayStone);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "thorns"), Thorns);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "thorns_plant"), ThornsPlant);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "stripped_umbra_log"), Stripped_Umbra_Log);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "umbra_wood"), Umbra_Wood);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "ilfty_log"), Ilfty_Log);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_log"), Bebusn_Log);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "ginkgo_log"), Ginkgo_Log);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "naveli_log"), Naveli_Log);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_leaves"), Bebusn_Leaves);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "umbra_slab"), Umbra_Slab);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "umbra_stairs"), Umbra_Stairs);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "umbra_fence"), Umbra_Fence);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "umbra_fence_gate"), Umbra_Fence_Gate);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_planks"), Bebusn_Planks);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "stripped_bebusn_log"), Stripped_Bebusn_Log);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "stripped_bebusn_wood"), Stripped_Bebusn_Wood);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_wood"), Bebusn_Wood);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "umbra_button"), Umbra_Button);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "umbra_pressure_plate"), Umbra_Pressure_Plate);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_door"), Bebusn_Door);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_trapdoor"), Bebusn_Trapdoor);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_slab"), Bebusn_Slab);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_stairs"), Bebusn_Stairs);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_fence"), Bebusn_Fence);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_fence_gate"), Bebusn_Fence_Gate);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_button"), Bebusn_Button);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_pressure_plate"), Bebusn_Pressure_Plate);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_standing_sign"), Bebusn_Standing_Sign);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "bebusn_wall_sign"), Bebusn_Wall_Sign);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "umbra_standing_sign"), Umbra_Standing_Sign);
        Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "umbra_wall_sign"), Umbra_Wall_Sign);


        /*
        *BlockItem
        */

        //Dirt
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "weird_grass_block"), new BlockItem(CharlsensideasBlocks.Weird_Grass_Block, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "mudded_dirt"), new BlockItem(MuddedDirt, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "hardened_mudded_dirt"), new BlockItem(HardenedMuddedDirt, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "weird_dirt"),  new BlockItem(CharlsensideasBlocks.Weird_Dirt, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Saplings
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "pine_sapling"), new BlockItem(PineSapling, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "umbra_sapling"), new BlockItem(CharlsensideasBlocks.Umbra_Sapling, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)) );

        //Leaves
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "pine_leaves"), new BlockItem(PineLeaves, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "umbra_leaves"),  new BlockItem(CharlsensideasBlocks.Umbra_Leaves, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "bebusn_leaves"),  new BlockItem(CharlsensideasBlocks.Bebusn_Leaves, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Logs
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "pine_log"), new BlockItem(PineLog, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "umbra_log"),  new BlockItem(CharlsensideasBlocks.Umbra_Log, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "bebusn_log"), new BlockItem(CharlsensideasBlocks.Bebusn_Log, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "ilfty_log"), new BlockItem(CharlsensideasBlocks.Ilfty_Log, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "ginkgo_log"), new BlockItem(CharlsensideasBlocks.Ginkgo_Log, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "naveli_log"), new BlockItem(CharlsensideasBlocks.Naveli_Log, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "stripped_umbra_log"), new BlockItem(CharlsensideasBlocks.Stripped_Umbra_Log, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "stripped_bebusn_log"), new BlockItem(CharlsensideasBlocks.Stripped_Bebusn_Log, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Wood
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "stripped_umbra_wood"), new BlockItem(CharlsensideasBlocks.Stripped_Umbra_Wood, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "umbra_wood"), new BlockItem(CharlsensideasBlocks.Umbra_Wood, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "stripped_bebusn_wood"), new BlockItem(CharlsensideasBlocks.Stripped_Bebusn_Wood, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "bebusn_wood"), new BlockItem(CharlsensideasBlocks.Bebusn_Wood, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Planks
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "umbra_planks"), new BlockItem(CharlsensideasBlocks.Umbra_Planks, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "bebusn_planks"), new BlockItem(CharlsensideasBlocks.Bebusn_Planks, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Fences
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "umbra_fence"), new BlockItem(CharlsensideasBlocks.Umbra_Fence, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "bebusn_fence"), new BlockItem(CharlsensideasBlocks.Bebusn_Fence, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //FenceGates
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "umbra_fence_gate"), new BlockItem(CharlsensideasBlocks.Umbra_Fence_Gate, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "bebusn_fence_gate"), new BlockItem(CharlsensideasBlocks.Bebusn_Fence_Gate, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Stone
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "bornite_ore"), new BlockItem(Bornite_Ore, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "steel_ore"), new BlockItem(CharlsensideasBlocks.Steel_Ore, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //TourmalineStone
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "black_tourmaline_stone"), new BlockItem(Black_Tourmaline_Stone, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "weirdly_black_tourmaline_stone"), new BlockItem(Weirdly_Black_Tourmaline_Stone, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "cobbled_black_tourmaline_stone"), new BlockItem(CharlsensideasBlocks.Cobbled_Black_Tourmaline_Stone, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)) );
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "chiseled_black_tourmaline_stone"),  new BlockItem(CharlsensideasBlocks.Chiseled_Black_Tourmaline_Stone, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "black_tourmaline_stone_bricks"),  new BlockItem(CharlsensideasBlocks.Black_Tourmaline_Stone_Bricks, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "cracked_black_tourmaline_stone_bricks"),  new BlockItem(CharlsensideasBlocks.Cracked_Black_Tourmaline_Stone_Bricks, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "polished_black_tourmaline_stone"), new BlockItem(CharlsensideasBlocks.Polished_Black_Tourmaline_Stone, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "black_tourmaline_stone_pillar"),  new BlockItem(CharlsensideasBlocks.Black_Tourmaline_Stone_Pillar, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Slabs
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "umbra_slab"), new BlockItem(CharlsensideasBlocks.Umbra_Slab, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "bebusn_slab"), new BlockItem(CharlsensideasBlocks.Bebusn_Slab, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "cobbled_black_tourmaline_stone_slab"),  new BlockItem(CharlsensideasBlocks.Cobbled_Black_Tourmaline_Stone_Slab, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "polished_black_tourmaline_stone_slab"), new BlockItem(CharlsensideasBlocks.Polished_Black_Tourmaline_Stone_Slab, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "chiseled_black_tourmaline_stone_slab"), new BlockItem(CharlsensideasBlocks.Chiseled_Black_Tourmaline_Stone_Slab, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "black_tourmaline_stone_brick_slab"), new BlockItem(CharlsensideasBlocks.Black_Tourmaline_Stone_Brick_Slab, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "black_tourmaline_stone_cracked_brick_slab"), new BlockItem(CharlsensideasBlocks.Black_Tourmaline_Stone_Cracked_Brick_Slab, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Stairs
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "umbra_stairs"), new BlockItem(CharlsensideasBlocks.Umbra_Stairs, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "bebusn_stairs"), new BlockItem(CharlsensideasBlocks.Bebusn_Stairs, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "cobbled_black_tourmaline_stone_stairs"), new BlockItem(CharlsensideasBlocks.Cobbled_Black_Tourmaline_Stone_Stairs, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "polished_black_tourmaline_stone_stairs"), new BlockItem(CharlsensideasBlocks.Polished_Black_Tourmaline_Stone_Stairs, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "chiseled_black_tourmaline_stone_stairs"), new BlockItem(CharlsensideasBlocks.Chiseled_Black_Tourmaline_Stone_Stairs, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "black_tourmaline_stone_brick_stairs"), new BlockItem(CharlsensideasBlocks.Black_Tourmaline_Stone_Brick_Stairs, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "black_tourmaline_stone_cracked_brick_stairs"), new BlockItem(CharlsensideasBlocks.Black_Tourmaline_Stone_Cracked_Brick_Stairs, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Buttons
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "umbra_button"), new BlockItem(CharlsensideasBlocks.Umbra_Button, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "bebusn_button"), new BlockItem(CharlsensideasBlocks.Bebusn_Button, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //PressurePlates
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "umbra_pressure_plate"), new BlockItem(CharlsensideasBlocks.Umbra_Pressure_Plate, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "bebusn_pressure_plate"), new BlockItem(CharlsensideasBlocks.Bebusn_Pressure_Plate, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Doors
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "bebusn_door"), new BlockItem(CharlsensideasBlocks.Bebusn_Door, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Trapdoors
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "bebusn_trapdoor"), new BlockItem(CharlsensideasBlocks.Bebusn_Trapdoor, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //OtherStone
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "clay_stone"), new BlockItem(CharlsensideasBlocks.ClayStone, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Nature
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "cloud_block"), new BlockItem(CharlsensideasBlocks.CloudBlock, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "ancient_groats"), new BlockItem(CharlsensideasBlocks.Ancient_Groats, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "spore"), new BlockItem(CharlsensideasBlocks.Spore, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "thorns"), new BlockItem(CharlsensideasBlocks.Thorns, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Flowers
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "lavender"), new BlockItem(CharlsensideasBlocks.Lavender, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Plants
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "ring_leaf"), new BlockItem(CharlsensideasBlocks.RingLeaf, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "nightshade"), new BlockItem(CharlsensideasBlocks.NightShadeBlock, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //OtherBlocks
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "tenebris_portal_block"), new BlockItem(CharlsensideasBlocks.TenebrisGateway, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));
        Registry.register(Registry.ITEM, new Identifier(Charlsensideas.MOD_ID, "press"), new BlockItem(CharlsensideasBlocks.Press, new OwoItemSettings().group(Charlsensideas.MAIN).tab(1)));

        //Other
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "alpine_strawberry_cake"), new BlockItem(CharlsensideasBlocks.Alpine_Strawberry_Cake, new OwoItemSettings().group(Charlsensideas.MAIN).tab(5)));

    }
}