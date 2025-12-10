package huase.xiuxianzhilu.capabilitys.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public class
AttributeBase implements INBTSerializable<CompoundTag> {
    public float maxshengming;
    public float wugong;
    public float wufang;
    public float baojishanghai;
    public float baojilv;

    public AttributeBase(){
        this.maxshengming = 20;
        this.wugong = 1;
        this.wufang = 1;
        this.baojishanghai = 1;
        this.baojilv = 1;
    }

    public AttributeBase(float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv) {
        this.maxshengming = maxshengming;
        this.wugong = wugong;
        this.wufang = wufang;
        this.baojishanghai = baojishanghai;
        this.baojilv = baojilv;
    }

    @Override
    public CompoundTag serializeNBT() {

        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putFloat("wugong",wugong);
        compoundTag.putFloat("baojishanghai",baojishanghai);
        compoundTag.putFloat("baojilv",baojilv);
        compoundTag.putFloat("wufang",wufang);
        compoundTag.putFloat("maxshengming",maxshengming);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        if(compoundTag == null)return;
        this.wugong=compoundTag.getFloat("wugong");
        this.baojishanghai=compoundTag.getFloat("baojishanghai");
        this.baojilv=compoundTag.getFloat("baojilv");
        this.wufang=compoundTag.getFloat("wufang");
        this.maxshengming=compoundTag.getFloat("maxshengming");

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
