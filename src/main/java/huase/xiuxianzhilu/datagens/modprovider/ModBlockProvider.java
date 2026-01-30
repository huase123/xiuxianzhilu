package huase.xiuxianzhilu.datagens.modprovider;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.blocks.zhiwu.ZhiwuBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
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
        simpleBlockWithItem(BlockInit.lianqiding0.get(), new ModelFile.UncheckedModelFile(modLoc("block/lianqiding0")));
        simpleBlockWithItem(BlockInit.lianqiding1.get(), new ModelFile.UncheckedModelFile(modLoc("block/lianqiding1")));
        simpleBlockWithItem(BlockInit.lianqiding2.get(), new ModelFile.UncheckedModelFile(modLoc("block/lianqiding2")));
        simpleBlockWithItem(BlockInit.lianqiding3.get(), new ModelFile.UncheckedModelFile(modLoc("block/lianqiding3")));

        simpleBlockWithItem(BlockInit.liandanlu0.get(), new ModelFile.UncheckedModelFile(modLoc("block/liandanlu0")));
        simpleBlockWithItem(BlockInit.liandanlu1.get(), new ModelFile.UncheckedModelFile(modLoc("block/liandanlu1")));
        simpleBlockWithItem(BlockInit.liandanlu2.get(), new ModelFile.UncheckedModelFile(modLoc("block/liandanlu2")));
        simpleBlockWithItem(BlockInit.liandanlu3.get(), new ModelFile.UncheckedModelFile(modLoc("block/liandanlu3")));
        simpleBlockWithItem(BlockInit.jvlingzhen0.get(), new ModelFile.UncheckedModelFile(modLoc("block/zhenpan")));

        cubeTop(BlockInit.lingdirblock);
        BlockInit.zhiwublocklist.stream().forEach(c-> this.makeCornCrop(c.get(),c.getId().getPath(),c.getId().getPath()));

        logBlockWithItem( BlockInit.lingmu0_LOG);
        logBlockWithItem( BlockInit.lingmu1_LOG);
        logBlockWithItem( BlockInit.lingmu2_LOG);
        logBlockWithItem( BlockInit.lingmu3_LOG);

        simpleBlockWithItemFile(BlockInit.lingmu0_LEAVES);
        simpleBlockWithItemFile(BlockInit.lingmu1_LEAVES);
        simpleBlockWithItemFile(BlockInit.lingmu2_LEAVES);
        simpleBlockWithItemFile(BlockInit.lingmu3_LEAVES);


        cross(BlockInit.lingmu0_SAPLING);
        cross(BlockInit.lingmu1_SAPLING);
        cross(BlockInit.lingmu2_SAPLING);
        cross(BlockInit.lingmu3_SAPLING);



        BlockInit.OreBlocklist.stream().forEach(this::ore);
    }



    private void cubeTop(RegistryObject<Block> blockRegistryObject) {

        this.getVariantBuilder(blockRegistryObject.get()).forAllStates((state) ->  new ConfiguredModel[]{new ConfiguredModel(
                this.models().cubeTop(
                            blockRegistryObject.getId().getPath(),
                            TextureMapping.getBlockTexture(Blocks.DIRT),
                            ModMain.prefix( "block/" + blockRegistryObject.getId().getPath())
                )
//                        .renderType("cutout")
        )});
        simpleBlockItem(blockRegistryObject.get(),models().getExistingFile(modLoc("block/" + blockRegistryObject.getId().getPath())));
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
    private void cross(RegistryObject<Block> blockRegistryObject) {
        this.getVariantBuilder(blockRegistryObject.get()).forAllStates((state) ->  new ConfiguredModel[]{new ConfiguredModel(
                this.models().cross(
                                blockRegistryObject.getId().getPath(),
                                ModMain.prefix( "block/" + blockRegistryObject.getId().getPath())
                        )
                        .renderType("cutout"))});

    }

    private void ore(RegistryObject<Block> blockRegistryObject) {
        this.getVariantBuilder(blockRegistryObject.get()).forAllStates((state) ->  new ConfiguredModel[]{new ConfiguredModel(
                this.models().cross(
                                blockRegistryObject.getId().getPath(),
                                ModMain.prefix( "item/" + blockRegistryObject.getId().getPath())
                        )
                        .renderType("cutout"))});

    }
    public void logBlockWithItem(RegistryObject<Block> block) {
        logBlock((RotatedPillarBlock)block.get());
        simpleBlockItem(block.get(),models().getExistingFile(modLoc("block/" + block.getId().getPath())));
    }

    private void simpleBlockWithItemFile(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
