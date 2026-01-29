package huase.xiuxianzhilu.datagens.recipeprovider;

import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.items.Iteminit;
import huase.xiuxianzhilu.recipe.BuildLiandanluRecipe;
import huase.xiuxianzhilu.recipe.BuildLianqidingRecipe;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
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

        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao0.get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu0")).define(1,getzhiwu("zhiwu1")).define(2,getzhiwu("linghe0")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao1.get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu0")).define(1,getzhiwu("zhiwu2")).define(2,getzhiwu("linghe0")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao2.get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu0")).define(1,getzhiwu("zhiwu3")).define(2,getzhiwu("linghe0")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao3.get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu2")).define(1,getzhiwu("zhiwu1")).define(2,getzhiwu("linghe0")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao4.get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu2")).define(1,getzhiwu("zhiwu3")).define(2,getzhiwu("linghe0")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao5.get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu3")).define(1,getzhiwu("zhiwu1")).define(2,getzhiwu("linghe0")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao6.get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu0")).define(1,getzhiwu("zhiwu2")).define(2,getzhiwu("zhiwu1")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao7.get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu0")).define(1,getzhiwu("zhiwu3")).define(2,getzhiwu("zhiwu1")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao8   .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu4")).define(1,getzhiwu("zhiwu5")).define(2,getzhiwu("linghe1")).define(3,getzhiwu("zhiwu4")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao9   .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu4")).define(1,getzhiwu("zhiwu6")).define(2,getzhiwu("linghe1")).define(3,getzhiwu("zhiwu4")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao10  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu4")).define(1,getzhiwu("zhiwu7")).define(2,getzhiwu("linghe1")).define(3,getzhiwu("zhiwu4")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao11  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu6")).define(1,getzhiwu("zhiwu5")).define(2,getzhiwu("linghe1")).define(3,getzhiwu("zhiwu6")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao12  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu6")).define(1,getzhiwu("zhiwu7")).define(2,getzhiwu("linghe1")).define(3,getzhiwu("zhiwu6")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao13  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu7")).define(1,getzhiwu("zhiwu5")).define(2,getzhiwu("linghe1")).define(3,getzhiwu("zhiwu7")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao14  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu4")).define(1,getzhiwu("zhiwu6")).define(2,getzhiwu("zhiwu5")).define(3,getzhiwu("zhiwu4")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao15  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu4")).define(1,getzhiwu("zhiwu7")).define(2,getzhiwu("zhiwu5")).define(3,getzhiwu("zhiwu4")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao16  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu8")).define(1,getzhiwu("zhiwu9")).define(2,getzhiwu("linghe2")).define(3,getzhiwu("zhiwu8")).define(4,getzhiwu("zhiwu9")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao17  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu8")).define(1,getzhiwu("zhiwu10")).define(2,getzhiwu("linghe2")).define(3,getzhiwu("zhiwu8")).define(4,getzhiwu("zhiwu10")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao18  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu8")).define(1,getzhiwu("zhiwu11")).define(2,getzhiwu("linghe2")).define(3,getzhiwu("zhiwu8")).define(4,getzhiwu("zhiwu11")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao19  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu10")).define(1,getzhiwu("zhiwu9")).define(2,getzhiwu("linghe2")).define(3,getzhiwu("zhiwu10")).define(4,getzhiwu("zhiwu9")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao20  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu10")).define(1,getzhiwu("zhiwu11")).define(2,getzhiwu("linghe2")).define(3,getzhiwu("zhiwu10")).define(4,getzhiwu("zhiwu11")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao21  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu11")).define(1,getzhiwu("zhiwu9")).define(2,getzhiwu("linghe2")).define(3,getzhiwu("zhiwu11")).define(4,getzhiwu("zhiwu9")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao22  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu8")).define(1,getzhiwu("zhiwu10")).define(2,getzhiwu("zhiwu9")).define(3,getzhiwu("zhiwu8")).define(4,getzhiwu("zhiwu10")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao23  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu8")).define(1,getzhiwu("zhiwu11")).define(2,getzhiwu("zhiwu9")).define(3,getzhiwu("zhiwu8")).define(4,getzhiwu("zhiwu11")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao24  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu12")).define(1,getzhiwu("zhiwu13")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu12")).define(4,getzhiwu("zhiwu13")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao25  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu12")).define(1,getzhiwu("zhiwu14")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu12")).define(4,getzhiwu("zhiwu14")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao26  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu12")).define(1,getzhiwu("zhiwu15")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu12")).define(4,getzhiwu("zhiwu15")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao27  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu14")).define(1,getzhiwu("zhiwu13")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu14")).define(4,getzhiwu("zhiwu13")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao28  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu14")).define(1,getzhiwu("zhiwu15")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu14")).define(4,getzhiwu("zhiwu15")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao29  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu15")).define(1,getzhiwu("zhiwu13")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu15")).define(4,getzhiwu("zhiwu13")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao30  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu12")).define(1,getzhiwu("zhiwu14")).define(2,getzhiwu("zhiwu13")).define(3,getzhiwu("zhiwu12")).define(4,getzhiwu("zhiwu14")).define(5,getzhiwu("zhiwu13")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao31  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu12")).define(1,getzhiwu("zhiwu15")).define(2,getzhiwu("zhiwu13")).define(3,getzhiwu("zhiwu12")).define(4,getzhiwu("zhiwu15")).define(5,getzhiwu("zhiwu13")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao32  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu16")).define(1,getzhiwu("zhiwu17")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu16")).define(4,getzhiwu("zhiwu17")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao33  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu16")).define(1,getzhiwu("zhiwu18")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu16")).define(4,getzhiwu("zhiwu18")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao34  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu16")).define(1,getzhiwu("zhiwu19")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu16")).define(4,getzhiwu("zhiwu19")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao35  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu18")).define(1,getzhiwu("zhiwu17")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu18")).define(4,getzhiwu("zhiwu17")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao36  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu19")).define(1,getzhiwu("zhiwu19")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu19")).define(4,getzhiwu("zhiwu19")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao37  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu19")).define(1,getzhiwu("zhiwu17")).define(2,getzhiwu("linghe3")).define(3,getzhiwu("zhiwu19")).define(4,getzhiwu("zhiwu17")).define(5,getzhiwu("linghe3")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao38  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu16")).define(1,getzhiwu("zhiwu18")).define(2,getzhiwu("zhiwu17")).define(3,getzhiwu("zhiwu16")).define(4,getzhiwu("zhiwu18")).define(5,getzhiwu("zhiwu17")));
        pWriter.accept(BuildLiandanluRecipe.shapedResult(Iteminit.danyao39  .get(), 1).defineLingli(100).defineLingliDensity(10).define(0,getzhiwu("zhiwu16")).define(1,getzhiwu("zhiwu19")).define(2,getzhiwu("zhiwu17")).define(3,getzhiwu("zhiwu16")).define(4,getzhiwu("zhiwu19")).define(5,getzhiwu("zhiwu17")));







        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.jiezhi0          .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.xvantie0.get(),1,3,7,9).defines(Iteminit.lingjin0.get(),2,4,6,8).defines(Iteminit.linghe0 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.jiezhi1          .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.xvantie1.get(),1,3,7,9,10,11).defines(Iteminit.lingjin1.get(),2,4,6,8,12,13).defines(Iteminit.linghe1 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.jiezhi2          .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.xvantie2.get(),1,3,7,9,10,11,14,15,16).defines(Iteminit.lingjin2.get(),2,4,6,8,12,13,18,19,20,21).defines(Iteminit.linghe2 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.jiezhi3          .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.xvantie3.get(),1,3,7,9,10,11,14,15,16,22,23).defines(Iteminit.lingjin3.get(),2,4,6,8,12,13,18,19,20,21,24,25).defines(Iteminit.linghe3 .get(),5));


        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.xianglian0       .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.xvantie0.get(),1,3).defines(Iteminit.lingjin0.get(),7,9).defines(Iteminit.lingyv0 .get(),2,4,6,8).defines(Iteminit.linghe0 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.xianglian1       .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.xvantie1.get(),1,3,10,11).defines(Iteminit.lingjin1.get(),7,9,12,13).defines(Iteminit.lingyv1 .get(),2,4,6,8).defines(Iteminit.linghe1 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.xianglian2       .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.xvantie2.get(),1,3,10,11,14,15,16).defines(Iteminit.lingjin2.get(),7,9,12,13,18,19,20).defines(Iteminit.lingyv2 .get(),2,4,6,8).defines(Iteminit.linghe2 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.xianglian3       .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.xvantie3.get(),1,3,10,11,14,15,16,22,23).defines(Iteminit.lingjin3.get(),7,9,12,13,18,19,20,24,25).defines(Iteminit.lingyv3 .get(),2,4,6,8).defines(Iteminit.linghe3 .get(),5));


        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.yvpei0           .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.lingjin0.get(),1,3,7,9).defines(Iteminit.lingyv0 .get(),2,4,6,8).defines(Iteminit.linghe0 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.yvpei1           .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.lingjin1.get(),1,3,7,9,10,11).defines(Iteminit.lingyv1 .get(),2,4,6,8,12,13).defines(Iteminit.linghe1 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.yvpei2           .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.lingjin2.get(),1,3,7,9,10,11,14,15,16).defines(Iteminit.lingyv2 .get(),2,4,6,8,12,13,18,19,20).defines(Iteminit.linghe2 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.yvpei3           .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.lingjin3.get(),1,3,7,9,10,11,14,15,16,22,23).defines(Iteminit.lingyv3 .get(),2,4,6,8,12,13,18,19,20,24,25).defines(Iteminit.linghe3 .get(),5));


        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.hufu0            .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.lingjin0.get(),1,3,7,9).defines(Iteminit.lingmu0 .get(),2,4,6,8).defines(Iteminit.linghe0 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.hufu1            .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.lingjin1.get(),1,3,7,9,10,11).defines(Iteminit.lingmu1 .get(),2,4,6,8,12,13).defines(Iteminit.linghe1 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.hufu2            .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.lingjin2.get(),1,3,7,9,10,11,14,15,16).defines(Iteminit.lingmu2 .get(),2,4,6,8,12,13,18,19,20).defines(Iteminit.linghe2 .get(),5));
        pWriter.accept(BuildLianqidingRecipe.shapedResult(Iteminit.hufu3            .get(), 1).defineLingli(100).defineLingliDensity(10).defines(Iteminit.lingjin3.get(),1,3,7,9,10,11,14,15,16,22,23).defines(Iteminit.lingmu3 .get(),2,4,6,8,12,13,18,19,20,24,25).defines(Iteminit.linghe3 .get(),5));

