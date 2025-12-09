package huase.xiuxianzhilu.capabilitys.capability.jingjie;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjie;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:LingxiuJingjieType接口
 */
public interface LingxiuJingjieType <S extends LingxiuJingjie>{

    public static final ResourceKey<Registry<LingxiuJingjieType<?>>> LINGXIUJINGJIE_TYPE = ResourceKey.createRegistryKey(ModMain.prefix("lingxiujingjie_type"));

    public static final DeferredRegister<LingxiuJingjieType<?>> LINGXIUJINGJIE_TYPE_Registries = DeferredRegister.create(LINGXIUJINGJIE_TYPE, ModMain.MOD_ID);

    RegistryObject<LingxiuJingjieType<?>> WOODLAND_MANSION = register("woodland_mansion", LingxiuJingjie.CODEC);

    Codec<S> codec();

    private static <S extends LingxiuJingjie> RegistryObject<LingxiuJingjieType<S>> register(String pName, Codec<S> pCodec) {
        RegistryObject<LingxiuJingjieType<S>> register = LINGXIUJINGJIE_TYPE_Registries.register(pName, () ->() -> pCodec);
        return register;
    }
}
