package huase.xiuxianzhilu.worlds.worldpresets;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.worlds.levelstem.LevelStemGen;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.TheEndBiomeSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.presets.WorldPreset;

import java.util.Map;

/**
 * - @description:WorldPresets类
 */
public class WorldPresetsGen {
    public static final ResourceKey<WorldPreset> XIUXIANZHILU = ResourceKey.create(Registries.WORLD_PRESET, ModMain.prefix("xiuxianzhilu"));

    public static void bootstrap(BootstapContext<WorldPreset> pContext) {
        HolderGetter<Biome> biomes = pContext.lookup(Registries.BIOME);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = pContext.lookup(Registries.NOISE_SETTINGS);
        HolderGetter<DimensionType> holdergetter = pContext.lookup(Registries.DIMENSION_TYPE);
        Holder<DimensionType> holder = holdergetter.getOrThrow(BuiltinDimensionTypes.NETHER);
//        (new net.minecraft.world.level.levelgen.presets.WorldPresets.Bootstrap(pContext)).bootstrap();
        pContext.register(XIUXIANZHILU,new WorldPreset(Map.of(
                LevelStem.OVERWORLD,
                new LevelStem(holder, new NoiseBasedChunkGenerator(TheEndBiomeSource.create(biomes), noiseSettings.getOrThrow(NoiseGeneratorSettings.END))),
                LevelStemGen.XIUXIANJIE,
                new LevelStem(holder, new NoiseBasedChunkGenerator(TheEndBiomeSource.create(biomes), noiseSettings.getOrThrow(NoiseGeneratorSettings.END)))
        )));
    }

}
