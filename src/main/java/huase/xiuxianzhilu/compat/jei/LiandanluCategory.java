package huase.xiuxianzhilu.compat.jei;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.functions.liandanlu.LiandanluBlock;
import huase.xiuxianzhilu.recipe.LiandanluRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class LiandanluCategory implements IRecipeCategory<LiandanluRecipe> {

    public static final RecipeType<LiandanluRecipe> GEM_LIANDANLU0_TYPE = new RecipeType<>(ModMain.prefix("jei_liandanlu0"), LiandanluRecipe.class);
    public static final RecipeType<LiandanluRecipe> GEM_LIANDANLU1_TYPE = new RecipeType<>(ModMain.prefix("jei_liandanlu1"), LiandanluRecipe.class);
    public static final RecipeType<LiandanluRecipe> GEM_LIANDANLU2_TYPE = new RecipeType<>(ModMain.prefix("jei_liandanlu2"), LiandanluRecipe.class);
    public static final RecipeType<LiandanluRecipe> GEM_LIANDANLU3_TYPE = new RecipeType<>(ModMain.prefix("jei_liandanlu3"), LiandanluRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private  int lv = 0;

    public LiandanluCategory(IGuiHelper helper, LiandanluBlock block) {
        lv = block.getLv();
        IDrawableBuilder iDrawableBuilder = helper.drawableBuilder(getResourceLocation(lv), 0, 0, 176, 120);
        this.background = iDrawableBuilder.setTextureSize(176, 210).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(block));
    }

    private static final ResourceLocation liandanlu0 = ModMain.prefix("textures/gui/container/liandanlu0.png");
    private static final ResourceLocation liandanlu1 = ModMain.prefix("textures/gui/container/liandanlu1.png");
    private static final ResourceLocation liandanlu2 = ModMain.prefix("textures/gui/container/liandanlu2.png");
    private static final ResourceLocation liandanlu3 = ModMain.prefix("textures/gui/container/liandanlu3.png");

    public static RecipeType<LiandanluRecipe> getRecipeTypeWithLV(int lv) {
        switch (lv){
            case 0:return GEM_LIANDANLU0_TYPE;
            case 1:return GEM_LIANDANLU1_TYPE;
            case 2:return GEM_LIANDANLU2_TYPE;
            case 3:return GEM_LIANDANLU3_TYPE;
        }
        return GEM_LIANDANLU3_TYPE;
    }

    private ResourceLocation getResourceLocation(int lv) {
        switch (lv){
            case 0:return liandanlu0;
            case 1:return liandanlu1;
            case 2:return liandanlu2;
            case 3:return liandanlu3;
        }
        return liandanlu3;
    }

    @Override
    public RecipeType<LiandanluRecipe> getRecipeType() {
        switch (lv){
            case 0:return GEM_LIANDANLU0_TYPE;
            case 1:return GEM_LIANDANLU1_TYPE;
            case 2:return GEM_LIANDANLU2_TYPE;
            case 3:return GEM_LIANDANLU3_TYPE;
        }

        return GEM_LIANDANLU0_TYPE;
    }

    @Override
    public Component getTitle() {
        switch (lv){
            case 0:return Component.translatable("炼丹炉lv0");
            case 1:return Component.translatable("炼丹炉lv1");
            case 2:return Component.translatable("炼丹炉lv2");
            case 3:return Component.translatable("炼丹炉lv3");
        }

        return Component.translatable("炼丹炉");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }


    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, LiandanluRecipe recipe, IFocusGroup focuses) {

        if(lv >=0){
            builder.addSlot(RecipeIngredientRole.INPUT, 44,  62).addIngredients(recipe.getIngredients().get(0));
            builder.addSlot(RecipeIngredientRole.INPUT, 44+18,  62).addIngredients(recipe.getIngredients().get(1));
            builder.addSlot(RecipeIngredientRole.INPUT, 44+36,  62).addIngredients(recipe.getIngredients().get(2));
        }
        if (lv >= 1) {
            builder.addSlot(RecipeIngredientRole.INPUT, 44-18,  62).addIngredients(recipe.getIngredients().get(3));
        }
        if (lv >= 2) {
            builder.addSlot(RecipeIngredientRole.INPUT, 44-18,  62-18).addIngredients(recipe.getIngredients().get(4));
        }
        if (lv >= 3) {
            builder.addSlot(RecipeIngredientRole.INPUT, 44-18,  62+18).addIngredients(recipe.getIngredients().get(5));
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 129,  62).addItemStack(recipe.getResultItem(null));
    }


    @Override
    public void draw(LiandanluRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

        guiGraphics.drawString(Minecraft.getInstance().font,
                Component.translatable("灵力消耗："+recipe.getLingli()).withStyle(ChatFormatting.AQUA)
                , 113, 84, 0xFF00ff00, false);
    }

}
