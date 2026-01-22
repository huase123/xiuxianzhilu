package huase.xiuxianzhilu.blocks;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.functions.jvlingzhen.JvlingzhenBlock;
import huase.xiuxianzhilu.blocks.functions.lianqiding.LianqidingBlock;
import huase.xiuxianzhilu.blocks.zhiwu.GuoshiBlock;
import huase.xiuxianzhilu.blocks.zhiwu.LingDirBlock;
import huase.xiuxianzhilu.blocks.zhiwu.ZhiwuBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
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
