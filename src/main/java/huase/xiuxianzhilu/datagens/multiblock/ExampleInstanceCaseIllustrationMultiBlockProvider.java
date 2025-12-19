package huase.xiuxianzhilu.datagens.multiblock;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.recipe.multiblock.BuildMultiBlockRecipe;
import huase.xiuxianzhilu.recipe.multiblock.BuildMultiRecipe;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

/**
 * - @description:RERecipeProvider类
 */
public class ExampleInstanceCaseIllustrationMultiBlockProvider extends MultiBlockProvider {
    public ExampleInstanceCaseIllustrationMultiBlockProvider(PackOutput pOutput) {
        super(pOutput, ModMain.MODID);
    }


    @Override
    protected void buildRecipes(Consumer<BuildMultiRecipe> pWriter) {
        pWriter.accept(BuildMultiBlockRecipe.builder(
                MultiBlockPatternBuilder.start( REBlockPredicate.Builder.block().of(BlockInit.lianaqiding0.get()).build())
                        .aisle(
                                "?sss?",
                                "saaas",
                                "sa?as",
                                "saaas",
                                "?sss?")
                        .aisle(
                                "?????",
                                "?sss?",
                                "?sss?",
                                "?sss?",
                                "?????")
                        .where('?', REBlockPredicate.ANY)
                        .where('a',  REBlockPredicate.Builder.block().of(Blocks.AIR).build())
                        .where('s',  REBlockPredicate.Builder.block().of(Blocks.STONE).build())
//                        .build()
        ));
    }
}