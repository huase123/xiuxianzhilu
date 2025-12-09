package huase.xiuxianzhilu.event.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.DensityFunction;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;

@Mod.EventBusSubscriber(modid = ModMain.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class RERenderGuiEventEventEvent {


    @SubscribeEvent(priority= EventPriority.LOWEST)
    public static void onRenderGuiEvent(RenderGuiEvent.Post event){
        renderDensityFunction(event);
//        renderlightTexture(event);
    }

    private static void renderDensityFunction(RenderGuiEvent.Post event) {
        LocalPlayer localplayer = Minecraft.getInstance().player;
        if(localplayer == null)return;
        PlayerCapability capability = (PlayerCapability) CapabilityUtil.getCapability(localplayer);
        float partialTick = event.getPartialTick();
        DensityFunction densityFunction = capability.getDensityFunction();
        float d = (float) densityFunction.value();
        GuiGraphics guiGraphics = event.getGuiGraphics();
        Matrix4f matrix4f = guiGraphics.pose().last().pose();

        int width = event.getWindow().getGuiScaledWidth();
        int height = event.getWindow().getGuiScaledHeight();
        RenderSystem.enableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);

        Tesselator tessellator = Tesselator.getInstance();
        BufferBuilder buffer = tessellator.getBuilder();
        buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        float pX1 = 0;
        float pX2 = width/8;
        float pY1 = 0;
        float pY2 = height/8;
        float pBlitOffset = 0;
        float Alpha = 1;
        float r = d;
        float g = d;
        float b = d;
        buffer.vertex(matrix4f, (float)pX1, (float)pY1, (float)pBlitOffset).color(r, g, b, Alpha).endVertex();
        buffer.vertex(matrix4f, (float)pX1, (float)pY2, (float)pBlitOffset).color(r, g, b, Alpha).endVertex();
        buffer.vertex(matrix4f, (float)pX2, (float)pY2, (float)pBlitOffset).color(r, g, b, Alpha).endVertex();
        buffer.vertex(matrix4f, (float)pX2, (float)pY1, (float)pBlitOffset).color(r, g, b, Alpha).endVertex();
        tessellator.end();

        RenderSystem.disableBlend();
        event.getGuiGraphics().drawString(Minecraft.getInstance().font, "密度："+d,10,10,16777215);
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
