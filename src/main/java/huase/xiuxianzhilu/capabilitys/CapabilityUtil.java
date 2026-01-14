package huase.xiuxianzhilu.capabilitys;

import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.Linggen;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaCase;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaSample;
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

import static huase.xiuxianzhilu.ModMain.random;
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



    public static void addLingxiuCase(Player player, Holder<LingxiuJingjieSample> lingxiuCase) {
        PlayerCapability capability =getCapability(player);
        List<LingxiuCase> lingxius = capability.getLingxius();


        lingxius.add(new LingxiuCase(player, lingxiuCase.get()));
        lingxius.sort((o1, o2) -> (int) (o1.getIntensity() - o2.getIntensity()));
        capability.setLingxiuindex(lingxius.size()-1);
        capability.setIsupdate(true);
        ResourceLocation key = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(lingxiuCase.get());
        player.sendSystemMessage(Component.translatable("修为成功进阶到").withStyle(ChatFormatting.YELLOW).append(Component.translatable(key.toString()).withStyle(ChatFormatting.GOLD)));
    }
    public static void openLinggen(Player player) {
        PlayerCapability capability =CapabilityUtil.getCapability(player);
        RandomSource random = player.getRandom();
        Linggen[] values = Linggen.values();
        List<Linggen> linggens1 = capability.getLinggens();
        linggens1.clear();
        while (linggens1.isEmpty()){
            for (Linggen value : values) {
                float v = random.nextFloat();
                if(v <=0.2f){
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

    public static void setLingxiuindex(Player player, int i) {
        PlayerCapability capability = getCapability(player);
        capability.setLingxiuindex(i);
    }
    public static LingxiuCase getLingxiuindext(Player player,int indext) {
        LingxiuCase lingxiuCase = getCapability(player).getLingxiu(indext);

        return lingxiuCase;
    }
    public static int getLingxiuindex(Player player) {
        PlayerCapability capability = getCapability(player);
        return capability.getLingxiuindex();
    }
    public static void setGongfaindex(Player player, int i) {
        PlayerCapability capability = getCapability(player);
        capability.setGongfaindex(i);
    }
    public static int getGongfaindex(Player player) {
        PlayerCapability capability = getCapability(player);
        return capability.getGongfaindex();
    }
    public static void addGongfa(Player player, ItemStack itemstack) {
        GongfaSample gongfaSample = player.level().registryAccess().registryOrThrow(gongfa_key).stream().filter(
                c -> itemstack.is(c.getItem())
        ).findAny().get();
        PlayerCapability capability =  getCapability(player);
        List<GongfaCase> gongfas = capability.getGongfas();
        for (GongfaCase gongfa : gongfas) {
            if(gongfaSample.equals(gongfa.getGongfaSample())){
                player.sendSystemMessage(Component.translatable("已有功法").withStyle(ChatFormatting.RED));
                return;
            }
        }

        Holder<LingxiuJingjieSample> child = gongfaSample.getChild();
        LingxiuCase lingxiu = capability.getLingxiu();

        if(child == null){
            if(lingxiu != null){
                player.sendSystemMessage(Component.translatable("修为境界不匹配，无法修炼该功法").withStyle(ChatFormatting.RED));
                return;
            }
        }else {
            if(lingxiu == null){
                player.sendSystemMessage(Component.translatable("修为境界不匹配，无法修炼该功法").withStyle(ChatFormatting.RED));
                return;
            }else {
                if(!lingxiu.getLingxiuJingjie().equals(child.get())){
                    player.sendSystemMessage(Component.translatable("修为境界不匹配，无法修炼该功法").withStyle(ChatFormatting.RED));
                    return;
                }
            }
        }
        ResourceLocation key = player.level().registryAccess().registryOrThrow(gongfa_key).getKey(gongfaSample);
        player.sendSystemMessage(Component.translatable("成功习得功法：").withStyle(ChatFormatting.AQUA)
                .append(Component.translatable(key.toString())));
        gongfas.add(new GongfaCase(player,gongfaSample));
        gongfas.sort((o1, o2) -> (int) (o2.getIntensity() - o1.getIntensity()));
        capability.setIsupdate(true);
    }


    public static GongfaCase getGongfaindext(Player player,int indext) {
        GongfaCase gongfaCase = getCapability(player).getGongfa(indext);

        return gongfaCase;
    }

    public static void xiuliangongfa(Player player, List<Entity> passengers) {
        GongfaCase gongfaindex = getCapability(player).getGongfa();

        if(gongfaindex == null){

        }else {
            gongfaindex.xiulian(player,passengers);
        }
    }

    public static void xiulianlingmai(Player player, List<Entity> passengers) {
        player.sendSystemMessage(Component.translatable("灵脉调整"));
    }

    public static float getPlayerLingli(Player player) {

        PlayerCapability capability =getCapability(player);
        return capability.getLingli();
    }

    public static void addPlayerLingli(Player player, float lingi) {
        PlayerCapability capability =getCapability(player);
        float v = getPlayerLingli(player) + lingi;
        float maxlingli = getMaxlingli(player);
        capability.setLingli(Math.min(maxlingli,Math.max(v,0)));

    }

    public static MutableComponent getJingjie(Player player) {
        PlayerCapability capability =getCapability(player);
        LingxiuCase lingxiuCase = capability.getLingxiu();
        if(lingxiuCase == null){
            return Component.translatable("凡人");
        }else {
            ResourceLocation key = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(lingxiuCase.getLingxiuJingjie());
            return Component.translatable(key.toString());
        }
    }
    public static int getJingjieNum(Player player) {
        PlayerCapability capability =getCapability(player);
        return capability.getLingxiuindex();
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
        LingxiuCase lingxiuCase = capability.getLingxiu();
        if(lingxiuCase == null)return 0;
        return lingxiuCase.getDengji()+1;
    }
    public static String getCengshustring(Player player) {
        PlayerCapability capability =getCapability(player);
        LingxiuCase lingxiuCase = capability.getLingxiu();
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
        LingxiuCase lingxiuCase = capability.getLingxiu();
        if(lingxiuCase == null)return 0;
        return lingxiuCase.getMaxdengji()+1;
    }
    public static String getMaxcengshustring(Player player) {
        PlayerCapability capability =getCapability(player);
        LingxiuCase lingxiuCase = capability.getLingxiu();
        if(lingxiuCase == null)return "无";
        return (lingxiuCase.getMaxdengji()+1)+"层";
    }

    public static int getXiulianshudu(Player player) {
        PlayerCapability capability =getCapability(player);
        int value = 0;
        LingxiuCase lingxiuCase = capability.getLingxiu();
        if(lingxiuCase != null){
            value += lingxiuCase.getIntensity();
        }
        GongfaCase gongfaindex = capability.getGongfa();
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
        LingxiuCase lingxiuCase = capability.getLingxiu();
        if(lingxiuCase == null)return 0;
        return lingxiuCase.getJingyan();
    }

    public static float getMaxjingyan(Player player) {
        PlayerCapability capability =getCapability(player);
        LingxiuCase lingxiuCase = capability.getLingxiu();
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

    public static void addNianling(Player player, int i) {
        PlayerCapability capability =getCapability(player);
        capability.setNianling(Math.min(getShouyuan(player),getNianling(player)+i));

        if(getNianling(player)+3>=getShouyuan(player)){
            player.sendSystemMessage(Component.translatable("油尽灯枯，寿元即将耗尽").withStyle(ChatFormatting.RED));
        }
        if(getNianling(player)>=getShouyuan(player)){
            chongsheng(player);
        }
        capability.setIsupdate(true);
    }

    static void chongsheng(Player player) {

        PlayerCapability playerCapability =getCapability(player);
        PlayerCapability playerCapability1 = new PlayerCapability(player);
        playerCapability.deserializeNBT(playerCapability1.serializeNBT());
        playerCapability.setIsupdate(true);
        player.setHealth(0);
        player.die(player.damageSources().generic());
        player.sendSystemMessage(Component.translatable("§4修炼一生最后不过一堆黄土，寿命耗尽"));
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
    public static void addLingli(Player player,float value) {
        PlayerCapability capability =getCapability(player);
        capability.setLingli(Math.min(Math.max(getLingli(player)+value,0),getMaxlingli(player)));

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

    public static boolean handleMingzhong(Entity entity, LivingEntity living) {
        float mingzhong = 0;
        if(entity instanceof Player player){
             mingzhong += getMingzhong(player);
        }
        float dunsu = 0;
        if(living instanceof Player player){
             dunsu = getDunsu(player);
        }
        float i1 = random.nextFloat(100);
        if(i1+mingzhong-dunsu>0){
            return true;
        }
        return false;
    }

    public static float handleWuliDamage(Entity entity, LivingEntity living, float amount) {

        float i = 0;
        float j = 0;
        if(entity instanceof Player player){
            float linglixiaohao = getXiulianshudu(player)/10f;
            float lingli = getLingli(player);
            if(lingli>linglixiaohao){
                i = getWugong(player) + handleBaolv(getBaolv(player)) * (0.4f + getBaojishanghai(player)/100f) * getWugong(player);
                addLingli(player,-linglixiaohao);
            }
        }
        if(living instanceof Player player){
            float linglixiaohao = getXiulianshudu(player)/30f;
            float lingli = getLingli(player);
            if(lingli>linglixiaohao){
                j = getWufang(player);
            }
            addLingli(player,-linglixiaohao);
        }

        return Math.max(0,i-j+amount);
    }

    static float handleBaolv(float i) {
        float i1 = random.nextFloat(100);
        if(i1+i>100){
            return 1;
        }
        return 0;
    }

     public static void handxixue(Entity entity, float amount) {
        if(entity != null && entity.isAlive()){
            if(entity instanceof Player player){
                float v1 = getXixue(player) / 100f * amount;
                player.setHealth(player.getHealth()+v1);
            }
        }
    }

}
