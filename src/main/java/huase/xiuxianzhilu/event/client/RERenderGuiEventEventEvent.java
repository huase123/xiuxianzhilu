package huase.xiuxianzhilu.event.client;

import com.ibm.icu.text.DecimalFormat;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.DensityFunction;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
import huase.xiuxianzhilu.util.RenderApi;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModMain.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class RERenderGuiEventEventEvent {
    @SubscribeEvent(priority= EventPriority.LOWEST)
    public static void onRenderGuiEvent(RenderGuiEvent.Post event){
        renderDensityFunction(event);
    }

    private static final ResourceLocation lingmai0 = ModMain.prefix("textures/gui/player/lingmai0.png");
    private static final ResourceLocation lingmai1 = ModMain.prefix("textures/gui/player/lingmai1.png");

    static float lastenoise = 0f;
    static DecimalFormat decimalFormat = new DecimalFormat("#");
    private static void renderDensityFunction(RenderGuiEvent.Post event) {
        LocalPlayer localplayer = Minecraft.getInstance().player;
        if(localplayer == null)return;
        PlayerCapability capability = CapabilityUtil.getCapability(localplayer);
        if(capability == null)return;
        float partialTick = event.getPartialTick();
        DensityFunction densityFunction = capability.getDensityFunction();
        if(densityFunction == null)return;
        densityFunction.updateClientState(partialTick);
        float noise = (float) densityFunction.getjingjieNoise();
        GuiGraphics guiGraphics = event.getGuiGraphics();

        int width = event.getWindow().getGuiScaledWidth();
        int height = event.getWindow().getGuiScaledHeight();


        RenderSystem.enableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        PoseStack posestack = guiGraphics.pose();
        posestack.pushPose();
        int size = 60;
        posestack.translate(width-size/2-18,height-size/2-18,0);
        posestack.mulPose(Axis.ZP.rotationDegrees((((int)((noise)*10))/10f )*5.0f * (Minecraft.getInstance().level.getGameTime()+partialTick) % 360f));
        if(noise>0){
            RenderApi.renderColorTexture(lingmai0,posestack,-size/2,-size/2,0,0,size,size,size,size,1.0f,1.0f,1.0f,1.0f);
        }else {
            RenderApi.renderColorTexture(lingmai0,posestack,-size/2,-size/2,0,0,size,size,size,size,0.5f,0.5f,0.5f,1.0f);
        }
        posestack.popPose();

        posestack.pushPose();
        int size1 = 60;
        posestack.translate(width-size1/2-18,height-size1/2-18,0);
        posestack.mulPose(Axis.ZP.rotationDegrees(1.0f * (Minecraft.getInstance().level.getGameTime()+partialTick) % 360f));
        RenderApi.renderColorTexture(lingmai1,posestack,-size/2,-size/2,0,0,size,size,size,size,1.0f,1.0f,1.0f,1.0f);
        posestack.popPose();
        RenderSystem.disableBlend();


        String format = decimalFormat.format(noise * 100);
        if(noise>0){
            event.getGuiGraphics().drawCenteredString(Minecraft.getInstance().font, "灵脉:"+format+"%",width-size1/2-12,height-12,0xffbbbbff);
          }else {
            event.getGuiGraphics().drawCenteredString(Minecraft.getInstance().font, "灵脉:"+format+"%",width-size1/2-12,height-12,0xffff3333);
        }
    }

    /**
 * TODO 功能描述：渲染光照贴图
 * @author :huase
 * @date 2025/12/2 21:00
 */
    private static void renderlightTexture(RenderGuiEvent.Post event) {
/*

        LocalPlayer localplayer = Minecraft.getInstance().player;
        if(localplayer == null)return;

        GuiGraphics guiGraphics = event.getGuiGraphics();

        int width = event.getWindow().getScreenWidth();
        int height = event.getWindow().getScreenHeight();
//渲染背景
        LightTexture lightTexture = Minecraft.getInstance().gameRenderer.lightTexture();

        ResourceLocation resourcelocation = new ResourceLocation(String.format(Locale.ROOT, "dynamic/%s_%d", "light_map", 1));
        RenderSystem.setShaderTexture(0, resourcelocation);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        Matrix4f matrix4f = guiGraphics.pose().last().pose();
        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        float pX1 = 0;
        float pX2 = width/6;
        float pY1 = 0;
        float pY2 = height/6;
        float pMinU = 0;
        float pMaxU = 1;
        float pMinV = 0;
        float pMaxV = 1;
        float pBlitOffset = 0;
        bufferbuilder.vertex(matrix4f, (float)pX1, (float)pY1, (float)pBlitOffset).uv(pMinU, pMinV).endVertex();
        bufferbuilder.vertex(matrix4f, (float)pX1, (float)pY2, (float)pBlitOffset).uv(pMinU, pMaxV).endVertex();
        bufferbuilder.vertex(matrix4f, (float)pX2, (float)pY2, (float)pBlitOffset).uv(pMaxU, pMaxV).endVertex();
        bufferbuilder.vertex(matrix4f, (float)pX2, (float)pY1, (float)pBlitOffset).uv(pMaxU, pMinV).endVertex();
        BufferUploader.drawWithShader(bufferbuilder.end());

*/

    }

}
