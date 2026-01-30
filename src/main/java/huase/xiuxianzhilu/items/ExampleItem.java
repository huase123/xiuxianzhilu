package huase.xiuxianzhilu.items;

import huase.xiuxianzhilu.items.danyao.UseStats;
import huase.xiuxianzhilu.worlds.levelstem.LevelStemGen;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

/**
 * - @description:ExampleItem类
 */
public class ExampleItem extends Item {

    public ExampleItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

//        pPlayer.move(MoverType.PISTON,new Vec3(10,0,0));
//        pPlayer.setPos(10,0,0);

        Vec3 vec3 = new Vec3(10,0,0);
//        pPlayer.setDeltaMovement(pPlayer.getDeltaMovement().add(vec3.normalize().scale(0.5D)));
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        BlockHitResult blockhitresult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.NONE);

        pPlayer.awardStat(UseStats.danyaoused.get().get(this));
        if(!pPlayer.level().isClientSide){
//            PlayerCapability capability = (PlayerCapability) CapabilityUtil.getCapability(pPlayer);
//            DensityFunction densityFunction = capability.getDensityFunction();
//            CapabilityUtil.openLinggen(pPlayer);

//            int value = ((ServerPlayer) pPlayer).getStats().getValue(UseStats.danyaoused.get(), this);
//            pPlayer.sendSystemMessage(Component.translatable("已使用次数："+value));


            ResourceKey<Level> destination = getDestination(pPlayer);
            ServerLevel serverWorld = pPlayer.getCommandSenderWorld().getServer().getLevel(destination);

            pPlayer.changeDimension(serverWorld, new ITeleporter() {
                @Override
                public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
                    return ITeleporter.super.placeEntity(entity, currentWorld, destWorld, yaw, repositionEntity);
                }
            });
        }else {
//            Minecraft.getInstance().gameRenderer.cycleEffect();
        }



        return InteractionResultHolder.consume(itemstack);
    }

    private static ResourceKey<Level> getDestination(Entity entity) {
        return !entity.getCommandSenderWorld().dimension().location().equals(Level.OVERWORLD.location())
                ? Level.OVERWORLD : ResourceKey.create(Registries.DIMENSION, LevelStemGen.XIUXIANJIE.location());
    }
}
