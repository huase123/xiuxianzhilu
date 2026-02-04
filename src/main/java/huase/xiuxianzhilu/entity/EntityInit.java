package huase.xiuxianzhilu.entity;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.entity.functions.putuan.PutuanEntity;
import huase.xiuxianzhilu.entity.moster.MosterBaseEntity;
import huase.xiuxianzhilu.entity.moster.bingfenghuang.BingfenghuangEntity;
import huase.xiuxianzhilu.entity.moster.chilingshuishe.ChilingshuisheEntity;
import huase.xiuxianzhilu.entity.moster.huanduzhu.HuanduzhuEntity;
import huase.xiuxianzhilu.entity.moster.huanlinghu.HuanlinghuEntity;
import huase.xiuxianzhilu.entity.moster.huoqiling.HuoqilingEntity;
import huase.xiuxianzhilu.entity.moster.kunpeng.KunpengEntity;
import huase.xiuxianzhilu.entity.moster.shayingmoxie.ShayingmoxieEntity;
import huase.xiuxianzhilu.entity.moster.xiushi.XiushiEntity;
import huase.xiuxianzhilu.entity.moster.xueyichanglang.XueyichanglangEntity;
import huase.xiuxianzhilu.entity.moster.xvanbingjvxiong.XvanbingjvxiongEntity;
import huase.xiuxianzhilu.entity.moster.youmingguishou.YoumingguishouEntity;
import huase.xiuxianzhilu.entity.moster.zuoying.ZuoyingEntity;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

/**
 * - @description:EntityInit类
 */
@Mod.EventBusSubscriber(modid = ModMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ModMain.MODID);
    public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, ModMain.MOD_ID);
    public static final List<RegistryObject<EntityType<LivingEntity>>> mosterlist = new ArrayList<>();


    public static final RegistryObject<EntityType<PutuanEntity>> putuanentity =
            registerEntity("putuanentity",
                    EntityType.Builder.<PutuanEntity>of(PutuanEntity::new, MobCategory.MISC)
                    .updateInterval(Integer.MAX_VALUE)
                    .sized(0.9f, 0.3f));

    public static final RegistryObject<EntityType<MosterBaseEntity>> mosterbaseentity =
            registerEntityAndEgg("mosterbaseentity",
                    EntityType.Builder.of(MosterBaseEntity::new, MobCategory.MISC)
                    .setTrackingRange(10)
                    .sized(0.9f, 1.6f));

    public static final RegistryObject<EntityType<ChilingshuisheEntity>>    chilingshuishe              = registerEntityAndEgg("chilingshuishe"          , EntityType.Builder.of(ChilingshuisheEntity::new, MobCategory.MONSTER).setTrackingRange(10).sized(0.9f, 1.6f));
    public static final RegistryObject<EntityType<HuanlinghuEntity>>        huanlinghu                  = registerEntityAndEgg("huanlinghu"              , EntityType.Builder.of(HuanlinghuEntity::new, MobCategory.MONSTER).setTrackingRange(10).sized(0.9f, 1.6f));
    public static final RegistryObject<EntityType<XueyichanglangEntity>>    xueyichanglang              = registerEntityAndEgg("xueyichanglang"          , EntityType.Builder.of(XueyichanglangEntity::new, MobCategory.MONSTER).setTrackingRange(10).sized(0.9f, 1.6f));
    public static final RegistryObject<EntityType<YoumingguishouEntity>>    youmingguishou              = registerEntityAndEgg("youmingguishou"          , EntityType.Builder.of(YoumingguishouEntity::new, MobCategory.MONSTER).setTrackingRange(10).sized(0.9f, 1.6f));
    public static final RegistryObject<EntityType<ShayingmoxieEntity>>      shayingmoxie                = registerEntityAndEgg("shayingmoxie"            , EntityType.Builder.of(ShayingmoxieEntity::new, MobCategory.MONSTER).setTrackingRange(10).sized(0.9f, 1.6f));
    public static final RegistryObject<EntityType<HuanduzhuEntity>>         huanduzhu                   = registerEntityAndEgg("huanduzhu"               , EntityType.Builder.of(HuanduzhuEntity::new, MobCategory.MONSTER).setTrackingRange(10).sized(0.9f, 1.6f));
    public static final RegistryObject<EntityType<ZuoyingEntity>>           zuoying                     = registerEntityAndEgg("zuoying"                 , EntityType.Builder.of(ZuoyingEntity::new, MobCategory.MONSTER).setTrackingRange(10).sized(0.9f, 1.6f));
    public static final RegistryObject<EntityType<HuoqilingEntity>>         huoqiling                   = registerEntityAndEgg("huoqiling"               , EntityType.Builder.of(HuoqilingEntity::new, MobCategory.MONSTER).setTrackingRange(10).sized(0.9f, 1.6f));
    public static final RegistryObject<EntityType<XvanbingjvxiongEntity>>   xvanbingjvxiong             = registerEntityAndEgg("xvanbingjvxiong"         , EntityType.Builder.of(XvanbingjvxiongEntity::new, MobCategory.MONSTER).setTrackingRange(10).sized(0.9f, 1.6f));
    public static final RegistryObject<EntityType<BingfenghuangEntity>>     bingfenghuang               = registerEntityAndEgg("bingfenghuang"           , EntityType.Builder.of(BingfenghuangEntity::new, MobCategory.MONSTER).setTrackingRange(10).sized(0.9f, 1.6f));
    public static final RegistryObject<EntityType<KunpengEntity>>           kunpeng                     = registerEntityAndEgg("kunpeng"                 , EntityType.Builder.of(KunpengEntity::new, MobCategory.MONSTER).setTrackingRange(10).sized(0.9f, 1.6f));


    public static final RegistryObject<EntityType<XiushiEntity>> xiushi = registerEntityAndEgg("xiushientity"                 , EntityType.Builder.of(XiushiEntity::new, MobCategory.MONSTER).setTrackingRange(10).sized(0.9f, 1.2f));
    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String entityName, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(entityName, () -> builder.build(entityName));
    }



    private static <T extends LivingEntity> RegistryObject<EntityType<T>> registerEntityAndEgg(String entityName, EntityType.Builder<T> builder) {
        RegistryObject<EntityType<T>> register = ENTITY_TYPES.register(entityName, () -> builder.build(entityName));
        mosterlist.add((RegistryObject<EntityType<LivingEntity>>) (RegistryObject<?>) register);

        SPAWN_EGGS.register(entityName + "_spawn_egg", () -> new ForgeSpawnEggItem(() -> (EntityType<? extends Mob>) register.get(), 0x0a0000, 0x00008b, new Item.Properties()));
        return register;
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.4D)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
                .add(Attributes.FOLLOW_RANGE, 20.0D)
//                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                ;
    }

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        mosterlist.stream().forEach(c -> event.put(c.get(),registerAttributes().build()));
    }

}
