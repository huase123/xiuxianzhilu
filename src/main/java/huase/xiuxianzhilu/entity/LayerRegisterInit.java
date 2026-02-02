package huase.xiuxianzhilu.entity;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.entity.moster.chilingshuishe.ChilingshuisheModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ModMain.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LayerRegisterInit {
	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ChilingshuisheModel.LAYER_LOCATION, ChilingshuisheModel::createBodyLayer);
	}
}
