package huase.xiuxianzhilu.worlds.feature;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/**
 * - @description:FeatureUtils类
 */
public class FeaturePlacementGen {

    public static void bootstrap(BootstapContext<PlacedFeature> pContext) {
        TreeFeaturePlacements.bootstrap(pContext);

//        AquaticPlacements.bootstrap(pContext);
//        CavePlacements.bootstrap(pContext);
//        EndPlacements.bootstrap(pContext);
//        MiscOverworldPlacements.bootstrap(pContext);
//        NetherPlacements.bootstrap(pContext);
//        OrePlacements.bootstrap(pContext);
//        TreePlacements.bootstrap(pContext);
//        VegetationPlacements.bootstrap(pContext);
//        VillagePlacements.bootstrap(pContext);
    }

}
