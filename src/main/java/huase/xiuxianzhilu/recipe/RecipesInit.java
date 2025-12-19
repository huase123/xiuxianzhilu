package huase.xiuxianzhilu.recipe;

import huase.xiuxianzhilu.ModMain;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:RecipesInit类
 */
public class RecipesInit {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ModMain.MOD_ID);

    public static final RegistryObject<RecipeSerializer<LianqidingRecipe>> lianqidingtrecipe =
            SERIALIZERS.register("lianqiding_recipe", () -> LianqidingRecipe.Serializer.INSTANCE);

}
