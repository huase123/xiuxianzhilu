package huase.xiuxianzhilu.blocks;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.functions.jvlingzhen.JvlingzhenBlockEntity;
import huase.xiuxianzhilu.blocks.functions.liandanlu.LiandanluBlockEntity;
import huase.xiuxianzhilu.blocks.functions.lianqiding.LianqidingBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:BlockEntitiesinit类
 */
public class BlockEntitiesinit {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ModMain.MODID);

    public static final RegistryObject<BlockEntityType<JvlingzhenBlockEntity>> jvlingzhenblockentity =
            BLOCK_ENTITIES.register("jvlingzhenblockentity", () ->
                    BlockEntityType.Builder.of(JvlingzhenBlockEntity::new, BlockInit.jvlingzhen0.get()).build(null));


    public static final RegistryObject<BlockEntityType<LianqidingBlockEntity>> lianqidingblockentity =
            BLOCK_ENTITIES.register("lianqidingblockentity", () ->
                    BlockEntityType.Builder.of(LianqidingBlockEntity::new
                            , BlockInit.lianqiding0.get()
                            , BlockInit.lianqiding1.get()
                            , BlockInit.lianqiding2.get()
                            , BlockInit.lianqiding3.get()
                    ).build(null));

    public static final RegistryObject<BlockEntityType<LiandanluBlockEntity>> liandanlublockentity =
            BLOCK_ENTITIES.register("liandanlublockentity", () ->
                    BlockEntityType.Builder.of(LiandanluBlockEntity::new
                            , BlockInit.liandanlu0.get()
                            , BlockInit.liandanlu1.get()
                            , BlockInit.liandanlu2.get()
                            , BlockInit.liandanlu3.get()
                    ).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }


}
