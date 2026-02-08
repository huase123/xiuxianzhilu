package huase.xiuxianzhilu.items;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.items.cailiao.CailiaoSampleItem;
import huase.xiuxianzhilu.items.danyao.DanyaoSampleItem;
import huase.xiuxianzhilu.items.fabao.FabaoSampleItem;
import huase.xiuxianzhilu.items.functions.*;
import huase.xiuxianzhilu.items.gongfa.GongfaSampleItem;
import huase.xiuxianzhilu.items.jingjie.JingjieSampleItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * - @description:inti类
 */
public class Iteminit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModMain.MODID);
    public static List<RegistryObject<Item>> gongfaSamplelist = new ArrayList();
    public static List<RegistryObject<Item>> jingjielist = new ArrayList();
    public static List<RegistryObject<Item>> fabaolist = new ArrayList();
    public static List<RegistryObject<Item>> cailiaolist = new ArrayList();
    public static List<RegistryObject<Item>> danyaolist = new ArrayList();
    public static List<RegistryObject<Item>> arromlist = new ArrayList();


    public static final RegistryObject<Item> linggao0 = ITEMS.register("linggao0", () -> new ToolItem(0));
    public static final RegistryObject<Item> linggao1 = ITEMS.register("linggao1", () -> new ToolItem(1));
    public static final RegistryObject<Item> linggao2 = ITEMS.register("linggao2", () -> new ToolItem(2));
    public static final RegistryObject<Item> linggao3 = ITEMS.register("linggao3", () -> new ToolItem(3));

    public static final RegistryObject<Item> lingjian0 = ITEMS.register("lingjian0", () -> new LingSwordItem(0));
    public static final RegistryObject<Item> lingjian1 = ITEMS.register("lingjian1", () -> new LingSwordItem(1));
    public static final RegistryObject<Item> lingjian2 = ITEMS.register("lingjian2", () -> new LingSwordItem(2));
    public static final RegistryObject<Item> lingjian3 = ITEMS.register("lingjian3", () -> new LingSwordItem(3));


    public static final RegistryObject<Item> ling_helmet0     = registerArrom("ling_helmet0"    ,  () -> new LingArmorItem(0,ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> ling_chestplate0 = registerArrom("ling_chestplate0",  () -> new LingArmorItem(0,ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> ling_leggings0   = registerArrom("ling_leggings0"  ,  () -> new LingArmorItem(0,ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> ling_boots0      = registerArrom("ling_boots0"     ,  () -> new LingArmorItem(0,ArmorItem.Type.BOOTS));

    public static final RegistryObject<Item> ling_helmet1     = registerArrom("ling_helmet1",      () -> new LingArmorItem(1,ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> ling_chestplate1 = registerArrom("ling_chestplate1",  () -> new LingArmorItem(1,ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> ling_leggings1   = registerArrom("ling_leggings1",    () -> new LingArmorItem(1,ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> ling_boots1      = registerArrom("ling_boots1",       () -> new LingArmorItem(1,ArmorItem.Type.BOOTS));

    public static final RegistryObject<Item> ling_helmet2     = registerArrom("ling_helmet2",      () -> new LingArmorItem(2,ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> ling_chestplate2 = registerArrom("ling_chestplate2",  () -> new LingArmorItem(2,ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> ling_leggings2   = registerArrom("ling_leggings2",    () -> new LingArmorItem(2,ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> ling_boots2      = registerArrom("ling_boots2",       () -> new LingArmorItem(2,ArmorItem.Type.BOOTS));

    public static final RegistryObject<Item> ling_helmet3     = registerArrom("ling_helmet3",      () -> new LingArmorItem(3,ArmorItem.Type.HELMET));
    public static final RegistryObject<Item> ling_chestplate3 = registerArrom("ling_chestplate3",  () -> new LingArmorItem(3,ArmorItem.Type.CHESTPLATE));
    public static final RegistryObject<Item> ling_leggings3   = registerArrom("ling_leggings3",    () -> new LingArmorItem(3,ArmorItem.Type.LEGGINGS));
    public static final RegistryObject<Item> ling_boots3      = registerArrom("ling_boots3",       () -> new LingArmorItem(3,ArmorItem.Type.BOOTS));

    public static final RegistryObject<Item> celingzhu = ITEMS.register("celingzhu", () -> new Item(new Item.Properties().stacksTo(1)) {
        public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
            pTooltip.add(Component.translatable("拿手上可观察到天地间的灵力浓度").withStyle(ChatFormatting.GREEN));
        }
    });
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new ExampleItem(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build())));
    public static final RegistryObject<Item> zhenqi = ITEMS.register("zhenqi", () -> new ZhenqiItem());
    public static final RegistryObject<Item> putuan = ITEMS.register("putuan", () -> new PutuanItem());

    public static final RegistryObject<Item> tpfu = ITEMS.register("tpfu", () -> new TPFuItem());
    public static final RegistryObject<Item> lingshi0 = ITEMS.register("lingshi0", () -> new LingshiItem());
    public static final RegistryObject<Item> lingshi1 = ITEMS.register("lingshi1", () -> new LingshiItem());
    public static final RegistryObject<Item> lingshi2 = ITEMS.register("lingshi2", () -> new LingshiItem());

//    public static final RegistryObject<Item> gongfa0 = ITEMS.register("gongfa0", () -> new GongfaSampleItem());
    public static final RegistryObject<Item> gongfa0 = registerGongfa("gongfa_0", () ->new GongfaSampleItem());
    public static final RegistryObject<Item> gongfa1 = registerGongfa("gongfa_1", () ->new GongfaSampleItem());
    public static final RegistryObject<Item> gongfa2 = registerGongfa("gongfa_2", () ->new GongfaSampleItem());
    public static final RegistryObject<Item> gongfa3 = registerGongfa("gongfa_3", () ->new GongfaSampleItem());
    public static final RegistryObject<Item> gongfa4 = registerGongfa("gongfa_4", () ->new GongfaSampleItem());

    public static final RegistryObject<Item> jingjie0 = registerJingjie("jingjie0", () ->new JingjieSampleItem());
    public static final RegistryObject<Item> jingjie1 = registerJingjie("jingjie1", () ->new JingjieSampleItem());
    public static final RegistryObject<Item> jingjie2 = registerJingjie("jingjie2", () ->new JingjieSampleItem());
    public static final RegistryObject<Item> jingjie3 = registerJingjie("jingjie3", () ->new JingjieSampleItem());
    public static final RegistryObject<Item> jingjie4 = registerJingjie("jingjie4", () ->new JingjieSampleItem());
    public static final RegistryObject<Item> jingjie5 = registerJingjie("jingjie5", () ->new JingjieSampleItem());

    public static final RegistryObject<Item> jiezhi0 = registerFabao("jiezhi0", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> jiezhi1 = registerFabao("jiezhi1", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> jiezhi2 = registerFabao("jiezhi2", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> jiezhi3 = registerFabao("jiezhi3", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> xianglian0 = registerFabao("xianglian0", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> xianglian1 = registerFabao("xianglian1", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> xianglian2 = registerFabao("xianglian2", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> xianglian3 = registerFabao("xianglian3", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> yvpei0 = registerFabao("yvpei0", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> yvpei1 = registerFabao("yvpei1", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> yvpei2 = registerFabao("yvpei2", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> yvpei3 = registerFabao("yvpei3", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> hufu0 = registerFabao("hufu0", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> hufu1 = registerFabao("hufu1", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> hufu2 = registerFabao("hufu2", () ->new FabaoSampleItem());
    public static final RegistryObject<Item> hufu3 = registerFabao("hufu3", () ->new FabaoSampleItem());

    public static final RegistryObject<Item> linghe0 = registerCailiao("linghe0", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> linghe1 = registerCailiao("linghe1", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> linghe2 = registerCailiao("linghe2", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> linghe3 = registerCailiao("linghe3", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> xvantie0 = registerCailiao("xvantie0", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> xvantie1 = registerCailiao("xvantie1", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> xvantie2 = registerCailiao("xvantie2", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> xvantie3 = registerCailiao("xvantie3", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> lingjin0 = registerCailiao("lingjin0", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> lingjin1 = registerCailiao("lingjin1", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> lingjin2 = registerCailiao("lingjin2", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> lingjin3 = registerCailiao("lingjin3", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> lingyv0 = registerCailiao("lingyv0", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> lingyv1 = registerCailiao("lingyv1", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> lingyv2 = registerCailiao("lingyv2", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> lingyv3 = registerCailiao("lingyv3", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> lingmu0 = registerCailiao("lingmu0", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> lingmu1 = registerCailiao("lingmu1", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> lingmu2 = registerCailiao("lingmu2", () ->new CailiaoSampleItem());
    public static final RegistryObject<Item> lingmu3 = registerCailiao("lingmu3", () ->new CailiaoSampleItem());

    public static final RegistryObject<Item> danyao0 = registerDanyao("danyao0", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao1 = registerDanyao("danyao1", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao2 = registerDanyao("danyao2", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao3 = registerDanyao("danyao3", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao4 = registerDanyao("danyao4", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao5 = registerDanyao("danyao5", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao6 = registerDanyao("danyao6", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao7 = registerDanyao("danyao7", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao8 = registerDanyao("danyao8", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao9 = registerDanyao("danyao9", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao10 = registerDanyao("danyao10", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao11 = registerDanyao("danyao11", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao12 = registerDanyao("danyao12", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao13 = registerDanyao("danyao13", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao14 = registerDanyao("danyao14", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao15 = registerDanyao("danyao15", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao16 = registerDanyao("danyao16", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao17 = registerDanyao("danyao17", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao18 = registerDanyao("danyao18", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao19 = registerDanyao("danyao19", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao20 = registerDanyao("danyao20", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao21 = registerDanyao("danyao21", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao22 = registerDanyao("danyao22", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao23 = registerDanyao("danyao23", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao24 = registerDanyao("danyao24", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao25 = registerDanyao("danyao25", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao26 = registerDanyao("danyao26", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao27 = registerDanyao("danyao27", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao28 = registerDanyao("danyao28", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao29 = registerDanyao("danyao29", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao30 = registerDanyao("danyao30", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao31 = registerDanyao("danyao31", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao32 = registerDanyao("danyao32", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao33 = registerDanyao("danyao33", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao34 = registerDanyao("danyao34", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao35 = registerDanyao("danyao35", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao36 = registerDanyao("danyao36", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao37 = registerDanyao("danyao37", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao38 = registerDanyao("danyao38", () ->new DanyaoSampleItem());
    public static final RegistryObject<Item> danyao39 = registerDanyao("danyao39", () ->new DanyaoSampleItem());

    private static  <T extends Item> RegistryObject<Item> registerDanyao(String string, Supplier<T> item) {
        RegistryObject<Item> register = ITEMS.register(string, item);
        danyaolist.add(register);
        return register;
    }
    private static  <T extends Item> RegistryObject<Item> registerCailiao(String string, Supplier<T> item) {
        RegistryObject<Item> register = ITEMS.register(string, item);
        cailiaolist.add(register);
        return register;
    }
    private static  <T extends Item> RegistryObject<Item> registerGongfa(String string, Supplier<T> item) {
        RegistryObject<Item> register = ITEMS.register(string, item);
        gongfaSamplelist.add(register);
        return register;
    }
    private static  <T extends Item> RegistryObject<Item> registerArrom(String string, Supplier<T> item) {
        RegistryObject<Item> register = ITEMS.register(string, item);
        arromlist.add(register);
        return register;
    }
    private static  <T extends Item> RegistryObject<Item> registerJingjie(String string, Supplier<T> item) {
        RegistryObject<Item> register = ITEMS.register(string, item);
        jingjielist.add(register);
        return register;
    }
    private static  <T extends Item> RegistryObject<Item> registerFabao(String string, Supplier<T> item) {
        RegistryObject<Item> register = ITEMS.register(string, item);
        fabaolist.add(register);
        return register;
    }
}
