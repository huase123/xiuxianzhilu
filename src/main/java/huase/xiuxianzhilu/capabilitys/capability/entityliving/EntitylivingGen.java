package huase.xiuxianzhilu.capabilitys.capability.entityliving;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.entityliving.entitylivings.EntitylivingSample;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import huase.xiuxianzhilu.entity.EntityInit;
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
public class EntitylivingGen {
    public static final ResourceKey<Registry<Entitylivingabstract>> entityliving_key = ResourceKey.createRegistryKey(ModMain.prefix("entityliving_key"));
    public static final DeferredRegister<Entitylivingabstract> entityliving_key_keyBase_REGISTER = DeferredRegister.create(entityliving_key, ModMain.MODID);

    public static final Supplier<IForgeRegistry<Entitylivingabstract>> entityliving_key_key_Supplier_REGISTRY = entityliving_key_keyBase_REGISTER.makeRegistry(() -> new RegistryBuilder<Entitylivingabstract>().allowModification().disableSync());

    public static final Codec<Entitylivingabstract> CODEC = EntitylivingTypesInIt.CODEC.dispatch("entityliving_key_type", Entitylivingabstract::getType, EntitylivingType::getCodec);
    public static final Codec<Holder<Entitylivingabstract>> HOLDER_CODEC = RegistryFileCodec.create(entityliving_key, CODEC, true);

    public static final ResourceKey<Entitylivingabstract> chilingshuishe      = registerKey("chilingshuishe");
    public static ResourceKey<Entitylivingabstract> registerKey(String name) {
        return ResourceKey.create(entityliving_key,ModMain.prefix(name));
    }


    public static void bootstrap(BootstapContext<Entitylivingabstract> context) {
        HolderGetter<LingxiuJingjieSample> lookup = context.lookup(LingxiujingjieGen.lingxiu_jingjie_key);
        context.register(chilingshuishe    , new EntitylivingSample(EntityInit.chilingshuishe.get(),lookup.getOrThrow(LingxiujingjieGen.lianqi   ),2.0f,30,3,3,3,3,3,3,3,3,3));

    }
}
