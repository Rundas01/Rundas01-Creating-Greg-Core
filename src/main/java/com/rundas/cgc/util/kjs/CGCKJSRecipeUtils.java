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
        if (s.contains(" ")) {
            return new MaterialStack(GTMaterials.get(s.split(" ")[1].split(":")[1]),
                    Long.getLong(StringUtils.removeEnd(s.split(" ")[0], "x")));
        }
        return new MaterialStack(GTMaterials.get(s.split(":")[1]), 1);
    }

    private static MaterialStack getMaterialStackFromFluidString(String s) {
        Material material = GTMaterials.get(s.split(" ")[0].split(":")[1]);
        long amount = Long.getLong(s.split(" ")[1]);
        return new MaterialStack(material, amount);
    }

    public static double calculateDuration(List<String> itemInputs, List<String> fluidInputs,
                                            List<String> itemOutputs,
                                            List<String> fluidOutputs) {
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

        return enthalpy > 0 ? 2 * enthalpy : -enthalpy;
    }

    public static int getMaxTier(List<String> items, List<String> fluids) {
        int max = 0;
        PhysicsProperty property;
        List<MaterialStack> itemMaterials = items.stream().map(CGCKJSRecipeUtils::getMaterialStackFromItemString)
                .toList();
        List<MaterialStack> fluidMaterials = fluids.stream()
                .map(CGCKJSRecipeUtils::getMaterialStackFromFluidString).toList();
        for (MaterialStack stack : itemMaterials) {
            property = stack.material().getProperty(CGCPropertyKeys.PHYSICS);
            max = Math.max(max, property.tier());
        }
        for (MaterialStack stack : fluidMaterials) {
            property = stack.material().getProperty(CGCPropertyKeys.PHYSICS);
            max = Math.max(max, property.tier());
        }

        return max;
    }
}
