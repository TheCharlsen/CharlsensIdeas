package io.github.thecharlsen.charlsensideas;

import com.glisco.owo.itemgroup.Icon;
import com.glisco.owo.itemgroup.OwoItemGroup;
import com.glisco.owo.itemgroup.gui.ItemGroupButton;
import com.glisco.owo.itemgroup.gui.ItemGroupTab;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
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
		this.setStackHeight(6);

		this.addTab(Icon.of(CharlsensideasItems.Dog_Music_Disc), "items", TagFactory.ITEM.create(RegistryHelper.id("chidtems")));
		this.addTab(Icon.of(CharlsensideasBlocks.Black_Tourmaline_Stone_Bricks), "blocks", TagFactory.ITEM.create(RegistryHelper.id("chidlocks")));
		this.addTab(Icon.of(CharlsensideasTools.Bornite_Pickaxe), "tools", TagFactory.ITEM.create(RegistryHelper.id("chidools")));
		this.addTab(Icon.of(CharlsensideasItems.Combat_Helmet), "armor", TagFactory.ITEM.create(RegistryHelper.id("chidrmor")));
		this.addTab(Icon.of(CharlsensideasItems.Bornite), "ores", TagFactory.ITEM.create(RegistryHelper.id("chidres")));
		this.addTab(Icon.of(CharlsensideasItems.CHIP), "food", TagFactory.ITEM.create(RegistryHelper.id("chidood")));

		this.addButton(ItemGroupButton.github("https://github.com/TheCharlsen/CharlsensIdeas"));
		this.addButton(ItemGroupButton.curseforge("https://www.curseforge.com/minecraft/mc-mods/charlsensideas"));
		this.addButton(ItemGroupButton.modrinth("https://modrinth.com/mod/charlsensideas"));
		this.addButton(ItemGroupButton.discord("https://discord.gg/fPZgf2y3eB"));
		this.addButton(ItemGroupButton.link(Icon.of(CharlsensideasIdentifiers.ITEM_GROUP_BUTTON_ICONS, 0, 0, 64, 64), "youtube", "https://www.youtube.com/channel/UCzBj08FS4tDr3Lyf9zWM3kg"));
		this.addButton(ItemGroupButton.link(Icon.of(CharlsensideasIdentifiers.ITEM_GROUP_BUTTON_ICONS, 16, 64, 64, 64), "tcgithubio", "https://thecharlsen.github.io/"));
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(CharlsensideasItems.Black_Tourmaline_Gem);
	}
}
