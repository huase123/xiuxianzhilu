package huase.xiuxianzhilu.capabilitys.capability.jingjie;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample0;
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
public class LingxiujingjieGen {
    public static final ResourceKey<Registry<LingxiuJingjieSample>> lingxiu_jingjie_key = ResourceKey.createRegistryKey(ModMain.prefix("lingxiu_jingjie_key"));
    public static final DeferredRegister<LingxiuJingjieSample> LingxiujingjieBase_REGISTER = DeferredRegister.create(lingxiu_jingjie_key, ModMain.MODID);

    public static final Supplier<IForgeRegistry<LingxiuJingjieSample>> LingxiuJingjie_Supplier_REGISTRY = LingxiujingjieBase_REGISTER.makeRegistry(() -> new RegistryBuilder<LingxiuJingjieSample>().allowModification().disableSync());

    public static final Codec<LingxiuJingjieSample> CODEC = LingxiujingjieTypesInIt.CODEC.dispatch("jingjie_type", LingxiuJingjieSample::getType, LingxiujingjieType::getCodec);
    public static final Codec<Holder<LingxiuJingjieSample>> HOLDER_CODEC = RegistryFileCodec.create(lingxiu_jingjie_key, CODEC, true);

    public static final ResourceKey<LingxiuJingjieSample> lianqi      = registerKey("lianqi");
    public static final ResourceKey<LingxiuJingjieSample> zhuji       = registerKey("zhuji");
    public static final ResourceKey<LingxiuJingjieSample> jindan      = registerKey("jindan");
    public static final ResourceKey<LingxiuJingjieSample> yuanying    = registerKey("yuanying");
    public static final ResourceKey<LingxiuJingjieSample> huashen     = registerKey("huashen");

    public static ResourceKey<LingxiuJingjieSample> registerKey(String name) {
        return ResourceKey.create(lingxiu_jingjie_key,ModMain.prefix(name));
    }


    public static void bootstrap(BootstapContext<LingxiuJingjieSample> context) {
        HolderGetter<LingxiuJingjieSample> lookup = context.lookup(LingxiujingjieGen.lingxiu_jingjie_key);
        context.register(lianqi, new LingxiuJingjieSample0(lookup.getOrThrow(zhuji)                 , Iteminit.jingjie0.get()   ,12 , 5     ,360     ,   60        , 24        , 12     ,12 , 12 ,120 , 12, 12, 200       , 0));
        context.register(zhuji, new LingxiuJingjieSample0(lookup.getOrThrow(jindan)                 , Iteminit.jingjie1.get()   ,3  , 10    ,1000    ,   200       , 36        , 18     ,12 , 12 ,200 , 12, 12, 600       , 0));
        context.register(jindan, new LingxiuJingjieSample0(lookup.getOrThrow(yuanying)              , Iteminit.jingjie2.get()   ,3  , 20    ,2000    ,   800       , 48        , 24     ,12 , 12 ,300 , 12, 12, 1800      , 0));
        context.register(yuanying, new LingxiuJingjieSample0(lookup.getOrThrow(huashen)             , Iteminit.jingjie3.get()   ,3  , 40    ,4000    ,   3200      , 148       , 72     ,12 , 12 ,400 , 12, 12, 5400      , 3));
        context.register(huashen, new LingxiuJingjieSample0( (Holder<LingxiuJingjieSample>) null    , Iteminit.jingjie4.get()   ,3  , 80    ,8000    ,   12800     , 432       , 216    ,12 , 12 ,800 , 12, 12, 10000     , 3));
    }
}
