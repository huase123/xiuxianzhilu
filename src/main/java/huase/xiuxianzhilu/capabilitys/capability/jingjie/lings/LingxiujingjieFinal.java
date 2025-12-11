package huase.xiuxianzhilu.capabilitys.capability.jingjie.lings;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieType;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieTypes;

/**
 * - @description:LingxiujingjieEmpty类
 */
public class LingxiujingjieFinal extends LingxiuJingjie{

    public static final Codec<LingxiujingjieFinal> CODEC =  RecordCodecBuilder.create(instance -> instance.group(
            Codec.intRange(0, Integer.MAX_VALUE).fieldOf("maxmaxdengji").forGetter(LingxiuJingjie::getMaxDengji),
            Codec.intRange(0, Integer.MAX_VALUE).fieldOf("intensity").forGetter(LingxiuJingjie::getIntensity),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("maxlingli").forGetter(p -> p.maxlingli),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("maxjingyan").forGetter(p -> p.maxjingyan),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWugong").forGetter(AttributeBase::getWugong),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWufang").forGetter(AttributeBase::getWufang),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMaxshengming").forGetter(AttributeBase::getMaxshengming),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojishanghai").forGetter(AttributeBase::getBaojishanghai),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojilv").forGetter(AttributeBase::getBaojilv)
    ).apply(instance, LingxiujingjieFinal::new));

    public LingxiujingjieFinal(int maxDengji, int intensity, float maxlingli, float maxjingyan, float getWugong, float getWufang, float getMaxshengming, float getBaojishanghai, float getBaojilv) {
        super( null,maxDengji,intensity,maxlingli, maxjingyan, getWugong, getWufang, getMaxshengming, getBaojishanghai, getBaojilv);
    }


    public LingxiujingjieType getType() {
        return LingxiujingjieTypes.fannal_type.get();
    }
}
