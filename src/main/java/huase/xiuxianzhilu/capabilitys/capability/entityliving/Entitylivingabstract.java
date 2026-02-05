package huase.xiuxianzhilu.capabilitys.capability.entityliving;

import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

/**
 * - @description:Jingjie类
 */
public abstract class Entitylivingabstract extends AttributeBase {
    public Entitylivingabstract(float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv, float maxlingli, float mingzhong, float dunsu, float shouyuan, float xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
    }

    public abstract EntitylivingType getType();

    public abstract Holder<LingxiuJingjieSample> getJingjie();
    public abstract EntityType<?> getEntityType();
    public abstract float getAmplification();

}
