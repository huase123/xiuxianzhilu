package huase.xiuxianzhilu.items.danyao;

import huase.xiuxianzhilu.ModMain;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.stats.StatType;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:UseStats类
 */
public class UseStats {
    public static final DeferredRegister<StatType<?>> ITEMSUSED = DeferredRegister.create(ForgeRegistries.STAT_TYPES, ModMain.MODID);

    public static RegistryObject<StatType<Item>> danyaoused = ITEMSUSED.register("danyaoused", () -> new StatType<>(BuiltInRegistries.ITEM));
}
