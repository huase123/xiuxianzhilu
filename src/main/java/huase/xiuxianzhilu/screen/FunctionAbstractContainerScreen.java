package huase.xiuxianzhilu.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/**
 * - @description:FunctionAbstractContainerScreen类
 */
public abstract class FunctionAbstractContainerScreen<T extends ReAbstractContainerMenu> extends AbstractContainerScreen<T> {
    public FunctionAbstractContainerScreen(T pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        createToServerButton((T)this.menu);
    }
    public abstract void createToServerButton(T pMenu);

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

    }
}
