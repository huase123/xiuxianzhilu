package huase.xiuxianzhilu.datagens.tag;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.items.Iteminit;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

/**
 * - @description:XiuxianItemTagsProvider类
 */
public class ItemTagsProvider extends net.minecraft.data.tags.ItemTagsProvider {

    public static final TagKey<Item> islingshi = TagKey.create(Registries.ITEM, ModMain.prefix("islingshi"));
    public ItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTagProvider, ModMain.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(islingshi).add(Iteminit.lingshi.get());
    }
}
