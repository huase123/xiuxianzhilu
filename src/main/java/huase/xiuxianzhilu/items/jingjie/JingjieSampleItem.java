package huase.xiuxianzhilu.items.jingjie;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

/**
 * - @description:GongfaSampleItem类
 */
public class JingjieSampleItem extends Item {
    public JingjieSampleItem() {
        super(new Properties());
    }
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
//        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
//        if (!pLevel.isClientSide) {
//
//            CapabilityUtil.addGongfa(pPlayer,itemstack);
//
//        }
//
//        pPlayer.awardStat(Stats.ITEM_USED.get(this));
//        if (!pPlayer.getAbilities().instabuild) {
//            itemstack.shrink(1);
//        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }


    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}
