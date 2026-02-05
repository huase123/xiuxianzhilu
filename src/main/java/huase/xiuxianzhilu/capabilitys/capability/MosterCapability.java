package huase.xiuxianzhilu.capabilitys.capability;

import net.minecraft.world.entity.Entity;

/**
 * - @description:MosterCapability类
 * - @author: huase。
 * - @date: 2025/10/12 3:33
 */
public class MosterCapability extends AttributeBase implements hua.huase.shanhaicontinent.capabilitys.capability.Update {


    private boolean isupdate =true;

    public MosterCapability(Entity object) {

    }

    public boolean isIsupdate() {
        return isupdate;
    }

    public void setIsupdate(boolean isupdate) {
        this.isupdate = isupdate;
    }
}
