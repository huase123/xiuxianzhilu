package huase.xiuxianzhilu.capabilitys.capability.jingjie.lings;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieType;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieTypesInIt;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * - @description:Jingjie类
 */
public class LingxiuJingjieSample0 extends LingxiuJingjieSample {

    public static final Codec<LingxiuJingjieSample0> CODEC =  RecordCodecBuilder.create(instance -> instance.group(
            LingxiujingjieGen.HOLDER_CODEC.optionalFieldOf("prent").forGetter(lingxiuJingjieSample0 -> Optional.ofNullable(lingxiuJingjieSample0.getPrent())),
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(LingxiuJingjieSample::getItem),
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
    ).apply(instance, LingxiuJingjieSample0::new));
    Holder<LingxiuJingjieSample> prent;
    Item item;
    int maxdengji;
    float intensity;
    float maxjingyan;
    public LingxiuJingjieSample0(Optional<Holder<LingxiuJingjieSample>> prent, Item item, int maxDengji, float intensity, float maxjingyan,float maxshengming, float wugong, float wufang, float baojishanghai,float baojilv, float maxlingli, float mingzhong, float dunsu, float shouyuan, float xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
        this.maxdengji =maxDengji;
        this.intensity=intensity;
        this.maxjingyan=maxjingyan;
        this.prent=prent.orElse(null);
        this.item = item;

    }
    public LingxiuJingjieSample0(@Nullable Holder<LingxiuJingjieSample> prent,  Item item, int maxDengji, float intensity, float maxjingyan,float maxshengming, float wugong, float wufang, float baojishanghai,float baojilv, float maxlingli, float mingzhong, float dunsu, float shouyuan, float xixue) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv, maxlingli, mingzhong, dunsu, shouyuan, xixue);
        this.maxdengji =maxDengji;
        this.intensity=intensity;
        this.maxjingyan=maxjingyan;
        this.prent=prent;
        this.item = item;

    }
    public LingxiujingjieType getType() {
        return LingxiujingjieTypesInIt.lianqi_type.get();
    }

    @Override
    public Item getItem() {
        return item;
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
