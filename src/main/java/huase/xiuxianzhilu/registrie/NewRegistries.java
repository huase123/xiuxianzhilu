package huase.xiuxianzhilu.registrie;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.danyao.DanyaoGen;
import huase.xiuxianzhilu.capabilitys.capability.danyao.DanyaoTypesInIt;
import huase.xiuxianzhilu.capabilitys.capability.entityliving.EntitylivingGen;
import huase.xiuxianzhilu.capabilitys.capability.entityliving.EntitylivingTypesInIt;
import huase.xiuxianzhilu.capabilitys.capability.fabao.FabaoGen;
import huase.xiuxianzhilu.capabilitys.capability.fabao.FabaoTypesInIt;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaTypesInit;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieTypesInIt;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import huase.xiuxianzhilu.recipe.MultiBlockRecipeSerializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.registries.DataPackRegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegistryBuilder;


/**
 * - @description:Registries类
 */
public class NewRegistries {

    public static void setRegistriesForDatapack(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(LingxiujingjieGen.lingxiu_jingjie_key, LingxiujingjieGen.CODEC, LingxiujingjieGen.CODEC);
        event.dataPackRegistry(GongfaGen.gongfa_key, GongfaGen.CODEC, GongfaGen.CODEC);
        event.dataPackRegistry(FabaoGen.fabao_key, FabaoGen.CODEC, FabaoGen.CODEC);
        event.dataPackRegistry(DanyaoGen.danyao_key, DanyaoGen.CODEC, DanyaoGen.CODEC);
        event.dataPackRegistry(EntitylivingGen.entityliving_key, EntitylivingGen.CODEC, EntitylivingGen.CODEC);
//        event.dataPackRegistry(MagicPaintingVariants.REGISTRY_KEY, MagicPaintingVariant.CODEC, MagicPaintingVariant.CODEC);
    }


    public static final ResourceKey<Registry<MultiBlockRecipeSerializer<?>>> MultiBlockRecipeSerializer_Resourcekey = createRegistryKey("multiblockrecipeserializer_resourcekey");

    public static IForgeRegistry<MultiBlockRecipeSerializer<?>> MultiBlockRecipeSerializer_IForgeRegistry;
    private static <T> ResourceKey<Registry<T>> createRegistryKey(String pName) {
        return ResourceKey.createRegistryKey(ModMain.parse(pName));
    }
    /**
     * TODO 功能描述：注册表查询使用，可直接用level.registryAccess().registryOrThrow(LINGXIUJINGJIE_KEY)代替
     * @author :huase
     * @date 2025/11/10 9:45
     */
    public static void registerNewRegistry(NewRegistryEvent event) {

        event.create(new RegistryBuilder<MultiBlockRecipeSerializer<?>>().setName(MultiBlockRecipeSerializer_Resourcekey.location()).setMaxID(1000),
                functionTypes -> MultiBlockRecipeSerializer_IForgeRegistry = functionTypes);


        event.create(new RegistryBuilder<LingxiuJingjieSample>().setName(LingxiujingjieGen.lingxiu_jingjie_key.location()).setMaxID(1000));
        event.create(new RegistryBuilder<LingxiuJingjieSample>().setName(GongfaGen.gongfa_key.location()).setMaxID(1000));
        event.create(new RegistryBuilder<LingxiuJingjieSample>().setName(FabaoGen.fabao_key.location()).setMaxID(1000));
        event.create(new RegistryBuilder<LingxiuJingjieSample>().setName(DanyaoGen.danyao_key.location()).setMaxID(1000));
        event.create(new RegistryBuilder<LingxiuJingjieSample>().setName(EntitylivingGen.entityliving_key.location()).setMaxID(1000));

        event.create(new RegistryBuilder<LingxiuJingjieSample>().setName(LingxiujingjieTypesInIt.lingxiu_jingjie_type.location()).setMaxID(1000));
        event.create(new RegistryBuilder<LingxiuJingjieSample>().setName(GongfaTypesInit.gongfa_type_key.location()).setMaxID(1000));
        event.create(new RegistryBuilder<LingxiuJingjieSample>().setName(FabaoTypesInIt.fabao_type.location()).setMaxID(1000));
        event.create(new RegistryBuilder<LingxiuJingjieSample>().setName(DanyaoTypesInIt.danyao_type.location()).setMaxID(1000));
        event.create(new RegistryBuilder<LingxiuJingjieSample>().setName(EntitylivingTypesInIt.entityliving_type.location()).setMaxID(1000));
//        event.create(new RegistryBuilder<LingxiuJingjie>().setName(LINGXIUJINGJIE_KEY.location()).setMaxID(1000), functionTypes -> LingxiuJingjie_IForgeRegistry = functionTypes);
//        event.create(new RegistryBuilder<LingxiuJingjie>().setName(LINGXIUJINGJIE_KEY.location()).setMaxID(1000));
  }
}
