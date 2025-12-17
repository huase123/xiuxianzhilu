package huase.xiuxianzhilu.items.functions;

import huase.xiuxianzhilu.blocks.functions.jvlingzhen.JvlingzhenEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.UUID;

/**
 * - @description:ExampleItem类
 */
public class ZhenqiItem extends Item implements Interactionzhenfa{

    public ZhenqiItem() {
        super(new Properties());
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand pUsedHand) {
        ItemStack itemstack = player.getItemInHand(pUsedHand);
        if(!player.level().isClientSide) {
            setEntity(player,itemstack,null);
        }


        return InteractionResultHolder.consume(itemstack);
    }


    public void interactionzhenfa(ItemStack itemInHand, JvlingzhenEntity jvlingzhenEntity, Player player) {
        if(player.level().isClientSide)return;

        Entity entity =getEntity(player, itemInHand);
        if(entity == null){
            setEntity(player,itemInHand,jvlingzhenEntity);
        }else {
            if(!entity.is(jvlingzhenEntity)&&entity.isAlive()){
                jvlingzhenEntity.interactZhenfa(itemInHand,entity,player);
            }
        }

    }

    @Override
    public void interactionzhenfa(Level pLevel, Player pPlayer, BlockEntity entity, BlockState pState, BlockPos pPos) {

    }

    public void setEntity(Player player, ItemStack itemStack, Entity entity) {
        CompoundTag orCreateTag = itemStack.getOrCreateTag();
        if (entity != null) {
            orCreateTag.putUUID("entityuuid", entity.getUUID());
        }else {
            orCreateTag.remove("entityuuid");
        }

    }

    public Entity getEntity(Player player, ItemStack itemStack) {
        CompoundTag orCreateTag = itemStack.getOrCreateTag();
        if (!orCreateTag.hasUUID("entityuuid")) {
            return null;
        }else {
            UUID uuid = orCreateTag.getUUID("entityuuid");
            return ((ServerLevel)player.level()).getEntity(uuid);
        }
    }
}
