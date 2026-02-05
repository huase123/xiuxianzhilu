package huase.xiuxianzhilu.worlds.feature.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

/**
 * - @description:ZhiwuFeature类
 */
public class ZhiwuFeature extends Feature<ZhiwuFeatureConfiguration> {

    public ZhiwuFeature(Codec<ZhiwuFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ZhiwuFeatureConfiguration> pContext) {
        RandomSource randomsource = pContext.random();
        BlockPos blockpos = pContext.origin();
        WorldGenLevel worldgenlevel = pContext.level();
        ZhiwuFeatureConfiguration oreconfiguration = pContext.config();
        BlockState topblock = oreconfiguration.topblock.getState(randomsource, blockpos);
        BlockState bottomblock = oreconfiguration.bottomblock.getState(randomsource, blockpos);
        float generateProbability = oreconfiguration.generateProbability;
        if (!(randomsource.nextFloat() >= generateProbability)) {
            this.setBlock(worldgenlevel, blockpos, topblock);
            this.setBlock(worldgenlevel, blockpos.below(), bottomblock);
            return true;
        }
        return false;
    }
}
