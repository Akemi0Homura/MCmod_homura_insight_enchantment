package com.homura.insight.core;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/**
 * 附魔书相关数据<br>
 * @author Akemi0Homura
 */
public class Book extends Enchantment {
    protected Book() {
        super(
                Rarity.RARE,
                EnchantmentCategory.ARMOR_HEAD,
                new EquipmentSlot[]{EquipmentSlot.HEAD}
        );
    }

    //可在附魔台上出现
    @Override
    public boolean isDiscoverable() {
        return true;
    }

    //允许村民交易出现
    @Override
    public boolean isTradeable() {
        return true;
    }

    //最便宜：15-20级
    //中间：20-25级
    //最贵：25-30级

    //附魔台最低等级
    @Override
    public int getMinCost(int level) {
        return 10;
    }

    //附魔台最高等级
    @Override
    public int getMaxCost(int level) {
        return 30;
    }

    //最高等级
    @Override
    public int getMaxLevel() {
        return 1;
    }
}

