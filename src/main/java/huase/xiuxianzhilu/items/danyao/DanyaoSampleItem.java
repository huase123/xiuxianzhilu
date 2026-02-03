package huase.xiuxianzhilu.items.danyao;

import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
import huase.xiuxianzhilu.capabilitys.capability.danyao.Danyaoabstract;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuCase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static huase.xiuxianzhilu.capabilitys.capability.danyao.DanyaoGen.danyao_key;
import static huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen.lingxiu_jingjie_key;

/**
 * - @description:CailiaoSampleItem类
 */
public class DanyaoSampleItem extends Item {
    public DanyaoSampleItem() {
        super(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build()));
    }


    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof ServerPlayer serverplayer) {

            int value = serverplayer.getStats().getValue(UseStats.danyaoused.get(), this);
            Danyaoabstract danyaoSample = getDanyaoSample(pLevel, pStack);
            if (danyaoSample.getMaxusetime() == -1 || value <= danyaoSample.getMaxusetime()) {
                Holder<LingxiuJingjieSample> lingxiuJingjieSample = danyaoSample.getJingjie();
                if (lingxiuJingjieSample == null || isSatisfy(serverplayer,lingxiuJingjieSample)) {
                    finishUsingItem(danyaoSample, serverplayer);
                } else {
                    serverplayer.sendSystemMessage(Component.translatable("当前境界无法服用该丹药"));
                }
            } else {
                serverplayer.sendSystemMessage(Component.translatable("已达到服用上限"));
            }
        }


        return  pStack;
    }

    private boolean isSatisfy(ServerPlayer serverplayer, Holder<LingxiuJingjieSample> lingxiuJingjieSample) {
        PlayerCapability capability = CapabilityUtil.getCapability(serverplayer);
        for (LingxiuCase lingxius : capability.getLingxius()) {
            if(lingxiuJingjieSample.get().equals(lingxius.getLingxiuJingjie())){
                return true;
            }
        }
        return false;
    }

    private void finishUsingItem(Danyaoabstract danyaoSample, ServerPlayer serverplayer) {

        PlayerCapability capability = CapabilityUtil.getCapability(serverplayer);
        LingxiuCase lingxiu = capability.getLingxiu();
        AttributeBase attributeBase;
        if(lingxiu == null){
            attributeBase =capability;
        }else {
            attributeBase =lingxiu;
        }
        if(danyaoSample.getJingyan()>0 && lingxiu !=null){
            lingxiu.addJingyan(serverplayer,danyaoSample.getJingyan());
        }
        if(danyaoSample.getReturnTolingli()>0 ){
            CapabilityUtil.addLingli(serverplayer,danyaoSample.getReturnTolingli());
        }
        if(danyaoSample.getReturnToLife()>0 ){
            serverplayer.setHealth(serverplayer.getHealth()+danyaoSample.getReturnToLife());
        }
        if(danyaoSample.getBaojilv()>0 ){
            attributeBase.setBaojilv(attributeBase.getBaojilv()+danyaoSample.getBaojilv());
        }
        if(danyaoSample.getBaojishanghai()>0 ){
            attributeBase.setBaojishanghai(attributeBase.getBaojishanghai()+danyaoSample.getBaojishanghai());
        }
        if(danyaoSample.getDunsu()>0 ){
            attributeBase.setDunsu(attributeBase.getDunsu()+danyaoSample.getDunsu());
        }
        if(danyaoSample.getMaxlingli()>0 ){
            attributeBase.setMaxlingli(attributeBase.getMaxlingli()+danyaoSample.getMaxlingli());
        }
        if(danyaoSample.getMaxshengming()>0 ){
            attributeBase.setMaxshengming(attributeBase.getMaxshengming()+danyaoSample.getMaxshengming());
        }
        if(danyaoSample.getMingzhong()>0 ){
            attributeBase.setMingzhong(attributeBase.getMingzhong()+danyaoSample.getMingzhong());
        }
        if(danyaoSample.getShouyuan()>0 ){
            attributeBase.setShouyuan(attributeBase.getShouyuan()+danyaoSample.getShouyuan());
        }
        if(danyaoSample.getWufang()>0 ){
            attributeBase.setWufang(attributeBase.getWufang()+danyaoSample.getWufang());
        }
        if(danyaoSample.getWugong()>0 ){
            attributeBase.setWugong(attributeBase.getWugong()+danyaoSample.getWugong());
        }
        if(danyaoSample.getXixue()>0 ){
            attributeBase.setXixue(attributeBase.getXixue()+danyaoSample.getXixue());
        }
        capability.setIsupdate(true);
    }


    Danyaoabstract sample;
    public Danyaoabstract getDanyaoSample(Level level, ItemStack pStack) {
        if(sample == null){
            sample = level.registryAccess().registryOrThrow(danyao_key).stream().filter(
                    c -> pStack.is(c.getItem())
            ).findAny().get();
        }
        return sample;
    }

    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        if(pLevel == null)return;
        Danyaoabstract sample = getDanyaoSample(pLevel, pStack);

        Holder<LingxiuJingjieSample> jingjie = sample.getJingjie();
        if(jingjie != null){
            pTooltip.add(Component.translatable("所需境界:").withStyle(ChatFormatting.AQUA).append(Component.translatable(pLevel.registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(jingjie.get()).toString())));
        }

        if(sample.getMaxusetime() != -1){
            pTooltip.add(Component.translatable("可服用:").append(Component.translatable(sample.getMaxusetime()+"次").withStyle(ChatFormatting.YELLOW)));
        }

        pTooltip.add(Component.translatable("-----属性-----").withStyle(ChatFormatting.WHITE));



        if(sample.getJingyan()>0){
            pTooltip.add(Component.translatable("修为:").append(Component.translatable("+"+sample.getJingyan()).withStyle(ChatFormatting.YELLOW)));

        }
        if(sample.getReturnTolingli()>0 ){
            pTooltip.add(Component.translatable("灵力:").append(Component.translatable("+"+sample.getReturnTolingli()).withStyle(ChatFormatting.YELLOW)));
        }
        if(sample.getReturnToLife()>0 ){
            pTooltip.add(Component.translatable("生命:").append(Component.translatable("+"+sample.getReturnToLife()).withStyle(ChatFormatting.YELLOW)));
        }




        if(sample.getMaxshengming() >0 ){
            pTooltip.add(Component.translatable("最大生命:").append(Component.translatable("+"+sample.getMaxshengming()).withStyle(ChatFormatting.YELLOW)));
        }

        if(sample.getWugong() >0 ){
            pTooltip.add(Component.translatable("物攻:").append(Component.translatable("+"+sample.getWugong()).withStyle(ChatFormatting.YELLOW)));
        }
        if(sample.getWufang() >0 ){
            pTooltip.add(Component.translatable("物防:").append(Component.translatable("+"+sample.getWufang()).withStyle(ChatFormatting.YELLOW)));

        }

        if(sample.getBaojishanghai() >0 ){
            pTooltip.add(Component.translatable("爆伤:").append(Component.translatable("+"+sample.getBaojishanghai()).withStyle(ChatFormatting.YELLOW)));

        }

        if(sample.getBaojilv() >0 ){
            pTooltip.add(Component.translatable("爆率:").append(Component.translatable("+"+sample.getBaojilv()).withStyle(ChatFormatting.YELLOW)));

        }

        if(sample.getMingzhong() >0 ){
            pTooltip.add(Component.translatable("命中:").append(Component.translatable("+"+sample.getMingzhong()).withStyle(ChatFormatting.YELLOW)));

        }

        if(sample.getShouyuan() >0 ){
            pTooltip.add(Component.translatable("寿元:").append(Component.translatable("+"+sample.getShouyuan()).withStyle(ChatFormatting.YELLOW)));

        }

        if(sample.getMaxlingli() >0 ){
            pTooltip.add(Component.translatable("最大灵力:").append(Component.translatable("+"+sample.getMaxlingli()).withStyle(ChatFormatting.YELLOW)));

        }

        if(sample.getDunsu() >0 ){
            pTooltip.add(Component.translatable("遁速:").append(Component.translatable("+"+sample.getDunsu()).withStyle(ChatFormatting.YELLOW)));

        }
        if(sample.getXixue() >0 ){
            pTooltip.add(Component.translatable("吸血:").append(Component.translatable("+"+sample.getXixue()).withStyle(ChatFormatting.YELLOW)));
        }


    }
}
