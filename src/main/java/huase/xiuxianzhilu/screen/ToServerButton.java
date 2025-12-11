package huase.xiuxianzhilu.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.CommonComponents;

/**
 * - @description:ToServerButton类
 */
public class ToServerButton extends AbstractButton {
    private int index;
    private ReAbstractContainerMenu pMenu;
    public ToServerButton(ReAbstractContainerMenu pMenu, int index, int pX, int pY, int pWidth, int pHeight) {
        super(pX, pY, pWidth, pHeight, CommonComponents.GUI_OK);
        this.index = index;
        this.pMenu = pMenu;
    }

    @Override
    public void onPress() {

        Minecraft.getInstance().gameMode.handleInventoryButtonClick(pMenu.containerId, index);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

    }
}
