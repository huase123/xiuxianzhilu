package huase.xiuxianzhilu.screen;

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
    private Map<Integer, Task> buttonFunctionMap = new HashMap<>();
    protected ReAbstractContainerMenu(@Nullable MenuType<?> pMenuType, int pContainerId) {
        super(pMenuType, pContainerId);
        createButtonFunctions();
    }

    public void addButtonFunctions(Task task) {
        buttonFunctionMap.put(index++,task);
    }

    public boolean clickMenuButton(Player pPlayer, int pId) {
        Map<Integer, Task> buttonFunctionMap = getButtonFunctionMap();
        Task task = buttonFunctionMap.get(pId);
        if(task != null){
            task.task();
        }
        return false;
    }

    @Override
    public Map<Integer, Task> getButtonFunctionMap() {
        return buttonFunctionMap;
    }
}
