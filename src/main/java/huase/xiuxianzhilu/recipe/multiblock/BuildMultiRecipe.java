package huase.xiuxianzhilu.recipe.multiblock;

import com.google.gson.JsonObject;
import huase.xiuxianzhilu.recipe.MultiBlockRecipeSerializer;
import net.minecraft.resources.ResourceLocation;

/**
 * - @description:BuildMultiRecipe接口
 */
public interface BuildMultiRecipe {
    void serializeRecipeData(JsonObject pJson);

    /**
     * Gets the JSON for the recipe.
     */
     JsonObject serializeRecipe() ;

    /**
     * Gets the ID for the recipe.
     */
    ResourceLocation getId();

    MultiBlockRecipeSerializer<?> getType();

    /**
     * Gets the JSON for the advancement that unlocks this recipe. Null if there is no advancement.
     */
}
