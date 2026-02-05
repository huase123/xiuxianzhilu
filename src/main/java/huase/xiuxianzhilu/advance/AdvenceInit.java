package huase.xiuxianzhilu.advance;

import huase.xiuxianzhilu.ModMain;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.PlayerTrigger;


public class AdvenceInit {

    public static final PlayerTrigger xiuxianzhilu = CriteriaTriggers.register(new PlayerTrigger(ModMain.prefix("xiuxianzhilu")));
    public static final ChangeLingxiuTrigger changelingxiutrigger = CriteriaTriggers.register(new ChangeLingxiuTrigger());
    public static final PlayerTrigger juexinglinggen = CriteriaTriggers.register(new PlayerTrigger(ModMain.prefix("juexinglinggen")));
    public static final GongfaTrigger gongfatrigger = CriteriaTriggers.register(new GongfaTrigger());
    public static final PlayerTrigger mijing = CriteriaTriggers.register(new PlayerTrigger(ModMain.prefix("mijing")));
    public static final PlayerTrigger tiaozhenglingmai = CriteriaTriggers.register(new PlayerTrigger(ModMain.prefix("tiaozhenglingmai")));

//
//    public static void register(){
//        System.out.println("Advence invalid scussed");
//    }
}
