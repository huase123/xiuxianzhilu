package huase.xiuxianzhilu.capabilitys.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.items.ItemStackHandler;

/**
 * - @description:MosterCapability类
 * - @author: huase。
 * - @date: 2025/10/12 3:33
 */
public class MosterCapability extends AttributeBase implements hua.huase.shanhaicontinent.capabilitys.capability.Update {

    int nianxian;
    ItemStackHandler hunhuan = new ItemStackHandler();
    private boolean isupdate =true;

    public MosterCapability(Entity object) {

    }

    public boolean isIsupdate() {
        return isupdate;
    }

    public void setIsupdate(boolean isupdate) {
        this.isupdate = isupdate;
    }


    public int getNianxian() {
        return nianxian;
    }

    public void setNianxian(int nianxian) {
        this.nianxian = nianxian;
    }

    public ItemStackHandler getHunhuan() {
        return hunhuan;
    }

    public void setHunhuan(ItemStackHandler hunhuan) {
        this.hunhuan = hunhuan;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("nianxian", nianxian);
        nbt.put("hunhuan", hunhuan.serializeNBT());
        nbt.putBoolean("isupdate",isupdate);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        this.nianxian = nbt.getInt("nianxian");
        isupdate = nbt.getBoolean("isupdate");
        if(nbt.get("hunhuan")!=null){
            this.hunhuan.deserializeNBT((CompoundTag) nbt.get("hunhuan"));
        }

    }

    @Override
    public float Hurt(LivingEntity directEntity, DamageSource source, float amount) {
        return super.Hurt(directEntity, source, amount);
    }
}
