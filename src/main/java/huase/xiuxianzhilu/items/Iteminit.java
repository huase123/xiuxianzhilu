package huase.xiuxianzhilu.items;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.items.functions.LingshiItem;
import huase.xiuxianzhilu.items.functions.PutuanItem;
import huase.xiuxianzhilu.items.functions.ZhenqiItem;
import huase.xiuxianzhilu.items.gongfa.GongfaSampleItem;
import huase.xiuxianzhilu.items.jingjie.JingjieSampleItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new ExampleItem(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build())));
    public static final RegistryObject<Item> ZhenqiItem = ITEMS.register("zhenqiitem", () -> new ZhenqiItem());
    public static final RegistryObject<Item> putuan = ITEMS.register("putuan", () -> new PutuanItem());
    public static final RegistryObject<Item> lingshi = ITEMS.register("lingshi", () -> new LingshiItem());

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

    private static  <T extends Item> RegistryObject<Item> registerGongfa(String string, Supplier<T> item) {
        RegistryObject<Item> register = ITEMS.register(string, item);
        gongfaSamplelist.add(register);
        return register;
    }
    private static  <T extends Item> RegistryObject<Item> registerJingjie(String string, Supplier<T> item) {
        RegistryObject<Item> register = ITEMS.register(string, item);
        jingjielist.add(register);
        return register;
    }
}
