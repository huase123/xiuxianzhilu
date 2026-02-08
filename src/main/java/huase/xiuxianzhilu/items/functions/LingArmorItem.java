package huase.xiuxianzhilu.items.functions;

import huase.xiuxianzhilu.ModMain;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

/**
 * - @description:LingArmorItem类
 */
public class LingArmorItem extends ArmorItem {
    int LV;
    public LingArmorItem(int LV,Type type) {
        super(ArmorMaterialsCustomize.getType(LV), type, new Item.Properties());
        this.LV = LV;
    }
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type)
    {
        ArmorItem item = (ArmorItem)stack.getItem();
        String texture = item.getMaterial().getName();
        String domain = ModMain.MOD_ID;
        int idx = texture.indexOf(':');
        if (idx != -1) {
            domain = texture.substring(0, idx);
            texture = texture.substring(idx + 1);
        }
        String s1 = String.format(java.util.Locale.ROOT, "%s:textures/models/armor/%s_layer_%d%s.png", domain, texture, (slot == EquipmentSlot.LEGS ? 1 : 2), type == null ? "" : String.format(java.util.Locale.ROOT, "_%s", type));

        return s1;
    }

    public float handLinglixiaohao(float linglixiaohao) {
        return linglixiaohao*getLinglixiaohaoCoefficient();
    }
    private float getLinglixiaohaoCoefficient() {
        return (float) Math.pow(0.9f, LV + 1);
    }
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("除本拥有更强大的属性，还能减少使用者的灵力消耗").withStyle(ChatFormatting.GREEN));
        pTooltip.add(Component.translatable("玩家受伤与攻击都需要消耗灵力来获得属性的增幅").withStyle(ChatFormatting.DARK_GRAY));

        int pow = (int) (getLinglixiaohaoCoefficient()*100);
        pTooltip.add(Component.translatable("防御灵力消耗削减:").append(Component.translatable(pow+"%").withStyle(ChatFormatting.YELLOW)));
    }

}
