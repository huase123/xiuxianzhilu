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
    public static final TagKey<Item> islinghe = TagKey.create(Registries.ITEM, ModMain.prefix("islinghe"));
    public static final TagKey<Item> isxvantie = TagKey.create(Registries.ITEM, ModMain.prefix("isxvantie"));
    public static final TagKey<Item> islingjin = TagKey.create(Registries.ITEM, ModMain.prefix("islingjin"));
    public static final TagKey<Item> islingyv = TagKey.create(Registries.ITEM, ModMain.prefix("islingyv"));
    public static final TagKey<Item> islingmu = TagKey.create(Registries.ITEM, ModMain.prefix("islingmu"));
    public ItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTagProvider, ModMain.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(islingshi)
                .add(Iteminit.lingshi0.get())
                .add(Iteminit.lingshi1.get())
                .add(Iteminit.lingshi2.get())
        ;
        this.tag(islinghe)
                .add(Iteminit.linghe0.get())
                .add(Iteminit.linghe1.get())
                .add(Iteminit.linghe2.get())
                .add(Iteminit.linghe3.get())
        ;
        this.tag(isxvantie)
                .add(Iteminit.xvantie0.get())
                .add(Iteminit.xvantie1.get())
                .add(Iteminit.xvantie2.get())
                .add(Iteminit.xvantie3.get())
        ;
        this.tag(islingjin)
                .add(Iteminit.lingjin0.get())
                .add(Iteminit.lingjin1.get())
                .add(Iteminit.lingjin2.get())
                .add(Iteminit.lingjin3.get())
        ;
        this.tag(islingyv)
                .add(Iteminit.lingyv0.get())
                .add(Iteminit.lingyv1.get())
                .add(Iteminit.lingyv2.get())
                .add(Iteminit.lingyv3.get())
        ;
        this.tag(islingmu)
                .add(Iteminit.lingmu0.get())
                .add(Iteminit.lingmu1.get())
                .add(Iteminit.lingmu2.get())
                .add(Iteminit.lingmu3.get())
        ;
    }
}
