package huase.xiuxianzhilu.items.functions;

import huase.xiuxianzhilu.datagens.tag.BlockTagsProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static huase.xiuxianzhilu.items.functions.ForgeTiers.getForgeTier;

/**
 * - @description:ToolItem类
 */
public class ToolItem extends DiggerItem {
    int LV;
    public ToolItem(int lv) {
        super(1, -2.8f+lv*0.4f, getForgeTier(lv), BlockTagsProvider.mineable_tool, new Item.Properties());
        this.LV = lv;
    }


    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return net.minecraftforge.common.ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction);
    }


    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("可不受工具类型限制挖掘方块").withStyle(ChatFormatting.GREEN));
    }
}
