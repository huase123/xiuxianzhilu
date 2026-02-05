package huase.xiuxianzhilu.worlds.noises;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

/**
 * - @description:NoiseGen类
 */
public class NoiseGen {

    public static void bootstrap(BootstapContext<NormalNoise.NoiseParameters> pContext) {

        register(pContext, Noises.CONTINENTALNESS, -9 , 1.0D, 1.0D, 2.0D, 2.0D, 2.0D, 1.0D, 1.0D, 1.0D, 1.0D);
        register(pContext, Noises.RIDGE, -7, 1.0D, 3.0D, 1.0D, 0.0D, 0.0D, 0.0D);
        register(pContext, Noises.EROSION, -9, 1.0D, 5.0D, 0.0D, 1.0D, 1.0D);
        /*
        register(pContext, pTemperature, -10 + pFirstOctaveOffset, 1.5D, 0.0D, 1.0D, 0.0D, 0.0D, 0.0D);
        register(pContext, pVegetation, -8 + pFirstOctaveOffset, 1.0D, 1.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        register(pContext, pContinentalness, -9 + pFirstOctaveOffset, 1.0D, 1.0D, 2.0D, 2.0D, 2.0D, 1.0D, 1.0D, 1.0D, 1.0D);
        register(pContext, pErosion, -9 + pFirstOctaveOffset, 1.0D, 1.0D, 0.0D, 1.0D, 1.0D);*/
    }


    private static void register(BootstapContext<NormalNoise.NoiseParameters> pContext, ResourceKey<NormalNoise.NoiseParameters> pKey, int pFirstOctave, double pAmplitude, double... pOtherAmplitudes) {
        pContext.register(pKey, new NormalNoise.NoiseParameters(pFirstOctave, pAmplitude, pOtherAmplitudes));
    }
}
