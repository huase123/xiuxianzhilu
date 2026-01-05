package huase.xiuxianzhilu.capabilitys.capability;

import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaCase;
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
//    用于客户端平滑插值
    public double newtime = 0;
    public double newdazuo = 0;
    public double newdanyao = 0;
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
        gongfaNoise = NormalNoise.create(new WorldgenRandom(new LegacyRandomSource(player.getUUID().getMostSignificantBits()>>2)), -9, 1);
    }

    public void update(Player player) {

        newtime++;
        time++;

        if (((int)time) % 20 == 0L) {
            LingxiuCase lingxiu = playerCapability.getLingxiuindex();
            if(lingxiu == null)return;


            double value = value();
            lingxiu.addJingyan(player,value);
        }

    }

    public void updateClientState(float partialTick) {
        time += (newtime-time)*0.01 * partialTick;
        dazuo += (newdazuo-dazuo)*0.01 * partialTick;
        danyao += (newdanyao-danyao)*0.01 *partialTick;
    }
    public void synchronizeClient(double time, double dazuo, double danyao) {
        this.newtime = time;
        this.newdazuo = dazuo;
        this.newdanyao = danyao;
    }

    public double getjingjieValue() {
        LingxiuCase lingxiu = playerCapability.getLingxiuindex();
        if(lingxiu == null)return 0;
        double value = getjingjieNoise();
        float intensity =lingxiu.getIntensity();
        return Math.abs(value*intensity);
    }
    public double getjingjieNoise() {
        LingxiuCase lingxiu = playerCapability.getLingxiuindex();
        if(lingxiu == null)return 0;
        float scale=100.0f;
        double value = jingjieNoise.getValue(time / scale,  dazuo,danyao);
        return value;
    }

    public double getGongfaValue() {
        GongfaCase gongfaindex = playerCapability.getGongfaindex();
        if(gongfaindex == null)return 0;
        double value = getGongfaNoise();
        int intensity = gongfaindex.getIntensity();
        return Math.abs(value*intensity);
    }
    public double getGongfaNoise() {
        GongfaCase gongfaindex = playerCapability.getGongfaindex();
        if(gongfaindex == null)return 0;
        float scale=100.0f;
        double value = gongfaNoise.getValue(time / scale, dazuo, danyao);
        return value;
    }

    public double value() {
        double value = getjingjieValue() + getGongfaValue();
        return value;
    }

}
