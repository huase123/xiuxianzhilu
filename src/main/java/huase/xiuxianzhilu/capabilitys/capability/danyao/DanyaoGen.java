package huase.xiuxianzhilu.capabilitys.capability.danyao;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.danyao.danyaos.DanyaoSample;
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
public class DanyaoGen {
    public static final ResourceKey<Registry<Danyaoabstract>> danyao_key = ResourceKey.createRegistryKey(ModMain.prefix("danyao_key"));
    public static final DeferredRegister<Danyaoabstract> danyao_keyBase_REGISTER = DeferredRegister.create(danyao_key, ModMain.MODID);

    public static final Supplier<IForgeRegistry<Danyaoabstract>> danyao_key_Supplier_REGISTRY = danyao_keyBase_REGISTER.makeRegistry(() -> new RegistryBuilder<Danyaoabstract>().allowModification().disableSync());

    public static final Codec<Danyaoabstract> CODEC = DanyaoTypesInIt.CODEC.dispatch("danyao_key_type", Danyaoabstract::getType, DanyaoType::getCodec);
    public static final Codec<Holder<Danyaoabstract>> HOLDER_CODEC = RegistryFileCodec.create(danyao_key, CODEC, true);

    public static final ResourceKey<Danyaoabstract> danyao0      = registerKey("danyao0");
    public static final ResourceKey<Danyaoabstract> danyao1      = registerKey("danyao1");
    public static final ResourceKey<Danyaoabstract> danyao2      = registerKey("danyao2");
    public static final ResourceKey<Danyaoabstract> danyao3      = registerKey("danyao3");
    public static final ResourceKey<Danyaoabstract> danyao4      = registerKey("danyao4");
    public static final ResourceKey<Danyaoabstract> danyao5      = registerKey("danyao5");
    public static final ResourceKey<Danyaoabstract> danyao6      = registerKey("danyao6");
    public static final ResourceKey<Danyaoabstract> danyao7      = registerKey("danyao7");
    public static final ResourceKey<Danyaoabstract> danyao8      = registerKey("danyao8");
    public static final ResourceKey<Danyaoabstract> danyao9      = registerKey("danyao9");
    public static final ResourceKey<Danyaoabstract> danyao10      = registerKey("danyao10");
    public static final ResourceKey<Danyaoabstract> danyao11      = registerKey("danyao11");
    public static final ResourceKey<Danyaoabstract> danyao12      = registerKey("danyao12");
    public static final ResourceKey<Danyaoabstract> danyao13      = registerKey("danyao13");
    public static final ResourceKey<Danyaoabstract> danyao14      = registerKey("danyao14");
    public static final ResourceKey<Danyaoabstract> danyao15      = registerKey("danyao15");
    public static final ResourceKey<Danyaoabstract> danyao16      = registerKey("danyao16");
    public static final ResourceKey<Danyaoabstract> danyao17      = registerKey("danyao17");
    public static final ResourceKey<Danyaoabstract> danyao18      = registerKey("danyao18");
    public static final ResourceKey<Danyaoabstract> danyao19      = registerKey("danyao19");
    public static final ResourceKey<Danyaoabstract> danyao20      = registerKey("danyao20");
    public static final ResourceKey<Danyaoabstract> danyao21      = registerKey("danyao21");
    public static final ResourceKey<Danyaoabstract> danyao22      = registerKey("danyao22");
    public static final ResourceKey<Danyaoabstract> danyao23      = registerKey("danyao23");
    public static final ResourceKey<Danyaoabstract> danyao24      = registerKey("danyao24");
    public static final ResourceKey<Danyaoabstract> danyao25      = registerKey("danyao25");
    public static final ResourceKey<Danyaoabstract> danyao26      = registerKey("danyao26");
    public static final ResourceKey<Danyaoabstract> danyao27      = registerKey("danyao27");
    public static final ResourceKey<Danyaoabstract> danyao28      = registerKey("danyao28");
    public static final ResourceKey<Danyaoabstract> danyao29      = registerKey("danyao29");
    public static final ResourceKey<Danyaoabstract> danyao30      = registerKey("danyao30");
    public static final ResourceKey<Danyaoabstract> danyao31      = registerKey("danyao31");
    public static final ResourceKey<Danyaoabstract> danyao32      = registerKey("danyao32");
    public static final ResourceKey<Danyaoabstract> danyao33      = registerKey("danyao33");
    public static final ResourceKey<Danyaoabstract> danyao34      = registerKey("danyao34");
    public static final ResourceKey<Danyaoabstract> danyao35      = registerKey("danyao35");
    public static final ResourceKey<Danyaoabstract> danyao36      = registerKey("danyao36");
    public static final ResourceKey<Danyaoabstract> danyao37      = registerKey("danyao37");
    public static final ResourceKey<Danyaoabstract> danyao38      = registerKey("danyao38");
    public static final ResourceKey<Danyaoabstract> danyao39      = registerKey("danyao39");

