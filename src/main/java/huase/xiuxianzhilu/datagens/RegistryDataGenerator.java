//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package huase.xiuxianzhilu.datagens;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.worlds.biomes.BiomesInit;
import huase.xiuxianzhilu.worlds.densityfunctions.DensityFunctionGen;
import huase.xiuxianzhilu.worlds.dimensiontype.DimensionTypeGen;
import huase.xiuxianzhilu.worlds.levelstem.LevelStemGen;
import huase.xiuxianzhilu.worlds.multinoisebiomesourceparameterlists.MultiNoiseBiomeSourceParameterListGen;
import huase.xiuxianzhilu.worlds.noisegeneratorsettings.NoiseGeneratorSettingsGen;
import huase.xiuxianzhilu.worlds.noises.NoiseGen;
import huase.xiuxianzhilu.worlds.structures.StructuresInit;
import huase.xiuxianzhilu.worlds.worldpresets.WorldPresetsGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RegistryDataGenerator extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER;

    public RegistryDataGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
//        super(output, provider, BUILDER, Set.of("minecraft", "shxiuxian"));
        super(output, provider, BUILDER, Set.of("minecraft", ModMain.MOD_ID));
    }
 static {
        BUILDER = (new RegistrySetBuilder())
//                .add(Registries.DIMENSION_TYPE, DimensionTypes::bootstrap)
//                .add(Registries.CONFIGURED_CARVER, (RegistrySetBuilder.RegistryBootstrap) Carvers::bootstrap)
//                .add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) FeatureUtils::bootstrap)
//                .add(Registries.PLACED_FEATURE, PlacementUtils::bootstrap)
//                .add(Registries.STRUCTURE, Structures::bootstrap)
//                .add(Registries.STRUCTURE_SET, StructureSets::bootstrap)
//                .add(Registries.PROCESSOR_LIST, ProcessorLists::bootstrap)
//                .add(Registries.TEMPLATE_POOL, Pools::bootstrap)
//                .add(Registries.BIOME, BiomeData::bootstrap)
                .add(Registries.BIOME, BiomesInit::bootstrap)
//                .add(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, MultiNoiseBiomeSourceParameterLists::bootstrap)
//                .add(Registries.NOISE, NoiseData::bootstrap)
//                .add(Registries.DENSITY_FUNCTION, NoiseRouterData::bootstrap)
                .add(Registries.DENSITY_FUNCTION, DensityFunctionGen::bootstrap)
//                .add(Registries.NOISE_SETTINGS, NoiseGeneratorSettings::bootstrap)
//                .add(Registries.WORLD_PRESET, WorldPresets::bootstrap)

                .add(Registries.STRUCTURE, StructuresInit::bootstrapSTRUCTURE)
                .add(Registries.STRUCTURE_SET, StructuresInit::bootstrapSTRUCTURE_SET)



                .add(Registries.NOISE, NoiseGen::bootstrap)

                .add(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, MultiNoiseBiomeSourceParameterListGen::bootstrap)
                .add(Registries.NOISE_SETTINGS, NoiseGeneratorSettingsGen::bootstrapNoise)
                .add(Registries.DIMENSION_TYPE, DimensionTypeGen::bootstrapType)
                .add(Registries.LEVEL_STEM, LevelStemGen::bootstrapStem)
                .add(Registries.WORLD_PRESET, WorldPresetsGen::bootstrap)


                .add(LingxiujingjieGen.lingxiu_jingjie_key, LingxiujingjieGen::bootstrap)
                .add(GongfaGen.gongfa_key, GongfaGen::bootstrap)
//                .add(Registries.FLAT_LEVEL_GENERATOR_PRESET, FlatLevelGeneratorPresets::bootstrap)
//                .add(Registries.CHAT_TYPE, ChatType::bootstrap)
//                .add(Registries.TRIM_PATTERN, TrimPatterns::bootstrap)
//                .add(Registries.TRIM_MATERIAL, TrimMaterials::bootstrap)
//                .add(Registries.DAMAGE_TYPE, DamageTypes::bootstrap)
                ;
    }
}
