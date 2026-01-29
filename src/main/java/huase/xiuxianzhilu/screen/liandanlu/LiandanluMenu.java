package huase.xiuxianzhilu.screen.liandanlu;

import huase.xiuxianzhilu.blocks.functions.liandanlu.LiandanluBlockEntity;
import huase.xiuxianzhilu.screen.MenuTypesInit;
import huase.xiuxianzhilu.screen.ReAbstractContainerMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
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
public class LiandanluMenu extends ReAbstractContainerMenu {
    private Player player;
    private LiandanluBlockEntity blockEntity;

    public LiandanluMenu(int containerId, Inventory playerInventory, FriendlyByteBuf friendlyByteBuf) {
        this(containerId,playerInventory, playerInventory.player.level().getBlockEntity(friendlyByteBuf.readBlockPos()));
    }
    public LiandanluMenu(int containerId, Inventory playerInventory, BlockEntity blockEntity) {
        super(MenuTypesInit.liandanlumenu.get(),containerId);
        this.player = playerInventory.player;
        this.blockEntity = (LiandanluBlockEntity) blockEntity;


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
            this.addSlot(new SlotItemHandler(iItemHandler, 0, 44,  62));
            this.addSlot(new SlotItemHandler(iItemHandler, 1, 44+18,  62));
            this.addSlot(new SlotItemHandler(iItemHandler, 2, 44+36,  62));
        }
        if (lv >= 1) {
            this.addSlot(new SlotItemHandler(iItemHandler, 0, 44-18,  62));
        }
        if (lv >= 2) {
            this.addSlot(new SlotItemHandler(iItemHandler, 0, 44-18,  62-18));
        }
        if (lv >= 3) {
            this.addSlot(new SlotItemHandler(iItemHandler, 0, 44-18,  62+18));
        }
    }
    @Override
    public void createButtonFunctions() {
        addButtonClientAndServer(119,96,40,20,() -> blockEntity.handleButtonClick(player), Component.translatable("炼制"));
    }


    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return !blockEntity.isRemoved();
    }

    public LiandanluBlockEntity getBlockEntity() {
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
