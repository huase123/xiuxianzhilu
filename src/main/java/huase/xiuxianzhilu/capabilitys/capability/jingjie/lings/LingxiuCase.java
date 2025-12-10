package huase.xiuxianzhilu.capabilitys.capability.jingjie.lings;

import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieFactorys;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

/**
 * - @description:LingxiuCase类
 */
public class LingxiuCase extends AttributeBase {
    private LingxiuJingjie lingxiuJingjie;
    float lingli;
    float maxlingli;
    float jingyan;
    float maxjingyan;
    int dengji;
    int maxDengji;

    public LingxiuCase(LingxiuJingjie lingxiuJingjie) {
        super(lingxiuJingjie.maxshengming, lingxiuJingjie.wugong, lingxiuJingjie.wufang, lingxiuJingjie.baojishanghai, lingxiuJingjie.baojilv);
        this.lingxiuJingjie = lingxiuJingjie;
        this.maxlingli = lingxiuJingjie.maxlingli;
        this.maxjingyan = lingxiuJingjie.maxjingyan;
        this.maxDengji = lingxiuJingjie.maxDengji;
    }

    public LingxiuCase(CompoundTag compoundTag) {
        deserializeNBT(compoundTag);
    }

    public LingxiuJingjie getLingxiuJingjie() {
        return lingxiuJingjie;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = super.serializeNBT();
        ResourceLocation key = LingxiujingjieFactorys.LingxiuJingjie_Supplier_REGISTRY.get().getKey(lingxiuJingjie);
        compoundTag.putString("lingxiuJingjie",key.toString());
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        super.deserializeNBT(compoundTag);
        String string = compoundTag.getString("lingxiuJingjie");
        LingxiujingjieFactorys.LingxiuJingjie_Supplier_REGISTRY.get().getValue(new ResourceLocation(string));
    }

    public int getIntensity() {

        return lingxiuJingjie.getIntensity();
    }

}
