package huase.xiuxianzhilu.screen.player;

import com.ibm.icu.text.DecimalFormat;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaCase;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen;
import huase.xiuxianzhilu.screen.ButtonMenu;
import huase.xiuxianzhilu.screen.ToServerButton;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.LinkedList;
import java.util.List;

/**
 * - @description:PlayerMianbanButton类
 */
public class GongfaSlotButton extends ToServerButton {
    private static final ResourceLocation slot =
            ModMain.prefix("textures/gui/player/slot.png");
    private int slotButtonindex;
    public GongfaSlotButton(PlayerAttrubuteContainerMenu pMenu, int index, int slotButtonindex, ButtonMenu buttonMenu, int leftPos, int topPos) {
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
                renderAttributeTooltip(pGuiGraphics,pMouseX,pMouseY);
            }
        }
    }


    DecimalFormat decimalFormat = new DecimalFormat("#.0");

    List<Component> mutableComponents = new LinkedList<>();
    protected void renderAttributeTooltip(GuiGraphics pGuiGraphics, int pX, int pY) {

        GongfaCase gongfaCase = getGongfaCase();
        if(gongfaCase != null){
            mutableComponents.clear();
            ResourceLocation key = Minecraft.getInstance().level.registryAccess().registryOrThrow(GongfaGen.gongfa_key).getKey(gongfaCase.getGongfaSample());
            mutableComponents.add(Component.translatable("功法：").append(Component.translatable(key.toString())).withStyle(ChatFormatting.GOLD));
            mutableComponents.add(Component.translatable("层数:" + gongfaCase.getLayernum() + "/" + gongfaCase.getMaxlayernum()).withStyle(ChatFormatting.YELLOW));
            mutableComponents.add(Component.translatable("进度:").append(decimalFormat.format(gongfaCase.getJingyan()*100f/gongfaCase.getMaxjingyan())).append("%").withStyle(ChatFormatting.YELLOW));
            mutableComponents.add(Component.translatable("修炼速度+").append(decimalFormat.format(gongfaCase.getMaxshengming())).withStyle(ChatFormatting.YELLOW));
            mutableComponents.add(Component.translatable("生命+").append(decimalFormat.format(gongfaCase.getMaxshengming())).withStyle(ChatFormatting.YELLOW));
            mutableComponents.add(Component.translatable("物攻+").append(decimalFormat.format(gongfaCase.getWugong())).withStyle(ChatFormatting.YELLOW));
            mutableComponents.add(Component.translatable("物防+").append(decimalFormat.format(gongfaCase.getWufang())).withStyle(ChatFormatting.YELLOW));
            mutableComponents.add(Component.translatable("爆伤+").append(decimalFormat.format(gongfaCase.getBaojishanghai())).withStyle(ChatFormatting.YELLOW));
            mutableComponents.add(Component.translatable("爆率+").append(decimalFormat.format(gongfaCase.getBaojilv())).withStyle(ChatFormatting.YELLOW));
            mutableComponents.add(Component.translatable("命中+").append(decimalFormat.format(gongfaCase.getMingzhong())).withStyle(ChatFormatting.YELLOW));
            mutableComponents.add(Component.translatable("寿元+").append(decimalFormat.format(gongfaCase.getShouyuan())).withStyle(ChatFormatting.YELLOW));
            mutableComponents.add(Component.translatable("灵力+").append(decimalFormat.format(gongfaCase.getMaxlingli())).withStyle(ChatFormatting.YELLOW));
            mutableComponents.add(Component.translatable("遁速+").append(decimalFormat.format(gongfaCase.getDunsu())).withStyle(ChatFormatting.YELLOW));
            mutableComponents.add(Component.translatable("吸血+").append(decimalFormat.format(gongfaCase.getXixue())).withStyle(ChatFormatting.YELLOW));

            pGuiGraphics.renderComponentTooltip(Minecraft.getInstance().font,mutableComponents, pX, pY);
        }

    }
    protected void renderTooltip(GuiGraphics pGuiGraphics, int pX, int pY) {

        ItemStack itemstack = ItemStack.EMPTY;
        if(slotButtonindex==-1){
            GongfaCase gongfaindext = CapabilityUtil.getGongfaindext(((PlayerAttrubuteContainerMenu) this.pMenu).player,  CapabilityUtil.getGongfaindex(((PlayerAttrubuteContainerMenu) this.pMenu).player));
            if(gongfaindext != null){
                itemstack = new ItemStack(gongfaindext.getGongfaSample().getItem());
            }
        }else {
            GongfaCase gongfaindext = CapabilityUtil.getGongfaindext(((PlayerAttrubuteContainerMenu) this.pMenu).player, slotButtonindex);
            if(gongfaindext != null){
                itemstack = new ItemStack(gongfaindext.getGongfaSample().getItem());
            }
        }
        if(!itemstack.isEmpty()){
            pGuiGraphics.renderTooltip(Minecraft.getInstance().font, this.getTooltipFromContainerItem(itemstack), itemstack.getTooltipImage(), itemstack, pX, pY);
        }
    }


    protected List<Component> getTooltipFromContainerItem(ItemStack pStack) {
        return getTooltipFromItem(Minecraft.getInstance(), pStack);
    }

    public static List<Component> getTooltipFromItem(Minecraft pMinecraft, ItemStack pItem) {
        return pItem.getTooltipLines(pMinecraft.player, pMinecraft.options.advancedItemTooltips ? TooltipFlag.Default.ADVANCED : TooltipFlag.Default.NORMAL);
    }
    private void renderItem(GuiGraphics pGuiGraphics) {
        int i = this.getX();
        int j = this.getY();
        GongfaCase gongfaCase = getGongfaCase();
        if(gongfaCase != null){
            pGuiGraphics.pose().pushPose();
            pGuiGraphics.pose().translate(0.0F, 0.0F, 100.0F);
            int gongfaindex = CapabilityUtil.getGongfaindex(((PlayerAttrubuteContainerMenu) this.pMenu).player);
            if (gongfaindex == slotButtonindex || slotButtonindex == -1) {
                pGuiGraphics.fill(i+1, j+1, i+1 + 16, j+1 + 16, 0Xff00ff55);
            }

            pGuiGraphics.renderItem( new ItemStack(gongfaCase.getGongfaSample().getItem()), i+1, j+1);
            pGuiGraphics.pose().popPose();
        }else {

        }

    }
    private GongfaCase getGongfaCase() {
        GongfaCase gongfacase = null;
        if(slotButtonindex==-1){
            gongfacase = CapabilityUtil.getGongfaindext(((PlayerAttrubuteContainerMenu) this.pMenu).player,  CapabilityUtil.getGongfaindex(((PlayerAttrubuteContainerMenu) this.pMenu).player));

        }else {
            gongfacase = CapabilityUtil.getGongfaindext(((PlayerAttrubuteContainerMenu) this.pMenu).player, slotButtonindex);
        }
        return gongfacase;
    }



    private boolean isEffective() {
        return PlayerAttrubuteContainerMenu.Mianban.gongfa.equals(((PlayerAttrubuteContainerMenu)this.pMenu).mianban);
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
