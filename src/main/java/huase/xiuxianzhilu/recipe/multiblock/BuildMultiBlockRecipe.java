package huase.xiuxianzhilu.recipe.multiblock;

import com.google.gson.JsonObject;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.datagens.multiblock.MultiBlockPattern;
import huase.xiuxianzhilu.datagens.multiblock.MultiBlockPatternBuilder;
import huase.xiuxianzhilu.datagens.multiblock.REBlockPredicate;
import huase.xiuxianzhilu.recipe.MultiBlockRecipeSerializer;
import huase.xiuxianzhilu.recipe.MultiBlockRecipesInit;
import huase.xiuxianzhilu.registrie.NewRegistries;
import net.minecraft.resources.ResourceLocation;

/**
 * - @description:MultiBlockRecipe类
 */
public class BuildMultiBlockRecipe implements BuildMultiRecipe {
    private MultiBlockPattern multiBlockPattern;
    private MultiBlockPatternBuilder multiBlockPatternBuilder;

    public BuildMultiBlockRecipe(MultiBlockPatternBuilder multiBlockPatternBuilder) {
        this.multiBlockPatternBuilder = multiBlockPatternBuilder;
        this.multiBlockPattern = multiBlockPatternBuilder.build();
    }

    public static BuildMultiRecipe builder(MultiBlockPatternBuilder multiBlockPatternBuilder) {
        return new BuildMultiBlockRecipe(multiBlockPatternBuilder);
    }

    @Override
    public void serializeRecipeData(JsonObject pJson) {

        multiBlockPatternBuilder.serializeRecipeData( pJson);
    }

    @Override
    public JsonObject serializeRecipe() {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("type", NewRegistries.MultiBlockRecipeSerializer_IForgeRegistry.getKey(this.getType()).toString());
        this.serializeRecipeData(jsonobject);
        return jsonobject;
    }

    @Override
    public ResourceLocation getId() {
        REBlockPredicate result = multiBlockPatternBuilder.getResult();

        return ModMain.prefix("multiblockrecipe/"+ result.toString());
    }

    @Override
    public MultiBlockRecipeSerializer<?> getType() {
        return MultiBlockRecipesInit.registryObject.get();
    }

}
