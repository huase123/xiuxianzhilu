package huase.xiuxianzhilu.capabilitys.capability.danyao;

import com.mojang.serialization.Codec;

@FunctionalInterface
public interface DanyaoType {
    Codec<? extends Danyaoabstract> getCodec();

}
