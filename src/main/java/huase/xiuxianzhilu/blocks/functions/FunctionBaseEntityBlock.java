package huase.xiuxianzhilu.blocks.functions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/**
 * - @description:FunctionBaseEntityBlock类
 */
public abstract class FunctionBaseEntityBlock extends BlockEntity {
    public FunctionBaseEntityBlock(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

}
