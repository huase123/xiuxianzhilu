package huase.xiuxianzhilu.entity.functions.putuan;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import huase.xiuxianzhilu.items.Iteminit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class PutuanRender extends EntityRenderer<PutuanEntity> {
    public PutuanRender(EntityRendererProvider.Context context) {
        super(context);
    }

    ItemStack itemstack = new ItemStack(Iteminit.putuan.get());
    public void render(PutuanEntity entity, float v, float v1, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {

        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        poseStack.pushPose();
//        poseStack.translate(0.5f, 1.10f, 0.5f);
//        poseStack.scale(0.35f, 0.35f, 0.35f);
        poseStack.mulPose(Axis.XP.rotationDegrees(90));

        itemRenderer.renderStatic(itemstack, ItemDisplayContext.FIXED, 15728880,
                OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, entity.level(), 1);
        poseStack.popPose();
    }
    @Override
    public ResourceLocation getTextureLocation(PutuanEntity entity) {
        return null;
    }
}
