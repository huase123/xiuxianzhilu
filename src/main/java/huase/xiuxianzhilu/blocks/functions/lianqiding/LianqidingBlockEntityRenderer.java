package huase.xiuxianzhilu.blocks.functions.lianqiding;

import com.mojang.blaze3d.vertex.PoseStack;
import huase.xiuxianzhilu.util.RenderApi;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class LianqidingBlockEntityRenderer implements BlockEntityRenderer<LianqidingBlockEntity> {
    public LianqidingBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(LianqidingBlockEntity pEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {

        Entity prent = pEntity.getPlayer();

        if(prent != null){
            float f6 = (float)(Mth.lerp(pPartialTick, prent.xo, prent.getX()) - pEntity.getBlockPos().getX());
            float f7 = (float)(Mth.lerp(pPartialTick, prent.yo, prent.getY()) - pEntity.getBlockPos().getY()) - 1.0f;
            float f8 = (float)(Mth.lerp(pPartialTick, prent.zo, prent.getZ()) - pEntity.getBlockPos().getZ());

            pPoseStack.pushPose();
            pPoseStack.translate(f6, f7, f8);
            RenderApi.renderCrystalBeams(0.14f,0.6f,255,-f6+0.5f, -f7- 1.0f, -f8+0.5f, pPartialTick, prent.tickCount, pPoseStack, pBuffer, pPackedLight);
            RenderApi.renderCrystalBeams(0.20f,0.6f,150,-f6+0.5f, -f7- 1.0f, -f8+0.5f, pPartialTick, prent.tickCount, pPoseStack, pBuffer, pPackedLight);
            RenderApi.renderCrystalBeams(0.4f,0.6f,55,  -f6+0.5f, -f7- 1.0f, -f8+0.5f, pPartialTick, prent.tickCount, pPoseStack, pBuffer, pPackedLight);

            pPoseStack.popPose();
        }
    }

    public boolean shouldRenderOffScreen(LianqidingBlockEntity pBlockEntity) {
        return true;
    }

    public int getViewDistance() {
        return 256;
    }

    public boolean shouldRender(LianqidingBlockEntity pBlockEntity, Vec3 pCameraPos) {
        return Vec3.atCenterOf(pBlockEntity.getBlockPos()).multiply(1.0D, 0.0D, 1.0D).closerThan(pCameraPos.multiply(1.0D, 0.0D, 1.0D), (double)this.getViewDistance());
    }
}
