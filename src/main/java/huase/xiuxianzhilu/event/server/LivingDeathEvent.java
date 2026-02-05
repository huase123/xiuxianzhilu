//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package huase.xiuxianzhilu.event.server;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = ModMain.MODID, bus = Bus.FORGE)
public class LivingDeathEvent {
    @SubscribeEvent
    public static void livingDeathEvent(net.minecraftforge.event.entity.living.LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity != null && !entity.level().isClientSide) {
            if (entity instanceof ServerPlayer player) {
                playerDeath(player);

//                if (event.getSource().is(SHDamageTypeTagsProvider.istianjie)) {
//                    playerDeathTianjie(player);
//                }
            }

        }
    }

//    死于天劫
//    private static void playerDeathTianjie(Player player) {
////        寿元减半
//        AttrubuteAPI.addShouyuan(player,AttrubuteAPI.getShouyuan(player));
//
//    }

    private static void playerDeath(Player player) {
        CapabilityUtil.addShouyuan(player, -3);
    }
}
