package huase.xiuxianzhilu.entity;

import huase.xiuxianzhilu.entity.functions.putuan.PutuanEntity;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;

public class Entitydataserializersint {
    public static final EntityDataSerializer<PutuanEntity.State> PutuanEntityState =EntityDataSerializer.simpleEnum(PutuanEntity.State.class);

    static {
        EntityDataSerializers.registerSerializer(PutuanEntityState);
    }
}
