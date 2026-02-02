package huase.xiuxianzhilu.entity.moster.chilingshuishe;

import huase.xiuxianzhilu.entity.moster.MosterBaseEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

/**
 * - @description:ChilingshuisheEntity类
 */
public class ChilingshuisheEntity extends MosterBaseEntity {
    public ChilingshuisheEntity(EntityType<? extends Monster> type, Level world) {
        super(type, world);
    }
}
