package huase.xiuxianzhilu.capabilitys.capability.jingjie.lings;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieType;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieTypesInIt;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * - @description:Jingjie类
 */
public class LingxiuJingjieSample0 extends LingxiuJingjieSample {

    public static final Codec<LingxiuJingjieSample0> CODEC =  RecordCodecBuilder.create(instance -> instance.group(
            LingxiujingjieGen.HOLDER_CODEC.optionalFieldOf("prent").forGetter(lingxiuJingjieSample0 -> Optional.ofNullable(lingxiuJingjieSample0.getPrent())),
            Codec.intRange(0, 10000).fieldOf("maxdengji").forGetter(LingxiuJingjieSample::getMaxdengji),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("intensity").forGetter(LingxiuJingjieSample::getIntensity),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("maxlingli").forGetter(LingxiuJingjieSample::getMaxlingli),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("maxjingyan").forGetter(LingxiuJingjieSample::getMaxjingyan),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWugong").forGetter(AttributeBase::getWugong),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getWufang").forGetter(AttributeBase::getWufang),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getMaxshengming").forGetter(AttributeBase::getMaxshengming),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojishanghai").forGetter(AttributeBase::getBaojishanghai),
            Codec.floatRange(0, Float.MAX_VALUE).fieldOf("getBaojilv").forGetter(AttributeBase::getBaojilv)
    ).apply(instance, LingxiuJingjieSample0::new));
    Holder<LingxiuJingjieSample> prent;
    int maxdengji;
    float intensity;
    float maxlingli;
    float maxjingyan;
    public LingxiuJingjieSample0( Optional<Holder<LingxiuJingjieSample>> prent, int maxDengji, float intensity, float maxlingli, float maxjingyan, float getWugong, float getWufang, float getMaxshengming, float getBaojishanghai, float getBaojilv) {
        super(getWugong, getWufang, getMaxshengming, getBaojishanghai, getBaojilv);
        this.maxdengji =maxDengji;
        this.intensity=intensity;
        this.maxlingli=maxlingli;
        this.maxjingyan=maxjingyan;
        this.prent=prent.orElse(null);

    }
    public LingxiuJingjieSample0(@Nullable Holder<LingxiuJingjieSample> prent, int maxDengji, float intensity, float maxlingli, float maxjingyan, float getWugong, float getWufang, float getMaxshengming, float getBaojishanghai, float getBaojilv) {
        super(getWugong, getWufang, getMaxshengming, getBaojishanghai, getBaojilv);
        this.maxdengji =maxDengji;
        this.intensity=intensity;
        this.maxlingli=maxlingli;
        this.maxjingyan=maxjingyan;
        this.prent=prent;

    }
    public LingxiujingjieType getType() {
        return LingxiujingjieTypesInIt.lianqi_type.get();
    }

    @Override
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
        return prent;
    }

    @Override
    public double addJingyan(Player player, double value) {
        return super.addJingyan(player, value);
    }
}
