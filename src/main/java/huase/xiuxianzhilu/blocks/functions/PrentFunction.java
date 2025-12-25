package huase.xiuxianzhilu.blocks.functions;

import net.minecraft.core.BlockPos;

import java.util.List;

/**
 * - @description:PrentFunction接口
 */
public interface PrentFunction  extends LinkEntity {

    public abstract  List<BlockPos>  getChildBlockPos();

    BlockPos getBlockPos();

    boolean checkScope(BlockPos blockPos);
}
