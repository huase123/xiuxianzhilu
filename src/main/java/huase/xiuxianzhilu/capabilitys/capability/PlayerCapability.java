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
    //年龄
    private float nianling;
    //灵力
    private float lingli;

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
        compoundTag.putFloat("nianling",nianling);
        compoundTag.putFloat("lingli",lingli);

        compoundTag.putBoolean("isupdate",isupdate);
        compoundTag.put("boneslot", boneslot.serializeNBT());


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

        compoundTag.putBoolean("huadensityfunction",densityFunction != null);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        super.deserializeNBT(compoundTag);
        this.nianling =compoundTag.getFloat("nianling");
        this.lingli =compoundTag.getFloat("lingli");

        isupdate = compoundTag.getBoolean("isupdate");
        if(compoundTag.get("boneslot")!=null){
            this.boneslot.deserializeNBT((CompoundTag) compoundTag.get("boneslot"));
        }


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
        for (int i = 0; i < compoundTag.getInt("gongfasize"); i++) {
            CompoundTag tag = (CompoundTag) compoundTag.get("gongfa" + i);
            gongfas.add(new GongfaCase(player,tag));
        }
        if(compoundTag.getBoolean("huadensityfunction"))createDensityFunction(player);
    }

    public float getNianling() {
        return nianling;
    }

    public void setNianling(float nianling) {
        this.nianling = nianling;
    }

    public float getLingli() {
        return lingli;
    }

    public void setLingli(float lingli) {
        this.lingli = lingli;
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

    public LingxiuCase getLingxiu() {
        if(lingxius.isEmpty()||lingxiuindex <= -1){
            return null;
        }else {
            if(lingxiuindex>=lingxius.size()){
                lingxiuindex = -1;
                return null;
            }else {
                return lingxius.get(lingxiuindex);
            }
        }
    }
    public LingxiuCase getLingxiu(int indext) {
//        return gongfaindex == -1? null :gongfas.get(gongfaindex);
        if(lingxius.isEmpty()||indext <= -1){
            return null;
        }else {
            if(indext>=lingxius.size()){
                return null;
            }else {
                return lingxius.get(indext);
            }
        }
    }


    public void setLingxiuindex(int lingxiuindex) {
        this.lingxiuindex = lingxiuindex;
    }

    public int getLingxiuindex() {
        return this.lingxiuindex ;
    }

    public List<GongfaCase> getGongfas() {
        return gongfas;
    }

    public void setGongfaindex(int gongfaindex) {
        if (gongfaindex<gongfas.size()){
            this.gongfaindex = gongfaindex;
        }else {
            this.gongfaindex = -1;
        }
    }
    public int getGongfaindex() {
        return this.gongfaindex;
    }

    public GongfaCase getGongfa() {
        if(gongfas.isEmpty()||gongfaindex <= -1){
            return null;
        }else {
            if(gongfaindex>=gongfas.size()){
                gongfaindex = -1;
                return null;
            }else {
                return gongfas.get(gongfaindex);
            }
        }
    }
    public GongfaCase getGongfa(int indext) {
//        return gongfaindex == -1? null :gongfas.get(gongfaindex);
        if(gongfas.isEmpty()||indext <= -1){
            return null;
        }else {
            if(indext>=gongfas.size()){
                return null;
            }else {
                return gongfas.get(indext);
            }
        }
    }


    public void setDensityFunction(DensityFunction densityFunction) {
        this.densityFunction = densityFunction;
    }

    public void createDensityFunction( Player player) {
        densityFunction = new DensityFunction(this, player);
    }
}
