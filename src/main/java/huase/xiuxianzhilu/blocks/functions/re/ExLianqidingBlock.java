package huase.xiuxianzhilu.blocks.functions.re;

import huase.xiuxianzhilu.blocks.functions.FunctionBaseEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEventListener;
import org.jetbrains.annotations.Nullable;

/**
 * - @description:ExLianqidingBlock类
 */
public class ExLianqidingBlock extends FunctionBaseEntity {
    protected ExLianqidingBlock(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
//        return super.getTicker(pLevel, pState, pBlockEntityType);
        return super.getTicker(pLevel, pState, pBlockEntityType);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> GameEventListener getListener(ServerLevel pLevel, T pBlockEntity) {
        return super.getListener(pLevel, pBlockEntity);
    }

    @Override
    public void handleClick(Level pLevel, Player pPlayer, BlockEntity entity, BlockState pState, BlockPos pPos) {

    }

    @Override
    public boolean isPass(Level pLevel, Player pPlayer, BlockEntity entity, BlockState pState, BlockPos pPos) {
        return false;
    }
}
