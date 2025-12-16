package com.rundas.cgc.util;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;

import com.google.common.collect.ImmutableList;
import com.gregtechceu.gtceu.common.unification.material.MaterialRegistryManager;
import com.rundas.cgc.common.material.CGCMaterialFlags;
import com.rundas.cgc.common.material.CGCPropertyKeys;
import com.rundas.cgc.common.material.PhysicsProperty;

import static com.rundas.cgc.CreatingGregCore.id;

public class CGCMaterialUtil {

    public static void registerTierProperty(Material material, int tier) {
        material.setProperty(CGCPropertyKeys.PHYSICS, new PhysicsProperty(tier, 0));
    }

    public static Material.Builder cgcMaterialBuilder(String name, Integer color, Integer secondColor,
                                                      ImmutableList<MaterialStack> stacks) {
        Material.Builder builder = new Material.Builder(id(name));
        if (stacks != null) {
            builder.componentStacks(stacks);
        }
        if (color != null) {
            builder.color(color);
            if (secondColor != null) {
                builder.secondaryColor(secondColor);
            }
        } else {
            builder.colorAverage();
        }
        return builder;
    }

    public static Material cgcDustMaterial(String name, Integer color, Integer secondColor, int tier,
                                           ImmutableList<MaterialStack> stacks) {
        Material.Builder builder = cgcMaterialBuilder(name, color, secondColor, stacks).dust();
        Material material = builder.buildAndRegister();
        registerTierProperty(material, tier);
        return material;
    }

    public static Material cgcIngotMaterial(String name, Integer color, Integer secondColor, int tier,
                                            ImmutableList<MaterialStack> stacks) {
        Material.Builder builder = cgcMaterialBuilder(name, color, secondColor, stacks).ingot();
        Material material = builder.buildAndRegister();
        registerTierProperty(material, tier);
        return material;
    }

    public static Material cgcFluidMaterial(String name, Integer color, Integer secondColor, int tier,
                                            ImmutableList<MaterialStack> stacks) {
        Material.Builder builder = cgcMaterialBuilder(name, color, secondColor, stacks).liquid();
        Material material = builder.buildAndRegister();
        registerTierProperty(material, tier);
        return material;
    }

    public static Material cgcAcidMaterial(String name, Integer color, Integer secondColor, int tier,
                                           ImmutableList<MaterialStack> stacks) {
        Material.Builder builder = cgcMaterialBuilder(name, color, secondColor, stacks)
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID));
        Material material = builder.buildAndRegister();
        registerTierProperty(material, tier);
        return material;
    }

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
            if (material.isElement() && material.getProtons() == protons && (onlyStable && !material.isRadioactive()) | !onlyStable) {
                return material;
            }
        }
        return null;
    }

    public static Material isotopeMaterial(Material base, Element element) {
        Material.Builder builder = new Material.Builder(id(base.getUnlocalizedName() + element.mass()))
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
}
