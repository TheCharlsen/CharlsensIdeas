package io.github.thecharlsen.charlsensideas;

import com.glisco.owo.itemgroup.OwoItemSettings;
import io.github.thecharlsen.charlsensideas.tools.Bornite.BornitePickaxeItem;
import io.github.thecharlsen.charlsensideas.tools.Bornite.BornitePickaxeMaterial;
import io.github.thecharlsen.charlsensideas.tools.Bornite.BorniteSwordItem;
import io.github.thecharlsen.charlsensideas.tools.Bornite.BorniteSwordMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CharlsensideasTools {

    public static final ToolItem Bornite_Pickaxe = new BornitePickaxeItem(BornitePickaxeMaterial.INSTANCEBOPICK, 3, 7.0F, new OwoItemSettings().group(Charlsensideas.MAIN).tab(2));
    public static final ToolItem Bornite_Sword = new BorniteSwordItem(BorniteSwordMaterial.INSTANCEBOSWORD, 10, 15.0F, new OwoItemSettings().group(Charlsensideas.MAIN).tab(2));

    public static void toolsInit(){

        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "bornite_pickaxe"), Bornite_Pickaxe);
        Registry.register(Registry.ITEM, new Identifier("charlsensideas", "bornite_sword"), Bornite_Sword);

    }
}
