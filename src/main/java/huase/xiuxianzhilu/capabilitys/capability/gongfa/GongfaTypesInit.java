package huase.xiuxianzhilu.capabilitys.capability.gongfa;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.gongfas.JichutulafaGongfa;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.ExtraCodecs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * - @description:GongfaTypesInit类
 */
public class GongfaTypesInit {

    public static final ResourceKey<Registry<GongfaType>> gongfa_type_key = ResourceKey.createRegistryKey(ModMain.prefix("gongfa_type_key"));
    public static final DeferredRegister<GongfaType> gongfa_type_key_REGISTER = DeferredRegister.create(gongfa_type_key, ModMain.MODID);
    public static final Supplier<IForgeRegistry<GongfaType>> REGISTRY = gongfa_type_key_REGISTER.makeRegistry(() -> new RegistryBuilder<GongfaType>().allowModification().disableSync());
    public static final Codec<GongfaType> CODEC = ExtraCodecs.lazyInitializedCodec(() -> REGISTRY.get().getCodec());

    public static final RegistryObject<GongfaType> jichutulafagongfa_type = registerType("jichutulafagongfa_type", () -> () -> JichutulafaGongfa.CODEC);
//    public static final RegistryObject<GongfaType> fannal_type = registerType("fannal_type", () -> () -> LingxiujingjieFinal.CODEC);

    private static RegistryObject<GongfaType> registerType(String name, Supplier<GongfaType> factory) {
        return gongfa_type_key_REGISTER.register(name, factory);
    }
}
