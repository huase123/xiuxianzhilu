package huase.xiuxianzhilu.capabilitys.capability.jingjie.lings;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieType;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieTypesInIt;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

/**
 * - @description:LingxiujingjieEmpty类
 */
public class LingxiujingjieNoPrent extends LingxiuJingjieSample {


    public static final Codec<LingxiujingjieNoPrent> CODEC =  RecordCodecBuilder.create(instance -> instance.group(
            Codec.intRange(0, 10000).fieldOf("maxdengji").forGetter(LingxiuJingjieSample::getMaxdengji),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("intensity").forGetter(LingxiuJingjieSample::getIntensity),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("maxjingyan").forGetter(LingxiuJingjieSample::getMaxjingyan),
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
    ).apply(instance, LingxiujingjieNoPrent::new));

    int maxdengji;
    float intensity;
    float maxjingyan;

    public LingxiujingjieNoPrent(int maxDengji, float intensity, float maxjingyan, float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv, float maxlingli, float mingzhong, float dunsu, float shouyuan, float xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
        this.maxdengji =maxDengji;
        this.intensity=intensity;
        this.maxjingyan=maxjingyan;
    }


    public LingxiujingjieType getType() {
        return LingxiujingjieTypesInIt.fannal_type.get();
    }

    @Override
    public Item getItem() {
        return null;
    }

    public int getMaxdengji() {
        return maxdengji;
    }

    @Override
    public float getIntensity() {
        return intensity;
    }


    @Override
    public float getMaxjingyan() {
        return maxjingyan;
    }

    @Override
    public Holder<LingxiuJingjieSample> getPrent() {
        return null;
    }

    @Override
    public double addJingyan(Player player, double value) {
        return super.addJingyan(player, value);
    }
}
