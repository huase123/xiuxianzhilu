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
        GongfaSample sample = pLevel.registryAccess().registryOrThrow(gongfa_key).stream().filter(
                c -> pStack.is(c.getItem())
        ).findAny().get();

        Holder<LingxiuJingjieSample> child = sample.getChild();
        if(child != null){
            pTooltip.add(Component.translatable("所需境界:").withStyle(ChatFormatting.AQUA).append(Component.translatable(pLevel.registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(child.get()).toString())));
        }


        pTooltip.add(Component.translatable("-----基础属性-----").withStyle(ChatFormatting.WHITE));
        if(sample.getMaxdengji() >0 ){
            pTooltip.add(Component.translatable("最大层数:").append(Component.translatable(""+sample.getMaxdengji()).withStyle(ChatFormatting.YELLOW)));
        }

        if(sample.getIntensity() >0 ){
            pTooltip.add(Component.translatable("修炼速度:").append(Component.translatable("+"+sample.getIntensity()).withStyle(ChatFormatting.YELLOW)));
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


        Holder<LingxiuJingjieSample> prent = sample.getPrent();
        if(prent != null){
            pTooltip.add(Component.translatable("=====特殊效果=====").withStyle(ChatFormatting.LIGHT_PURPLE));
            pTooltip.add(Component.translatable("可突破修为：").withStyle(ChatFormatting.DARK_PURPLE).append(Component.translatable(pLevel.registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(prent.get()).toString())).append("境"));
        }
    }
}
