package huase.xiuxianzhilu.capabilitys.capability.jingjie;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjie;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjie0;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiujingjieFinal;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

import java.util.function.Supplier;

/**
 * - @description:LingxiujingjieFactorys类
 */
public class LingxiujingjieFactorys {
    public static final ResourceKey<Registry<LingxiuJingjie>> lingxiu_jingjie_key = ResourceKey.createRegistryKey(ModMain.prefix("lingxiu_jingjie_key"));
    public static final DeferredRegister<LingxiuJingjie> LingxiujingjieBase_REGISTER = DeferredRegister.create(lingxiu_jingjie_key, ModMain.MODID);

    public static final Supplier<IForgeRegistry<LingxiuJingjie>> LingxiuJingjie_Supplier_REGISTRY = LingxiujingjieBase_REGISTER.makeRegistry(() -> new RegistryBuilder<LingxiuJingjie>().allowModification().disableSync());

    public static final Codec<LingxiuJingjie> CODEC = LingxiujingjieTypes.CODEC.dispatch("layer_type", LingxiuJingjie::getType, LingxiujingjieType::getCodec);
    public static final Codec<Holder<LingxiuJingjie>> HOLDER_CODEC = RegistryFileCodec.create(lingxiu_jingjie_key, CODEC, true);

    public static final ResourceKey<LingxiuJingjie> huashen     = registerKey("huashen");
    public static final ResourceKey<LingxiuJingjie> yuanying    = registerKey("yuanying");
    public static final ResourceKey<LingxiuJingjie> jindan      = registerKey("jindan");
    public static final ResourceKey<LingxiuJingjie> zhuji       = registerKey("zhuji");
    public static final ResourceKey<LingxiuJingjie> lianqi      = registerKey("lianqi");
    public static ResourceKey<LingxiuJingjie> registerKey(String name) {
        return ResourceKey.create(lingxiu_jingjie_key,ModMain.prefix(name));
    }


    public static void bootstrap(BootstapContext<LingxiuJingjie> context) {

        Holder.Reference<LingxiuJingjie> lingxiujingjie4 = context.register(huashen, new LingxiujingjieFinal( 4, 500, 100, 300, 8, 4, 40, 3, 3));
        Holder.Reference<LingxiuJingjie> lingxiujingjie3 = context.register(yuanying, new LingxiuJingjie0(lingxiujingjie4, 4, 100, 100, 300, 8, 4, 40, 3, 3));
        Holder.Reference<LingxiuJingjie> lingxiujingjie2 = context.register(jindan, new LingxiuJingjie0(lingxiujingjie3, 4, 50, 100, 300, 8, 4, 40, 3, 3));
        Holder.Reference<LingxiuJingjie> lingxiujingjie1 = context.register(zhuji, new LingxiuJingjie0(lingxiujingjie2, 4, 10, 100, 300, 8, 4, 40, 3, 3));
        Holder.Reference<LingxiuJingjie> lingxiujingjie0 = context.register(lianqi, new LingxiuJingjie0(lingxiujingjie1, 10, 2, 100, 300, 8, 4, 40, 3, 3));
    }
}
