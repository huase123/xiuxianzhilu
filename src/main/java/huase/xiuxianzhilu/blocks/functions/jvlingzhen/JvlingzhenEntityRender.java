package huase.xiuxianzhilu.blocks.functions.jvlingzhen;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EnderDragonRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class JvlingzhenEntityRender extends EntityRenderer<JvlingzhenEntity> {
    public JvlingzhenEntityRender(EntityRendererProvider.Context context) {
        super(context);
    }

    public void render(JvlingzhenEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {

//        pMatrixStack.pushPose();
//        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
//        pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot())));
//        int i = 0;
//        float f = 0.0F;
//        float f1 = 0.5F;
//        float f2 = 0.0F;
//        float f3 = 0.15625F;
//        float f4 = 0.0F;
//        float f5 = 0.15625F;
//        float f6 = 0.15625F;
//        float f7 = 0.3125F;
//        float f8 = 0.05625F;
//        float f9 = 0- pPartialTicks;
//        if (f9 > 0.0F) {
//            float f10 = -Mth.sin(f9 * 3.0F) * f9;
//            pMatrixStack.mulPose(Axis.ZP.rotationDegrees(f10));
//        }
//
//        pMatrixStack.mulPose(Axis.XP.rotationDegrees(45.0F));
//        pMatrixStack.scale(0.05625F, 0.05625F, 0.05625F);
//        pMatrixStack.translate(-4.0F, 0.0F, 0.0F);
//        VertexConsumer vertexconsumer = pBuffer.getBuffer(RenderType.entityCutout(this.getTextureLocation(pEntity)));
//        PoseStack.Pose posestack$pose = pMatrixStack.last();
//        Matrix4f matrix4f = posestack$pose.pose();
//        Matrix3f matrix3f = posestack$pose.normal();
//        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, -2, -2, 0.0F, 0.15625F, -1, 0, 0, pPackedLight);
//        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, -2, 2, 0.15625F, 0.15625F, -1, 0, 0, pPackedLight);
//        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, 2, 2, 0.15625F, 0.3125F, -1, 0, 0, pPackedLight);
//        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, 2, -2, 0.0F, 0.3125F, -1, 0, 0, pPackedLight);
//        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, 2, -2, 0.0F, 0.15625F, 1, 0, 0, pPackedLight);
//        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, 2, 2, 0.15625F, 0.15625F, 1, 0, 0, pPackedLight);
//        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, -2, 2, 0.15625F, 0.3125F, 1, 0, 0, pPackedLight);
//        this.vertex(matrix4f, matrix3f, vertexconsumer, -7, -2, -2, 0.0F, 0.3125F, 1, 0, 0, pPackedLight);
//
//        for(int j = 0; j < 4; ++j) {
//            pMatrixStack.mulPose(Axis.XP.rotationDegrees(90.0F));
//            this.vertex(matrix4f, matrix3f, vertexconsumer, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, pPackedLight);
//            this.vertex(matrix4f, matrix3f, vertexconsumer, 8, -2, 0, 0.5F, 0.0F, 0, 1, 0, pPackedLight);
//            this.vertex(matrix4f, matrix3f, vertexconsumer, 8, 2, 0, 0.5F, 0.15625F, 0, 1, 0, pPackedLight);
//            this.vertex(matrix4f, matrix3f, vertexconsumer, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, pPackedLight);
//        }
//
//        pMatrixStack.popPose();
        Entity prent = pEntity.getprentEntity();

        if(prent != null){
            BlockPos blockpos = pEntity.getOnPos();


            float f3 = (float)blockpos.getX() + 0.5F;
            float f4 = (float)blockpos.getY() + 0.5F;
            float f5 = (float)blockpos.getZ() + 0.5F;
            float f6 = (float)((double)f3 - pEntity.getX());
            float f7 = (float)((double)f4 - pEntity.getY());
            float f8 = (float)((double)f5 - pEntity.getZ());
            pMatrixStack.translate(f6, f7, f8);
            EnderDragonRenderer.renderCrystalBeams(-f6, -f7 + 0.1f, -f8, pPartialTicks, pEntity.tickCount, pMatrixStack, pBuffer, pPackedLight);
        }

    }

    public void vertex(Matrix4f pMatrix, Matrix3f pNormal, VertexConsumer pConsumer, int pX, int pY, int pZ, float pU, float pV, int pNormalX, int pNormalZ, int pNormalY, int pPackedLight) {
        pConsumer.vertex(pMatrix, (float)pX, (float)pY, (float)pZ).color(255, 255, 255, 255).uv(pU, pV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(pPackedLight).normal(pNormal, (float)pNormalX, (float)pNormalY, (float)pNormalZ).endVertex();
    }

    private static final ResourceLocation EVOKER_ILLAGER = new ResourceLocation("textures/entity/illager/evoker.png");
    @Override
    public ResourceLocation getTextureLocation(JvlingzhenEntity pEntity) {
        return EVOKER_ILLAGER;
    }
}
