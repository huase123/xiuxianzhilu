package huase.xiuxianzhilu.capabilitys.capability.jingjie;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;

@FunctionalInterface
public interface LingxiujingjieType {
    Codec<? extends LingxiuJingjieSample> getCodec();

}
