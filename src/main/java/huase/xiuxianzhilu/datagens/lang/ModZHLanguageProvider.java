package huase.xiuxianzhilu.datagens.lang;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaSample;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import huase.xiuxianzhilu.items.Iteminit;
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
    }

    private void addgongfa(ResourceKey<GongfaSample> gongfa0, String s) {
        this.add(gongfa0.location().toString(),s);
    }

    private void addjingjie(ResourceKey<LingxiuJingjieSample> jingjieSampleResourceKey, String s) {
        this.add(jingjieSampleResourceKey.location().toString(),s);
    }

    public void addBiome(ResourceKey<Biome> biome, String name) {
        this.add("biome.shxiuxian." + biome.location().getPath(), name);
    }
}
