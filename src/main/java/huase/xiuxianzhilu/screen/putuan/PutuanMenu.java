package huase.xiuxianzhilu.screen.putuan;

import huase.xiuxianzhilu.entity.functions.putuan.PutuanEntity;
import huase.xiuxianzhilu.screen.MenuTypesInit;
import huase.xiuxianzhilu.screen.ReAbstractContainerMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * - @description:LinggenMenu类
 */
public class PutuanMenu extends ReAbstractContainerMenu {
    private PutuanEntity putuan;
    private Player player;
    public PutuanMenu(int i, Inventory playerInventory, FriendlyByteBuf friendlyByteBuf) {
        super(MenuTypesInit.putuanmenu.get(), i);
        Entity entity = playerInventory.player.level().getEntity(friendlyByteBuf.readInt());
        player = playerInventory.player;
        if(entity.isAlive()){
            this.putuan = (PutuanEntity) entity;
        }
    }

    public PutuanMenu(int containerId, Inventory playerInventory, PutuanEntity putuan) {
        super(MenuTypesInit.putuanmenu.get(),containerId);
        this.putuan = putuan;
        player = playerInventory.player;
    }

    @Override
    public void createButtonFunctions() {
        for (PutuanEntity.State value : PutuanEntity.State.values()) {
            addButtonFunctions(() -> {
                putuan.setState(value);
            });
        }

    }


    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return putuan.isAlive();
    }

}
