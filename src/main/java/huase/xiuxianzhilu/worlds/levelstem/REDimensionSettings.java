package huase.xiuxianzhilu.worlds.levelstem;

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
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;

import java.util.List;
import java.util.OptionalLong;

/**
 * - @description:REDimensionSettings类
 */
public class REDimensionSettings {

/**
 * TODO 功能描述：维度类型
 * @author :huase
 * @date 2025/11/30 1:02
 */

    public static final ResourceKey<DimensionType> XIUXIUZHILU_DIMENSIONN_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, ModMain.prefix("xiuxiuzhilu_dimensionn_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(XIUXIUZHILU_DIMENSIONN_TYPE, twilightDimType());
    }

    private static DimensionType twilightDimType() {
        return new DimensionType(
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
                ModMain.prefix("renderer"), // DimensionRenderInfo
                0f, // Wish this could be set to -0.05 since it'll make the world truly blacked out if an area is not sky-lit (see: Dark Forests) Sadly this also messes up night vision so it gets 0
                new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 7)
        );
    }
/**
 * TODO 功能描述：注册噪音生成器
 * @author :huase
 * @date 2025/11/30 0:45
 */
    public static final ResourceKey<NoiseGeneratorSettings> XIUXIANZHILU_NOISE_GEN = ResourceKey.create(Registries.NOISE_SETTINGS, ModMain.prefix("xiuxianzhilu_noise_gen"));

    public static void bootstrapNoise(BootstapContext<NoiseGeneratorSettings> context) {
        context.register(XIUXIANZHILU_NOISE_GEN, tfDefault());
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

/**
 * TODO 功能描述：注册维度
 * @author :huase
 * @date 2025/11/30 0:44
 */
    public static final ResourceKey<LevelStem> XIUXIANJIE =  ResourceKey.create(Registries.LEVEL_STEM, ModMain.prefix("xiuxianjie"));
    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new REBiomeSource(
                        biomeRegistry.getOrThrow(Biomes.PLAINS)
                ),
                noiseGenSettings.getOrThrow(XIUXIANZHILU_NOISE_GEN));

        LevelStem stem = new LevelStem(
                dimTypes.getOrThrow(XIUXIUZHILU_DIMENSIONN_TYPE),
                wrappedChunkGenerator
        );

//        context.register(XIUXIANJIE, stem);

//        覆盖主世界
        context.register(LevelStem.OVERWORLD, stem);
    }

}
