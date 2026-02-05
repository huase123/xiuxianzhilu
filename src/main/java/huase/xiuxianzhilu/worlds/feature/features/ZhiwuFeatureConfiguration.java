package huase.xiuxianzhilu.worlds.feature.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

/**
 * - @description:ZhiwuFeatureConfiguration类
 */
public class ZhiwuFeatureConfiguration implements FeatureConfiguration {
    public static final Codec<ZhiwuFeatureConfiguration> CODEC = RecordCodecBuilder.create((zhiwuFeatureConfigurationInstance) -> zhiwuFeatureConfigurationInstance.group(
            BlockStateProvider.CODEC.fieldOf("topblock").forGetter(c-> c.topblock) ,
            BlockStateProvider.CODEC.fieldOf("bottomblock").forGetter(c-> c.bottomblock),
            Codec.FLOAT.fieldOf("generateProbability").forGetter((p_161025_) -> p_161025_.generateProbability)
            ).apply(zhiwuFeatureConfigurationInstance, ZhiwuFeatureConfiguration::new));

    public  float generateProbability;
    public  BlockStateProvider topblock;
    public  BlockStateProvider bottomblock;

    public ZhiwuFeatureConfiguration(BlockStateProvider topblock,BlockStateProvider bottomblock, float generateProbability) {
        this.bottomblock = bottomblock;
        this.topblock = topblock;
        this.generateProbability = generateProbability;
    }


}
