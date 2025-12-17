package huase.xiuxianzhilu.blocks.functions.lianqiding;

import huase.xiuxianzhilu.blocks.BlockEntitiesinit;
import huase.xiuxianzhilu.screen.lianqiding.LianqidingMenu;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

/**
 * - @description:ZhenjiBlock类
 */
public class LianqidingBlock extends BaseEntityBlock {
    public LianqidingBlock(Properties pProperties) {
        super(pProperties);
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


    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
//        if (pState.getBlock() != pNewState.getBlock()) {
//            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
//            if (blockEntity instanceof PotBlockEntity) {
//                ((PotBlockEntity) blockEntity).drops();
//            }
//        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }


    public void handleClick(ItemStack itemstack, Player pPlayer, BlockEntity entity) {
        if(isSuccess(entity)){
            NetworkHooks.openScreen((ServerPlayer) pPlayer,
                    new SimpleMenuProvider((containerId, playerInventory, player) -> new LianqidingMenu(containerId, playerInventory,entity),
                            Component.translatable("menu.title.linggen")),
                    entity.getBlockPos()
            );
        }else {
            pPlayer.sendSystemMessage(Component.translatable("需正确布置结构").withStyle(ChatFormatting.RED));
            pPlayer.sendSystemMessage(Component.translatable("?sss?\n"+
                    "saaas\n"+
                    "sa?as\n"+
                    "saaas\n"+
                    "?sss?\n"+
                    "-------------------------------------\n"+
                    "?????\n"+
                    "?sss?\n"+
                    "?sss?\n"+
                    "?sss?\n"+
                    "?????\n"
                    )
                    .withStyle(ChatFormatting.GREEN));

        }
    }

    private boolean isSuccess(BlockEntity entity) {
        BlockPos blockPos = entity.getBlockPos();
        return getOrCreateWitherFull().find(entity.getLevel(), blockPos)!= null;
    }



    @javax.annotation.Nullable
    private static BlockPattern lianqidingpattern;
    private static BlockPattern getOrCreateWitherFull() {
        if (lianqidingpattern == null) {
            lianqidingpattern =
                    BlockPatternBuilder.start()
                            .aisle(
                                    "?sss?",
                                    "saaas",
                                    "sa?as",
                                    "saaas",
                                    "?sss?")
                            .aisle(
                                    "?????",
                                    "?sss?",
                                    "?sss?",
                                    "?sss?",
                                    "?????")
                            .where('?', BlockInWorld.hasState(BlockStatePredicate.ANY))
                            .where('a',  (blockInWorld) -> blockInWorld.getState().isAir())
                            .where('s',  (blockInWorld) -> blockInWorld.getState().is(Blocks.STONE))
                            .build();

        }
        return lianqidingpattern;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {

        return new LianqidingBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
//        if(pLevel.isClientSide()) {
//            return null;
//        }

//        return createTickerHelper(pBlockEntityType,  BlockEntitiesinit.lianqidingblockentity.get(), LianqidingBlockEntity::tick);
        return createTickerHelper(pBlockEntityType, BlockEntitiesinit.lianqidingblockentity.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }

    @Nullable
    @Override
    public <T extends BlockEntity> GameEventListener getListener(ServerLevel pLevel, T pBlockEntity) {
        return super.getListener(pLevel, pBlockEntity);
    }
}
