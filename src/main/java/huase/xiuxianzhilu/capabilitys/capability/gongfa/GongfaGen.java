package huase.xiuxianzhilu.capabilitys.capability.gongfa;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.gongfas.JichutulafaGongfa;
import huase.xiuxianzhilu.items.Iteminit;
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
        context.register(jichutulafa0, new JichutulafaGongfa(Iteminit.gongfa0.get(),1, 10, 2, 3, 1, 1));
        context.register(jichutulafa1, new JichutulafaGongfa(Iteminit.gongfa1.get(), 2,20, 2, 3, 1, 1));
        context.register(jichutulafa2, new JichutulafaGongfa(Iteminit.gongfa2.get(), 3,30, 2, 3, 1, 1));
        context.register(jichutulafa3, new JichutulafaGongfa(Iteminit.gongfa3.get(), 4,50, 2, 3, 1, 1));
        context.register(jichutulafa4, new JichutulafaGongfa(Iteminit.gongfa4.get(), 5,80, 2, 3, 1, 1));
    }
}
