package huase.xiuxianzhilu.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

/**
 * - @description:renderapi类
 */
public class RenderApi {
    public static final ResourceLocation CRYSTAL_BEAM_LOCATION = new ResourceLocation("textures/entity/beacon_beam.png");
    private static final RenderType BEAM = RenderType.beaconBeam(CRYSTAL_BEAM_LOCATION,true);
    public static void renderCrystalBeams(float size,float sizegoal, int alpha, float pX, float pY, float pZ, float pPartialTick, int pTickCount, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        float f = Mth.sqrt(pX * pX + pZ * pZ);
        float f1 = Mth.sqrt(pX * pX + pY * pY + pZ * pZ);
        pPoseStack.pushPose();
        pPoseStack.translate(0.0F, 2.0F, 0.0F);
        pPoseStack.mulPose(Axis.YP.rotation((float)(-Math.atan2((double)pZ, (double)pX)) - ((float)Math.PI / 2F)));
        pPoseStack.mulPose(Axis.XP.rotation((float)(-Math.atan2((double)f, (double)pY)) - ((float)Math.PI / 2F)));
        VertexConsumer vertexconsumer = pBuffer.getBuffer(BEAM);
        float f2 = Mth.frac(-((float)pTickCount + pPartialTick) * 0.01F);
        float f3 = f2+1;
        int i = 8;
        float f4 = 0.0F;
        float f5 = size;
        float f6 = 0.0F;
        PoseStack.Pose posestack$pose = pPoseStack.last();
        Matrix4f matrix4f = posestack$pose.pose();
        Matrix3f matrix3f = posestack$pose.normal();

        for(int j = 1; j <= 8; ++j) {
            float f7 = Mth.sin((float)j * ((float)Math.PI * 2F) / 8.0F) *size;
            float f8 = Mth.cos((float)j * ((float)Math.PI * 2F) / 8.0F) * size;
            float f9 = 1.0f;
            vertexconsumer.vertex(matrix4f, f4 , f5 , 0.0F)                                         .color(100, 100, 255, alpha)    .uv(f6, f2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(pPackedLight).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
    vertexconsumer.vertex(matrix4f, f4*sizegoal, f5*sizegoal, f1)                               .color(255, 255, 255, alpha)  .uv(f6, f3).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(pPackedLight).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
    vertexconsumer.vertex(matrix4f, f7*sizegoal, f8*sizegoal, f1)                               .color(255, 255, 255, alpha)  .uv(f9, f3).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(pPackedLight).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
            vertexconsumer.vertex(matrix4f, f7 , f8 , 0.0F)                                         .color(100, 100, 255, alpha)    .uv(f9, f2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(pPackedLight).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
            f4 = f7;
            f5 = f8;
        }

        pPoseStack.popPose();
    }
}

