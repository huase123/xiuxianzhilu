package huase.xiuxianzhilu.capabilitys.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public class
AttributeBase implements INBTSerializable<CompoundTag> {
    private float maxshengming;
    private float wugong;
    private float wufang;
    private float baojishanghai;
    private float baojilv;
    public AttributeBase(){
        this.maxshengming = 20;
        this.wugong = 1;
        this.wufang = 1;
        this.baojishanghai = 1;
        this.baojilv = 1;
    }

    @Override
    public CompoundTag serializeNBT() {

        CompoundTag nbt = new CompoundTag();
        nbt.putFloat("wugong",wugong);
        nbt.putFloat("baojishanghai",baojishanghai);
        nbt.putFloat("baojilv",baojilv);
        nbt.putFloat("wufang",wufang);
        nbt.putFloat("maxshengming",maxshengming);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        if(nbt == null)return;
        this.wugong=nbt.getFloat("wugong");
        this.baojishanghai=nbt.getFloat("baojishanghai");
        this.baojilv=nbt.getFloat("baojilv");
        this.wufang=nbt.getFloat("wufang");
        this.maxshengming=nbt.getFloat("maxshengming");

    }

    public float getMaxshengming() {
        return maxshengming;
    }

    public void setMaxshengming(float maxshengming) {
        this.maxshengming = maxshengming;
    }

    public float getWugong() {
        return wugong;
    }

    public void setWugong(float wugong) {
        this.wugong = wugong;
    }

    public float getWufang() {
        return wufang;
    }

    public void setWufang(float wufang) {
        this.wufang = wufang;
    }

    public float getBaojishanghai() {
        return baojishanghai;
    }

    public void setBaojishanghai(float baojishanghai) {
        this.baojishanghai = baojishanghai;
    }

    public float getBaojilv() {
        return baojilv;
    }

    public void setBaojilv(float baojilv) {
        this.baojilv = baojilv;
    }
}
