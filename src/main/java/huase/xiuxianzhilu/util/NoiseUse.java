package huase.xiuxianzhilu.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import javax.annotation.Nullable;

/**
 * - @description:NoiseUse类
 */
public class NoiseUse {
    public static NormalNoise normalNoise;
    public static  ServerLevel serverLevel;
    public static  long seed = 0L;
    @Nullable
    private static ServerLevel getServerLevel() {
        IntegratedServer integratedserver = Minecraft.getInstance().getSingleplayerServer();
        return integratedserver != null ? integratedserver.getLevel(Minecraft.getInstance().level.dimension()) : null;
    }
    public static double getLingliDensity(Level level, int x, int y, int z) {
        if(serverLevel == null || seed == 0L || normalNoise == null){
            if(level instanceof ServerLevel serverLevel1){
                serverLevel = serverLevel1;
            }else {
                serverLevel = getServerLevel();
            }
            seed = serverLevel.getSeed();
            normalNoise = NormalNoise.create(RandomSource.create(seed), -5, 1);
        }


        double value = normalNoise.getValue(x<<8, y<<8, z<<8)-0.7;

        return value;
    }

    public static int getLingliDensity(Level level, BlockPos pPos) {
        int x0 = pPos.getX()>>4;
        int y0 = pPos.getY()>>4;
        int z0 = pPos.getZ()>>4;
        double lingliDensity = NoiseUse.getLingliDensity(Minecraft.getInstance().level, x0, y0, z0);
//        double max = Math.max(0.0D, lingliDensity);
        double v = 1.7D + lingliDensity;
        return (int) (v*100);
    }
}
