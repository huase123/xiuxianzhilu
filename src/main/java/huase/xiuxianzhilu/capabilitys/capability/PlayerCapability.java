package huase.xiuxianzhilu.capabilitys.capability;

import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.Lingxiu;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.tis.Tixiu;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.List;


/**
 * - @description:PlayerCapability类
 * - @author: huase。
 * - @date: 2025/10/12 3:37
 */
public class PlayerCapability extends AttributeBase implements hua.huase.shanhaicontinent.capabilitys.capability.Update {
    List<Linggen> linggens = new ArrayList<>();
    List<Lingxiu> lingxius = new ArrayList<>();
    List<Tixiu> tixius = new ArrayList<>();

    ItemStackHandler boneslot = new ItemStackHandler(7);
    private boolean isupdate =true;

    private DensityFunction densityFunction ;

    public boolean isIsupdate() {
        return isupdate;
    }

    public void setIsupdate(boolean isupdate) {
        this.isupdate = isupdate;
    }

    public PlayerCapability(Player player) {
        densityFunction = new DensityFunction(this,player);
    }



    @Override
    public CompoundTag serializeNBT() {

        CompoundTag nbt = super.serializeNBT();
        nbt.putBoolean("isupdate",isupdate);
        nbt.put("boneslot", boneslot.serializeNBT());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        isupdate = nbt.getBoolean("isupdate");
        if(nbt.get("boneslot")!=null){
            this.boneslot.deserializeNBT((CompoundTag) nbt.get("boneslot"));
        }
    }

    public DensityFunction getDensityFunction() {
        return densityFunction;
    }

    public void setDensityFunction(DensityFunction densityFunction) {
        this.densityFunction = densityFunction;
    }
}
