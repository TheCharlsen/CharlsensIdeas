package charlsen.charlsens.ideas;

import charlsen.charlsens.ideas.Blocks.CloudBlock;
import charlsen.charlsens.ideas.Generators.PineTreeGenerator;
import charlsen.charlsens.ideas.Blocks.BorniteOreBlock;
import charlsen.charlsens.ideas.Blocks.WeirdlyDeepStoneBlock;
import charlsen.charlsens.ideas.ProtectedAcces.SaplingBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CharlsensideasBlocks {

    public static final Block MuddedDirt = new Block(FabricBlockSettings.of(Material.SOIL).strength(1F, 1F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block HardenedMuddedDirt = new Block(FabricBlockSettings.of(Material.STONE).strength(2F, 2F).sounds(BlockSoundGroup.STONE));
    public static final Block Bornite_Ore = new BorniteOreBlock(FabricBlockSettings.of(Material.STONE).strength(1F, 1F).sounds(BlockSoundGroup.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().luminance((state) -> { return 15;}));
    public static final Block Adrian_Block = new Block(FabricBlockSettings.of(Material.CAKE).strength(5F, 5F).sounds(CharlsensideasBlockSoundGroup.ADRIAN_BLOCK).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
    public static final Block Charlie_Block = new Block(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(5F, 5F).sounds(BlockSoundGroup.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
    public static final Block Julian_Block = new Block(FabricBlockSettings.of(Material.PISTON).strength(5F, 5F).sounds(BlockSoundGroup.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
    public static final Block Emil_Block = new Block(FabricBlockSettings.of(Material.CACTUS).strength(5F, 5F).sounds(BlockSoundGroup.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
    public static final Block DeepStone = new Block(FabricBlockSettings.of(Material.STONE).strength(13F, 12F).sounds(BlockSoundGroup.STONE));
    public static final Block PineLeaves = new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).strength(0.5F, 0.5F).nonOpaque());
    public static final SaplingBlock PineSapling = new SaplingBlocks(new PineTreeGenerator(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block PineLog = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(1.5F, 1.5F).sounds(BlockSoundGroup.WOOD));
    public static final Block WeirdlyDeepStone = new WeirdlyDeepStoneBlock(FabricBlockSettings.of(Material.STONE).strength(14F, 13F).sounds(BlockSoundGroup.STONE).luminance((state) -> { return 4;}));
    public static Block Weird_Water;
    public static final Block Pompon = new FlowerBlock(CharlsensideasStatusEffects.Blossomed, 9, FabricBlockSettings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final Block CloudBlock = new CloudBlock(FabricBlockSettings.of(Material.WOOL).strength(1F, 1F).sounds(BlockSoundGroup.SNOW).noCollision());
    public static final Block Cobbled_DeepStone = new Block(FabricBlockSettings.of(Material.STONE).strength(13F, 12F).sounds(BlockSoundGroup.STONE));
    public static final Block DeepStone_Grass = new Block(FabricBlockSettings.of(Material.STONE).strength(13F, 12F).sounds(BlockSoundGroup.STONE));
    public static final Block Umbra_Log = new Block(FabricBlockSettings.of(Material.STONE).strength(13F, 12F).sounds(BlockSoundGroup.STONE));
    public static final Block Umbra_Leaves = new Block(FabricBlockSettings.of(Material.STONE).strength(13F, 12F).sounds(BlockSoundGroup.STONE));
    public static final Block Umbra_Sapling = new Block(FabricBlockSettings.of(Material.STONE).strength(13F, 12F).sounds(BlockSoundGroup.STONE));

    public static void blocksInit(){
        //Blocks
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "bornite_ore"), Bornite_Ore);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "adrian_block"), Adrian_Block);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "charlie_block"), Charlie_Block);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "julian_block"), Julian_Block);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "emil_block"), Emil_Block);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "mudded_dirt"), MuddedDirt);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "hardened_mudded_dirt"), HardenedMuddedDirt);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "deepstone"), DeepStone);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "pine_sapling"), PineSapling);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "pine_leaves"), PineLeaves);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "pine_log"), PineLog);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "weirdly_deep_stone"), WeirdlyDeepStone);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "pompon"), Pompon);
        Registry.register(Registry.BLOCK, new Identifier("charlsensideas", "cloud_block"), CloudBlock);

        //BlockItems
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "bornite_ore"), new BlockItem(Bornite_Ore, new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_ORES)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "adrian_block"), new BlockItem(Adrian_Block, new Item.Settings()));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "charlie_block"), new BlockItem(Charlie_Block, new Item.Settings()));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "julian_block"), new BlockItem(Julian_Block, new Item.Settings()));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "emil_block"), new BlockItem(Emil_Block, new Item.Settings()));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "mudded_dirt"), new BlockItem(MuddedDirt, new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_NATURE)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "hardened_mudded_dirt"), new BlockItem(HardenedMuddedDirt, new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_NATURE)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "deepstone"), new BlockItem(DeepStone, new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_NATURE)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "pine_sapling"), new BlockItem(PineSapling, new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_NATURE)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "pine_leaves"), new BlockItem(PineLeaves, new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_NATURE)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "pine_log"), new BlockItem(PineLog, new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_NATURE)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "weirdly_deep_stone"), new BlockItem(WeirdlyDeepStone, new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_NATURE)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "pompon"), new BlockItem(CharlsensideasBlocks.Pompon, new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_NATURE)));
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "cloud_block"), new BlockItem(CharlsensideasBlocks.CloudBlock, new Item.Settings().group(CharlsensideasItemGroup.ITEM_GROUP_NATURE)));

    }
}
