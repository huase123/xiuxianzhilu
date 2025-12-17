package huase.xiuxianzhilu.screen.lianqiding;

import huase.xiuxianzhilu.blocks.functions.lianqiding.LianqidingBlockEntity;
import huase.xiuxianzhilu.screen.MenuTypesInit;
import huase.xiuxianzhilu.screen.ReAbstractContainerMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

/**
 * - @description:LinggenMenu类
 */
public class LianqidingMenu extends ReAbstractContainerMenu {
    private Player player;
    private LianqidingBlockEntity blockEntity;

    public LianqidingMenu(int containerId, Inventory playerInventory, FriendlyByteBuf friendlyByteBuf) {
        this(containerId,playerInventory, playerInventory.player.level().getBlockEntity(friendlyByteBuf.readBlockPos()));
    }
    public LianqidingMenu(int containerId, Inventory playerInventory, BlockEntity blockEntity) {
        super(MenuTypesInit.lianqidingmenu.get(),containerId);
        this.player = playerInventory.player;
        this.blockEntity = (LianqidingBlockEntity) blockEntity;


        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + 18));
            }
        }

        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 161 + 18));
        }


        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
            int slots1 = iItemHandler.getSlots();
            for (int i = 0; i < slots1; i++) {
                int x = i % 7;
                int y = i / 7;
                this.addSlot(new SlotItemHandler(iItemHandler, i, 100+x*18,  y*18));
            }
        });

        this.addSlot(new resultSolt( this.blockEntity.getResult(), 0, 0,  0));
    }

    @Override
    public void createButtonFunctions() {
        addButtonFunctions(() -> {
            blockEntity.startPlayer(player);
        });
    }


    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return !blockEntity.isRemoved();
    }



    class resultSolt extends Slot {

        public resultSolt(Container pContainer, int pSlot, int pX, int pY) {
            super(pContainer, pSlot, pX, pY);
        }

        //能否放置
        @Override
        public boolean mayPlace(@NotNull ItemStack stack)
        {
            return false;
        }
        /**
         * Return whether this slot's stack can be taken from this slot.
         */
        @Override
        @NotNull
        public ItemStack remove(int amount)
        {
            return ItemStack.EMPTY;
        }
        public boolean isActive() {
            return true;
        }
    }
}
