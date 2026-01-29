package huase.xiuxianzhilu.screen.liandanlu;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.functions.liandanlu.LiandanluBlockEntity;
import huase.xiuxianzhilu.recipe.LiandanluRecipe;
import huase.xiuxianzhilu.screen.FunctionAbstractContainerScreen;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.Optional;

/**
 * - @description:LinggenScreen类
 */
public class LiandanluScreen extends FunctionAbstractContainerScreen<LiandanluMenu> {
    public LiandanluScreen(LiandanluMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        this.imageWidth = 176;
        this.imageHeight = 210;

        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
        this.titleLabelY = 10;
        super.init();
    }

    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }
    private static final ResourceLocation liandanlu0 = ModMain.prefix("textures/gui/container/liandanlu0.png");
    private static final ResourceLocation liandanlu1 = ModMain.prefix("textures/gui/container/liandanlu1.png");
    private static final ResourceLocation liandanlu2 = ModMain.prefix("textures/gui/container/liandanlu2.png");
    private static final ResourceLocation liandanlu3 = ModMain.prefix("textures/gui/container/liandanlu3.png");

    private static final ResourceLocation tiao0 = ModMain.prefix("textures/gui/container/tiao0.png");
    private static final ResourceLocation tiao1 = ModMain.prefix("textures/gui/container/tiao1.png");
    private static final ResourceLocation tiao2 = ModMain.prefix("textures/gui/container/tiao2.png");
    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

        this.renderBackground(pGuiGraphics);
        pGuiGraphics.blit(getResourceLocation(), leftPos, topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        LiandanluBlockEntity blockEntity = this.menu.getBlockEntity();
        Optional<LiandanluRecipe> recipeFor = blockEntity.getRecipeFor();

        if(recipeFor.isPresent()){
            int lingliDensity = blockEntity.getLingliDensity();
            int recipelinglidensity = recipeFor.get().getlinglidensity();

            pGuiGraphics.drawString(Minecraft.getInstance().font,
                    Component.translatable("灵力密度："+ lingliDensity).withStyle(ChatFormatting.BLUE)
                    , leftPos+120, topPos+81, 0xFF00ff00, false);



            pGuiGraphics.drawString(Minecraft.getInstance().font,
                    Component.translatable("所需密度："+ recipelinglidensity).withStyle(ChatFormatting.AQUA)
                    , leftPos+120, topPos+46, 0xFF00ff00, false);

            if(lingliDensity<recipelinglidensity){
                pGuiGraphics.drawString(Minecraft.getInstance().font,
                        Component.translatable("密度不够").withStyle(ChatFormatting.DARK_RED)
                        , leftPos+120, topPos+16, 0xFF00ff00, false);

            }



            pGuiGraphics.drawString(Minecraft.getInstance().font,
                    Component.translatable("灵力消耗："+recipeFor.get().getLingli()).withStyle(ChatFormatting.AQUA)
                    , leftPos+120, topPos+31, 0xFF00ff00, false);



            int width = 161;
            int height = 6;
            pGuiGraphics.blit(tiao0, leftPos+7, topPos+118, 0, 0, width, height, width, height);
            float v = (float) blockEntity.getProgress() /blockEntity.getMaxProgress();
            pGuiGraphics.blit(tiao1, leftPos+7, topPos+118, 0, 0, (int) (width*v), height, width, height);
        }
    }

    private ResourceLocation getResourceLocation() {
        int lv = this.menu.getBlockEntity().getLv();
        switch (lv){
            case 0:return liandanlu0;
            case 1:return liandanlu1;
            case 2:return liandanlu2;
            case 3:return liandanlu3;
        }
        return liandanlu3;
    }


    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        pGuiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
//        pGuiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }
}
