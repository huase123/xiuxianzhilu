package huase.xiuxianzhilu.compat.jei;

import huase.xiuxianzhilu.recipe.LiandanluRecipe;
import huase.xiuxianzhilu.recipe.LianqidingRecipe;
import huase.xiuxianzhilu.screen.liandanlu.LiandanluMenu;
import huase.xiuxianzhilu.screen.lianqiding.LianqidingMenu;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * - @description:REBasicRecipeTransferInfo类
 */
public class REBasicRecipeTransferInfo<C extends AbstractContainerMenu, R> implements IRecipeTransferInfo<C, R> {
    private final Class<? extends C> containerClass;
    @Nullable
    private final MenuType<C> menuType;
    private final RecipeType<R> recipeType;
    private final int recipeSlotStart;
    private final int recipeSlotCount;
    private final int inventorySlotStart;
    private final int inventorySlotCount;

    public REBasicRecipeTransferInfo(
            Class<? extends C> containerClass,
            @Nullable MenuType<C> menuType,
            RecipeType<R> recipeType,
            int recipeSlotStart,
            int recipeSlotCount,
            int inventorySlotStart,
            int inventorySlotCount
    ) {
        this.containerClass = containerClass;
        this.menuType = menuType;
        this.recipeType = recipeType;
        this.recipeSlotStart = recipeSlotStart;
        this.recipeSlotCount = recipeSlotCount;
        this.inventorySlotStart = inventorySlotStart;
        this.inventorySlotCount = inventorySlotCount;
    }

    @Override
    public Class<? extends C> getContainerClass() {
        return containerClass;
    }

    @Override
    public Optional<MenuType<C>> getMenuType() {
        return Optional.ofNullable(menuType);
    }

    @Override
    public RecipeType<R> getRecipeType() {
        return recipeType;
    }

    @Override
    public boolean canHandle(C container, R recipe) {
        if(container instanceof LianqidingMenu lianqidingMenu && recipe instanceof LianqidingRecipe lianqidingRecipe){
            int recipeLv = getRecipeLv();
            int lv = lianqidingMenu.getBlockEntity().getLv();
            if (recipeLv>lv)return false;
        }

        if(container instanceof LiandanluMenu liandanluMenu && recipe instanceof LiandanluRecipe lianqidingRecipe){
            int recipeLv = getRecipeLv();
            int lv = liandanluMenu.getBlockEntity().getLv();
            if (recipeLv>lv)return false;
        }


        return true;
    }
    @Nullable
    public IRecipeTransferError getHandlingError(C container, R recipe) {
        return new IRecipeTransferError() {
            @Override
            public Type getType() {
                return Type.USER_FACING;
            }

            @Override
            public List<Component> getTooltip() {
                return List.of(Component.translatable("等级不够").withStyle(ChatFormatting.RED));
            }
        };
    }
    private int getRecipeLv(){
        if(recipeType.equals(LianqidingCategory.GEM_LIANQIDING0_TYPE))return 0;
        if(recipeType.equals(LianqidingCategory.GEM_LIANQIDING1_TYPE))return 1;
        if(recipeType.equals(LianqidingCategory.GEM_LIANQIDING2_TYPE))return 2;
        if(recipeType.equals(LianqidingCategory.GEM_LIANQIDING3_TYPE))return 3;

        if(recipeType.equals(LiandanluCategory.GEM_LIANDANLU0_TYPE))return 0;
        if(recipeType.equals(LiandanluCategory.GEM_LIANDANLU1_TYPE))return 1;
        if(recipeType.equals(LiandanluCategory.GEM_LIANDANLU2_TYPE))return 2;
        if(recipeType.equals(LiandanluCategory.GEM_LIANDANLU3_TYPE))return 3;
        return 0;
    }
    @Override
    public List<Slot> getRecipeSlots(C container, R recipe) {
        List<Slot> slots = new ArrayList<>();
        for (int i = recipeSlotStart; i < recipeSlotStart + recipeSlotCount; i++) {
            Slot slot = container.getSlot(i);
            slots.add(slot);
        }
        return slots;
    }

    @Override
    public List<Slot> getInventorySlots(C container, R recipe) {
        List<Slot> slots = new ArrayList<>();
        for (int i = inventorySlotStart; i < inventorySlotStart + inventorySlotCount; i++) {
            Slot slot = container.getSlot(i);
            slots.add(slot);
        }
        return slots;
    }
}
