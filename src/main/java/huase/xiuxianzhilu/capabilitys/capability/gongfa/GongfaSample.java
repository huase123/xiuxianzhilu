package huase.xiuxianzhilu.capabilitys.capability.gongfa;

import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuCase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

import java.util.List;

/**
 * - @description:GongfaSample类
 */
public abstract class GongfaSample extends AttributeBase {

    public GongfaSample(float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv);
    }

    public abstract GongfaType getType();

    public abstract Item getItem() ;

    public abstract int getIntensity();

    public void xiulian(Player player, List<Entity> passengers) {

    }

    public abstract int getmaxlayernum() ;

    public abstract int getmaxjingyan() ;

    public abstract Holder<LingxiuJingjieSample> getPrent();
    public abstract Holder<LingxiuJingjieSample> getChild();

    public void yuanman(Player player, List<Entity> passengers) {
        Holder<LingxiuJingjieSample> prent = getPrent();
        Holder<LingxiuJingjieSample> child = getChild();
        if(prent != null) {
            PlayerCapability capability = CapabilityUtil.getCapability(player);
            List<LingxiuCase> lingxius = capability.getLingxius();
            for (LingxiuCase lingxiuCase : lingxius) {
                if(lingxiuCase.getLingxiuJingjie().equals(prent.get()))return;
            }
            LingxiuCase lingxiu = capability.getLingxiu();

            if(child == null){
                if(lingxiu != null){
                    return;
                }
            }else {
                if(lingxiu == null){
                    return;
                }else {
                    if(!lingxiu.getLingxiuJingjie().equals(child.get()) || !lingxiu.isYuanman()){
                        return;
                    }
                }
            }
            CapabilityUtil.addLingxiuCase(player,prent);
        }
    }

}
