package huase.xiuxianzhilu.worlds.feature.treedecorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;

/**
 * - @description:LingguoDecorator类
 */
public class LingguoDecorator  extends TreeDecorator {
    public static final Codec<LingguoDecorator> CODEC = RecordCodecBuilder.create((lingguoDecoratorInstance) -> lingguoDecoratorInstance.group(
            Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter((lingguoDecorator) -> lingguoDecorator.probability),
            BlockStateProvider.CODEC.fieldOf("block_provider").forGetter((lingguoDecorator) -> lingguoDecorator.blockProvider)
    ).apply(lingguoDecoratorInstance, LingguoDecorator::new));
    private static final Direction WORLDGEN_FACING = Direction.SOUTH;
    private static final Direction[] SPAWN_DIRECTIONS = Direction.Plane.HORIZONTAL.stream().filter((p_202307_) -> {
        return p_202307_ != WORLDGEN_FACING.getOpposite();
    }).toArray((p_202297_) -> {
        return new Direction[p_202297_];
    });
    /** Probability to generate a beehive */
    private final float probability;
    private final BlockStateProvider blockProvider;

    public LingguoDecorator(float probability,BlockStateProvider blockProvider) {
        this.probability = probability;
        this.blockProvider = blockProvider;
    }

    protected TreeDecoratorType<?> type() {
        return TreeDecoratorTypeInit.lingguo0.get();
    }

    public void place(TreeDecorator.Context pContext) {
        RandomSource randomsource = pContext.random();
        if (!(randomsource.nextFloat() >= this.probability)) {
            List<BlockPos> list = pContext.leaves();

            list.stream().filter((blockPos) -> pContext.isAir(blockPos.below())).forEach(c->{
                    pContext.setBlock(c.below(), blockProvider.getState(randomsource,c.below()));
            });
        }
    }
}