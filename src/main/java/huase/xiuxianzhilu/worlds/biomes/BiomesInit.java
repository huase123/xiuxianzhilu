package huase.xiuxianzhilu.worlds.biomes;

import huase.xiuxianzhilu.ModMain;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/**
 * - @description:BiomesInit类
 */
public class BiomesInit {

    public static final ResourceKey<Biome> FOREST = makeKey("forest");
    public static final ResourceKey<Biome> DENSE_FOREST = makeKey("dense_forest");
    public static final ResourceKey<Biome> FIREFLY_FOREST = makeKey("firefly_forest");
    public static final ResourceKey<Biome> CLEARING = makeKey("clearing");
    public static final ResourceKey<Biome> OAK_SAVANNAH = makeKey("oak_savannah");
    public static final ResourceKey<Biome> STREAM = makeKey("stream");
    public static final ResourceKey<Biome> LAKE = makeKey("lake");
    private static ResourceKey<Biome> makeKey(String name) {
        return ResourceKey.create(Registries.BIOME, ModMain.prefix(name));
    }

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> featureGetter = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> carverGetter = context.lookup(Registries.CONFIGURED_CARVER);
//        context.register(FOREST, biomeWithDefaults(fireflyParticles(defaultAmbientBuilder()), defaultMobSpawning(), twilightForestGen(featureGetter, carverGetter)).build());
//        context.register(DENSE_FOREST, biomeWithDefaults(fireflyParticles(defaultAmbientBuilder()).waterColor(0x005522), defaultMobSpawning(), denseForestGen(featureGetter, carverGetter)).temperature(0.7F).downfall(0.8F).build());
    }
}
