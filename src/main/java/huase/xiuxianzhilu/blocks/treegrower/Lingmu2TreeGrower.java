package huase.xiuxianzhilu.blocks.treegrower;

import huase.xiuxianzhilu.worlds.feature.TreeFeaturesGen;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

/**
 * - @description:Lingmu0TreeGrower类
 */
public class Lingmu2TreeGrower extends AbstractTreeGrower {
    /**
     * @return the key of this tree
     */
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_256345_, boolean p_255618_) {
//        return p_255618_ ? TreeFeatures.BIRCH_BEES_005 : TreeFeatures.BIRCH;
        return TreeFeaturesGen.lingguo2;
    }
}