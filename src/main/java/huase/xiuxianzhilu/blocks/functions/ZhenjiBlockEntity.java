package huase.xiuxianzhilu.blocks.functions;

import huase.xiuxianzhilu.blocks.BlockEntitiesinit;
import huase.xiuxianzhilu.entity.functions.ZhenfaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * - @description:ZhenjiBlockEntity类
 */
public class ZhenjiBlockEntity extends BlockEntity implements MenuProvider {
    public ZhenjiBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntitiesinit.zhenjiblockentity.get(),pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }

    public void handleLingshi(ItemStack itemstack, Player pPlayer) {
        ZhenfaEntity zhenfaEntity = new ZhenfaEntity(this.level);
        this.level.addFreshEntity(zhenfaEntity);
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }
    }
}
