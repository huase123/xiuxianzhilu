package huase.xiuxianzhilu.capabilitys.capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

/**
 * - @description:DensityFunction类
 */
public class DensityFunction {
    public double time = 0;
    public double dazuo = 0;
    public double danyao = 0;
    PlayerCapability playerCapability;
    NormalNoise normalNoise;
    Player player;
    public DensityFunction(PlayerCapability playerCapability, Player player) {
        this.playerCapability = playerCapability;
        this.player =player;
        updateNormalNoise();
    }
//更新密度函数
    public void updateNormalNoise() {
        normalNoise = NormalNoise.create(new WorldgenRandom(new LegacyRandomSource(player.getUUID().getMostSignificantBits())), -9, 1);
    }

    public void update() {
        time++;
    }

    public void synchronize(double time, double dazuo, double danyao) {
        this.time = time;
        this.dazuo = dazuo;
        this.danyao = danyao;
    }

    public double value() {
        int scale=1;
        return normalNoise.getValue((double) time /scale, (double) dazuo , (double) danyao);
    }

}
