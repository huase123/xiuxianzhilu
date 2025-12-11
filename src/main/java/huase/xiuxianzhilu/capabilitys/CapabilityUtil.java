package huase.xiuxianzhilu.capabilitys;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.AttributeBase;
import huase.xiuxianzhilu.capabilitys.capability.Linggen;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieFactorys;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuCase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjie;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import java.util.List;

import static huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieFactorys.lingxiu_jingjie_key;

/**
 * - @description:CapabilityUtil类
 * - @author: huase。
 * - @date: 2025/10/12 9:03
 */
public class CapabilityUtil {

    public static void synsMaxhealth(Entity entity, AttributeBase capability) {
        if (entity instanceof LivingEntity livingEntity){
            float maxshengming = capability.getMaxshengming();
            if(livingEntity.getAttribute(Attributes.MAX_HEALTH).getValue() != maxshengming){
                livingEntity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(maxshengming);
                if(!(entity instanceof Player)){
                    livingEntity.setHealth(maxshengming);
                }
            }
        }
    }

    public static AttributeBase getCapability(ICapabilityProvider capabilityProvider) {
//        if(capabilityProvider == null)return null;
        if(capabilityProvider instanceof Player)return capabilityProvider.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).orElse(null);
        if(capabilityProvider instanceof LivingEntity)return capabilityProvider.getCapability(RegisterCapabilitys.MOSTERCAPABILITY).orElse(null);
        return null;

    }



    public static void addLingxiuCase(Player player) {
        PlayerCapability capability = (PlayerCapability) getCapability(player);
        List<LingxiuCase> lingxius = capability.getLingxius();
        if(lingxius.isEmpty()){
            LingxiuJingjie lingxiuJingjie = player.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieFactorys.lianqi);
            lingxius.add(new LingxiuCase(player,lingxiuJingjie));
            ModMain.LOGGER.info("成功添加新境界");
        }else {
            LingxiuCase lingxiuCase = lingxius.get(lingxius.size() - 1);
            Holder<LingxiuJingjie> prent = lingxiuCase.getLingxiuJingjie().getPrent();

            if(prent != null){
                lingxius.add(new LingxiuCase(player,prent.get()));
            }else {
                ModMain.LOGGER.info("无后续境界");
            }
        }
    }

    public static void createDensityFunction(PlayerCapability capability, Player pPlayer) {
        capability.createDensityFunction(pPlayer);
        openLinggen(capability,pPlayer);

//        改为由功法触发
        CapabilityUtil.addLingxiuCase(pPlayer);
    }

    private static void openLinggen(PlayerCapability capability, Player pPlayer) {
        RandomSource random = pPlayer.getRandom();
        Linggen[] values = Linggen.values();
        List<Linggen> linggens1 = capability.getLinggens();
        while (linggens1.isEmpty()){
            for (Linggen value : values) {
                if(random.nextBoolean());{
                    linggens1.add(value);
                }
            }
        }
    }
}
