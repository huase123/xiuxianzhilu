package huase.xiuxianzhilu.event.server;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
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
                updatesDensityFunction(player);
            }
            if (!player.level().isClientSide && !player.isDeadOrDying()) {
                updateShouyuan(player);
                updatesLingli(player);
            }

            updatesFly(player);
        }

    }

    private static void updatesDensityFunction(Player player) {
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

    private static void updateShouyuan(Player player) {
        if (player.level().getGameTime() % 4000L == 0L && !player.isDeadOrDying()) {
            CapabilityUtil.addNianling(player, 1);
        }
    }

    private static void updatesLingli(Player player) {
        if (player.level().getGameTime() % 100L == 0L) {
            int xiulianshudu = CapabilityUtil.getXiulianshudu(player);
            CapabilityUtil.addLingli(player, xiulianshudu/20f);
        }
    }


    private static void updatesFly(Player player) {
        if (!player.isCreative() && !player.isSpectator() && !player.isDeadOrDying()) {

            if (CapabilityUtil.getLingxiuindex(player) >= 2 && CapabilityUtil.getLingli(player) > 0.0F) {
                player.getAbilities().mayfly = true;
            } else {
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
            }

            if (player.getAbilities().flying && player.level().getGameTime() % 40L == 0L) {
                CapabilityUtil.addLingli(player, -0.2f);
            }
        }

    }
}
