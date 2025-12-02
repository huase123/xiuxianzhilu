package huase.xiuxianzhilu.worlds.levelstem;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.worlds.biomesources.REBiomeSource;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.OptionalLong;

/**
 * - @description:REDimensionSettings类
 */
public class REDimensionSettings {


    /**
     * TODO 功能描述：注册表，用于注册自定义BiomeSource
     * @author :huase
     * @date 2025/12/2 17:24
     */
    public static final DeferredRegister<Codec<? extends BiomeSource>> BIOME_SOURCE_TYPE_REGISTRIES = DeferredRegister.create(Registries.BIOME_SOURCE, ModMain.MOD_ID);
    public static final RegistryObject<Codec<? extends BiomeSource>> re_biome_source = BIOME_SOURCE_TYPE_REGISTRIES.register("re_biome_source", () -> REBiomeSource.CODEC);



    /**
 * TODO 功能描述：维度类型
 * @author :huase
 * @date 2025/11/30 1:02
 */
    public static final ResourceKey<DimensionType> XIUXIUZHILU_DIMENSIONN_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, ModMain.prefix("xiuxiuzhilu_dimensionn_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        DimensionType dimensionType = new DimensionType(
                OptionalLong.of(13000L), //fixed time
                true, //skylight
                false, //ceiling
                false, //ultrawarm
                true, //natural
                0.125D, //coordinate scale
                true, //bed works
                true, //respawn anchor works
                -32, // Minimum Y Level
                32 + 256, // Height + Min Y = Max Y
                32 + 256, // Logical Height
                BlockTags.INFINIBURN_OVERWORLD, //infiburn
                ModMain.prefix("xiuxianzhiludimensionrenderinfo"), // DimensionRenderInfo
                0f, // Wish this could be set to -0.05 since it'll make the world truly blacked out if an area is not sky-lit (see: Dark Forests) Sadly this also messes up night vision so it gets 0
                new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 7)
        );
        context.register(XIUXIUZHILU_DIMENSIONN_TYPE, dimensionType);
    }

/**
 * TODO 功能描述：
 * @author :huase
 * @date 2025/11/30 0:45
 */
    public static final ResourceKey<NoiseGeneratorSettings> xiuxianzhilu_noisegeneratorsetting = ResourceKey.create(Registries.NOISE_SETTINGS, ModMain.prefix("xiuxianzhilu_noisegeneratorsetting"));

    public static void bootstrapNoise(BootstapContext<NoiseGeneratorSettings> context) {
        context.register(xiuxianzhilu_noisegeneratorsetting, tfDefault());
    }

    public static NoiseGeneratorSettings tfDefault() {
        NoiseSettings tfNoise = NoiseSettings.create(
                -32, //TODO Deliberate over this. For now it'll be -32
                256,
                1,
                2
        );

        return new NoiseGeneratorSettings(
                tfNoise,
                Blocks.STONE.defaultBlockState(),
                Blocks.WATER.defaultBlockState(),
                new NoiseRouter(
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero(),
                        DensityFunctions.zero()
                ),
                SurfaceRuleData.overworld(),
                List.of(),
                0,
                false,
                false,
                false,
                false
        );
    }

    public static final ResourceKey<LevelStem> XIUXIANJIE =  ResourceKey.create(Registries.LEVEL_STEM, ModMain.prefix("xiuxianjie"));
    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new REBiomeSource(
                        biomeRegistry.getOrThrow(Biomes.PLAINS)
                ),
                noiseGenSettings.getOrThrow(xiuxianzhilu_noisegeneratorsetting));

        LevelStem stem = new LevelStem(
                dimTypes.getOrThrow(XIUXIUZHILU_DIMENSIONN_TYPE),
                wrappedChunkGenerator
        );

//        context.register(XIUXIANJIE, stem);

//        覆盖主世界
        context.register(LevelStem.OVERWORLD, stem);
    }

}
