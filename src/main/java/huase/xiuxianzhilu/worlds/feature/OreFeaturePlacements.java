package huase.xiuxianzhilu.worlds.feature;

import huase.xiuxianzhilu.ModMain;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

/**
 * - @description:TreeFeaturePlacements类
 */
public class OreFeaturePlacements {

    public static final ResourceKey<PlacedFeature> xvantie0_placed =createKey("xvantie0_placed");
    public static final ResourceKey<PlacedFeature> xvantie1_placed =createKey("xvantie1_placed");
    public static final ResourceKey<PlacedFeature> xvantie2_placed =createKey("xvantie2_placed");
    public static final ResourceKey<PlacedFeature> xvantie3_placed =createKey("xvantie3_placed");
    public static final ResourceKey<PlacedFeature> lingjin0_placed =createKey("lingjin0_placed");
    public static final ResourceKey<PlacedFeature> lingjin1_placed =createKey("lingjin1_placed");
    public static final ResourceKey<PlacedFeature> lingjin2_placed =createKey("lingjin2_placed");
    public static final ResourceKey<PlacedFeature> lingjin3_placed =createKey("lingjin3_placed");
    public static final ResourceKey<PlacedFeature> lingyv0_placed  =createKey("lingyv0_placed");
    public static final ResourceKey<PlacedFeature> lingyv1_placed  =createKey("lingyv1_placed");
    public static final ResourceKey<PlacedFeature> lingyv2_placed  =createKey("lingyv2_placed");
    public static final ResourceKey<PlacedFeature> lingyv3_placed  =createKey("lingyv3_placed");


    public static ResourceKey<PlacedFeature> createKey(String pKey) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ModMain.prefix(pKey));
    }
    public static void bootstrap(BootstapContext<PlacedFeature> pContext) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = pContext.lookup(Registries.CONFIGURED_FEATURE);

//        PlacementUtils.register(pContext, xvantie0_placed, holdergetter.getOrThrow(TreeFeaturesGen.lingguo0), treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));

        PlacementUtils.register(pContext, xvantie0_placed, holdergetter.getOrThrow(OreFeaturesGen.xvantie0), commonOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180))));
        PlacementUtils.register(pContext, xvantie1_placed, holdergetter.getOrThrow(OreFeaturesGen.xvantie1), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180))));
        PlacementUtils.register(pContext, xvantie2_placed, holdergetter.getOrThrow(OreFeaturesGen.xvantie2), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180))));
        PlacementUtils.register(pContext, xvantie3_placed, holdergetter.getOrThrow(OreFeaturesGen.xvantie3), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180))));
        PlacementUtils.register(pContext, lingjin0_placed, holdergetter.getOrThrow(OreFeaturesGen.lingjin0), commonOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180))));
        PlacementUtils.register(pContext, lingjin1_placed, holdergetter.getOrThrow(OreFeaturesGen.lingjin1), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180))));
        PlacementUtils.register(pContext, lingjin2_placed, holdergetter.getOrThrow(OreFeaturesGen.lingjin2), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180))));
        PlacementUtils.register(pContext, lingjin3_placed, holdergetter.getOrThrow(OreFeaturesGen.lingjin3), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180))));
        PlacementUtils.register(pContext, lingyv0_placed , holdergetter.getOrThrow(OreFeaturesGen.lingyv0 ), commonOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180))));
        PlacementUtils.register(pContext, lingyv1_placed , holdergetter.getOrThrow(OreFeaturesGen.lingyv1 ), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180))));
        PlacementUtils.register(pContext, lingyv2_placed , holdergetter.getOrThrow(OreFeaturesGen.lingyv2 ), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180))));
        PlacementUtils.register(pContext, lingyv3_placed , holdergetter.getOrThrow(OreFeaturesGen.lingyv3 ), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(180))));

    }

    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }


}
