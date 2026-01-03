package com.rundas.cgc.client;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.rundas.cgc.common.material.CGCPropertyKeys;
import com.rundas.cgc.common.material.PhysicsProperty;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CGCTooltipsHandler {
    public static void appendTooltips(ItemStack stack, TooltipFlag flag, List<Component> tooltips) {
        var materialEntry = ChemicalHelper.getMaterialEntry(stack.getItem());
        if (materialEntry.isEmpty()) {
            return;
        }
        if (!materialEntry.material().hasProperty(CGCPropertyKeys.PHYSICS)) {
            return;
        }
        PhysicsProperty property = materialEntry.material().getProperty(CGCPropertyKeys.PHYSICS);
        if (GTUtil.isShiftDown()) {
            tooltips.add(Component.translatable("cgc.tooltip.physics_property.formation_enthalpy", property.formationEnthalpy()).withStyle(ChatFormatting.GREEN));
        }
    }
}
