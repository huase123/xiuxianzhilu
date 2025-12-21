package huase.xiuxianzhilu.datagens.modprovider;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:ModBlockProvider类
 */
public class ModBlockProvider extends BlockStateProvider {
    public ModBlockProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ModMain.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

//        simpleBlockWithItemFile(BlockInit.lianqiding0);
//        simpleBlockWithItemFile(BlockInit.lianqiding1);
//        simpleBlockWithItemFile(BlockInit.lianqiding2);
//        simpleBlockWithItemFile(BlockInit.lianqiding3);

        simpleBlockWithItem(BlockInit.lianqiding0.get(), new ModelFile.UncheckedModelFile(modLoc("block/liandanlu0")));
        simpleBlockWithItem(BlockInit.lianqiding1.get(), new ModelFile.UncheckedModelFile(modLoc("block/liandanlu1")));
        simpleBlockWithItem(BlockInit.lianqiding2.get(), new ModelFile.UncheckedModelFile(modLoc("block/liandanlu2")));
        simpleBlockWithItem(BlockInit.lianqiding3.get(), new ModelFile.UncheckedModelFile(modLoc("block/liandanlu3")));

    }

    private void simpleBlockWithItemFile(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(modLoc("block/"+blockRegistryObject.getKey().location().getPath())));
    }
}
