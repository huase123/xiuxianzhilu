package huase.xiuxianzhilu.capabilitys.capability.fabao;

import com.mojang.serialization.Codec;

@FunctionalInterface
public interface FabaoType {
    Codec<? extends Fabaoabstract> getCodec();

}
