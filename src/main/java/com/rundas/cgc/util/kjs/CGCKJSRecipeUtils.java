package com.rundas.cgc.util.kjs;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import com.rundas.cgc.common.material.CGCPropertyKeys;
import com.rundas.cgc.common.material.PhysicsProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

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

    public static double calculateDuration(List<String> itemInputs, List<String> fluidInputs,
                                            List<String> itemOutputs,
                                            List<String> fluidOutputs, int volts) {
        List<MaterialStack> materialItemInputs = itemInputs.stream()
                .map(CGCKJSRecipeUtils::getMaterialStackFromItemString).toList();
        List<MaterialStack> materialFluidInputs = fluidInputs.stream()
                .map(CGCKJSRecipeUtils::getMaterialStackFromFluidString).toList();
        List<MaterialStack> materialItemOutputs = itemOutputs.stream()
                .map(CGCKJSRecipeUtils::getMaterialStackFromItemString).toList();
        List<MaterialStack> materialFluidOutputs = fluidOutputs.stream()
                .map(CGCKJSRecipeUtils::getMaterialStackFromFluidString).toList();

        double enthalpy = 0;
        PhysicsProperty property;

        for (MaterialStack stack : materialItemOutputs) {
            property = stack.material().getProperty(CGCPropertyKeys.PHYSICS);
            enthalpy += property.formationEnthalpy() * stack.amount() / property.solidMole();
        }
        for (MaterialStack stack : materialItemInputs) {
            property = stack.material().getProperty(CGCPropertyKeys.PHYSICS);
            enthalpy -= property.formationEnthalpy() * stack.amount() / property.solidMole();
        }
        for (MaterialStack stack : materialFluidOutputs) {
            property = stack.material().getProperty(CGCPropertyKeys.PHYSICS);
            enthalpy += property.formationEnthalpy() * stack.amount() / property.liquidMole();
        }
        for (MaterialStack stack : materialFluidInputs) {
            property = stack.material().getProperty(CGCPropertyKeys.PHYSICS);
            enthalpy -= property.formationEnthalpy() * stack.amount() / property.liquidMole();
        }

        return 20 * enthalpy / volts;
    }

    public static int getMaxTier(List<String> items, List<String> fluids) {
        int max = 0;
        PhysicsProperty property;

        List<MaterialStack> itemMaterials = items.stream().map(CGCKJSRecipeUtils::getMaterialStackFromItemString)
                .toList();
        List<MaterialStack> fluidMaterials = fluids.stream()
                .map(CGCKJSRecipeUtils::getMaterialStackFromFluidString).toList();

        for (MaterialStack stack : itemMaterials) {
            if (stack.material().hasProperty(CGCPropertyKeys.PHYSICS)) {
                property = stack.material().getProperty(CGCPropertyKeys.PHYSICS);
                max = Math.max(max, property.tier());
            } else {
                throw new RuntimeException(stack.material().getName() + " has no PP!");
            }
        }
        for (MaterialStack stack : fluidMaterials) {
            if (stack.material().hasProperty(CGCPropertyKeys.PHYSICS)) {
                property = stack.material().getProperty(CGCPropertyKeys.PHYSICS);
                max = Math.max(max, property.tier());
            } else {
                throw new RuntimeException(stack.material().getName() + " has no PP!");
            }
        }

        return max;
    }
}
