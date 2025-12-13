package huase.xiuxianzhilu.blocks;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.functions.jvlingzhen.JvlingzhenEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:EntityInit类
 */
public class BlockCreateEntityInit {

    public static final DeferredRegister<EntityType<?>> BlockCreate_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ModMain.MODID);


    public static final RegistryObject<EntityType<JvlingzhenEntity>> jvlingzhenentity = registerEntity("jvlingzhenentity",
            EntityType.Builder.<JvlingzhenEntity>of(JvlingzhenEntity::new, MobCategory.MISC).sized(1.3964844F, 1.4F));

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity( String entityName,EntityType.Builder<T> builder) {
        return BlockCreate_ENTITY_TYPES.register(entityName, () -> builder.build(entityName));
    }


}
