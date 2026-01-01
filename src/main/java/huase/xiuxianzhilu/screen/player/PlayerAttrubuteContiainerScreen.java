package huase.xiuxianzhilu.screen.player;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.screen.FunctionAbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

import static net.minecraft.client.gui.screens.inventory.InventoryScreen.renderEntityInInventoryFollowsMouse;

public class PlayerAttrubuteContiainerScreen extends FunctionAbstractContainerScreen<PlayerAttrubuteContainerMenu> {
    private static final ResourceLocation playerpanel =
            new ResourceLocation(ModMain.MOD_ID, "textures/gui/playerpanel.png");

    public PlayerAttrubuteContiainerScreen(PlayerAttrubuteContainerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }


    @Override
    protected void init() {
        this.imageWidth = 341;
        this.imageHeight = 166;
        super.init();
    }

    @Override
    public void createToServerButton(PlayerAttrubuteContainerMenu pMenu) {

    }
    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        this.renderBackground(pGuiGraphics);
        pGuiGraphics.blit(playerpanel, leftPos, topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);



        renderEntityInInventoryFollowsMouse(pGuiGraphics, leftPos + 51, topPos + 75, 30, (float)(leftPos + 51) - pMouseX, (float)(topPos + 75 - 50) - pMouseY, this.minecraft.player);
    }






    //计算滑动
    private float scrollOffs;
    private int startIndex;
    public boolean mouseScrolled(double pMouseX, double pMouseY, double pDelta) {
        if (this.isScrollBarActive()) {
            int i = Math.max(0,this.getOffscreenRows());
            float f = (float)pDelta / (float)i;
            this.scrollOffs = Mth.clamp(this.scrollOffs - f, 0.0F, 1.0F);
            this.startIndex = (int) ((double) (this.scrollOffs * (float) i));
        }

        return true;
    }

    //    滑动是否有效
    private boolean isScrollBarActive() {
        return true;
    }
    //    屏幕外行数
    protected int getOffscreenRows() {
//总行数-屏幕内行数
        return 0;
    }
}
