package huase.xiuxianzhilu.capabilitys.capability.gongfa;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.gongfas.JichutulafaGongfa;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import huase.xiuxianzhilu.items.Iteminit;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
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
public class GongfaGen {
    public static final ResourceKey<Registry<GongfaSample>> gongfa_key = ResourceKey.createRegistryKey(ModMain.prefix("gongfa_key"));
    public static final DeferredRegister<GongfaSample> gongfa_key_REGISTER = DeferredRegister.create(gongfa_key, ModMain.MODID);

    public static final Supplier<IForgeRegistry<GongfaSample>> gongfa_key_Supplier_REGISTRY = gongfa_key_REGISTER.makeRegistry(() -> new RegistryBuilder<GongfaSample>().allowModification().disableSync());

    public static final Codec<GongfaSample> CODEC = GongfaTypesInit.CODEC.dispatch("gongfa_type", GongfaSample::getType, GongfaType::getCodec);
    public static final Codec<Holder<GongfaSample>> HOLDER_CODEC = RegistryFileCodec.create(gongfa_key, CODEC, true);

    public static final ResourceKey<GongfaSample> jichutulafa0     = registerKey("jichutulafa0");
    public static final ResourceKey<GongfaSample> jichutulafa1     = registerKey("jichutulafa1");
    public static final ResourceKey<GongfaSample> jichutulafa2     = registerKey("jichutulafa2");
    public static final ResourceKey<GongfaSample> jichutulafa3     = registerKey("jichutulafa3");
    public static final ResourceKey<GongfaSample> jichutulafa4     = registerKey("jichutulafa4");
    public static ResourceKey<GongfaSample> registerKey(String name) {
        return ResourceKey.create(gongfa_key,ModMain.prefix(name));
    }


    public static void bootstrap(BootstapContext<GongfaSample> context) {
        HolderGetter<LingxiuJingjieSample> lookup = context.lookup(LingxiujingjieGen.lingxiu_jingjie_key);

        context.register(jichutulafa0, new JichutulafaGongfa(null                                          ,lookup.getOrThrow(LingxiujingjieGen.lianqi)    ,Iteminit.gongfa0.get(),1, 100,3,10, 2, 3, 1, 1));
        context.register(jichutulafa1, new JichutulafaGongfa(lookup.getOrThrow(LingxiujingjieGen.lianqi)        ,lookup.getOrThrow(LingxiujingjieGen.zhuji)     ,Iteminit.gongfa1.get(), 2,200,3,20, 2, 3, 1, 1));
        context.register(jichutulafa2, new JichutulafaGongfa(lookup.getOrThrow(LingxiujingjieGen.zhuji)         ,lookup.getOrThrow(LingxiujingjieGen.jindan)    ,Iteminit.gongfa2.get(), 3,300,3,30, 2, 3, 1, 1));
        context.register(jichutulafa3, new JichutulafaGongfa(lookup.getOrThrow(LingxiujingjieGen.jindan)        ,lookup.getOrThrow(LingxiujingjieGen.yuanying)  ,Iteminit.gongfa3.get(), 4,500,3,50, 2, 3, 1, 1));
        context.register(jichutulafa4, new JichutulafaGongfa(lookup.getOrThrow(LingxiujingjieGen.yuanying)      ,lookup.getOrThrow(LingxiujingjieGen.huashen)   ,Iteminit.gongfa4.get(), 5,800,3,80, 2, 3, 1, 1));
    }
}
