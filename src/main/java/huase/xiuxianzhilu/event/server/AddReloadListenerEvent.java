package huase.xiuxianzhilu.event.server;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.recipe.multiblock.BuildMultiBlockRecipeManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * - @description:AddReloadListenerEvent类
 */
@Mod.EventBusSubscriber(modid = ModMain.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AddReloadListenerEvent {

    public static BuildMultiBlockRecipeManager INSTANCE;

    @SubscribeEvent
    public static void onResourceReload(net.minecraftforge.event.AddReloadListenerEvent event)
    {
        INSTANCE = new BuildMultiBlockRecipeManager();
        event.addListener(INSTANCE);
    }
}
