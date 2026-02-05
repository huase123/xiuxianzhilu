package huase.xiuxianzhilu.event.server;

import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.items.Iteminit;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = ModMain.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ReVillagerTradesEvent {

    @SubscribeEvent
    public static void onStartTracking(VillagerTradesEvent event) {
        if(event.getType().equals(VillagerProfession.LIBRARIAN)) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(1).add(new BasicItemListing(
                    new ItemStack(Items.EMERALD,6)
                    , new ItemStack(Items.BOOK)
                    , new ItemStack(Iteminit.gongfa0.get())
                    , 10, 1, 1.0f));
            trades.get(1).add(new BasicItemListing(
                    new ItemStack(Items.EMERALD,2)
                    , ItemStack.EMPTY
                    , new ItemStack(Iteminit.tpfu.get())
                    , 2, 1, 1.0f));
        }
        if(event.getType().equals(VillagerProfession.TOOLSMITH)) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(1).add(new BasicItemListing(
                    new ItemStack(Items.EMERALD,2)
                    , ItemStack.EMPTY
                    , new ItemStack(Iteminit.tpfu.get())
                    , 2, 1, 1.0f));
        }
    }

}
