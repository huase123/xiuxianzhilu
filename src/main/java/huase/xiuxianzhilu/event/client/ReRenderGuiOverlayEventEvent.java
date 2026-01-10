//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package huase.xiuxianzhilu.event.client;

import com.mojang.blaze3d.vertex.PoseStack;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font.DisplayMode;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.NamedGuiOverlay;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import org.joml.Matrix4f;

@EventBusSubscriber(
        modid = ModMain.MODID,
        bus = Bus.FORGE,
        value = {Dist.CLIENT}
)
public class ReRenderGuiOverlayEventEvent {
    public static final ResourceLocation heathkong = ModMain.prefix("textures/gui/overlay/heathkong.png");
    public static final ResourceLocation heath = ModMain.prefix("textures/gui/overlay/heath.png");
    public static final ResourceLocation jingyankong = ModMain.prefix("textures/gui/overlay/jingyankong.png");
    public static final ResourceLocation jingyan = ModMain.prefix("textures/gui/overlay/jingyan.png");
    public static final ResourceLocation linglikong =ModMain.prefix("textures/gui/overlay/linglikong.png");
    public static final ResourceLocation lingli = ModMain.prefix("textures/gui/overlay/lingli.png");

    public ReRenderGuiOverlayEventEvent() {
    }

    @SubscribeEvent(
            priority = EventPriority.LOWEST
    )
    public static void onRenderGuiOverlayEvent(RenderGuiOverlayEvent.Pre event) {
        NamedGuiOverlay overlay = event.getOverlay();
        if (overlay.id().getPath() == VanillaGuiOverlay.PLAYER_HEALTH.id().getPath()) {
            event.setCanceled(true);
            renderPlayerHealth(event);
        }

    }

    private static void renderPlayerHealth(RenderGuiOverlayEvent.Pre event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if(player.isDeadOrDying()){
            return;
        }

        int width = event.getWindow().getGuiScaledWidth();
        int height = event.getWindow().getGuiScaledHeight();
        GuiGraphics guiGraphics = event.getGuiGraphics();
        PoseStack pose1 = event.getGuiGraphics().pose();
        Matrix4f matrix4f = event.getGuiGraphics().pose().last().pose();
        pose1.pushPose();
        guiGraphics.blit(heathkong, 0, height / 2 - 48, 0.0F, 0.0F, 124, 33, 124, 33);
        guiGraphics.blit(heath, 0, height / 2 - 48, 0.0F, 0.0F, Math.min(124, (int)(124.0F * (player.getHealth() / player.getMaxHealth()))), 33, 124, 33);
        Minecraft.getInstance().font.drawInBatch(Component.translatable("生命1", (int)player.getHealth(), (int)player.getMaxHealth()), 22.0F, (float)(height / 2 - 48 + 9), -6684928, false, matrix4f, guiGraphics.bufferSource(), DisplayMode.SEE_THROUGH, 100, 0);
        guiGraphics.blit(linglikong, 5, height / 2 - 40, 0.0F, 0.0F, 121, 31, 121, 31);
        guiGraphics.blit(lingli, 5, height / 2 - 40, 0.0F, 0.0F, Math.min(121, (int)(121.0F * (CapabilityUtil.getLingli(player) / CapabilityUtil.getMaxlingli(player)))), 31, 121, 31);
        Minecraft.getInstance().font.drawInBatch(Component.translatable("灵力1", (int)CapabilityUtil.getLingli(player), (int)CapabilityUtil.getMaxlingli(player)), 33.0F, (float)(height / 2 - 40 + 22), -6710785, false, matrix4f, guiGraphics.bufferSource(), DisplayMode.SEE_THROUGH, 100, 0);
        if (CapabilityUtil.getMaxjingyan(player) != 0) {
            guiGraphics.blit(jingyankong, 0, height / 2 - 70, 0.0F, 0.0F, 124, 24, 124, 24);
            guiGraphics.blit(jingyan, 0, height / 2 - 70, 0.0F, 0.0F, (int) Math.min(124, 124 * CapabilityUtil.getJingyan(player) / CapabilityUtil.getMaxjingyan(player)), 24, 124, 24);
            Minecraft.getInstance().font.drawInBatch(Component.translatable("修为1",(int)CapabilityUtil.getJingyan(player), (int)CapabilityUtil.getMaxjingyan(player)), 22.0F, (float)(height / 2 - 70 + 9), -1, false, matrix4f, guiGraphics.bufferSource(), DisplayMode.SEE_THROUGH, 100, 0);
        }

        pose1.popPose();
    }

    @SubscribeEvent(
            priority = EventPriority.HIGHEST
    )
    public static void onRenderGuiOverlayEvent(RenderGuiOverlayEvent.Post event) {
    }
}
