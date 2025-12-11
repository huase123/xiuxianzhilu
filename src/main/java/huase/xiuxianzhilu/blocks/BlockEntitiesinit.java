package huase.xiuxianzhilu.blocks;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.functions.ZhenjiBlockEntity;
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

    public static final RegistryObject<BlockEntityType<ZhenjiBlockEntity>> zhenjiblockentity =
            BLOCK_ENTITIES.register("zhenjiblockentity", () ->
                    BlockEntityType.Builder.of(ZhenjiBlockEntity::new, BlockInit.zhenji.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }


}
