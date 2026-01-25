package huase.xiuxianzhilu.worlds.feature;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.worlds.feature.features.ZhiwuFeature;
import huase.xiuxianzhilu.worlds.feature.features.ZhiwuFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:FeatureInit类
 */
public class FeatureInit {

    public static final DeferredRegister<Feature<?>> FEATURE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, ModMain.MODID);

    public static final RegistryObject<Feature<ZhiwuFeatureConfiguration>> zhiwu = FEATURE_DEFERRED_REGISTER.register("zhiwu", () -> new ZhiwuFeature(ZhiwuFeatureConfiguration.CODEC));
}
