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
        /*
        List<String[]> pattern = multiBlockPatternBuilder.getPattern();
        JsonArray pattern_jsonarray1 = new JsonArray();
        for (String[] strings : pattern) {

            JsonArray pattern_jsonarray2 = new JsonArray();
            for (String string : strings) {
                pattern_jsonarray2.add(string);
            }
            pattern_jsonarray1.add(pattern_jsonarray2);
        }
        pJson.add("pattern",pattern_jsonarray1);


        Map<Character, REBlockPredicate> key = multiBlockPatternBuilder.getLookup();
        JsonObject key_jsonobject = new JsonObject();
        for(Map.Entry<Character, REBlockPredicate> entry : key.entrySet()) {
            key_jsonobject.add(String.valueOf(entry.getKey()), entry.getValue().serializeToJson());
        }
        pJson.add("key", key_jsonobject);

        int height = multiBlockPatternBuilder.getHeight();

        pJson.addProperty("height", height);
        int width = multiBlockPatternBuilder.getWidth();
        pJson.addProperty("width", width);

        REBlockPredicate result = multiBlockPatternBuilder.getResult();
        pJson.add("result", result.serializeToJson());
*/
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
