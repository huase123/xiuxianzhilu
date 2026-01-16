package huase.xiuxianzhilu.capabilitys.capability.fabao;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.fabao.fabaos.FabaaoSample;
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
public class FabaoTypesInIt {

    public static final ResourceKey<Registry<FabaoType>> fabao_type = ResourceKey.createRegistryKey(ModMain.prefix("fabao_type"));
    public static final DeferredRegister<FabaoType> fabao_type_REGISTER = DeferredRegister.create(fabao_type, ModMain.MODID);
    public static final Supplier<IForgeRegistry<FabaoType>> REGISTRY = fabao_type_REGISTER.makeRegistry(() -> new RegistryBuilder<FabaoType>().allowModification().disableSync());
    public static final Codec<FabaoType> CODEC = ExtraCodecs.lazyInitializedCodec(() -> REGISTRY.get().getCodec());

    public static final RegistryObject<FabaoType> fabao_sample_type = registerType("fabao_sample_type", () -> () -> FabaaoSample.CODEC);

    private static RegistryObject<FabaoType> registerType(String name, Supplier<FabaoType> factory) {
        return fabao_type_REGISTER.register(name, factory);
    }
}
