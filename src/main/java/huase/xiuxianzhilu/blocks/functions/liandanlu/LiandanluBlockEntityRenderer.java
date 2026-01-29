package huase.xiuxianzhilu.blocks.functions.liandanlu;

import com.mojang.blaze3d.vertex.PoseStack;
import huase.xiuxianzhilu.util.RenderApi;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class LiandanluBlockEntityRenderer implements BlockEntityRenderer<LiandanluBlockEntity> {
    public LiandanluBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(LiandanluBlockEntity pEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {

        Player player = pEntity.getGoalplayer();

        if(player != null){
            float f6 = (float)(Mth.lerp(pPartialTick, player.xo, player.getX()) - pEntity.getBlockPos().getX()) - 0.5f;
            float f7 = (float)(Mth.lerp(pPartialTick, player.yo, player.getY()) - pEntity.getBlockPos().getY())+ 0.5f;
            float f8 = (float)(Mth.lerp(pPartialTick, player.zo, player.getZ()) - pEntity.getBlockPos().getZ()) - 0.5f;
            pPoseStack.pushPose();
            pPoseStack.translate(0.5f, 0.5, 0.5);
            RenderApi.renderCrystalBeams(0.14f,0.6f,255,f6, f7, f8, pPartialTick, -player.tickCount, pPoseStack, pBuffer, pPackedLight);
            RenderApi.renderCrystalBeams(0.20f,0.6f,150,f6, f7, f8, pPartialTick, -player.tickCount, pPoseStack, pBuffer, pPackedLight);
            RenderApi.renderCrystalBeams(0.4f,0.6f,55,  f6, f7, f8, pPartialTick, -player.tickCount, pPoseStack, pBuffer, pPackedLight);
            pPoseStack.popPose();
        }
    }

    public boolean shouldRenderOffScreen(LiandanluBlockEntity pBlockEntity) {
        return true;
    }

    public int getViewDistance() {
        return 256;
    }

    public boolean shouldRender(LiandanluBlockEntity pBlockEntity, Vec3 pCameraPos) {
        return Vec3.atCenterOf(pBlockEntity.getBlockPos()).multiply(1.0D, 0.0D, 1.0D).closerThan(pCameraPos.multiply(1.0D, 0.0D, 1.0D), (double)this.getViewDistance());
    }
}
