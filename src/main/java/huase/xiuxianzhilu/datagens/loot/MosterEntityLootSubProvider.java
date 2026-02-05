package huase.xiuxianzhilu.datagens.loot;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import huase.xiuxianzhilu.entity.EntityInit;
import huase.xiuxianzhilu.items.Iteminit;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * - @description:MosterEntityLootSubProvider类
 */
public class MosterEntityLootSubProvider extends EntityLootSubProvider {

    private final Map<EntityType<?>, Map<ResourceLocation, LootTable.Builder>> map = Maps.newHashMap();
    public MosterEntityLootSubProvider() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> pOutput) {
        this.generate();
        Set<ResourceLocation> set = Sets.newHashSet();
        this.getKnownEntityTypes().map(EntityType::builtInRegistryHolder).forEach((p_249003_) -> {
            EntityType<?> entitytype = p_249003_.value();
//            if (entitytype.isEnabled(this.allowed)) {
            if (true) {
                if (canHaveLootTable(entitytype)) {
                    Map<ResourceLocation, LootTable.Builder> map = this.map.remove(entitytype);
                    ResourceLocation resourcelocation = entitytype.getDefaultLootTable();
//                    if (!resourcelocation.equals(BuiltInLootTables.EMPTY) && entitytype.isEnabled(this.required) && (map == null || !map.containsKey(resourcelocation))) {
//                        throw new IllegalStateException(String.format(Locale.ROOT, "Missing loottable '%s' for '%s'", resourcelocation, p_249003_.key().location()));
//                    }

                    if (map != null) {
                        map.forEach((p_250376_, p_250972_) -> {
                            if (!set.add(p_250376_)) {
                                throw new IllegalStateException(String.format(Locale.ROOT, "Duplicate loottable '%s' for '%s'", p_250376_, p_249003_.key().location()));
                            } else {
                                pOutput.accept(p_250376_, p_250972_);
                            }
                        });
                    }
                } else {
                    Map<ResourceLocation, LootTable.Builder> map1 = this.map.remove(entitytype);
                    if (map1 != null) {
                        throw new IllegalStateException(String.format(Locale.ROOT, "Weird loottables '%s' for '%s', not a LivingEntity so should not have loot", map1.keySet().stream().map(ResourceLocation::toString).collect(Collectors.joining(",")), p_249003_.key().location()));
                    }
                }

            }
        });
        if (!this.map.isEmpty()) {
            throw new IllegalStateException("Created loot tables for entities not supported by datapack: " + this.map.keySet());
        }
    }

    public void generate() {
        addMoster(EntityInit.chilingshuishe.get()     , Iteminit.linghe0.get(),0.5f);
        addMoster(EntityInit.huanlinghu.get()         , Iteminit.linghe0.get(),0.7f);
        addMoster(EntityInit.xueyichanglang.get()     , Iteminit.linghe0.get(),0.9f);
        addMoster(EntityInit.youmingguishou.get()     , Iteminit.linghe1.get(),0.4f);
        addMoster(EntityInit.shayingmoxie.get()       , Iteminit.linghe1.get(),0.6f);
        addMoster(EntityInit.huanduzhu.get()          , Iteminit.linghe1.get(),0.8f);
        addMoster(EntityInit.zuoying.get()            , Iteminit.linghe2.get(),0.3f);
        addMoster(EntityInit.huoqiling.get()          , Iteminit.linghe2.get(),0.5f);
        addMoster(EntityInit.xvanbingjvxiong.get()    , Iteminit.linghe2.get(),0.7f);
    }

    private void addMoster(EntityType<?> pEntityType, Item item, float v) {
        this.add(pEntityType, LootTable.lootTable().withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(item))
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(v, 0.0225F))));
    }



    protected void add(EntityType<?> pEntityType, ResourceLocation pLootTableLocation, LootTable.Builder pBuilder) {
        this.map.computeIfAbsent(pEntityType, (p_251466_) -> {
            return new HashMap();
        }).put(pLootTableLocation, pBuilder);
    }
}
