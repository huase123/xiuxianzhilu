package huase.xiuxianzhilu.capabilitys.capability;

import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaCase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuCase;
import net.minecraft.world.entity.Entity;
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
//    用于客户端平滑插值
    public double newtime = 0;
    public double newdazuo = 0;
    public double newdanyao = 0;
    PlayerCapability playerCapability;
    NormalNoise jingjieNoise;
    NormalNoise gongfaNoise;
    Entity entity;
    /**
     * TODO 问题描述：未知原因，第一次启动游戏进入世界时，获取客户端与服务端玩家的UUID不一致，所以用@see mostSignificantBits 变量来向客户端同步seed
     * @author :huase
     * @date 2026/2/5 18:24
     */
    public long mostSignificantBits;
    public DensityFunction(PlayerCapability playerCapability, Entity entity) {
        this.playerCapability = playerCapability;
        this.entity = entity;
        updateNormalNoise(entity.getUUID().getMostSignificantBits());
    }
//更新密度函数,灵根改变再调用
    public void updateNormalNoise(long mostSignificantBits) {
        this.mostSignificantBits =mostSignificantBits;
        int size = playerCapability.getLinggens().size();
        jingjieNoise = NormalNoise.create(new WorldgenRandom(new LegacyRandomSource(mostSignificantBits)), -9+size, 1);
        gongfaNoise = NormalNoise.create(new WorldgenRandom(new LegacyRandomSource(mostSignificantBits >>2)), -9, 1);
    }

    public void update(Player player) {

        newtime++;
        time++;

        if(!player.level().isClientSide){
            if (((int)time) % 20 == 0L) {
                LingxiuCase lingxiu = playerCapability.getLingxiu();
                if(lingxiu == null)return;


                double value = value()/10;
                lingxiu.addJingyan(player,value);
                playerCapability.setIsupdate(true);
            }
        }

    }

    public void updateClientState(float partialTick) {
//        time += (newtime-time)*0.01 * partialTick;
//        dazuo += (newdazuo-dazuo)*0.01 * partialTick;
//        danyao += (newdanyao-danyao)*0.01 *partialTick;
    }
    public void synchronizeClient(double time, double dazuo, double danyao, long mostSignificantBits) {
        this.newtime = time;
        this.newdazuo = dazuo;
        this.newdanyao = danyao;
        this.time = time;
        this.dazuo = dazuo;
        this.danyao = danyao;
        if(this.mostSignificantBits != mostSignificantBits)updateNormalNoise(mostSignificantBits);
    }

    public double getjingjieValue() {
        LingxiuCase lingxiu = playerCapability.getLingxiu();
        if(lingxiu == null)return 0;
        double value = getjingjieNoise();
        if(value<0)value = value/4;
        float intensity =lingxiu.getIntensity();
//        return Math.abs(value*intensity);
//        return Math.max(0,value*intensity);
        return value*intensity;
    }
    public double getjingjieNoise() {
        LingxiuCase lingxiu = playerCapability.getLingxiu();
        if(lingxiu == null)return 0;
        float scale=100.0f;
        double value = jingjieNoise.getValue(time / scale,  dazuo,danyao);
        return value;
    }

    public double getGongfaValue() {
        GongfaCase gongfaindex = playerCapability.getGongfa();
        if(gongfaindex == null)return 0;
//        double value = getGongfaNoise();
        float intensity = gongfaindex.getIntensity();
//        return Math.abs(value*intensity);
        return Math.abs(intensity/5);
    }
    public double getGongfaNoise() {
        GongfaCase gongfaindex = playerCapability.getGongfa();
        if(gongfaindex == null)return 0;
        float scale=100.0f;
        double value = gongfaNoise.getValue(time / scale, dazuo, danyao);
        return value;
    }

    public double value() {
        double value = getjingjieValue() + getGongfaValue();
        return value;
    }

    public void dazuotiaozheng(Player player, List<Entity> passengers) {
        newdazuo++;
        dazuo++;
    }
}
