package huase.xiuxianzhilu.worlds.feature;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

/**
 * - @description:TreeFeatures类
 */
public class OreFeaturesGen {
    public static final ResourceKey<ConfiguredFeature<?, ?>> xvantie0 = createKey("xvantie0");
    public static final ResourceKey<ConfiguredFeature<?, ?>> xvantie1 = createKey("xvantie1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> xvantie2 = createKey("xvantie2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> xvantie3 = createKey("xvantie3");
    public static final ResourceKey<ConfiguredFeature<?, ?>> lingjin0 = createKey("lingjin0");
    public static final ResourceKey<ConfiguredFeature<?, ?>> lingjin1 = createKey("lingjin1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> lingjin2 = createKey("lingjin2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> lingjin3 = createKey("lingjin3");
    public static final ResourceKey<ConfiguredFeature<?, ?>> lingyv0  = createKey("lingyv0");
    public static final ResourceKey<ConfiguredFeature<?, ?>> lingyv1  = createKey("lingyv1");
    public static final ResourceKey<ConfiguredFeature<?, ?>> lingyv2  = createKey("lingyv2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> lingyv3  = createKey("lingyv3");


    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ModMain.prefix(pName));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> pContext) {


        RuleTest ruletest1 = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        FeatureUtils.register(pContext,  xvantie0, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruletest1, BlockInit.xvantie0.get().defaultBlockState())), 5));
        FeatureUtils.register(pContext,  xvantie1, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruletest1, BlockInit.xvantie1.get().defaultBlockState())), 5));
        FeatureUtils.register(pContext,  xvantie2, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruletest1, BlockInit.xvantie2.get().defaultBlockState())), 5));
        FeatureUtils.register(pContext,  xvantie3, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruletest1, BlockInit.xvantie3.get().defaultBlockState())), 5));
        FeatureUtils.register(pContext,  lingjin0, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruletest1, BlockInit.lingjin0.get().defaultBlockState())), 5));
        FeatureUtils.register(pContext,  lingjin1, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruletest1, BlockInit.lingjin1.get().defaultBlockState())), 5));
        FeatureUtils.register(pContext,  lingjin2, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruletest1, BlockInit.lingjin2.get().defaultBlockState())), 5));
        FeatureUtils.register(pContext,  lingjin3, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruletest1, BlockInit.lingjin3.get().defaultBlockState())), 5));
        FeatureUtils.register(pContext,  lingyv0 , Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruletest1, BlockInit.lingyv0 .get().defaultBlockState())), 5));
        FeatureUtils.register(pContext,  lingyv1 , Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruletest1, BlockInit.lingyv1 .get().defaultBlockState())), 5));
        FeatureUtils.register(pContext,  lingyv2 , Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruletest1, BlockInit.lingyv2 .get().defaultBlockState())), 5));
        FeatureUtils.register(pContext,  lingyv3 , Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(ruletest1, BlockInit.lingyv3 .get().defaultBlockState())), 5));



    }

}
