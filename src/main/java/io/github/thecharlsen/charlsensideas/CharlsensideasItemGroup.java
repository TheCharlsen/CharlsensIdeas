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
		this.addTab(Icon.of(Items.BARRIER), "items", TagFactory.ITEM.create(RegistryHelper.id("metals")));
		this.addTab(Icon.of(Items.BARRIER), "blocks", ItemGroupTab.EMPTY);
		this.addTab(Icon.of(Items.BARRIER), "tools", TagFactory.ITEM.create(RegistryHelper.id("weapons")));
		this.addTab(Icon.of(Items.BARRIER), "armor", TagFactory.ITEM.create(RegistryHelper.id("gear")));

		this.addButton(ItemGroupButton.github("https://github.com/Noaaan/MythicMetals/issues"));
		this.addButton(ItemGroupButton.curseforge("https://www.curseforge.com/minecraft/mc-mods/mythicmetals"));
		this.addButton(ItemGroupButton.modrinth("https://modrinth.com/mod/mythicmetals"));
		this.addButton(ItemGroupButton.discord("https://discord.gg/69cKvQWScC"));
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(CharlsensideasItems.Black_Tourmaline_Gem);
	}
}
