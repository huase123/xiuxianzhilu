package huase.xiuxianzhilu.blocks.functions.lianqiding;

import huase.xiuxianzhilu.blocks.BlockEntitiesinit;
import huase.xiuxianzhilu.blocks.functions.ChildFunction;
import huase.xiuxianzhilu.blocks.functions.PrentFunction;
import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.recipe.LianqidingRecipe;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

/**
 * - @description:ZhenjiBlockEntity类
 */
public class LianqidingBlockEntity extends BlockEntity implements PrentFunction {
    private final ItemStackHandler itemHandler = new ItemStackHandler(49) {
        @Override
        protected void onContentsChanged(int slot) {
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private int progress = 0;
    private int maxProgress = 200;
    private int lingli = 0;
    private Player player;
    public LianqidingBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntitiesinit.lianqidingblockentity.get(),pPos, pBlockState);

    }


    public void startPlayer(Player player) {
        this.player = player;
    }
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(player != null && recipeFor.isPresent()){
            handRecipeFor(player,pPos,recipeFor.get());
        }else {
            progress = 0;
        }
    }

    private void handRecipeFor(Player player, BlockPos pPos, LianqidingRecipe lianqidingRecipe) {
        float playerLingli = CapabilityUtil.getPlayerLingli(player);
        float lingli1 = ((float)lianqidingRecipe.getLingli())/maxProgress;
        if(progress<maxProgress){
            if(playerLingli<lingli1){
                player.sendSystemMessage(Component.translatable("灵力不足").withStyle(ChatFormatting.RED));
                this.player =null;
                progress = 0;
            }else {
                CapabilityUtil.addPlayerLingli(player);
                progress++;
            }
        }else {
//            player =null;
            progress = 0;
            handRecipeResult(player,pPos,lianqidingRecipe);
        }
    }

    private void handRecipeResult(Player player, BlockPos pPos, LianqidingRecipe lianqidingRecipe) {
        ItemStack resultItem = lianqidingRecipe.getResultItem().copy();
        NonNullList<Ingredient> ingredients = lianqidingRecipe.getIngredients();
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            if(!ingredients.get(i).isEmpty()){
                this.itemHandler.extractItem(i, 1, false);
            }
        }

        ItemEntity itementity = new ItemEntity(this.getLevel(), pPos.getX(), pPos.getY() + (double)1.2, pPos.getZ(), resultItem);
        itementity.setDefaultPickUpDelay();
        this.getLevel().addFreshEntity(itementity);
    }

    public void setChanged() {
        updateCurrentRecipe();

        super.setChanged();
    }

    private Optional<LianqidingRecipe> recipeFor = Optional.empty();
    private final Container result = new SimpleContainer(1);
    public void updateCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots()-1; i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }
        recipeFor = this.level.getRecipeManager().getRecipeFor(LianqidingRecipe.Type.INSTANCE, inventory, level);
        if(recipeFor.isPresent()){
            ItemStack resultItem = recipeFor.get().getResultItem();
            result.setItem(0,resultItem);
        }else {
            result.setItem(0,ItemStack.EMPTY);
        }
    }

    public Container getResult() {
        return result;
    }

    @Override
    public List<ChildFunction> getChildFunction() {
        return null;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }


    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("gem_polishing_station.progress", progress);

    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("gem_polishing_station.progress");
    }

//
//    @Nullable
//    @Override
//    public Packet<ClientGamePacketListener> getUpdatePacket() {
//        return ClientboundBlockEntityDataPacket.create(this);
//    }
//
//    @Override
//    public CompoundTag getUpdateTag() {
//        return saveWithoutMetadata();
//    }

}
