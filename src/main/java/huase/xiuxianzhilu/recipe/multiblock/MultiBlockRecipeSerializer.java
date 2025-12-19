package huase.xiuxianzhilu.recipe.multiblock;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import huase.xiuxianzhilu.datagens.multiblock.MultiBlockPatternBuilder;
import huase.xiuxianzhilu.datagens.multiblock.REBlockPredicate;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * - @description:MultiBlockRecipeSerializer类
 */
public class MultiBlockRecipeSerializer implements huase.xiuxianzhilu.recipe.MultiBlockRecipeSerializer<MultiBlockRecipe> {
    public static final MultiBlockRecipeSerializer INSTANCE = new MultiBlockRecipeSerializer();

    @Override
    public MultiBlockRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
        List<String[]> list = new ArrayList<>();
        JsonArray pattern = pJson.getAsJsonArray("pattern");
        for (JsonElement jsonElement : pattern) {
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            int size = asJsonArray.size();
            String[] strings = new String[size];
            for (int i = 0; i < size; i++) {
                strings[i] = asJsonArray.get(i).getAsString();
            }
            list.add(strings);
        }

        Map<Character, REBlockPredicate> map = new HashMap<>();

        JsonObject jsonObject = pJson.get("key").getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {

            char key = entry.getKey().charAt(0);
            REBlockPredicate value = REBlockPredicate.fromJson(entry.getValue().getAsJsonObject());
            map.put(key, value);
        }

        int height = GsonHelper.getAsInt(pJson, "height");
        int width = GsonHelper.getAsInt(pJson, "width");
        REBlockPredicate result = REBlockPredicate.fromJson(pJson.get("result").getAsJsonObject());


        MultiBlockPatternBuilder start = MultiBlockPatternBuilder.start(result);
        for (String[] strings : list) {
            start.aisle(strings);
        }
        for (Map.Entry<Character, REBlockPredicate> characterREBlockPredicateEntry : map.entrySet()) {
            start.where(characterREBlockPredicateEntry.getKey(),characterREBlockPredicateEntry.getValue());
        }


        return new MultiBlockRecipe(start, pRecipeId);
    }

    @Override
    public @Nullable MultiBlockRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        CompoundTag compoundTag = pBuffer.readNbt();
        JsonElement jsonElement = NbtOps.INSTANCE.convertTo(JsonOps.INSTANCE, compoundTag);
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        return fromJson(pRecipeId,asJsonObject);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, MultiBlockRecipe pRecipe) {
        MultiBlockPatternBuilder multiBlockPatternBuilder = pRecipe.getMultiBlockPatternBuilder();
        JsonObject jsonObject = new JsonObject();
        multiBlockPatternBuilder.serializeRecipeData(jsonObject);
        Tag tag = JsonOps.INSTANCE.convertTo(NbtOps.INSTANCE, jsonObject);
        pBuffer.writeNbt((CompoundTag) tag);

    }
}