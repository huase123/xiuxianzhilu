package huase.xiuxianzhilu.capabilitys.capability.fabao;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.fabao.fabaos.FabaoSample;
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
public class FabaoGen {
    public static final ResourceKey<Registry<Fabaoabstract>> fabao_key = ResourceKey.createRegistryKey(ModMain.prefix("fabao_key"));
    public static final DeferredRegister<Fabaoabstract> fabao_keyBase_REGISTER = DeferredRegister.create(fabao_key, ModMain.MODID);

    public static final Supplier<IForgeRegistry<Fabaoabstract>> fabao_key_Supplier_REGISTRY = fabao_keyBase_REGISTER.makeRegistry(() -> new RegistryBuilder<Fabaoabstract>().allowModification().disableSync());

    public static final Codec<Fabaoabstract> CODEC = FabaoTypesInIt.CODEC.dispatch("fabao_key_type", Fabaoabstract::getType, FabaoType::getCodec);
    public static final Codec<Holder<Fabaoabstract>> HOLDER_CODEC = RegistryFileCodec.create(fabao_key, CODEC, true);

    public static final ResourceKey<Fabaoabstract> jiezhi0      = registerKey("jiezhi0");
    public static final ResourceKey<Fabaoabstract> jiezhi1      = registerKey("jiezhi1");
    public static final ResourceKey<Fabaoabstract> jiezhi2      = registerKey("jiezhi2");
    public static final ResourceKey<Fabaoabstract> jiezhi3      = registerKey("jiezhi3");
    public static final ResourceKey<Fabaoabstract> xianglian0      = registerKey("xianglian0");
    public static final ResourceKey<Fabaoabstract> xianglian1      = registerKey("xianglian1");
    public static final ResourceKey<Fabaoabstract> xianglian2      = registerKey("xianglian2");
    public static final ResourceKey<Fabaoabstract> xianglian3      = registerKey("xianglian3");
    public static final ResourceKey<Fabaoabstract> yvpei0      = registerKey("yvpei0");
    public static final ResourceKey<Fabaoabstract> yvpei1      = registerKey("yvpei1");
    public static final ResourceKey<Fabaoabstract> yvpei2      = registerKey("yvpei2");
    public static final ResourceKey<Fabaoabstract> yvpei3      = registerKey("yvpei3");
    public static final ResourceKey<Fabaoabstract> hufu0      = registerKey("hufu0");
    public static final ResourceKey<Fabaoabstract> hufu1      = registerKey("hufu1");
    public static final ResourceKey<Fabaoabstract> hufu2      = registerKey("hufu2");
    public static final ResourceKey<Fabaoabstract> hufu3      = registerKey("hufu3");

    public static ResourceKey<Fabaoabstract> registerKey(String name) {
        return ResourceKey.create(fabao_key,ModMain.prefix(name));
    }


    public static void bootstrap(BootstapContext<Fabaoabstract> context) {
        HolderGetter<LingxiuJingjieSample> lookup = context.lookup(LingxiujingjieGen.lingxiu_jingjie_key);
        context.register(jiezhi0    , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.lianqi   ),Iteminit.jiezhi0.get(),0,0,5 , 2    ,2     ,   0       , 0       , 0     ,0 , 2 ,0 , 0));
        context.register(jiezhi1    , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.zhuji    ),Iteminit.jiezhi1.get(),0,1,20 , 5    ,4     ,   0       , 0       , 0     ,0 , 4 ,0 , 0));
        context.register(jiezhi2    , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.yuanying ),Iteminit.jiezhi2.get(),0,2,100 , 15    ,12     ,   0       , 0       , 0     ,0 , 8 ,0 , 0));
        context.register(jiezhi3    , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.huashen  ),Iteminit.jiezhi3.get(),0,3,500 , 75    ,36     ,   0       , 0       , 0     ,0 , 16 ,0 , 0));
        context.register(xianglian0 , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.lianqi   ),Iteminit.xianglian0.get(),1,0,5 , 0    ,2     ,   2       , 0       , 0     ,0 , 2 ,0 , 0));
        context.register(xianglian1 , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.zhuji    ),Iteminit.xianglian1.get(),1,1,20 , 0    ,4     ,   4       , 0       , 0     ,0 , 4 ,0 , 0));
        context.register(xianglian2 , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.yuanying ),Iteminit.xianglian2.get(),1,2,100 , 0    ,12     ,   8       , 0       , 0     ,0 , 8 ,0 , 0));
        context.register(xianglian3 , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.huashen  ),Iteminit.xianglian3.get(),1,3,500 , 0    ,36     ,   0       , 0       , 16     ,0 , 16 ,0 , 0));
        context.register(yvpei0     , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.lianqi   ),Iteminit.yvpei0.get(),2,0,5 , 0    ,2     ,   0       , 0       , 20     ,0 , 2 ,0 , 0));
        context.register(yvpei1     , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.zhuji    ),Iteminit.yvpei1.get(),2,1,20 , 0    ,4     ,   0       , 0       , 40     ,0 , 4 ,0 , 0));
        context.register(yvpei2     , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.yuanying ),Iteminit.yvpei2.get(),2,2,100 , 0    ,12     ,   0       , 0       , 80     ,0 , 8 ,0 , 0));
        context.register(yvpei3     , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.huashen  ),Iteminit.yvpei3.get(),2,3,500 , 0    ,36     ,   0       , 0       , 160     ,0 , 16 ,0 , 0));
        context.register(hufu0      , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.lianqi   ),Iteminit.hufu0.get(),3,0,5 , 0    ,2     ,   0       , 0       , 0     ,5 , 2 ,0 , 0));
        context.register(hufu1      , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.zhuji    ),Iteminit.hufu1.get(),3,1,20 , 0    ,4     ,   0       , 0       , 0     ,10 , 4 ,0 , 0));
        context.register(hufu2      , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.yuanying ),Iteminit.hufu2.get(),3,2,100 , 0    ,12     ,   0       , 0       , 0     ,15 , 8 ,0 , 0));
        context.register(hufu3      , new FabaoSample(lookup.getOrThrow(LingxiujingjieGen.huashen  ),Iteminit.hufu3.get(),3,3,500 , 0    ,36     ,   0       , 0       , 0     ,20 , 16 ,0 , 0));
 }
}
