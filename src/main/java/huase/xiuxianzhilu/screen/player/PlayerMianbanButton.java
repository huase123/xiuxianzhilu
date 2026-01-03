package huase.xiuxianzhilu.screen.player;

import com.mojang.blaze3d.systems.RenderSystem;
import huase.xiuxianzhilu.screen.ButtonMenu;
import huase.xiuxianzhilu.screen.ToServerButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;

/**
 * - @description:PlayerMianbanButton类
 */
public class PlayerMianbanButton extends ToServerButton {
    private static final net.minecraft.resources.ResourceLocation CREATIVE_INVENTORY_TABS_IMAGE =
            new net.minecraft.resources.ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
    public PlayerMianbanButton(PlayerAttrubuteContainerMenu pMenu, int index, ButtonMenu buttonMenu, int leftPos, int topPos) {
        super(pMenu,index,buttonMenu,leftPos,topPos);
    }


    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        Minecraft minecraft = Minecraft.getInstance();
        pGuiGraphics.setColor(1.0F, 1.0F, 1.0F, this.alpha);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();

//        pGuiGraphics.blit(CREATIVE_INVENTORY_TABS_IMAGE, this.getX(), this.getY()+(this.isFocused()? 3:0), 0, this.isFocused()? 30+3:0, this.getWidth(), this.getHeight());
        pGuiGraphics.blit(CREATIVE_INVENTORY_TABS_IMAGE, this.getX(), this.getY()+(this.isFocused()? 3:0),this.getWidth(), this.getHeight(), 0, this.isFocused()? 30+3:0, 26, 30,256,256);


        pGuiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
        int i = getFGColor();
        this.renderString(pGuiGraphics, minecraft.font, i | Mth.ceil(this.alpha * 255.0F) << 24);
    }



}
