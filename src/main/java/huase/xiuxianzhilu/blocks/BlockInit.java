package huase.xiuxianzhilu.blocks;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.functions.jvlingzhen.JvlingzhenBlock;
import huase.xiuxianzhilu.blocks.functions.lianqiding.LianqidingBlock;
import huase.xiuxianzhilu.blocks.treegrower.Lingmu0TreeGrower;
import huase.xiuxianzhilu.blocks.treegrower.Lingmu1TreeGrower;
import huase.xiuxianzhilu.blocks.treegrower.Lingmu2TreeGrower;
import huase.xiuxianzhilu.blocks.treegrower.Lingmu3TreeGrower;
import huase.xiuxianzhilu.blocks.zhiwu.GuoshiBlock;
import huase.xiuxianzhilu.blocks.zhiwu.LingDirBlock;
import huase.xiuxianzhilu.blocks.zhiwu.ZhiwuBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * - @description:BlockInti类
 */
public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModMain.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModMain.MODID);

    public static List<RegistryObject<Block>> zhiwublocklist = new ArrayList();
    public static List<RegistryObject<Item>> zhiwuitemlist = new ArrayList();
    public static List<RegistryObject<BlockItem>> zhiwuseeditemlist = new ArrayList();
    public static List<RegistryObject<Block>> OreBlocklist = new ArrayList();


    // Creates a new Block with the id "xiuxianzhilu:example_block", combining the namespace and path
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));




    public static final RegistryObject<Block> jvlingzhen0 = registerBlockWithBlockItem("jvlingzhen0", () -> new JvlingzhenBlock(0));



    public static final RegistryObject<Block> lianqiding0 = registerBlockWithBlockItem("lianqiding0", () -> new LianqidingBlock(0));
    public static final RegistryObject<Block> lianqiding1 = registerBlockWithBlockItem("lianqiding1", () -> new LianqidingBlock(1));
    public static final RegistryObject<Block> lianqiding2 = registerBlockWithBlockItem("lianqiding2", () -> new LianqidingBlock(2));
    public static final RegistryObject<Block> lianqiding3 = registerBlockWithBlockItem("lianqiding3", () -> new LianqidingBlock(3));


    //    灵土
    public static final RegistryObject<Block> lingdirblock= registerBlockWithBlockItem("lingdirblock", LingDirBlock::new);

    public static final RegistryObject<Block> zhiwu0= registerZhiwuBlockWithBlockItem("zhiwu0", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu1= registerGuoshiBlockWithBlockItem("zhiwu1", GuoshiBlock::new);
    public static final RegistryObject<Block> zhiwu2= registerZhiwuBlockWithBlockItem("zhiwu2", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu3= registerZhiwuBlockWithBlockItem("zhiwu3", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu4= registerZhiwuBlockWithBlockItem("zhiwu4", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu5= registerGuoshiBlockWithBlockItem("zhiwu5", GuoshiBlock::new);
    public static final RegistryObject<Block> zhiwu6= registerZhiwuBlockWithBlockItem("zhiwu6", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu7= registerZhiwuBlockWithBlockItem("zhiwu7", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu8= registerZhiwuBlockWithBlockItem("zhiwu8", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu9= registerGuoshiBlockWithBlockItem("zhiwu9", GuoshiBlock::new);
    public static final RegistryObject<Block> zhiwu10= registerZhiwuBlockWithBlockItem("zhiwu10", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu11= registerZhiwuBlockWithBlockItem("zhiwu11", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu12= registerZhiwuBlockWithBlockItem("zhiwu12", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu13= registerGuoshiBlockWithBlockItem("zhiwu13", GuoshiBlock::new);
    public static final RegistryObject<Block> zhiwu14= registerZhiwuBlockWithBlockItem("zhiwu14", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu15= registerZhiwuBlockWithBlockItem("zhiwu15", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu16= registerZhiwuBlockWithBlockItem("zhiwu16", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu17= registerZhiwuBlockWithBlockItem("zhiwu17", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu18= registerZhiwuBlockWithBlockItem("zhiwu18", ZhiwuBlock::new);
    public static final RegistryObject<Block> zhiwu19= registerZhiwuBlockWithBlockItem("zhiwu19", ZhiwuBlock::new);


    public static final RegistryObject<Block> lingmu0_SAPLING = registerBlockWithBlockItem("lingmu0_sapling", () -> new SaplingBlock(new Lingmu0TreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> lingmu1_SAPLING = registerBlockWithBlockItem("lingmu1_sapling", () -> new SaplingBlock(new Lingmu1TreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> lingmu2_SAPLING = registerBlockWithBlockItem("lingmu2_sapling", () -> new SaplingBlock(new Lingmu2TreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> lingmu3_SAPLING = registerBlockWithBlockItem("lingmu3_sapling", () -> new SaplingBlock(new Lingmu3TreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> lingmu0_LOG = registerBlockWithBlockItem("lingmu0_log", () ->log(MapColor.SAND, MapColor.QUARTZ));
    public static final RegistryObject<Block> lingmu1_LOG = registerBlockWithBlockItem("lingmu1_log", () ->log(MapColor.SAND, MapColor.QUARTZ));
    public static final RegistryObject<Block> lingmu2_LOG = registerBlockWithBlockItem("lingmu2_log", () ->log(MapColor.SAND, MapColor.QUARTZ));
    public static final RegistryObject<Block> lingmu3_LOG = registerBlockWithBlockItem("lingmu3_log", () ->log(MapColor.SAND, MapColor.QUARTZ));
    public static final RegistryObject<Block> lingmu0_LEAVES = registerBlockWithBlockItem("lingmu0_leaves", () ->leaves(SoundType.GRASS));
    public static final RegistryObject<Block> lingmu1_LEAVES = registerBlockWithBlockItem("lingmu1_leaves", () ->leaves(SoundType.GRASS));
    public static final RegistryObject<Block> lingmu2_LEAVES = registerBlockWithBlockItem("lingmu2_leaves", () ->leaves(SoundType.GRASS));
    public static final RegistryObject<Block> lingmu3_LEAVES = registerBlockWithBlockItem("lingmu3_leaves", () ->leaves(SoundType.GRASS));


    public static final RegistryObject<Block> xvantie0 = registerOreBlock("xvantie0", () ->new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).noOcclusion().lightLevel((blockState) -> 7), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> xvantie1 = registerOreBlock("xvantie1", () ->new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).noOcclusion().lightLevel((blockState) -> 7), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> xvantie2 = registerOreBlock("xvantie2", () ->new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).noOcclusion().lightLevel((blockState) -> 7), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> xvantie3 = registerOreBlock("xvantie3", () ->new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).noOcclusion().lightLevel((blockState) -> 7), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> lingjin0 = registerOreBlock("lingjin0", () ->new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).noOcclusion().lightLevel((blockState) -> 7), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> lingjin1 = registerOreBlock("lingjin1", () ->new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).noOcclusion().lightLevel((blockState) -> 7), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> lingjin2 = registerOreBlock("lingjin2", () ->new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).noOcclusion().lightLevel((blockState) -> 7), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> lingjin3 = registerOreBlock("lingjin3", () ->new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).noOcclusion().lightLevel((blockState) -> 7), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> lingyv0  = registerOreBlock("lingyv0",  () ->new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).noOcclusion().lightLevel((blockState) -> 7), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> lingyv1  = registerOreBlock("lingyv1",  () ->new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).noOcclusion().lightLevel((blockState) -> 7), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> lingyv2  = registerOreBlock("lingyv2",  () ->new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).noOcclusion().lightLevel((blockState) -> 7), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> lingyv3  = registerOreBlock("lingyv3",  () ->new DropExperienceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).noOcclusion().lightLevel((blockState) -> 7), UniformInt.of(3, 7)));
    private static LeavesBlock leaves(SoundType pType) {
        return new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(pType).noOcclusion()
                .isValidSpawn(BlockInit::ocelotOrParrot)
                .isSuffocating(BlockInit::never)
                .isViewBlocking(BlockInit::never)
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY)
                .isRedstoneConductor(BlockInit::never)
                .lightLevel((blockState) -> 3)
        );
    }
    private static Boolean ocelotOrParrot(BlockState p_50822_, BlockGetter p_50823_, BlockPos p_50824_, EntityType<?> p_50825_) {
//        return (boolean)(p_50825_ == EntityType.OCELOT || p_50825_ == EntityType.PARROT);
        return true;
    }
    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

    private static RotatedPillarBlock log(MapColor pTopMapColor, MapColor pSideMapColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of()
                .mapColor((p_152624_) -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? pTopMapColor : pSideMapColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F).sound(SoundType.WOOD).ignitedByLava().lightLevel((blockState) -> 4));
    }

    private static <T extends Block> RegistryObject<T> registerOreBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        OreBlocklist.add((RegistryObject<Block>)toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<T> registerBlockWithBlockItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerZhiwuBlockWithBlockItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        zhiwublocklist.add((RegistryObject<Block>) toReturn);
        RegistryObject<BlockItem> zhiwuseed = ITEMS.register(name+"_seed", () -> new BlockItem(toReturn.get(), new Item.Properties()));
        zhiwuseeditemlist.add(zhiwuseed);
        RegistryObject<Item> zhiwu = ITEMS.register(name, () -> new Item( new Item.Properties()));
        zhiwuitemlist.add(zhiwu);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<T> registerGuoshiBlockWithBlockItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        zhiwublocklist.add((RegistryObject<Block>) toReturn);
        RegistryObject<Item> zhiwu = ITEMS.register(name, () -> new Item( new Item.Properties()));
        zhiwuitemlist.add(zhiwu);
        return toReturn;
    }


}
