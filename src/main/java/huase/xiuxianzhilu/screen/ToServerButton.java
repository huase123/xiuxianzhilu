package huase.xiuxianzhilu.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;

/**
 * - @description:ToServerButton类
 */
public class ToServerButton extends AbstractButton {
    private int index;
    private ReAbstractContainerMenu pMenu;


    public ToServerButton(ReAbstractContainerMenu pMenu, Integer key, ButtonMenu buttonMenu) {
        super(buttonMenu.left(),buttonMenu.top(),buttonMenu.width(),buttonMenu.height(), buttonMenu.pMessage());
        this.index = key;
        this.pMenu = pMenu;
    }

    @Override
    public void onPress() {
        ButtonMenu.Task clentrun = pMenu.getButtonFunctionMap().get(index).clentrun();
        if(clentrun != null)clentrun.task();
        Minecraft.getInstance().gameMode.handleInventoryButtonClick(pMenu.containerId, index);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

    }
}
