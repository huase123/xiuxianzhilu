package huase.xiuxianzhilu.screen.player;


import huase.xiuxianzhilu.screen.MenuTypesInit;
import huase.xiuxianzhilu.screen.ReAbstractContainerMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class PlayerAttrubuteContainerMenu extends ReAbstractContainerMenu implements MenuProvider {
    public final Player player;
    private final Level level;
    private final ContainerData data;

    public PlayerAttrubuteContainerMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player, new SimpleContainerData(7));
    }
    public PlayerAttrubuteContainerMenu(int pContainerId, Inventory inv, Player player) {
        this(pContainerId, inv, inv.player, new SimpleContainerData(7));
    }

    public PlayerAttrubuteContainerMenu(int pContainerId, Inventory inv, Player entity, ContainerData data) {
        super(MenuTypesInit.playerattrubutecontainermenu.get(), pContainerId);
        checkContainerSize(inv, 7);
        player = ((Player) entity);
        this.level = inv.player.level();
        this.data = data;
    }


    @Override
    public void createButtonFunctions() {

    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("player.shanhaicontinent.player_attrubute_station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return this;
    }



}
