package huase.xiuxianzhilu.blocks.functions.lianqiding;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EnderDragonRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class LianqidingBlockEntityRenderer implements BlockEntityRenderer<LianqidingBlockEntity> {
    public LianqidingBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(LianqidingBlockEntity pEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {



        Entity prent = pEntity.getPlayer();
        if(prent != null){
            BlockPos goalblockpos = prent.getOnPos();
            BlockPos blockPos = pEntity.getBlockPos();

            float f3 = (float)goalblockpos.getX() + 0.5F;
            float f4 = (float)goalblockpos.getY() + 0.5F;
            float f5 = (float)goalblockpos.getZ() + 0.5F;
            float f6 = (float)((double)f3 - blockPos.getX());
            float f7 = (float)((double)f4 - blockPos.getY());
            float f8 = (float)((double)f5 - blockPos.getZ());
            pPoseStack.translate(f6, f7, f8);
            EnderDragonRenderer.renderCrystalBeams(-f6, -f7 + 0.1f, -f8, pPartialTick, prent.tickCount, pPoseStack, pBuffer, pPackedLight);
        }
    }

    private static final ResourceLocation EVOKER_ILLAGER = new ResourceLocation("textures/entity/end_crystal/end_crystal.png");
}
