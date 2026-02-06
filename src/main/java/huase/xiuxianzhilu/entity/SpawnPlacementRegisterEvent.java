package huase.xiuxianzhilu.entity;

import huase.xiuxianzhilu.ModMain;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.entity.SpawnPlacements.Type.NO_RESTRICTIONS;
import static net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING_NO_LEAVES;

/**
 * - @description:SpawnPlacementRegisterEvent类
 */
@Mod.EventBusSubscriber(modid = ModMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpawnPlacementRegisterEvent {

    @SubscribeEvent
    public static void spawnPlacementRegister(net.minecraftforge.event.entity.SpawnPlacementRegisterEvent event)
    {
//        世界同类生物上线不超过num+num*玩家数/2
        int num = 4;
        for (RegistryObject<EntityType<LivingEntity>> entityTypeRegistryObject : EntityInit.mosterlist) {
            event.register(entityTypeRegistryObject.get()
                    , NO_RESTRICTIONS
                    , MOTION_BLOCKING_NO_LEAVES
//                    , (pEntityType, pServerLevel, pSpawnType, pPos, pRandom) -> pRandom.nextInt(100)==0
                    , (pEntityType, pServerLevel, pSpawnType, pPos, pRandom) ->
                            pServerLevel.getLevel().getEntities(entityTypeRegistryObject.get(), LivingEntity::isAlive).size()<=num+  pServerLevel.getLevel().getPlayers(LivingEntity::isAlive).size()*num/2
                                    && pRandom.nextInt(100)==0
                    , net.minecraftforge.event.entity.SpawnPlacementRegisterEvent.Operation.AND
            );
        }
    }
}
