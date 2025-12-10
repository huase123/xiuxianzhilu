package huase.xiuxianzhilu.capabilitys.capability.jingjie.lings;

import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieType;

/**
 * - @description:Jingjie类
 */
public abstract class LingxiuJingjie extends AttributeBase {
    int maxDengji;
    private int intensity;
    float maxlingli;
    float maxjingyan;


    public LingxiuJingjie(int maxDengji,int intensity,float maxlingli, float maxjingyan, float getWugong, float getWufang, float getMaxshengming, float getBaojishanghai, float getBaojilv) {
        this.maxDengji = maxDengji;
        this.intensity = intensity;
        this.maxlingli = maxlingli;
        this.maxjingyan = maxjingyan;
        setWugong(getWugong);
        setWufang(getWufang);
        setMaxshengming(getMaxshengming);
        setBaojishanghai(getBaojishanghai);
        setBaojilv(getBaojilv);
    }




    public float getMaxlingli() {
        return maxlingli;
    }


    public float getMaxjingyan() {
        return maxjingyan;
    }

    public int getMaxDengji() {
        return maxDengji;
    }

    public abstract LingxiujingjieType getType();


    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}
