package huase.xiuxianzhilu.screen;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.screen.linggen.LinggenMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:MenuTypesInit类
 */
public class MenuTypesInit {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ModMain.MOD_ID);

    public static final RegistryObject<MenuType<LinggenMenu>> linggenmenu =
            registerMenuType("pot_menu", LinggenMenu::new);


    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }


}
