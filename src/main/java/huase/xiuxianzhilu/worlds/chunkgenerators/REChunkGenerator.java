package huase.xiuxianzhilu.worlds.chunkgenerators;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.Mth;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * - @description:REChunkGenerator类
 */
public class REChunkGenerator extends ChunkGenerator {
    public static final Codec<REChunkGenerator> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            BiomeSource.CODEC.fieldOf("biome_source").forGetter(o -> o.biomeSource)
    ).apply(instance, instance.stable(REChunkGenerator::new)));
    public REChunkGenerator(BiomeSource biomeSource) {
        super(biomeSource);
    }

    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    public void applyCarvers(WorldGenRegion pLevel, long pSeed, RandomState pRandom, BiomeManager pBiomeManager, StructureManager pStructureManager, ChunkAccess pChunk, GenerationStep.Carving pStep) {

    }

    @Override
    public void buildSurface(WorldGenRegion pLevel, StructureManager pStructureManager, RandomState pRandom, ChunkAccess pChunk) {

    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion pLevel) {

    }

    @Override
    public int getGenDepth() {
        return 0;
    }


    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Executor pExecutor, Blender pBlender, RandomState pRandom, StructureManager pStructureManager, ChunkAccess pChunk) {

        Set<LevelChunkSection> set = Sets.newHashSet();
        for (LevelChunkSection levelchunksection : pChunk.getSections()) {
            levelchunksection.acquire();
            set.add(levelchunksection);
        }


        return CompletableFuture.supplyAsync(Util.wrapThreadWithTaskName("wgen_fill_noise", () -> {
            return this.doFill(pBlender, pStructureManager, pRandom, pChunk);
        }), Util.backgroundExecutor()).whenCompleteAsync((p_224309_, p_224310_) -> {
            for(LevelChunkSection levelchunksection1 : set) {
                levelchunksection1.release();
            }

        }, pExecutor);
    }
    NormalNoise normalNoise = NormalNoise.create(new WorldgenRandom(new LegacyRandomSource(1)), -4, 1, 1, 1);
    private ChunkAccess doFill(Blender pBlender, StructureManager pStructureManager, RandomState pRandom, ChunkAccess pChunk) {
        Heightmap heightmap = pChunk.getOrCreateHeightmapUnprimed(Heightmap.Types.OCEAN_FLOOR_WG);
        Heightmap heightmap1 = pChunk.getOrCreateHeightmapUnprimed(Heightmap.Types.WORLD_SURFACE_WG);
        ChunkPos chunkpos = pChunk.getPos();
        int i = chunkpos.getMinBlockX();
        int j = chunkpos.getMinBlockZ();
        for (int k = 0; k < 16; k++) {
            for (int l = 0; l < 16; l++) {
                int i1 = i + k;
                int j1 = j + l;
                int value = (int) Mth.abs((float) (normalNoise.getValue(i/100f+k/100f, 0, j/100f+l/100f)*200.0f));
                for (int height = 0; height < value; height++) {
                    LevelChunkSection levelchunksection = pChunk.getSection(pChunk.getSectionIndex(height ));
                    double value1 = normalNoise.getValue(i1/10.0, height/10.0, j1/10.0);
                    if( Math.abs(value1) > 0.1D){
                        levelchunksection.setBlockState(k, height & 15, l, STONE, false);
                    }
                }

                heightmap.update(k, value & 15, l, STONE);
                heightmap1.update(k, value & 15, l, STONE);
            }
        }
        return pChunk;
    }
    private static final BlockState AIR = Blocks.AIR.defaultBlockState();
    private static final BlockState STONE = Blocks.STONE.defaultBlockState();
    @Override
    public int getSeaLevel() {
        return 0;
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public int getBaseHeight(int pX, int pZ, Heightmap.Types pType, LevelHeightAccessor pLevel, RandomState pRandom) {
        return 0;
    }

    @Override
    public NoiseColumn getBaseColumn(int pX, int pZ, LevelHeightAccessor pHeight, RandomState pRandom) {

        return new NoiseColumn(0, new BlockState[0]);
    }

    @Override
    public void addDebugScreenInfo(List<String> pInfo, RandomState pRandom, BlockPos pPos) {

    }




    public void createReferences(WorldGenLevel pLevel, StructureManager pStructureManager, ChunkAccess pChunk) {
//        int i = 8;
//        ChunkPos chunkpos = pChunk.getPos();
//        int j = chunkpos.x;
//        int k = chunkpos.z;
//        int l = chunkpos.getMinBlockX();
//        int i1 = chunkpos.getMinBlockZ();
//        SectionPos sectionpos = SectionPos.bottomOf(pChunk);
//
//        for(int j1 = j - 8; j1 <= j + 8; ++j1) {
//            for(int k1 = k - 8; k1 <= k + 8; ++k1) {
//                long l1 = ChunkPos.asLong(j1, k1);
//
//                for(StructureStart structurestart : pLevel.getChunk(j1, k1).getAllStarts().values()) {
//                    try {
//                        if (structurestart.isValid() && structurestart.getBoundingBox().intersects(l, i1, l + 15, i1 + 15)) {
//                            pStructureManager.addReferenceForStructure(sectionpos, structurestart.getStructure(), l1, pChunk);
//                            DebugPackets.sendStructurePacket(pLevel, structurestart);
//                        }
//                    } catch (Exception exception) {
//                        CrashReport crashreport = CrashReport.forThrowable(exception, "Generating structure reference");
//                        CrashReportCategory crashreportcategory = crashreport.addCategory("Structure");
//                        Optional<? extends Registry<Structure>> optional = pLevel.registryAccess().registry(Registries.STRUCTURE);
//                        crashreportcategory.setDetail("Id", () -> {
//                            return optional.map((p_258977_) -> {
//                                return p_258977_.getKey(structurestart.getStructure()).toString();
//                            }).orElse("UNKNOWN");
//                        });
//                        crashreportcategory.setDetail("Name", () -> {
//                            return BuiltInRegistries.STRUCTURE_TYPE.getKey(structurestart.getStructure().type()).toString();
//                        });
//                        crashreportcategory.setDetail("Class", () -> {
//                            return structurestart.getStructure().getClass().getCanonicalName();
//                        });
//                        throw new ReportedException(crashreport);
//                    }
//                }
//            }
//        }

    }


    public void applyBiomeDecoration(WorldGenLevel pLevel, ChunkAccess pChunk, StructureManager pStructureManager) {
//        ChunkPos chunkpos = pChunk.getPos();
//        if (!SharedConstants.debugVoidTerrain(chunkpos)) {
//            SectionPos sectionpos = SectionPos.of(chunkpos, pLevel.getMinSection());
//            BlockPos blockpos = sectionpos.origin();
//            Registry<Structure> registry = pLevel.registryAccess().registryOrThrow(Registries.STRUCTURE);
//            Map<Integer, List<Structure>> map = registry.stream().collect(Collectors.groupingBy((p_223103_) -> {
//                return p_223103_.step().ordinal();
//            }));
//            List<FeatureSorter.StepFeatureData> list = this.featuresPerStep.get();
//            WorldgenRandom worldgenrandom = new WorldgenRandom(new XoroshiroRandomSource(RandomSupport.generateUniqueSeed()));
//            long i = worldgenrandom.setDecorationSeed(pLevel.getSeed(), blockpos.getX(), blockpos.getZ());
//            Set<Holder<Biome>> set = new ObjectArraySet<>();
//            ChunkPos.rangeClosed(sectionpos.chunk(), 1).forEach((p_223093_) -> {
//                ChunkAccess chunkaccess = pLevel.getChunk(p_223093_.x, p_223093_.z);
//
//                for(LevelChunkSection levelchunksection : chunkaccess.getSections()) {
//                    levelchunksection.getBiomes().getAll(set::add);
//                }
//
//            });
//            set.retainAll(this.biomeSource.possibleBiomes());
//            int j = list.size();
//
//            try {
//                Registry<PlacedFeature> registry1 = pLevel.registryAccess().registryOrThrow(Registries.PLACED_FEATURE);
//                int i1 = Math.max(GenerationStep.Decoration.values().length, j);
//
//                for(int k = 0; k < i1; ++k) {
//                    int l = 0;
//                    if (pStructureManager.shouldGenerateStructures()) {
//                        for(Structure structure : map.getOrDefault(k, Collections.emptyList())) {
//                            worldgenrandom.setFeatureSeed(i, l, k);
//                            Supplier<String> supplier = () -> {
//                                return registry.getResourceKey(structure).map(Object::toString).orElseGet(structure::toString);
//                            };
//
//                            try {
//                                pLevel.setCurrentlyGenerating(supplier);
//                                pStructureManager.startsForStructure(sectionpos, structure).forEach((p_223086_) -> {
//                                    p_223086_.placeInChunk(pLevel, pStructureManager, this, worldgenrandom, getWritableArea(pChunk), chunkpos);
//                                });
//                            } catch (Exception exception) {
//                                CrashReport crashreport1 = CrashReport.forThrowable(exception, "Feature placement");
//                                crashreport1.addCategory("Feature").setDetail("Description", supplier::get);
//                                throw new ReportedException(crashreport1);
//                            }
//
//                            ++l;
//                        }
//                    }
//
//                    if (k < j) {
//                        IntSet intset = new IntArraySet();
//
//                        for(Holder<Biome> holder : set) {
//                            List<HolderSet<PlacedFeature>> list1 = this.generationSettingsGetter.apply(holder).features();
//                            if (k < list1.size()) {
//                                HolderSet<PlacedFeature> holderset = list1.get(k);
//                                FeatureSorter.StepFeatureData featuresorter$stepfeaturedata1 = list.get(k);
//                                holderset.stream().map(Holder::value).forEach((p_223174_) -> {
//                                    intset.add(featuresorter$stepfeaturedata1.indexMapping().applyAsInt(p_223174_));
//                                });
//                            }
//                        }
//
//                        int j1 = intset.size();
//                        int[] aint = intset.toIntArray();
//                        Arrays.sort(aint);
//                        FeatureSorter.StepFeatureData featuresorter$stepfeaturedata = list.get(k);
//
//                        for(int k1 = 0; k1 < j1; ++k1) {
//                            int l1 = aint[k1];
//                            PlacedFeature placedfeature = featuresorter$stepfeaturedata.features().get(l1);
//                            Supplier<String> supplier1 = () -> {
//                                return registry1.getResourceKey(placedfeature).map(Object::toString).orElseGet(placedfeature::toString);
//                            };
//                            worldgenrandom.setFeatureSeed(i, l1, k);
//
//                            try {
//                                pLevel.setCurrentlyGenerating(supplier1);
//                                placedfeature.placeWithBiomeCheck(pLevel, this, worldgenrandom, blockpos);
//                            } catch (Exception exception1) {
//                                CrashReport crashreport2 = CrashReport.forThrowable(exception1, "Feature placement");
//                                crashreport2.addCategory("Feature").setDetail("Description", supplier1::get);
//                                throw new ReportedException(crashreport2);
//                            }
//                        }
//                    }
//                }
//
//                pLevel.setCurrentlyGenerating((Supplier<String>)null);
//            } catch (Exception exception2) {
//                CrashReport crashreport = CrashReport.forThrowable(exception2, "Biome decoration");
//                crashreport.addCategory("Generation").setDetail("CenterX", chunkpos.x).setDetail("CenterZ", chunkpos.z).setDetail("Seed", i);
//                throw new ReportedException(crashreport);
//            }
//        }
    }

}
