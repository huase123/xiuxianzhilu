package huase.xiuxianzhilu.Registrie;

import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieFactorys;
import net.minecraftforge.registries.DataPackRegistryEvent;
import net.minecraftforge.registries.NewRegistryEvent;


/**
 * - @description:Registries类
 */
public class Registries {

    public static void setRegistriesForDatapack(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(LingxiujingjieFactorys.lingxiu_jingjie_key, LingxiujingjieFactorys.CODEC, LingxiujingjieFactorys.CODEC);
//        event.dataPackRegistry(MagicPaintingVariants.REGISTRY_KEY, MagicPaintingVariant.CODEC, MagicPaintingVariant.CODEC);
    }


    /**
     * TODO 功能描述：注册表查询使用，可直接用level.registryAccess().registryOrThrow(LINGXIUJINGJIE_KEY)代替
     * @author :huase
     * @date 2025/11/10 9:45
     */
//    public static IForgeRegistry<LingxiuJingjie> LingxiuJingjie_IForgeRegistry;
    public static void registerNewRegistry(NewRegistryEvent event) {
//        event.create(new RegistryBuilder<LingxiuJingjie>().setName(LINGXIUJINGJIE_KEY.location()).setMaxID(1000), functionTypes -> LingxiuJingjie_IForgeRegistry = functionTypes);
//        event.create(new RegistryBuilder<LingxiuJingjie>().setName(LINGXIUJINGJIE_KEY.location()).setMaxID(1000));
  }
}
