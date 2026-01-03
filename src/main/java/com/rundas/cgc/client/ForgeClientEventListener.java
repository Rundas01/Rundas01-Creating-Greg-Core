package com.rundas.cgc.client;

import com.rundas.cgc.CreatingGregCore;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreatingGregCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class ForgeClientEventListener {
    @SubscribeEvent
    public static void onTooltipEvent(ItemTooltipEvent event) {
        CGCTooltipsHandler.appendTooltips(event.getItemStack(), event.getFlags(), event.getToolTip());
    }
}
