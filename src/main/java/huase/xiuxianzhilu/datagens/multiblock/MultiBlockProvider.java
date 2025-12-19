package huase.xiuxianzhilu.datagens.multiblock;

import com.google.common.collect.Sets;
import huase.xiuxianzhilu.recipe.multiblock.BuildMultiRecipe;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * - @description:MultiBlockProvider类
 */
public abstract class MultiBlockProvider implements DataProvider {

    protected final PackOutput.PathProvider multiblockrecipepathprovider;
    private final Map<String, String> data = new TreeMap<>();
    private final PackOutput output;
    private final String modid;

    public MultiBlockProvider(PackOutput output, String modid) {
        this.multiblockrecipepathprovider = output.createPathProvider(PackOutput.Target.DATA_PACK, "multiblockrecipes");
        this.output = output;
        this.modid = modid;
    }

    protected abstract void buildRecipes(Consumer<BuildMultiRecipe> pWriter);
    @Override
    public CompletableFuture<?> run(CachedOutput pOutput) {

        Set<ResourceLocation> set = Sets.newHashSet();
        List<CompletableFuture<?>> list = new ArrayList<>();
        this.buildRecipes((multiBlockRecipe) -> {
            if (!set.add(multiBlockRecipe.getId())) {
                throw new IllegalStateException("Duplicate multiblockrecipes " + multiBlockRecipe.getId());
            } else {
                list.add(DataProvider.saveStable(pOutput, multiBlockRecipe.serializeRecipe(), this.multiblockrecipepathprovider.json(multiBlockRecipe.getId())));
            }
        });
        return CompletableFuture.allOf(list.toArray((p_253414_) -> {
            return new CompletableFuture[p_253414_];
        }));
    }

    @Override
    public String getName() {
        return "MultiBlock: " + "haha";
    }
}
