package com.rundas.cgc.util;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.common.unification.material.MaterialRegistryManager;

import com.rundas.cgc.common.material.CGCMaterialFlags;
import com.rundas.cgc.common.material.PhysicsProperty;

import java.util.List;

import static com.rundas.cgc.CreatingGregCore.id;
import static com.rundas.cgc.common.material.CGCPropertyKeys.PHYSICS;

public class CGCMaterialUtil {

    public static int getMolarAmount(Material material, int moles) {
        int amount = 1;
        for (MaterialStack stack : material.getMaterialComponents()) {
            amount += (int) (stack.amount() * molarDecomposer(stack.material()));
        }
        return moles * amount;
    }

    public static int getMolarAmount(Material material) {
        return getMolarAmount(material, 1);
    }

    private static int molarDecomposer(Material material) {
        int amount = 1;
        for (MaterialStack stack : material.getMaterialComponents()) {
            if (stack.material().isElement()) {
                amount += (int) stack.amount();
            } else {
                amount += molarDecomposer(stack.material());
            }
        }
        return amount;
    }

    public static Material getElementFromProtons(long protons, boolean onlyStable) {
        for (Material material : MaterialRegistryManager.getInstance().getRegisteredMaterials()) {
            if (material.isElement() && material.getProtons() == protons &&
                    (onlyStable && !material.isRadioactive()) | !onlyStable) {
                return material;
            }
        }
        return null;
    }

    public static Material isotopeMaterial(Material base, Element element) {
        Material.Builder builder = new Material.Builder(id(base.getUnlocalizedName().split("\\.")[2] + element.mass()))
                .element(element).color(base.getMaterialRGB()).secondaryColor(base.getMaterialSecondaryRGB());
        if (base.hasProperty(PropertyKey.DUST)) {
            builder.dust();
        } else {
            builder.fluid();
        }
        Material material = builder.buildAndRegister();
        material.addFlags(CGCMaterialFlags.IS_NUCLEAR);
        return material;
    }

    public static int getMaxTier(List<MaterialStack> stacks) {
        int tier = 1;
        for (MaterialStack stack : stacks) {
            PhysicsProperty property = stack.material().getProperty(PHYSICS);
            tier = Math.max(property.tier(), tier);
        }
        return tier;
    }
}
