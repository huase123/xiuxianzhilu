package huase.xiuxianzhilu.capabilitys.capability.entityliving.entitylivings;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.entityliving.EntitylivingType;
import huase.xiuxianzhilu.capabilitys.capability.entityliving.EntitylivingTypesInIt;
import huase.xiuxianzhilu.capabilitys.capability.entityliving.Entitylivingabstract;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;

import java.util.Optional;

/**
 * - @description:FabaaoSample类
 */
public class EntitylivingSample extends Entitylivingabstract {
    public static final Codec<EntitylivingSample> CODEC =  RecordCodecBuilder.create(instance -> instance.group(
            BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("entitytype").forGetter(Entitylivingabstract::getEntityType),
            LingxiujingjieGen.HOLDER_CODEC.optionalFieldOf("jingjie").forGetter(fabaoabstract -> Optional.ofNullable(fabaoabstract.getJingjie())),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("amplification").forGetter(Entitylivingabstract::getAmplification),

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
    ).apply(instance, EntitylivingSample::new));
    EntityType<?> entityType;
    Holder<LingxiuJingjieSample> jingjie;
    float amplification;
    public EntitylivingSample(EntityType<?> entityType,Optional<Holder<LingxiuJingjieSample>> jingjie, float amplification, float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv, float maxlingli, float mingzhong, float dunsu, float shouyuan, float xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
        this.entityType=entityType;
        this.jingjie=jingjie.orElse(null);
        this.amplification=amplification;
    }

    public EntitylivingSample(EntityType<?> entityType,Holder.Reference<LingxiuJingjieSample> jingjie, float amplification, int maxshengming, int wugong, int wufang, int baojishanghai, int baojilv, int maxlingli, int mingzhong, int dunsu, int shouyuan, int xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
        this.entityType=entityType;
        this.jingjie=jingjie;
        this.amplification=amplification;
    }

    @Override
    public EntitylivingType getType() {
        return EntitylivingTypesInIt.entityliving_sample_type.get();
    }

    @Override
    public Holder<LingxiuJingjieSample> getJingjie() {
        return jingjie;
    }

    @Override
    public EntityType<?> getEntityType() {
        return entityType;
    }

    @Override
    public float getAmplification() {
        return amplification;
    }
}
