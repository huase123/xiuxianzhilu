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
    //最大灵力值
    public float maxlingli;
    //命中
    public float mingzhong;
    // 遁速
    public float dunsu;
    //寿元
    public float shouyuan;
    //吸血
    public float xixue;

    public AttributeBase(){
        this.maxshengming = 20;
        this.wugong = 0;
        this.wufang = 0;
        this.baojishanghai = 0;
        this.baojilv = 0;
    }

    public AttributeBase(float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv) {
        this.maxshengming = maxshengming;
        this.wugong = wugong;
        this.wufang = wufang;
        this.baojishanghai = baojishanghai;
        this.baojilv = baojilv;
    }


    public AttributeBase(float maxshengming, float wugong, float wufang, float baojishanghai,float baojilv, float maxlingli, float mingzhong, float dunsu, float shouyuan, float xixue) {
        this.maxshengming = maxshengming;
        this.wugong = wugong;
        this.wufang = wufang;
        this.baojishanghai = baojishanghai;
        this.baojilv = baojilv;
        this.maxlingli = maxlingli;
        this.mingzhong = mingzhong;
        this.dunsu = dunsu;
        this.shouyuan = shouyuan;
        this.xixue = xixue;
    }

    @Override
    public CompoundTag serializeNBT() {

        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putFloat("wugong",wugong);
        compoundTag.putFloat("baojishanghai",baojishanghai);
        compoundTag.putFloat("baojilv",baojilv);
        compoundTag.putFloat("wufang",wufang);
        compoundTag.putFloat("maxshengming",maxshengming);

        compoundTag.putFloat("mingzhong",mingzhong);
        compoundTag.putFloat("shouyuan",shouyuan);
        compoundTag.putFloat("maxlingli",maxlingli);
        compoundTag.putFloat("dunsu",dunsu);
        compoundTag.putFloat("xixue",xixue);
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

        this.mingzhong=compoundTag.getFloat("mingzhong");
        this.shouyuan=compoundTag.getFloat("shouyuan");
        this.maxlingli=compoundTag.getFloat("maxlingli");
        this.dunsu=compoundTag.getFloat("dunsu");
        this.xixue=compoundTag.getFloat("xixue");

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

    public float getMingzhong() {
        return mingzhong;
    }

    public void setMingzhong(float mingzhong) {
        this.mingzhong = mingzhong;
    }

    public float getShouyuan() {
        return shouyuan;
    }

    public void setShouyuan(float shouyuan) {
        this.shouyuan = shouyuan;
    }

    public float getMaxlingli() {
        return maxlingli;
    }

    public void setMaxlingli(float maxlingli) {
        this.maxlingli = maxlingli;
    }

    public float getDunsu() {
        return dunsu;
    }

    public void setDunsu(float dunsu) {
        this.dunsu = dunsu;
    }

    public float getXixue() {
        return xixue;
    }

    public void setXixue(float xixue) {
        this.xixue = xixue;
    }
}
