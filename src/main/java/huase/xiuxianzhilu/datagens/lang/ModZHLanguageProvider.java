package huase.xiuxianzhilu.datagens.lang;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaSample;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import huase.xiuxianzhilu.entity.EntityInit;
import huase.xiuxianzhilu.entity.functions.putuan.PutuanEntity;
import huase.xiuxianzhilu.items.Iteminit;
import huase.xiuxianzhilu.worlds.biomes.BiomesInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.LanguageProvider;

public class ModZHLanguageProvider extends LanguageProvider {
    public ModZHLanguageProvider(PackOutput output) {
        super(output, ModMain.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        this.add("境界",                 "境界:%s");
        this.add("层数",                 "层数:%s");
        this.add("修炼速度",                 "修炼速度:%s");
        this.add("经验",                 "经验:%s");
        this.add("修龄",                 "修龄:%s");
        this.add("生命",                 "生命:%s");
        this.add("灵力",                 "灵力:%s");
        this.add("物攻",                 "物攻:%s");
        this.add("命中",                 "命中:%s");
        this.add("爆伤",                 "爆伤:%s");


        this.add("最高境界",                  "最高境界:%s");
        this.add("圆满层数",                  "圆满层数:%s");
        this.add("灵根",                    "灵根:%s");
        this.add("最大经验",                  "最大经验:%s");
        this.add("寿元",                    "寿元:%s");
        this.add("最大生命",                  "最大生命:%s");
        this.add("最大灵力",                  "最大灵力:%s");
        this.add("物防",                    "物防:%s");
        this.add("遁速",                    "遁速:%s");
        this.add("爆率",                    "爆率:%s");
        this.add("吸血",                    "吸血:%s");


        this.add("生命1",                   "血量：%s/%s" );
        this.add("修为1",                   "修为：%s/%s" );
        this.add("灵力1",                   "灵力：%s/%s" );


        this.add("linggen.jin",                     "§e金");
        this.add("linggen.mu",                      "§a木");
        this.add("linggen.shui",                    "§b水");
        this.add("linggen.huo",                     "§c火");
        this.add("linggen.tu",                      "§6土");


        this.add("item.xiuxianzhilu.mosterbaseentity_spawn_egg"  ,"测试实体-刷怪蛋");
        this.add("item.xiuxianzhilu.chilingshuishe_spawn_egg"  ,"赤鳞水虺-刷怪蛋");
        this.add("item.xiuxianzhilu.huanlinghu_spawn_egg"  ,"幻灵狐-刷怪蛋");
        this.add("item.xiuxianzhilu.xueyichanglang_spawn_egg"  ,"雪翼苍狼-刷怪蛋");
        this.add("item.xiuxianzhilu.youmingguishou_spawn_egg"  ,"幽冥鬼手-刷怪蛋");
        this.add("item.xiuxianzhilu.shayingmoxie_spawn_egg"  ,"沙影魔蝎-刷怪蛋");
        this.add("item.xiuxianzhilu.huanduzhu_spawn_egg"  ,"幻毒蛛-刷怪蛋");
        this.add("item.xiuxianzhilu.zuoying_spawn_egg"  ,"烛阴-刷怪蛋");
        this.add("item.xiuxianzhilu.huoqiling_spawn_egg"  ,"火麟兽-刷怪蛋");
        this.add("item.xiuxianzhilu.xvanbingjvxiong_spawn_egg"  ,"玄冰巨熊-刷怪蛋");
        this.add("item.xiuxianzhilu.bingfenghuang_spawn_egg"  ,"冰凤凰-刷怪蛋");
        this.add("item.xiuxianzhilu.kunpeng_spawn_egg"  ,"鲲鹏-刷怪蛋");
        this.add("item.xiuxianzhilu.xiushi_spawn_egg"  ,"鲲鹏-修士");

        this.add(Iteminit.celingzhu.get()  ,"§a测灵珠");
        this.add(Iteminit.lingshi0.get()  ,"§a灵石");
        this.add(Iteminit.lingshi1.get()  ,"§b中阶灵石");
        this.add(Iteminit.lingshi2.get()  ,"§c高阶灵石");
        this.add(Iteminit.tpfu.get()  ,"§a秘境传送符");
        this.add(Iteminit.zhenqi.get()  ,"§a阵旗");
        this.add(Iteminit.putuan.get()  ,"§a蒲团");


        this.add(BlockInit.jvlingzhen0.get()  ,"§a聚灵阵");
        this.add(BlockInit.jvlingzhen1.get()  ,"§b中阶聚灵阵");
        this.add(BlockInit.jvlingzhen2.get()  ,"§c高阶聚灵阵");
        this.add(BlockInit.lingdirblock.get()  ,"§a灵土");





        this.addjingjie(LingxiujingjieGen.lianqi    ,"§a练气");
        this.addjingjie(LingxiujingjieGen.zhuji     ,"§b筑基");
        this.addjingjie(LingxiujingjieGen.jindan    ,"§e金丹");
        this.addjingjie(LingxiujingjieGen.yuanying  ,"§d元婴");
        this.addjingjie(LingxiujingjieGen.huashen   ,"§c化神");

        this.add(Iteminit.jingjie0.get()  ,"§a练气");
        this.add(Iteminit.jingjie1.get()  ,"§b筑基");
        this.add(Iteminit.jingjie2.get()  ,"§e金丹");
        this.add(Iteminit.jingjie3.get()  ,"§d元婴");
        this.add(Iteminit.jingjie4.get()  ,"§c化神");

        this.add(BlockInit.lianqiding0.get()  ,"§a初阳鼎");
        this.add(BlockInit.lianqiding1.get()  ,"§b玄阴鼎");
        this.add(BlockInit.lianqiding2.get()  ,"§e流光鼎");
        this.add(BlockInit.lianqiding3.get()  ,"§d归元鼎");
        this.add(BlockInit.liandanlu0.get()  ,"§a初阳炉");
        this.add(BlockInit.liandanlu1.get()  ,"§b玄阴炉");
        this.add(BlockInit.liandanlu2.get()  ,"§e流光炉");
        this.add(BlockInit.liandanlu3.get()  ,"§d归元炉");

        this.addgongfa(GongfaGen.gongfa0  ,"功法:§a---聚灵诀---");
        this.addgongfa(GongfaGen.gongfa1  ,"功法:§b---凝元功---");
        this.addgongfa(GongfaGen.gongfa2  ,"功法:§e---金丹诀---");
        this.addgongfa(GongfaGen.gongfa3  ,"功法:§d---元婴化神诀---");
        this.addgongfa(GongfaGen.gongfa4  ,"功法:§c---化神归真诀---");

        this.add(Iteminit.gongfa0.get(),  "功法:§a---聚灵诀---");
        this.add(Iteminit.gongfa1.get(),  "功法:§b---凝元功---");
        this.add(Iteminit.gongfa2.get(),  "功法:§e---金丹诀---");
        this.add(Iteminit.gongfa3.get(),  "功法:§d---元婴化神诀---");
        this.add(Iteminit.gongfa4.get(),  "功法:§c---化神归真诀---");


        this.add(Iteminit.linggao0.get(),  "§a<黄>-§b灵镐");
        this.add(Iteminit.linggao1.get(),  "§b<玄>-§b灵镐");
        this.add(Iteminit.linggao2.get(),  "§e<地>-§b灵镐");
        this.add(Iteminit.linggao3.get(),  "§d<天>-§b灵镐");
        this.add(Iteminit.lingjian0.get(),  "§a<黄>-§b灵剑");
        this.add(Iteminit.lingjian1.get(),  "§b<玄>-§b灵剑");
        this.add(Iteminit.lingjian2.get(),  "§e<地>-§b灵剑");
        this.add(Iteminit.lingjian3.get(),  "§d<天>-§b灵剑");

        this.add(Iteminit.jiezhi0.get(),  "法宝:§a---灵戒指---§f<§a黄§f>阶");
        this.add(Iteminit.jiezhi1.get(),  "法宝:§b---灵戒指---§f<§b玄§f>阶");
        this.add(Iteminit.jiezhi2.get(),  "法宝:§e---灵戒指---§f<§e地§f>阶");
        this.add(Iteminit.jiezhi3.get(),  "法宝:§d---灵戒指---§f<§d天§f>阶");
        this.add(Iteminit.xianglian0.get(),  "法宝:§a---灵项链---§f<§a黄§f>阶");
        this.add(Iteminit.xianglian1.get(),  "法宝:§b---灵项链---§f<§b玄§f>阶");
        this.add(Iteminit.xianglian2.get(),  "法宝:§e---灵项链---§f<§e地§f>阶");
        this.add(Iteminit.xianglian3.get(),  "法宝:§d---灵项链---§f<§d天§f>阶");
        this.add(Iteminit.yvpei0.get(),  "法宝:§a---灵玉佩---§f<§a黄§f>阶");
        this.add(Iteminit.yvpei1.get(),  "法宝:§b---灵玉佩---§f<§b玄§f>阶");
        this.add(Iteminit.yvpei2.get(),  "法宝:§e---灵玉佩---§f<§e地§f>阶");
        this.add(Iteminit.yvpei3.get(),  "法宝:§d---灵玉佩---§f<§d天§f>阶");
        this.add(Iteminit.hufu0.get(),  "法宝:§a---灵护符---§f<§a黄§f>阶");
        this.add(Iteminit.hufu1.get(),  "法宝:§b---灵护符---§f<§b玄§f>阶");
        this.add(Iteminit.hufu2.get(),  "法宝:§e---灵护符---§f<§e地§f>阶");
        this.add(Iteminit.hufu3.get(),  "法宝:§d---灵护符---§f<§d天§f>阶");

        this.add("attribute",   "§6面板");
        this.add("fabao",       "§6法宝");
        this.add("lingxiu",     "§6境界");
        this.add("gongfa",      "§6功法");



        this.add(Iteminit.linghe0   .get(),  "灵核:§a---凝气妖丹---");
        this.add(Iteminit.linghe1   .get(),  "灵核:§b---灵风妖丹---");
        this.add(Iteminit.linghe2   .get(),  "灵核:§e---真元妖丹---");
        this.add(Iteminit.linghe3   .get(),  "灵核:§d---真灵妖丹---");
        this.add(Iteminit.xvantie0  .get(),  "玄铁:§a---黑纹铁---");
        this.add(Iteminit.xvantie1  .get(),  "玄铁:§b---百锻玄铁---");
        this.add(Iteminit.xvantie2  .get(),  "玄铁:§e---寒心铁精---");
        this.add(Iteminit.xvantie3  .get(),  "玄铁:§d---星辰玄铁---");
        this.add(Iteminit.lingjin0  .get(),  "仙金:§a---云纹仙金---");
        this.add(Iteminit.lingjin1  .get(),  "仙金:§b---流霞仙金---");
        this.add(Iteminit.lingjin2  .get(),  "仙金:§e---玄霜仙金---");
        this.add(Iteminit.lingjin3  .get(),  "仙金:§d---鸿蒙仙金---");
        this.add(Iteminit.lingyv0   .get(),  "灵玉:§a---青纹灵玉---");
        this.add(Iteminit.lingyv1   .get(),  "灵玉:§b---凝露灵玉---");
        this.add(Iteminit.lingyv2   .get(),  "灵玉:§e---玄心灵玉---");
        this.add(Iteminit.lingyv3   .get(),  "灵玉:§d---通神灵玉---");
        this.add(Iteminit.lingmu0   .get(),  "灵木:§a---月纹木‌---");
        this.add(Iteminit.lingmu1   .get(),  "灵木:§b---凝脂楠‌---");
        this.add(Iteminit.lingmu2   .get(),  "灵木:§e---星叶松---");
        this.add(Iteminit.lingmu3   .get(),  "灵木:§d---若灵木---");

        this.add(Iteminit.danyao0   .get(),  "丹药:§a---裂石丹---");
        this.add(Iteminit.danyao1   .get(),  "丹药:§b---凝血丹---");
        this.add(Iteminit.danyao2   .get(),  "丹药:§e---韧皮丹‌---");
        this.add(Iteminit.danyao3   .get(),  "丹药:§d---聚气丹---");
        this.add(Iteminit.danyao4   .get(),  "丹药:§c---炼气丹---");
        this.add(Iteminit.danyao5   .get(),  "丹药:§a---延寿丹---");
        this.add(Iteminit.danyao6   .get(),  "丹药:§b---回春丹---");
        this.add(Iteminit.danyao7   .get(),  "丹药:§e---灵泉丹---");
        this.add(Iteminit.danyao8   .get(),  "丹药:§d---破山丹‌---");
        this.add(Iteminit.danyao9   .get(),  "丹药:§c---龟息丹---");
        this.add(Iteminit.danyao10   .get(),  "丹药:§a---玄甲丹---");
        this.add(Iteminit.danyao11   .get(),  "丹药:§b---灵海丹‌---");
        this.add(Iteminit.danyao12   .get(),  "丹药:§e---筑基丹---");
        this.add(Iteminit.danyao13   .get(),  "丹药:§d---长春丹---");
        this.add(Iteminit.danyao14   .get(),  "丹药:§c---血莲丹---");
        this.add(Iteminit.danyao15   .get(),  "丹药:§a---续灵丹---");
        this.add(Iteminit.danyao16   .get(),  "丹药:§b---惊雷丹---");
        this.add(Iteminit.danyao17   .get(),  "丹药:§e---龙血丹---");
        this.add(Iteminit.danyao18   .get(),  "丹药:§d---金刚丹‌---");
        this.add(Iteminit.danyao19   .get(),  "丹药:§c---紫府丹---");
        this.add(Iteminit.danyao20   .get(),  "丹药:§a---天尘丹---");
        this.add(Iteminit.danyao21   .get(),  "丹药:§b---驻颜丹---");
        this.add(Iteminit.danyao22   .get(),  "丹药:§e---九转还魂丹---");
        this.add(Iteminit.danyao23   .get(),  "丹药:§d---聚灵丹---");
        this.add(Iteminit.danyao24   .get(),  "丹药:§c---碎星丹‌---");
        this.add(Iteminit.danyao25   .get(),  "丹药:§a---不死金丹---");
        this.add(Iteminit.danyao26   .get(),  "丹药:§b---混元甲丹---");
        this.add(Iteminit.danyao27   .get(),  "丹药:§e---太虚丹---");
        this.add(Iteminit.danyao28   .get(),  "丹药:§d---化神丹‌---");
        this.add(Iteminit.danyao29   .get(),  "丹药:§c---万寿丹---");
        this.add(Iteminit.danyao30   .get(),  "丹药:§a---涅槃丹‌---");
        this.add(Iteminit.danyao31   .get(),  "丹药:§b---灵髓丹---");
        this.add(Iteminit.danyao32   .get(),  "丹药:§e---弑神丹‌---");
        this.add(Iteminit.danyao33   .get(),  "丹药:§d---鸿蒙丹---");
        this.add(Iteminit.danyao34   .get(),  "丹药:§c---混沌甲丹‌---");
        this.add(Iteminit.danyao35   .get(),  "丹药:§a---宇宙丹‌---");
        this.add(Iteminit.danyao36   .get(),  "丹药:§b---飞升丹---");
        this.add(Iteminit.danyao37   .get(),  "丹药:§e---长生丹---");
        this.add(Iteminit.danyao38   .get(),  "丹药:§d---轮回丹---");
        this.add(Iteminit.danyao39   .get(),  "丹药:§c---源初灵丹---");



        this.add(BlockInit.zhiwu0      .get(),  "种子:§a---银月花---");
        this.add(BlockInit.zhiwu1      .get(),  "§a---月纹果---");
        this.add(BlockInit.zhiwu2      .get(),  "种子:§a---恒心草---");
        this.add(BlockInit.zhiwu3      .get(),  "种子:§a---轻灵草---");
        this.add(BlockInit.zhiwu4      .get(),  "种子:§b---流董草---");
        this.add(BlockInit.zhiwu5      .get(),  "§b---凝脂果---");
        this.add(BlockInit.zhiwu6      .get(),  "种子:§b---红绞草---");
        this.add(BlockInit.zhiwu7      .get(),  "种子:§b---龙纹草---");
        this.add(BlockInit.zhiwu8      .get(),  "种子:§e---雪凝花---");
        this.add(BlockInit.zhiwu9      .get(),  "§e---星叶果---");
        this.add(BlockInit.zhiwu10     .get(),  "种子:§e---菩提花---");
        this.add(BlockInit.zhiwu11     .get(),  "种子:§e---冰精莲---");
        this.add(BlockInit.zhiwu12     .get(),  "种子:§d---血菩提---");
        this.add(BlockInit.zhiwu13     .get(),  "§d--若灵果---");
        this.add(BlockInit.zhiwu14     .get(),  "种子:§d---阴凝草---");
        this.add(BlockInit.zhiwu15     .get(),  "种子:§d---火灵莲---");
        this.add(BlockInit.zhiwu16     .get(),  "种子:§c---地心火莲---");
        this.add(BlockInit.zhiwu17     .get(),  "种子:§c---腐骨灵花---");
        this.add(BlockInit.zhiwu18     .get(),  "种子:§c---奇茸通天菊---");
        this.add(BlockInit.zhiwu19     .get(),  "种子:§c---地心淬灵乳---");

        this.add("item.xiuxianzhilu.zhiwu0",      "植物：§a---银月花---");
        this.add("item.xiuxianzhilu.zhiwu1",      "果实：§a---月纹果---");
        this.add("item.xiuxianzhilu.zhiwu2",      "植物：§a---恒心草---");
        this.add("item.xiuxianzhilu.zhiwu3",      "植物：§a---轻灵草---");
        this.add("item.xiuxianzhilu.zhiwu4",      "植物：§b---流董草---");
        this.add("item.xiuxianzhilu.zhiwu5",      "果实：§b---凝脂果---");
        this.add("item.xiuxianzhilu.zhiwu6",      "植物：§b---红绞草---");
        this.add("item.xiuxianzhilu.zhiwu7",      "植物：§b---龙纹草---");
        this.add("item.xiuxianzhilu.zhiwu8",      "植物：§e---雪凝花---");
        this.add("item.xiuxianzhilu.zhiwu9",      "果实：§e---星叶果---");
        this.add("item.xiuxianzhilu.zhiwu10",     "植物：§e---菩提花---");
        this.add("item.xiuxianzhilu.zhiwu11",     "植物：§e---冰精莲---");
        this.add("item.xiuxianzhilu.zhiwu12",     "植物：§d---血菩提---");
        this.add("item.xiuxianzhilu.zhiwu13",     "果实：§d---若灵果---");
        this.add("item.xiuxianzhilu.zhiwu14",     "植物：§d---阴凝草---");
        this.add("item.xiuxianzhilu.zhiwu15",     "植物：§d---火灵莲---");
        this.add("item.xiuxianzhilu.zhiwu16",     "植物：§c---地心火莲---");
        this.add("item.xiuxianzhilu.zhiwu17",     "植物：§c---腐骨灵花---");
        this.add("item.xiuxianzhilu.zhiwu18",     "植物：§c---奇茸通天菊---");
        this.add("item.xiuxianzhilu.zhiwu19",     "植物：§c---地心淬灵乳---");

        this.add(BlockInit.lingmu0_SAPLING     .get(),  "幼苗:§a---月纹木‌---");
        this.add(BlockInit.lingmu1_SAPLING     .get(),  "幼苗:§b---凝脂楠‌---");
        this.add(BlockInit.lingmu2_SAPLING     .get(),  "幼苗:§e---星叶松---");
        this.add(BlockInit.lingmu3_SAPLING     .get(),  "幼苗:§d---若灵木---");

        this.add(BlockInit.lingmu0_LOG     .get(),  "原木:§a---月纹木‌---");
        this.add(BlockInit.lingmu1_LOG     .get(),  "原木:§b---凝脂楠‌---");
        this.add(BlockInit.lingmu2_LOG     .get(),  "原木:§e---星叶松---");
        this.add(BlockInit.lingmu3_LOG     .get(),  "原木:§d---若灵木---");

        this.add(BlockInit.lingmu0_LEAVES     .get(),  "树叶:§a---月纹木‌---");
        this.add(BlockInit.lingmu1_LEAVES     .get(),  "树叶:§b---凝脂楠‌---");
        this.add(BlockInit.lingmu2_LEAVES     .get(),  "树叶:§e---星叶松---");
        this.add(BlockInit.lingmu3_LEAVES     .get(),  "树叶:§d---若灵木---");


        this.add(BlockInit.xvantie0  .get(),  "原矿:§a---黑纹铁---");
        this.add(BlockInit.xvantie1  .get(),  "原矿:§b---百锻玄铁---");
        this.add(BlockInit.xvantie2  .get(),  "原矿:§e---寒心铁精---");
        this.add(BlockInit.xvantie3  .get(),  "原矿:§d---星辰玄铁---");
        this.add(BlockInit.lingjin0  .get(),  "原矿:§a---云纹仙金---");
        this.add(BlockInit.lingjin1  .get(),  "原矿:§b---流霞仙金---");
        this.add(BlockInit.lingjin2  .get(),  "原矿:§e---玄霜仙金---");
        this.add(BlockInit.lingjin3  .get(),  "原矿:§d---鸿蒙仙金---");
        this.add(BlockInit.lingyv0   .get(),  "原矿:§a---青纹灵玉---");
        this.add(BlockInit.lingyv1   .get(),  "原矿:§b---凝露灵玉---");
        this.add(BlockInit.lingyv2   .get(),  "原矿:§e---玄心灵玉---");
        this.add(BlockInit.lingyv3   .get(),  "原矿:§d---通神灵玉---");




        this.addBiome(BiomesInit.xiuxianjie_biome0  ,  "赤水河"        );
        this.addBiome(BiomesInit.xiuxianjie_biome1  ,  "青丘草原"       );
        this.addBiome(BiomesInit.xiuxianjie_biome2  ,  "昆仑山地"       );
        this.addBiome(BiomesInit.xiuxianjie_biome3  ,  "地下幽都"       );
        this.addBiome(BiomesInit.xiuxianjie_biome4  ,  "流沙之墟"       );
        this.addBiome(BiomesInit.xiuxianjie_biome5  ,  "雾凇林海‌"      );
        this.addBiome(BiomesInit.xiuxianjie_biome6  ,  "归墟溟海"       );
        this.addBiome(BiomesInit.xiuxianjie_biome7  ,  "炎火之山‌"      );
        this.addBiome(BiomesInit.xiuxianjie_biome8  ,  "不周雪山"       );
        this.addBiome(BiomesInit.xiuxianjie_biome9  ,  "冰魄寒渊"       );
        this.addBiome(BiomesInit.xiuxianjie_biome10 ,  "黑水玄渊‌"      );



        this.add(EntityInit.mosterbaseentity                  .get(),  "测试实体"           );

        this.add(EntityInit.chilingshuishe                  .get(),  "§a赤鳞水虺"           );
        this.add(EntityInit.huanlinghu                      .get(),  "§a幻灵狐"            );
        this.add(EntityInit.xueyichanglang                  .get(),  "§a雪翼苍狼"           );
        this.add(EntityInit.youmingguishou                  .get(),  "§b幽冥鬼手"           );
        this.add(EntityInit.shayingmoxie                    .get(),  "§b沙影魔蝎"           );
        this.add(EntityInit.huanduzhu                       .get(),  "§b幻毒蛛"            );
        this.add(EntityInit.zuoying                         .get(),  "§e烛阴"         );
        this.add(EntityInit.huoqiling                       .get(),  "§e火麟兽"            );
        this.add(EntityInit.xvanbingjvxiong                 .get(),  "§e玄冰巨熊"           );
        this.add(EntityInit.bingfenghuang                   .get(),  "§d冰凤凰"            );
        this.add(EntityInit.kunpeng                         .get(),  "§c鲲鹏"         );

        this.add(EntityInit.xiushi                         .get(),  "修士"         );

        this.add(PutuanEntity.State.EMPTY,  "挂机"         );
        this.add(PutuanEntity.State.GONGFA, "修炼功法"      );
        this.add(PutuanEntity.State.LINGMAI,"调整灵脉"      );
    }

    private void add(PutuanEntity.State state, String s) {
        this.add("putuan.state."+state.name(),  s);
    }

    private void addgongfa(ResourceKey<GongfaSample> gongfa0, String s) {
        this.add(gongfa0.location().toString(),s);
    }

    private void addjingjie(ResourceKey<LingxiuJingjieSample> jingjieSampleResourceKey, String s) {
        this.add(jingjieSampleResourceKey.location().toString(),s);
    }

    public void addBiome(ResourceKey<Biome> biome, String name) {
        this.add("biome."+ModMain.MOD_ID+"." + biome.location().getPath(), name);
    }
}
