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

    }


    private void modleItem(RegistryObject<Item> itemRegistryObject) {

        String currentTrimName =itemRegistryObject.getKey().location().getPath();
        ResourceLocation trimNameResLoc = new ResourceLocation(ModMain.MOD_ID, currentTrimName);

        this.withExistingParent(itemRegistryObject.getId().getPath(),
                        mcLoc("item/generated"))
                .override()
                .model(new ModelFile.UncheckedModelFile(trimNameResLoc));
    }



    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ModMain.MOD_ID,"item/" + item.getId().getPath()));
    }

}