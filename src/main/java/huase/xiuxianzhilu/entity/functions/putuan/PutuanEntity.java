package huase.xiuxianzhilu.entity.functions.putuan;

import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.entity.EntityInit;
import huase.xiuxianzhilu.entity.Entitydataserializersint;
import huase.xiuxianzhilu.items.Iteminit;
import huase.xiuxianzhilu.screen.putuan.PutuanMenu;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.List;

public class PutuanEntity extends Entity implements HasCustomInventoryScreen {
    private static final EntityDataAccessor<PutuanEntity.State> DATA_STATE = SynchedEntityData.defineId(PutuanEntity.class, Entitydataserializersint.PutuanEntityState);
    public PutuanEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public PutuanEntity(Level level, double pX, double pY, double pZ) {
        super(EntityInit.putuanentity.get(),level);
        this.setPos(pX, pY, pZ);
    }

    /**
     * Returns the Y offset from the entity's position for any entity riding this one.
     */
    public double getPassengersRidingOffset() {
        return 0.1D;
    }


    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
//        if(!this.level().isClientSide){
            Entity firstPassenger = this.getFirstPassenger();
            if(getState().equals(State.EMPTY))return;
            if(firstPassenger == null){
                setState(State.EMPTY);
            }else {
                List<Entity> passengers = this.getPassengers();
                for (Entity passenger : passengers) {
                    if(passenger instanceof Player player){
                        getState().tick(player,passengers);
                    }
                }
            }
//        }
    }


    public void openCustomInventoryScreen(Player pPlayer) {
        if (!this.level().isClientSide) {

            NetworkHooks.openScreen((ServerPlayer) pPlayer,
                    new SimpleMenuProvider((containerId, playerInventory, player) -> new PutuanMenu(containerId, playerInventory,this),
                            Component.translatable("蒲团")),
                    buf -> buf.writeInt(this.getId()));
        }
    }

    public boolean isAttackable() {
        return true;
    }


    public boolean skipAttackInteraction(Entity entity) {
        if(entity instanceof Player){
            return false;
        }
        return true;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (!this.level().isClientSide && !this.isRemoved()) {
            if (this.isInvulnerableTo(pSource)) {
                return false;
            } else {
                this.gameEvent(GameEvent.ENTITY_DAMAGE, pSource.getEntity());
                this.ejectPassengers();
                this.destroy(pSource);

                return true;
            }
        } else {
            return true;
        }
    }

    public void destroy(DamageSource pDamageSource) {
        this.kill();
        if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            ItemStack itemstack = new ItemStack(this.getDropItem());
            if (this.hasCustomName()) {
                itemstack.setHoverName(this.getCustomName());
            }

            this.spawnAtLocation(itemstack);
        }

    }
    protected Item getDropItem() {
        return Iteminit.putuan.get();
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
                return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
            } else {
                return InteractionResult.SUCCESS;
            }
        }
    }

    public State getState() {
        return this.entityData.get(DATA_STATE);
    }
    public void setState(State state) {
         this.entityData.set(DATA_STATE,state);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_STATE,State.EMPTY);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        String string = compoundTag.getString("state");
        State state = State.valueOf(string);
        setState(state);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putString("state",getState().name());
    }

    public enum State {
        EMPTY,
        GONGFA,
        LINGMAI;

        public void tick(Player player, List<Entity> passengers) {
            switch (this){
                case EMPTY -> {
                }
                case GONGFA -> CapabilityUtil.xiuliangongfa(player,passengers);
                case LINGMAI -> CapabilityUtil.xiulianlingmai(player,passengers);
                default -> throw new IllegalStateException("Unexpected value: " + this);
            }
        }
    }
}
