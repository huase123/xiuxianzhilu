package huase.xiuxianzhilu.capabilitys.capability.gongfa.gongfas;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaSample;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaType;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaTypesInit;
import huase.xiuxianzhilu.items.gongfa.GongfaSampleItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

/**
 * - @description:JichutulafaGongfa类
 */
public class JichutulafaGongfa extends GongfaSample {
    public static final Codec<JichutulafaGongfa> CODEC =  RecordCodecBuilder.create(instance -> instance.group(
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(GongfaSample::getItem),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWugong").forGetter(AttributeBase::getWugong),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWufang").forGetter(AttributeBase::getWufang),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMaxshengming").forGetter(AttributeBase::getMaxshengming),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojishanghai").forGetter(AttributeBase::getBaojishanghai),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojilv").forGetter(AttributeBase::getBaojilv)
    ).apply(instance, JichutulafaGongfa::new));

    public GongfaSampleItem getItem() {
        return item;
    }

    GongfaSampleItem item;

    public JichutulafaGongfa(Item item,float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv);
        if(item instanceof GongfaSampleItem gongfaSampleItem){
            this.item = gongfaSampleItem;
        }else {
            ModMain.LOGGER.error("非功法物品添加>>>>"+item.getDescriptionId());
        }
    }

    @Override
    public GongfaType getType() {
        return GongfaTypesInit.jichutulafagongfa_type.get();
    }
}
