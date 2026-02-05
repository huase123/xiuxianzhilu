package huase.xiuxianzhilu.screen;

import huase.xiuxianzhilu.ModMain;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import java.util.Map;

/**
 * - @description:FunctionAbstractContainerScreen类
 */
public abstract class FunctionAbstractContainerScreen<T extends ReAbstractContainerMenu> extends AbstractContainerScreen<T> {
    public FunctionAbstractContainerScreen(T pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;
        createToServerButton((T)this.menu);
    }
    public void createToServerButton(T pMenu){
        Map<Integer, ButtonMenu> buttonFunctionMap = pMenu.getButtonFunctionMap();
        for (Map.Entry<Integer, ButtonMenu> integerButtonMenuEntry : buttonFunctionMap.entrySet()) {
            ButtonMenu buttonMenu = integerButtonMenuEntry.getValue();
            ToServerButton toServerButton = new ToServerButton(pMenu,integerButtonMenuEntry.getKey(),buttonMenu,this.leftPos,this.topPos);
            this.addRenderableWidget(toServerButton);
        }
    }


    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

    }

    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {

    }


    protected  void checkButtonNum(int index){
        if(index != this.menu.getButtonFunctionMap().size()){
            ModMain.LOGGER.error("客户端与服务端按钮创建数量不对");
        }
    };
}
