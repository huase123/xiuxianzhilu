package huase.xiuxianzhilu.event.client;

import com.mojang.blaze3d.platform.InputConstants;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.network.NetworkHandler;
import huase.xiuxianzhilu.network.client.CPacketOpenAttrGUI;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

public class KeyMappingInit {
    // In some physical client only class

    // Key mapping is lazily initialized so it doesn't exist until it is registered
//    public static final KeyMapping HUNJI = new KeyMapping(
//            "技能开关", // Will be localized using this translation key
//            InputConstants.Type.KEYSYM, // Default mapping is on the keyboard
//            GLFW.GLFW_KEY_R, // Default key is P
//            SHMainBus.MOD_ID // Mapping will be in the misc category
//        );
    public static final KeyMapping ATTRIBUTE_MAPPING = new KeyMapping(
            "属性面板",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_O,
            ModMain.MOD_ID
    );
    @Mod.EventBusSubscriber(modid = ModMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class RegisterBindings {
        // Event is on the mod event bus only on the physical client
        @SubscribeEvent
        public static void registerBindings(RegisterKeyMappingsEvent event) {
            event.register(ATTRIBUTE_MAPPING);
        }
    }

    @Mod.EventBusSubscriber(modid = ModMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class OnClientTick{
        // Event is on the Forge event bus only on the physical client
/**
 * TODO 功能描述：游戏随时触发
 * @author :huase
 * @date 2026/1/15 1:47
 */
//        @SubscribeEvent
        public static void onKeyPressed(InputEvent.Key event) {
            if(event.getAction() == InputConstants.PRESS){
                if (ATTRIBUTE_MAPPING.getKey().getValue() == event.getKey()) {
                    NetworkHandler.INSTANCE.sendToServer(new CPacketOpenAttrGUI());
                }
            }
        }
        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent event) {
            if (event.phase == TickEvent.Phase.END) { // Only call code once as the tick event is called twice every tick
                if (ATTRIBUTE_MAPPING.consumeClick()) {
                    NetworkHandler.INSTANCE.sendToServer(new CPacketOpenAttrGUI());
                }
            }

        }
    }
}
