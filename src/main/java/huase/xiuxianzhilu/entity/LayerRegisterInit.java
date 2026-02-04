package huase.xiuxianzhilu.entity;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.entity.moster.bingfenghuang.BingfenghuangModel;
import huase.xiuxianzhilu.entity.moster.chilingshuishe.ChilingshuisheModel;
import huase.xiuxianzhilu.entity.moster.huanduzhu.HuanduzhuModel;
import huase.xiuxianzhilu.entity.moster.huanlinghu.HuanlinghuModel;
import huase.xiuxianzhilu.entity.moster.huoqiling.HuoqilingModel;
import huase.xiuxianzhilu.entity.moster.kunpeng.KunpengModel;
import huase.xiuxianzhilu.entity.moster.shayingmoxie.ShayingmoxieModel;
import huase.xiuxianzhilu.entity.moster.xiushi.XiushiModel;
import huase.xiuxianzhilu.entity.moster.xueyichanglang.XueyichanglangModel;
import huase.xiuxianzhilu.entity.moster.xvanbingjvxiong.XvanbingjvxiongModel;
import huase.xiuxianzhilu.entity.moster.youmingguishou.YoumingguishouModel;
import huase.xiuxianzhilu.entity.moster.zuoying.ZuoyingModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ModMain.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LayerRegisterInit {
	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ChilingshuisheModel.LAYER_LOCATION, ChilingshuisheModel::createBodyLayer);
		event.registerLayerDefinition(HuanlinghuModel.LAYER_LOCATION, HuanlinghuModel::createBodyLayer);
		event.registerLayerDefinition(XueyichanglangModel.LAYER_LOCATION, XueyichanglangModel::createBodyLayer);
		event.registerLayerDefinition(YoumingguishouModel.LAYER_LOCATION, YoumingguishouModel::createBodyLayer);
		event.registerLayerDefinition(ShayingmoxieModel.LAYER_LOCATION, ShayingmoxieModel::createBodyLayer);
		event.registerLayerDefinition(HuanduzhuModel.LAYER_LOCATION, HuanduzhuModel::createBodyLayer);
		event.registerLayerDefinition(ZuoyingModel.LAYER_LOCATION, ZuoyingModel::createBodyLayer);
		event.registerLayerDefinition(HuoqilingModel.LAYER_LOCATION, HuoqilingModel::createBodyLayer);
		event.registerLayerDefinition(XvanbingjvxiongModel.LAYER_LOCATION, XvanbingjvxiongModel::createBodyLayer);
		event.registerLayerDefinition(BingfenghuangModel.LAYER_LOCATION, BingfenghuangModel::createBodyLayer);
		event.registerLayerDefinition(KunpengModel.LAYER_LOCATION, KunpengModel::createBodyLayer);
		event.registerLayerDefinition(XiushiModel.LAYER_LOCATION, XiushiModel::createBodyLayer);
	}
}