//
//        for (int i = 0; i < 11; i++) {
//            BuildLianqidingRecipe define = BuildLianqidingRecipe.shapedResult(Items.STONE, 10+i)
//                    .define(0, Items.STONE)
//                    .define(1, Items.STONE)
//                    .define(2, Items.STONE)
//                    .define(3, Items.STONE)
//                    .defineLingli(100)
//                    .defineLingliDensity(10)
//                    ;
//
//            pWriter.accept(define);
//
//        }
//        for (int i = 0; i < 11; i++) {
//            BuildLianqidingRecipe define = BuildLianqidingRecipe.shapedResult(Items.RED_BED, 10+i)
//                    .define(0, Items.STONE)
//                    .define(1, Items.STONE)
//                    .define(11, Items.STONE)
//                    .define(9, Items.STONE)
//                    .defineLingli(20)
//                    ;
//            pWriter.accept(define);
//
//        }
//        for (int i = 0; i < 5; i++) {
//            BuildLiandanluRecipe define = BuildLiandanluRecipe.shapedResult(Iteminit.danyao0.get(), 10+i)
//                    .define(0, Items.STONE)
//                    .define(1, Items.STONE)
//                    .define(2, Items.STONE)
//                    .defineLingli(20)
//                    ;
//            pWriter.accept(define);
//
//        }
//        for (int i = 0; i < 5; i++) {
//            BuildLiandanluRecipe define = BuildLiandanluRecipe.shapedResult(Iteminit.danyao1.get(), 10+i)
//                    .define(0, Items.STONE)
//                    .define(1, Items.STONE)
//                    .define(2, Items.STONE)
//                    .define(3, Items.STONE)
//                    .define(4, Items.STONE)
//                    .define(5, Items.STONE)
//                    .defineLingli(20)
//                    ;
//            pWriter.accept(define);
//
//        }
//        for (int i = 0; i < 5; i++) {
//            BuildLiandanluRecipe define = BuildLiandanluRecipe.shapedResult(Iteminit.danyao2.get(), 10+i)
//                    .define(0, Items.STONE)
//                    .define(1, Items.STONE)
//                    .define(2, Items.STONE)
//                    .define(3, Items.STONE)
//                    .defineLingli(20)
//                    ;
//            pWriter.accept(define);
//
//        }
//        for (int i = 0; i < 5; i++) {
//            BuildLiandanluRecipe define = BuildLiandanluRecipe.shapedResult(Iteminit.danyao3.get(), 10+i)
//                    .define(0, Items.STONE)
//                    .define(1, Items.STONE)
//                    .define(2, Items.STONE)
//                    .define(3, Items.STONE)
//                    .define(4, Items.STONE)
//                    .defineLingli(20)
//                    ;
//            pWriter.accept(define);
//
//        }
//

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