package huase.xiuxianzhilu.entity.moster.huanlinghu;

import com.mojang.blaze3d.vertex.PoseStack;
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
public class HuanlinghuRender<T extends Mob, M extends EntityModel<T>> extends MobRenderer{
    public HuanlinghuRender(EntityRendererProvider.Context context) {
        super(context, new HuanlinghuModel(context.bakeLayer(HuanlinghuModel.LAYER_LOCATION)), 1.0F);
    }


    public void render(Mob pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity pEntity) {
        return HuanlinghuModel.LAYER_LOCATION.getModel();
    }
}
