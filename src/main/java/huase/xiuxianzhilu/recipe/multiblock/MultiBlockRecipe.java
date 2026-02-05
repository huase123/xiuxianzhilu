package huase.xiuxianzhilu.recipe.multiblock;

import com.google.common.cache.LoadingCache;
import huase.xiuxianzhilu.datagens.multiblock.MultiBlockPattern;
import huase.xiuxianzhilu.datagens.multiblock.MultiBlockPatternBuilder;
import huase.xiuxianzhilu.recipe.MultiBlockRecipeType;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;


public class MultiBlockRecipe implements MultiRecipe<LoadingCache<BlockPos, BlockInWorld>> {
    private ResourceLocation id;
    private MultiBlockPatternBuilder multiBlockPatternBuilder;
    private MultiBlockPattern multiBlockPattern;

    public MultiBlockRecipe(MultiBlockPatternBuilder multiBlockPatternBuilder, ResourceLocation id) {
        this.id = id;
        this.multiBlockPatternBuilder = multiBlockPatternBuilder;
        this.multiBlockPattern = multiBlockPatternBuilder.build();
    }

    @Override
    public boolean matches(BlockEntity entity) {

        if(multiBlockPatternBuilder.getResult().match(entity)){
            return true;
        }

        return false;
    }

    @Override
    public boolean matches(Level pLevel, BlockPos blockPos) {
        return  multiBlockPattern.matches(pLevel, blockPos,multiBlockPatternBuilder);
    }

    public ResourceLocation getId() {
        return id;
    }

    public MultiBlockPatternBuilder getMultiBlockPatternBuilder() {
        return multiBlockPatternBuilder;
    }

    public MultiBlockPattern getMultiBlockPattern() {
        return multiBlockPattern;
    }

    @Override
    public MultiBlockRecipeType<?> getType() {
        return MultiBlockRecipeType.multiblockrecipe;
    }


}
