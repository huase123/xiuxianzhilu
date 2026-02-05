package huase.xiuxianzhilu.worlds.biomesources;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:BiomeSourceInit类
 */
public class BiomeSourceInit {

    /**
     * TODO 功能描述：注册表，用于注册自定义BiomeSource
     * @author :huase
     * @date 2025/12/2 17:24
     */
    public static final DeferredRegister<Codec<? extends BiomeSource>> BIOME_SOURCE_TYPE_REGISTRIES = DeferredRegister.create(Registries.BIOME_SOURCE, ModMain.MOD_ID);
    public static final RegistryObject<Codec<? extends BiomeSource>> re_biome_source = BIOME_SOURCE_TYPE_REGISTRIES.register("re_biome_source", () -> REBiomeSource.CODEC);


}
