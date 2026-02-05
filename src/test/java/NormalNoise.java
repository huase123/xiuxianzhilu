import it.unimi.dsi.fastutil.doubles.DoubleList;
import it.unimi.dsi.fastutil.doubles.DoubleListIterator;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;

/**
 * - @description:NormalNoise类
 */
public class NormalNoise {
    private static final double INPUT_FACTOR = 1.0181268882175227D;
    private static final double TARGET_DEVIATION = 0.3333333333333333D;
    private final double valueFactor;
    private final PerlinNoise first;
    private final PerlinNoise second;
    private final double maxValue=0;

    public NormalNoise(RandomSource pRandom, int i,DoubleList doublelist, boolean pUseLegacyNetherBiome) {
        if (pUseLegacyNetherBiome) {
            this.first = PerlinNoise.create(pRandom, i, doublelist);
            this.second = PerlinNoise.create(pRandom, i, doublelist);
        } else {
            this.first = PerlinNoise.createLegacyForLegacyNetherBiome(pRandom, i, doublelist);
            this.second = PerlinNoise.createLegacyForLegacyNetherBiome(pRandom, i, doublelist);
        }

        int j = Integer.MAX_VALUE;
        int k = Integer.MIN_VALUE;
        DoubleListIterator doublelistiterator = doublelist.iterator();

        while(doublelistiterator.hasNext()) {
            int l = doublelistiterator.nextIndex();
            double d0 = doublelistiterator.nextDouble();
            if (d0 != 0.0D) {
                j = Math.min(j, l);
                k = Math.max(k, l);
            }
        }

        this.valueFactor = 0.16666666666666666D / expectedDeviation(k - j);
//        this.maxValue = (this.first.maxValue() + this.second.maxValue()) * this.valueFactor;
    }

    public double maxValue() {
        return this.maxValue;
    }

    private static double expectedDeviation(int pOctaves) {
        return 0.1D * (1.0D + 1.0D / (double)(pOctaves + 1));
    }

    public double getValue(double pX, double pY, double pZ) {
        double d0 = pX * 1.0181268882175227D;
        double d1 = pY * 1.0181268882175227D;
        double d2 = pZ * 1.0181268882175227D;
        return (this.first.getValue(pX, pY, pZ) + this.second.getValue(d0, d1, d2)) * this.valueFactor;
    }


}