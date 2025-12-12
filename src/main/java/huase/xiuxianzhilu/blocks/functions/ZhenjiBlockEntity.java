package huase.xiuxianzhilu.blocks.functions;

import huase.xiuxianzhilu.blocks.BlockEntitiesinit;
import huase.xiuxianzhilu.entity.functions.ZhenfaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import org.jetbrains.annotations.Nullable;

/**
 * - @description:ZhenjiBlockEntity类
 */
public class ZhenjiBlockEntity extends BlockEntity implements MenuProvider {
    public ZhenjiBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntitiesinit.zhenjiblockentity.get(),pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return null;
    }

    public void handleLingshi(ItemStack itemstack, Player pPlayer) {
        if(isSuccess()){
            createZhenfa(itemstack,pPlayer);
        }else {
            ItemStack itemStack = new ItemStack(itemstack.getItem());
            BlockPos blockPos = this.getBlockPos();
            ItemEntity itementity = new ItemEntity(this.level, blockPos.getX(), blockPos.getY() + (double)0.8, blockPos.getZ(), itemStack);
            itementity.setDefaultPickUpDelay();
            this.level.addFreshEntity(itementity);
            itemstack.shrink(1);
        }
    }

    private boolean isSuccess() {
        BlockPos blockPos = this.getBlockPos();
        return getOrCreateWitherFull().find(level, blockPos)!= null;
    }


    private void createZhenfa(ItemStack itemstack, Player pPlayer) {
        ZhenfaEntity zhenfaEntity = new ZhenfaEntity(this.level,this);
        zhenfaEntity.setPos(this.getBlockPos().getCenter());
        this.level.addFreshEntity(zhenfaEntity);
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }
        BlockPos offset = this.getBlockPos().offset(-2, 0, -2);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                BlockPos offset1 = offset.offset(i, 0, j);
                if(!this.level.getBlockState(offset1).is(this.getBlockState().getBlock())){
                    this.level.setBlock(offset1,Blocks.AIR.defaultBlockState(),2);
                }
            }
        }

        this.level.playSeededSound(pPlayer,offset.getX(), offset.getY(), offset.getZ(), SoundEvents.END_PORTAL_SPAWN, SoundSource.HOSTILE, 1.0F, 1.0F, 1L);
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
}
