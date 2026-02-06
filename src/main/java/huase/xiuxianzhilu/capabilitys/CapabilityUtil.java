package huase.xiuxianzhilu.capabilitys;

import huase.xiuxianzhilu.advance.AdvenceInit;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.DensityFunction;
import huase.xiuxianzhilu.capabilitys.capability.Linggen;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaCase;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaSample;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuCase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import huase.xiuxianzhilu.entity.moster.CapabilityMoster;
import huase.xiuxianzhilu.items.fabao.FabaoSampleItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
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

    public static PlayerCapability getCapability(Entity entity) {
        return entity.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).orElse(null);
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

        AdvenceInit.changelingxiutrigger.trigger((ServerPlayer) player,key);
    }
    public static void addLingxiuCase(LivingEntity livingEntity, LingxiuCase lingxiuCase) {
        PlayerCapability capability =getCapability(livingEntity);
        List<LingxiuCase> lingxius = capability.getLingxius();


        lingxius.add(lingxiuCase);
        lingxius.sort((o1, o2) -> (int) (o1.getIntensity() - o2.getIntensity()));
        capability.setLingxiuindex(lingxius.size()-1);
        capability.setIsupdate(true); }
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

        AdvenceInit.juexinglinggen.trigger((ServerPlayer) player);
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
    public static int getLingxiuindex(Entity player) {
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
        gongfas.sort((o1, o2) -> (int) (o1.getIntensity() - o2.getIntensity()));
        capability.setIsupdate(true);
    }


    public static GongfaCase getGongfaindext(Player player,int indext) {
        GongfaCase gongfaCase = getCapability(player).getGongfa(indext);

        return gongfaCase;
    }

    public static void xiuliangongfa(Player player, List<Entity> passengers) {
        if(player.level().isClientSide)return;
        GongfaCase gongfaindex = getCapability(player).getGongfa();
        if(gongfaindex == null){
        }else {
            gongfaindex.xiulian(player,passengers);
        }
    }

    public static void xiulianlingmai(Player player, List<Entity> passengers) {

        player.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).ifPresent(playerCapability -> {
            DensityFunction densityFunction = playerCapability.getDensityFunction();
            if(densityFunction == null){
                if(player instanceof ServerPlayer serverPlayer){
                    ((ServerPlayer)player).connection.send(new ClientboundSetActionBarTextPacket(Component.translatable("未觉醒灵根，无法调整").withStyle(ChatFormatting.GREEN)));
                }
            }else {
                densityFunction.dazuotiaozheng(player,passengers);
                if(player instanceof ServerPlayer serverPlayer){
                    ((ServerPlayer)player).connection.send(new ClientboundSetActionBarTextPacket(Component.translatable("正在调整灵脉").withStyle(ChatFormatting.GREEN)));


                    AdvenceInit.tiaozhenglingmai.trigger((ServerPlayer) player);
                }
            };
        });
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

    public static int getXiulianshudu(Entity player) {
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
        for (int i = 0; i <= getLingxiuindex(player); i++) {
            LingxiuCase lingxius = capability.getLingxius().get(i);
            if(lingxius.isActivate())
            value +=lingxius.getShouyuan();
        }
        for (GongfaCase gongfa : capability.getGongfas()) {
            value +=gongfa.getShouyuan();
        }
        for (int i = 0; i <capability.getFabaoslot().getSlots(); i++) {
            ItemStack pStack = capability.getFabaoslot().getStackInSlot(i);
            if(!pStack.isEmpty() && pStack.getItem() instanceof FabaoSampleItem fabaoSampleItem){
                value +=fabaoSampleItem.getShouyuan(player.level(),pStack);
            }
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

    public static void addShouyuan(Player player, int i) {
        PlayerCapability capability =getCapability(player);
        capability.setShouyuan(Math.min(getShouyuan(player)+i,getShouyuan(player)));

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

    public static float getMaxshengming(LivingEntity player) {

        PlayerCapability capability =getCapability(player);
        float value = capability.getMaxshengming();
        for (int i = 0; i <= getLingxiuindex(player); i++) {
            LingxiuCase lingxius = capability.getLingxius().get(i);
            if(lingxius.isActivate())
            value +=lingxius.getMaxshengming();
        }
        for (GongfaCase gongfa : capability.getGongfas()) {
            value +=gongfa.getMaxshengming();
        }
        for (int i = 0; i <capability.getFabaoslot().getSlots(); i++) {
            ItemStack pStack = capability.getFabaoslot().getStackInSlot(i);
            if(!pStack.isEmpty() && pStack.getItem() instanceof FabaoSampleItem fabaoSampleItem){
                value +=fabaoSampleItem.getMaxshengming(player.level(),pStack);
            }
        }


//        处理玩家血量与capabilit血量的不同
        if(player.getMaxHealth()!=value){
            player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(value);
        }
        return value;
    }

    public static float getLingli(Entity player) {
        PlayerCapability capability =getCapability(player);
        return  capability.getLingli();
    }
    public static void addLingli(Entity player, float value) {
        PlayerCapability capability =getCapability(player);
        capability.setLingli(Math.min(Math.max(getLingli(player)+value,0),getMaxlingli(player)));

    }

    public static float getMaxlingli(Entity player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getMaxlingli();
        for (int i = 0; i <= getLingxiuindex(player); i++) {
            LingxiuCase lingxius = capability.getLingxius().get(i);
            if(lingxius.isActivate())
            value +=lingxius.getMaxlingli();
        }
        for (GongfaCase gongfa : capability.getGongfas()) {
            value +=gongfa.getMaxlingli();
        }
        for (int i = 0; i <capability.getFabaoslot().getSlots(); i++) {
            ItemStack pStack = capability.getFabaoslot().getStackInSlot(i);
            if(!pStack.isEmpty() && pStack.getItem() instanceof FabaoSampleItem fabaoSampleItem){
                value +=fabaoSampleItem.getMaxlingli(player.level(),pStack);
            }
        }

        return value;
    }

    public static float getWugong(Entity player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getWugong();
        for (int i = 0; i <= getLingxiuindex(player); i++) {
            LingxiuCase lingxius = capability.getLingxius().get(i);
            if(lingxius.isActivate())
            value +=lingxius.getWugong();
        }
        for (GongfaCase gongfa : capability.getGongfas()) {
            value +=gongfa.getWugong();
        }
        for (int i = 0; i <capability.getFabaoslot().getSlots(); i++) {
            ItemStack pStack = capability.getFabaoslot().getStackInSlot(i);
            if(!pStack.isEmpty() && pStack.getItem() instanceof FabaoSampleItem fabaoSampleItem){
                value +=fabaoSampleItem.getWugong(player.level(),pStack);
            }
        }
        return value;
    }

    public static float getWufang(Entity player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getWufang();
        for (int i = 0; i <= getLingxiuindex(player); i++) {
            LingxiuCase lingxius = capability.getLingxius().get(i);
            if(lingxius.isActivate())
            value +=lingxius.getWufang();
        }
        for (GongfaCase gongfa : capability.getGongfas()) {
            value +=gongfa.getWufang();
        }
        for (int i = 0; i <capability.getFabaoslot().getSlots(); i++) {
            ItemStack pStack = capability.getFabaoslot().getStackInSlot(i);
            if(!pStack.isEmpty() && pStack.getItem() instanceof FabaoSampleItem fabaoSampleItem){
                value +=fabaoSampleItem.getWufang(player.level(),pStack);
            }
        }
        return value;

    }

    public static float getMingzhong(Entity entity) {
        PlayerCapability capability =getCapability(entity);
        float value = capability.getMingzhong();
        for (int i = 0; i <= getLingxiuindex(entity); i++) {
            LingxiuCase lingxius = capability.getLingxius().get(i);
            if(lingxius.isActivate())
            value +=lingxius.getMingzhong();
        }
        for (GongfaCase gongfa : capability.getGongfas()) {
            value +=gongfa.getMingzhong();
        }
        for (int i = 0; i <capability.getFabaoslot().getSlots(); i++) {
            ItemStack pStack = capability.getFabaoslot().getStackInSlot(i);
            if(!pStack.isEmpty() && pStack.getItem() instanceof FabaoSampleItem fabaoSampleItem){
                value +=fabaoSampleItem.getMingzhong(entity.level(),pStack);
            }
        }
        return value;
    }

    public static float getDunsu(Entity player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getDunsu();
        for (int i = 0; i <= getLingxiuindex(player); i++) {
            LingxiuCase lingxius = capability.getLingxius().get(i);
            if(lingxius.isActivate())
            value +=lingxius.getDunsu();
        }
        for (GongfaCase gongfa : capability.getGongfas()) {
            value +=gongfa.getDunsu();
        }
        for (int i = 0; i <capability.getFabaoslot().getSlots(); i++) {
            ItemStack pStack = capability.getFabaoslot().getStackInSlot(i);
            if(!pStack.isEmpty() && pStack.getItem() instanceof FabaoSampleItem fabaoSampleItem){
                value +=fabaoSampleItem.getDunsu(player.level(),pStack);
            }
        }
        return value;
    }

    public static float getBaojishanghai(Entity player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getBaojishanghai();
        for (int i = 0; i <= getLingxiuindex(player); i++) {
            LingxiuCase lingxius = capability.getLingxius().get(i);
            if(lingxius.isActivate())
            value +=lingxius.getBaojishanghai();
        }
        for (GongfaCase gongfa : capability.getGongfas()) {
            value +=gongfa.getBaojishanghai();
        }
        for (int i = 0; i <capability.getFabaoslot().getSlots(); i++) {
            ItemStack pStack = capability.getFabaoslot().getStackInSlot(i);
            if(!pStack.isEmpty() && pStack.getItem() instanceof FabaoSampleItem fabaoSampleItem){
                value +=fabaoSampleItem.getBaojishanghai(player.level(),pStack);
            }
        }
        return value;
    }

    public static float getBaolv(Entity player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getBaojilv();
        for (int i = 0; i <= getLingxiuindex(player); i++) {
            LingxiuCase lingxius = capability.getLingxius().get(i);
            if(lingxius.isActivate())
            value +=lingxius.getBaojilv();
        }
        for (GongfaCase gongfa : capability.getGongfas()) {
            value +=gongfa.getBaojilv();
        }
        for (int i = 0; i <capability.getFabaoslot().getSlots(); i++) {
            ItemStack pStack = capability.getFabaoslot().getStackInSlot(i);
            if(!pStack.isEmpty() && pStack.getItem() instanceof FabaoSampleItem fabaoSampleItem){
                value +=fabaoSampleItem.getBaojilv(player.level(),pStack);
            }
        }
        return value;
    }

    public static float getXixue(Entity player) {
        PlayerCapability capability =getCapability(player);
        float value = capability.getXixue();
        for (int i = 0; i <= getLingxiuindex(player); i++) {
            LingxiuCase lingxius = capability.getLingxius().get(i);
            if(lingxius.isActivate())
            value +=lingxius.getXixue();
        }
        for (GongfaCase gongfa : capability.getGongfas()) {
            value +=gongfa.getXixue();
        }
        for (int i = 0; i <capability.getFabaoslot().getSlots(); i++) {
            ItemStack pStack = capability.getFabaoslot().getStackInSlot(i);
            if(!pStack.isEmpty() && pStack.getItem() instanceof FabaoSampleItem fabaoSampleItem){
                value +=fabaoSampleItem.getXixue(player.level(),pStack);
            }
        }
        return value;
    }

    public static boolean handleMingzhong(Entity entity, LivingEntity living) {
        float mingzhong = 0;
        if(entity instanceof Player || entity instanceof CapabilityMoster){
             mingzhong += getMingzhong(entity);
        }
        float dunsu = 0;
        if(living instanceof Player || entity instanceof CapabilityMoster){
             dunsu = getDunsu(living);
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
        if(entity instanceof Player){
            float linglixiaohao = getXiulianshudu(entity)/10f;
            float lingli = getLingli(entity);
            if(lingli>linglixiaohao){
                i = getWugong(entity) + handleBaolv(getBaolv(entity)) * (0.4f + getBaojishanghai(entity)/100f) * getWugong(entity);
                addLingli(entity,-linglixiaohao);
            }
        }
        if(entity instanceof CapabilityMoster){
            i = getWugong(entity) + handleBaolv(getBaolv(entity)) * (0.4f + getBaojishanghai(entity)/100f) * getWugong(entity);
        }
        if(living instanceof Player ){
            float linglixiaohao = getXiulianshudu(living)/30f;
            float lingli = getLingli(living);
            if(lingli>linglixiaohao){
                j = getWufang(living);
            }
            addLingli(living,-linglixiaohao);
        }
        if(living instanceof CapabilityMoster){
            j = getWufang(living);
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
            if(entity instanceof CapabilityMoster && entity instanceof LivingEntity livingEntity){
                float v1 = getXixue(entity) / 100f * amount;
                livingEntity.setHealth(livingEntity.getHealth()+v1);
            }
        }
    }

}
