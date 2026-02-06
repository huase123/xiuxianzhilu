package huase.xiuxianzhilu.recipe.multiblock;

import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.*;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.recipe.MultiBlockRecipeType;
import huase.xiuxianzhilu.registrie.NewRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * - @description:BuildMultiBlockRecipeManager类
 */
public class BuildMultiBlockRecipeManager  extends SimpleJsonResourceReloadListener {
    public static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();

    private Map<MultiBlockRecipeType<?>, Map<ResourceLocation, MultiRecipe<?>>> multiblockrecipes = ImmutableMap.of();
    private Map<ResourceLocation, MultiRecipe<?>> byName = ImmutableMap.of();

    private final net.minecraftforge.common.crafting.conditions.ICondition.IContext context; //Forge: add context

    public BuildMultiBlockRecipeManager() {
        super(GSON, "multiblockrecipes");
        this.context =net.minecraftforge.common.crafting.conditions.ICondition.IContext.EMPTY;
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> pObject, ResourceManager resourceManagerIn, ProfilerFiller profilerIn) {
        Map<MultiBlockRecipeType<?>, ImmutableMap.Builder<ResourceLocation, MultiRecipe<?>>> map = Maps.newHashMap();
        ImmutableMap.Builder<ResourceLocation, MultiRecipe<?>> builder = ImmutableMap.builder();

        for(Map.Entry<ResourceLocation, JsonElement> entry : pObject.entrySet()) {
            ResourceLocation resourcelocation = entry.getKey();
            if (resourcelocation.getPath().startsWith("_")) continue; //Forge: filter anything beginning with "_" as it's used for metadata.

            try {
                if (entry.getValue().isJsonObject() && !net.minecraftforge.common.crafting.CraftingHelper.processConditions(entry.getValue().getAsJsonObject(), "conditions", this.context)) {
                    LOGGER.debug("Skipping loading recipe {} as it's conditions were not met", resourcelocation);
                    continue;
                }
                MultiRecipe<?> recipe = fromJson(resourcelocation, GsonHelper.convertToJsonObject(entry.getValue(), "top element"), this.context);
                if (recipe == null) {
                    LOGGER.info("Skipping loading recipe {} as it's serializer returned null", resourcelocation);
                    continue;
                }
                map.computeIfAbsent(recipe.getType(), (p_44075_) -> {
                    return ImmutableMap.builder();
                }).put(resourcelocation, recipe);
                builder.put(resourcelocation, recipe);
            } catch (IllegalArgumentException | JsonParseException jsonparseexception) {
                LOGGER.error("Parsing error loading recipe {}", resourcelocation, jsonparseexception);
            }
        }

        this.multiblockrecipes = map.entrySet().stream().collect(ImmutableMap.toImmutableMap(Map.Entry::getKey, (multiBlockRecipeTypeBuilderEntry) -> {
            return multiBlockRecipeTypeBuilderEntry.getValue().build();
        }));
        this.byName = builder.build();
        LOGGER.info("Loaded {} recipes", (int)map.size());
    }


    public static MultiRecipe<?> fromJson(ResourceLocation pRecipeId, JsonObject pJson, net.minecraftforge.common.crafting.conditions.ICondition.IContext context) {
        String s = GsonHelper.getAsString(pJson, "type");

        return NewRegistries.MultiBlockRecipeSerializer_IForgeRegistry.getValue(ModMain.parse(s)).fromJson(pRecipeId, pJson);

    }

    public <C extends LoadingCache<BlockPos, BlockInWorld>, T extends MultiRecipe<C>> Optional<T> getMultiBlockRecipeFor(MultiBlockRecipeType<T> multiBlockRecipeType, Level level, BlockPos blockPos) {
        return this.byType(multiBlockRecipeType).values().stream().filter((t) -> t.matches(level,blockPos)).findFirst();
    }

    public <C extends LoadingCache<BlockPos, BlockInWorld>, T extends MultiRecipe<C>> Optional<T> getMultiBlockRecipeFor(MultiBlockRecipeType<T> multiBlockRecipeType, BlockEntity entity) {
        return this.byType(multiBlockRecipeType).values().stream().filter((t) -> t.matches(entity)).findFirst();
    }

    private < C extends LoadingCache<BlockPos, BlockInWorld>,T extends  MultiRecipe<C>> Map<ResourceLocation, T> byType(MultiBlockRecipeType<T> tMultiBlockRecipeType) {
        return (Map<ResourceLocation, T>)this.multiblockrecipes.getOrDefault(tMultiBlockRecipeType, Collections.emptyMap());
    }


    public < C extends LoadingCache<BlockPos, BlockInWorld>,T extends  MultiRecipe<C>> List<T> getAllRecipesFor(MultiBlockRecipeType<T> multiBlockRecipeType) {
        return List.copyOf(this.byType(multiBlockRecipeType).values());
    }

}