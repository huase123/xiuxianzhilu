package huase.xiuxianzhilu.capabilitys.capability.gongfa;

import huase.xiuxianzhilu.advance.AdvenceInit;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import java.util.List;

import static huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen.gongfa_key;

/**
 * - @description:GongfaCase类
 */
public class GongfaCase extends AttributeBase {
    GongfaSample gongfaSample;
    Entity entity;
    int layernum;
    int maxlayernum;
    float jingyan;
    float maxjingyan;
    public GongfaCase(Entity entity, CompoundTag compoundTag) {
        this.entity = entity;
        deserializeNBT(compoundTag);
    }

    public GongfaCase(Entity entity, GongfaSample gongfaSample) {
        super(gongfaSample.maxshengming, gongfaSample.wugong, gongfaSample.wufang, gongfaSample.baojishanghai, gongfaSample.baojilv
                , gongfaSample.getMaxlingli()
                , gongfaSample.getMingzhong()
                , gongfaSample.getDunsu()
                , gongfaSample.getShouyuan()
                , gongfaSample.getXixue()
        );
        this.entity = entity;
        this.gongfaSample =gongfaSample;
        this.maxlayernum = this.gongfaSample.getMaxdengji();
        this.maxjingyan = this.gongfaSample.getmaxjingyan();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = super.serializeNBT();
        ResourceLocation key = entity.level().registryAccess().registryOrThrow(gongfa_key).getKey(gongfaSample);
        if(key !=null){
            compoundTag.putString("gongfaSample",key.toString());
        }
        compoundTag.putInt("layernum",layernum);
        compoundTag.putInt("maxlayernum",maxlayernum);
        compoundTag.putFloat("jingyan",jingyan);
        compoundTag.putFloat("maxjingyan",maxjingyan);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        super.deserializeNBT(compoundTag);
        String string = compoundTag.getString("gongfaSample");
        gongfaSample = entity.level().registryAccess().registryOrThrow(gongfa_key).get(ResourceLocation.parse(string));

        this.layernum = compoundTag.getInt("layernum");
        this.maxlayernum = compoundTag.getInt("maxlayernum");
        this.jingyan = compoundTag.getFloat("jingyan");
        this.maxjingyan = compoundTag.getFloat("maxjingyan");
    }

    public GongfaSample getGongfaSample() {
        return gongfaSample;
    }

    public float getIntensity() {

        return gongfaSample.getIntensity();
    }

    public int getLayernum() {
        return layernum;
    }

    public int getMaxlayernum() {
        return maxlayernum;
    }

    public float getJingyan() {
        return jingyan;
    }

    public float getMaxjingyan() {
        return maxjingyan;
    }

    public boolean isYuanman() {
        return layernum>= maxlayernum;
    }
    public void xiulian(Player player, List<Entity> passengers) {
        gongfaSample.xiulian(player,passengers);

        if(player.level().getGameTime() %20 == 0){
            if (!isYuanman()){
                addjingyan(player,passengers);
            }else {
                yuanman(player,passengers);
            }

        }

    }

    private void addjingyan(Player player, List<Entity> passengers) {
        if(jingyan<maxlayernum){
            jingyan++;
            jingyan +=20;
        }else {
            jingyan=0;
            layernum++;
            if(layernum == maxlayernum){
                player.sendSystemMessage(Component.translatable("功法修炼圆满").withStyle(ChatFormatting.GOLD));
                yuanman(player,passengers);
            }else {
                player.sendSystemMessage(Component.translatable("功法突破至"+(layernum+1)+"层").withStyle(ChatFormatting.GOLD));
            }
        }
    }

    private void yuanman(Player player, List<Entity> passengers) {
        gongfaSample.yuanman(player,passengers);

        AdvenceInit.gongfatrigger.trigger((ServerPlayer) player,
                entity.level().registryAccess().registryOrThrow(gongfa_key).getKey(gongfaSample));
    }
}
