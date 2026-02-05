package huase.xiuxianzhilu.worlds.structures;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.worlds.structures.text.TextStructure;
import huase.xiuxianzhilu.worlds.structures.text.TextStructurePiece;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class StructuresInit {



/**
 * TODO 功能描述：注册表，用于注册自定义StructurePiece
 * @author :huase
 * @date 2025/12/2 17:24
 */
    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPE_Registries = DeferredRegister.create(Registries.STRUCTURE_PIECE, ModMain.MOD_ID);
    public static final RegistryObject<StructurePieceType> text_structure_piece_type = STRUCTURE_PIECE_TYPE_Registries.register("text_structure_piece_type",() -> TextStructurePiece::new);


    /**
     * TODO 功能描述：注册表，用于注册自定义Structure
     * @author :huase
     * @date 2025/12/2 17:24
     */
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPE_Registries = DeferredRegister.create(Registries.STRUCTURE_TYPE, ModMain.MOD_ID);
    public static final RegistryObject<StructureType<TextStructure>> text_structure_type = STRUCTURE_TYPE_Registries.register("text_structure_type", () -> () -> TextStructure.CODEC);


//    结构创建
    public static final ResourceKey<Structure> text_structure = ResourceKey.create(Registries.STRUCTURE, ModMain.prefix("text_structure"));
//    结构布置
    public static final ResourceKey<StructureSet> text_structureset = ResourceKey.create(Registries.STRUCTURE_SET, ModMain.prefix("text_structureset"));


    public static void bootstrapSTRUCTURE(BootstapContext<Structure> context) {
        context.register(text_structure, new TextStructure(new Structure.StructureSettings(
                        context.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_OVERWORLD),
                        Map.of(MobCategory.MONSTER,
                                new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE, MobSpawnSettings.EMPTY_MOB_LIST),
                                MobCategory.UNDERGROUND_WATER_CREATURE,
                                new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE, MobSpawnSettings.EMPTY_MOB_LIST),
                                MobCategory.AXOLOTLS,
                                new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE, MobSpawnSettings.EMPTY_MOB_LIST)
                        ),
                        GenerationStep.Decoration.UNDERGROUND_STRUCTURES,
                        TerrainAdjustment.BEARD_BOX
                    )
                )
        );
    }

    public static <T> void bootstrapSTRUCTURE_SET(BootstapContext<StructureSet> tBootstapContext) {

        HolderGetter<Structure> holdergetter = tBootstapContext.lookup(Registries.STRUCTURE);
        tBootstapContext.register(text_structureset, new StructureSet(holdergetter.getOrThrow(text_structure), new RandomSpreadStructurePlacement(20, 4, RandomSpreadType.TRIANGULAR, 428149644)));

    }
}
