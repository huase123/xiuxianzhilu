package huase.xiuxianzhilu.screen.player;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import huase.xiuxianzhilu.screen.ButtonMenu;
import huase.xiuxianzhilu.screen.ToServerButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix4f;

import static huase.xiuxianzhilu.capabilitys.capability.fabao.FabaoGen.fabao_key;
import static huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen.gongfa_key;
import static huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen.lingxiu_jingjie_key;

/**
 * - @description:PlayerMianbanButton类
 */
public class PlayerMianbanButton extends ToServerButton {
    private static final net.minecraft.resources.ResourceLocation CREATIVE_INVENTORY_TABS_IMAGE =
           ResourceLocation.parse("textures/gui/container/creative_inventory/tabs.png");
    PlayerAttrubuteContainerMenu.Mianban value;
    public PlayerMianbanButton(PlayerAttrubuteContainerMenu pMenu, int index, ButtonMenu buttonMenu, int leftPos, int topPos, PlayerAttrubuteContainerMenu.Mianban value) {
        super(pMenu,index,buttonMenu,leftPos,topPos);
        this.value = value;
    }


    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        Minecraft minecraft = Minecraft.getInstance();
        pGuiGraphics.setColor(1.0F, 1.0F, 1.0F, this.alpha);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();

        if(this.isFocused()){
            pGuiGraphics.blit(CREATIVE_INVENTORY_TABS_IMAGE, this.getX(), this.getY()+0,this.getWidth(), this.getHeight()+3, 0, 33, 26, 30,256,256);
        }else {
            pGuiGraphics.blit(CREATIVE_INVENTORY_TABS_IMAGE, this.getX(), this.getY()+0,this.getWidth(), this.getHeight(), 0, 0, 26, 30,256,256);
        }
//      pGuiGraphics.blit(CREATIVE_INVENTORY_TABS_IMAGE, this.getX(), this.getY()+(this.isFocused()? 3:0),this.getWidth(), this.getHeight(), 0, this.isFocused()? 30+3:0, 26, 30,256,256);

        renderItem(pGuiGraphics);


        if (isHovering(pMouseX,pMouseY)) {
            PoseStack poseStack = pGuiGraphics.pose();
            poseStack.pushPose();
            Matrix4f pose = poseStack.last().pose();
            pose.translate(0,0,100);
            pGuiGraphics.renderTooltip(Minecraft.getInstance().font,getMessage(), pMouseX, pMouseY);
            poseStack.popPose();
        }
    }

    public boolean isFocused() {
        return ((PlayerAttrubuteContainerMenu)this.pMenu).mianban.equals(value);
    }

    private boolean isHovering(double pMouseX, double pMouseY) {
        return this.isHovering( this.getX()+1, this.getY()+1, this.getWidth()-2, this.getHeight()-2, pMouseX, pMouseY);
    }
    protected boolean isHovering(int pX, int pY, int pWidth, int pHeight, double pMouseX, double pMouseY) {
        return pMouseX >= (double)(pX - 1) &&
                pMouseX < (double)(pX + pWidth + 1) &&
                pMouseY >= (double)(pY - 1) &&
                pMouseY < (double)(pY + pHeight + 1);
    }
    private void renderItem(GuiGraphics pGuiGraphics) {
        int i = this.getX();
        int j = this.getY();
        Item item = null;

        switch (value){
            case attribute ->{
//                item = Items.ARROW;
            }
            case fabao -> {
                item = Minecraft.getInstance().level.registryAccess().registryOrThrow(fabao_key).stream().findFirst().get().getItem();
            }
            case lingxiu -> {
                item = Minecraft.getInstance().level.registryAccess().registryOrThrow(lingxiu_jingjie_key).stream().findFirst().get().getItem();
                break;
            }
            case gongfa -> {
                item = Minecraft.getInstance().level.registryAccess().registryOrThrow(gongfa_key).stream().findFirst().get().getItem();
                break;
            }
        }

        if(item != null){
            PoseStack poseStack = pGuiGraphics.pose();
            poseStack.pushPose();
            pGuiGraphics.pose().translate(i+4, j+5, 50.0F);
            pGuiGraphics.pose().scale(1.5f,1.5f,1);

            pGuiGraphics.renderItem( new ItemStack(item), 0, 0);
            poseStack.popPose();
        }
    }

}
