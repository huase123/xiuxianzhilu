package huase.xiuxianzhilu.entity.moster;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

/**
 * - @description:CapabilityMoster接口
 */
public interface CapabilityMoster {
    void initCapability(LivingEntity livingEntity, Level level);
}
