package huase.xiuxianzhilu.worlds.worldpresets;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
public class REWorldPresets {
    public static final ResourceKey<WorldPreset> XIUXIANZHILU = register("xiuxianzhilu");

    private static ResourceKey<WorldPreset> register(String pName) {
        return ResourceKey.create(Registries.WORLD_PRESET, new ResourceLocation(pName));
    }
    public static void bootstrap(BootstapContext<WorldPreset> pContext) {
        HolderGetter<Biome> biomes = pContext.lookup(Registries.BIOME);
        HolderGetter<NoiseGeneratorSettings> noiseSettings = pContext.lookup(Registries.NOISE_SETTINGS);
        HolderGetter<DimensionType> holdergetter = pContext.lookup(Registries.DIMENSION_TYPE);
        Holder<DimensionType> holder = holdergetter.getOrThrow(BuiltinDimensionTypes.NETHER);
//        (new net.minecraft.world.level.levelgen.presets.WorldPresets.Bootstrap(pContext)).bootstrap();
        pContext.register(XIUXIANZHILU,new WorldPreset(Map.of(LevelStem.OVERWORLD, new LevelStem(holder,
                new NoiseBasedChunkGenerator(TheEndBiomeSource.create(biomes), noiseSettings.getOrThrow(NoiseGeneratorSettings.END))))));
    }

}
