package huase.xiuxianzhilu.screen.linggen;

import huase.xiuxianzhilu.screen.FunctionAbstractContainerScreen;
import huase.xiuxianzhilu.screen.Task;
import huase.xiuxianzhilu.screen.ToServerButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import java.util.Map;

/**
 * - @description:LinggenScreen类
 */
public class LinggenScreen  extends FunctionAbstractContainerScreen<LinggenMenu> {
    public LinggenScreen(LinggenMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    public void createToServerButton(LinggenMenu pMenu) {
        Map<Integer, Task> buttonFunctionMap = pMenu.getButtonFunctionMap();
        int index = 0;
        ToServerButton toServerButton = new ToServerButton(pMenu, index++, width/2-100, height/2-30, 200,60);
        this.addRenderableWidget(toServerButton);

        this.checkButtonNum(index);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

    }
}
