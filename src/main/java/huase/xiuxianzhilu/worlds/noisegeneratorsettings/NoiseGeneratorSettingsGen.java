package huase.xiuxianzhilu.worlds.noisegeneratorsettings;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.worlds.densityfunctions.DensityFunctionGen;
import huase.xiuxianzhilu.worlds.surfaceruledata.SurfaceRuleDatas;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseSettings;

/**
 * - @description:NoiseGeneratorSettingsGen类
 */
public class NoiseGeneratorSettingsGen {

    /**
     * TODO 功能描述：
     * @author :huase
     * @date 2025/11/30 0:45
     */
    public static final ResourceKey<NoiseGeneratorSettings> xiuxianzhilu_noisegeneratorsetting = ResourceKey.create(Registries.NOISE_SETTINGS, ModMain.prefix("xiuxianzhilu_noisegeneratorsetting"));

    public static void bootstrapNoise(BootstapContext<NoiseGeneratorSettings> context) {
        NoiseGeneratorSettings noiseGeneratorSettings = tfDefault(context);

        context.register(xiuxianzhilu_noisegeneratorsetting, noiseGeneratorSettings);
    }

    public static NoiseGeneratorSettings tfDefault(BootstapContext<NoiseGeneratorSettings> context) {
        NoiseSettings tfNoise = NoiseSettings.create(
                -32, //TODO Deliberate over this. For now it'll be -32
                256,
                1,
                2
        );

        NoiseGeneratorSettings noiseGeneratorSettings = new NoiseGeneratorSettings(
                tfNoise,
                Blocks.STONE.defaultBlockState(),
                Blocks.WATER.defaultBlockState(),
                DensityFunctionGen.xiuxianjie(context.lookup(Registries.DENSITY_FUNCTION), context.lookup(Registries.NOISE)),
//                DensityFunctionGen.none(),
//                SurfaceRuleData.overworld(),
                SurfaceRuleDatas.xiuxianjieLike(),
                (new OverworldBiomeBuilder()).spawnTarget(),
                63,
                false,
                true,
                false,
                false
        );
        /*
        NoiseGeneratorSettings noiseGeneratorSettings1 = new NoiseGeneratorSettings(
//                NoiseSettings.OVERWORLD_NOISE_SETTINGS,
                tfNoise,
                Blocks.STONE.defaultBlockState(),
                Blocks.WATER.defaultBlockState(),
//                NoiseRouterData.overworld(context.lookup(Registries.DENSITY_FUNCTION), context.lookup(Registries.NOISE), false, false),
                overworld(context.lookup(Registries.DENSITY_FUNCTION), context.lookup(Registries.NOISE), false, false),
                SurfaceRuleData.overworld(),
                (new OverworldBiomeBuilder()).spawnTarget(),
                63,
                false,
                true,
                true,
                false);
*/
        return noiseGeneratorSettings;
    }



}
