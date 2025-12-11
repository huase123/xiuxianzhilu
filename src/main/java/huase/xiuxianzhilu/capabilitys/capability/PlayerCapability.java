package huase.xiuxianzhilu.capabilitys.capability;

import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuCase;
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
    private List<LingxiuCase> lingxius = new ArrayList<>();
    private List<Tixiu> tixius = new ArrayList<>();
    private List<Linggen> linggens = new ArrayList<>();

    ItemStackHandler boneslot = new ItemStackHandler(7);
    private boolean isupdate =true;

    private DensityFunction densityFunction ;
    private Player player ;

    public boolean isIsupdate() {
        return isupdate;
    }

    public void setIsupdate(boolean isupdate) {
        this.isupdate = isupdate;
    }

    public PlayerCapability(Player player) {
        this.player = player;
        if(!linggens.isEmpty());
        densityFunction = new DensityFunction(this, player);
    }



    @Override
    public CompoundTag serializeNBT() {

        CompoundTag compoundTag = super.serializeNBT();
        compoundTag.putBoolean("isupdate",isupdate);
        compoundTag.put("boneslot", boneslot.serializeNBT());

        compoundTag.putInt("lingxiusize",lingxius.size());
        for (int i = 0; i < lingxius.size(); i++) {
            compoundTag.put("lingxiu"+i,lingxius.get(i).serializeNBT());
        }

        compoundTag.putInt("linggensize",linggens.size());
        for (int i = 0; i < linggens.size(); i++) {
            compoundTag.putString("linggen"+i,linggens.get(i).name());
        }


        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        super.deserializeNBT(compoundTag);
        isupdate = compoundTag.getBoolean("isupdate");
        if(compoundTag.get("boneslot")!=null){
            this.boneslot.deserializeNBT((CompoundTag) compoundTag.get("boneslot"));
        }
        lingxius.clear();
        int lingxiusize = compoundTag.getInt("lingxiusize");
        for (int i = 0; i < lingxiusize; i++) {
            CompoundTag tag = (CompoundTag) compoundTag.get("lingxiu" + i);
            lingxius.add(new LingxiuCase(player,tag));
        }
        linggens.clear();
        int linggensize = compoundTag.getInt("linggensize");
        for (int i = 0; i < linggensize; i++) {
            Linggen linggen = Linggen.valueOf(compoundTag.getString("linggen" + i));
            linggens.add(linggen);
        }
    }

    public DensityFunction getDensityFunction() {
        return densityFunction;
    }

    public List<Linggen> getLinggens() {
        return linggens;
    }

    public void setLinggens(List<Linggen> linggens) {
        this.linggens = linggens;
    }

    public List<LingxiuCase> getLingxius() {
        return lingxius;
    }

    public void setDensityFunction(DensityFunction densityFunction) {
        this.densityFunction = densityFunction;
    }

    public void createDensityFunction( Player player) {
        densityFunction = new DensityFunction(this, player);
    }
}
