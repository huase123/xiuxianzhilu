package huase.xiuxianzhilu.blocks.functions.jvlingzhen;

import huase.xiuxianzhilu.blocks.BlockEntitiesinit;
import huase.xiuxianzhilu.event.server.MultiBlockRecipeManager;
import huase.xiuxianzhilu.items.functions.Interactionzhenfa;
import huase.xiuxianzhilu.recipe.MultiBlockRecipeType;
import huase.xiuxianzhilu.recipe.multiblock.MultiBlockRecipe;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * - @description:ZhenjiBlock类
 */
public class JvlingzhenBlock extends BaseEntityBlock {

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    private static final VoxelShape INSIDE = box(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    protected static final VoxelShape SHAPE = Shapes.join(Shapes.block(), Shapes.or(box(0.0D, 0.0D, 4.0D, 16.0D, 3.0D, 12.0D), box(4.0D, 0.0D, 0.0D, 12.0D, 3.0D, 16.0D), box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D), INSIDE), BooleanOp.ONLY_FIRST);

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
    public VoxelShape getInteractionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return INSIDE;
    }


    private int lv = 0;

    public int getLv() {
        return lv;
    }

    public JvlingzhenBlock(int lv) {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
        this.lv = lv;
    }



    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(!entity.isRemoved()) {
                ItemStack itemInHand = pPlayer.getItemInHand(pHand);
                handleClick(itemInHand,pPlayer,entity);
            } else {
                throw new IllegalStateException("pot is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }



    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
//            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
//            if (blockentity instanceof LianqidingBlockEntity lianqidingBlockEntity) {
//                ItemStackHandler itemHandler = lianqidingBlockEntity.getItemHandler();
//                for (int i = 0; i < itemHandler.getSlots(); i++) {
//                    ItemStack stackInSlot = itemHandler.getStackInSlot(i);
//                    Containers.dropItemStack(pLevel, pPos.getX(),pPos.getY(),pPos.getZ(),stackInSlot);
//                }
//                pLevel.updateNeighbourForOutputSignal(pPos, this);
//            }
            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }
    }


    public void handleClick(ItemStack itemstack, Player pPlayer, BlockEntity entity) {
        if(isSuccess(entity)){
            if(!itemstack.isEmpty() && itemstack.getItem() instanceof Interactionzhenfa interactionzhenfa){

                interactionzhenfa.interactionzhenfa(itemstack,entity,pPlayer);
            }else {
//                pPlayer.sendSystemMessage(Component.translatable("觉醒灵根").withStyle(ChatFormatting.RED));
                if(entity instanceof JvlingzhenBlockEntity jvlingzhenBlockEntity){
                    jvlingzhenBlockEntity.handleClick(itemstack,pPlayer,jvlingzhenBlockEntity);
                }

            }
        }else {
            pPlayer.sendSystemMessage(Component.translatable("需正确布置结构").withStyle(ChatFormatting.RED));
        }
    }
    private Optional<MultiBlockRecipe> multiBlockRecipeFor;
    private boolean isSuccess(BlockEntity entity) {
        Optional<MultiBlockRecipe> multiBlockRecipe = getmultiBlockRecipeFor(entity);
        if(multiBlockRecipe.isPresent()){
            return multiBlockRecipe.get().matches(entity.getLevel(), entity.getBlockPos());
        }

        return true;
    }

    private Optional<MultiBlockRecipe> getmultiBlockRecipeFor(BlockEntity entity) {
        if(multiBlockRecipeFor == null){
            multiBlockRecipeFor = MultiBlockRecipeManager.INSTANCE.getMultiBlockRecipeFor(MultiBlockRecipeType.multiblockrecipe, entity);
        }
        return multiBlockRecipeFor;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {

        return new JvlingzhenBlockEntity(pPos, pState,lv);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
//        if(pLevel.isClientSide()) {
//            return null;
//        }

//        return createTickerHelper(pBlockEntityType,  BlockEntitiesinit.lianqidingblockentity.get(), LianqidingBlockEntity::tick);
        return createTickerHelper(pBlockEntityType, BlockEntitiesinit.jvlingzhenblockentity.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }

    @Nullable
    @Override
    public <T extends BlockEntity> GameEventListener getListener(ServerLevel pLevel, T pBlockEntity) {
        return super.getListener(pLevel, pBlockEntity);
    }
}
