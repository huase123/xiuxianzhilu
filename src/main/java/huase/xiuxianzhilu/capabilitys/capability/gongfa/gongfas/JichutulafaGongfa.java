package huase.xiuxianzhilu.capabilitys.capability.gongfa.gongfas;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaSample;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaType;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaTypesInit;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import huase.xiuxianzhilu.items.gongfa.GongfaSampleItem;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.Optional;

/**
 * - @description:JichutulafaGongfa类
 */
public class JichutulafaGongfa extends GongfaSample {
    public static final Codec<JichutulafaGongfa> CODEC =  RecordCodecBuilder.create(instance -> instance.group(
            LingxiujingjieGen.HOLDER_CODEC.optionalFieldOf("child").forGetter(lingxiuJingjieSample0 -> Optional.ofNullable(lingxiuJingjieSample0.getChild())),
            LingxiujingjieGen.HOLDER_CODEC.optionalFieldOf("prent").forGetter(lingxiuJingjieSample0 -> Optional.ofNullable(lingxiuJingjieSample0.getPrent())),
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(GongfaSample::getItem),
            Codec.intRange(0, 10000).fieldOf("maxdengji").forGetter(GongfaSample::getMaxdengji),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("intensity").forGetter(GongfaSample::getIntensity),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("maxjingyan").forGetter(GongfaSample::getmaxjingyan),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMaxshengming").forGetter(AttributeBase::getMaxshengming),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWugong").forGetter(AttributeBase::getWugong),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWufang").forGetter(AttributeBase::getWufang),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojishanghai").forGetter(AttributeBase::getBaojishanghai)
            ,Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojilv").forGetter(AttributeBase::getBaojilv)
            ,Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMaxlingli").forGetter(AttributeBase::getMaxlingli)
            ,Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMingzhong").forGetter(AttributeBase::getMingzhong)
            ,Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getDunsu").forGetter(AttributeBase::getDunsu)
            ,Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getShouyuan").forGetter(AttributeBase::getShouyuan)
            ,Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getXixue").forGetter(AttributeBase::getXixue)
    ).apply(instance, JichutulafaGongfa::new));

    Holder<LingxiuJingjieSample> prent;
    Holder<LingxiuJingjieSample> child;
    GongfaSampleItem item;
    int maxdengji;
    float intensity;
    float maxjingyan;

    public JichutulafaGongfa(Optional<Holder<LingxiuJingjieSample>> child, Optional<Holder<LingxiuJingjieSample>> prent, Item item, int maxDengji, float intensity, float maxjingyan,float maxshengming, float wugong, float wufang, float baojishanghai,float baojilv, float maxlingli, float mingzhong, float dunsu, float shouyuan, float xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
        if(item instanceof GongfaSampleItem gongfaSampleItem){
            this.item = gongfaSampleItem;
        }else {
            ModMain.LOGGER.error("非功法物品添加>>>>"+item.getDescriptionId());
        }
        this.prent=prent.orElse(null);
        this.child=child.orElse(null);
        this.maxdengji =maxDengji;
        this.intensity=intensity;
        this.maxjingyan=maxjingyan;
    }

    public JichutulafaGongfa(Holder<LingxiuJingjieSample> child, Holder<LingxiuJingjieSample> prent, Item item, int maxDengji, float intensity, float maxjingyan,float maxshengming, float wugong, float wufang, float baojishanghai,float baojilv, float maxlingli, float mingzhong, float dunsu, float shouyuan, float xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
        if(item instanceof GongfaSampleItem gongfaSampleItem){
            this.item = gongfaSampleItem;
        }else {
            ModMain.LOGGER.error("非功法物品添加>>>>"+item.getDescriptionId());
        }
        this.prent=prent;
        this.child=child;
        this.maxdengji =maxDengji;
        this.intensity=intensity;
        this.maxjingyan=maxjingyan;
    }


    public Item getItem() {
        return item;
    }

    @Override
    public float getIntensity() {
        return intensity;
    }

    @Override
    public GongfaType getType() {
        return GongfaTypesInit.jichutulafagongfa_type.get();
    }

    @Override
    public int getMaxdengji() {
        return maxdengji;
    }

    @Override
    public float getmaxjingyan() {
        return maxjingyan;
    }

    @Override
    public Holder<LingxiuJingjieSample> getPrent() {
        return prent;
    }

    @Override
    public Holder<LingxiuJingjieSample> getChild() {
        return child;
    }
}
