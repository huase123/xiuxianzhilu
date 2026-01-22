package huase.xiuxianzhilu.worlds.feature.treedecorators;

import huase.xiuxianzhilu.ModMain;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:TreeDecoratorType类
 */
public class TreeDecoratorTypeInit{
    public static final DeferredRegister<TreeDecoratorType<?>> TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, ModMain.MODID);

    public static final RegistryObject<TreeDecoratorType<? extends TreeDecorator>> lingguo0 =
            TYPE_DEFERRED_REGISTER.register("lingguo0", () -> new TreeDecoratorType<>(LingguoDecorator.CODEC));
}