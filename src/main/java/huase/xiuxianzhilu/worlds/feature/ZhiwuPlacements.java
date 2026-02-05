package huase.xiuxianzhilu.worlds.feature;

import com.google.common.collect.ImmutableList;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.datagens.tag.BlockTagsProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

/**
 * - @description:ZhiwuPlacements类
 */
public class ZhiwuPlacements {
    public static final ResourceKey<PlacedFeature> zhiwu0_placed    =createKey("zhiwu0_placed");
    public static final ResourceKey<PlacedFeature> zhiwu2_placed    =createKey("zhiwu2_placed");
    public static final ResourceKey<PlacedFeature> zhiwu3_placed    =createKey("zhiwu3_placed");
    public static final ResourceKey<PlacedFeature> zhiwu4_placed    =createKey("zhiwu4_placed");
    public static final ResourceKey<PlacedFeature> zhiwu6_placed    =createKey("zhiwu6_placed");
    public static final ResourceKey<PlacedFeature> zhiwu7_placed    =createKey("zhiwu7_placed");
    public static final ResourceKey<PlacedFeature> zhiwu8_placed    =createKey("zhiwu8_placed");
    public static final ResourceKey<PlacedFeature> zhiwu10_placed   =createKey("zhiwu10_placed");
    public static final ResourceKey<PlacedFeature> zhiwu11_placed   =createKey("zhiwu11_placed");
    public static final ResourceKey<PlacedFeature> zhiwu12_placed   =createKey("zhiwu12_placed");
    public static final ResourceKey<PlacedFeature> zhiwu14_placed   =createKey("zhiwu14_placed");
    public static final ResourceKey<PlacedFeature> zhiwu15_placed   =createKey("zhiwu15_placed");
    public static final ResourceKey<PlacedFeature> zhiwu16_placed   =createKey("zhiwu16_placed");
    public static final ResourceKey<PlacedFeature> zhiwu17_placed   =createKey("zhiwu17_placed");
    public static final ResourceKey<PlacedFeature> zhiwu18_placed   =createKey("zhiwu18_placed");
    public static final ResourceKey<PlacedFeature> zhiwu19_placed   =createKey("zhiwu19_placed");
    public static ResourceKey<PlacedFeature> createKey(String pKey) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ModMain.prefix(pKey));
    }
    public static void bootstrap(BootstapContext<PlacedFeature> pContext) {

        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = pContext.lookup(Registries.CONFIGURED_FEATURE);
        PlacementUtils.register(pContext,  zhiwu0_placed , holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu0 ), normalPlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
        PlacementUtils.register(pContext,  zhiwu2_placed , holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu2 ), riverPlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
        PlacementUtils.register(pContext,  zhiwu3_placed , holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu3 ), normalPlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
        PlacementUtils.register(pContext,  zhiwu4_placed , holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu4 ), undergroundPlacement(PlacementUtils.countExtra(0, 0.2F, 1)));
        PlacementUtils.register(pContext,  zhiwu6_placed , holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu6 ), normalPlacement(PlacementUtils.countExtra(0, 0.5F, 1)));
        PlacementUtils.register(pContext,  zhiwu7_placed , holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu7 ), normalPlacement(PlacementUtils.countExtra(0, 0.5F, 1)));
        PlacementUtils.register(pContext,  zhiwu8_placed , holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu8 ), seaPlacement(PlacementUtils.countExtra(0, 0.5F, 1)));
        PlacementUtils.register(pContext,  zhiwu10_placed, holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu10), normalPlacement(PlacementUtils.countExtra(0, 0.5F, 1)));
        PlacementUtils.register(pContext,  zhiwu11_placed, holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu11), normalPlacement(PlacementUtils.countExtra(0, 0.5F, 1)));
        PlacementUtils.register(pContext,  zhiwu12_placed, holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu12), seaPlacement(PlacementUtils.countExtra(0, 0.2F, 1)));
        PlacementUtils.register(pContext,  zhiwu14_placed, holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu14), seaPlacement(PlacementUtils.countExtra(0, 0.2F, 1)));
        PlacementUtils.register(pContext,  zhiwu15_placed, holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu15), seaPlacement(PlacementUtils.countExtra(0, 0.2F, 1)));
        PlacementUtils.register(pContext,  zhiwu16_placed, holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu16), seaPlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
        PlacementUtils.register(pContext,  zhiwu17_placed, holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu17), seaPlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
        PlacementUtils.register(pContext,  zhiwu18_placed, holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu18), seaPlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
        PlacementUtils.register(pContext,  zhiwu19_placed, holdergetter.getOrThrow(ZhiwuFeaturesGen.zhiwu19), seaPlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
    }


    public static List<PlacementModifier> seaPlacement(PlacementModifier pPlacement) {

        return ImmutableList.<PlacementModifier>builder()
                .add(pPlacement)
                .add(InSquarePlacement.spread())
//                .add(TREE_THRESHOLD)
                .add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE)
                .add(BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.WATER)))
                .add(BiomeFilter.biome()).build();
    }
    public static List<PlacementModifier> undergroundPlacement(PlacementModifier pPlacement) {
        return ImmutableList.<PlacementModifier>builder()
                .add(pPlacement)
                .add(CountPlacement.of(UniformInt.of(48, 96)))
                .add(InSquarePlacement.spread())
                .add(PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT)
//                .add(SurfaceWaterDepthFilter.forMaxDepth(0))
//                .add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
//                .add(BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.PODZOL)))
                .add(BiomeFilter.biome()).build();


    }
    public static List<PlacementModifier> riverPlacement(PlacementModifier pPlacement) {
        return ImmutableList.<PlacementModifier>builder()
                .add(pPlacement)
                .add(InSquarePlacement.spread())
                .add(SurfaceWaterDepthFilter.forMaxDepth(0))
                .add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
                .add(BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK)))
                .add(BiomeFilter.biome()).build();

    }
    public static List<PlacementModifier> normalPlacement(PlacementModifier pPlacement) {
        return ImmutableList.<PlacementModifier>builder()
                .add(pPlacement)
                .add(InSquarePlacement.spread())
                .add(SurfaceWaterDepthFilter.forMaxDepth(0))
                .add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
                .add(BlockPredicateFilter.forPredicate(BlockPredicate.matchesTag(Direction.DOWN.getNormal(), BlockTagsProvider.biome_top_block)))
                .add(BiomeFilter.biome()).build();

    }


}
