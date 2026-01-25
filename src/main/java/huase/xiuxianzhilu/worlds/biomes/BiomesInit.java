package huase.xiuxianzhilu.worlds.biomes;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.worlds.feature.OreFeaturePlacements;
import huase.xiuxianzhilu.worlds.feature.TreeFeaturePlacements;
import huase.xiuxianzhilu.worlds.feature.ZhiwuPlacements;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/**
 * - @description:BiomesInit类
 */
public class BiomesInit {


    public static final ResourceKey<Biome> ZHUJI_BIOME1 = makeKey("zhuji_biome1");
    public static final ResourceKey<Biome> ZHUJI_BIOME2 = makeKey("zhuji_biome2");

    public static final ResourceKey<Biome> JINDAN_BIOME1 = makeKey("jindan_biome1");
    public static final ResourceKey<Biome> JINDAN_BIOME2 = makeKey("jindan_biome2");
    public static final ResourceKey<Biome> JINDAN_BIOME3 = makeKey("jindan_biome3");

    public static final ResourceKey<Biome> YUANYIN_BIOME1 = makeKey("yuanyin_biome1");
    public static final ResourceKey<Biome> YUANYIN_BIOME2 = makeKey("yuanyin_biome2");
    public static final ResourceKey<Biome> YUANYIN_BIOME3 = makeKey("yuanyin_biome3");

    public static final ResourceKey<Biome> HUASHEN_BIOME1 = makeKey("huashen_biome1");
    public static final ResourceKey<Biome> HUASHEN_BIOME2 = makeKey("huashen_biome2");
    public static final ResourceKey<Biome> HUASHEN_BIOME3 = makeKey("huashen_biome3");

    public static final ResourceKey<Biome> JIN_BIOME    = makeKey("jin_biome");
    public static final ResourceKey<Biome> MU_BIOME     = makeKey("mu_biome");
    public static final ResourceKey<Biome> SHUI_BIOME   = makeKey("shui_biome");
    public static final ResourceKey<Biome> HUO_BIOME    = makeKey("huo_biome");
    public static final ResourceKey<Biome> TU_BIOME     = makeKey("tu_biome");

    public static final ResourceKey<Biome> xiuxianjie_biome0     = makeKey("xiuxianjie_biome0");
    public static final ResourceKey<Biome> xiuxianjie_biome1     = makeKey("xiuxianjie_biome1");
    public static final ResourceKey<Biome> xiuxianjie_biome2     = makeKey("xiuxianjie_biome2");
    public static final ResourceKey<Biome> xiuxianjie_biome3     = makeKey("xiuxianjie_biome3");
    public static final ResourceKey<Biome> xiuxianjie_biome4     = makeKey("xiuxianjie_biome4");
    public static final ResourceKey<Biome> xiuxianjie_biome5     = makeKey("xiuxianjie_biome5");
    public static final ResourceKey<Biome> xiuxianjie_biome6     = makeKey("xiuxianjie_biome6");
    public static final ResourceKey<Biome> xiuxianjie_biome7     = makeKey("xiuxianjie_biome7");
    public static final ResourceKey<Biome> xiuxianjie_biome8     = makeKey("xiuxianjie_biome8");
    public static final ResourceKey<Biome> xiuxianjie_biome9     = makeKey("xiuxianjie_biome9");
    public static final ResourceKey<Biome> xiuxianjie_biome10     = makeKey("xiuxianjie_biome10");


    private static ResourceKey<Biome> makeKey(String name) {
        return ResourceKey.create(Registries.BIOME, ModMain.prefix(name));
    }

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> featureGetter = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carverGetter = context.lookup(Registries.CONFIGURED_CARVER);


