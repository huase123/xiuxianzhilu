package huase.xiuxianzhilu.capabilitys;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.CapabilityProvider;
import huase.xiuxianzhilu.capabilitys.capability.MosterCapability;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
import huase.xiuxianzhilu.network.NetworkHandler;
import huase.xiuxianzhilu.network.SynsAPI;
import huase.xiuxianzhilu.network.client.CPacketCapability;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ModMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RegisterCapabilitys {

    public static Capability<MosterCapability> MOSTERCAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    public static Capability<PlayerCapability> PLAYERCAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    @SubscribeEvent
    public static void registerCaps(RegisterCapabilitiesEvent event) {
        event.register(MosterCapability.class);
        event.register(PlayerCapability.class);
    }

    //    实体增加Capabilities事件
    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof Player player) {
            event.addCapability(ModMain.prefix("playercapability"),
                    new CapabilityProvider(new PlayerCapability(player))
            );
        }
    }

    //    实体增加Capabilities事件
    @SubscribeEvent
    public static void onAttachItemCapabilities(AttachCapabilitiesEvent<ItemStack> event)
    {

    }

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event){
        Entity entity = event.getEntity();
        if (entity instanceof ServerPlayer serverPlayer)
        {
            CapabilityUtil.synsMaxhealth(serverPlayer,CapabilityUtil.getCapability(serverPlayer));
        }

    }

    public static void monsterJoin(LivingEntity livingEntity){

    }
//    玩家生成事件
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event)
    {
        event.getOriginal().reviveCaps();
        event.getOriginal().getCapability(PLAYERCAPABILITY).ifPresent(oriState->{
            event.getEntity().getCapability(PLAYERCAPABILITY).ifPresent(newState ->{
                newState.deserializeNBT(oriState.serializeNBT());
            });
        });
        event.getOriginal().invalidateCaps();
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onLivingTickEvent(LivingEvent.LivingTickEvent event){
        capabilitySyns(event);
    }

    private static void capabilitySyns(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
//        服务端同步至客户端
        if(event.getEntity()!=null &&!event.getEntity().level().isClientSide && entity.isAlive()){
            AttributeBase capability = CapabilityUtil.getCapability(entity);
            if(capability instanceof hua.huase.shanhaicontinent.capabilitys.capability.Update update && update.isIsupdate()){
                update.setIsupdate(false);
                SynsAPI.synsCapability(entity,capability);
            }
        }
//        客户端同步至服务端
        if(event.getEntity()!=null &&event.getEntity().level().isClientSide && entity.isAlive()){
            AttributeBase capability = CapabilityUtil.getCapability(entity);
            if(capability instanceof hua.huase.shanhaicontinent.capabilitys.capability.Update update && update.isIsupdate()){
                update.setIsupdate(false);
                NetworkHandler.INSTANCE.sendToServer(new CPacketCapability(event.getEntity().getId()));
            }
        }
    }

}
