package huase.xiuxianzhilu.blocks;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.functions.jvlingzhen.JvlingzhenBlockEntityRenderer;
import huase.xiuxianzhilu.blocks.functions.liandanlu.LiandanluBlockEntityRenderer;
import huase.xiuxianzhilu.blocks.functions.lianqiding.LianqidingBlockEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * - @description:BlockEntitiesRenderinit类
 */

@Mod.EventBusSubscriber(modid = ModMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockEntitiesRenderinit {

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
//            event.registerBlockEntityRenderer(ModelBlockEntitiesinit.Pot_ENTITY.get(), PotBlockEntityRenderer::new);
//        EntityRenderers.register(BlockCreateEntityInit.jvlingzhenentity.get(), JvlingzhenEntityRender::new);


        event.registerBlockEntityRenderer(BlockEntitiesinit.jvlingzhenblockentity.get(), JvlingzhenBlockEntityRenderer::new);

        event.registerBlockEntityRenderer(BlockEntitiesinit.lianqidingblockentity.get(), LianqidingBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntitiesinit.liandanlublockentity.get(), LiandanluBlockEntityRenderer::new);
    }
}
