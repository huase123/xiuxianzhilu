package huase.xiuxianzhilu.event.client;

import com.mojang.blaze3d.vertex.PoseStack;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.util.NoiseUse;
import huase.xiuxianzhilu.util.RenderApi;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ReRenderLevelStageEvent {



    @SubscribeEvent
    public static void renderPlayerEventPost(RenderLevelStageEvent event){
        postEvent(event);
    }

    public static final float[] rainxs = new float[1024];
    public static final float[] rainzs = new float[1024];
    private static void postEvent(RenderLevelStageEvent event) {
//        if(!SHConfig.FIRSTPERSONDISPLAY.get())return;
        if (event.getStage() !=RenderLevelStageEvent.Stage.AFTER_ENTITIES )return;

        MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
        PoseStack poseStack = event.getPoseStack();
        Vec3 position = event.getCamera().getPosition();
        float partialTick = event.getPartialTick();
        int renderTick = event.getRenderTick();
        int x0 = Mth.floor(position.x)>>4;
        int y0 = Mth.floor(position.y)>>4;
        int z0 = Mth.floor(position.z)>>4;


        int range = 5;
        for (int i = x0-range; i < x0+range; i++) {
            for (int j = z0-range; j < z0+range; j++) {
                for (int k = 6; k < 10; k++) {
                    double lingliLV = NoiseUse.getLingliDensity(Minecraft.getInstance().level, i, k, j);
                    if(lingliLV>=0){
                        int i1 = (i << 4)+8;
                        int j1 = (j << 4)+8;
                        int k1 = (k << 4)+8;
                        poseStack.pushPose();
                        poseStack.translate(i1-position.x, k1-position.y, j1-position.z);
                        RenderApi.renderCrystalBeams(0.1f,80.1f,150,0f, 10.0f, 0f, partialTick, renderTick, poseStack, bufferSource, 15728880);
                        RenderApi.renderCrystalBeams(0.1f,1.0f,250,0f, 10.0f, 0f, partialTick, renderTick, poseStack, bufferSource, 15728880);
                        poseStack.popPose();
                    }
                }
            }
        }

        bufferSource.endBatch();

    }


}
