package huase.xiuxianzhilu.capabilitys.capability.jingjie.lings;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import static huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen.lingxiu_jingjie_key;

/**
 * - @description:LingxiuCase类
 */
public class LingxiuCase extends AttributeBase {
    private LingxiuJingjieSample lingxiuJingjieSample;
    float lingli;
    float maxlingli;
    float jingyan;
    float maxjingyan;
    int dengji;
    int maxDengji;
    Player player;

    public LingxiuCase(Player player, LingxiuJingjieSample lingxiuJingjieSample) {
        super(lingxiuJingjieSample.maxshengming, lingxiuJingjieSample.wugong, lingxiuJingjieSample.wufang, lingxiuJingjieSample.baojishanghai, lingxiuJingjieSample.baojilv);
        this.player = player;
        this.lingxiuJingjieSample = lingxiuJingjieSample;
        this.maxlingli = lingxiuJingjieSample.getMaxlingli();
        this.maxjingyan = lingxiuJingjieSample.getMaxjingyan();
        this.maxDengji = lingxiuJingjieSample.getMaxdengji();
    }

    public LingxiuCase(Player player, CompoundTag compoundTag) {
        this.player = player;
        deserializeNBT(compoundTag);
    }


    public LingxiuJingjieSample getLingxiuJingjie() {
        return lingxiuJingjieSample;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = super.serializeNBT();
        ResourceLocation key = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(lingxiuJingjieSample);
        if(key !=null){
            compoundTag.putString("lingxiuJingjie",key.toString());
        }
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        super.deserializeNBT(compoundTag);
        String string = compoundTag.getString("lingxiuJingjie");
        lingxiuJingjieSample = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).get(ResourceLocation.parse(string));
    }

    public float getIntensity() {

        return lingxiuJingjieSample.getIntensity();
    }

    public void addJingyan(Player player, double value) {
        value = lingxiuJingjieSample.addJingyan(player,value);
        if(jingyan>=maxjingyan){
            tupo(player);
        }else {
            jingyan = (float) Math.min(maxlingli,jingyan+value);
        }
    }

    public void tupo(Player player) {
        if(dengji<maxDengji-1){
            dengji++;
            jingyan = 0;
            maxjingyan +=(maxjingyan/maxDengji)*2;
            ModMain.LOGGER.info("境界突破至于"+dengji);
        }else {
            ModMain.LOGGER.info("境界圆满，可开启新境界");
            CapabilityUtil.addLingxiuCase(player);
        }
    }
}
