package huase.xiuxianzhilu.worlds.dimensiontype;

import huase.xiuxianzhilu.ModMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.OptionalLong;

/**
 * - @description:DimensionTypeGen类
 */
public class DimensionTypeGen {

    /**
     * TODO 功能描述：维度类型
     * @author :huase
     * @date 2025/11/30 1:02
     */
    public static final ResourceKey<DimensionType> XIUXIUZHILU_DIMENSIONN_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, ModMain.prefix("xiuxiuzhilu_dimensionn_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        DimensionType dimensionType = new DimensionType(
                OptionalLong.of(13000L), //fixed time
                true, //skylight
                false, //ceiling
                false, //ultrawarm
                true, //natural
                8D, //coordinate scale
                true, //bed works
                true, //respawn anchor works
                -32, // Minimum Y Level
                32 + 256, // Height + Min Y = Max Y
                32 + 256, // Logical Height
                BlockTags.INFINIBURN_OVERWORLD, //infiburn
                ModMain.prefix("xiuxianzhiludimensionrenderinfo"), // DimensionRenderInfo
                0f, // Wish this could be set to -0.05 since it'll make the world truly blacked out if an area is not sky-lit (see: Dark Forests) Sadly this also messes up night vision so it gets 0
                new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 7)
        );

        DimensionType dimensionType1 = new DimensionType(OptionalLong.empty(),
                true,
                false,
                false,
                true,
                1.0D,
                true,
                false,
                -64,
                384,
                384,
                BlockTags.INFINIBURN_OVERWORLD,
                BuiltinDimensionTypes.OVERWORLD_EFFECTS,
                0.0F,
                new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0));

        context.register(XIUXIUZHILU_DIMENSIONN_TYPE, dimensionType1);
    }

}
