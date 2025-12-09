package huase.xiuxianzhilu.capabilitys.capability.jingjie.lings;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;

/**
 * - @description:Jingjie类
 */
public class LingxiuJingjie extends AttributeBase implements Lingxiu{
    public static final Codec<LingxiuJingjie> CODEC =  RecordCodecBuilder.create(instance -> instance.group(
//            Codec.intRange(0, Float.MAX_VALUE).fieldOf("spacing").forGetter(p -> p.lingli),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("maxlingli").forGetter(p -> p.maxlingli),
//            Codec.intRange(0, Float.MAX_VALUE).fieldOf("jingyan").forGetter(p -> p.jingyan),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("maxjingyan").forGetter(p -> p.maxjingyan),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWugong").forGetter(AttributeBase::getWugong),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWufang").forGetter(AttributeBase::getWufang),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMaxshengming").forGetter(AttributeBase::getMaxshengming),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojishanghai").forGetter(AttributeBase::getBaojishanghai),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojilv").forGetter(AttributeBase::getBaojilv)
    ).apply(instance, LingxiuJingjie::new));

    public LingxiuJingjie(float maxlingli,float maxjingyan,float getWugong,float getWufang,float getMaxshengming,float getBaojishanghai,float getBaojilv) {
        this.lingli = 0;
        this.maxlingli = maxlingli;
        this.jingyan = 0;
        this.maxjingyan = maxjingyan;
        setWugong(getWugong);
        setWufang(getWufang);
        setMaxshengming(getMaxshengming);
        setBaojishanghai(getBaojishanghai);
        setBaojilv(getBaojilv);
    }

    float lingli;
    float maxlingli;
    float jingyan;
    float maxjingyan;


    public float getLingli() {
        return lingli;
    }

    public float getMaxlingli() {
        return maxlingli;
    }

    public float getJingyan() {
        return jingyan;
    }

    public float getMaxjingyan() {
        return maxjingyan;
    }
}
