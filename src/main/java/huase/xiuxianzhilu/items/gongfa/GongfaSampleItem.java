package huase.xiuxianzhilu.items.gongfa;

import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaSample;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen.gongfa_key;
import static huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen.lingxiu_jingjie_key;

/**
 * - @description:GongfaSampleItem类
 */
public class GongfaSampleItem extends Item {
    public GongfaSampleItem() {
        super(new Item.Properties());
    }
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {

            CapabilityUtil.addGongfa(pPlayer,itemstack);

        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }


    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);

        if(pLevel == null)return;
        GongfaSample gongfaSample = pLevel.registryAccess().registryOrThrow(gongfa_key).stream().filter(
                c -> pStack.is(c.getItem())
        ).findAny().get();

        Holder<LingxiuJingjieSample> child = gongfaSample.getChild();
        if(child != null){
            pTooltip.add(Component.translatable("所需境界:").append(Component.translatable(pLevel.registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(child.get()).toString())).withStyle(ChatFormatting.GREEN));
        }

        if(gongfaSample.getmaxlayernum() >0 ){
            pTooltip.add(Component.translatable("最大层数:"+gongfaSample.getmaxlayernum()).withStyle(ChatFormatting.YELLOW));
        }

        if(gongfaSample.getIntensity() >0 ){
            pTooltip.add(Component.translatable("修炼速度",gongfaSample.getIntensity()).withStyle(ChatFormatting.YELLOW));
        }

        if(gongfaSample.getMaxshengming() >0 ){
            pTooltip.add(Component.translatable("最大生命",gongfaSample.getMaxshengming()).withStyle(ChatFormatting.YELLOW));
        }

        if(gongfaSample.getWufang() >0 ){
            pTooltip.add(Component.translatable("物防",gongfaSample.getWufang()).withStyle(ChatFormatting.YELLOW));
        }

        if(gongfaSample.getBaojishanghai() >0 ){
            pTooltip.add(Component.translatable("爆伤",gongfaSample.getBaojishanghai()).withStyle(ChatFormatting.YELLOW));
        }

        if(gongfaSample.getBaojilv() >0 ){
            pTooltip.add(Component.translatable("爆率",gongfaSample.getBaojilv()).withStyle(ChatFormatting.YELLOW));
        }

        if(gongfaSample.getMingzhong() >0 ){
            pTooltip.add(Component.translatable("命中",gongfaSample.getMingzhong()).withStyle(ChatFormatting.YELLOW));
        }


        if(gongfaSample.getShouyuan() >0 ){
            pTooltip.add(Component.translatable("寿元",gongfaSample.getShouyuan()).withStyle(ChatFormatting.YELLOW));
        }


        if(gongfaSample.getMaxlingli() >0 ){
            pTooltip.add(Component.translatable("最大灵力",gongfaSample.getMaxlingli()).withStyle(ChatFormatting.YELLOW));
        }

        if(gongfaSample.getDunsu() >0 ){
            pTooltip.add(Component.translatable("遁速",gongfaSample.getDunsu()).withStyle(ChatFormatting.YELLOW));
        }

        if(gongfaSample.getXixue() >0 ){
            pTooltip.add(Component.translatable("吸血",gongfaSample.getXixue()).withStyle(ChatFormatting.YELLOW));
        }


        Holder<LingxiuJingjieSample> prent = gongfaSample.getPrent();
        if(prent != null){
            pTooltip.add(Component.translatable("效果：修为突破").append(Component.translatable(pLevel.registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(prent.get()).toString())).append("境").withStyle(ChatFormatting.GOLD));

        }
    }
}
