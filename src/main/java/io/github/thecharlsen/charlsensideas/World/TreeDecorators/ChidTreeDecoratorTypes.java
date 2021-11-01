package io.github.thecharlsen.charlsensideas.World.TreeDecorators;

import io.github.thecharlsen.charlsensideas.Charlsensideas;
import io.github.thecharlsen.charlsensideas.mixin.TreeDecoratorTypeInvoker;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ChidTreeDecoratorTypes {

    public static TreeDecoratorType<TrunkSporeTreeDecorator> SPORE_TRUNK;

    public static void init(){

        SPORE_TRUNK = TreeDecoratorTypeInvoker.createType(TrunkSporeTreeDecorator.CODEC);
        Registry.register(Registry.TREE_DECORATOR_TYPE, new Identifier(Charlsensideas.MOD_ID, "spore_trunk"), SPORE_TRUNK);
    }
}
