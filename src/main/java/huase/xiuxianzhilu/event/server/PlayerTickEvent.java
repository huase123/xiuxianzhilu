package huase.xiuxianzhilu.event.server;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.RegisterCapabilitys;
import huase.xiuxianzhilu.capabilitys.capability.DensityFunction;
import huase.xiuxianzhilu.network.NetworkHandler;
import huase.xiuxianzhilu.network.server.DensityFunctionPacketCapability;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;

@Mod.EventBusSubscriber(modid = ModMain.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerTickEvent {

    @SubscribeEvent
    public static void onStartTracking(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (event.phase == TickEvent.Phase.END) {
            if (!player.isDeadOrDying()) {
                updatesganwu(player);
            }
        }

    }

    private static void updatesganwu(Player player) {
        player.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).ifPresent(playerCapability -> {
            DensityFunction densityFunction = playerCapability.getDensityFunction();
            if(densityFunction == null)return;
            densityFunction.update(player);
            if (player.level().getGameTime() %100L == 0L) {
                if(!player.level().isClientSide){
                    NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> player), new DensityFunctionPacketCapability(player.getId(),densityFunction));
                }

            }
        });
    }

}
