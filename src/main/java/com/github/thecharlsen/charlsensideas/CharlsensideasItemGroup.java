package com.github.thecharlsen.charlsensideas;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CharlsensideasItemGroup implements ModInitializer {

			public static final ItemGroup ITEM_GROUP_NATURE = FabricItemGroupBuilder.build(
			new Identifier("charlsensideas", "nature"),
			() -> new ItemStack(CharlsensideasBlocks.MuddedDirt));

			public static final ItemGroup ITEM_GROUP_BUILDING_BLOCKS = FabricItemGroupBuilder.build(
			new Identifier("charlsensideas", "building_blocks"),
			() -> new ItemStack(CharlsensideasBlocks.Chiseled_Black_Tourmaline_Stone));

			public static final ItemGroup ITEM_GROUP_ORES = FabricItemGroupBuilder.build(
			new Identifier("charlsensideas", "ores"),
			() -> new ItemStack(CharlsensideasItems.Bornite));

			public static final ItemGroup ITEM_GROUP_TOOLS = FabricItemGroupBuilder.build(
			new Identifier("charlsensideas", "tools"),
			() -> new ItemStack(CharlsensideasTools.Bornite_Pickaxe));

			public static final ItemGroup ITEM_GROUP_FOOD = FabricItemGroupBuilder.build(
			new Identifier("charlsensideas", "food"),
			() -> new ItemStack(CharlsensideasBlocks.Alpine_Strawberry_Cake));

			public static final ItemGroup ITEM_GROUP_MUSIC = FabricItemGroupBuilder.build(
				new Identifier("charlsensideas", "music"),
				() -> new ItemStack(CharlsensIdeasClientModInitializer.MUSICPLAYER));

			public static final ItemGroup ITEM_GROUP_SECCHESTS = FabricItemGroupBuilder.build(
			new Identifier("charlsensideas", "secchests"),
			() -> new ItemStack(CharlsensideasItems.Secure_Chest_Module));

	        @Override
			public void onInitialize() {
    }
}
