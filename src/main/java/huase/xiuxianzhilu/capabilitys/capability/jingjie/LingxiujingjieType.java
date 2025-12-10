package huase.xiuxianzhilu.capabilitys.capability.jingjie;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjie;

@FunctionalInterface
public interface LingxiujingjieType {
    Codec<? extends LingxiuJingjie> getCodec();

}
