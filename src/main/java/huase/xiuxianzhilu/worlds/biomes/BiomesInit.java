package huase.xiuxianzhilu.worlds.biomes;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.worlds.feature.TreeFeaturePlacements;
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


        context.register(xiuxianjie_biome0 , biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0111fd4e)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome1 , biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0111cd4e)), defaultSpawning(), grasslandTreePlacement(defaultGenSettingBuilder(featureGetter, carverGetter))).build());
        context.register(xiuxianjie_biome2 , biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0111ad4e)), defaultSpawning(), mountainousAreaTreePlacement(defaultGenSettingBuilder(featureGetter, carverGetter))).build());
        context.register(xiuxianjie_biome3 , biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x11ffffff)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome4 , biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0161cd6e)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome5 , biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0111fd1e)), defaultSpawning(), deepForestAreaTreePlacement(defaultGenSettingBuilder(featureGetter, carverGetter))).build());
        context.register(xiuxianjie_biome6 , biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x01111199)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome7 , biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x55ff1111)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome8 , biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x55999999)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(xiuxianjie_biome9 , biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x55111199)), defaultSpawning(), glacierTreePlacement(defaultGenSettingBuilder(featureGetter, carverGetter))).build());
        context.register(xiuxianjie_biome10, biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x55111133)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());


        context.register(ZHUJI_BIOME1, biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0111fd4e)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(ZHUJI_BIOME2, biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0111fd4e)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());

        context.register(JINDAN_BIOME1, biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0111fd9c)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(JINDAN_BIOME2, biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0111fd9c)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(JINDAN_BIOME3, biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0111fd9c)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());

        context.register(YUANYIN_BIOME1, biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0111fde4)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(YUANYIN_BIOME2, biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0111fde4)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(YUANYIN_BIOME3, biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x0111fde4)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());

        context.register(HUASHEN_BIOME1, biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x017dfbf4)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(HUASHEN_BIOME2, biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x017dfbf4)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(HUASHEN_BIOME3, biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x017dfbf4)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());


        context.register(JIN_BIOME  , biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x01ffea00)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(MU_BIOME   , biomeWithDefaults(fireflyParticles   (defaultSHAmbientBuilder(0x013cff00)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(SHUI_BIOME , biomeWithDefaults(fireflyParticles (defaultSHAmbientBuilder(0x016faffe)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(HUO_BIOME  , biomeWithDefaults(fireflyParticles  (defaultSHAmbientBuilder(0x01c4360f)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
        context.register(TU_BIOME   , biomeWithDefaults(fireflyParticles   (defaultSHAmbientBuilder(0x01925f36)), defaultSpawning(), defaultGenSettingBuilder(featureGetter, carverGetter)).build());
    }


    public static Biome.BiomeBuilder biomeWithDefaults(BiomeSpecialEffects.Builder biomeAmbience, MobSpawnSettings.Builder mobSpawnInfo, BiomeGenerationSettings.Builder biomeGenerationSettings) {
        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.5F)
                .downfall(0.5F)
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
                .waterColor(0x01aaffaa)
                .waterFogColor(0x01aaffaa)
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

    private static BiomeGenerationSettings.Builder grasslandTreePlacement(BiomeGenerationSettings.Builder builder) {

        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreeFeaturePlacements.grassland_lingmu0_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder mountainousAreaTreePlacement(BiomeGenerationSettings.Builder builder) {

        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreeFeaturePlacements.mountainous_lingmu1_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder deepForestAreaTreePlacement(BiomeGenerationSettings.Builder builder) {

        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreeFeaturePlacements.deepforest_lingmu0_placed);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreeFeaturePlacements.deepforest_lingmu2_placed);
        return builder;
    }
    private static BiomeGenerationSettings.Builder glacierTreePlacement(BiomeGenerationSettings.Builder builder) {

        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreeFeaturePlacements.glacier_lingmu3_placed);
        return builder;
    }
}
