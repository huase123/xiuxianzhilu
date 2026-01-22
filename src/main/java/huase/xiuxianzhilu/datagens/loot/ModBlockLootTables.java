package huase.xiuxianzhilu.datagens.loot;

import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.blocks.zhiwu.GuoshiBlock;
import huase.xiuxianzhilu.blocks.zhiwu.ZhiwuBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;


public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }


    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> pOutput) {
        this.generate();
        Set<ResourceLocation> set = new HashSet<>();
//        Block block = BlockInit.baisuilan
        for(Block block : getKnownBlocks()) {
            if (block.isEnabled(this.enabledFeatures)) {
                ResourceLocation resourcelocation = block.getLootTable();
                if (resourcelocation != BuiltInLootTables.EMPTY && set.add(resourcelocation)) {
                    LootTable.Builder loottable$builder = this.map.remove(resourcelocation);
                    if (loottable$builder == null) {
//                        throw new IllegalStateException(String.format(Locale.ROOT, "Missing loottable '%s' for '%s'", resourcelocation, BuiltInRegistries.BLOCK.getKey(block)));
                    }else {
                        pOutput.accept(resourcelocation, loottable$builder);
                    }

                }
            }
        }

        if (!this.map.isEmpty()) {
            throw new IllegalStateException("Created block loot tables for non-blocks: " + this.map.keySet());
        }
    }

    @Override
    protected void generate() {
        this.dropSelf(BlockInit.lingdirblock.get());

        BlockInit.zhiwublocklist.stream().forEach(this::dropzhiwu);

    }

    private void dropzhiwu(RegistryObject<Block> block) {
        if(block.get() instanceof GuoshiBlock guoshiBlock){
            Optional<RegistryObject<Item>> any = BlockInit.ITEMS.getEntries().stream().filter(
                    c ->c.getId().getPath().equals(block.getId().getPath())
            ).findAny();
            this.dropOther(block.get(),any.get().get());
        }
        if(block.get() instanceof ZhiwuBlock zhiwuBlock){
            LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                    .hasBlockStateProperties(block.get())
                    .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ZhiwuBlock.AGE, 3));

            Optional<RegistryObject<Item>> any = BlockInit.ITEMS.getEntries().stream().filter(
                    c ->c.getId().getPath().equals(block.getId().getPath())
            ).findAny();
            this.add(block.get(), createCropDrops(block.get(), any.get().get(), lootitemcondition$builder));

        }
    }
    protected LootTable.Builder createCropDrops(Block block, Item item, LootItemCondition.Builder builder) {
        return this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(block)))
                .withPool(LootPool.lootPool().when(builder).add(LootItem.lootTableItem(item)))
                .withPool(LootPool.lootPool().when(builder)
                        .add(LootItem.lootTableItem(block).setWeight(5).setQuality(2))
                        .add(LootItem.lootTableItem(Items.AIR).setWeight(90))
                )
        );
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
//        return null;
    }
}
