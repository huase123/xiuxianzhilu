package huase.xiuxianzhilu.blocks.functions.jvlingzhen;

import com.mojang.blaze3d.vertex.PoseStack;
import huase.xiuxianzhilu.util.RenderApi;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

public class JvlingzhenBlockEntityRenderer implements BlockEntityRenderer<JvlingzhenBlockEntity> {
    public JvlingzhenBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(JvlingzhenBlockEntity pEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {

        for (BlockPos blockPos : pEntity.getPrentBlockPos()) {
            float f6 = blockPos.getX() - pEntity.getBlockPos().getX();
            float f7 = blockPos.getY() - pEntity.getBlockPos().getY();
            float f8 = blockPos.getZ() - pEntity.getBlockPos().getZ();
            pPoseStack.pushPose();
            pPoseStack.translate(0.5f, 0.5, 0.5);
            RenderApi.renderCrystalBeams(0.14f,0.6f,255,f6+0.0f, f7+0.0f, f8+0.0f, pPartialTick, (int) pEntity.getLevel().getGameTime(), pPoseStack, pBuffer, pPackedLight);
            RenderApi.renderCrystalBeams(0.20f,0.6f,150,f6+0.0f, f7+0.0f, f8+0.0f, pPartialTick, (int) pEntity.getLevel().getGameTime(), pPoseStack, pBuffer, pPackedLight);
            RenderApi.renderCrystalBeams(0.40f,0.6f,55,  f6+0.0f, f7+0.0f, f8+0.0f, pPartialTick, (int) pEntity.getLevel().getGameTime(), pPoseStack, pBuffer, pPackedLight);
            pPoseStack.popPose();
        }
    }

    public boolean shouldRenderOffScreen(JvlingzhenBlockEntity pBlockEntity) {
        return true;
    }

    public int getViewDistance() {
        return 256;
    }

    public boolean shouldRender(JvlingzhenBlockEntity pBlockEntity, Vec3 pCameraPos) {
        return Vec3.atCenterOf(pBlockEntity.getBlockPos()).multiply(1.0D, 0.0D, 1.0D).closerThan(pCameraPos.multiply(1.0D, 0.0D, 1.0D), (double)this.getViewDistance());
    }
}