    public static ResourceKey<Danyaoabstract> registerKey(String name) {
        return ResourceKey.create(danyao_key,ModMain.prefix(name));
    }


    public static void bootstrap(BootstapContext<Danyaoabstract> context) {
        HolderGetter<LingxiuJingjieSample> lookup = context.lookup(LingxiujingjieGen.lingxiu_jingjie_key);
        context.register(danyao0    , new DanyaoSample(Iteminit.danyao0.get(),lookup.getOrThrow(LingxiujingjieGen.lianqi   ),3,1,0,0,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao1    , new DanyaoSample(Iteminit.danyao1.get(),lookup.getOrThrow(LingxiujingjieGen.lianqi   ),3,0,5,0,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao2    , new DanyaoSample(Iteminit.danyao2.get(),lookup.getOrThrow(LingxiujingjieGen.lianqi   ),3,0,0,1,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao3    , new DanyaoSample(Iteminit.danyao3.get(),lookup.getOrThrow(LingxiujingjieGen.lianqi   ),3,0,0,0,5,0,0,0,0,0,0,0,0,0));
        context.register(danyao4    , new DanyaoSample(Iteminit.danyao4.get(),lookup.getOrThrow(LingxiujingjieGen.lianqi   ),-1,0,0,0,0,40,0,0,0,0,0,0,0,0));
        context.register(danyao5    , new DanyaoSample(Iteminit.danyao5.get(),lookup.getOrThrow(LingxiujingjieGen.lianqi   ),3,0,0,0,0,0,5,0,0,0,0,0,0,0));
        context.register(danyao6    , new DanyaoSample(Iteminit.danyao6.get(),lookup.getOrThrow(LingxiujingjieGen.lianqi   ),-1,0,0,0,0,0,0,20,0,0,0,0,0,0));
        context.register(danyao7    , new DanyaoSample(Iteminit.danyao7.get(),lookup.getOrThrow(LingxiujingjieGen.lianqi   ),-1,0,0,0,0,0,0,0,20,0,0,0,0,0));
        context.register(danyao8    , new DanyaoSample(Iteminit.danyao8.get(),lookup.getOrThrow(LingxiujingjieGen.zhuji   ),3,3,0,0,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao9    , new DanyaoSample(Iteminit.danyao9.get(),lookup.getOrThrow(LingxiujingjieGen.zhuji   ),3,0,10,0,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao10    , new DanyaoSample(Iteminit.danyao10.get(),lookup.getOrThrow(LingxiujingjieGen.zhuji   ),3,0,0,3,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao11    , new DanyaoSample(Iteminit.danyao11.get(),lookup.getOrThrow(LingxiujingjieGen.zhuji   ),3,0,0,0,10,0,0,0,0,0,0,0,0,0));
        context.register(danyao12    , new DanyaoSample(Iteminit.danyao12.get(),lookup.getOrThrow(LingxiujingjieGen.zhuji   ),-1,0,0,0,0,80,0,0,0,0,0,0,0,0));
        context.register(danyao13    , new DanyaoSample(Iteminit.danyao13.get(),lookup.getOrThrow(LingxiujingjieGen.zhuji   ),3,0,0,0,0,0,10,0,0,0,0,0,0,0));
        context.register(danyao14    , new DanyaoSample(Iteminit.danyao14.get(),lookup.getOrThrow(LingxiujingjieGen.zhuji   ),-1,0,0,0,0,0,0,80,0,0,0,0,0,0));
        context.register(danyao15    , new DanyaoSample(Iteminit.danyao15.get(),lookup.getOrThrow(LingxiujingjieGen.zhuji   ),-1,0,0,0,0,0,0,0,80,0,0,0,0,0));
        context.register(danyao16    , new DanyaoSample(Iteminit.danyao16.get(),lookup.getOrThrow(LingxiujingjieGen.jindan   ),3,9,0,0,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao17    , new DanyaoSample(Iteminit.danyao17.get(),lookup.getOrThrow(LingxiujingjieGen.jindan   ),3,0,30,0,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao18    , new DanyaoSample(Iteminit.danyao18.get(),lookup.getOrThrow(LingxiujingjieGen.jindan   ),3,0,0,9,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao19    , new DanyaoSample(Iteminit.danyao19.get(),lookup.getOrThrow(LingxiujingjieGen.jindan   ),3,0,0,0,20,0,0,0,0,0,0,0,0,0));
        context.register(danyao20    , new DanyaoSample(Iteminit.danyao20.get(),lookup.getOrThrow(LingxiujingjieGen.jindan   ),-1,0,0,0,0,160,0,0,0,0,0,0,0,0));
        context.register(danyao21    , new DanyaoSample(Iteminit.danyao21.get(),lookup.getOrThrow(LingxiujingjieGen.jindan   ),3,0,0,0,0,0,20,0,0,0,0,0,0,0));
        context.register(danyao22    , new DanyaoSample(Iteminit.danyao22.get(),lookup.getOrThrow(LingxiujingjieGen.jindan   ),-1,0,0,0,0,0,0,240,0,0,0,0,0,0));
        context.register(danyao23    , new DanyaoSample(Iteminit.danyao23.get(),lookup.getOrThrow(LingxiujingjieGen.jindan   ),-1,0,0,0,0,0,0,0,240,0,0,0,0,0));
        context.register(danyao24    , new DanyaoSample(Iteminit.danyao24.get(),lookup.getOrThrow(LingxiujingjieGen.yuanying   ),3,27,0,0,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao25    , new DanyaoSample(Iteminit.danyao25.get(),lookup.getOrThrow(LingxiujingjieGen.yuanying   ),3,0,90,0,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao26    , new DanyaoSample(Iteminit.danyao26.get(),lookup.getOrThrow(LingxiujingjieGen.yuanying   ),3,0,0,27,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao27    , new DanyaoSample(Iteminit.danyao27.get(),lookup.getOrThrow(LingxiujingjieGen.yuanying   ),3,0,0,0,30,0,0,0,0,0,0,0,0,0));
        context.register(danyao28    , new DanyaoSample(Iteminit.danyao28.get(),lookup.getOrThrow(LingxiujingjieGen.yuanying   ),-1,0,0,0,0,320,0,0,0,0,0,0,0,0));
        context.register(danyao29    , new DanyaoSample(Iteminit.danyao29.get(),lookup.getOrThrow(LingxiujingjieGen.yuanying   ),3,0,0,0,0,0,40,0,0,0,0,0,0,0));
        context.register(danyao30    , new DanyaoSample(Iteminit.danyao30.get(),lookup.getOrThrow(LingxiujingjieGen.yuanying   ),-1,0,0,0,0,0,0,720,0,0,0,0,0,0));
        context.register(danyao31    , new DanyaoSample(Iteminit.danyao31.get(),lookup.getOrThrow(LingxiujingjieGen.yuanying   ),-1,0,0,0,0,0,0,0,720,0,0,0,0,0));
        context.register(danyao32    , new DanyaoSample(Iteminit.danyao32.get(),lookup.getOrThrow(LingxiujingjieGen.huashen   ),3,54,0,0,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao33    , new DanyaoSample(Iteminit.danyao33.get(),lookup.getOrThrow(LingxiujingjieGen.huashen   ),3,0,150,0,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao34    , new DanyaoSample(Iteminit.danyao34.get(),lookup.getOrThrow(LingxiujingjieGen.huashen   ),3,0,0,54,0,0,0,0,0,0,0,0,0,0));
        context.register(danyao35    , new DanyaoSample(Iteminit.danyao35.get(),lookup.getOrThrow(LingxiujingjieGen.huashen   ),3,0,0,0,40,0,0,0,0,0,0,0,0,0));
        context.register(danyao36    , new DanyaoSample(Iteminit.danyao36.get(),lookup.getOrThrow(LingxiujingjieGen.huashen   ),-1,0,0,0,0,640,0,0,0,0,0,0,0,0));
        context.register(danyao37    , new DanyaoSample(Iteminit.danyao37.get(),lookup.getOrThrow(LingxiujingjieGen.huashen   ),3,0,0,0,0,0,80,0,0,0,0,0,0,0));
        context.register(danyao38    , new DanyaoSample(Iteminit.danyao38.get(),lookup.getOrThrow(LingxiujingjieGen.huashen   ),-1,0,0,0,0,0,0,1440,0,0,0,0,0,0));
        context.register(danyao39    , new DanyaoSample(Iteminit.danyao39.get(),lookup.getOrThrow(LingxiujingjieGen.huashen   ),-1,0,0,0,0,0,0,0,1440,0,0,0,0,0));

    }
}
