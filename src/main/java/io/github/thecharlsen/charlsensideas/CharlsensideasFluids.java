package io.github.thecharlsen.charlsensideas;

import io.github.thecharlsen.charlsensideas.Fluids.Oil;
import io.github.thecharlsen.charlsensideas.Fluids.WeirdWater;
import io.github.thecharlsen.charlsensideas.ProtectedAcces.FluidBlocks;
import io.wispforest.owo.itemgroup.OwoItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CharlsensideasFluids {

    public static FlowableFluid Still_Weird_Water;
    public static FlowableFluid Flowing_Weird_Water;
    public static Item Bucket_Of_Weird_Water;

    public static FlowableFluid Still_Oil;
    public static FlowableFluid Flowing_Oil;
    public static Item Bucket_Of_Oil;

    public static void fluidsInit(){

        Still_Weird_Water = Registry.register(Registry.FLUID, new Identifier("charlsensideas", "still_weird_water"), new WeirdWater.Still());
        Flowing_Weird_Water =  Registry.register(Registry.FLUID, new Identifier("charlsensideas", "flowing_weird_water"), new WeirdWater.Flowing());
        CharlsensideasBlocks.Weird_Water = Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "weird_water_block"), new FluidBlocks(Still_Weird_Water, FabricBlockSettings.copy(Blocks.WATER)));
        Bucket_Of_Weird_Water = Registry.register(Registry.ITEM, new Identifier("charlsensideas", "bucket_of_weird_water"), new BucketItem(Still_Weird_Water, new OwoItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(Charlsensideas.CHARLSENSIDEAS_ITG).tab(0)));

        Still_Oil = Registry.register(Registry.FLUID, new Identifier(Charlsensideas.MOD_ID, "still_oil"), new Oil.Still());
        Flowing_Oil = Registry.register(Registry.FLUID, new Identifier(Charlsensideas.MOD_ID, "flowing_oil"), new Oil.Flowing());
        CharlsensideasBlocks.Oil = Registry.register(Registry.BLOCK, new Identifier(Charlsensideas.MOD_ID, "oil_block"), new FluidBlocks(Still_Oil, FabricBlockSettings.copy(Blocks.WATER)));
        Bucket_Of_Oil = Registry.register(Registry.ITEM, new Identifier("charlsensideas", "bucket_of_oil"), new BucketItem(Still_Oil, new OwoItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(Charlsensideas.CHARLSENSIDEAS_ITG).tab(0)));

    }
}
