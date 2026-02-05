package huase.xiuxianzhilu.blocks.functions;

import net.minecraft.core.BlockPos;

import java.util.List;

/**
 * - @description:ChildFunction接口
 */
public interface ChildFunction extends LinkEntity {

    public abstract List<BlockPos> getPrentBlockPos();

    BlockPos getBlockPos();

    boolean checkScope(BlockPos blockPos);

    int getLingliDensity();
}
