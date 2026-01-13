package huase.xiuxianzhilu.capabilitys.capability.jingjie.lings;

import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import static huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen.lingxiu_jingjie_key;

/**
 * - @description:LingxiuCase类
 */
public class LingxiuCase extends AttributeBase {
    private LingxiuJingjieSample lingxiuJingjieSample;
    float maxlingli;
    float jingyan;
    float maxjingyan;
    int dengji;
    int maxdengji;
    Player player;
    boolean activate = true;

    public LingxiuCase(Player player, LingxiuJingjieSample lingxiuJingjieSample) {
        super(lingxiuJingjieSample.maxshengming, lingxiuJingjieSample.wugong, lingxiuJingjieSample.wufang, lingxiuJingjieSample.baojishanghai, lingxiuJingjieSample.baojilv);
        this.player = player;
        this.lingxiuJingjieSample = lingxiuJingjieSample;
        this.maxlingli = lingxiuJingjieSample.getMaxlingli();
        this.maxjingyan = lingxiuJingjieSample.getMaxjingyan();
        this.maxdengji = lingxiuJingjieSample.getMaxdengji();
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
        compoundTag.putFloat("maxlingli",maxlingli);
        compoundTag.putFloat("jingyan",jingyan);
        compoundTag.putFloat("maxjingyan",maxjingyan);
        compoundTag.putInt("dengji",dengji);
        compoundTag.putInt("maxdengji", maxdengji);
        compoundTag.putBoolean("activate", activate);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        super.deserializeNBT(compoundTag);
        String string = compoundTag.getString("lingxiuJingjie");
        lingxiuJingjieSample = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).get(ResourceLocation.parse(string));

        this.maxlingli = compoundTag.getFloat("maxlingli");
        this.jingyan = compoundTag.getFloat("jingyan");
        this.maxjingyan = compoundTag.getFloat("maxjingyan");
        this.dengji = compoundTag.getInt("dengji");
        this.maxdengji = compoundTag.getInt("maxdengji");
        this.activate = compoundTag.getBoolean("activate");
    }

    public float getIntensity() {

        return lingxiuJingjieSample.getIntensity();
    }

    public void addJingyan(Player player, double value) {
        value = lingxiuJingjieSample.addJingyan(player,value);
        if(jingyan>=maxjingyan){
            tupo(player);
        }else {
            jingyan = (float) Math.min(maxjingyan,jingyan+value);
        }
    }

    public void tupo(Player player) {
        if(dengji< maxdengji -1){
            dengji++;
            jingyan = 0;
            maxjingyan +=(maxjingyan/ maxdengji)*2;

            ResourceLocation key = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(lingxiuJingjieSample);
            player.sendSystemMessage(Component.translatable("境界突破至")
                    .append(Component.translatable(key.toString())).append((dengji+1)+"层")
            );
        }else {
            if(!isYuanman()){
                ResourceLocation key = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(lingxiuJingjieSample);
                player.sendSystemMessage(Component.translatable("境界突破至")
                        .append(Component.translatable(key.toString())).append("圆满")
                );
                dengji++;
            }else {
//                CapabilityUtil.addLingxiuCase(player);
            }
        }
    }


    @Override
    public float getMaxlingli() {
        return maxlingli;
    }

    public float getJingyan() {
        return jingyan;
    }

    public float getMaxjingyan() {
        return maxjingyan;
    }

    public int getDengji() {
        return dengji;
    }

    public int getMaxdengji() {
        return maxdengji;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public boolean isYuanman() {
        return dengji>= maxdengji;
    }
}
