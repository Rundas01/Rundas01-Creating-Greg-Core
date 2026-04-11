package com.rundas.cgc.util.gtceu;

import com.google.common.collect.ImmutableList;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.OreProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.rundas.cgc.CreatingGregCore.id;
import static com.rundas.cgc.common.material.CGCPropertyKeys.PHYSICS;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.*;

public class CGCMaterialCreationUtil {

    private static Material.Builder cgcMaterialBuilder(String name, Integer color1, Integer color2, ImmutableList<MaterialStack> components, String formula) {
        Material.Builder builder = new Material.Builder(id(name)).flags(DISABLE_DECOMPOSITION);
        if (!components.isEmpty()) {
            builder.componentStacks(components);
        }
        if (color1 == null && color2 == null) {
            builder.colorAverage();
        } else {
            builder.color(color1);
            if (color2 != null) {
                builder.secondaryColor(color2);
            }
        }
        if (formula != null) {
            builder.formula(formula, true);
        }
        return builder;
    }

    private static Material.Builder cgcMaterialBuilder(String name, Integer color1, Integer color2, List<MaterialStack> components, String formula) {
        return cgcMaterialBuilder(name, color1, color2, convertComponents(components), formula);
    }

    public static Material cgcDustMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, Integer harvestLevel, int tier, Double formationEnthalpy, String formula) {
        return cgcDustMaterial(name, color1, color2, convertComponents(components), harvestLevel, tier, formationEnthalpy, formula);
    }

    public static Material cgcDustMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, Integer harvestLevel, int tier, Double formationEnthalpy) {
        return cgcDustMaterial(name, color1, color2, convertComponents(components), harvestLevel, tier, formationEnthalpy, null);
    }

    public static Material cgcDustMaterial(String name, Integer color1, Integer color2, ImmutableList<MaterialStack> components, Integer harvestLevel, int tier, Double formationEnthalpy, Double heatCapacity, Integer meltingPoint, String formula) {
        Material.Builder builder = cgcMaterialBuilder(name, color1, color2, components, formula);
        if (harvestLevel != null) {
            builder.dust(harvestLevel);
        } else {
            builder.dust();
        }
        Material material = builder.buildAndRegister();
        if (formationEnthalpy == null) {
            if (components.isEmpty()) {
                formationEnthalpy = 0.0;
            } else {
                formationEnthalpy = avgFormationEnthalpy(components);
            }
        }

        registerPhysicsPropertyNonmetal(material, tier, formationEnthalpy, heatCapacity, meltingPoint);
        return material;
    }

    public static Material cgcDustMaterial(String name, Integer color1, Integer color2, ImmutableList<MaterialStack> components, Integer harvestLevel, int tier, Double formationEnthalpy, String formula) {
        return cgcDustMaterial(name, color1, color2, components, harvestLevel, tier, formationEnthalpy, 0.0, 273, formula);
    }

    public static Material cgcFluidMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, int tier, Double formationEnthalpy, Double heatCapacity, boolean isMetal, String formula) {
        Material.Builder builder = cgcMaterialBuilder(name, color1, color2, components, formula).fluid();
        Material material = builder.buildAndRegister();
        if (formationEnthalpy == null) {
            if (components == null) {
                formationEnthalpy = 0.0;
            } else {
                formationEnthalpy = avgFormationEnthalpy(components);
            }
        }

        registerPhysicsPropertyFluidOrGas(material, tier, formationEnthalpy, isMetal, heatCapacity, 273);
        return material;
    }

    public static Material cgcFluidMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, int tier, Double formationEnthalpy, Double heatCapacity, boolean isMetal) {
        return cgcFluidMaterial(name, color1, color2, components, tier, formationEnthalpy, heatCapacity, isMetal, null);
    }

    public static Material cgcFluidMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, int tier, Double formationEnthalpy, Double heatCapacity) {
        return cgcFluidMaterial(name, color1, color2, components, tier, formationEnthalpy, heatCapacity,false, null);
    }

    public static Material cgcFluidMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, int tier, Double formationEnthalpy) {
        return cgcFluidMaterial(name, color1, color2, components, tier, formationEnthalpy, 0.0,false, null);
    }

    public static Material cgcGasMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, int tier, Double formationEnthalpy, Double heatCapacity, String formula) {
        Material.Builder builder = cgcMaterialBuilder(name, color1, color2, components, formula).gas();
        Material material = builder.buildAndRegister();
        if (formationEnthalpy == null) {
            if (components == null) {
                formationEnthalpy = 0.0;
            } else {
                formationEnthalpy = avgFormationEnthalpy(components);
            }
        }

        registerPhysicsPropertyFluidOrGas(material, tier, formationEnthalpy, false, heatCapacity, 273);
        return material;
    }

    public static Material cgcGasMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, int tier, Double formationEnthalpy, Double heatCapacity) {
        return cgcGasMaterial(name, color1, color2, components, tier, formationEnthalpy, heatCapacity, null);
    }

    public static Material cgcGasMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, int tier, Double formationEnthalpy) {
        return cgcGasMaterial(name, color1, color2, components, tier, formationEnthalpy, 0.0, null);
    }

    public static Material cgcOreMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, Double formationEnthalpy, String formula, @Nullable Material meltsInto, Double heatCapacity, Integer meltingPoint) {
        ImmutableList<MaterialStack> newComponents = convertComponents(components);
        Material.Builder builder = cgcMaterialBuilder(name, color1, color2, components, formula).ore(getMolarAmount(newComponents), 1).flags(NO_ORE_SMELTING, NO_SMELTING);
        Material material = builder.buildAndRegister();
        int tier = getMaxTier(newComponents);
        registerPhysicsPropertyMetal(material, getMetalAmountInCompound(newComponents) > 1 ? tier + 1 : tier, formationEnthalpy, heatCapacity, meltingPoint);
        registerTFCProperty(material, tier, meltsInto);
        Material byproduct = cgcDustMaterial(name + "_residue", 0x222222, null, Collections.emptyList(), 1, tier, 0.0, "?");
        changeOreByproducts(material, byproduct);
        return material;
    }

    public static Material cgcOreMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, Double formationEnthalpy, Material meltsInto, Double heatCapacity, Integer meltingPoint) {
        return cgcOreMaterial(name, color1, color2, components, formationEnthalpy, null, meltsInto, heatCapacity, meltingPoint);
    }

    public static Material cgcOreMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, Double formationEnthalpy, Double heatCapacity, Integer meltingPoint) {
        return cgcOreMaterial(name, color1, color2, components, formationEnthalpy, null, null, heatCapacity, meltingPoint);
    }

    public static Material cgcOreMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, Double formationEnthalpy, String formula) {
        return cgcOreMaterial(name, color1, color2, components, formationEnthalpy, formula, null, 0.0, 273);
    }

    public static Material cgcOreMaterial(String name, Integer color1, Integer color2, List<MaterialStack> components, Double formationEnthalpy) {
        return cgcOreMaterial(name, color1, color2, components, formationEnthalpy, null, null, 0.0, 273);
    }

    public static void registerRoastedDusts(Material material, List<MaterialStack> components, @Nullable Material toRemove) {
        String name = material.getName();
        int color1 = material.getMaterialRGB();
        int color2 = material.getMaterialSecondaryRGB();
        int tier = material.getProperty(PHYSICS).tier();

        cgcDustMaterial("roasted_" + name, color1 - 5, color2 - 5, components, 1, tier, null, null);
        if (toRemove != null) {
            String name2 = toRemove.getName();
            components = components.stream().filter(ms -> !contains(ms.material(), toRemove)).toList();
            cgcDustMaterial(name2 + "_free_roasted_" + name, color1 - 5, color2 - 5, components, 1, tier, null, null);
        }
    }

    public static void changeOreByproducts(Material material, Material byproduct) {
        OreProperty property = material.getProperty(PropertyKey.ORE);
        property.setOreByProducts(byproduct);
        property.setOreMultiplier(material.getProperty(PHYSICS).solidMole());
    }
}
