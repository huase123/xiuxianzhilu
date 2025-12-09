package huase.xiuxianzhilu.worlds.levelstem;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.worlds.biomesources.REBiomeSource;
import huase.xiuxianzhilu.worlds.multinoisebiomesourceparameterlists.MultiNoiseBiomeSourceParameterListGen;
import huase.xiuxianzhilu.worlds.noisegeneratorsettings.NoiseGeneratorSettingsGen;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import static huase.xiuxianzhilu.worlds.dimensiontype.DimensionTypeGen.XIUXIUZHILU_DIMENSIONN_TYPE;

/**
 * - @description:REDimensionSettings类
 */
public class LevelStemGen {


    public static final ResourceKey<LevelStem> caves =  ResourceKey.create(Registries.LEVEL_STEM, ModMain.prefix("caves"));
    public static final ResourceKey<LevelStem> floating_islands =  ResourceKey.create(Registries.LEVEL_STEM, ModMain.prefix("floating_islands"));
    public static final ResourceKey<LevelStem> XIUXIANJIE =  ResourceKey.create(Registries.LEVEL_STEM, ModMain.prefix("xiuxianjie"));
    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        Holder.Reference<MultiNoiseBiomeSourceParameterList> reference = context.lookup(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST).getOrThrow(MultiNoiseBiomeSourceParameterListGen.XIEXIANJIE_BiomeSourceParameterList_Registries);
        MultiNoiseBiomeSource multiNoiseBiomeSource = MultiNoiseBiomeSource.createFromPreset(reference);
        REBiomeSource reBiomeSource = new REBiomeSource(biomeRegistry.getOrThrow(Biomes.PLAINS));

        Holder<NoiseGeneratorSettings> xiuxinjie = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(NoiseGeneratorSettingsGen.xiuxianzhilu_noisegeneratorsetting);
        Holder<NoiseGeneratorSettings> holder = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(NoiseGeneratorSettings.OVERWORLD);
        Holder<NoiseGeneratorSettings> CAVES = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(NoiseGeneratorSettings.CAVES);
        Holder<NoiseGeneratorSettings> FLOATING_ISLANDS = context.lookup(Registries.NOISE_SETTINGS).getOrThrow(NoiseGeneratorSettings.FLOATING_ISLANDS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                multiNoiseBiomeSource,
                xiuxinjie
        );

        LevelStem stem = new LevelStem(
                dimTypes.getOrThrow(XIUXIUZHILU_DIMENSIONN_TYPE),
                wrappedChunkGenerator
        );

        context.register(XIUXIANJIE, stem);
        context.register(caves, new LevelStem(dimTypes.getOrThrow(XIUXIUZHILU_DIMENSIONN_TYPE),
                new NoiseBasedChunkGenerator(
                        reBiomeSource,
                        CAVES
                )
                ));
        context.register(floating_islands, new LevelStem(dimTypes.getOrThrow(XIUXIUZHILU_DIMENSIONN_TYPE),
                new NoiseBasedChunkGenerator(
                        reBiomeSource,
                        FLOATING_ISLANDS
                )
                ));

//        覆盖主世界
//        context.register(LevelStem.OVERWORLD, stem);
    }

}
