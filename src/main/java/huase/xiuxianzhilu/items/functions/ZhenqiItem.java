package huase.xiuxianzhilu.items.functions;

import huase.xiuxianzhilu.blocks.functions.LinkEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

/**
 * - @description:ExampleItem类
 */
public class ZhenqiItem extends Item implements Interactionzhenfa{

    public ZhenqiItem() {
        super(new Item.Properties().stacksTo(1));
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand pUsedHand) {
        ItemStack itemstack = player.getItemInHand(pUsedHand);

        if(!player.level().isClientSide) {
            if (player.isSecondaryUseActive()) {
                setBlockEntity(player,itemstack,null);
            }else {
                return InteractionResultHolder.pass(itemstack);
            }
        }


        return InteractionResultHolder.consume(itemstack);
    }


    @Override
    public void interactionzhenfa(ItemStack itemstack, BlockEntity entity, Player player) {
        if(player.level().isClientSide)return;

        BlockEntity blockEntity = getBlockEntity(player, itemstack);
        if(blockEntity == null){
            setBlockEntity(player,itemstack,entity);
        }else {
            if(blockEntity instanceof LinkEntity linkEntity){
                linkEntity.interaction(entity,player);
            }
            if(entity instanceof LinkEntity linkEntity){
                linkEntity.interaction(blockEntity, player);
            }
        }


    }

    public void setBlockEntity(Player player, ItemStack itemStack, BlockEntity blockEntity) {
        CompoundTag orCreateTag = itemStack.getOrCreateTag();
        if (blockEntity != null) {
            BlockPos blockPos = blockEntity.getBlockPos();
            orCreateTag.putIntArray("blockpos",new int[]{blockPos.getX(),blockPos.getY(),blockPos.getZ()});
        }else {
            orCreateTag.remove("blockpos");
        }

    }

    public BlockEntity getBlockEntity(Player player, ItemStack itemStack) {
        CompoundTag orCreateTag = itemStack.getOrCreateTag();
        int[] intArray = orCreateTag.getIntArray("blockpos");
        if(intArray.length != 3){
            return null;
        }else {
            return player.level().getBlockEntity(new BlockPos(intArray[0],intArray[1],intArray[2]));
        }
    }
}
