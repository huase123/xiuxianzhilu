package huase.xiuxianzhilu;

import com.mojang.logging.LogUtils;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieFactorys;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieTypes;
import huase.xiuxianzhilu.configs.Config;
import huase.xiuxianzhilu.creativemodetabs.CreativeModeTabInit;
import huase.xiuxianzhilu.items.Iteminit;
import huase.xiuxianzhilu.network.NetworkHandler;
import huase.xiuxianzhilu.worlds.biomesources.BiomeSourceInit;
import huase.xiuxianzhilu.worlds.biomesources.REBiomeSource;
import huase.xiuxianzhilu.worlds.chunkgenerators.ChunkGeneratorInti;
import huase.xiuxianzhilu.worlds.multinoisebiomesourceparameterlists.MultiNoiseBiomeSourceParameterListGen;
import huase.xiuxianzhilu.worlds.structures.StructuresInit;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
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
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;

import java.lang.reflect.Field;
import java.util.Locale;

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


        BiomeSourceInit.BIOME_SOURCE_TYPE_REGISTRIES.register(modEventBus);
        ChunkGeneratorInti.CHUNK_GENERATOR_REGISTRIES.register(modEventBus);

        StructuresInit.STRUCTURE_PIECE_TYPE_Registries.register(modEventBus);
        StructuresInit.STRUCTURE_TYPE_Registries.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(CreativeModeTabInit::addCreative);

        NetworkHandler.register();
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
//普通注册表注册
//        modEventBus.addListener(huase.xiuxianzhilu.Registrie.Registries::registerNewRegistry);
        LingxiujingjieFactorys.LingxiujingjieBase_REGISTER.register(modEventBus);
        LingxiujingjieTypes.BIOME_LAYER_TYPES_REGISTER.register(modEventBus);
//        资源包管理的注册表
        modEventBus.addListener(huase.xiuxianzhilu.Registrie.Registries::setRegistriesForDatapack);

//        modEventBus.addListener(this::registerExtraStuff);
        changeAttributesIO();

/**
 * TODO 功能描述：原版群系分布修改功能需要
 * @author :huase
 * @date 2025/12/7 5:29
 */
        MultiNoiseBiomeSourceParameterList.Preset.BY_NAME.put(MultiNoiseBiomeSourceParameterListGen.xiexianjiemultinoisebiome.id(),MultiNoiseBiomeSourceParameterListGen.xiexianjiemultinoisebiome);
    }

    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name.toLowerCase(Locale.ROOT));
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

    public void registerExtraStuff(RegisterEvent evt) {
        if (evt.getRegistryKey().equals(Registries.BIOME_SOURCE)) {
            Registry.register(BuiltInRegistries.BIOME_SOURCE, prefix("xiuxiuzhilu_biomes"), REBiomeSource.CODEC);
//            Registry.register(BuiltInRegistries.BIOME_SOURCE, TwilightForestMod.prefix("twilight_biomes"), TFBiomeProvider.TF_CODEC);
//            Registry.register(BuiltInRegistries.BIOME_SOURCE, TwilightForestMod.prefix("landmarks"), LandmarkBiomeSource.CODEC);
        } else if (evt.getRegistryKey().equals(Registries.CHUNK_GENERATOR)) {
//            Registry.register(BuiltInRegistries.CHUNK_GENERATOR, prefix("structure_locating_wrapper"), REChunkGenerator.CODEC);
//            Registry.register(BuiltInRegistries.CHUNK_GENERATOR, TwilightForestMod.prefix("structure_locating_wrapper"), ChunkGeneratorTwilight.CODEC);
        } else if (evt.getRegistryKey().equals(ForgeRegistries.Keys.RECIPE_SERIALIZERS)) {
//            CraftingHelper.register(UncraftingTableCondition.Serializer.INSTANCE);
        } else if (evt.getRegistryKey().equals(ForgeRegistries.Keys.CHUNK_STATUS)) {

        }
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
