package huase.xiuxianzhilu.items.functions;

import huase.xiuxianzhilu.items.Iteminit;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ArmorMaterialsCustomize implements ArmorMaterial {

    huang("huang", 30, Util.make(new EnumMap<>(ArmorItem.Type.class), (typeIntegerEnumMap) -> {
        typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, 3);
        typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, 6);
        typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, 8);
        typeIntegerEnumMap.put(ArmorItem.Type.HELMET, 3);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0F, 0.1F, () -> Ingredient.of(Iteminit.linghe0.get())),
    xvan("xvan", 120, Util.make(new EnumMap<>(ArmorItem.Type.class), (typeIntegerEnumMap) -> {
        typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, 4);
        typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, 7);
        typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, 9);
        typeIntegerEnumMap.put(ArmorItem.Type.HELMET, 4);
    }), 20, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(Iteminit.linghe1.get())),
    di("di", 240, Util.make(new EnumMap<>(ArmorItem.Type.class), (typeIntegerEnumMap) -> {
        typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, 5);
        typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, 8);
        typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, 10);
        typeIntegerEnumMap.put(ArmorItem.Type.HELMET, 5);
    }), 30, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.2F, () -> Ingredient.of(Iteminit.linghe2.get())),
    tian("tian", 480, Util.make(new EnumMap<>(ArmorItem.Type.class), (typeIntegerEnumMap) -> {
        typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, 6);
        typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, 9);
        typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, 11);
        typeIntegerEnumMap.put(ArmorItem.Type.HELMET, 6);
    }), 40, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () -> Ingredient.of(Iteminit.linghe3.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;


    private ArmorMaterialsCustomize(String pName, int pDurabilityMultiplier, EnumMap<ArmorItem.Type, Integer> pProtectionFunctionForType, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
        this.name = pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.protectionFunctionForType = pProtectionFunctionForType;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }

    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.BOOTS, 23);
        p_266653_.put(ArmorItem.Type.LEGGINGS, 25);
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 27);
        p_266653_.put(ArmorItem.Type.HELMET, 20);
    });

    public static ArmorMaterial getType(int lv) {
        switch (lv){
            case 0:return huang;
            case 1:return xvan;
            case 2:return di;
            case 3:return tian;
            default:
                 return huang;
        }
    }

    public int getDurabilityForType(ArmorItem.Type pType) {
        return HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionFunctionForType.get(pType);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    /**
     * Gets the percentage of knockback resistance provided by armor of the material.
     */
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public String getSerializedName() {
        return this.name;
    }
}
