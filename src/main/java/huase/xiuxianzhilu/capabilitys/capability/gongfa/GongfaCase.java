package huase.xiuxianzhilu.capabilitys.capability.gongfa;

import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import java.util.List;

import static huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen.gongfa_key;

/**
 * - @description:GongfaCase类
 */
public class GongfaCase extends AttributeBase {
    GongfaSample gongfaSample;
    Player player;
    int layernum;
    int maxlayernum;
    int jingyan;
    int maxjingyan;
    public GongfaCase(Player player, CompoundTag compoundTag) {
        this.player = player;
        deserializeNBT(compoundTag);
    }

    public GongfaCase(Player player, GongfaSample gongfaSample) {
        this.player = player;
        this.gongfaSample = gongfaSample;
        this.maxlayernum = gongfaSample.getmaxlayernum();
        this.maxjingyan = gongfaSample.getmaxjingyan();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = super.serializeNBT();
        ResourceLocation key = player.level().registryAccess().registryOrThrow(gongfa_key).getKey(gongfaSample);
        if(key !=null){
            compoundTag.putString("gongfaSample",key.toString());
        }
        compoundTag.putInt("layernum",layernum);
        compoundTag.putInt("maxlayernum",maxlayernum);
        compoundTag.putInt("jingyan",jingyan);
        compoundTag.putInt("maxjingyan",maxjingyan);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        super.deserializeNBT(compoundTag);
        String string = compoundTag.getString("gongfaSample");
        gongfaSample = player.level().registryAccess().registryOrThrow(gongfa_key).get(ResourceLocation.parse(string));

        this.layernum = compoundTag.getInt("layernum");
        this.maxlayernum = compoundTag.getInt("maxlayernum");
        this.jingyan = compoundTag.getInt("jingyan");
        this.maxjingyan = compoundTag.getInt("maxjingyan");
    }

    public GongfaSample getGongfaSample() {
        return gongfaSample;
    }

    public int getIntensity() {

        return gongfaSample.getIntensity();
    }

    public void xiulian(Player player, List<Entity> passengers) {
        gongfaSample.xiulian(player,passengers);

        if(layernum <maxlayernum && player.level().getGameTime() %20 == 0){
            addjingyan(player,passengers);
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
    }
}
