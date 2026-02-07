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

    public static final ResourceKey<Entitylivingabstract> chilingshuishe       = registerKey("chilingshuishe");
    public static final ResourceKey<Entitylivingabstract> huanlinghu           = registerKey("huanlinghu");
    public static final ResourceKey<Entitylivingabstract> xueyichanglang       = registerKey("xueyichanglang");
    public static final ResourceKey<Entitylivingabstract> youmingguishou       = registerKey("youmingguishou");
    public static final ResourceKey<Entitylivingabstract> shayingmoxie         = registerKey("shayingmoxie");
    public static final ResourceKey<Entitylivingabstract> huanduzhu            = registerKey("huanduzhu");
    public static final ResourceKey<Entitylivingabstract> zuoying              = registerKey("zuoying");
    public static final ResourceKey<Entitylivingabstract> huoqiling            = registerKey("huoqiling");
    public static final ResourceKey<Entitylivingabstract> xvanbingjvxiong      = registerKey("xvanbingjvxiong");
    public static final ResourceKey<Entitylivingabstract> bingfenghuang        = registerKey("bingfenghuang");
    public static final ResourceKey<Entitylivingabstract> kunpeng              = registerKey("kunpeng");
    public static ResourceKey<Entitylivingabstract> registerKey(String name) {
        return ResourceKey.create(entityliving_key,ModMain.prefix(name));
    }


    public static void bootstrap(BootstapContext<Entitylivingabstract> context) {
        HolderGetter<LingxiuJingjieSample> lookup = context.lookup(LingxiujingjieGen.lingxiu_jingjie_key);
        context.register(chilingshuishe     , new EntitylivingSample(EntityInit.chilingshuishe .get(),lookup.getOrThrow(LingxiujingjieGen.lianqi       ),1f     ,0,0,0,0,0,0,0,0,0,0));
        context.register(huanlinghu         , new EntitylivingSample(EntityInit.huanlinghu     .get(),lookup.getOrThrow(LingxiujingjieGen.lianqi       ),1.5f   ,0,0,0,0,0,0,0,0,0,0));
        context.register(xueyichanglang     , new EntitylivingSample(EntityInit.xueyichanglang .get(),lookup.getOrThrow(LingxiujingjieGen.lianqi       ),2f     ,0,0,0,0,0,0,0,0,0,0));
        context.register(youmingguishou     , new EntitylivingSample(EntityInit.youmingguishou .get(),lookup.getOrThrow(LingxiujingjieGen.zhuji        ),2f     ,0,0,0,0,0,0,0,0,0,0));
        context.register(shayingmoxie       , new EntitylivingSample(EntityInit.shayingmoxie   .get(),lookup.getOrThrow(LingxiujingjieGen.zhuji        ),3f     ,0,0,0,0,0,0,0,0,0,0));
        context.register(huanduzhu          , new EntitylivingSample(EntityInit.huanduzhu      .get(),lookup.getOrThrow(LingxiujingjieGen.zhuji        ),4f     ,0,0,0,0,0,0,0,0,0,0));
        context.register(zuoying            , new EntitylivingSample(EntityInit.zuoying        .get(),lookup.getOrThrow(LingxiujingjieGen.jindan       ),3f     ,0,0,0,0,0,0,0,0,0,0));
        context.register(huoqiling          , new EntitylivingSample(EntityInit.huoqiling      .get(),lookup.getOrThrow(LingxiujingjieGen.jindan       ),4f     ,0,0,0,0,0,0,0,0,0,0));
        context.register(xvanbingjvxiong    , new EntitylivingSample(EntityInit.xvanbingjvxiong.get(),lookup.getOrThrow(LingxiujingjieGen.jindan       ),5f     ,0,0,0,0,0,0,0,0,0,0));
        context.register(bingfenghuang      , new EntitylivingSample(EntityInit.bingfenghuang  .get(),lookup.getOrThrow(LingxiujingjieGen.yuanying     ),4f     ,0,0,0,0,0,0,0,0,0,0));
        context.register(kunpeng            , new EntitylivingSample(EntityInit.kunpeng        .get(),lookup.getOrThrow(LingxiujingjieGen.huashen      ),4f     ,0,0,0,0,0,0,0,0,0,0));

    }
}
