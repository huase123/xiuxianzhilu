package huase.xiuxianzhilu.screen.linggen;

import huase.xiuxianzhilu.screen.FunctionAbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/**
 * - @description:LinggenScreen类
 */
public class LinggenScreen  extends FunctionAbstractContainerScreen<LinggenMenu> {
    public LinggenScreen(LinggenMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

    }
}