        context.register(xiuxianjie_biome0 , biomeWithDefaults(0.5f,0.0f,fireflyParticles  (defaultSHAmbientBuilder(0x0111fd4e)), defaultSpawning(), xiuxianjie_biome0_Placement(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome1 , biomeWithDefaults(0.5f,0.1f,fireflyParticles  (defaultSHAmbientBuilder(0x0211cd4e)), defaultSpawning(), xiuxianjie_biome1_Placement(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome2 , biomeWithDefaults(0.5f,0.5f,fireflyParticles  (defaultSHAmbientBuilder(0x0311ad4e)), defaultSpawning(), xiuxianjie_biome2_Placement(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome3 , biomeWithDefaults(0.5f,0.0f,fireflyParticles  (defaultSHAmbientBuilder(0xffffffff)), defaultSpawning(), xiuxianjie_biome3_Placement(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome4 , biomeWithDefaults(0.5f,0.2f,fireflyParticles  (defaultSHAmbientBuilder(0x0161cd6e)), defaultSpawning(), xiuxianjie_biome4_Placement(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome5 , biomeWithDefaults(0.5f,0.2f,fireflyParticles  (defaultSHAmbientBuilder(0x0141fd1e)), defaultSpawning(), xiuxianjie_biome5_Placement(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome6 , biomeWithDefaults(0.5f,0.0f,fireflyParticles  (defaultSHAmbientBuilder(0x01111199)), defaultSpawning(), xiuxianjie_biome6_Placement(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome7 , biomeWithDefaults(0.5f,0.5f,fireflyParticles  (defaultSHAmbientBuilder(0x55ff1111)), defaultSpawning(), xiuxianjie_biome7_Placement(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome8 , biomeWithDefaults(-2.0f,0.5f,fireflyParticles  (defaultSHAmbientBuilder(0x55999999)), defaultSpawning(), xiuxianjie_biome8_Placement(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome9 , biomeWithDefaults(-2.0f,2.5f,fireflyParticles  (defaultSHAmbientBuilder(0x55111199)), defaultSpawning(), xiuxianjie_biome9_Placement(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome10, biomeWithDefaults(0.5f,0.0f,fireflyParticles  (defaultSHAmbientBuilder(0x11111133)), defaultSpawning(), xiuxianjie_biome10_Placement(featureGetter, carverGetter)).build());

   }


    public static Biome.BiomeBuilder biomeWithDefaults(float temperature,float downfall,BiomeSpecialEffects.Builder biomeAmbience, MobSpawnSettings.Builder mobSpawnInfo, BiomeGenerationSettings.Builder biomeGenerationSettings) {
        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(temperature)
                .temperatureAdjustment(Biome.TemperatureModifier.FROZEN)
                .downfall(downfall)
                .specialEffects(biomeAmbience.build())
                .mobSpawnSettings(mobSpawnInfo.build())
                .generationSettings(biomeGenerationSettings.build())
                .temperatureAdjustment(Biome.TemperatureModifier.NONE);
    }


    public static BiomeSpecialEffects.Builder fireflyParticles(BiomeSpecialEffects.Builder builder) {
//        builder.ambientParticle(new AmbientParticleSettings(SHParticleType.WANDERING_FIREFLY.get(), 0.005f));
        builder.ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.05f));
        return builder;
    }



    public static BiomeSpecialEffects.Builder defaultSHAmbientBuilder(int color) {
        return new BiomeSpecialEffects.Builder()
                .waterColor(color)
                .waterFogColor(color)
                .fogColor(0x01aaffaa)
                .skyColor(0x01aaffaa)
                .foliageColorOverride(color)
                .grassColorOverride(color)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS) // We should probably change it
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_NETHER_WASTES));

    }




    public static MobSpawnSettings.Builder defaultSpawning() {
        MobSpawnSettings.Builder spawnInfo = new MobSpawnSettings.Builder();
        spawnInfo.creatureGenerationProbability(0.004f);
        spawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 10, 2, 5));
        spawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 12, 4, 4));
        spawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 10, 4, 4));
        spawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 8, 4, 4));
        spawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1));
//        spawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityInit.xiushientity.get(), 1, 1, 1));
        spawnInfo.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 100, 4, 8));
        return spawnInfo;
    }


    public static BiomeGenerationSettings.Builder defaultGenSettingBuilder(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder biome = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);

        BiomeDefaultFeatures.addDefaultOres(biome);
        BiomeDefaultFeatures.addDefaultSoftDisks(biome);
        BiomeDefaultFeatures.addForestGrass(biome);
        BiomeDefaultFeatures.addSavannaGrass(biome);
        BiomeDefaultFeatures.addDefaultGrass(biome);
        BiomeDefaultFeatures.addSavannaExtraGrass(biome);
        biome.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE);
//        biome.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreeFeaturesGen.lingguo0.);
        BiomeDefaultFeatures.addSurfaceFreezing(biome);
        return biome;
    }

    private static BiomeGenerationSettings.Builder xiuxianjie_biome0_Placement(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder builder = defaultGenSettingBuilder(featureGetter, carverGetter);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.lingyv0_placed);

        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu2_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder xiuxianjie_biome1_Placement(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder builder = defaultGenSettingBuilder(featureGetter, carverGetter);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreeFeaturePlacements.grassland_lingmu0_placed);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.xvantie0_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu3_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder xiuxianjie_biome2_Placement(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder builder = defaultGenSettingBuilder(featureGetter, carverGetter);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreeFeaturePlacements.mountainous_lingmu1_placed);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.lingjin0_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu0_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder xiuxianjie_biome3_Placement(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder builder = defaultGenSettingBuilder(featureGetter, carverGetter);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.xvantie1_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu4_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder xiuxianjie_biome4_Placement(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder builder = defaultGenSettingBuilder(featureGetter, carverGetter);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.lingjin1_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu6_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder xiuxianjie_biome5_Placement(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder builder = defaultGenSettingBuilder(featureGetter, carverGetter);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreeFeaturePlacements.deepforest_lingmu0_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreeFeaturePlacements.deepforest_lingmu2_placed);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.lingyv1_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu7_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder xiuxianjie_biome6_Placement(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder builder = defaultGenSettingBuilder(featureGetter, carverGetter);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.xvantie2_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu8_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder xiuxianjie_biome7_Placement(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder builder = defaultGenSettingBuilder(featureGetter, carverGetter);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.lingyv2_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu10_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder xiuxianjie_biome8_Placement(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder builder = defaultGenSettingBuilder(featureGetter, carverGetter);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.lingjin2_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu11_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder xiuxianjie_biome9_Placement(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder builder = defaultGenSettingBuilder(featureGetter, carverGetter);
        BiomeDefaultFeatures.addIcebergs(builder);
        BiomeDefaultFeatures.addBlueIce(builder);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreeFeaturePlacements.glacier_lingmu3_placed);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.lingjin3_placed);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.lingyv3_placed);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.xvantie3_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu12_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu14_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu15_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder xiuxianjie_biome10_Placement(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder builder = defaultGenSettingBuilder(featureGetter, carverGetter);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.lingjin3_placed);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.lingyv3_placed);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreFeaturePlacements.xvantie3_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu16_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu17_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu18_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ZhiwuPlacements.zhiwu19_placed);
        return builder;
    }

}
