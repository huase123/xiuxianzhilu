package huase.xiuxianzhilu.capabilitys.capability;

import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuCase;
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
    NormalNoise jingjieNoise;
    NormalNoise gongfaNoise;
    Player player;
    public DensityFunction(PlayerCapability playerCapability, Player player) {
        this.playerCapability = playerCapability;
        this.player =player;
        updateNormalNoise();
    }
//更新密度函数
    public void updateNormalNoise() {
        int size = playerCapability.getLinggens().size();
        jingjieNoise = NormalNoise.create(new WorldgenRandom(new LegacyRandomSource(player.getUUID().getMostSignificantBits())), -9+size, 1);
        gongfaNoise = NormalNoise.create(new WorldgenRandom(new LegacyRandomSource(player.getUUID().getMostSignificantBits()>>2)), -9+size, 1);
    }

    public void update() {
        time++;
    }

    public void synchronize(double time, double dazuo, double danyao) {
        this.time = time;
        this.dazuo = dazuo;
        this.danyao = danyao;
    }

    public double getjingjieNoise() {
        int scale=1;
        double value = jingjieNoise.getValue((double) time / scale, (double) dazuo, (double) danyao);
        LingxiuCase lingxiuCase = playerCapability.getLingxius().get(playerCapability.getLingxius().size() - 1);
        int intensity = lingxiuCase.getIntensity();
        return Math.abs(value*intensity);
    }

    public double getGongfaNoise() {
        int scale=1;
        double value = gongfaNoise.getValue((double) time / scale, (double) dazuo, (double) danyao);
        return value;
    }

    public double value() {
        double value = getjingjieNoise() + getGongfaNoise();
        return value;
    }

}
