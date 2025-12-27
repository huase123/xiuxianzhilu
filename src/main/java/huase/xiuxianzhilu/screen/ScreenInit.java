package huase.xiuxianzhilu.screen;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.screen.lianqiding.LianqidingScreen;
import huase.xiuxianzhilu.screen.linggen.LinggenScreen;
import huase.xiuxianzhilu.screen.putuan.PutuanScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * - @description:ScreenInit类
 */
@Mod.EventBusSubscriber(modid = ModMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ScreenInit {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(MenuTypesInit.linggenmenu.get(), LinggenScreen::new);
        MenuScreens.register(MenuTypesInit.lianqidingmenu.get(), LianqidingScreen::new);
        MenuScreens.register(MenuTypesInit.putuanmenu.get(), PutuanScreen::new);
    }
}
