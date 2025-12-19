package huase.xiuxianzhilu.recipe.multiblock;

import com.google.common.cache.LoadingCache;
import huase.xiuxianzhilu.recipe.MultiBlockRecipeType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;

/**
 * - @description:MultiRecipe类
 */
public interface MultiRecipe<C extends LoadingCache<BlockPos, BlockInWorld>> {
    boolean matches(LoadingCache<BlockPos, BlockInWorld> loadingcache, Level pLevel, BlockPos blockPos);

    MultiBlockRecipeType<?> getType();

}
