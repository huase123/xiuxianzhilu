package huase.xiuxianzhilu.recipe;

import com.google.gson.JsonObject;
import huase.xiuxianzhilu.recipe.multiblock.MultiRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

/**
 * - @description:MultiBlockRecipeSerializer接口
 */
public interface MultiBlockRecipeSerializer <T extends MultiRecipe<?>> {

//    RecipeSerializer<ShapelessRecipe> SHAPELESS_RECIPE = register("crafting_shapeless", new ShapelessRecipe.Serializer());
    // Forge: use fromJson with IContext if you need the context
    T fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe);

    @org.jetbrains.annotations.Nullable
    T fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer);

    void toNetwork(FriendlyByteBuf pBuffer, T pRecipe);
}
