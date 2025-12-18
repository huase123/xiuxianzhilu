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
import net.minecraftforge.items.IItemHandler;
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
                this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 128 + l * 18));
            }
        }

        for(int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 186));
        }


        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
            int lv = this.blockEntity.getLv();
            createItemHandler(iItemHandler,lv);

        });

        this.addSlot(new resultSolt( this.blockEntity.getResult(), 0, 129,  62));
    }

    private void createItemHandler(IItemHandler iItemHandler, int lv) {
        if(lv >=0){
            for (int i = 0; i < 9; i++) {
                int x = i % 3;
                int y = i / 3;
                this.addSlot(new SlotItemHandler(iItemHandler, i, 8+x*18+18,  26+y*18+18));
            }
        }
        if (lv >= 1) {
            this.addSlot(new SlotItemHandler(iItemHandler, 9, 8+0*18,  26+0*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 10, 8+4*18,  26+0*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 11, 8+0*18,  26+4*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 12, 8+4*18,  26+4*18));
        }
        if (lv >= 2) {
            this.addSlot(new SlotItemHandler(iItemHandler, 13, 8+0*18,  26+1*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 14, 8+1*18,  26+0*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 15, 8+3*18,  26+0*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 16, 8+4*18,  26+1*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 17, 8+0*18,  26+3*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 18, 8+1*18,  26+4*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 19, 8+3*18,  26+4*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 20, 8+4*18,  26+3*18));

        }
        if (lv >= 3) {
            this.addSlot(new SlotItemHandler(iItemHandler, 21, 8+0*18,  26+2*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 22, 8+2*18,  26+0*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 23, 8+2*18,  26+4*18));
            this.addSlot(new SlotItemHandler(iItemHandler, 24, 8+4*18,  26+2*18));
        }
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

    public LianqidingBlockEntity getBlockEntity() {
        return blockEntity;
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
