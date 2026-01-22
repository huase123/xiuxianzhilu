package huase.xiuxianzhilu.items.danyao;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

/**
 * - @description:CailiaoSampleItem类
 */
public class DanyaoSampleItem extends Item {
    public DanyaoSampleItem() {
        super(new Properties());
    }

    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);

//        pTooltip.add(Component.translatable("---炼器材料").withStyle(ChatFormatting.GREEN));
    }
}
