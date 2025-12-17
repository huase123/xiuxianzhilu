package huase.xiuxianzhilu.blocks;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.functions.jvlingzhen.JvlingzhenBlock;
import huase.xiuxianzhilu.blocks.functions.lianqiding.LianqidingBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:BlockInti类
 */
public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModMain.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModMain.MODID);

    // Creates a new Block with the id "xiuxianzhilu:example_block", combining the namespace and path
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));


    public static final RegistryObject<Block> jvlingzhen = BLOCKS.register("jvlingzhen", () -> new JvlingzhenBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

    public static final RegistryObject<Item> jvlingzhen_item = ITEMS.register("jvlingzhen_item", () -> new BlockItem(jvlingzhen.get(), new Item.Properties()));



    public static final RegistryObject<Block> lianaqiding = BLOCKS.register("lianaqiding", () -> new LianqidingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

    public static final RegistryObject<Item> lianaqiding_item = ITEMS.register("lianaqiding_item", () -> new BlockItem(lianaqiding.get(), new Item.Properties()));



}
