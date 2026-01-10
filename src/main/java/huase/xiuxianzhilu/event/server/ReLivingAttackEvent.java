//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package huase.xiuxianzhilu.event.server;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
        modid = ModMain.MODID,
        bus = Bus.FORGE
)
public class ReLivingAttackEvent {
    public ReLivingAttackEvent() {
    }

    @SubscribeEvent
    public static void livingAttack(LivingHurtEvent event) {
        LivingEntity living = event.getEntity();
        if (!living.level().isClientSide()) {
            handDamage(event);
        }

    }
    private static void handDamage(LivingHurtEvent event) {
        LivingEntity living = event.getEntity();
        Entity entity = event.getSource().getEntity();


//处理命中
        if (!CapabilityUtil.handleMingzhong(entity, living)) {
            event.setCanceled(true);
        }
        //            计算物理伤害
        float v = CapabilityUtil.handleWuliDamage(entity, living, event.getAmount());

        event.setAmount(v);
    }

    @SubscribeEvent
    public static void LivingDamageEvent(LivingDamageEvent event) {
        LivingEntity living = event.getEntity();
        if (!living.level().isClientSide()) {
            Entity entity = event.getSource().getEntity();
            float amount = event.getAmount();
//        处理吸血
            CapabilityUtil.handxixue(entity,amount);
        }

    }

}
