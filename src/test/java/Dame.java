import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;

/**
 * - @description:Dame类
 */
public class Dame {
    public static void main(String[] args) {

        WorldgenRandom worldgenrandom = new WorldgenRandom(new LegacyRandomSource(1));
        double[] doubles = {1.0D};
        NormalNoise normalnoise = new NormalNoise(worldgenrandom, -4,  new DoubleArrayList(doubles),true);
        PerlinNoise perlinNoise = PerlinNoise.create(worldgenrandom, -2, new DoubleArrayList(doubles));
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 20; j++) {
                int v = (int) (perlinNoise.getValue(i, 0, j) * 1000);
                System.out.print(v+" ");
            }
            System.out.println("\n");
        }

    }
}
