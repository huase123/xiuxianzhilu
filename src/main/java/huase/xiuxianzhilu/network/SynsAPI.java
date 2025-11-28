package huase.xiuxianzhilu.network;

import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.network.server.SPacketCapability;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

public interface SynsAPI {
    static void synsCapability(Entity entity, @NotNull AttributeBase attributeBase){
//        CapabilityUtil.synsMaxhealth(serverPlayer,playerCapability);
        NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), new SPacketCapability(entity.getId(),attributeBase.serializeNBT()));
    }
}
