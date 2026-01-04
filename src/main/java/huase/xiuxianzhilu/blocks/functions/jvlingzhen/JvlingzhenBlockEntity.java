package huase.xiuxianzhilu.blocks.functions.jvlingzhen;

import huase.xiuxianzhilu.blocks.BlockEntitiesinit;
import huase.xiuxianzhilu.blocks.functions.ChildFunction;
import huase.xiuxianzhilu.blocks.functions.PrentFunction;
import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
import java.util.UUID;

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
    private Player goalplayer;
    private UUID playerUUID;
    private int lv = 0;
    List<BlockPos> prentBlockPos = new ArrayList<>();

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


    public void handleClick(ItemStack itemstack, Player pPlayer, JvlingzhenBlockEntity jvlingzhenBlockEntity) {
        if(!CapabilityUtil.isOpenLinggen(pPlayer)){
            playerUUID =  pPlayer.getUUID();
            this.setChanged();
        }
    }
    public void tick(Level Level, BlockPos pPos, BlockState State) {
        if(getGoalplayer() != null){
            handProgress(getGoalplayer(),pPos);
        }else {
            progress = 0;
        }
        if(level.getGameTime() %20 == 0){
            checkPrent(Level,pPos,State);
        }
    }

    private void checkPrent(Level level, BlockPos pPos, BlockState state) {
        prentBlockPos.removeIf(c -> checkPrentBlockPos(c)
        );
    }

    private boolean checkPrentBlockPos(BlockPos pPos) {
        BlockEntity blockEntity = null;
        if (this.level != null) {
            blockEntity = this.level.getBlockEntity(pPos);
        }
        if(blockEntity == null &&  !(blockEntity instanceof ChildFunction)){
            return true;
        }
        return false;
    }
    private void handProgress(Player player, BlockPos pPos) {

        if(progress<maxProgress){
                progress++;
        }else {
            if(!level.isClientSide){
                CapabilityUtil.openLinggen(player);
            }
            this.goalplayer =null;
            playerUUID =null;
            progress = 0;
            this.setChanged();
        }
    }



    public void setChanged() {
        super.setChanged();
        level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
    }


    @Override
    public void interaction(BlockEntity entity, Player player) {
        if(entity instanceof PrentFunction prentFunction && ! prentBlockPos.contains(entity.getBlockPos())){
            if(prentBlockPos.size()>=getMaxinteractNum()){
                prentBlockPos.remove(0);
            }
            if(this.checkScope(entity.getBlockPos())){
                prentBlockPos.add(entity.getBlockPos());
            }
            setChanged();
        }
    }

    private int getMaxinteractNum() {
        return getLv()+1;
    }
    @Override
    public List<BlockPos> getPrentBlockPos() {
        return prentBlockPos;
    }

    @Override
    public boolean checkScope(BlockPos blockPos) {
        int scope = (int) Math.pow(10 + 10 * getLv(), 2);
        double v = blockPos.distSqr(this.getBlockPos());
        return scope >= v;
    }

    @Override
    public int getLingliDensity() {
        return 10 + getLv()*10;
    }

    public Player getGoalplayer() {
        if(playerUUID != null){
            if(goalplayer == null){
                goalplayer = this.level.getPlayerByUUID(playerUUID);
            }
        }else {
            return null;
        }
        return goalplayer;
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
        if (playerUUID != null){
            pTag.putUUID("player", playerUUID);
        }
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

        if(pTag.hasUUID("player")){
            playerUUID = pTag.getUUID("player");
        }


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
