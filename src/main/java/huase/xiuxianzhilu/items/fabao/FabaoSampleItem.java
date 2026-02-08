package huase.xiuxianzhilu.items.fabao;

import huase.xiuxianzhilu.capabilitys.capability.fabao.FabaoGen;
import huase.xiuxianzhilu.capabilitys.capability.fabao.Fabaoabstract;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen.lingxiu_jingjie_key;

/**
 * - @description:GongfaSampleItem类
 */
public class FabaoSampleItem extends Item {
    public FabaoSampleItem() {
        super(new Properties().stacksTo(1));
    }

    public float getMaxshengming(Level level, ItemStack pStack) {
        Fabaoabstract fabaoabstract = getFabaoabstract(level, pStack);
        return fabaoabstract.getMaxshengming();
    }

    public float getWugong(Level level, ItemStack pStack) {
        Fabaoabstract fabaoabstract = getFabaoabstract(level, pStack);
        return fabaoabstract.getWugong();
    }

    public float getWufang(Level level, ItemStack pStack) {
        Fabaoabstract fabaoabstract = getFabaoabstract(level, pStack);
        return fabaoabstract.getWufang();
    }

    public float getBaojishanghai(Level level, ItemStack pStack) {
        Fabaoabstract fabaoabstract = getFabaoabstract(level, pStack);
        return fabaoabstract.getBaojishanghai();
    }

    public float getBaojilv(Level level, ItemStack pStack) {
        Fabaoabstract fabaoabstract = getFabaoabstract(level, pStack);
        return fabaoabstract.getBaojilv();
    }

    public float getMaxlingli(Level level, ItemStack pStack) {
        Fabaoabstract fabaoabstract = getFabaoabstract(level, pStack);
        return fabaoabstract.getMaxlingli();
    }

    public float getMingzhong(Level level, ItemStack pStack) {
        Fabaoabstract fabaoabstract = getFabaoabstract(level, pStack);
        return fabaoabstract.getMingzhong();
    }

    public float getDunsu(Level level, ItemStack pStack) {
        Fabaoabstract fabaoabstract = getFabaoabstract(level, pStack);
        return fabaoabstract.getDunsu();
    }

    public float getShouyuan(Level level, ItemStack pStack) {
        Fabaoabstract fabaoabstract = getFabaoabstract(level, pStack);
        return fabaoabstract.getShouyuan();
    }

    public float getXixue(Level level, ItemStack pStack) {
        Fabaoabstract fabaoabstract = getFabaoabstract(level, pStack);
        return fabaoabstract.getXixue();
    }

    Fabaoabstract sample;
    public Fabaoabstract getFabaoabstract(Level level, ItemStack pStack) {
        if(sample == null){
             sample = level.registryAccess().registryOrThrow(FabaoGen.fabao_key).stream().filter(
                    c -> pStack.is(c.getItem())
            ).findAny().get();
        }
        return sample;
    }

    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);

        if(pLevel == null)return;


        Fabaoabstract sample = getFabaoabstract(pLevel, pStack);
        Holder<LingxiuJingjieSample> child = sample.getJingjie();

        if(child != null){
            ResourceLocation key = pLevel.registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(child.get());
            if(key !=null){
                pTooltip.add(Component.translatable("穿戴所需境界:").append(Component.translatable(key.toString())).withStyle(ChatFormatting.AQUA));
            }
        }

        pTooltip.add(Component.translatable("-----基础属性-----").withStyle(ChatFormatting.WHITE));

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
