package huase.xiuxianzhilu.blocks.functions.jvlingzhen;

import huase.xiuxianzhilu.blocks.BlockCreateEntityInit;
import huase.xiuxianzhilu.capabilitys.RegisterCapabilitys;
import huase.xiuxianzhilu.items.functions.Interactionzhenfa;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkHooks;

import java.util.Optional;
import java.util.UUID;

/**
 * - @description:ZhenfaEntity类
 */
public class JvlingzhenEntity extends Entity implements HasCustomInventoryScreen {


    private static final EntityDataAccessor<BlockPos> blockPosEntityDataAccessor =
            SynchedEntityData.defineId(JvlingzhenEntity.class, EntityDataSerializers.BLOCK_POS);

    private static final EntityDataAccessor<Optional<UUID>> prentEntityUUID =
            SynchedEntityData.defineId(JvlingzhenEntity.class, EntityDataSerializers.OPTIONAL_UUID);
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
            ItemStack itemInHand = player.getItemInHand(hand);
            if(itemInHand.getItem() instanceof Interactionzhenfa interactionzhenfa){
                interactionzhenfa.interactionzhenfa(itemInHand,this,player);
            }
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

    Entity prent;
    public void interactZhenfa(ItemStack itemInHand, Entity entity, Player player) {
        prent = entity;
        this.entityData.set(prentEntityUUID, Optional.of(entity.getUUID()));
    }


    public Entity getprentEntity() {
        if(prent == null){
            Level level = this.level();
            Optional<UUID> uuid1 = this.entityData.get(prentEntityUUID);
            if(!uuid1.isEmpty()){
                prent = level.getEntities().get(uuid1.get());
            }
        }
        return prent;
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
        this.entityData.define(prentEntityUUID, Optional.empty());
    }


    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        BlockPos blockPos = this.entityData.get(blockPosEntityDataAccessor);
        pCompound.putInt("blockposx", blockPos.getX());
        pCompound.putInt("blockposy", blockPos.getY());
        pCompound.putInt("blockposz", blockPos.getZ());

        Optional<UUID> uuid1 = this.entityData.get(prentEntityUUID);
        if(!uuid1.isEmpty()){
            pCompound.putUUID("prententityuuid",uuid1.get());
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        BlockPos blockPos = new BlockPos(pCompound.getInt("blockposx"),
                pCompound.getInt("blockposy"),
                pCompound.getInt("blockposz")
        );
        this.entityData.set(blockPosEntityDataAccessor, blockPos);
        if(pCompound.hasUUID("prententityuuid")){
            this.entityData.set(prentEntityUUID, Optional.of(pCompound.getUUID("prententityuuid")));
        }


    }

}
