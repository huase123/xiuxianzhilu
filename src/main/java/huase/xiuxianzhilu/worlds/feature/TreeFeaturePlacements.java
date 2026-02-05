package huase.xiuxianzhilu.worlds.feature;

import com.google.common.collect.ImmutableList;
import huase.xiuxianzhilu.ModMain;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

/**
 * - @description:TreeFeaturePlacements类
 */
public class TreeFeaturePlacements {

    public static final ResourceKey<PlacedFeature> grassland_lingmu0_placed =createKey("grassland_lingmu0_placed");
    public static final ResourceKey<PlacedFeature> deepforest_lingmu0_placed =createKey("deepforest_lingmu0_placed");
    public static final ResourceKey<PlacedFeature> mountainous_lingmu1_placed =createKey("mountainous_lingmu1_placed");
    public static final ResourceKey<PlacedFeature> deepforest_lingmu2_placed =createKey("deepforest_lingmu2_placed");
    public static final ResourceKey<PlacedFeature> glacier_lingmu3_placed =createKey("glacier_lingmu3_placed");
    public static final ResourceKey<PlacedFeature> lingmu0_placed =createKey("lingmu0_placed");
    public static final ResourceKey<PlacedFeature> lingmu1_placed =createKey("lingmu1_placed");
    public static final ResourceKey<PlacedFeature> lingmu2_placed =createKey("lingmu2_placed");
    public static final ResourceKey<PlacedFeature> lingmu3_placed =createKey("lingmu3_placed");


    public static ResourceKey<PlacedFeature> createKey(String pKey) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ModMain.prefix(pKey));
    }
    public static void bootstrap(BootstapContext<PlacedFeature> pContext) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = pContext.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> holder0 = holdergetter.getOrThrow(TreeFeaturesGen.lingguo0);
        Holder<ConfiguredFeature<?, ?>> holder1 = holdergetter.getOrThrow(TreeFeaturesGen.lingguo1);
        Holder<ConfiguredFeature<?, ?>> holder2 = holdergetter.getOrThrow(TreeFeaturesGen.lingguo2);
        Holder<ConfiguredFeature<?, ?>> holder3 = holdergetter.getOrThrow(TreeFeaturesGen.lingguo3);
        PlacementUtils.register(pContext, grassland_lingmu0_placed, holder0, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
        PlacementUtils.register(pContext, deepforest_lingmu0_placed, holder0, deepforesttreePlacement(PlacementUtils.countExtra(10, 0.1F, 3)));
        PlacementUtils.register(pContext, mountainous_lingmu1_placed, holder1, treePlacement(PlacementUtils.countExtra(0, 0.5F, 1)));
        PlacementUtils.register(pContext, deepforest_lingmu2_placed, holder2, deepforesttreePlacement(PlacementUtils.countExtra(0, 0.1F, 2)));
        PlacementUtils.register(pContext, glacier_lingmu3_placed, holder3, glaciertreePlacement(PlacementUtils.countExtra(0, 0.2F, 1)));
    }

    private static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);
    public static List<PlacementModifier> deepforesttreePlacement(PlacementModifier pPlacement) {
        return ImmutableList.<PlacementModifier>builder()
                .add(pPlacement)
                .add(InSquarePlacement.spread())
                .add(TREE_THRESHOLD)
                .add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
                .add(BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(),Blocks.PODZOL)))
                .add(BiomeFilter.biome()).build();

    }
    public static List<PlacementModifier> treePlacement(PlacementModifier pPlacement) {
        return ImmutableList.<PlacementModifier>builder()
                .add(pPlacement)
                .add(InSquarePlacement.spread())
                .add(TREE_THRESHOLD)
                .add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
                .add(BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(),Blocks.GRASS_BLOCK)))
                .add(BiomeFilter.biome()).build();

    }
    public static List<PlacementModifier> glaciertreePlacement(PlacementModifier pPlacement) {
        return ImmutableList.<PlacementModifier>builder()
                .add(pPlacement)
                .add(InSquarePlacement.spread())
//                .add(TREE_THRESHOLD)
                .add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE)
                .add(BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(),Blocks.WATER)))
                .add(BiomeFilter.biome()).build();

    }


}
