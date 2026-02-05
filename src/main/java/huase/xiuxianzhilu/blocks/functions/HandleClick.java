package huase.xiuxianzhilu.blocks.functions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * - @description:HandleClick接口
 */
public interface HandleClick {
     void handleClick(Level pLevel, Player pPlayer, BlockEntity entity, BlockState pState, BlockPos pPos);
}
