package huase.xiuxianzhilu.items;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen;
import huase.xiuxianzhilu.items.functions.LingshiItem;
import huase.xiuxianzhilu.items.gongfa.GongfaSampleItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:inti类
 */
public class Iteminit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModMain.MODID);
    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new ExampleItem(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build())));
    public static final RegistryObject<Item> lingshi = ITEMS.register("lingshi", () -> new LingshiItem());
    public static final RegistryObject<Item> gongfa0 = ITEMS.register("gongfa0", () -> new GongfaSampleItem());
    public static final RegistryObject<Item> gongfa1 = ITEMS.register("gongfa1", () -> new GongfaSampleItem());
    public static final RegistryObject<Item> gongfa2 = ITEMS.register("gongfa2", () -> new GongfaSampleItem());
    public static final RegistryObject<Item> gongfa3 = ITEMS.register("gongfa3", () -> new GongfaSampleItem());
    public static final RegistryObject<Item> gongfa4 = ITEMS.register("gongfa4", () -> new GongfaSampleItem());

    static {
        GongfaGen.gongfa_key_REGISTER.getEntries().stream().forEach(e ->{
            ModMain.LOGGER.info("开始注册功法物品");
            ITEMS.register(e.getKey().toString()+"aaa", () -> new GongfaSampleItem());
        });
    }

}
