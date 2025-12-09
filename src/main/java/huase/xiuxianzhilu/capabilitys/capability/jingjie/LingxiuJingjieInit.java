package huase.xiuxianzhilu.capabilitys.capability.jingjie;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjie;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.registries.DeferredRegister;

/**
 * - @description:LingxiuJingjieInit类
 */
public class LingxiuJingjieInit {
//    注册表查询获取使用，如level.registryAccess().registryOrThrow(LINGXIUJINGJIE_KEY).get(lianqi);
    public static final ResourceKey<Registry<LingxiuJingjie>> LINGXIUJINGJIE_KEY = ResourceKey.createRegistryKey(ModMain.prefix("lingxiujingjie"));

//    注册表注册使用，通过code自动加载注册
    public static final DeferredRegister<LingxiuJingjie> LINGXIUJINGJIE_REGISTER = DeferredRegister.create(LINGXIUJINGJIE_KEY, ModMain.MODID);

    /**
     * TODO 功能描述：提后续资源包使用
     * @author :huase
     * @date 2025/12/10 2:32
     */
    public static final Codec<Holder<LingxiuJingjie>> CODEC = RegistryFileCodec.create(LingxiuJingjieInit.LINGXIUJINGJIE_KEY, LingxiuJingjie.CODEC, false);


    public static final ResourceKey<LingxiuJingjie> lianqi = makeKey("lianqi");

    private static ResourceKey<LingxiuJingjie> makeKey(String name) {
        return ResourceKey.create(LINGXIUJINGJIE_KEY, ModMain.prefix(name));
    }

    public static void bootstrap(BootstapContext<LingxiuJingjie> context) {
        context.register(lianqi, new LingxiuJingjie(100,300,8,4,40,3,3));
    }
}