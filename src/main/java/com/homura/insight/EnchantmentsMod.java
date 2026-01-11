package com.homura.insight;

import com.homura.insight.core.Enroll;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EnchantmentsMod.MODID)
public class EnchantmentsMod
{

    public static final String MODID = "homura_insight_enchantment";

    public EnchantmentsMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        Enroll.ENCHANTMENTS.register(modEventBus);
    }

}
