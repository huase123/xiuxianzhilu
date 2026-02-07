package huase.xiuxianzhilu.datagens.modprovider;


import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.entity.EntityInit;
import huase.xiuxianzhilu.items.Iteminit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;



public class ModItemProvider extends ItemModelProvider {
    public ModItemProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModMain.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item : EntityInit.SPAWN_EGGS.getEntries()) {
            if (item.get() instanceof SpawnEggItem) {
                getBuilder(item.getId().getPath()).parent(getExistingFile(ModMain.parse("item/template_spawn_egg")));
            }
        }
        simpleItem(Iteminit.celingzhu);
        simpleItem(Iteminit.lingshi0);
        simpleItem(Iteminit.lingshi1);
        simpleItem(Iteminit.lingshi2);
        simpleItem(Iteminit.zhenqi);
        simpleItem(Iteminit.tpfu);

        this.toolItem(Iteminit.linggao0);
        this.toolItem(Iteminit.linggao1);
        this.toolItem(Iteminit.linggao2);
        this.toolItem(Iteminit.linggao3);


        this.toolItem(Iteminit.lingjian0);
        this.toolItem(Iteminit.lingjian1);
        this.toolItem(Iteminit.lingjian2);
        this.toolItem(Iteminit.lingjian3);

        modleItem(Iteminit.putuan);


        Iteminit.gongfaSamplelist.stream().forEach(c ->simpleItem(c));
        Iteminit.jingjielist.stream().forEach(c ->simpleItem(c));
        Iteminit.fabaolist.stream().forEach(c ->simpleItem(c));
        Iteminit.cailiaolist.stream().forEach(c ->simpleItem(c));
        Iteminit.danyaolist.stream().forEach(c ->simpleItem(c));

        BlockInit.zhiwuseeditemlist.stream().forEach(c -> simpleblockItem(c));
        BlockInit.zhiwuitemlist.stream().forEach(c ->simpleZhiwuItem(c));

        simpleblockItem(BlockInit.lingmu0_SAPLING);
        simpleblockItem(BlockInit.lingmu1_SAPLING);
        simpleblockItem(BlockInit.lingmu2_SAPLING);
        simpleblockItem(BlockInit.lingmu3_SAPLING);

    }
    private void modleItem(RegistryObject<Item> itemRegistryObject) {

        String currentTrimName =itemRegistryObject.getKey().location().getPath();
        ResourceLocation trimNameResLoc = ModMain.prefix( currentTrimName);

        this.withExistingParent(itemRegistryObject.getId().getPath(),
                        mcLoc("item/generated"))
                .override()
                .model(new ModelFile.UncheckedModelFile(trimNameResLoc));
    }

    private ItemModelBuilder toolItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/handheld")).texture("layer0",
                ModMain.prefix( "item/" + item.getId().getPath()))
                ;
    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated")).texture("layer0",
                ModMain.prefix( "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleZhiwuItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated")).texture("layer0",
                ModMain.prefix("block/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleblockItem(RegistryObject item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated")).texture("layer0",
                ModMain.prefix("block/" + item.getId().getPath()));
    }

}