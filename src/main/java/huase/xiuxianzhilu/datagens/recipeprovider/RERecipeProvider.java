package huase.xiuxianzhilu.datagens.recipeprovider;

import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.datagens.tag.ItemTagsProvider;
import huase.xiuxianzhilu.items.Iteminit;
import huase.xiuxianzhilu.recipe.BuildLiandanluRecipe;
import huase.xiuxianzhilu.recipe.BuildLianqidingRecipe;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * - @description:RERecipeProvider类
 */
public class RERecipeProvider extends RecipeProvider {
    public RERecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
//        丹药
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao0   .get(), 1).defineLingli(30  ).defineLingliDensity(35     ).define(0,getzhiwu("zhiwu0")).define(1,getzhiwu("zhiwu1")).define(2,getzhiwu("linghe0")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao1   .get(), 1).defineLingli(30  ).defineLingliDensity(35     ).define(0,getzhiwu("zhiwu0")).define(1,getzhiwu("zhiwu2")).define(2,getzhiwu("linghe0")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao2   .get(), 1).defineLingli(30  ).defineLingliDensity(35     ).define(0,getzhiwu("zhiwu0")).define(1,getzhiwu("zhiwu3")).define(2,getzhiwu("linghe0")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao3   .get(), 1).defineLingli(30  ).defineLingliDensity(35     ).define(0,getzhiwu("zhiwu2")).define(1,getzhiwu("zhiwu1")).define(2,getzhiwu("linghe0")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao4   .get(), 1).defineLingli(30  ).defineLingliDensity(35     ).define(0,getzhiwu("zhiwu2")).define(1,getzhiwu("zhiwu3")).define(2,getzhiwu("linghe0")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao5   .get(), 1).defineLingli(30  ).defineLingliDensity(35     ).define(0,getzhiwu("zhiwu3")).define(1,getzhiwu("zhiwu1")).define(2,getzhiwu("linghe0")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao6   .get(), 1).defineLingli(0   ).defineLingliDensity(20     ).define(0,getzhiwu("zhiwu0")).define(1,getzhiwu("zhiwu2")).define(2,getzhiwu("zhiwu1")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao7   .get(), 1).defineLingli(0   ).defineLingliDensity(20     ).define(0,getzhiwu("zhiwu0")).define(1,getzhiwu("zhiwu3")).define(2,getzhiwu("zhiwu1")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao8   .get(), 1).defineLingli(60  ).defineLingliDensity(40     ).define(0,getzhiwu("zhiwu4")).define(1,getzhiwu("zhiwu5")).define(2,getzhiwu("linghe1")).define(3,getzhiwu("zhiwu4")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao9   .get(), 1).defineLingli(60  ).defineLingliDensity(40     ).define(0,getzhiwu("zhiwu4")).define(1,getzhiwu("zhiwu6")).define(2,getzhiwu("linghe1")).define(3,getzhiwu("zhiwu4")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao10  .get(), 1).defineLingli(60  ).defineLingliDensity(40     ).define(0,getzhiwu("zhiwu4")).define(1,getzhiwu("zhiwu7")).define(2,getzhiwu("linghe1")).define(3,getzhiwu("zhiwu4")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao11  .get(), 1).defineLingli(60  ).defineLingliDensity(40     ).define(0,getzhiwu("zhiwu6")).define(1,getzhiwu("zhiwu5")).define(2,getzhiwu("linghe1")).define(3,getzhiwu("zhiwu6")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao12  .get(), 1).defineLingli(60  ).defineLingliDensity(40     ).define(0,getzhiwu("zhiwu6")).define(1,getzhiwu("zhiwu7")).define(2,getzhiwu("linghe1")).define(3,getzhiwu("zhiwu6")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao13  .get(), 1).defineLingli(60  ).defineLingliDensity(40     ).define(0,getzhiwu("zhiwu7")).define(1,getzhiwu("zhiwu5")).define(2,getzhiwu("linghe1")).define(3,getzhiwu("zhiwu7")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao14  .get(), 1).defineLingli(5   ).defineLingliDensity(20     ).define(0,getzhiwu("zhiwu4")).define(1,getzhiwu("zhiwu6")).define(2,getzhiwu("zhiwu5")).define(3,getzhiwu("zhiwu4")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao15  .get(), 1).defineLingli(5   ).defineLingliDensity(20     ).define(0,getzhiwu("zhiwu4")).define(1,getzhiwu("zhiwu7")).define(2,getzhiwu("zhiwu5")).define(3,getzhiwu("zhiwu4")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao16  .get(), 1).defineLingli(120 ).defineLingliDensity(55     ).define(0,getzhiwu("zhiwu8")).define(1,getzhiwu("zhiwu9")).define(2,getzhiwu("linghe2")).define(3,getzhiwu("zhiwu8")).define(4,getzhiwu("zhiwu9")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao17  .get(), 1).defineLingli(120 ).defineLingliDensity(55     ).define(0,getzhiwu("zhiwu8")).define(1,getzhiwu("zhiwu10")).define(2,getzhiwu("linghe2")).define(3,getzhiwu("zhiwu8")).define(4,getzhiwu("zhiwu10")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao18  .get(), 1).defineLingli(120 ).defineLingliDensity(55     ).define(0,getzhiwu("zhiwu8")).define(1,getzhiwu("zhiwu11")).define(2,getzhiwu("linghe2")).define(3,getzhiwu("zhiwu8")).define(4,getzhiwu("zhiwu11")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao19  .get(), 1).defineLingli(120 ).defineLingliDensity(55     ).define(0,getzhiwu("zhiwu10")).define(1,getzhiwu("zhiwu9")).define(2,getzhiwu("linghe2")).define(3,getzhiwu("zhiwu10")).define(4,getzhiwu("zhiwu9")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao20  .get(), 1).defineLingli(120 ).defineLingliDensity(55     ).define(0,getzhiwu("zhiwu10")).define(1,getzhiwu("zhiwu11")).define(2,getzhiwu("linghe2")).define(3,getzhiwu("zhiwu10")).define(4,getzhiwu("zhiwu11")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao21  .get(), 1).defineLingli(120 ).defineLingliDensity(55     ).define(0,getzhiwu("zhiwu11")).define(1,getzhiwu("zhiwu9")).define(2,getzhiwu("linghe2")).define(3,getzhiwu("zhiwu11")).define(4,getzhiwu("zhiwu9")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao22  .get(), 1).defineLingli(10  ).defineLingliDensity(20     ).define(0,getzhiwu("zhiwu8")).define(1,getzhiwu("zhiwu10")).define(2,getzhiwu("zhiwu9")).define(3,getzhiwu("zhiwu8")).define(4,getzhiwu("zhiwu10")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao23  .get(), 1).defineLingli(10  ).defineLingliDensity(20     ).define(0,getzhiwu("zhiwu8")).define(1,getzhiwu("zhiwu11")).define(2,getzhiwu("zhiwu9")).define(3,getzhiwu("zhiwu8")).define(4,getzhiwu("zhiwu11")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao24  .get(), 1).defineLingli(240 ).defineLingliDensity(120        ).define(0,getzhiwu("zhiwu12")).define(1,getzhiwu("zhiwu13")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu12")).define(4,getzhiwu("zhiwu13")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao25  .get(), 1).defineLingli(240 ).defineLingliDensity(120        ).define(0,getzhiwu("zhiwu12")).define(1,getzhiwu("zhiwu14")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu12")).define(4,getzhiwu("zhiwu14")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao26  .get(), 1).defineLingli(240 ).defineLingliDensity(120        ).define(0,getzhiwu("zhiwu12")).define(1,getzhiwu("zhiwu15")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu12")).define(4,getzhiwu("zhiwu15")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao27  .get(), 1).defineLingli(240 ).defineLingliDensity(120        ).define(0,getzhiwu("zhiwu14")).define(1,getzhiwu("zhiwu13")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu14")).define(4,getzhiwu("zhiwu13")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao28  .get(), 1).defineLingli(240 ).defineLingliDensity(120        ).define(0,getzhiwu("zhiwu14")).define(1,getzhiwu("zhiwu15")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu14")).define(4,getzhiwu("zhiwu15")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao29  .get(), 1).defineLingli(240 ).defineLingliDensity(120        ).define(0,getzhiwu("zhiwu15")).define(1,getzhiwu("zhiwu13")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu15")).define(4,getzhiwu("zhiwu13")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao30  .get(), 1).defineLingli(20  ).defineLingliDensity(20     ).define(0,getzhiwu("zhiwu12")).define(1,getzhiwu("zhiwu14")).define(2,getzhiwu("zhiwu13")).define(3,getzhiwu("zhiwu12")).define(4,getzhiwu("zhiwu14")).define(5,getzhiwu("zhiwu13")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao31  .get(), 1).defineLingli(20  ).defineLingliDensity(20     ).define(0,getzhiwu("zhiwu12")).define(1,getzhiwu("zhiwu15")).define(2,getzhiwu("zhiwu13")).define(3,getzhiwu("zhiwu12")).define(4,getzhiwu("zhiwu15")).define(5,getzhiwu("zhiwu13")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao32  .get(), 1).defineLingli(480 ).defineLingliDensity(160        ).define(0,getzhiwu("zhiwu16")).define(1,getzhiwu("zhiwu17")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu16")).define(4,getzhiwu("zhiwu17")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao33  .get(), 1).defineLingli(480 ).defineLingliDensity(160        ).define(0,getzhiwu("zhiwu16")).define(1,getzhiwu("zhiwu18")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu16")).define(4,getzhiwu("zhiwu18")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao34  .get(), 1).defineLingli(480 ).defineLingliDensity(160        ).define(0,getzhiwu("zhiwu16")).define(1,getzhiwu("zhiwu19")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu16")).define(4,getzhiwu("zhiwu19")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao35  .get(), 1).defineLingli(480 ).defineLingliDensity(160        ).define(0,getzhiwu("zhiwu18")).define(1,getzhiwu("zhiwu17")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu18")).define(4,getzhiwu("zhiwu17")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao36  .get(), 1).defineLingli(480 ).defineLingliDensity(160        ).define(0,getzhiwu("zhiwu19")).define(1,getzhiwu("zhiwu19")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu19")).define(4,getzhiwu("zhiwu19")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao37  .get(), 1).defineLingli(480 ).defineLingliDensity(160        ).define(0,getzhiwu("zhiwu19")).define(1,getzhiwu("zhiwu17")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu19")).define(4,getzhiwu("zhiwu17")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao38  .get(), 1).defineLingli(40  ).defineLingliDensity(20     ).define(0,getzhiwu("zhiwu16")).define(1,getzhiwu("zhiwu18")).define(2,getzhiwu("zhiwu17")).define(3,getzhiwu("zhiwu16")).define(4,getzhiwu("zhiwu18")).define(5,getzhiwu("zhiwu17")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao39  .get(), 1).defineLingli(40  ).defineLingliDensity(20     ).define(0,getzhiwu("zhiwu16")).define(1,getzhiwu("zhiwu19")).define(2,getzhiwu("zhiwu17")).define(3,getzhiwu("zhiwu16")).define(4,getzhiwu("zhiwu19")).define(5,getzhiwu("zhiwu17")));







        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.jiezhi0          .get(), 1).defineLingli(60  ).defineLingliDensity(40    ).defines(Iteminit.xvantie0.get(),1,3,7,9).defines(Iteminit.lingjin0.get(),2,4,6,8).defines(Iteminit.linghe0 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.jiezhi1          .get(), 1).defineLingli(120 ).defineLingliDensity(55    ).defines(Iteminit.xvantie1.get(),1,3,7,9,10,11).defines(Iteminit.lingjin1.get(),2,4,6,8,12,13).defines(Iteminit.linghe1 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.jiezhi2          .get(), 1).defineLingli(240 ).defineLingliDensity(80    ).defines(Iteminit.xvantie2.get(),1,3,7,9,10,11,14,15,16,17).defines(Iteminit.lingjin2.get(),2,4,6,8,12,13,18,19,20,21).defines(Iteminit.linghe2 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.jiezhi3          .get(), 1).defineLingli(480 ).defineLingliDensity(120   ).defines(Iteminit.xvantie3.get(),1,3,7,9,10,11,14,15,16,17,22,23).defines(Iteminit.lingjin3.get(),2,4,6,8,12,13,18,19,20,21,24,25).defines(Iteminit.linghe3 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.xianglian0       .get(), 1).defineLingli(60  ).defineLingliDensity(40    ).defines(Iteminit.xvantie0.get(),1,3).defines(Iteminit.lingjin0.get(),7,9).defines(Iteminit.lingyv0 .get(),2,4,6,8).defines(Iteminit.linghe0 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.xianglian1       .get(), 1).defineLingli(120 ).defineLingliDensity(55    ).defines(Iteminit.xvantie1.get(),1,3,10,11).defines(Iteminit.lingjin1.get(),7,9,12,13).defines(Iteminit.lingyv1 .get(),2,4,6,8).defines(Iteminit.linghe1 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.xianglian2       .get(), 1).defineLingli(240 ).defineLingliDensity(80    ).defines(Iteminit.xvantie2.get(),1,3,10,11,14,15,16,17).defines(Iteminit.lingjin2.get(),7,9,12,13,18,19,20,21).defines(Iteminit.lingyv2 .get(),2,4,6,8).defines(Iteminit.linghe2 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.xianglian3       .get(), 1).defineLingli(480 ).defineLingliDensity(120   ).defines(Iteminit.xvantie3.get(),1,3,10,11,14,15,16,17,22,23).defines(Iteminit.lingjin3.get(),7,9,12,13,18,19,20,21,24,25).defines(Iteminit.lingyv3 .get(),2,4,6,8).defines(Iteminit.linghe3 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.yvpei0           .get(), 1).defineLingli(60  ).defineLingliDensity(40    ).defines(Iteminit.lingjin0.get(),1,3,7,9).defines(Iteminit.lingyv0 .get(),2,4,6,8).defines(Iteminit.linghe0 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.yvpei1           .get(), 1).defineLingli(120 ).defineLingliDensity(55    ).defines(Iteminit.lingjin1.get(),1,3,7,9,10,11).defines(Iteminit.lingyv1 .get(),2,4,6,8,12,13).defines(Iteminit.linghe1 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.yvpei2           .get(), 1).defineLingli(240 ).defineLingliDensity(80    ).defines(Iteminit.lingjin2.get(),1,3,7,9,10,11,14,15,16,17).defines(Iteminit.lingyv2 .get(),2,4,6,8,12,13,18,19,20,21).defines(Iteminit.linghe2 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.yvpei3           .get(), 1).defineLingli(480 ).defineLingliDensity(120   ).defines(Iteminit.lingjin3.get(),1,3,7,9,10,11,14,15,16,17,22,23).defines(Iteminit.lingyv3 .get(),2,4,6,8,12,13,18,19,20,21,24,25).defines(Iteminit.linghe3 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.hufu0            .get(), 1).defineLingli(60  ).defineLingliDensity(40    ).defines(Iteminit.lingjin0.get(),1,3,7,9).defines(Iteminit.lingmu0 .get(),2,4,6,8).defines(Iteminit.linghe0 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.hufu1            .get(), 1).defineLingli(120 ).defineLingliDensity(55    ).defines(Iteminit.lingjin1.get(),1,3,7,9,10,11).defines(Iteminit.lingmu1 .get(),2,4,6,8,12,13).defines(Iteminit.linghe1 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.hufu2            .get(), 1).defineLingli(240 ).defineLingliDensity(80    ).defines(Iteminit.lingjin2.get(),1,3,7,9,10,11,14,15,16,17).defines(Iteminit.lingmu2 .get(),2,4,6,8,12,13,18,19,20,21).defines(Iteminit.linghe2 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.hufu3            .get(), 1).defineLingli(480 ).defineLingliDensity(120   ).defines(Iteminit.lingjin3.get(),1,3,7,9,10,11,14,15,16,17,22,23).defines(Iteminit.lingmu3 .get(),2,4,6,8,12,13,18,19,20,21,24,25).defines(Iteminit.linghe3 .get(),5));



        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Iteminit.lingmu0.get())
                .pattern("a a")
                .define('a', BlockInit.lingmu0_LOG.get())
                .unlockedBy(getHasName(Iteminit.lingmu0.get()), has(BlockInit.lingmu0_LOG.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Iteminit.lingmu1.get())
                .pattern("a a")
                .define('a', BlockInit.lingmu1_LOG.get())
                .unlockedBy(getHasName(Iteminit.lingmu1.get()), has(BlockInit.lingmu1_LOG.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Iteminit.lingmu2.get())
                .pattern("a a")
                .define('a', BlockInit.lingmu2_LOG.get())
                .unlockedBy(getHasName(Iteminit.lingmu2.get()), has(BlockInit.lingmu2_LOG.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Iteminit.lingmu3.get())
                .pattern("a a")
                .define('a', BlockInit.lingmu3_LOG.get())
                .unlockedBy(getHasName(Iteminit.lingmu3.get()), has(BlockInit.lingmu3_LOG.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Iteminit.celingzhu.get())
                .pattern(" a ")
                .pattern("aba")
                .pattern(" a ")
                .define('a', ItemTagsProvider.islingshi)
                .define('b', ItemTagsProvider.islingyv)
                .unlockedBy(getHasName(Iteminit.celingzhu.get()), has(ItemTagsProvider.islingyv))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Iteminit.zhenqi.get())
                .pattern("aa ")
                .pattern("ab ")
                .pattern(" b ")
                .define('a', ItemTags.WOOL)
                .define('b', ItemTagsProvider.islingmu)
                .unlockedBy(getHasName(Iteminit.zhenqi.get()), has(ItemTagsProvider.islingmu))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Iteminit.putuan.get())
                .pattern(" a ")
                .pattern("bbb")
                .define('a', Blocks.HAY_BLOCK)
                .define('b', ItemTagsProvider.islingmu)
                .unlockedBy(getHasName(Iteminit.putuan.get()), has(ItemTagsProvider.islingmu))
                .save(pWriter);
//        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Iteminit.lingshi1.get())
//                .pattern("aaa")
//                .pattern("aaa")
//                .pattern("aaa")
//                .define('a', Iteminit.lingshi0.get())
//                .unlockedBy(getHasName(Iteminit.lingshi1.get()), has(Iteminit.lingshi0.get()))
//                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Iteminit.lingshi0.get(),9)
                .requires(Iteminit.lingshi1.get())
                .unlockedBy(getHasName(Iteminit.lingshi0.get()), has(Iteminit.lingshi1.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Iteminit.lingshi1.get(),9)
                .requires(Iteminit.lingshi2.get())
                .unlockedBy(getHasName(Iteminit.lingshi1.get())+"_decompose", has(Iteminit.lingshi2.get()))
                .save(pWriter);


//        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Iteminit.lingshi2.get())
//                .pattern("aaa")
//                .pattern("aaa")
//                .pattern("aaa")
//                .define('a', Iteminit.lingshi1.get())
//                .unlockedBy(getHasName(Iteminit.lingshi2.get()), has(Iteminit.lingshi1.get()))
//                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, BlockInit.lianqiding0.get())
                .pattern("b b")
                .pattern("aba")
                .pattern("bab")
                .define('a', ItemTagsProvider.isxvantie)
                .define('b', ItemTagsProvider.islingjin)
                .unlockedBy(getHasName(Iteminit.lingshi2.get()), has(Iteminit.lingshi1.get()))
                .save(pWriter);

        pWriter.accept(BuildLianqidingRecipe.shapedResult(BlockInit.lianqiding1          .get(), 1).defineLingli(240).defineLingliDensity(80).defines(Iteminit.xvantie1.get(),1,3,7,9,10,11).defines(Iteminit.lingjin1.get(),2,4,6,8,12,13).defines(BlockInit.lianqiding0.get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(BlockInit.lianqiding2          .get(), 1).defineLingli(480).defineLingliDensity(120).defines(Iteminit.xvantie2.get(),1,3,7,9,10,11,14,15,16,17).defines(Iteminit.lingjin2.get(),2,4,6,8,12,13,18,19,20,21).defines(BlockInit.lianqiding1.get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(BlockInit.lianqiding3          .get(), 1).defineLingli(888).defineLingliDensity(160).defines(Iteminit.xvantie3.get(),1,3,7,9,10,11,14,15,16,17,22,23).defines(Iteminit.lingjin3.get(),2,4,6,8,12,13,18,19,20,21,24,25).defines(BlockInit.lianqiding2.get(),5));


        pWriter.accept(BuildLianqidingRecipe.shapedResult(BlockInit.liandanlu0          .get(), 1).defineLingli(60).defineLingliDensity(20).defines(Iteminit.xvantie0.get(),7,9).defines(Iteminit.lingjin0.get(),2,4,6,8).defines(Iteminit.linghe0 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(BlockInit.liandanlu1          .get(), 1).defineLingli(240).defineLingliDensity(80).defines(Iteminit.xvantie1.get(),7,9,10,11).defines(Iteminit.lingjin1.get(),2,4,6,8,12,13).defines(BlockInit.liandanlu0 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(BlockInit.liandanlu2          .get(), 1).defineLingli(480).defineLingliDensity(120).defines(Iteminit.xvantie2.get(),7,9,10,11,14,15,16,17).defines(Iteminit.lingjin2.get(),2,4,6,8,12,13,18,19,20,21).defines(BlockInit.liandanlu1 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(BlockInit.liandanlu3          .get(), 1).defineLingli(888).defineLingliDensity(160).defines(Iteminit.xvantie3.get(),7,9,10,11,14,15,16,17,22,23).defines(Iteminit.lingjin3.get(),2,4,6,8,12,13,18,19,20,21,24,25).defines(BlockInit.liandanlu2 .get(),5));



        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.tpfu.get(), 2).defineLingli(20).defineLingliDensity(10).defines(ItemTagsProvider.islingmu,2,4,6,8));


        pWriter.accept(BuildLianqidingRecipe.shapedResult(BlockInit.jvlingzhen0.get(), 1).defineLingli(0).defineLingliDensity(10).defines(Iteminit.zhenqi.get(),4,5,6));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(BlockInit.jvlingzhen1.get(), 1).defineLingli(240).defineLingliDensity(80).defines(Iteminit.zhenqi.get(),4,5,6,10,11,12,13));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(BlockInit.jvlingzhen2.get(), 1).defineLingli(480).defineLingliDensity(120).defines(Iteminit.zhenqi.get(),4,5,6,10,11,12,13,14,15,16,17,18,19,20,21));


    }

    private @NotNull Item getzhiwu(String s) {
            Optional<RegistryObject<Item>> any = BlockInit.ITEMS.getEntries().stream().filter(
                    c ->c.getId().getPath().equals(s)
            ).findAny();
            if(any.isEmpty()){
                any = Iteminit.ITEMS.getEntries().stream().filter(
                        c ->c.getId().getPath().equals(s)
                ).findAny();
            }
            return any.get().get();
    }
}