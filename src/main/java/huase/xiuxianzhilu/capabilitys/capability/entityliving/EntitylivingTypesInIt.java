package huase.xiuxianzhilu.capabilitys.capability.entityliving;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.entityliving.entitylivings.EntitylivingSample;
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
public class EntitylivingTypesInIt {

    public static final ResourceKey<Registry<EntitylivingType>> entityliving_type = ResourceKey.createRegistryKey(ModMain.prefix("entityliving_type"));
    public static final DeferredRegister<EntitylivingType> entityliving_type_REGISTER = DeferredRegister.create(entityliving_type, ModMain.MODID);
    public static final Supplier<IForgeRegistry<EntitylivingType>> REGISTRY = entityliving_type_REGISTER.makeRegistry(() -> new RegistryBuilder<EntitylivingType>().allowModification().disableSync());
    public static final Codec<EntitylivingType> CODEC = ExtraCodecs.lazyInitializedCodec(() -> REGISTRY.get().getCodec());

    public static final RegistryObject<EntitylivingType> entityliving_sample_type = registerType("entityliving_sample_type", () -> () -> EntitylivingSample.CODEC);

    private static RegistryObject<EntitylivingType> registerType(String name, Supplier<EntitylivingType> factory) {
        return entityliving_type_REGISTER.register(name, factory);
    }
}
