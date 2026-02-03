package huase.xiuxianzhilu.entity.moster.shayingmoxie;

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
public class ShayingmoxieRender<T extends Mob, M extends EntityModel<T>> extends MobRenderer{
    public ShayingmoxieRender(EntityRendererProvider.Context context) {
        super(context, new ShayingmoxieModel(context.bakeLayer(ShayingmoxieModel.LAYER_LOCATION)), 1.0F);
    }


    public void render(Mob pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity pEntity) {
        return ShayingmoxieModel.LAYER_LOCATION.getModel();
    }
}
