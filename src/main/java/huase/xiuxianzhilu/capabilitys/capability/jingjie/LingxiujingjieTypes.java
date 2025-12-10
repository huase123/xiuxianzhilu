package huase.xiuxianzhilu.capabilitys.capability.jingjie;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjie0;
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
public class LingxiujingjieTypes {

    public static final ResourceKey<Registry<LingxiujingjieType>> lingxiu_jingjie_type = ResourceKey.createRegistryKey(ModMain.prefix("lingxiu_jingjie_type"));
    public static final DeferredRegister<LingxiujingjieType> BIOME_LAYER_TYPES_REGISTER = DeferredRegister.create(lingxiu_jingjie_type, ModMain.MODID);
    public static final Supplier<IForgeRegistry<LingxiujingjieType>> REGISTRY = BIOME_LAYER_TYPES_REGISTER.makeRegistry(() -> new RegistryBuilder<LingxiujingjieType>().allowModification().disableSync());
    public static final Codec<LingxiujingjieType> CODEC = ExtraCodecs.lazyInitializedCodec(() -> REGISTRY.get().getCodec());

    public static final RegistryObject<LingxiujingjieType> lianqi_type = registerType("lianqi_type", () -> () -> LingxiuJingjie0.CODEC);

    private static RegistryObject<LingxiujingjieType> registerType(String name, Supplier<LingxiujingjieType> factory) {
        return BIOME_LAYER_TYPES_REGISTER.register(name, factory);
    }
}
