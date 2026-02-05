package huase.xiuxianzhilu.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.util.Mth;

/**
 * - @description:ToServerButton类
 */
public class ToServerButton extends AbstractButton {
    private int index;
    protected ReAbstractContainerMenu pMenu;


    public ToServerButton(ReAbstractContainerMenu pMenu, Integer key, ButtonMenu buttonMenu, int leftPos, int topPos) {
        super(buttonMenu.left()+leftPos,buttonMenu.top()+topPos,buttonMenu.width(),buttonMenu.height(), buttonMenu.pMessage());
        this.index = key;
        this.pMenu = pMenu;
    }

    @Override
    public void onPress() {
        ButtonMenu.Task clentrun = pMenu.getButtonFunctionMap().get(index).clentrun();
        if(clentrun != null)clentrun.task();
        Minecraft.getInstance().gameMode.handleInventoryButtonClick(pMenu.containerId, index);
    }

    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        Minecraft minecraft = Minecraft.getInstance();
        pGuiGraphics.setColor(1.0F, 1.0F, 1.0F, this.alpha);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        pGuiGraphics.blitNineSliced(WIDGETS_LOCATION, this.getX(), this.getY(), this.getWidth(), this.getHeight(), 20, 4, 200, 20, 0, this.getTextureY());
        pGuiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
        int i = getFGColor();
        this.renderString(pGuiGraphics, minecraft.font, i | Mth.ceil(this.alpha * 255.0F) << 24);
    }


    private int getTextureY() {
        int i = 1;
        if (!this.active) {
            i = 0;
//        } else if (this.isHoveredOrFocused()) {
        } else if (this.isHovered()) {
            i = 2;
        }

        return 46 + i * 20;
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

    }
}
