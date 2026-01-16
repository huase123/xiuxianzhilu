package huase.xiuxianzhilu.capabilitys.capability.fabao;

import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

/**
 * - @description:Jingjie类
 */
public abstract class Fabaoabstract extends AttributeBase {
    public Fabaoabstract(float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv, float maxlingli, float mingzhong, float dunsu, float shouyuan, float xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
    }

    public abstract FabaoType getType();

    public abstract Holder<LingxiuJingjieSample> getJingjie();
    public abstract Item getItem() ;
    public abstract int getDengji() ;
    public abstract int getTypenum() ;

}
