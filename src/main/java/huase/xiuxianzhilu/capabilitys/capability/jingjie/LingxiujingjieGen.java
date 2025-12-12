package huase.xiuxianzhilu.capabilitys.capability.jingjie;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample0;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiujingjieNoPrent;
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
public class LingxiujingjieGen {
    public static final ResourceKey<Registry<LingxiuJingjieSample>> lingxiu_jingjie_key = ResourceKey.createRegistryKey(ModMain.prefix("lingxiu_jingjie_key"));
    public static final DeferredRegister<LingxiuJingjieSample> LingxiujingjieBase_REGISTER = DeferredRegister.create(lingxiu_jingjie_key, ModMain.MODID);

    public static final Supplier<IForgeRegistry<LingxiuJingjieSample>> LingxiuJingjie_Supplier_REGISTRY = LingxiujingjieBase_REGISTER.makeRegistry(() -> new RegistryBuilder<LingxiuJingjieSample>().allowModification().disableSync());

    public static final Codec<LingxiuJingjieSample> CODEC = LingxiujingjieTypesInIt.CODEC.dispatch("jingjie_type", LingxiuJingjieSample::getType, LingxiujingjieType::getCodec);
    public static final Codec<Holder<LingxiuJingjieSample>> HOLDER_CODEC = RegistryFileCodec.create(lingxiu_jingjie_key, CODEC, true);

    public static final ResourceKey<LingxiuJingjieSample> huashen     = registerKey("huashen");
    public static final ResourceKey<LingxiuJingjieSample> yuanying    = registerKey("yuanying");
    public static final ResourceKey<LingxiuJingjieSample> jindan      = registerKey("jindan");
    public static final ResourceKey<LingxiuJingjieSample> zhuji       = registerKey("zhuji");
    public static final ResourceKey<LingxiuJingjieSample> lianqi      = registerKey("lianqi");
    public static ResourceKey<LingxiuJingjieSample> registerKey(String name) {
        return ResourceKey.create(lingxiu_jingjie_key,ModMain.prefix(name));
    }


    public static void bootstrap(BootstapContext<LingxiuJingjieSample> context) {

        Holder.Reference<LingxiuJingjieSample> lingxiujingjie4 = context.register(huashen, new LingxiujingjieNoPrent( 4, 500, 100, 300, 8, 4, 40, 3, 3));
        Holder.Reference<LingxiuJingjieSample> lingxiujingjie3 = context.register(yuanying, new LingxiuJingjieSample0(lingxiujingjie4, 4, 100, 100, 300, 8, 4, 40, 3, 3));
        Holder.Reference<LingxiuJingjieSample> lingxiujingjie2 = context.register(jindan, new LingxiuJingjieSample0(lingxiujingjie3, 4, 50, 100, 300, 8, 4, 40, 3, 3));
        Holder.Reference<LingxiuJingjieSample> lingxiujingjie1 = context.register(zhuji, new LingxiuJingjieSample0(lingxiujingjie2, 4, 10, 100, 300, 8, 4, 40, 3, 3));
        Holder.Reference<LingxiuJingjieSample> lingxiujingjie0 = context.register(lianqi, new LingxiuJingjieSample0(lingxiujingjie1, 10, 2, 100, 300, 8, 4, 40, 3, 3));
    }
}
