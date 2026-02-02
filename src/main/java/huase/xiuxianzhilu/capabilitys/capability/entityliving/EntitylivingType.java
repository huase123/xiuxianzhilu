package huase.xiuxianzhilu.capabilitys.capability.entityliving;

import com.mojang.serialization.Codec;

@FunctionalInterface
public interface EntitylivingType {
    Codec<? extends Entitylivingabstract> getCodec();

}
