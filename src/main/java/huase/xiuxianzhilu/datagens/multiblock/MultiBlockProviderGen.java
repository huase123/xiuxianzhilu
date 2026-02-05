package huase.xiuxianzhilu.datagens.multiblock;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.recipe.multiblock.BuildMultiBlockRecipe;
import huase.xiuxianzhilu.recipe.multiblock.BuildMultiRecipe;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

/**
 * - @description:RERecipeProvider类
 */
public class MultiBlockProviderGen extends MultiBlockProvider {
    public MultiBlockProviderGen(PackOutput pOutput) {
        super(pOutput, ModMain.MODID);
    }


    @Override
    protected void buildRecipes(Consumer<BuildMultiRecipe> pWriter) {
        buildRecipeszhenfa(pWriter,BlockInit.jvlingzhen0.get(),BlockInit.lingmu0_LOG.get());
        buildRecipeszhenfa(pWriter,BlockInit.jvlingzhen1.get(),BlockInit.lingmu1_LOG.get());
        buildRecipeszhenfa(pWriter,BlockInit.jvlingzhen2.get(),BlockInit.lingmu2_LOG.get());

        buildRecipessquare(pWriter,BlockInit.lianqiding0.get(),BlockInit.lingmu0_LOG.get());
        buildRecipessquare(pWriter,BlockInit.lianqiding1.get(),BlockInit.lingmu1_LOG.get());
        buildRecipessquare(pWriter,BlockInit.lianqiding2.get(),BlockInit.lingmu2_LOG.get());
        buildRecipessquare(pWriter,BlockInit.lianqiding3.get(),BlockInit.lingmu3_LOG.get());

        buildRecipessquare(pWriter,BlockInit.liandanlu0.get(),BlockInit.lingmu0_LOG.get());
        buildRecipessquare(pWriter,BlockInit.liandanlu1.get(),BlockInit.lingmu1_LOG.get());
        buildRecipessquare(pWriter,BlockInit.liandanlu2.get(),BlockInit.lingmu2_LOG.get());
        buildRecipessquare(pWriter,BlockInit.liandanlu3.get(),BlockInit.lingmu3_LOG.get());


//        pWriter.accept(BuildMultiBlockRecipe.builder(
//                MultiBlockPatternBuilder.start( REBlockPredicate.Builder.block().of(BlockInit.jvlingzhen0.get()).build())
//                        .aisle(
//                                "?????"
//                                , "?sss?"
//                                , "?sss?"
//                                , "?sss?"
//                                , "?????"
//                        )
//                        .aisle(
//                                "?sss?"
//                                , "saaas"
//                                , "saxas"
//                                , "saaas"
//                                , "?sss?"
//                        )
//                        .whereresult('x')
//                        .where('?', REBlockPredicate.ANY)
//                        .where('a',  REBlockPredicate.Builder.block().of(Blocks.AIR).build())
//                        .where('s',  REBlockPredicate.Builder.block().of(Blocks.STONE).build())
//        ));
//        pWriter.accept(BuildMultiBlockRecipe.builder(
//                MultiBlockPatternBuilder.start( REBlockPredicate.Builder.block().of(BlockInit.lianqiding0.get()).build())
//                        .aisle(
//                                "?????"
//                                , "?sss?"
//                                , "?sss?"
//                                , "?sss?"
//                                , "?????"
//                        )
//                        .aisle(
//                                "?sss?"
//                                , "saaas"
//                                , "saxas"
//                                , "saaas"
//                                , "?sss?"
//                        )
//                        .whereresult('x')
//                        .where('?', REBlockPredicate.ANY)
//                        .where('a',  REBlockPredicate.Builder.block().of(Blocks.AIR).build())
//                        .where('s',  REBlockPredicate.Builder.block().of(Blocks.STONE).build())
//        ));
//
//        pWriter.accept(BuildMultiBlockRecipe.builder(
//                MultiBlockPatternBuilder.start( REBlockPredicate.Builder.block().of(BlockInit.lianqiding1.get()).build())
//                        .aisle(
//                                "?????"
//                                , "?sss?"
//                                , "?sss?"
//                                , "?sss?"
//                                , "?????"
//                        )
//                        .aisle(
//                                "?sss?"
//                                , "saaas"
//                                , "saxas"
//                                , "saaas"
//                                , "?sss?"
//                        )
//                        .whereresult('x')
//                        .where('?', REBlockPredicate.ANY)
//                        .where('a',  REBlockPredicate.Builder.block().of(Blocks.FLETCHING_TABLE).build())
//                        .where('s',  REBlockPredicate.Builder.block().of(Blocks.SEA_LANTERN).build())
//        ));
//
//
//        pWriter.accept(BuildMultiBlockRecipe.builder(
//                MultiBlockPatternBuilder.start( REBlockPredicate.Builder.block().of(BlockInit.lianqiding3.get()).build())
//                        .aisle(
//                                "?sss?"
//                                , "saaas"
//                                , "saxas"
//                                , "saaas"
//                                , "?sss?"
//                        )
//                        .aisle(
//                                "?sss?"
//                                , "saaas"
//                                , "saxas"
//                                , "saaas"
//                                , "?sss?"
//                        )
//                        .whereresult('x')
//                        .where('?', REBlockPredicate.ANY)
//                        .where('a',  REBlockPredicate.Builder.block().of(Blocks.FLETCHING_TABLE).build())
//                        .where('s',  REBlockPredicate.Builder.block().of(Blocks.SEA_LANTERN).build())
//        ));
//

    }

    private void buildRecipessquare(Consumer<BuildMultiRecipe> pWriter, Block resultblock, Block fillblock) {

        pWriter.accept(BuildMultiBlockRecipe.builder(
                MultiBlockPatternBuilder.start( REBlockPredicate.Builder.block().of(resultblock).build())
                        .aisle(
                         "aaa",
                                "aaa",
                                "aaa"
                        )
                        .aisle(
                                "???",
                                        "?b?",
                                        "???"
                        )
                        .whereresult('b')
                        .where('?', REBlockPredicate.ANY)
                        .where('a',  REBlockPredicate.Builder.block().of(fillblock).build())
        ));
    }
    private void buildRecipeszhenfa(Consumer<BuildMultiRecipe> pWriter, Block resultblock, Block fillblock) {

        pWriter.accept(BuildMultiBlockRecipe.builder(
                MultiBlockPatternBuilder.start( REBlockPredicate.Builder.block().of(resultblock).build())
                        .aisle(
                         "a?a",
                                "?a?",
                                "a?a"
                        )
                        .aisle(
                                "???",
                                        "?b?",
                                        "???"
                        )
                        .whereresult('b')
                        .where('?', REBlockPredicate.ANY)
                        .where('a',  REBlockPredicate.Builder.block().of(fillblock).build())
        ));
    }
}