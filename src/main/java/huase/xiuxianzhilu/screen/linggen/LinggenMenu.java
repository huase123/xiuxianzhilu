package huase.xiuxianzhilu.screen.linggen;

import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
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
public class LinggenMenu extends ReAbstractContainerMenu {
    private Entity prententity;
    private Player player;
    public LinggenMenu(int i, Inventory playerInventory, FriendlyByteBuf friendlyByteBuf) {
        super(MenuTypesInit.linggenmenu.get(), i);
        Entity entity = playerInventory.player.level().getEntity(friendlyByteBuf.readInt());
        if(entity.isAlive()){
            this.prententity = entity;
        }
    }

    public LinggenMenu(int containerId, Inventory playerInventory, Entity prententity) {
        super(MenuTypesInit.linggenmenu.get(),containerId);
        this.prententity = prententity;
        player = playerInventory.player;
    }

    @Override
    public void createButtonFunctions() {
        addButtonFunctions(() -> {
            PlayerCapability capability = (PlayerCapability) CapabilityUtil.getCapability(player);
            CapabilityUtil.openLinggen(capability,player);
        });
    }


    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return prententity.isAlive();
    }

}
