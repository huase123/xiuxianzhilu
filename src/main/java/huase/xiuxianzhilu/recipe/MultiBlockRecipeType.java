package huase.xiuxianzhilu.recipe;

import huase.xiuxianzhilu.recipe.multiblock.MultiBlockRecipe;
import huase.xiuxianzhilu.recipe.multiblock.MultiRecipe;

/**
 * - @description:MultiBlockRecipeType类
 */
public interface MultiBlockRecipeType<T extends MultiRecipe<?>> {
    MultiBlockRecipeType<MultiBlockRecipe> multiblockrecipe = new MultiBlockRecipeType() {
        @Override
        public String toString() {
            return "multiblockrecipe";
        }
    };
}
