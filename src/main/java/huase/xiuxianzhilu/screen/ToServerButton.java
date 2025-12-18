package huase.xiuxianzhilu.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

/**
 * - @description:ToServerButton类
 */
public class ToServerButton extends AbstractButton {
    private int index;
    private ReAbstractContainerMenu pMenu;
    public ToServerButton(ReAbstractContainerMenu pMenu, int index, int pX, int pY, int pWidth, int pHeight) {
        super(pX, pY, pWidth, pHeight, Component.translatable("炼制"));
        this.index = index;
        this.pMenu = pMenu;
    }

    @Override
    public void onPress() {
        pMenu.getButtonFunctionMap().get(index).task();
        Minecraft.getInstance().gameMode.handleInventoryButtonClick(pMenu.containerId, index);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

    }
}
