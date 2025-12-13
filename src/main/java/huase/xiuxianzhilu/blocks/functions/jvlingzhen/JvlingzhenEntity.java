package huase.xiuxianzhilu.blocks.functions.jvlingzhen;

import huase.xiuxianzhilu.blocks.BlockCreateEntityInit;
import huase.xiuxianzhilu.capabilitys.RegisterCapabilitys;
import huase.xiuxianzhilu.screen.linggen.LinggenMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkHooks;

/**
 * - @description:ZhenfaEntity类
 */
public class JvlingzhenEntity extends Entity implements HasCustomInventoryScreen {


    private static final EntityDataAccessor<BlockPos> blockPosEntityDataAccessor =
            SynchedEntityData.defineId(JvlingzhenEntity.class, EntityDataSerializers.BLOCK_POS);
    public JvlingzhenEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public JvlingzhenEntity(Level level, BlockEntity zhenjiBlockEntity) {
        this(BlockCreateEntityInit.jvlingzhenentity.get(),level);
        this.entityData.set(blockPosEntityDataAccessor,zhenjiBlockEntity.getBlockPos());
    }
    private BlockEntity selfBlockEntity;

    @Override
    public void tick() {
        super.tick();

        if(!this.level().isClientSide){
            if(getSelfBlockEntity() == null || getSelfBlockEntity().isRemoved()){
                this.discard();
            }
        }
    }

    private BlockEntity getSelfBlockEntity() {
        if(selfBlockEntity == null){
            selfBlockEntity  = this.level().getBlockEntity(this.entityData.get(blockPosEntityDataAccessor));
        }
        return selfBlockEntity;
    }

    @Override
    public boolean isPickable() {
        return true;
    }
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (player.isSecondaryUseActive()) {
            return InteractionResult.SUCCESS;
        } else{
            if (!this.level().isClientSide) {
                if(player.startRiding(this)){
//                    this.player = player;
//                    existenceTime = 0;
                    return InteractionResult.CONSUME;
                }else {
                    return InteractionResult.PASS;
                }
            } else {
                return InteractionResult.SUCCESS;
            }
        }
    }

    @Override
    public void openCustomInventoryScreen(Player pPlayer) {
        if (!this.level().isClientSide) {
            pPlayer.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).ifPresent(playerCapability -> {
               if(playerCapability.getLinggens().isEmpty()){
                   NetworkHooks.openScreen((ServerPlayer) pPlayer,
                           new SimpleMenuProvider((containerId, playerInventory, player) -> new LinggenMenu(containerId, playerInventory,this),
                                   Component.translatable("menu.title.linggen")),
                           buf -> buf.writeInt(this.getId())
                   );
               }
            });
        }
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(blockPosEntityDataAccessor, BlockPos.ZERO);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        BlockPos blockPos = new BlockPos(pCompound.getInt("blockposx"),
                pCompound.getInt("blockposy"),
                pCompound.getInt("blockposz")
        );
        this.entityData.set(blockPosEntityDataAccessor, blockPos);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        BlockPos blockPos = this.entityData.get(blockPosEntityDataAccessor);

        pCompound.putInt("blockposx", blockPos.getX());
        pCompound.putInt("blockposy", blockPos.getY());
        pCompound.putInt("blockposz", blockPos.getZ());
    }

}
