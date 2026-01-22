package huase.xiuxianzhilu.datagens.modprovider;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.blocks.zhiwu.ZhiwuBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

/**
 * - @description:ModBlockProvider类
 */
public class ModBlockProvider extends BlockStateProvider {
    public ModBlockProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ModMain.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(BlockInit.lianqiding0.get(), new ModelFile.UncheckedModelFile(modLoc("block/liandanlu0")));
        simpleBlockWithItem(BlockInit.lianqiding1.get(), new ModelFile.UncheckedModelFile(modLoc("block/liandanlu1")));
        simpleBlockWithItem(BlockInit.lianqiding2.get(), new ModelFile.UncheckedModelFile(modLoc("block/liandanlu2")));
        simpleBlockWithItem(BlockInit.lianqiding3.get(), new ModelFile.UncheckedModelFile(modLoc("block/liandanlu3")));

        BlockInit.zhiwublocklist.stream().forEach(c->{
            this.makeCornCrop(c.get(),c.getId().getPath(),c.getId().getPath());
        });

    }


    public void makeCornCrop(Block block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function;

        if(block instanceof ZhiwuBlock zhiwuBlock){
            function = (state) -> this.zhiwuStates(state, zhiwuBlock, modelName, textureName);
        }else {
            function = (state) -> this.guoshiStates(state, block, modelName, textureName);
        }

        this.getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] zhiwuStates(BlockState state, ZhiwuBlock block, String modelName, String textureName) {
        ConfiguredModel[] models;
        if(block.getAge(state)>= block.getMaxAge()){
            models = new ConfiguredModel[]{new ConfiguredModel(
                    this.models().cross(
                            textureName,
                            ModMain.prefix( "block/" + textureName)
                    ).renderType("cutout"))};
        }else {
            models = new ConfiguredModel[]{new ConfiguredModel(
                    this.models().cross(
                            textureName+"_seed",
                            ModMain.prefix( "block/" + textureName+"_seed")
                    ).renderType("cutout"))};
        }
        return models;
    }
    private ConfiguredModel[] guoshiStates(BlockState state, Block block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[]{new ConfiguredModel(
                this.models().cross(
                        textureName,
                                ModMain.prefix( "block/" + textureName)
                )
                        .renderType("cutout"))};
        return models;
    }
    private void simpleBlockWithItemFile(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(modLoc("block/"+blockRegistryObject.getKey().location().getPath())));
    }
}
