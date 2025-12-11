package huase.xiuxianzhilu.entity.functions;

import huase.xiuxianzhilu.entity.EntityInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * - @description:ZhenfaEntity类
 */
public class ZhenfaEntity extends Entity implements HasCustomInventoryScreen {
    public ZhenfaEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ZhenfaEntity(Level pLevel) {
        this(EntityInit.zhenfaentity.get(),pLevel);
    }

    @Override
    public void openCustomInventoryScreen(Player pPlayer) {

    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {

    }
}
