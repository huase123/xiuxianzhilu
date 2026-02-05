package huase.xiuxianzhilu.advance;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.blocks.BlockInit;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaGen;
import huase.xiuxianzhilu.capabilitys.capability.gongfa.GongfaSample;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.LingxiujingjieGen;
import huase.xiuxianzhilu.capabilitys.capability.jingjie.lings.LingxiuJingjieSample;
import huase.xiuxianzhilu.items.Iteminit;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class ModAdvanceProviderGen implements AdvancementSubProvider {
    public void generate(HolderLookup.Provider pRegistries, Consumer<Advancement> pWriter) {
        Advancement root = Advancement.Builder.advancement()
                .display(Iteminit.jingjie5.get()
                        , Component.translatable("修仙之路").withStyle(ChatFormatting.WHITE)
                        , Component.translatable("欢迎来到《修仙之路》").withStyle(ChatFormatting.DARK_GREEN),
                        ResourceLocation.parse("textures/block/diamond_block.png"),
                        FrameType.GOAL, true, true, false)
                .addCriterion("xiuxianzhilu", new PlayerTrigger.TriggerInstance(AdvenceInit.xiuxianzhilu.getId(), ContextAwarePredicate.ANY)).
                save(pWriter, ModMain.MODID + ":advancement/root");

        Advancement tpfu  =  addItemAdvance(pWriter,root,Iteminit.tpfu,Component.translatable("听村民说，工具商收集了些奇奇怪怪的东西").withStyle(ChatFormatting.RED));

        Advancement mijing  =  advancementgen(pWriter,tpfu,Iteminit.linghe3,AdvenceInit.mijing,Component.translatable("前往秘境"),Component.translatable("利用传送符前往秘境"));

        Advancement lianqiding0  =  addItemAdvance(pWriter,root,BlockInit.lianqiding0);
        Advancement lianqiding1  =  addItemAdvance(pWriter,lianqiding0,BlockInit.lianqiding1);
        Advancement lianqiding2  =  addItemAdvance(pWriter,lianqiding1,BlockInit.lianqiding2);
        Advancement lianqiding3  =  addItemAdvance(pWriter,lianqiding2,BlockInit.lianqiding3);

        Advancement liandanlu0  =  addItemAdvance(pWriter,lianqiding0,BlockInit.liandanlu0);
        Advancement liandanlu1  =  addItemAdvance(pWriter,liandanlu0,BlockInit.liandanlu1);
        Advancement liandanlu2  =  addItemAdvance(pWriter,liandanlu1,BlockInit.liandanlu2);
        Advancement liandanlu3  =  addItemAdvance(pWriter,liandanlu2,BlockInit.liandanlu3);



        Advancement jvlingzhen0  =  addItemAdvance(pWriter,lianqiding0,BlockInit.jvlingzhen0);
        Advancement jvlingzhen1  =  addItemAdvance(pWriter,jvlingzhen0,BlockInit.jvlingzhen1);
        Advancement jvlingzhen2  =  addItemAdvance(pWriter,jvlingzhen1,BlockInit.jvlingzhen2);

        Advancement juexinglinggen  =  juexinglinggen(pWriter,jvlingzhen0,Iteminit.linghe0,AdvenceInit.juexinglinggen);

        Advancement putuan  =  addItemAdvance(pWriter,juexinglinggen,Iteminit.putuan,Component.translatable("制作蒲团").withStyle(ChatFormatting.GOLD));
        Advancement gongfa0yuanman  =  gongfayuanman(pWriter,putuan,Iteminit.gongfa0, GongfaGen.gongfa0);
        Advancement gongfa1yuanman  =  gongfayuanman(pWriter,gongfa0yuanman,Iteminit.gongfa1, GongfaGen.gongfa1);
        Advancement gongfa2yuanman  =  gongfayuanman(pWriter,gongfa1yuanman,Iteminit.gongfa2, GongfaGen.gongfa2);
        Advancement gongfa3yuanman  =  gongfayuanman(pWriter,gongfa2yuanman,Iteminit.gongfa3, GongfaGen.gongfa3);
        Advancement gongfa4yuanman  =  gongfayuanman(pWriter,gongfa3yuanman,Iteminit.gongfa4, GongfaGen.gongfa4);


        Advancement lianqi   =  addJingjieAdvance(pWriter,gongfa0yuanman    ,Iteminit.jingjie0,LingxiujingjieGen.lianqi  );
        Advancement zhuji    =  addJingjieAdvance(pWriter,lianqi  ,Iteminit.jingjie1,LingxiujingjieGen.zhuji   );
        Advancement jindan   =  addJingjieAdvance(pWriter,zhuji   ,Iteminit.jingjie2,LingxiujingjieGen.jindan  );
        Advancement yuanying =  addJingjieAdvance(pWriter,jindan  ,Iteminit.jingjie3,LingxiujingjieGen.yuanying);
        Advancement huashen  =  addJingjieAdvance(pWriter,yuanying,Iteminit.jingjie4,LingxiujingjieGen.huashen );



        Advancement tiaozhenglingmai   =  advancementgen(pWriter,lianqi,Iteminit.linghe1,AdvenceInit.tiaozhenglingmai,Component.translatable("灵脉调整").withStyle(ChatFormatting.RED),Component.translatable("当灵脉状态差时，立即打坐调理，以更快获取经验"));

    }

    private Advancement gongfayuanman(Consumer<Advancement> pWriter, Advancement root, RegistryObject<Item> itemRegistryObject, ResourceKey<GongfaSample> resourceKey) {
        return Advancement.Builder.advancement().parent(root)
                .display(itemRegistryObject.get()
                        , Component.translatable(itemRegistryObject.get().getDescriptionId()).withStyle(ChatFormatting.GREEN)
                        , Component.translatable("听村民说，图书管理员早年获得了本看不懂的古书？？？？").withStyle(ChatFormatting.RED)
                        , (ResourceLocation) null
                        , FrameType.GOAL, true, true, false)
                .addCriterion(itemRegistryObject.getId().getPath(), GongfaTrigger.TriggerInstance.createInstance(resourceKey)).
                save(pWriter, ModMain.MODID + ":advancement/root/" +itemRegistryObject.getId().getPath());
    }
    private Advancement juexinglinggen(Consumer<Advancement> pWriter, Advancement root, RegistryObject<Item> linghe0, PlayerTrigger id) {
        return Advancement.Builder.advancement().parent(root)
                .display(linghe0.get()
                        , Component.translatable("灵根觉醒").withStyle(ChatFormatting.YELLOW)
                        , Component.translatable("利用聚灵阵觉醒灵根").withStyle(ChatFormatting.YELLOW)
                        , (ResourceLocation) null
                        , FrameType.GOAL, true, true, false)
                .addCriterion(linghe0.getId().getPath(),  new PlayerTrigger.TriggerInstance(id.getId(), ContextAwarePredicate.ANY)).
                save(pWriter, ModMain.MODID + ":advancement/root/" +linghe0.getId().getPath());
    }
    private Advancement advancementgen(Consumer<Advancement> pWriter, Advancement root, RegistryObject<Item> linghe0, PlayerTrigger id,MutableComponent title,MutableComponent mutableComponent) {
        return Advancement.Builder.advancement().parent(root)
                .display(linghe0.get()
                        , title
                        , mutableComponent
                        , (ResourceLocation) null
                        , FrameType.GOAL, true, true, false)
                .addCriterion(linghe0.getId().getPath(),  new PlayerTrigger.TriggerInstance(id.getId(), ContextAwarePredicate.ANY)).
                save(pWriter, ModMain.MODID + ":advancement/root/" +linghe0.getId().getPath());
    }

    private Advancement addJingjieAdvance(Consumer<Advancement> pWriter, Advancement root, RegistryObject<Item> jingjie0, ResourceKey<LingxiuJingjieSample> resourceKey) {
        return Advancement.Builder.advancement().parent(root)
                .display(jingjie0.get()
                        , Component.translatable(jingjie0.get().getDescriptionId()).withStyle(ChatFormatting.GREEN)
                        , Component.translatable("成功突破至").withStyle(ChatFormatting.YELLOW).append(Component.translatable(jingjie0.get().getDescriptionId()))
                        , (ResourceLocation) null
                        , FrameType.GOAL, true, true, false)
                .addCriterion(jingjie0.getId().getPath(), ChangeLingxiuTrigger.TriggerInstance.createInstance(resourceKey)).
                save(pWriter, ModMain.MODID + ":advancement/root/" +jingjie0.getId().getPath());
    }
    private Advancement addItemAdvance(Consumer<Advancement> pWriter, Advancement root, RegistryObject<Block> itemRegistryObject) {
        return Advancement.Builder.advancement().parent(root)
                .display(itemRegistryObject.get()
                        , Component.translatable(itemRegistryObject.get().getDescriptionId()).withStyle(ChatFormatting.GREEN)
                        , Component.translatable("获得").withStyle(ChatFormatting.YELLOW).append(Component.translatable(itemRegistryObject.get().getDescriptionId()))
                        , (ResourceLocation) null
                        , FrameType.GOAL, true, true, false)
                .addCriterion(itemRegistryObject.getId().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(itemRegistryObject.get())).
                save(pWriter, ModMain.MODID + ":advancement/root/" +itemRegistryObject.getId().getPath());
    }
    private Advancement addItemAdvance(Consumer<Advancement> pWriter, Advancement root, RegistryObject<Item> itemRegistryObject, MutableComponent mutableComponent) {
        return Advancement.Builder.advancement().parent(root)
                .display(itemRegistryObject.get()
                        , Component.translatable(itemRegistryObject.get().getDescriptionId()).withStyle(ChatFormatting.GREEN)
                        , mutableComponent
                        , (ResourceLocation) null
                        , FrameType.GOAL, true, true, false)
                .addCriterion(itemRegistryObject.getId().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(itemRegistryObject.get())).
                save(pWriter, ModMain.MODID + ":advancement/root/" +itemRegistryObject.getId().getPath());
    }
}