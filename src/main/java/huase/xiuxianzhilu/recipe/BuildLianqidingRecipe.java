package huase.xiuxianzhilu.recipe;

import com.google.gson.JsonObject;
import huase.xiuxianzhilu.ModMain;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.HashMap;
import java.util.Map;

/**
 * - @description:BuildRecipe类
 */
public class BuildLianqidingRecipe implements FinishedRecipe {

    private  Item result;
    private  int count;
    private  Map<Integer, Ingredient> key = new HashMap<>();
    private int lingli;
    private int linglidensity;

    public BuildLianqidingRecipe(ItemLike result, int count) {

        this.result = result.asItem();
        this.count = count;
    }

    /**
     * Adds a key to the recipe pattern.
     */
    public BuildLianqidingRecipe define(int pSymbol, TagKey<Item> pTag) {
        return this.define(pSymbol, Ingredient.of(pTag));
    }

    /**
     * Adds a key to the recipe pattern.
     */
    public BuildLianqidingRecipe define(int pSymbol, ItemLike pItem) {
        return this.define(pSymbol, Ingredient.of(pItem));
    }

    /**
     * Adds a key to the recipe pattern.
     */
    public BuildLianqidingRecipe define(int pSymbol, Ingredient pIngredient) {
        if (this.key.containsKey(pSymbol)) {
            throw new IllegalArgumentException("Symbol '" + pSymbol + "' is already defined!");
        } else {
            this.key.put(pSymbol, pIngredient);
            return this;
        }
    }
    public BuildLianqidingRecipe defineLingli(int lingli) {
        this.lingli = lingli;
        return this;
    }

    public BuildLianqidingRecipe defineLingliDensity(int lingliDensity) {
        this.linglidensity = lingliDensity;
        return this;
    }

    /**
     * Creates a new builder for a shaped recipe.
     */
    public static BuildLianqidingRecipe shapedResult(ItemLike pResult, int pCount) {
        return new BuildLianqidingRecipe( pResult, pCount);
    }

    @Override
    public void serializeRecipeData(JsonObject pJson) {


        pJson.addProperty("lingli",lingli);
        pJson.addProperty("linglidensity",linglidensity);

        JsonObject jsonobject = new JsonObject();
        for(Map.Entry<Integer, Ingredient> entry : this.key.entrySet()) {
            jsonobject.add(String.valueOf(entry.getKey()), entry.getValue().toJson());
        }
        pJson.add("key", jsonobject);



        JsonObject jsonobject1 = new JsonObject();
        jsonobject1.addProperty("item", BuiltInRegistries.ITEM.getKey(this.result).toString());
        if (this.count > 1) {
            jsonobject1.addProperty("count", this.count);
        }
        pJson.add("result", jsonobject1);
    }

    @Override
    public ResourceLocation getId() {
        return ModMain.prefix("lingqiding/"+BuiltInRegistries.ITEM.getKey(result.asItem()).getPath()+count);
    }

    @Override
    public RecipeSerializer<?> getType() {
        return RecipesInit.lianqidingtrecipe.get();
    }

    @Override
    public JsonObject serializeAdvancement() {
        return null;
    }

    @Override
    public ResourceLocation getAdvancementId() {
        return null;
    }
}