package huase.xiuxianzhilu.items.functions;

import huase.xiuxianzhilu.items.Iteminit;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

import javax.annotation.Nullable;
import java.util.List;

/**
 * - @description:ToolItem类
 */
public class LingSwordItem extends SwordItem {
    int LV;
    public LingSwordItem(int lv) {
        super(getForgeTier(lv),3+5*lv, -2.4f+lv*0.5f, new Properties());
        this.LV = lv;
    }

    private static Tier getForgeTier(int lv) {
        switch (lv){
            case 0:return new ForgeTier(3,1200,8    ,6  ,10, Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Iteminit.linghe0.get()));
            case 1:return new ForgeTier(4,2000,20   ,12 ,15, Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Iteminit.linghe1.get()));
            case 2:return new ForgeTier(5,3000,40   ,24 ,20, Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Iteminit.linghe2.get()));
            case 3:return new ForgeTier(6,4000,60   ,48 ,25, Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Iteminit.linghe3.get()));

            default:
                return new ForgeTier(4,1561,8,1,10, Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Items.NETHERITE_INGOT));
        }
    }


    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return net.minecraftforge.common.ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }

    public float handLinglixiaohao(float linglixiaohao) {
//        return (float) (linglixiaohao*Math.pow(0.8f,LV+1));
        return linglixiaohao*getLinglixiaohaoCoefficient();
    }

    private float getLinglixiaohaoCoefficient() {
        return (float) Math.pow(0.8f, LV + 1);
    }


    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("除本拥有更强大的属性，还能减少使用者的灵力消耗").withStyle(ChatFormatting.GREEN));
        pTooltip.add(Component.translatable("玩家受伤与攻击都需要消耗灵力来获得属性的增幅").withStyle(ChatFormatting.DARK_GRAY));

        int pow = (int) (getLinglixiaohaoCoefficient()*100);
        pTooltip.add(Component.translatable("消耗削减:").append(Component.translatable(pow+"%").withStyle(ChatFormatting.YELLOW)));
    }
}
