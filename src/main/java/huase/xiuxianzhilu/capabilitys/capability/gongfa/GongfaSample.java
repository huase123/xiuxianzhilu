package huase.xiuxianzhilu.capabilitys.capability.gongfa;

import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuCase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import huase.xiuxianzhilu.items.gongfa.GongfaSampleItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import java.util.List;

import static huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen.lingxiu_jingjie_key;

/**
 * - @description:GongfaSample类
 */
public abstract class GongfaSample extends AttributeBase {

    public GongfaSample(float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv) {
        super(maxshengming, wugong, wufang, baojishanghai, baojilv);
    }

    public abstract GongfaType getType();

    public abstract GongfaSampleItem getItem() ;

    public abstract int getIntensity();

    public void xiulian(Player player, List<Entity> passengers) {

    }

    public abstract int getmaxlayernum() ;

    public abstract int getmaxjingyan() ;

    public abstract Holder<LingxiuJingjieSample> getPrent();

    public void yuanman(Player player, List<Entity> passengers) {
        Holder<LingxiuJingjieSample> prent = getPrent();
        if(prent != null) {
            PlayerCapability capability = CapabilityUtil.getCapability(player);
            List<LingxiuCase> lingxius = capability.getLingxius();
            for (LingxiuCase lingxiuCase : lingxius) {
                if(lingxiuCase.getLingxiuJingjie().equals(prent.get()))return;
            }
            lingxius.add(new LingxiuCase(player, prent.get()));
            capability.setLingxiuindex(lingxius.size()-1);
            ResourceLocation key = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(prent.get());
            player.sendSystemMessage(Component.translatable("修为成功进阶到").withStyle(ChatFormatting.YELLOW).append(Component.translatable(key.toString()).withStyle(ChatFormatting.GOLD)));

        }
    }
}
