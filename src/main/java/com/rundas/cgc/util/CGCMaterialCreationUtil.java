package com.rundas.cgc.util;

import com.google.common.collect.ImmutableList;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.rundas.cgc.common.material.OreprocProperty;
import net.minecraft.util.Tuple;

import java.util.Collections;
import java.util.List;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.rundas.cgc.CreatingGregCore.id;
import static com.rundas.cgc.common.material.materials.CGCMaterials.*;
import static com.rundas.cgc.common.material.CGCPropertyKeys.OREPROC;
import static com.rundas.cgc.common.material.CGCPropertyKeys.PHYSICS;
import static com.rundas.cgc.util.CGCMaterialUtil.*;

public class CGCMaterialCreationUtil {

    private static Material.Builder cgcMaterialBuilder(String name, Integer color1, Integer color2, ImmutableList<MaterialStack> components, String formula) {
        Material.Builder builder = new Material.Builder(id(name)).flags(DISABLE_DECOMPOSITION);
        if (components != null) {
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

    private static Material.Builder cgcMaterialBuilder(String name, Integer color1, Integer color2, List<Tuple<Material, Integer>> components, String formula) {
        return cgcMaterialBuilder(name, color1, color2, convertComponents(components), formula);
    }

    public static Material cgcDustMaterial(String name, Integer color1, Integer color2, List<Tuple<Material, Integer>> components, Integer harvestLevel, int tier, Double formationEnthalpy, String formula) {
        return cgcDustMaterial(name, color1, color2, convertComponents(components), harvestLevel, tier, formationEnthalpy, formula);
    }

    public static Material cgcDustMaterial(String name, Integer color1, Integer color2, ImmutableList<MaterialStack> components, Integer harvestLevel, int tier, Double formationEnthalpy, String formula) {
        Material.Builder builder = cgcMaterialBuilder(name, color1, color2, components, formula);
        if (harvestLevel != null) {
            builder.dust(harvestLevel);
        } else {
            builder.dust();
        }
        Material material = builder.buildAndRegister();
        if (formationEnthalpy == null) {
            if (components == null) {
                formationEnthalpy = 0.0;
            } else {
                formationEnthalpy = avgFormationEnthalpy(components);
            }
        }

        registerPhysicsPropertyNonmetal(material, tier, formationEnthalpy);
        return material;
    }

    public static Material cgcDustAliasMaterial(String name, Material toCopy, int tier, double formationEnthalpy) {
        return cgcDustMaterial(name, toCopy.getMaterialRGB(), toCopy.getMaterialSecondaryRGB(), toCopy.getMaterialComponents(), toCopy.getBlockHarvestLevel(), tier, formationEnthalpy, toCopy.getChemicalFormula());
    }

    public static Material cgcFluidMaterial(String name, Integer color1, Integer color2, List<Tuple<Material, Integer>> components, int tier, Double formationEnthalpy, String formula) {
        Material.Builder builder = cgcMaterialBuilder(name, color1, color2, components, formula).fluid();
        Material material = builder.buildAndRegister();
        if (formationEnthalpy == null) {
            if (components == null) {
                formationEnthalpy = 0.0;
            } else {
                formationEnthalpy = avgFormationEnthalpy(components);
            }
        }

        registerPhysicsPropertyFluidOrGas(material, tier, formationEnthalpy);
        return material;
    }

    public static Material cgcMetalFluidMaterial(String name, Integer color1, Integer color2, List<Tuple<Material, Integer>> components, int tier, double formationEnthalpy, String formula) {
        Material.Builder builder = cgcMaterialBuilder(name, color1, color2, components, formula).fluid();
        Material material = builder.buildAndRegister();
        registerPhysicsPropertyMetal(material, tier, formationEnthalpy);
        return material;
    }

    public static Material cgcGasMaterial(String name, Integer color1, Integer color2, List<Tuple<Material, Integer>> components, int tier, double formationEnthalpy, String formula) {
        Material.Builder builder = cgcMaterialBuilder(name, color1, color2, components, formula).gas();
        Material material = builder.buildAndRegister();
        registerPhysicsPropertyFluidOrGas(material, tier, formationEnthalpy);
        return material;
    }

    public static Material cgcOreMaterial(String name, Integer color1, Integer color2, List<Tuple<Material, Integer>> components, int tier, double formationEnthalpy, String formula) {
        Material.Builder builder = cgcMaterialBuilder(name, color1, color2, components, formula).ore(getMolarAmount(convertComponents(components)), 1);
        Material material = builder.buildAndRegister();
        registerPhysicsPropertyNonmetal(material, tier, formationEnthalpy);
        return material;
    }

    public static void registerOreprocMaterials(Material material, List<Tuple<Material, Integer>> leachComponents, List<Tuple<Material, Integer>> roastedComponents) {
        String name = material.getName();
        int color1 = material.getMaterialRGB();
        int color2 = material.getMaterialSecondaryRGB();
        int tier = material.getProperty(PHYSICS).tier();

        Material leach, impureSlag, slag, roastedDust = null;

        //Leach
        leach = cgcFluidMaterial(name + "_leach", null, null, leachComponents, tier + 1, null, null);
        //Impure Slag
        impureSlag = cgcFluidMaterial("impure_" + name + "_slag", null, null, null, tier + 1, null, null);
        //Slag
        slag = cgcDustMaterial(name + "_slag", color1 - 10, color2 - 10, Collections.emptyList(), 1, tier + 1, null, "?");
        //Roasted Dust
        if (roastedComponents != null) {
            roastedDust = cgcDustMaterial("roasted_" + name, color1 - 5, color2 - 5, roastedComponents, 1, tier, null, "?");
        }
        material.setProperty(OREPROC, new OreprocProperty(leach, impureSlag, slag, roastedDust));
    }
}
