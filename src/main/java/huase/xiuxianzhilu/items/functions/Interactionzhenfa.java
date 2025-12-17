package huase.xiuxianzhilu.items.functions;

import huase.xiuxianzhilu.blocks.functions.jvlingzhen.JvlingzhenEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * - @description:Interactionzhenfa接口
 */
public interface Interactionzhenfa {

    public void interactionzhenfa(ItemStack itemInHand, JvlingzhenEntity jvlingzhenEntity, Player player);

    void interactionzhenfa(Level pLevel, Player pPlayer, BlockEntity entity, BlockState pState, BlockPos pPos);

}
