package huase.xiuxianzhilu.screen.lianqiding;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.screen.FunctionAbstractContainerScreen;
import huase.xiuxianzhilu.screen.Task;
import huase.xiuxianzhilu.screen.ToServerButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.Map;

/**
 * - @description:LinggenScreen类
 */
public class LianqidingScreen extends FunctionAbstractContainerScreen<LianqidingMenu> {
    public LianqidingScreen(LianqidingMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        this.imageWidth = 176;
        this.imageHeight = 210;
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
        this.titleLabelY = 10;
        super.init();
    }

    @Override
    public void createToServerButton(LianqidingMenu pMenu) {
        Map<Integer, Task> buttonFunctionMap = pMenu.getButtonFunctionMap();
        int index = 0;
        ToServerButton toServerButton = new ToServerButton(pMenu, index++, this.leftPos+119, this.topPos+96, 40,20);
        this.addRenderableWidget(toServerButton);

        if(index != buttonFunctionMap.size()){
            ModMain.LOGGER.info("客户端与服务端按钮创建数量不对");
        }
    }

    private static final ResourceLocation lianqiding0 = ModMain.prefix("textures/gui/container/lianqiding0.png");
    private static final ResourceLocation lianqiding1 = ModMain.prefix("textures/gui/container/lianqiding1.png");
    private static final ResourceLocation lianqiding2 = ModMain.prefix("textures/gui/container/lianqiding2.png");
    private static final ResourceLocation lianqiding3 = ModMain.prefix("textures/gui/container/lianqiding3.png");
    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

        this.renderBackground(pGuiGraphics);
        int i = this.leftPos;
        int j = (this.height - this.imageHeight) / 2;
        pGuiGraphics.blit(getResourceLocation(), i, j, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
    }

    private ResourceLocation getResourceLocation() {
        int lv = this.menu.getBlockEntity().getLv();
        switch (lv){
            case 0:return lianqiding0;
            case 1:return lianqiding1;
            case 2:return lianqiding2;
            case 3:return lianqiding3;
        }
        return lianqiding3;
    }


    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        pGuiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
//        pGuiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }
}
