package huase.xiuxianzhilu.capabilitys.capability;

import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaCase;
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
    private int lingxiuindex =-1;
    private List<Tixiu> tixius = new ArrayList<>();
    private List<Linggen> linggens = new ArrayList<>();
    private List<GongfaCase> gongfas = new ArrayList<>();
    private int gongfaindex =-1;

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
//        densityFunction = new DensityFunction(this, player);
    }



    @Override
    public CompoundTag serializeNBT() {

        CompoundTag compoundTag = super.serializeNBT();
        compoundTag.putBoolean("isupdate",isupdate);
        compoundTag.put("boneslot", boneslot.serializeNBT());

        compoundTag.putBoolean("huadensityfunction",densityFunction != null);

        compoundTag.putInt("lingxiuindex",lingxiuindex);
        compoundTag.putInt("lingxiusize",lingxius.size());
        for (int i = 0; i < lingxius.size(); i++) {
            compoundTag.put("lingxiu"+i,lingxius.get(i).serializeNBT());
        }

        compoundTag.putInt("linggensize",linggens.size());
        for (int i = 0; i < linggens.size(); i++) {
            compoundTag.putString("linggen"+i,linggens.get(i).name());
        }


        compoundTag.putInt("gongfaindex",gongfaindex);
        compoundTag.putInt("gongfasize",gongfas.size());
        for (int i = 0; i < gongfas.size(); i++) {
            compoundTag.put("gongfa"+i,gongfas.get(i).serializeNBT());
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

        if(compoundTag.getBoolean("huadensityfunction"))createDensityFunction(player);

        lingxiuindex = compoundTag.getInt("lingxiuindex" );
        lingxius.clear();
        for (int i = 0; i < compoundTag.getInt("lingxiusize"); i++) {
            CompoundTag tag = (CompoundTag) compoundTag.get("lingxiu" + i);
            lingxius.add(new LingxiuCase(player,tag));
        }
        linggens.clear();
        for (int i = 0; i < compoundTag.getInt("linggensize"); i++) {
            Linggen linggen = Linggen.valueOf(compoundTag.getString("linggen" + i));
            linggens.add(linggen);
        }


        gongfaindex = compoundTag.getInt("gongfaindex" );
        gongfas.clear();
        for (int i = 0; i < compoundTag.getInt("gongfassize"); i++) {
            CompoundTag tag = (CompoundTag) compoundTag.get("gongfa" + i);
            gongfas.add(new GongfaCase(player,tag));
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
    public LingxiuCase getLingxiuindex() {
        return lingxiuindex == -1? null :lingxius.get(lingxiuindex);
    }

    public List<GongfaCase> getGongfas() {
        return gongfas;
    }

    public GongfaCase getGongfaindex() {
//        return gongfaindex == -1? null :gongfas.get(gongfaindex);
        if(gongfas.isEmpty())return null;
        return gongfas.get(gongfas.size()-1);
    }


    public void setDensityFunction(DensityFunction densityFunction) {
        this.densityFunction = densityFunction;
    }

    public void createDensityFunction( Player player) {
        densityFunction = new DensityFunction(this, player);
    }
}
