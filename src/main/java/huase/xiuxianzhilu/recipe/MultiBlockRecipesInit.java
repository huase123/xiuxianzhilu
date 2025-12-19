package huase.xiuxianzhilu.recipe;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.recipe.multiblock.MultiRecipe;
import huase.xiuxianzhilu.registrie.NewRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:RecipesInit类
 */
public class MultiBlockRecipesInit {

    public static final DeferredRegister<MultiBlockRecipeSerializer<?>> MULTIBLOCKRECIPESERIALIZER = DeferredRegister.create(NewRegistries.MultiBlockRecipeSerializer_Resourcekey, ModMain.MODID);

    public static RegistryObject<MultiBlockRecipeSerializer<?>> registryObject = register("exmple", huase.xiuxianzhilu.recipe.multiblock.MultiBlockRecipeSerializer.INSTANCE);
    static <S extends MultiBlockRecipeSerializer<T>, T extends MultiRecipe<?>> RegistryObject<MultiBlockRecipeSerializer<?>> register(String pKey, S pRecipeSerializer) {
        return MULTIBLOCKRECIPESERIALIZER.register(pKey, () -> pRecipeSerializer);
    }
}
