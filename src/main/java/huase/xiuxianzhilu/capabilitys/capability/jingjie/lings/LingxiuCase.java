package huase.xiuxianzhilu.capabilitys.capability.jingjie.lings;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import static huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieFactorys.lingxiu_jingjie_key;

/**
 * - @description:LingxiuCase类
 */
public class LingxiuCase extends AttributeBase {
    private LingxiuJingjie lingxiuJingjie;
    float lingli;
    float maxlingli;
    float jingyan;
    float maxjingyan;
    int dengji;
    int maxDengji;
    Player player;

    public LingxiuCase(Player player,LingxiuJingjie lingxiuJingjie) {
        super(lingxiuJingjie.maxshengming, lingxiuJingjie.wugong, lingxiuJingjie.wufang, lingxiuJingjie.baojishanghai, lingxiuJingjie.baojilv);
        this.player = player;
        this.lingxiuJingjie = lingxiuJingjie;
        this.maxlingli = lingxiuJingjie.maxlingli;
        this.maxjingyan = lingxiuJingjie.maxjingyan;
        this.maxDengji = lingxiuJingjie.maxDengji;
    }

    public LingxiuCase(Player player, CompoundTag compoundTag) {
        this.player = player;
        deserializeNBT(compoundTag);
    }


    public LingxiuJingjie getLingxiuJingjie() {
        return lingxiuJingjie;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = super.serializeNBT();
        ResourceLocation key = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(lingxiuJingjie);
        if(key !=null){
            compoundTag.putString("lingxiuJingjie",key.toString());
        }
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        super.deserializeNBT(compoundTag);
        String string = compoundTag.getString("lingxiuJingjie");
        lingxiuJingjie = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).get(ResourceLocation.parse(string));
    }

    public int getIntensity() {

        return lingxiuJingjie.getIntensity();
    }

    public void addJingyan(Player player, double value) {
        if(jingyan>=maxjingyan){
            ModMain.LOGGER.info("达到境界最大经验可以突破");
            tupo(player);
        }else {
            jingyan+=value*1000;
        }
    }

    private void tupo(Player player) {
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
