package huase.xiuxianzhilu.datagens.modprovider;


import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.items.Iteminit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
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
        modleItem(Iteminit.putuan);
        Iteminit.gongfaSamplelist.stream().forEach(c ->simpleItem(c));
        Iteminit.jingjielist.stream().forEach(c ->simpleItem(c));
    }
    private void modleItem(RegistryObject<Item> itemRegistryObject) {

        String currentTrimName =itemRegistryObject.getKey().location().getPath();
        ResourceLocation trimNameResLoc = ModMain.prefix( currentTrimName);

        this.withExistingParent(itemRegistryObject.getId().getPath(),
                        mcLoc("item/generated"))
                .override()
                .model(new ModelFile.UncheckedModelFile(trimNameResLoc));
    }



    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ModMain.prefix( "item/" + item.getId().getPath()));
    }

}