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
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("maxlingli").forGetter(LingxiuJingjieSample::getMaxlingli),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("maxjingyan").forGetter(LingxiuJingjieSample::getMaxjingyan),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWugong").forGetter(AttributeBase::getWugong),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWufang").forGetter(AttributeBase::getWufang),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMaxshengming").forGetter(AttributeBase::getMaxshengming),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojishanghai").forGetter(AttributeBase::getBaojishanghai),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojilv").forGetter(AttributeBase::getBaojilv)
    ).apply(instance, LingxiujingjieNoPrent::new));

    int maxdengji;
    float intensity;
    float maxlingli;
    float maxjingyan;

    public LingxiujingjieNoPrent(int maxDengji, float intensity, float maxlingli, float maxjingyan, float getWugong, float getWufang, float getMaxshengming, float getBaojishanghai, float getBaojilv) {
        super(getWugong, getWufang, getMaxshengming, getBaojishanghai, getBaojilv);
        this.maxdengji =maxDengji;
        this.intensity=intensity;
        this.maxlingli=maxlingli;
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
    public float getMaxlingli() {
        return maxlingli;
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
