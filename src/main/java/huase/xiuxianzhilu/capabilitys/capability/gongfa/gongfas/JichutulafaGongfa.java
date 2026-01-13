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
            Codec.intRange(0,100000).fieldOf("getIntensity").forGetter(JichutulafaGongfa::getIntensity),
            Codec.intRange(0,100000).fieldOf("maxjingyan").forGetter(JichutulafaGongfa::getmaxjingyan),
            Codec.intRange(0,100000).fieldOf("maxlayernum").forGetter(JichutulafaGongfa::getmaxlayernum),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMaxshengming").forGetter(AttributeBase::getMaxshengming),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWugong").forGetter(AttributeBase::getWugong),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWufang").forGetter(AttributeBase::getWufang),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojishanghai").forGetter(AttributeBase::getBaojishanghai),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojilv").forGetter(AttributeBase::getBaojilv)
    ).apply(instance, JichutulafaGongfa::new));

    Holder<LingxiuJingjieSample> prent;
    Holder<LingxiuJingjieSample> child;
    GongfaSampleItem item;
    int intensity;
    int maxjingyan;
    int maxlayernum;

    public JichutulafaGongfa( Optional<Holder<LingxiuJingjieSample>> child, Optional<Holder<LingxiuJingjieSample>> prent, Item item, int intensity, int maxjingyan, int maxlayernum, float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv);
        if(item instanceof GongfaSampleItem gongfaSampleItem){
            this.item = gongfaSampleItem;
        }else {
            ModMain.LOGGER.error("非功法物品添加>>>>"+item.getDescriptionId());
        }
        this.intensity = intensity;
        this.prent=prent.orElse(null);
        this.child=child.orElse(null);
        this.maxjingyan=maxjingyan;
        this.maxlayernum=maxlayernum;
    }

    public JichutulafaGongfa(Holder<LingxiuJingjieSample> child, Holder<LingxiuJingjieSample> prent, Item item, int intensity, int maxjingyan, int maxlayernum, float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv);
        if(item instanceof GongfaSampleItem gongfaSampleItem){
            this.item = gongfaSampleItem;
        }else {
            ModMain.LOGGER.error("非功法物品添加>>>>"+item.getDescriptionId());
        }
        this.intensity = intensity;
        this.prent=prent;
        this.child=child;
        this.maxjingyan=maxjingyan;
        this.maxlayernum=maxlayernum;
    }


    public GongfaSampleItem getItem() {
        return item;
    }

    @Override
    public int getIntensity() {
        return intensity;
    }

    @Override
    public GongfaType getType() {
        return GongfaTypesInit.jichutulafagongfa_type.get();
    }

    @Override
    public int getmaxlayernum() {
        return maxlayernum;
    }

    @Override
    public int getmaxjingyan() {
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
