package huase.xiuxianzhilu;

import com.mojang.logging.LogUtils;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.configs.Config;
import huase.xiuxianzhilu.creativemodetabs.CreativeModeTabInit;
import huase.xiuxianzhilu.items.Iteminit;
import huase.xiuxianzhilu.network.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

import java.lang.reflect.Field;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModMain.MODID)
public class ModMain {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "xiuxianzhilu";
    public static final String MOD_ID = "xiuxianzhilu";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public ModMain() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
//        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BlockInit.BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        BlockInit.ITEMS.register(modEventBus);
        Iteminit.ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CreativeModeTabInit.CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(CreativeModeTabInit::addCreative);

        NetworkHandler.register();
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);


        changeAttributesIO();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }

    //    修改血量上限
    public static void changeAttributesIO()  {
        try {
            Field privateField = RangedAttribute.class.getDeclaredFields()[1];
            privateField.setAccessible(true);
            privateField.set(Attributes.MAX_HEALTH, Float.MAX_VALUE);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}
