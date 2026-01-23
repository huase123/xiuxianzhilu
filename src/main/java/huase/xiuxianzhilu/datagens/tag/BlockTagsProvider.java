//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package huase.xiuxianzhilu.datagens.tag;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagsProvider extends net.minecraftforge.common.data.BlockTagsProvider {

    public static final TagKey<Block> cailiao_block = TagKey.create(Registries.BLOCK, ModMain.prefix("cailiao_block"));
    public BlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ModMain.MOD_ID, existingFileHelper);

    }

    protected void addTags(HolderLookup.Provider pProvider) {

        BlockInit.OreBlocklist.stream().forEach(c->tag(cailiao_block).add(c.get()));

        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(cailiao_block);
        tag(BlockTags.NEEDS_IRON_TOOL).addTag(cailiao_block);
    }
}
