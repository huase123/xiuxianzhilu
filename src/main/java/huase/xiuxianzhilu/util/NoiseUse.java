package huase.xiuxianzhilu.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
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
    public static double getLingliLV(Level level,int x,int y,int z) {
        if(serverLevel == null || seed == 0L || normalNoise == null){
            if(level instanceof ServerLevel serverLevel1){
                serverLevel = serverLevel1;
            }else {
                serverLevel = getServerLevel();
            }
            seed = serverLevel.getSeed();
            normalNoise = NormalNoise.create(new WorldgenRandom(new LegacyRandomSource(seed)), -5, 1);
        }


        double value = normalNoise.getValue(x<<8, y<<8, z<<8)-0.7;

        return value;
    }

}
