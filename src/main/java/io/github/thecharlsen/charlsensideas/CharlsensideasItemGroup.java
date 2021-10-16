package io.github.thecharlsen.charlsensideas;

import com.glisco.owo.itemgroup.Icon;
import com.glisco.owo.itemgroup.OwoItemGroup;
import com.glisco.owo.itemgroup.gui.ItemGroupButton;
import com.glisco.owo.itemgroup.gui.ItemGroupTab;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class CharlsensideasItemGroup extends OwoItemGroup {

	protected CharlsensideasItemGroup(Identifier id) {
		super(id);
	}

	@Override
	protected void setup() {
		this.setCustomTexture(CharlsensideasIdentifiers.ITEM_GROUP_BACKGROUND);
		this.addTab(Icon.of(CharlsensideasIdentifiers.ITEM_GROUP_TAB, 32, 1000, 16, 16), "items", TagFactory.ITEM.create(RegistryHelper.id("metals")));
		this.addTab(Icon.of(Items.BARRIER), "blocks", ItemGroupTab.EMPTY);
		this.addTab(Icon.of(Items.BARRIER), "tools", TagFactory.ITEM.create(RegistryHelper.id("weapons")));
		this.addTab(Icon.of(Items.BARRIER), "armor", TagFactory.ITEM.create(RegistryHelper.id("gear")));
		this.addTab(Icon.of(Items.BARRIER), "zero", TagFactory.ITEM.create(RegistryHelper.id("s")));
		this.addTab(Icon.of(Items.BARRIER), "one", ItemGroupTab.EMPTY);
		this.addTab(Icon.of(Items.BARRIER), "two", TagFactory.ITEM.create(RegistryHelper.id("c")));
		this.addTab(Icon.of(Items.BARRIER), "three", TagFactory.ITEM.create(RegistryHelper.id("h")));

		this.addButton(ItemGroupButton.github("https://github.com/TheCharlsen/CharlsensIdeas"));
		this.addButton(ItemGroupButton.curseforge("https://www.curseforge.com/minecraft/mc-mods/charlsensideas"));
		this.addButton(ItemGroupButton.modrinth("https://modrinth.com/mod/charlsensideas"));
		this.addButton(ItemGroupButton.discord("https://discord.gg/fPZgf2y3eB"));
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(CharlsensideasItems.Black_Tourmaline_Gem);
	}
}
