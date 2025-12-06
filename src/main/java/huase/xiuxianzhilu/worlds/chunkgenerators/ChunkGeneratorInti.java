package huase.xiuxianzhilu.worlds.chunkgenerators;

import com.mojang.serialization.Codec;
import huase.xiuxianzhilu.ModMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:ChunkGeneratorInti类
 */
public class ChunkGeneratorInti {

    /**
     * TODO 功能描述：注册表，用于注册自定义BiomeSource
     * @author :huase
     * @date 2025/12/2 17:24
     */
    public static final DeferredRegister<Codec<? extends ChunkGenerator>> CHUNK_GENERATOR_REGISTRIES = DeferredRegister.create(Registries.CHUNK_GENERATOR, ModMain.MOD_ID);
    public static final RegistryObject<Codec<REChunkGenerator>> re_chunkgenerator = CHUNK_GENERATOR_REGISTRIES.register("re_chunkgenerator", () -> REChunkGenerator.CODEC);

}
