package huase.xiuxianzhilu.worlds.biomesources;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;

import java.util.stream.Stream;

/**
 * - @description:REBiomeSource类
 */
public class REBiomeSource extends BiomeSource {
    public static final Codec<REBiomeSource> CODEC = Biome.CODEC.fieldOf("biome").xmap(REBiomeSource::new, (p_204259_) -> {
        return p_204259_.biome;
    }).stable().codec();
    private final Holder<Biome> biome;

    public REBiomeSource(Holder<Biome> biome) {
        this.biome = biome;
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return Stream.of(this.biome);
    }

    @Override
    public Holder<Biome> getNoiseBiome(int pX, int pY, int pZ, Climate.Sampler pSampler) {
        return this.biome;
    }
}
