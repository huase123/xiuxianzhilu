//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package huase.xiuxianzhilu.datagens;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.datagens.modprovider.ModBlockProvider;
import huase.xiuxianzhilu.datagens.modprovider.ModItemProvider;
import huase.xiuxianzhilu.datagens.multiblock.ExampleInstanceCaseIllustrationMultiBlockProvider;
import huase.xiuxianzhilu.datagens.recipeprovider.RERecipeProvider;
import huase.xiuxianzhilu.datagens.tag.BlockTagsProvider;
import huase.xiuxianzhilu.datagens.tag.CustomizeWorldPresetTagsProvider;
import huase.xiuxianzhilu.datagens.tag.ItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = ModMain.MODID, bus = Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

//        generator.addProvider(event.includeServer(), new ModZHLanguageProvider(packOutput, "shxiuxian", "zh_cn"));
//        generator.addProvider(event.includeServer(), new ModEnLanguageProvider(packOutput, "shxiuxian", "en_us"));
//
        generator.addProvider(event.includeClient(), new ModBlockProvider(packOutput, existingFileHelper));
//
        generator.addProvider(event.includeClient(), new ModItemProvider(packOutput, existingFileHelper));
//
        BlockTagsProvider blockTags = new BlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTags);

        generator.addProvider(event.includeServer(), new ItemTagsProvider(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
//        generator.addProvider(event.includeServer(), new EntityTagGenerator(packOutput, lookupProvider, existingFileHelper));
////        结构数据
//        generator.addProvider(event.includeServer(), new StalactiteGenerator(packOutput));
//
        generator.addProvider(event.includeServer(), new RERecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new ExampleInstanceCaseIllustrationMultiBlockProvider(packOutput));
//
//        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Set.of(), List.of(
//                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK),
//                new LootTableProvider.SubProviderEntry(SpecialLootTables::new, LootContextParamSets.BLOCK))));


//        generator.addProvider(event.includeServer(), new AdvancementProvider(packOutput, lookupProvider, List.of(new ModAdvanceProvider())));


        RegistryDataGenerator registryDataGenerator1 = new RegistryDataGenerator(packOutput, lookupProvider);
        generator.addProvider(event.includeServer(), registryDataGenerator1);
        lookupProvider = registryDataGenerator1.getRegistryProvider();
//        generator.addProvider(event.includeClient(), new SHDamageTypeTagsProvider(packOutput, lookupProvider));
//        generator.addProvider(event.includeServer(), new BiomeTagGenerator(packOutput, lookupProvider, existingFileHelper));
//        generator.addProvider(event.includeServer(), new StructureTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new CustomizeWorldPresetTagsProvider(packOutput, lookupProvider, existingFileHelper));
    }
}
