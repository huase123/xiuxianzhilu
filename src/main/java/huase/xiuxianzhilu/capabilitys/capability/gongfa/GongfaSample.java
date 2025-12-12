package huase.xiuxianzhilu.capabilitys.capability.gongfa;

import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.items.gongfa.GongfaSampleItem;

/**
 * - @description:GongfaSample类
 */
public abstract class GongfaSample extends AttributeBase {

    public GongfaSample(float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv);
    }

    public abstract GongfaType getType();

    public abstract GongfaSampleItem getItem() ;
}
