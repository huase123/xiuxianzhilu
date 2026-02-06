package huase.xiuxianzhilu.datagens.multiblock;

import com.google.common.collect.ImmutableSet;
import com.google.gson.*;
import huase.xiuxianzhilu.ModMain;
import net.minecraft.advancements.critereon.NbtPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;

import javax.annotation.Nullable;
import java.util.Set;

/**
 * - @description:BlockPredicate类
 */
public class REBlockPredicate {
    public static final REBlockPredicate ANY = new REBlockPredicate((TagKey<Block>)null, (Set<Block>)null, StatePropertiesPredicate.ANY, NbtPredicate.ANY);
    @Nullable
    private final TagKey<Block> tag;
    @Nullable
    private final Set<Block> blocks;
    private final StatePropertiesPredicate properties;
    private final NbtPredicate nbt;

    public REBlockPredicate(@Nullable TagKey<Block> pTag, @Nullable Set<Block> pBlocks, StatePropertiesPredicate pProperties, NbtPredicate pNbt) {
        this.tag = pTag;
        this.blocks = pBlocks;
        this.properties = pProperties;
        this.nbt = pNbt;
    }

    public  Block getBlock() {
        Block reblock = Blocks.AIR;
        if(blocks != null){
            for (Block block : blocks) {
                return block;
            }
        }
            return reblock;
    }

    public boolean match(BlockEntity blockentity) {
        if (this == ANY) {
            return true;
        } else {
            BlockState blockstate = blockentity.getBlockState();
            if (this.tag != null && !blockstate.is(this.tag)) {
                return false;
            } else if (this.blocks != null && !this.blocks.contains(blockstate.getBlock())) {
                return false;
            } else if (!this.properties.matches(blockstate)) {
                return false;
            } else {
                if (this.nbt != NbtPredicate.ANY) {

                    if (blockentity == null || !this.nbt.matches(blockentity.saveWithFullMetadata())) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    public boolean matches(ServerLevel pLevel, BlockPos pPos) {
        if (this == ANY) {
            return true;
        } else if (!pLevel.isLoaded(pPos)) {
            return false;
        } else {
            BlockState blockstate = pLevel.getBlockState(pPos);
            if (this.tag != null && !blockstate.is(this.tag)) {
                return false;
            } else if (this.blocks != null && !this.blocks.contains(blockstate.getBlock())) {
                return false;
            } else if (!this.properties.matches(blockstate)) {
                return false;
            } else {
                if (this.nbt != NbtPredicate.ANY) {
                    BlockEntity blockentity = pLevel.getBlockEntity(pPos);
                    if (blockentity == null || !this.nbt.matches(blockentity.saveWithFullMetadata())) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    public static REBlockPredicate fromJson(@Nullable JsonElement pJson) {
        if (pJson != null && !pJson.isJsonNull()) {
            JsonObject jsonobject = GsonHelper.convertToJsonObject(pJson, "block");
            NbtPredicate nbtpredicate = NbtPredicate.fromJson(jsonobject.get("nbt"));
            Set<Block> set = null;
            JsonArray jsonarray = GsonHelper.getAsJsonArray(jsonobject, "blocks", (JsonArray)null);
            if (jsonarray != null) {
                ImmutableSet.Builder<Block> builder = ImmutableSet.builder();

                for(JsonElement jsonelement : jsonarray) {
                    ResourceLocation resourcelocation = ModMain.parse(GsonHelper.convertToString(jsonelement, "block"));
                    builder.add(BuiltInRegistries.BLOCK.getOptional(resourcelocation).orElseThrow(() -> {
                        return new JsonSyntaxException("Unknown block id '" + resourcelocation + "'");
                    }));
                }

                set = builder.build();
            }

            TagKey<Block> tagkey = null;
            if (jsonobject.has("tag")) {
                ResourceLocation resourcelocation1 = ModMain.parse(GsonHelper.getAsString(jsonobject, "tag"));
                tagkey = TagKey.create(Registries.BLOCK, resourcelocation1);
            }

            StatePropertiesPredicate statepropertiespredicate = StatePropertiesPredicate.fromJson(jsonobject.get("state"));
            return new REBlockPredicate(tagkey, set, statepropertiespredicate, nbtpredicate);
        } else {
            return ANY;
        }
    }

    public JsonElement serializeToJson() {
        if (this == ANY) {
            return JsonNull.INSTANCE;
        } else {
            JsonObject jsonobject = new JsonObject();
            if (this.blocks != null) {
                JsonArray jsonarray = new JsonArray();

                for(Block block : this.blocks) {
                    jsonarray.add(BuiltInRegistries.BLOCK.getKey(block).toString());
                }

                jsonobject.add("blocks", jsonarray);
            }

            if (this.tag != null) {
                jsonobject.addProperty("tag", this.tag.location().toString());
            }

            jsonobject.add("nbt", this.nbt.serializeToJson());
            jsonobject.add("state", this.properties.serializeToJson());
            return jsonobject;
        }
    }


    public boolean test(BlockInWorld blockInWorld) {

        if (this == ANY) {
            return true;
        }else {
            BlockState blockstate =blockInWorld.getState();
            if (this.tag != null && !blockstate.is(this.tag)) {
                return false;
            } else if (this.blocks != null && !this.blocks.contains(blockstate.getBlock())) {
                return false;
            } else if (!this.properties.matches(blockstate)) {
                return false;
            } else {
                if (this.nbt != NbtPredicate.ANY) {
                    BlockEntity blockentity = blockInWorld.getEntity();
                    if (blockentity == null || !this.nbt.matches(blockentity.saveWithFullMetadata())) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if(tag != null){
            s.append(tag.location().getPath());
        }

        if(blocks != null) {
            for (Block block : blocks) {
                s.append(BuiltInRegistries.BLOCK.getKey(block).getPath());
            }
        }

        return s.toString();
    }

    @Nullable
    public TagKey<Block> getTag() {
        return tag;
    }

    @Nullable
    public Set<Block> getBlocks() {
        return blocks;
    }

    public static class Builder {
        @Nullable
        private Set<Block> blocks;
        @Nullable
        private TagKey<Block> tag;
        private StatePropertiesPredicate properties = StatePropertiesPredicate.ANY;
        private NbtPredicate nbt = NbtPredicate.ANY;

        private Builder() {
        }

        public static REBlockPredicate.Builder block() {
            return new REBlockPredicate.Builder();
        }

        public REBlockPredicate.Builder of(Block... pBlocks) {
            this.blocks = ImmutableSet.copyOf(pBlocks);
            return this;
        }

        public REBlockPredicate.Builder of(Iterable<Block> pBlocks) {
            this.blocks = ImmutableSet.copyOf(pBlocks);
            return this;
        }

        public REBlockPredicate.Builder of(TagKey<Block> pTag) {
            this.tag = pTag;
            return this;
        }

        public REBlockPredicate.Builder hasNbt(CompoundTag pNbt) {
            this.nbt = new NbtPredicate(pNbt);
            return this;
        }

        public REBlockPredicate.Builder setProperties(StatePropertiesPredicate pProperties) {
            this.properties = pProperties;
            return this;
        }

        public REBlockPredicate build() {
            return new REBlockPredicate(this.tag, this.blocks, this.properties, this.nbt);
        }
    }
}