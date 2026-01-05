package huase.xiuxianzhilu.capabilitys;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.Linggen;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaCase;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaSample;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuCase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import java.util.List;

import static huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen.gongfa_key;
import static huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen.lingxiu_jingjie_key;

/**
 * - @description:CapabilityUtil类
 * - @author: huase。
 * - @date: 2025/10/12 9:03
 */
public class CapabilityUtil {

    public static void synsMaxhealth(Entity entity, AttributeBase capability) {
        if (entity instanceof LivingEntity livingEntity){
            float maxshengming = capability.getMaxshengming();
            if(livingEntity.getAttribute(Attributes.MAX_HEALTH).getValue() != maxshengming){
                livingEntity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(maxshengming);
                if(!(entity instanceof Player)){
                    livingEntity.setHealth(maxshengming);
                }
            }
        }
    }

    public static AttributeBase getCapability(ICapabilityProvider capabilityProvider) {
//        if(capabilityProvider == null)return null;
        if(capabilityProvider instanceof Player)return capabilityProvider.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).orElse(null);
        if(capabilityProvider instanceof LivingEntity)return capabilityProvider.getCapability(RegisterCapabilitys.MOSTERCAPABILITY).orElse(null);
        return null;
    }

    public static PlayerCapability getCapability(Player player) {
        return player.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).orElse(null);
    }



    public static void addLingxiuCase(Player player) {
        PlayerCapability capability = (PlayerCapability) getCapability(player);
        List<LingxiuCase> lingxius = capability.getLingxius();
        if(lingxius.isEmpty()){
            LingxiuJingjieSample lingxiuJingjieSample = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.lianqi);
            lingxius.add(new LingxiuCase(player, lingxiuJingjieSample));
            ModMain.LOGGER.info("成功添加新境界");
        }else {
            LingxiuCase lingxiuCase = lingxius.get(lingxius.size() - 1);
            Holder<LingxiuJingjieSample> prent = lingxiuCase.getLingxiuJingjie().getPrent();

            if(prent != null){
                lingxius.add(new LingxiuCase(player,prent.get()));
            }else {
                ModMain.LOGGER.info("无后续境界");
            }
        }
    }
    public static void openLinggen(Player player) {
        PlayerCapability capability =CapabilityUtil.getCapability(player);
        RandomSource random = player.getRandom();
        Linggen[] values = Linggen.values();
        List<Linggen> linggens1 = capability.getLinggens();
        linggens1.clear();
        while (linggens1.isEmpty()){
            for (Linggen value : values) {
                if(random.nextBoolean());{
                    linggens1.add(value);
                }
            }
        }
        capability.createDensityFunction(player);
        player.sendSystemMessage(Component.translatable("成功觉醒灵根").append(getLinggenstring(player)));
        capability.setIsupdate(true);
    }

    public static boolean isOpenLinggen(Player player) {

        PlayerCapability capability =CapabilityUtil.getCapability(player);
        List<Linggen> linggens1 = capability.getLinggens();
        return !linggens1.isEmpty();
    }

    public static void addGongfa(Player player, ItemStack itemstack) {
        GongfaSample gongfaSample = player.level().registryAccess().registryOrThrow(gongfa_key).stream().filter(
                c -> itemstack.is(c.getItem())
        ).findAny().get();
        PlayerCapability capability =  getCapability(player);
        for (GongfaCase gongfa : capability.getGongfas()) {
            if(gongfaSample.equals(gongfa.getGongfaSample())){
                player.sendSystemMessage(Component.translatable("已有功法").withStyle(ChatFormatting.RED));
                return;
            }
        }

        ResourceLocation key = player.level().registryAccess().registryOrThrow(gongfa_key).getKey(gongfaSample);
        player.sendSystemMessage(Component.translatable("成功习得功法：").withStyle(ChatFormatting.AQUA)
                .append(Component.translatable(key.toString())));
        capability.getGongfas().add(new GongfaCase(player,gongfaSample));
        capability.setIsupdate(true);
    }


    public static void xiuliangongfa(Player player, List<Entity> passengers) {
        GongfaCase gongfaindex = getCapability(player).getGongfaindex();

        if(gongfaindex == null){

        }else {
            gongfaindex.xiulian(player,passengers);
        }
    }

    public static void xiulianlingmai(Player player, List<Entity> passengers) {
        player.sendSystemMessage(Component.translatable("灵脉调整"));
    }

    public static float getPlayerLingli(Player player) {

        return 100;
    }

    public static void addPlayerLingli(float lingi) {

    }

    public static MutableComponent getJingjie(Player player) {
        PlayerCapability capability =getCapability(player);
        LingxiuCase lingxiuCase = capability.getLingxiuindex();
        if(lingxiuCase == null){
            return Component.translatable("凡人");
        }else {
            ResourceLocation key = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(lingxiuCase.getLingxiuJingjie());
            return Component.translatable(key.toString());
        }
    }

    public static MutableComponent getMaxjingjie(Player player) {
        PlayerCapability capability =getCapability(player);
        List<LingxiuCase> lingxius = capability.getLingxius();
        if(lingxius.isEmpty()){
            return Component.translatable("凡人");
        }else {
            LingxiuCase lingxiuCase = lingxius.get(lingxius.size() - 1);
            ResourceLocation key = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(lingxiuCase.getLingxiuJingjie());
            return Component.translatable(key.toString());
        }
    }
    public static int getCengshu(Player player) {
        PlayerCapability capability =getCapability(player);
        LingxiuCase lingxiuCase = capability.getLingxiuindex();
        if(lingxiuCase == null)return 0;
        return lingxiuCase.getDengji()+1;
    }
    public static String getCengshustring(Player player) {
        PlayerCapability capability =getCapability(player);
        LingxiuCase lingxiuCase = capability.getLingxiuindex();
        if(lingxiuCase == null)return "无";
        int dengji = lingxiuCase.getDengji();
        int maxDengji = lingxiuCase.getMaxdengji();
        if(maxDengji == 3){
            switch (dengji){
                case 0:return "初期";
                case 1:return "中期";
                case 2:return "后期";
                case 3:return "圆满";
            }
        }
        return (dengji+1)+"层";
    }
    public static int getMaxcengshu(Player player) {
        PlayerCapability capability =getCapability(player);
        LingxiuCase lingxiuCase = capability.getLingxiuindex();
        if(lingxiuCase == null)return 0;
        return lingxiuCase.getMaxdengji()+1;
    }
    public static String getMaxcengshustring(Player player) {
        PlayerCapability capability =getCapability(player);
        LingxiuCase lingxiuCase = capability.getLingxiuindex();
        if(lingxiuCase == null)return "无";
        return (lingxiuCase.getMaxdengji()+1)+"层";
    }

    public static int getXiulianshudu(Player player) {
        PlayerCapability capability =getCapability(player);
        int value = 0;
        LingxiuCase lingxiuCase = capability.getLingxiuindex();
        if(lingxiuCase != null){
            value += lingxiuCase.getIntensity();
        }
        GongfaCase gongfaindex = capability.getGongfaindex();
        if(gongfaindex != null){
            value += gongfaindex.getIntensity();
        }
        return value;
    }

    public static MutableComponent getLinggenstring(Player player) {
        PlayerCapability capability =getCapability(player);
        List<Linggen> linggens = capability.getLinggens();
        if(linggens.isEmpty()){
            return Component.translatable("无");
        }else{
            MutableComponent translatable = Component.translatable("");
            for (Linggen linggen : linggens) {
                translatable.append(Component.translatable("linggen."+linggen.toString()));
            }
            return translatable;
        }

    }

    public static float getJingyan(Player player) {
        PlayerCapability capability =getCapability(player);
        LingxiuCase lingxiuCase = capability.getLingxiuindex();
        if(lingxiuCase == null)return 0;
        return lingxiuCase.getJingyan();
    }

    public static float getMaxjingyan(Player player) {
        PlayerCapability capability =getCapability(player);
        LingxiuCase lingxiuCase = capability.getLingxiuindex();
        if(lingxiuCase == null)return 0;
        return lingxiuCase.getMaxjingyan();
    }

    public static float getNianling(Player player) {
        PlayerCapability capability =getCapability(player);
        return capability.getNianling();
    }

    public static float getShouyuan(Player player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getShouyuan();
        for (LingxiuCase lingxius : capability.getLingxius()) {
            value +=lingxius.getShouyuan();
        }
        return value;
    }

    public static float getShengming(Player player) {

        return player.getHealth();
    }

    public static float getMaxshengming(Player player) {

        PlayerCapability capability =getCapability(player);
        float value = capability.getMaxshengming();
        for (LingxiuCase lingxius : capability.getLingxius()) {
            value +=lingxius.getMaxshengming();
        }
//        处理玩家血量与capabilit血量的不同
        if(player.getMaxHealth()!=value){
            player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(value);
        }
        return value;
    }

    public static float getLingli(Player player) {
        PlayerCapability capability =getCapability(player);
        return  capability.getLingli();
    }

    public static float getMaxlingli(Player player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getMaxlingli();
        for (LingxiuCase lingxius : capability.getLingxius()) {
            value +=lingxius.getMaxlingli();
        }
        return value;
    }

    public static float getWugong(Player player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getWugong();
        for (LingxiuCase lingxius : capability.getLingxius()) {
            value +=lingxius.getWugong();
        }
        return value;
    }

    public static float getWufang(Player player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getWufang();
        for (LingxiuCase lingxius : capability.getLingxius()) {
            value +=lingxius.getWufang();
        }
        return value;

    }

    public static float getMingzhong(Player player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getMingzhong();
        for (LingxiuCase lingxius : capability.getLingxius()) {
            value +=lingxius.getMingzhong();
        }
        return value;
    }

    public static float getDunsu(Player player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getDunsu();
        for (LingxiuCase lingxius : capability.getLingxius()) {
            value +=lingxius.getDunsu();
        }
        return value;
    }

    public static float getBaojishanghai(Player player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getBaojishanghai();
        for (LingxiuCase lingxius : capability.getLingxius()) {
            value +=lingxius.getBaojishanghai();
        }
        return value;
    }

    public static float getBaolv(Player player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getBaojilv();
        for (LingxiuCase lingxius : capability.getLingxius()) {
            value +=lingxius.getBaojilv();
        }
        return value;
    }

    public static float getXixue(Player player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getXixue();
        for (LingxiuCase lingxius : capability.getLingxius()) {
            value +=lingxius.getXixue();
        }
        return value;
    }
}
