package huase.xiuxianzhilu.compat.jei;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.functions.lianqiding.LianqidingBlock;
import huase.xiuxianzhilu.recipe.LianqidingRecipe;
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

public class LianqidingCategory implements IRecipeCategory<LianqidingRecipe> {

    public static final RecipeType<LianqidingRecipe> GEM_LIANQIDING0_TYPE = new RecipeType<>(ModMain.prefix("jei_lianqiding0"), LianqidingRecipe.class);
    public static final RecipeType<LianqidingRecipe> GEM_LIANQIDING1_TYPE = new RecipeType<>(ModMain.prefix("jei_lianqiding1"), LianqidingRecipe.class);
    public static final RecipeType<LianqidingRecipe> GEM_LIANQIDING2_TYPE = new RecipeType<>(ModMain.prefix("jei_lianqiding2"), LianqidingRecipe.class);
    public static final RecipeType<LianqidingRecipe> GEM_LIANQIDING3_TYPE = new RecipeType<>(ModMain.prefix("jei_lianqiding3"), LianqidingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private  int lv = 0;

    public LianqidingCategory(IGuiHelper helper,LianqidingBlock block) {
        lv = block.getLv();
        IDrawableBuilder iDrawableBuilder = helper.drawableBuilder(getResourceLocation(lv), 0, 0, 176, 120);
        this.background = iDrawableBuilder.setTextureSize(176, 210).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(block));
    }

    private static final ResourceLocation lianqiding0 = ModMain.prefix("textures/gui/container/lianqiding0.png");
    private static final ResourceLocation lianqiding1 = ModMain.prefix("textures/gui/container/lianqiding1.png");
    private static final ResourceLocation lianqiding2 = ModMain.prefix("textures/gui/container/lianqiding2.png");
    private static final ResourceLocation lianqiding3 = ModMain.prefix("textures/gui/container/lianqiding3.png");
    private ResourceLocation getResourceLocation(int lv) {
        switch (lv){
            case 0:return lianqiding0;
            case 1:return lianqiding1;
            case 2:return lianqiding2;
            case 3:return lianqiding3;
        }
        return lianqiding3;
    }

    @Override
    public RecipeType<LianqidingRecipe> getRecipeType() {
        switch (lv){
            case 0:return GEM_LIANQIDING0_TYPE;
            case 1:return GEM_LIANQIDING1_TYPE;
            case 2:return GEM_LIANQIDING2_TYPE;
            case 3:return GEM_LIANQIDING3_TYPE;
        }

        return GEM_LIANQIDING0_TYPE;
    }

    @Override
    public Component getTitle() {
        switch (lv){
            case 0:return Component.translatable("炼器鼎lv0");
            case 1:return Component.translatable("炼器鼎lv1");
            case 2:return Component.translatable("炼器鼎lv2");
            case 3:return Component.translatable("炼器鼎lv3");
        }

        return Component.translatable("炼器鼎");
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
    public void setRecipe(IRecipeLayoutBuilder builder, LianqidingRecipe recipe, IFocusGroup focuses) {


        if(lv >=0){
            for (int i = 0; i < 9; i++) {
                int x = i % 3;
                int y = i / 3;
                builder.addSlot(RecipeIngredientRole.INPUT, 8+x*18+18,  26+y*18+18).addIngredients(recipe.getIngredients().get(i));
            }
        }
        if (lv >= 1) {
            builder.addSlot(RecipeIngredientRole.INPUT, 8+0*18,  26+0*18).addIngredients(recipe.getIngredients().get(9));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+4*18,  26+0*18).addIngredients(recipe.getIngredients().get(10));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+0*18,  26+4*18).addIngredients(recipe.getIngredients().get(11));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+4*18,  26+4*18).addIngredients(recipe.getIngredients().get(12));
        }
        if (lv >= 2) {
            builder.addSlot(RecipeIngredientRole.INPUT, 8+0*18,  26+1*18).addIngredients(recipe.getIngredients().get(13));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+1*18,  26+0*18).addIngredients(recipe.getIngredients().get(14));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+3*18,  26+0*18).addIngredients(recipe.getIngredients().get(15));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+4*18,  26+1*18).addIngredients(recipe.getIngredients().get(16));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+0*18,  26+3*18).addIngredients(recipe.getIngredients().get(17));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+1*18,  26+4*18).addIngredients(recipe.getIngredients().get(18));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+3*18,  26+4*18).addIngredients(recipe.getIngredients().get(19));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+4*18,  26+3*18).addIngredients(recipe.getIngredients().get(20));

        }
        if (lv >= 3) {
            builder.addSlot(RecipeIngredientRole.INPUT, 8+0*18,  26+2*18).addIngredients(recipe.getIngredients().get(21));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+2*18,  26+0*18).addIngredients(recipe.getIngredients().get(22));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+2*18,  26+4*18).addIngredients(recipe.getIngredients().get(23));
            builder.addSlot(RecipeIngredientRole.INPUT, 8+4*18,  26+2*18).addIngredients(recipe.getIngredients().get(24));
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 129,  62).addItemStack(recipe.getResultItem(null));
    }


    @Override
    public void draw(LianqidingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

        guiGraphics.drawString(Minecraft.getInstance().font,
                Component.translatable("灵力消耗："+recipe.getLingli()).withStyle(ChatFormatting.AQUA)
                , 113, 84, 0xFF00ff00, false);
    }

}
