package huase.xiuxianzhilu.items;

import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiuJingjieInit;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjie;
import net.minecraft.core.Registry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

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
        Registry<LingxiuJingjie> lingxiuJingjies = pPlayer.level().registryAccess().registryOrThrow(LingxiuJingjieInit.LINGXIUJINGJIE_KEY);
        LingxiuJingjie lingxiuJingjie = pPlayer.level().registryAccess().registryOrThrow(LingxiuJingjieInit.LINGXIUJINGJIE_KEY).get(LingxiuJingjieInit.lianqi);

        System.out.println(lingxiuJingjie.toString());
        return InteractionResultHolder.consume(itemstack);
    }

}
