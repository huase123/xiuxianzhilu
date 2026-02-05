package huase.xiuxianzhilu.worlds.feature;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.worlds.feature.treedecorators.LingguoDecorator;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;

/**
 * - @description:TreeFeatures类
 */
public class TreeFeaturesGen {
    public static final ResourceKey<ConfiguredFeature<?, ?>> lingguo0 = createKey("lingguo0");
    public static final ResourceKey<ConfiguredFeature<?, ?>> lingguo1 = createKey("lingguo1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> lingguo2 = createKey("lingguo2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> lingguo3 = createKey("lingguo3");


    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ModMain.prefix(pName));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> pContext) {


        LingguoDecorator lingguoDecorator0 = new LingguoDecorator(0.5f, lingguoStateProvider(BlockInit.zhiwu1.get().defaultBlockState(),5));
        LingguoDecorator lingguoDecorator1 = new LingguoDecorator(0.5f, lingguoStateProvider(BlockInit.zhiwu5.get().defaultBlockState(),7));
        LingguoDecorator lingguoDecorator2 = new LingguoDecorator(0.5f, lingguoStateProvider(BlockInit.zhiwu9.get().defaultBlockState(),7));
        LingguoDecorator lingguoDecorator3 = new LingguoDecorator(0.5f, lingguoStateProvider(BlockInit.zhiwu14.get().defaultBlockState(),7));
        pContext.register(lingguo0, new ConfiguredFeature(Feature.TREE, createLingmu0().decorators(List.of(lingguoDecorator0)).build()));
        pContext.register(lingguo1, new ConfiguredFeature(Feature.TREE, createLingmu1().decorators(List.of(lingguoDecorator1)).build()));
        pContext.register(lingguo2, new ConfiguredFeature(Feature.TREE, createLingmu2().decorators(List.of(lingguoDecorator2)).build()));
        pContext.register(lingguo3, new ConfiguredFeature(Feature.TREE, createLingmu3().decorators(List.of(lingguoDecorator3)).build()));
    }

    private static BlockStateProvider lingguoStateProvider(BlockState blockState, int i) {
        return new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(blockState, 1)
                .add(Blocks.AIR.defaultBlockState(), i));
    }


    private static TreeConfiguration.TreeConfigurationBuilder createLingmu0() {
        return createStraightBlobTree(BlockInit.lingmu0_LOG.get(), BlockInit.lingmu0_LEAVES.get(), 5, 4, 0, 2).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createLingmu1() {
        return createStraightBlobTree(BlockInit.lingmu1_LOG.get(), BlockInit.lingmu1_LEAVES.get(), 7, 4, 0, 3).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createLingmu2() {
        return createStraightBlobTree(BlockInit.lingmu2_LOG.get(), BlockInit.lingmu2_LEAVES.get(), 9, 4, 0, 4).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createLingmu3() {
        return createStraightBlobTree(BlockInit.lingmu3_LOG.get(), BlockInit.lingmu3_LEAVES.get(), 11, 4, 0, 5).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block pLogBlock, Block pLeavesBlock, int pBaseHeight, int pHeightRandA, int pHeightRandB, int pRadius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(pLogBlock),
                new StraightTrunkPlacer(pBaseHeight, pHeightRandA, pHeightRandB),
                BlockStateProvider.simple(pLeavesBlock),
                new BlobFoliagePlacer(ConstantInt.of(pRadius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
    }
}
