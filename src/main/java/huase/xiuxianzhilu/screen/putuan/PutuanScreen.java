package huase.xiuxianzhilu.screen.putuan;

import huase.xiuxianzhilu.entity.functions.putuan.PutuanEntity;
import huase.xiuxianzhilu.screen.FunctionAbstractContainerScreen;
import huase.xiuxianzhilu.screen.ToServerButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/**
 * - @description:LinggenScreen类
 */
public class PutuanScreen extends FunctionAbstractContainerScreen<PutuanMenu> {
    public PutuanScreen(PutuanMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    public void createToServerButton(PutuanMenu pMenu) {
        int index = 0;
        PutuanEntity.State[] values = PutuanEntity.State.values();
        for (PutuanEntity.State value : values) {
            int i = index % 2 * 2 - 1;
            int i1 = (index+1) / 2 * i * 70;
            ToServerButton toServerButton = new ToServerButton(pMenu, index++, width/2-100, height/2-30+i1, 200,60,Component.translatable("putuan.state."+value.name()));
            this.addRenderableWidget(toServerButton);
        }

        this.checkButtonNum(index);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

    }
}
