package huase.xiuxianzhilu.entity;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.entity.functions.putuan.PutuanRender;
import huase.xiuxianzhilu.entity.moster.bingfenghuang.BingfenghuangRender;
import huase.xiuxianzhilu.entity.moster.chilingshuishe.ChilingshuisheRender;
import huase.xiuxianzhilu.entity.moster.huanduzhu.HuanduzhuRender;
import huase.xiuxianzhilu.entity.moster.huanlinghu.HuanlinghuRender;
import huase.xiuxianzhilu.entity.moster.huoqiling.HuoqilingRender;
import huase.xiuxianzhilu.entity.moster.kunpeng.KunpengRender;
import huase.xiuxianzhilu.entity.moster.shayingmoxie.ShayingmoxieRender;
import huase.xiuxianzhilu.entity.moster.xiushi.XiushiRender;
import huase.xiuxianzhilu.entity.moster.xueyichanglang.XueyichanglangRender;
import huase.xiuxianzhilu.entity.moster.xvanbingjvxiong.XvanbingjvxiongRender;
import huase.xiuxianzhilu.entity.moster.youmingguishou.YoumingguishouRender;
import huase.xiuxianzhilu.entity.moster.zuoying.ZuoyingRender;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * - @description:EntityRenderInit类
 */
@Mod.EventBusSubscriber(modid = ModMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityRenderInit {

    @Mod.EventBusSubscriber(modid = ModMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(EntityInit.putuanentity.get(), PutuanRender::new);
            event.registerEntityRenderer(EntityInit.mosterbaseentity.get(), PutuanRender::new);
            event.registerEntityRenderer(EntityInit.chilingshuishe.get(), ChilingshuisheRender::new);
            event.registerEntityRenderer(EntityInit.huanlinghu          .get(), HuanlinghuRender::new);
            event.registerEntityRenderer(EntityInit.xueyichanglang          .get(), XueyichanglangRender::new);
            event.registerEntityRenderer(EntityInit.youmingguishou          .get(), YoumingguishouRender::new);
            event.registerEntityRenderer(EntityInit.shayingmoxie            .get(), ShayingmoxieRender::new);
            event.registerEntityRenderer(EntityInit.huanduzhu           .get(), HuanduzhuRender::new);
            event.registerEntityRenderer(EntityInit.zuoying         .get(), ZuoyingRender::new);
            event.registerEntityRenderer(EntityInit.huoqiling           .get(), HuoqilingRender::new);
            event.registerEntityRenderer(EntityInit.xvanbingjvxiong         .get(), XvanbingjvxiongRender::new);
            event.registerEntityRenderer(EntityInit.bingfenghuang           .get(), BingfenghuangRender::new);
            event.registerEntityRenderer(EntityInit.kunpeng         .get(), KunpengRender::new);
            event.registerEntityRenderer(EntityInit.xiushi.get(), XiushiRender::new);


        }
    }
}
