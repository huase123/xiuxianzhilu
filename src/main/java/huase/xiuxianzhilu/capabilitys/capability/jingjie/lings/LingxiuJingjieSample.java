package huase.xiuxianzhilu.capabilitys.capability.jingjie.lings;

import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieType;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

/**
 * - @description:Jingjie类
 */
public abstract class LingxiuJingjieSample extends AttributeBase {
    public LingxiuJingjieSample(float maxshengming, float wugong, float wufang, float baojishanghai,float baojilv, float maxlingli, float mingzhong, float dunsu, float shouyuan, float xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
    }

    public abstract LingxiujingjieType getType();
    public abstract Item getItem() ;


    public abstract float getMaxjingyan();

    public abstract int getMaxdengji();



    public abstract float getIntensity();

    public abstract Holder<LingxiuJingjieSample> getPrent();


    public double addJingyan(Player player, double value) {
        return value;
    }
}
