package huase.xiuxianzhilu.datagens.tag;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.worlds.worldpresets.WorldPresetsGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.WorldPresetTagsProvider;
import net.minecraft.tags.WorldPresetTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

/**
 * - @description:CustomizeWorldPresetTagsProvider类
 */
public class CustomizeWorldPresetTagsProvider extends WorldPresetTagsProvider {
    public CustomizeWorldPresetTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(packOutput,lookupProvider, ModMain.MOD_ID,existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(WorldPresetTags.NORMAL).add(WorldPresetsGen.XIUXIANZHILU);
//        this.tag(WorldPresetTags.EXTENDED).addTag(WorldPresetTags.NORMAL).add(WorldPresets.DEBUG);
    }
}
