package huase.xiuxianzhilu.blocks.functions.jvlingzhen;

import huase.xiuxianzhilu.datagens.tag.ItemTagsProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
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
import org.jetbrains.annotations.Nullable;

/**
 * - @description:ZhenjiBlock类
 */
public class JvlingzhenBlock extends BaseEntityBlock {
    public JvlingzhenBlock(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {

        return new JvlingzhenBlockEntity(pPos, pState);
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(!entity.isRemoved()) {
                ItemStack itemInHand = pPlayer.getItemInHand(pHand);
                if(itemInHand.is(ItemTagsProvider.islingshi)){
                    handleLingshi(itemInHand,pPlayer,entity);
                }else {
                    pPlayer.sendSystemMessage(Component.translatable("需要灵石激活").withStyle(ChatFormatting.DARK_GRAY));
                }

            } else {
                throw new IllegalStateException("pot is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }



    public void handleLingshi(ItemStack itemstack, Player pPlayer, BlockEntity entity) {
        if(isSuccess(entity)){
            createZhenfa(itemstack,pPlayer,entity);
        }else {
            BlockPos blockPos = entity.getBlockPos();
            ItemEntity itementity = new ItemEntity(entity.getLevel(), blockPos.getX(), blockPos.getY() + (double)0.8, blockPos.getZ(), itemstack.copyWithCount(1));
            itementity.setDefaultPickUpDelay();
            entity.getLevel().addFreshEntity(itementity);
            if (!pPlayer.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            pPlayer.sendSystemMessage(Component.translatable("需正确布置阵法").withStyle(ChatFormatting.DARK_GRAY));
            pPlayer.sendSystemMessage(Component.translatable("?sss?\n"+
                    "saaas\n"+
                    "sa?as\n"+
                    "saaas\n"+
                    "?sss?\n"+
                    "-------------------------------------"+
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


    private void createZhenfa(ItemStack itemstack, Player pPlayer, BlockEntity entity) {
        JvlingzhenEntity jvlingzhenEntity = new JvlingzhenEntity(entity.getLevel(),entity);
        jvlingzhenEntity.setPos(entity.getBlockPos().getCenter());
        entity.getLevel().addFreshEntity(jvlingzhenEntity);
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }
        BlockPos offset = entity.getBlockPos().offset(-2, 0, -2);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                BlockPos offset1 = offset.offset(i, 0, j);
                if(!entity.getLevel().getBlockState(offset1).is(entity.getBlockState().getBlock())){
                    entity.getLevel().setBlock(offset1, Blocks.AIR.defaultBlockState(),2);
                }
            }
        }

        entity.getLevel().playSeededSound(pPlayer,offset.getX(), offset.getY(), offset.getZ(), SoundEvents.GHAST_WARN, SoundSource.RECORDS, 1.0F, 1.0F, 1L);
    }


    @javax.annotation.Nullable
    private static BlockPattern witherPatternFull;
    private static BlockPattern getOrCreateWitherFull() {
        if (witherPatternFull == null) {
            witherPatternFull =
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
        return witherPatternFull;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return super.getTicker(pLevel, pState, pBlockEntityType);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> GameEventListener getListener(ServerLevel pLevel, T pBlockEntity) {
        return super.getListener(pLevel, pBlockEntity);
    }
}
