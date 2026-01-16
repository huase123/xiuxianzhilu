package huase.xiuxianzhilu.screen.player;

import com.ibm.icu.text.DecimalFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuCase;
import huase.xiuxianzhilu.screen.ButtonMenu;
import huase.xiuxianzhilu.screen.ToServerButton;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix4f;

import java.util.LinkedList;
import java.util.List;

import static huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen.lingxiu_jingjie_key;

/**
 * - @description:PlayerMianbanButton类
 */
public class LingxiuSlotButton extends ToServerButton {
    private static final ResourceLocation slot =
            ModMain.prefix("textures/gui/player/slot.png");
    private int slotButtonindex;
    public LingxiuSlotButton(PlayerAttrubuteContainerMenu pMenu, int index, int slotButtonindex, ButtonMenu buttonMenu, int leftPos, int topPos) {
        super(pMenu,index,buttonMenu,leftPos,topPos);
        this.slotButtonindex = slotButtonindex;
    }


    protected boolean clicked(double pMouseX, double pMouseY) {
        boolean effective = isEffective();
        if(effective){
            return this.active && this.visible && pMouseX >= (double)this.getX() && pMouseY >= (double)this.getY() && pMouseX < (double)(this.getX() + this.width) && pMouseY < (double)(this.getY() + this.height);
        }else {
            return effective;
        }
    }

    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        if(isEffective()){
            pGuiGraphics.blit(slot, this.getX(), this.getY(), 0, 0,this.getWidth(), this.getHeight(),this.getWidth(), this.getHeight());
            renderItem(pGuiGraphics);

            if (isHovering(pMouseX,pMouseY)) {
                AbstractContainerScreen.renderSlotHighlight(pGuiGraphics, this.getX() + 1, this.getY() + 1, 0);
                renderTooltip(pGuiGraphics,pMouseX,pMouseY);
            }
        }
    }

    DecimalFormat decimalFormat = new DecimalFormat("#.0");

    List<Component> mutableComponents = new LinkedList<>();
    protected void renderTooltip(GuiGraphics pGuiGraphics, int pX, int pY) {

        LingxiuCase lingxiuCase = getLingxiuCase();
        if(lingxiuCase != null){
            mutableComponents.clear();
            ResourceLocation key = Minecraft.getInstance().level.registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(lingxiuCase.getLingxiuJingjie());
            mutableComponents.add(Component.translatable("境界:").append(Component.translatable(key.toString())));

            mutableComponents.add(Component.translatable("-----基础属性-----").withStyle(ChatFormatting.WHITE));
            if(lingxiuCase.isActivate()) {
                mutableComponents.add(Component.translatable("修炼速度:+").append(Component.translatable(decimalFormat.format(lingxiuCase.getIntensity())).withStyle(ChatFormatting.YELLOW)));
                if (lingxiuCase.getMaxshengming() > 0)
                    mutableComponents.add(Component.translatable("生命:+").append((Component.translatable(decimalFormat.format(lingxiuCase.getMaxshengming())).withStyle(ChatFormatting.YELLOW))));
                if (lingxiuCase.getWugong() > 0)
                    mutableComponents.add(Component.translatable("物攻:+").append((Component.translatable(decimalFormat.format(lingxiuCase.getWugong())).withStyle(ChatFormatting.YELLOW))));
                if (lingxiuCase.getWufang() > 0)
                    mutableComponents.add(Component.translatable("物防:+").append((Component.translatable(decimalFormat.format(lingxiuCase.getWufang())).withStyle(ChatFormatting.YELLOW))));
                if (lingxiuCase.getBaojishanghai() > 0)
                    mutableComponents.add(Component.translatable("爆伤:+").append((Component.translatable(decimalFormat.format(lingxiuCase.getBaojishanghai())).withStyle(ChatFormatting.YELLOW))));
                if (lingxiuCase.getBaojilv() > 0)
                    mutableComponents.add(Component.translatable("爆率:+").append((Component.translatable(decimalFormat.format(lingxiuCase.getBaojilv())).withStyle(ChatFormatting.YELLOW))));
                if (lingxiuCase.getMingzhong() > 0)
                    mutableComponents.add(Component.translatable("命中:+").append((Component.translatable(decimalFormat.format(lingxiuCase.getMingzhong())).withStyle(ChatFormatting.YELLOW))));
                if (lingxiuCase.getShouyuan() > 0)
                    mutableComponents.add(Component.translatable("寿元:+").append((Component.translatable(decimalFormat.format(lingxiuCase.getShouyuan())).withStyle(ChatFormatting.YELLOW))));
                if (lingxiuCase.getMaxlingli() > 0)
                    mutableComponents.add(Component.translatable("灵力:+").append((Component.translatable(decimalFormat.format(lingxiuCase.getMaxlingli())).withStyle(ChatFormatting.YELLOW))));
                if (lingxiuCase.getDunsu() > 0)
                    mutableComponents.add(Component.translatable("遁速:+").append((Component.translatable(decimalFormat.format(lingxiuCase.getDunsu())).withStyle(ChatFormatting.YELLOW))));
                if (lingxiuCase.getXixue() > 0)
                    mutableComponents.add(Component.translatable("吸血:+").append((Component.translatable(decimalFormat.format(lingxiuCase.getXixue())).withStyle(ChatFormatting.YELLOW))));
            }else {
                mutableComponents.add(Component.translatable("该修为已损失").withStyle(ChatFormatting.RED));
            }

            PoseStack poseStack = pGuiGraphics.pose();
            poseStack.pushPose();
            Matrix4f pose = poseStack.last().pose();
            pose.translate(0,0,100);
            pGuiGraphics.renderComponentTooltip(Minecraft.getInstance().font,mutableComponents, pX, pY);
            poseStack.popPose();
        }

    }

    private void renderItem(GuiGraphics pGuiGraphics) {
        int i = this.getX();
        int j = this.getY();
        LingxiuCase lingxiuCase = getLingxiuCase();
        if(lingxiuCase != null){

            pGuiGraphics.pose().pushPose();
            pGuiGraphics.pose().translate(0.0F, 0.0F, 50.0F);
            int lingxiuindex = CapabilityUtil.getLingxiuindex(((PlayerAttrubuteContainerMenu) this.pMenu).player);
            if (lingxiuindex == slotButtonindex || slotButtonindex == -1) {
                pGuiGraphics.fill(i+1, j+1, i+1 + 16, j+1 + 16, 0Xff00ff55);
            }

            pGuiGraphics.renderItem( new ItemStack(lingxiuCase.getLingxiuJingjie().getItem()), i+1, j+1);
            pGuiGraphics.pose().popPose();
        }else {

        }

    }

    private LingxiuCase getLingxiuCase() {
        LingxiuCase lingxiuCase = null;
        if(slotButtonindex==-1){
            lingxiuCase = CapabilityUtil.getLingxiuindext(((PlayerAttrubuteContainerMenu) this.pMenu).player,  CapabilityUtil.getLingxiuindex(((PlayerAttrubuteContainerMenu) this.pMenu).player));

        }else {
            lingxiuCase = CapabilityUtil.getLingxiuindext(((PlayerAttrubuteContainerMenu) this.pMenu).player, slotButtonindex);
        }
        return lingxiuCase;
    }


    private boolean isEffective() {
        return PlayerAttrubuteContainerMenu.Mianban.lingxiu.equals(((PlayerAttrubuteContainerMenu)this.pMenu).mianban);
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
}
