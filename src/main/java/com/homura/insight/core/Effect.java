package com.homura.insight.core;


import com.homura.insight.EnchantmentsMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @author Akemi0Homura
 */
@Mod.EventBusSubscriber(modid = EnchantmentsMod.MODID)
public class Effect {
    @SubscribeEvent
    public static void onPickupXp(PlayerXpEvent.PickupXp event) {
        // 获取触发事件的玩家实体
        Player player = event.getEntity();

        // 只在服务端处理，避免客户端与服务端重复结算经验
        if (player.level().isClientSide()) return;

        // 获取头盔槽位物品，用于检测附魔等级
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        // 读取指定附魔在头盔上的等级
        // 若未附魔或等级为 0，则不接管原版经验逻辑
        int level = EnchantmentHelper.getItemEnchantmentLevel(
                Enroll.INSIGHT.get(), helmet
        );
        if (level <= 0) return;

        // 获取即将被拾取的经验球实体
        ExperienceOrb orb = event.getOrb();

        // 记录经验球原本应给予的经验值
        int value = orb.value;

        // 取消原版的经验拾取流程
        event.setCanceled(true);

        // 移除经验球实体，防止重复触发拾取事件
        orb.discard();

        // 手动给予经验：
        // 原版经验 +（原版经验 × 附魔等级）
        player.giveExperiencePoints(value * (1 + level));
    }
}

