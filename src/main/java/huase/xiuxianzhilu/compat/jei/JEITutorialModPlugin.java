package huase.xiuxianzhilu.compat.jei;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.blocks.functions.lianqiding.LianqidingBlock;
import huase.xiuxianzhilu.event.server.AddReloadListenerEvent;
import huase.xiuxianzhilu.recipe.LianqidingRecipe;
import huase.xiuxianzhilu.recipe.MultiBlockRecipeType;
import huase.xiuxianzhilu.recipe.multiblock.MultiBlockRecipe;
import huase.xiuxianzhilu.screen.MenuTypesInit;
import huase.xiuxianzhilu.screen.lianqiding.LianqidingMenu;
import huase.xiuxianzhilu.screen.lianqiding.LianqidingScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.gui.handlers.IGuiClickableArea;
import mezz.jei.api.gui.handlers.IGuiContainerHandler;
import mezz.jei.api.registration.*;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Blocks;

import java.util.Collection;
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
                    ,BlockInit.lianqiding0.get()
                    ,BlockInit.lianqiding1.get()
                    ,BlockInit.lianqiding2.get()
                    ,BlockInit.lianqiding3.get()
            );
            registration.addRecipeCatalysts(LianqidingCategory.GEM_LIANQIDING1_TYPE
                    ,BlockInit.lianqiding1.get()
                    ,BlockInit.lianqiding2.get()
                    ,BlockInit.lianqiding3.get()
            );
            registration.addRecipeCatalysts(LianqidingCategory.GEM_LIANQIDING2_TYPE
                    ,BlockInit.lianqiding2.get()
                    ,BlockInit.lianqiding3.get()
            );
            registration.addRecipeCatalysts(LianqidingCategory.GEM_LIANQIDING3_TYPE
                    ,BlockInit.lianqiding3.get()
            );


            registration.addRecipeCatalysts(MultiBlockRecipeCategory.MULTIBLOCKRECIPE_TYPE
                    , Blocks.STRUCTURE_BLOCK
            );
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new LianqidingCategory(registration.getJeiHelpers().getGuiHelper(), (LianqidingBlock) BlockInit.lianqiding0.get()));
        registration.addRecipeCategories(new LianqidingCategory(registration.getJeiHelpers().getGuiHelper(), (LianqidingBlock) BlockInit.lianqiding1.get()));
        registration.addRecipeCategories(new LianqidingCategory(registration.getJeiHelpers().getGuiHelper(), (LianqidingBlock) BlockInit.lianqiding2.get()));
        registration.addRecipeCategories(new LianqidingCategory(registration.getJeiHelpers().getGuiHelper(), (LianqidingBlock) BlockInit.lianqiding3.get()));


        registration.addRecipeCategories(new MultiBlockRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {

//添加物品描述

        registration.addItemStackInfo(List.of(
                        new ItemStack(BlockInit.lianqiding0.get()),
                        new ItemStack(BlockInit.lianqiding1.get()),
                        new ItemStack(BlockInit.lianqiding2.get()),
                        new ItemStack(BlockInit.lianqiding3.get())
                ),
                Component.translatable("需要建造特殊结构").withStyle(ChatFormatting.RED), // actually 2 lines
                Component.translatable("需要灵力提供").withStyle(ChatFormatting.BLUE),
                Component.translatable("description.jei.wooden.door.3").withStyle(ChatFormatting.WHITE)
        );




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



        List<MultiBlockRecipe> allRecipesFor = AddReloadListenerEvent.INSTANCE.getAllRecipesFor(MultiBlockRecipeType.multiblockrecipe);
        registration.addRecipes(MultiBlockRecipeCategory.MULTIBLOCKRECIPE_TYPE, allRecipesFor);


    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addGuiContainerHandler(LianqidingScreen.class, new IGuiContainerHandler<>() {
            @Override
            public Collection<IGuiClickableArea> getGuiClickableAreas(LianqidingScreen containerScreen, double mouseX, double mouseY) {
                return List.of(IGuiClickableArea.createBasic(70, 2, 30, 20, LianqidingCategory.getRecipeTypeWithLV(containerScreen.getMenu().getBlockEntity().getLv())));
            }
        });
    }



    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(new REBasicRecipeTransferInfo<>(LianqidingMenu.class, MenuTypesInit.lianqidingmenu.get(), LianqidingCategory.GEM_LIANQIDING0_TYPE, 36, 9, 0, 36));
        registration.addRecipeTransferHandler(new REBasicRecipeTransferInfo<>(LianqidingMenu.class, MenuTypesInit.lianqidingmenu.get(), LianqidingCategory.GEM_LIANQIDING1_TYPE, 36, 13, 0, 36));
        registration.addRecipeTransferHandler(new REBasicRecipeTransferInfo<>(LianqidingMenu.class, MenuTypesInit.lianqidingmenu.get(), LianqidingCategory.GEM_LIANQIDING2_TYPE, 36, 21, 0, 36));
        registration.addRecipeTransferHandler(new REBasicRecipeTransferInfo<>(LianqidingMenu.class, MenuTypesInit.lianqidingmenu.get(), LianqidingCategory.GEM_LIANQIDING3_TYPE, 36, 25, 0, 36));
    }

}
