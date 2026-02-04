package huase.xiuxianzhilu.recipe;

import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Map;


public class LiandanluRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack result;
    private final ResourceLocation id;
    private final int lingli;
    private final int linglidensity;

    public LiandanluRecipe(NonNullList<Ingredient> inputItems, ItemStack result, ResourceLocation id, int lingli, int linglidensity) {
        this.inputItems = inputItems;
        this.result = result;
        this.id = id;
        this.lingli = lingli;
        this.linglidensity = linglidensity;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        for (int i = 0; i < inputItems.size(); i++) {
            Ingredient ingredient = inputItems.get(i);
            if(!ingredient.isEmpty()){
                if(i>=pContainer.getContainerSize()){
                    return false;
                }else {
                    if(!ingredient.test(pContainer.getItem( i))){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return inputItems;
    }
    public int getLingli() {
        return lingli;
    }

    public int getlinglidensity() {
        return linglidensity;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return result.copy();
    }

    public ItemStack getResultItem() {
        return result.copy();
    }

    @Override
    public ResourceLocation getId() {
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

    public static class Type implements RecipeType<LiandanluRecipe> {
        public static final Type INSTANCE = new Type();
    }

    public static class Serializer implements RecipeSerializer<LiandanluRecipe> {
        public static final Serializer INSTANCE = new Serializer();


        /**
         * Returns a key json object as a Java HashMap.
         */
        static Map<Integer, Ingredient> keyFromJson(JsonObject pKeyEntry) {
            Map<Integer, Ingredient> map = Maps.newHashMap();

            for(Map.Entry<String, JsonElement> entry : pKeyEntry.entrySet()) {
                map.put(Integer.valueOf(entry.getKey()), Ingredient.fromJson(entry.getValue(), true));
            }
            return map;
        }


        @Override
        public LiandanluRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {

            int lingli1 = GsonHelper.getAsInt(pSerializedRecipe, "lingli");
            int linglidensity = GsonHelper.getAsInt(pSerializedRecipe, "linglidensity");
            ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));


            Map<Integer, Ingredient> map = keyFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "key"));


            NonNullList<Ingredient> inputs = NonNullList.withSize(25, Ingredient.EMPTY);
            for (int i = 0; i < 25; i++) {
                Ingredient ingredient = map.get(i);
                if(ingredient != null){
                    inputs.set(i,ingredient);
                }
            }


            return new LiandanluRecipe(inputs, itemstack, pRecipeId,lingli1,linglidensity);
        }

        @Override
        public @Nullable LiandanluRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            int lingli = pBuffer.readVarInt();
            int linglidensity = pBuffer.readVarInt();

            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            ItemStack output = pBuffer.readItem();
            return new LiandanluRecipe(inputs, output, pRecipeId, lingli,linglidensity);
//            return new PotRecipe(inputs, output, pRecipeId, 0);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, LiandanluRecipe pRecipe) {
            pBuffer.writeVarInt(pRecipe.getLingli());
            pBuffer.writeVarInt(pRecipe.getlinglidensity());

            pBuffer.writeInt(pRecipe.inputItems.size());

            for (Ingredient ingredient : pRecipe.inputItems) {
                ingredient.toNetwork(pBuffer);
            }
            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        }
    }
}
