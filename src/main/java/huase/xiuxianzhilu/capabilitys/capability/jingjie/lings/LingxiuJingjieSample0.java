package huase.xiuxianzhilu.capabilitys.capability.jingjie.lings;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieType;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieTypesInIt;
import net.minecraft.core.Holder;

import javax.annotation.Nullable;

/**
 * - @description:Jingjie类
 */
public class LingxiuJingjieSample0 extends LingxiuJingjieSample {
    public static final Codec<LingxiuJingjieSample0> CODEC =  RecordCodecBuilder.create(instance -> instance.group(
            LingxiujingjieGen.HOLDER_CODEC.fieldOf("getprent").forGetter(LingxiuJingjieSample::getPrent),
            Codec.intRange(0, Integer.MAX_VALUE).fieldOf("maxmaxdengji").forGetter(LingxiuJingjieSample::getMaxDengji),
            Codec.intRange(0, Integer.MAX_VALUE).fieldOf("intensity").forGetter(LingxiuJingjieSample::getIntensity),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("maxlingli").forGetter(p -> p.maxlingli),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("maxjingyan").forGetter(p -> p.maxjingyan),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWugong").forGetter(AttributeBase::getWugong),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWufang").forGetter(AttributeBase::getWufang),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMaxshengming").forGetter(AttributeBase::getMaxshengming),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojishanghai").forGetter(AttributeBase::getBaojishanghai),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojilv").forGetter(AttributeBase::getBaojilv)
    ).apply(instance, LingxiuJingjieSample0::new));

    public LingxiuJingjieSample0(@Nullable Holder<LingxiuJingjieSample> prentkey, int maxDengji, int intensity, float maxlingli, float maxjingyan, float getWugong, float getWufang, float getMaxshengming, float getBaojishanghai, float getBaojilv) {
        super( prentkey,maxDengji,intensity,maxlingli, maxjingyan, getWugong, getWufang, getMaxshengming, getBaojishanghai, getBaojilv);
    }



    public LingxiujingjieType getType() {
        return LingxiujingjieTypesInIt.lianqi_type.get();
    }

}
