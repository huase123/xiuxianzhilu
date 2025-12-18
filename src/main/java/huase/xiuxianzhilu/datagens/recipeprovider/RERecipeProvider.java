package huase.xiuxianzhilu.datagens.recipeprovider;

import huase.xiuxianzhilu.recipe.BuildLianqidingRecipe;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

/**
 * - @description:RERecipeProvider类
 */
public class RERecipeProvider extends RecipeProvider implements IConditionBuilder {
    public RERecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        for (int i = 0; i < 11; i++) {
            BuildLianqidingRecipe define = BuildLianqidingRecipe.shapedResult(Items.STONE, 10+i)
                    .define(0, Items.STONE)
                    .define(1, Items.STONE)
                    .define(2, Items.STONE)
                    .define(3, Items.STONE);
            pWriter.accept(define);

        }
        for (int i = 0; i < 11; i++) {
            BuildLianqidingRecipe define = BuildLianqidingRecipe.shapedResult(Items.RED_BED, 10+i)
                    .define(0, Items.STONE)
                    .define(1, Items.STONE)
                    .define(11, Items.STONE)
                    .define(9, Items.STONE);
            pWriter.accept(define);

        }
    }

}