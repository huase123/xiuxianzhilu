package huase.xiuxianzhilu.blocks.functions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * - @description:StructuralTesting接口
 */
public interface StructuralTesting {

    public abstract boolean isPass(Level pLevel, Player pPlayer, BlockEntity entity, BlockState pState, BlockPos pPos);
}
