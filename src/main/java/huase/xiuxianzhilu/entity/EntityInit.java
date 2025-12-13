package huase.xiuxianzhilu.entity;

import huase.xiuxianzhilu.ModMain;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:EntityInit类
 */
public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ModMain.MODID);



    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity( String entityName,EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(entityName, () -> builder.build(entityName));
    }


}
