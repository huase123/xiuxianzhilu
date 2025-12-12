package huase.xiuxianzhilu.capabilitys.capability.gongfa;

import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import static huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen.gongfa_key;

/**
 * - @description:GongfaCase类
 */
public class GongfaCase extends AttributeBase {
    GongfaSample gongfaSample;
    Player player;
    public GongfaCase(Player player, CompoundTag compoundTag) {
        this.player = player;
        deserializeNBT(compoundTag);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = super.serializeNBT();
        ResourceLocation key = player.level().registryAccess().registryOrThrow(gongfa_key).getKey(gongfaSample);
        if(key !=null){
            compoundTag.putString("gongfaSample",key.toString());
        }
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        super.deserializeNBT(compoundTag);
        String string = compoundTag.getString("gongfaSample");
        gongfaSample = player.level().registryAccess().registryOrThrow(gongfa_key).get(ResourceLocation.parse(string));
    }

    public int getIntensity() {

        return gongfaSample.getIntensity();
    }
}
