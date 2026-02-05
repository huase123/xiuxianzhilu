package huase.xiuxianzhilu.capabilitys.capability.fabao.fabaos;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.fabao.FabaoType;
import huase.xiuxianzhilu.capabilitys.capability.fabao.FabaoTypesInIt;
import huase.xiuxianzhilu.capabilitys.capability.fabao.Fabaoabstract;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.Optional;

/**
 * - @description:FabaaoSample类
 */
public class FabaoSample extends Fabaoabstract {
    public static final Codec<FabaoSample> CODEC =  RecordCodecBuilder.create(instance -> instance.group(
            LingxiujingjieGen.HOLDER_CODEC.optionalFieldOf("jingjie").forGetter(fabaoabstract -> Optional.ofNullable(fabaoabstract.getJingjie())),
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(Fabaoabstract::getItem),
            Codec.INT.fieldOf("type").forGetter(Fabaoabstract::getTypenum),
            Codec.INT.fieldOf("dengji").forGetter(Fabaoabstract::getDengji),
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
    ).apply(instance, FabaoSample::new));
    Holder<LingxiuJingjieSample> jingjie;
    Item item;
    int dengji;
    int typenum;
    public FabaoSample(Optional<Holder<LingxiuJingjieSample>> jingjie, Item item, int typenum, int dengji , float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv, float maxlingli, float mingzhong, float dunsu, float shouyuan, float xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
        this.dengji=dengji;
        this.jingjie=jingjie.orElse(null);
        this.item = item;
        this.typenum = typenum;
    }

    public FabaoSample(Holder.Reference<LingxiuJingjieSample> jingjie, Item item, int typenum, int dengji, int maxshengming, int wugong, int wufang, int baojishanghai, int baojilv, int maxlingli, int mingzhong, int dunsu, int shouyuan, int xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
        this.dengji=dengji;
        this.jingjie=jingjie;
        this.item = item;
        this.typenum = typenum;
    }

    @Override
    public FabaoType getType() {
        return FabaoTypesInIt.fabao_sample_type.get();
    }

    @Override
    public Holder<LingxiuJingjieSample> getJingjie() {
        return jingjie;
    }

    @Override
    public Item getItem() {
        return item;
    }

    @Override
    public int getDengji() {
        return dengji;
    }

    @Override
    public int getTypenum() {
        return typenum;
    }
}
