package huase.xiuxianzhilu.blocks.functions;

import huase.xiuxianzhilu.items.functions.Interactionzhenfa;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/**
 * - @description:FunctionBaseEntityBlock类
 */
public abstract class FunctionBaseEntity extends BaseEntityBlock implements HandleClick,StructuralTesting{
    protected FunctionBaseEntity(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        BlockEntity entity = pLevel.getBlockEntity(pPos);
        if(!entity.isRemoved()) {
            ItemStack itemInHand = pPlayer.getItemInHand(pHand);
            if(itemInHand.getItem() instanceof Interactionzhenfa interactionzhenfa){
                interactionzhenfa.interactionzhenfa(pLevel,pPlayer,entity,pState,pPos);
            }else {
                if(isPass(pLevel,pPlayer,entity,pState,pPos)){
                    handleClick(pLevel,pPlayer,entity,pState,pPos);
                }else {
                    pPlayer.sendSystemMessage(Component.translatable("请搭建完整结构").withStyle(ChatFormatting.RED));
                }
            }
        } else {
            throw new IllegalStateException("pot is missing!");
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }



}
