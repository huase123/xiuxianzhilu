package huase.xiuxianzhilu.blocks.functions.jvlingzhen;

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
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * - @description:ZhenjiBlockEntity类
 */
public class JvlingzhenBlockEntity extends BlockEntity implements ChildFunction {
    private  ItemStackHandler itemHandler = new ItemStackHandler(){
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
    private int maxProgress = 400;
    private int lingli = 0;
    private Player player;
    private int lv = 0;

    public int getLv() {
        return lv;
    }

    public JvlingzhenBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntitiesinit.jvlingzhenblockentity.get(),pPos, pBlockState);

    }
    public JvlingzhenBlockEntity(BlockPos pPos, BlockState pBlockState, int lv) {
        super(BlockEntitiesinit.jvlingzhenblockentity.get(),pPos, pBlockState);
        this.lv = lv;
        maxProgress = 400-lv*100;
        int size;
        switch (lv){
            case 0:size=9;
            break;
            case 1:size=13;
            break;
            case 2:size=21;
            break;
            case 3:size=25;
            break;
            default:size=9;
        };
        itemHandler.setSize(size);
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
                CapabilityUtil.addPlayerLingli(lingli1);
                progress++;
            }
        }else {
            player =null;
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

        ItemEntity itementity = new ItemEntity(this.getLevel(), pPos.getX(), pPos.getY() + 2.2, pPos.getZ(), resultItem);
        itementity.setDefaultPickUpDelay();
        this.getLevel().addFreshEntity(itementity);
    }

    public void setChanged() {
        updateCurrentRecipe();
        super.setChanged();
        level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
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

    public Optional<LianqidingRecipe> getRecipeFor() {
        return recipeFor;
    }


    @Override
    public void interaction(BlockEntity entity) {
        if(entity instanceof PrentFunction prentFunction && ! prentBlockPos.contains(entity.getBlockPos())){
            if(prentBlockPos.size()>=getMaxinteractNum()){
                prentBlockPos.remove(0);
            }
            prentBlockPos.add(entity.getBlockPos());
            setChanged();
        }
    }

    private int getMaxinteractNum() {
        return getLv()+1;
    }
    List<BlockPos> prentBlockPos = new ArrayList<>();
    @Override
    public List<BlockPos> getPrentBlockPos() {
        return prentBlockPos;
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
        pTag.putInt("gprogress", progress);
        pTag.putInt("maxProgress", maxProgress);
        pTag.putInt("lv", lv);

        ListTag listTag = new ListTag();
        for (BlockPos blockPos : prentBlockPos) {
            IntArrayTag intTags = new IntArrayTag(new int[]{blockPos.getX(), blockPos.getY(), blockPos.getZ()});
            listTag.add(intTags);
        }

        pTag.put("prentblockpos",listTag);

    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("progress");
        maxProgress = pTag.getInt("maxProgress");
        lv = pTag.getInt("lv");

        prentBlockPos.clear();
        ListTag listTag = (ListTag) pTag.get("prentblockpos");
        for (Tag tag : listTag) {
            IntArrayTag intTags = (IntArrayTag) tag;
            int[] intArray = intTags.getAsIntArray();
            prentBlockPos.add(new BlockPos(intArray[0], intArray[1], intArray[2]));
        }
    }


    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    public AABB getRenderBoundingBox()
    {
        return INFINITE_EXTENT_AABB;
    }



    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}
