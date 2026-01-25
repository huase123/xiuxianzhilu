package huase.xiuxianzhilu.worlds.feature;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.blocks.zhiwu.ZhiwuBlock;
import huase.xiuxianzhilu.worlds.feature.features.ZhiwuFeatureConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

/**
 * - @description:VegetationFeaturesGen类
 */
public class ZhiwuFeaturesGen {
    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu0      = createKey("zhiwu0");

    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu2      = createKey("zhiwu2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu3      = createKey("zhiwu3");
    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu4      = createKey("zhiwu4");

    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu6      = createKey("zhiwu6");
    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu7      = createKey("zhiwu7");
    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu8      = createKey("zhiwu8");

    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu10     = createKey("zhiwu10");
    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu11     = createKey("zhiwu11");
    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu12     = createKey("zhiwu12");

    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu14     = createKey("zhiwu14");
    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu15     = createKey("zhiwu15");
    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu16     = createKey("zhiwu16");
    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu17     = createKey("zhiwu17");
    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu18     = createKey("zhiwu18");
    public static final ResourceKey<ConfiguredFeature<?, ?>> zhiwu19     = createKey("zhiwu19");


    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ModMain.prefix(pName));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> pContext) {
        FeatureUtils.register(pContext,  zhiwu0 , FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu0 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu2 , FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu2 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu3 , FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu3 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu4 , FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu4 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu6 , FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu6 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu7 , FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu7 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu8 , FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu8 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu10, FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu10 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu11, FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu11 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu12, FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu12 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu14, FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu14 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu15, FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu15 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu16, FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu16 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu17, FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu17 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu18, FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu18 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));
        FeatureUtils.register(pContext,  zhiwu19, FeatureInit.zhiwu.get(), new ZhiwuFeatureConfiguration(BlockStateProvider.simple(((ZhiwuBlock)BlockInit.zhiwu19 .get()).getStateForAge(ZhiwuBlock.MAX_AGE)),BlockStateProvider.simple(BlockInit.lingdirblock.get()),0.5f));

    }
}
