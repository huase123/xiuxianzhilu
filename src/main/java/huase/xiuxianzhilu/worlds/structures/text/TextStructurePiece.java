package huase.xiuxianzhilu.worlds.structures.text;

import huase.xiuxianzhilu.worlds.structures.StructuresInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;

/**
 * - @description:TextStructurePiece类
 */
public class TextStructurePiece extends StructurePiece {

    public TextStructurePiece(BlockPos blockPos, int pGenDepth) {
        super(StructuresInit.text_structure_piece_type.get(), pGenDepth, makeBoundingBx(blockPos));
    }


    public TextStructurePiece(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
        super(StructuresInit.text_structure_piece_type.get(),compoundTag);

    }

    private static BoundingBox makeBoundingBx(BlockPos blockPos) {
        return new BoundingBox(-20,0,0,20,4,4).move(blockPos);
    }


    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext pContext, CompoundTag pTag) {
//         super.addAdditionalSaveData(pContext, pTag);
    }
    BlockState blockState = Blocks.PRISMARINE_BRICKS.defaultBlockState();
    @Override
    public void postProcess(WorldGenLevel pLevel, StructureManager pStructureManager, ChunkGenerator pGenerator, RandomSource pRandom, BoundingBox pBox, ChunkPos pChunkPos, BlockPos pPos) {

        this.generateBox(pLevel, pBox, pPos.getX()-20,pPos.getY(),pPos.getZ(),pPos.getX()+20,pPos.getY()+4,pPos.getZ()+4, blockState, blockState, false);
    }
}
