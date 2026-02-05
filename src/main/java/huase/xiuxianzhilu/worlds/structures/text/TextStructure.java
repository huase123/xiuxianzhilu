package huase.xiuxianzhilu.worlds.structures.text;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.worlds.structures.StructuresInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.Optional;
import java.util.function.Predicate;

public class TextStructure extends Structure  {
    public static final Codec<TextStructure> CODEC = simpleCodec(TextStructure::new);

    public TextStructure(StructureSettings structureSettings) {
        super(structureSettings);
    }



    public StructureStart generate(RegistryAccess registryAccess, ChunkGenerator chunkGenerator, BiomeSource biomeSource, RandomState randomState, StructureTemplateManager structureTemplateManager, long l, ChunkPos chunkPos, int i, LevelHeightAccessor levelHeightAccessor, Predicate<Holder<Biome>> holderPredicate) {
   
        return super.generate( registryAccess,  chunkGenerator,  biomeSource,  randomState,  structureTemplateManager,  l,  chunkPos,  i,  levelHeightAccessor,  holderPredicate);
    }


    public Optional<GenerationStub> findGenerationPoint(GenerationContext pContext) {


        int seaLevel = pContext.chunkGenerator().getSeaLevel();
//        Rotation rotation = Rotation.getRandom(pContext.random());
        Rotation rotation = Rotation.NONE;
//主世界
        BlockPos blockpos = this.getLowestYIn5by5BoxOffset7Blocks(pContext, rotation);
        return Optional.of(new GenerationStub(blockpos, (structurePiecesBuilder) -> {
            this.generatePieces(structurePiecesBuilder, blockpos, rotation, pContext);
        }));
    }

    private void generatePieces(StructurePiecesBuilder structurePiecesBuilder, BlockPos blockPos, Rotation rotation, GenerationContext generationContext) {
        structurePiecesBuilder.addPiece(new TextStructurePiece(blockPos,0));
    }

    public StructureType<?> type() {
        return StructuresInit.text_structure_type.get();
    }


}
