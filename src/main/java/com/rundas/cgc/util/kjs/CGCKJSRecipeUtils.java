package com.rundas.cgc.util.kjs;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import com.rundas.cgc.common.material.CGCPropertyKeys;
import com.rundas.cgc.common.material.PhysicsProperty;
import dev.architectury.fluid.FluidStack;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static com.rundas.cgc.common.material.CGCPropertyKeys.PHYSICS;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.*;

public class CGCKJSRecipeUtils {

    private static MaterialStack getMaterialStackFromItemString(String s) {
        String[] parts;
        String materialPart, amountPart;
        Material material;
        long amount;
        if (s.contains(" ")) {
            parts = s.split(" ");
            amountPart = parts[0];
            materialPart = parts[1];
            material = GTMaterials.get(StringUtils.removeEnd(materialPart.split(":")[1], "_" + materialPart.split("_")[materialPart.split("_").length - 1]));
            amount = Long.parseLong(StringUtils.removeEnd(amountPart, "x"));
        } else {
            materialPart = StringUtils.removeEnd(s.split(":")[1], "_" + s.split("_")[s.split("_").length - 1]);
            material = GTMaterials.get(materialPart);
            amount = 1;
        }
        return new MaterialStack(material, amount);
    }

    private static MaterialStack getMaterialStackFromFluidString(String s) {
        String[] parts = s.split(" ");
        String materialPart = parts[0];
        String amountPart = parts[1];

        Material material = GTMaterials.get(materialPart.split(":")[1]);

        long amount = Long.parseLong(amountPart);

        return new MaterialStack(material, amount);
    }

    public static int getMaxTier(List<ItemStack> items, List<FluidStack> fluids) {
        int tier = GTValues.LV;
        PhysicsProperty property;
        if (!items.isEmpty()) {
            for (ItemStack stack : items) {
                property = getMaterialFromItemStack(stack).getProperty(PHYSICS);
                tier = Math.max(property.tier(), tier);
            }
        }
        if (!fluids.isEmpty()) {
            for (FluidStack stack : fluids) {
                property = getMaterialFromFluidStack(stack).getProperty(PHYSICS);
                tier = Math.max(property.tier(), tier);
            }
        }
        return tier;
    }

    public static int getMinTier(List<ItemStack> items, List<FluidStack> fluids) {
        int tier = GTValues.MAX;
        PhysicsProperty property;
        if (!items.isEmpty()) {
            for (ItemStack stack : items) {
                property = getMaterialFromItemStack(stack).getProperty(PHYSICS);
                tier = Math.min(property.tier(), tier);
            }
        }
        if (!fluids.isEmpty()) {
            for (FluidStack stack : fluids) {
                property = getMaterialFromFluidStack(stack).getProperty(PHYSICS);
                tier = Math.min(property.tier(), tier);
            }
        }
        return tier;
    }

    public static int calculateDuration(List<ItemStack> itemInputs, List<FluidStack> fluidInputs, List<ItemStack> itemOutputs, List<FluidStack> fluidOutputs, int voltage) {
        double enthalpyChange = 0.0;
        Material material;
        if (!itemOutputs.isEmpty()) {
            for (ItemStack stack : itemOutputs) {
                material = getMaterialFromItemStack(stack);
                enthalpyChange += getFormationEnthalpy(material) / getSolidMole(material) * stack.getCount();
            }
        }
        if (!fluidOutputs.isEmpty()) {
            for (FluidStack stack : fluidOutputs) {
                material = getMaterialFromFluidStack(stack);
                enthalpyChange += getFormationEnthalpy(material) / getLiquidMole(material) * stack.getAmount();
            }
        }
        if (!itemInputs.isEmpty()) {
            for (ItemStack stack : itemInputs) {
                material = getMaterialFromItemStack(stack);
                enthalpyChange -= getFormationEnthalpy(material) / getSolidMole(material) * stack.getCount();
            }
        }
        if (!fluidInputs.isEmpty()) {
            for (FluidStack stack : fluidInputs) {
                material = getMaterialFromFluidStack(stack);
                enthalpyChange -= getFormationEnthalpy(material) / getLiquidMole(material) * stack.getAmount();
            }
        }

        return (int) (enthalpyChange / voltage);
    }
}
