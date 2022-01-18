package io.github.thecharlsen.charlsensideas.Recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.Objects;

public class PressRecipe implements Recipe<SimpleInventory> {
    public enum Time {
        DAY,
        NIGHT;

        public static Time getTimeByString(String s) {
            return Objects.equals(s, "night") ? NIGHT : Objects.equals(s, "day") ? DAY : DAY;
        }
    }

    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;
    private final Time time;

    public PressRecipe(Identifier id, ItemStack output,
                                    DefaultedList<Ingredient> recipeItems, Time time) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(recipeItems.get(0).test(inventory.getStack(0))) {
            return recipeItems.get(1).test(inventory.getStack(1));
        }

        return false;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return output.copy();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<PressRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "press";
    }

    public static class Serializer implements RecipeSerializer<PressRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "press";
        // this is the name given in the json file

        @Override
        public PressRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
            String daytime = JsonHelper.getString(json, "daytime");

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new PressRecipe(id, output,
                    inputs, Time.getTimeByString(daytime));
        }

        @Override
        public PressRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new PressRecipe(id, output,
                    inputs, buf.readEnumConstant(Time.class));
        }

        @Override
        public void write(PacketByteBuf buf, PressRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
            buf.writeEnumConstant(recipe.time);
        }
    }
}
