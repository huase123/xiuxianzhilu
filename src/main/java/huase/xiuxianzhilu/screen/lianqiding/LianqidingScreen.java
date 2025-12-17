package huase.xiuxianzhilu.screen.lianqiding;

import huase.xiuxianzhilu.ModMain;
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
public class LianqidingScreen extends FunctionAbstractContainerScreen<LianqidingMenu> {
    public LianqidingScreen(LianqidingMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    public void createToServerButton(LianqidingMenu pMenu) {
        Map<Integer, Task> buttonFunctionMap = pMenu.getButtonFunctionMap();
        int index = 0;
        ToServerButton toServerButton = new ToServerButton(pMenu, index++, width/2, height/2, 40,20);
        this.addRenderableWidget(toServerButton);

        if(index != buttonFunctionMap.size()){
            ModMain.LOGGER.info("客户端与服务端按钮创建数量不对");
        }
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

    }
}
