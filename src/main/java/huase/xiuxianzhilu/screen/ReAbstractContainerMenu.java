package huase.xiuxianzhilu.screen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * - @description:ReAbstractContainerMenu类
 */
public abstract class ReAbstractContainerMenu extends AbstractContainerMenu implements ButtonFunction{
    private int index = 0;
    private Map<Integer, ButtonMenu> buttonFunctionMap = new HashMap<>();
    protected ReAbstractContainerMenu(@Nullable MenuType<?> pMenuType, int pContainerId) {
        super(pMenuType, pContainerId);
        createButtonFunctions();
    }



    public void addButtonClientAndServer(int left, int top, int width, int height, ButtonMenu.Task task, Component pMessage) {
        buttonFunctionMap.put(index++,new ButtonMenu(left,top,width,height,task,task,pMessage));
    }

    public void addButtonServer(int left, int top, int width, int height, ButtonMenu.Task task, Component pMessage) {
        buttonFunctionMap.put(index++,new ButtonMenu(left,top,width,height,null,task,pMessage));
    }


    public boolean clickMenuButton(Player pPlayer, int pId) {
        Map<Integer, ButtonMenu> buttonFunctionMap = getButtonFunctionMap();
        ButtonMenu buttonMenu = buttonFunctionMap.get(pId);
        if(buttonMenu.serverrun() != null){
            buttonMenu.serverrun().task();
        }
        return false;
    }

    @Override
    public Map<Integer, ButtonMenu> getButtonFunctionMap() {
        return buttonFunctionMap;
    }

}
