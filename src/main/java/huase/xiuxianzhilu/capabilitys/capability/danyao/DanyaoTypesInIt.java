package huase.xiuxianzhilu.capabilitys.capability.danyao;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.danyao.danyaos.DanyaoSample;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.ExtraCodecs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * - @description:LingxiujingjieTypes类
 */
public class DanyaoTypesInIt {

    public static final ResourceKey<Registry<DanyaoType>> danyao_type = ResourceKey.createRegistryKey(ModMain.prefix("danyao_type"));
    public static final DeferredRegister<DanyaoType> danyao_type_REGISTER = DeferredRegister.create(danyao_type, ModMain.MODID);
    public static final Supplier<IForgeRegistry<DanyaoType>> REGISTRY = danyao_type_REGISTER.makeRegistry(() -> new RegistryBuilder<DanyaoType>().allowModification().disableSync());
    public static final Codec<DanyaoType> CODEC = ExtraCodecs.lazyInitializedCodec(() -> REGISTRY.get().getCodec());

    public static final RegistryObject<DanyaoType> danyao_sample_type = registerType("danyao_sample_type", () -> () -> DanyaoSample.CODEC);

    private static RegistryObject<DanyaoType> registerType(String name, Supplier<DanyaoType> factory) {
        return danyao_type_REGISTER.register(name, factory);
    }
}
