package huase.xiuxianzhilu.entity.moster.xiushi;

import huase.xiuxianzhilu.capabilitys.CapabilityUtil;
import huase.xiuxianzhilu.capabilitys.capability.PlayerCapability;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuCase;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import huase.xiuxianzhilu.entity.moster.MosterBaseEntity;
import huase.xiuxianzhilu.items.Iteminit;
import huase.xiuxianzhilu.worlds.biomes.BiomesInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

import static huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen.lingxiu_jingjie_key;

/**
 * - @description:ChilingshuisheEntity类
 */
public class XiushiEntity extends MosterBaseEntity {
    public XiushiEntity(EntityType<? extends Monster> type, Level world) {
        super(type, world);
    }
    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));

    }

    protected void dropAllDeathLoot(DamageSource pDamageSource) {
        super.dropAllDeathLoot(pDamageSource);
        LingxiuCase lingxiu = CapabilityUtil.getCapability(this).getLingxiu();
        if(lingxiu != null){
            LingxiuJingjieSample lingxiuJingjie = lingxiu.getLingxiuJingjie();
            if(lingxiuJingjie.equals(this.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.lianqi))) {
                this.spawnAtLocation(Iteminit.gongfa0.get(),0.2f);
                this.spawnAtLocation(Iteminit.lingshi0.get(),0.6f,1);
            }else if (lingxiuJingjie.equals(this.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.zhuji))) {
                this.spawnAtLocation(Iteminit.gongfa1.get(),0.2f);
                this.spawnAtLocation(Iteminit.lingshi0.get(),0.6f,3);
            }else if (lingxiuJingjie.equals(this.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.jindan))) {
                this.spawnAtLocation(Iteminit.gongfa2.get(),0.1f);
                this.spawnAtLocation(Iteminit.lingshi1.get(),0.6f,1);
            }else if (lingxiuJingjie.equals(this.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.yuanying))) {
                this.spawnAtLocation(Iteminit.gongfa3.get(),0.1f);
                this.spawnAtLocation(Iteminit.lingshi1.get(),0.6f,2);
            }else if (lingxiuJingjie.equals(this.level().registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.huashen))) {
                this.spawnAtLocation(Iteminit.gongfa4.get(),0.1f);
                this.spawnAtLocation(Iteminit.lingshi2.get(),0.2f,1);

            }
        }

    }

    private void spawnAtLocation(ItemLike pItem, float v) {
        if(random.nextFloat()<= v){
            this.spawnAtLocation(pItem);
        }
    }
    private void spawnAtLocation(ItemLike pItem, float v,int num) {
        if(random.nextFloat()<= v){
            this.spawnAtLocation(new ItemStack(pItem,random.nextInt(num)+1));
        }
    }

    @Override
    public void initCapability(LivingEntity livingEntity, Level level) {
        PlayerCapability capability = CapabilityUtil.getCapability(livingEntity);

        LingxiuJingjieSample lingxiuJingjieSample = getEntitylivingabstract(level,livingEntity.getOnPos());

        if(lingxiuJingjieSample != null){
            CapabilityUtil.addLingxiuCase(livingEntity,new LingxiuCase(livingEntity,lingxiuJingjieSample).amplification(3));
        }

        LingxiuCase lingxiu = capability.getLingxiu();
        if(lingxiu !=null){
            ResourceLocation key = level.registryAccess().registryOrThrow(lingxiu_jingjie_key).getKey(lingxiu.getLingxiuJingjie());
            if(key != null){
                livingEntity.setCustomName(Component.translatable(livingEntity.getDisplayName().getString()).append("--------").append(Component.translatable(key.toString())));
            }
        }

    }

    private LingxiuJingjieSample getEntitylivingabstract(Level level, BlockPos onPos) {
        Holder<Biome> biome = level.getBiome(onPos);
        if(biome.is(BiomesInit.xiuxianjie_biome0)){
            return level.registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.lianqi);
        }
        if(biome.is(BiomesInit.xiuxianjie_biome1)){
            return level.registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.lianqi);
        }
        if(biome.is(BiomesInit.xiuxianjie_biome2)){
            return level.registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.lianqi);
        }
        if(biome.is(BiomesInit.xiuxianjie_biome3)){
            return level.registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.zhuji);
        }
        if(biome.is(BiomesInit.xiuxianjie_biome4)){
            return level.registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.zhuji);
        }
        if(biome.is(BiomesInit.xiuxianjie_biome5)){
            return level.registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.zhuji);
        }
        if(biome.is(BiomesInit.xiuxianjie_biome6)){
            return level.registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.jindan);
        }
        if(biome.is(BiomesInit.xiuxianjie_biome7)){
            return level.registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.jindan);
        }
        if(biome.is(BiomesInit.xiuxianjie_biome8)){
            return level.registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.jindan);
        }
        if(biome.is(BiomesInit.xiuxianjie_biome9)){
            return level.registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.yuanying);
        }
        if(biome.is(BiomesInit.xiuxianjie_biome10)){
            return level.registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.huashen);
        }

        return level.registryAccess().registryOrThrow(lingxiu_jingjie_key).get(LingxiujingjieGen.lianqi);
    }

}
