package huase.xiuxianzhilu.screen.player;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.screen.ButtonMenu;
import huase.xiuxianzhilu.screen.FunctionAbstractContainerScreen;
import huase.xiuxianzhilu.screen.ToServerButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static net.minecraft.client.gui.screens.inventory.InventoryScreen.renderEntityInInventoryFollowsMouse;

public class PlayerAttrubuteContiainerScreen extends FunctionAbstractContainerScreen<PlayerAttrubuteContainerMenu> {
    private static final ResourceLocation playermianban =
            new ResourceLocation(ModMain.MOD_ID, "textures/gui/player/playermianban.png");
    private static final ResourceLocation playerslot =
            new ResourceLocation(ModMain.MOD_ID, "textures/gui/player/playerslot.png");
    private static final ResourceLocation huakuaiclose =
            new ResourceLocation(ModMain.MOD_ID, "textures/gui/player/huakuaiclose.png");
    private static final ResourceLocation huakuaiopen =
            new ResourceLocation(ModMain.MOD_ID, "textures/gui/player/huakuaiopen.png");

    List<MutableComponent> mutableComponents = new LinkedList<>();
    public PlayerAttrubuteContiainerScreen(PlayerAttrubuteContainerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }


    @Override
    protected void init() {
        this.imageWidth = 362;
        this.imageHeight = 159;
        super.init();
    }

    protected void containerTick() {
        if(this.minecraft.level.getGameTime()%20==0){
            updateMutableComponents();
        }
    }

    private void updateMutableComponents() {
        mutableComponents.clear();
        mutableComponents.add(Component.translatable("境界:10006545",          1000));
        mutableComponents.add(Component.translatable("灵根",          1000));
        mutableComponents.add(Component.translatable("灵石",          1000));
        mutableComponents.add(Component.translatable("资质",          1000));
        mutableComponents.add(Component.translatable("悟性",          1000));
        mutableComponents.add(Component.translatable("神识",          1000));
        mutableComponents.add(Component.translatable("丹毒",          1000));
        mutableComponents.add(Component.translatable("修龄",          1000));
        mutableComponents.add(Component.translatable("物攻",          1000));
        mutableComponents.add(Component.translatable("命中",          1000));
        mutableComponents.add(Component.translatable("吸血",          1000));
        mutableComponents.add(Component.translatable("遁速",          1000));
        mutableComponents.add(Component.translatable("爆伤",          1000));
        mutableComponents.add(Component.translatable("爆率",          1000));

        mutableComponents.add(Component.translatable("生命",             1000));
        mutableComponents.add(Component.translatable("最大生命",           1000));
        mutableComponents.add(Component.translatable("灵力",             1000));
        mutableComponents.add(Component.translatable("最大灵力",           1000));
        mutableComponents.add(Component.translatable("修为",             1000));
        mutableComponents.add(Component.translatable("最大修为",         1000));
        mutableComponents.add(Component.translatable("感悟",            1000));;
        mutableComponents.add(Component.translatable("最大感悟",               1000));
        mutableComponents.add(Component.translatable("寿元",                 1000));
        mutableComponents.add(Component.translatable("物防",            1000));
        mutableComponents.add(Component.translatable("闪避",            1000));
        mutableComponents.add(Component.translatable("韧性",            1000));
        mutableComponents.add(Component.translatable("元素抗性",         1000));
//        mutableComponents.add(Component.translatable("元素精通",         1000));
    }

    @Override
    public void createToServerButton(PlayerAttrubuteContainerMenu pMenu) {
        Map<Integer, ButtonMenu> buttonFunctionMap = pMenu.getButtonFunctionMap();
        int index = 0;
        for (PlayerAttrubuteContainerMenu.Mianban value : PlayerAttrubuteContainerMenu.Mianban.values()) {
            ButtonMenu buttonMenu = buttonFunctionMap.get(index);
            ToServerButton toServerButton = new PlayerMianbanButton(pMenu,index,buttonMenu,this.leftPos,this.topPos);

            this.addRenderableWidget(toServerButton);
            index++;
        }


        this.checkButtonNum(buttonFunctionMap.size());

    }
    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        this.renderBackground(pGuiGraphics);
        pGuiGraphics.blit(playermianban, leftPos, topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

        renderEntityInInventoryFollowsMouse(pGuiGraphics, leftPos + 46, topPos + 136, 60, (float)(leftPos + 51) - pMouseX, (float)(topPos + 75 - 50) - pMouseY, this.minecraft.player);


        pGuiGraphics.blit(huakuaiclose, leftPos+259, topPos+10, 0, 0,12,15,12,15);
        pGuiGraphics.blit(huakuaiopen, leftPos+259, topPos+131, 0, 0,12,15,12,15);

        pGuiGraphics.blit(playerslot, leftPos+81, topPos+155, 0, 0,178,93,178,93);


        renderAllMianban(pGuiGraphics, pPartialTick, pMouseX, pMouseY);
    }

    private void renderAllMianban(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

        switch (menu.mianban){
            case attribute:
                renderattribute(guiGraphics, pPartialTick, pMouseX, pMouseY);
                break;
            case lingxiu:
                renderlingxiu(guiGraphics, pPartialTick, pMouseX, pMouseY);
                break;
            case gongfa:
                rendergongfa(guiGraphics, pPartialTick, pMouseX, pMouseY);
                break;
        }
    }


    private void renderattribute(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        for (int i = 0; i < getnumberOfExperts(); i++) {
            guiGraphics.drawString(Minecraft.getInstance().font,
                    mutableComponents.get(i+startIndex), leftPos+96, topPos+14+15*i,
                    0xffffffff, false);
            int i1 = i + gettotalNumberOfLines() + startIndex;
            if(i1< mutableComponents.size()){
                guiGraphics.drawString(Minecraft.getInstance().font,
                        mutableComponents.get(i1), leftPos+174, topPos+14+15*i,
                        0xffffffff, false);
            }
        }
    }
    private void renderlingxiu(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

    }
    private void rendergongfa(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {

    }



    //计算滑动
    private float scrollOffs;
    private int startIndex;
    public boolean mouseScrolled(double pMouseX, double pMouseY, double pDelta) {
        if (this.isScrollBarActive()) {
            int i = this.getOffscreenRows();
            if(i<=0){
                startIndex = 0;
                return true;
            }
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
        return gettotalNumberOfLines() - getnumberOfExperts();
    }

    private int gettotalNumberOfLines() {
        return (mutableComponents.size()+1)/2;
    }

    private int getnumberOfExperts() {
        return Math.min(9,gettotalNumberOfLines());
    }
}
