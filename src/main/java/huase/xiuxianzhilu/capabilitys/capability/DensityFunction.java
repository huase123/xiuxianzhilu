package huase.xiuxianzhilu.capabilitys.capability;

import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuCase;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

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
//更新密度函数,灵根改变再调用
    public void updateNormalNoise() {
        int size = playerCapability.getLinggens().size();
        jingjieNoise = NormalNoise.create(new WorldgenRandom(new LegacyRandomSource(player.getUUID().getMostSignificantBits())), -9+size, 1);
        gongfaNoise = NormalNoise.create(new WorldgenRandom(new LegacyRandomSource(player.getUUID().getMostSignificantBits()>>2)), -9+size, 1);
    }

    public void update(Player player) {
        time++;

        if (time %20 == 0L) {
            List<LingxiuCase> lingxius = playerCapability.getLingxius();
            if(lingxius.isEmpty())return;


            double value = value();
            lingxius.get(lingxius.size()-1).addJingyan(player,value);
            if(!player.level().isClientSide){

            }
        }

    }

    public void synchronize(double time, double dazuo, double danyao) {
        this.time = time;
        this.dazuo = dazuo;
        this.danyao = danyao;
    }

    public double getjingjieNoise() {
        int scale=1;
        double value = jingjieNoise.getValue((double) time / scale, (double) dazuo, (double) danyao);
        List<LingxiuCase> lingxius = playerCapability.getLingxius();
        int intensity =lingxius.isEmpty()? 1:lingxius.get(lingxius.size() - 1).getIntensity();
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
