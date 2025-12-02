//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package huase.xiuxianzhilu.datagens;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.worlds.levelstem.REDimensionSettings;
import huase.xiuxianzhilu.worlds.structures.StructuresInit;
import huase.xiuxianzhilu.worlds.worldpresets.REWorldPresets;
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
//                .add(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, MultiNoiseBiomeSourceParameterLists::bootstrap)
//                .add(Registries.NOISE, NoiseData::bootstrap)
//                .add(Registries.DENSITY_FUNCTION, NoiseRouterData::bootstrap)
//                .add(Registries.NOISE_SETTINGS, NoiseGeneratorSettings::bootstrap)
//                .add(Registries.WORLD_PRESET, WorldPresets::bootstrap)

                .add(Registries.STRUCTURE, StructuresInit::bootstrapSTRUCTURE)
                .add(Registries.STRUCTURE_SET, StructuresInit::bootstrapSTRUCTURE_SET)



                .add(Registries.DIMENSION_TYPE, REDimensionSettings::bootstrapType)
                .add(Registries.NOISE_SETTINGS, REDimensionSettings::bootstrapNoise)
                .add(Registries.LEVEL_STEM, REDimensionSettings::bootstrapStem)
                .add(Registries.WORLD_PRESET, REWorldPresets::bootstrap)
//                .add(Registries.FLAT_LEVEL_GENERATOR_PRESET, FlatLevelGeneratorPresets::bootstrap)
//                .add(Registries.CHAT_TYPE, ChatType::bootstrap)
//                .add(Registries.TRIM_PATTERN, TrimPatterns::bootstrap)
//                .add(Registries.TRIM_MATERIAL, TrimMaterials::bootstrap)
//                .add(Registries.DAMAGE_TYPE, DamageTypes::bootstrap)
                ;
    }
}
