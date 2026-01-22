package huase.xiuxianzhilu.worlds.feature;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

/**
 * - @description:FeatureUtils类
 */
public class FeatureGen {
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
//        AquaticFeatures.bootstrap(pContext);
//        CaveFeatures.bootstrap(pContext);
//        EndFeatures.bootstrap(pContext);
//        MiscOverworldFeatures.bootstrap(pContext);
//        NetherFeatures.bootstrap(pContext);
//        OreFeatures.bootstrap(pContext);
//        PileFeatures.bootstrap(pContext);
        TreeFeaturesGen.bootstrap(pContext);
//        VegetationFeatures.bootstrap(pContext);
    }

}
