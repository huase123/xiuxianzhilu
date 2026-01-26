package huase.xiuxianzhilu.capabilitys.capability.danyao.danyaos;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.danyao.DanyaoType;
import huase.xiuxianzhilu.capabilitys.capability.danyao.DanyaoTypesInIt;
import huase.xiuxianzhilu.capabilitys.capability.danyao.Danyaoabstract;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.Optional;

/**
 * - @description:FabaaoSample类
 */
public class DanyaoSample extends Danyaoabstract {
    public static final Codec<DanyaoSample> CODEC =  RecordCodecBuilder.create(instance -> instance.group(
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(Danyaoabstract::getItem),
            LingxiujingjieGen.HOLDER_CODEC.optionalFieldOf("jingjie").forGetter(o -> Optional.ofNullable(o.getJingjie())),
            Codec.INT.fieldOf("maxusetime").forGetter(Danyaoabstract::getMaxusetime),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWugong").forGetter(AttributeBase::getWugong),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMaxshengming").forGetter(AttributeBase::getMaxshengming),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWufang").forGetter(AttributeBase::getWufang),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMaxlingli").forGetter(AttributeBase::getMaxlingli),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getJingyan").forGetter(Danyaoabstract::getJingyan),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getShouyuan").forGetter(AttributeBase::getShouyuan),

            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getReturnToLife").forGetter(Danyaoabstract::getReturnToLife),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getReturnTolingli").forGetter(Danyaoabstract::getReturnTolingli),

            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojishanghai").forGetter(AttributeBase::getBaojishanghai),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojilv").forGetter(AttributeBase::getBaojilv),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMingzhong").forGetter(AttributeBase::getMingzhong),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getDunsu").forGetter(AttributeBase::getDunsu),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getXixue").forGetter(AttributeBase::getXixue)
    ).apply(instance, DanyaoSample::new));
    Holder<LingxiuJingjieSample> jingjie;
    Item item;
    float returnToLife;
    float returnTolingli;
    int maxusetime;
    float jingyan;
    public DanyaoSample( Item item,Optional<Holder<LingxiuJingjieSample>> jingjie , int maxusetime, float wugong, float maxshengming, float wufang, float maxlingli, float jingyan, float shouyuan, float returnToLife, float returnTolingli, float baojishanghai, float baojilv, float mingzhong, float dunsu, float xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
        this.jingjie=jingjie.orElse(null);
        this.returnToLife = returnToLife;
        this.returnTolingli = returnTolingli;
        this.maxusetime = maxusetime;
        this.jingyan = jingyan;
        this.item = item;
    }
    public DanyaoSample( Item item,Holder.Reference<LingxiuJingjieSample> jingjie, int maxusetime, float wugong, float maxshengming, float wufang, float maxlingli, float jingyan, float shouyuan, float returnToLife, float returnTolingli, float baojishanghai, float baojilv, float mingzhong, float dunsu, float xixue) {
    super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);

        this.jingjie=jingjie;
        this.returnToLife = returnToLife;
        this.returnTolingli = returnTolingli;
        this.maxusetime = maxusetime;
        this.jingyan = jingyan;
        this.item = item;
    }

    @Override
    public DanyaoType getType() {
        return DanyaoTypesInIt.danyao_sample_type.get();
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
    public int getMaxusetime() {
        return maxusetime;
    }

    @Override
    public float getJingyan() {
        return jingyan;
    }

    @Override
    public float getReturnToLife() {
        return returnToLife;
    }

    @Override
    public float getReturnTolingli() {
        return returnTolingli;
    }
}
