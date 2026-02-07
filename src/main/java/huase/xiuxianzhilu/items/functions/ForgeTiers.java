package huase.xiuxianzhilu.items.functions;

import huase.xiuxianzhilu.items.Iteminit;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

/**
 * - @description:ForgeTiers类
 */
public class ForgeTiers {

    public static Tier getForgeTier(int lv) {
        switch (lv){
            case 0:return new ForgeTier(3,1200,8    ,6  ,10, Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Iteminit.linghe0.get()));
            case 1:return new ForgeTier(4,2000,20   ,12 ,15, Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Iteminit.linghe1.get()));
            case 2:return new ForgeTier(5,3000,40   ,24 ,20, Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Iteminit.linghe2.get()));
            case 3:return new ForgeTier(6,4000,60   ,48 ,25, Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Iteminit.linghe3.get()));

            default:
                return new ForgeTier(4,1561,8,1,10, Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(Items.NETHERITE_INGOT));
        }
    }

}
