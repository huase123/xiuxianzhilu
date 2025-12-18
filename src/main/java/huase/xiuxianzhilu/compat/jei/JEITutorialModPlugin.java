package huase.xiuxianzhilu.compat.jei;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.blocks.functions.lianqiding.LianqidingBlock;
import huase.xiuxianzhilu.recipe.LianqidingRecipe;
import huase.xiuxianzhilu.screen.linggen.LinggenScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.stream.Collectors;

@JeiPlugin
public class JEITutorialModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ModMain.prefix("jei_xiuxianzhilu");
    }


    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
            registration.addRecipeCatalysts(LianqidingCategory.GEM_LIANQIDING0_TYPE
                    ,BlockInit.lianaqiding0.get()
            );
            registration.addRecipeCatalysts(LianqidingCategory.GEM_LIANQIDING1_TYPE
                    ,BlockInit.lianaqiding1.get()
            );
            registration.addRecipeCatalysts(LianqidingCategory.GEM_LIANQIDING2_TYPE
                    ,BlockInit.lianaqiding2.get()
            );
            registration.addRecipeCatalysts(LianqidingCategory.GEM_LIANQIDING3_TYPE
                    ,BlockInit.lianaqiding3.get()
            );
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new LianqidingCategory(registration.getJeiHelpers().getGuiHelper(), (LianqidingBlock) BlockInit.lianaqiding0.get()));
        registration.addRecipeCategories(new LianqidingCategory(registration.getJeiHelpers().getGuiHelper(), (LianqidingBlock) BlockInit.lianaqiding1.get()));
        registration.addRecipeCategories(new LianqidingCategory(registration.getJeiHelpers().getGuiHelper(), (LianqidingBlock) BlockInit.lianaqiding2.get()));
        registration.addRecipeCategories(new LianqidingCategory(registration.getJeiHelpers().getGuiHelper(), (LianqidingBlock) BlockInit.lianaqiding3.get()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<LianqidingRecipe> polishingRecipes = recipeManager.getAllRecipesFor(LianqidingRecipe.Type.INSTANCE);

        registration.addRecipes(LianqidingCategory.GEM_LIANQIDING0_TYPE, polishingRecipes.stream().filter(c -> {
                    int size = c.getIngredients().size();
                    for (int i = 9; i < size; i++) {
                        if (!c.getIngredients().get(i).isEmpty()) {
                            return false;
                        }
                    }
                    return true;

            }
        ).collect(Collectors.toList()));

        registration.addRecipes(LianqidingCategory.GEM_LIANQIDING1_TYPE, polishingRecipes.stream().filter(c -> {
                    int size = c.getIngredients().size();
                    for (int i = 13; i < size; i++) {
                        if (!c.getIngredients().get(i).isEmpty()) {
                            return false;
                        }
                    }
                    return true;

            }
        ).collect(Collectors.toList()));

        registration.addRecipes(LianqidingCategory.GEM_LIANQIDING2_TYPE, polishingRecipes.stream().filter(c -> {
                    int size = c.getIngredients().size();
                    for (int i = 21; i < size; i++) {
                        if (!c.getIngredients().get(i).isEmpty()) {
                            return false;
                        }
                    }
                    return true;

            }
        ).collect(Collectors.toList()));


        registration.addRecipes(LianqidingCategory.GEM_LIANQIDING3_TYPE, polishingRecipes);


    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(LinggenScreen.class, 60, 30, 200, 300,
                LianqidingCategory.GEM_LIANQIDING0_TYPE);
    }
}
