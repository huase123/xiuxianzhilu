package huase.xiuxianzhilu.items.functions;

import huase.xiuxianzhilu.worlds.levelstem.LevelStemGen;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

/**
 * - @description:ExampleItem类
 */
public class TPFuItem extends Item {

    public TPFuItem() {
        super(new Item.Properties().stacksTo(16));
    }
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        pPlayer.getCooldowns().addCooldown(this, 1000);
        if (!pLevel.isClientSide) {

            ResourceKey<Level> destination = !pPlayer.getCommandSenderWorld().dimension().location().equals(Level.OVERWORLD.location())
                    ? Level.OVERWORLD : ResourceKey.create(Registries.DIMENSION, LevelStemGen.XIUXIANJIE.location());
            ServerLevel serverWorld = pPlayer.getCommandSenderWorld().getServer().getLevel(destination);

            pPlayer.changeDimension(serverWorld, new ITeleporter() {
                @Override
                public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
                    return ITeleporter.super.placeEntity(entity, currentWorld, destWorld, yaw, repositionEntity);
                }
            });
        }
        pPlayer.getCooldowns().addCooldown(this, 1000);
        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
