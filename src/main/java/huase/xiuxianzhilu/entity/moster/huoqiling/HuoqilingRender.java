package huase.xiuxianzhilu.entity.moster.huoqiling;

import com.mojang.blaze3d.vertex.PoseStack;
import huase.xiuxianzhilu.entity.moster.chilingshuishe.ChilingshuisheModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;

/**
 * - @description:ChilingshuisheRender类
 */
public class HuoqilingRender<T extends Mob, M extends EntityModel<T>> extends MobRenderer{
    public HuoqilingRender(EntityRendererProvider.Context context) {
        super(context, new HuoqilingModel(context.bakeLayer(HuoqilingModel.LAYER_LOCATION)), 1.0F);
    }


    public void render(Mob pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity pEntity) {
        return HuoqilingModel.LAYER_LOCATION.getModel();
    }
}
