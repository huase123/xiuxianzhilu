package huase.xiuxianzhilu.registrie;

import huase.xiuxianzhilu.capabilitys.capability.danyao.DanyaoGen;
import huase.xiuxianzhilu.capabilitys.capability.fabao.FabaoGen;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.recipe.MultiBlockRecipeSerializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
//        event.dataPackRegistry(MagicPaintingVariants.REGISTRY_KEY, MagicPaintingVariant.CODEC, MagicPaintingVariant.CODEC);
    }


    public static final ResourceKey<Registry<MultiBlockRecipeSerializer<?>>> MultiBlockRecipeSerializer_Resourcekey = createRegistryKey("multiblockrecipeserializer_resourcekey");

    public static IForgeRegistry<MultiBlockRecipeSerializer<?>> MultiBlockRecipeSerializer_IForgeRegistry;
    private static <T> ResourceKey<Registry<T>> createRegistryKey(String pName) {
        return ResourceKey.createRegistryKey(ResourceLocation.parse(pName));
    }
    /**
     * TODO 功能描述：注册表查询使用，可直接用level.registryAccess().registryOrThrow(LINGXIUJINGJIE_KEY)代替
     * @author :huase
     * @date 2025/11/10 9:45
     */
    public static void registerNewRegistry(NewRegistryEvent event) {

        event.create(new RegistryBuilder<MultiBlockRecipeSerializer<?>>().setName(MultiBlockRecipeSerializer_Resourcekey.location()).setMaxID(1000), functionTypes -> MultiBlockRecipeSerializer_IForgeRegistry = functionTypes);
//        event.create(new RegistryBuilder<LingxiuJingjie>().setName(LINGXIUJINGJIE_KEY.location()).setMaxID(1000), functionTypes -> LingxiuJingjie_IForgeRegistry = functionTypes);
//        event.create(new RegistryBuilder<LingxiuJingjie>().setName(LINGXIUJINGJIE_KEY.location()).setMaxID(1000));
  }
}
