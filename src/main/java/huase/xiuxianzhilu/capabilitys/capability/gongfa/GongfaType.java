package huase.xiuxianzhilu.capabilitys.capability.gongfa;

import com.mojang.serialization.Codec;

@FunctionalInterface
public interface GongfaType {
    Codec<? extends GongfaSample> getCodec();

}
