package com.rundas.cgc.util.kjs;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import com.rundas.cgc.common.material.CGCMaterials;
import com.rundas.cgc.common.material.CGCPropertyKeys;

import java.util.List;

public class CGCKJSMaterialUtils {

    public static int getSolidMole(String s) {
        Material material = GTMaterials.get(s);
        if (!material.hasProperty(CGCPropertyKeys.PHYSICS)) {
            return 1;
        }
        return material.getProperty(CGCPropertyKeys.PHYSICS).solidMole();
    }

    public static int getLiquidMole(String s) {
        Material material = GTMaterials.get(s);
        if (!material.hasProperty(CGCPropertyKeys.PHYSICS)) {
            return 1000;
        }
        return material.getProperty(CGCPropertyKeys.PHYSICS).liquidMole();
    }

    public static void registerPhysicsProperty(String name, int tier, double formationEnthalpy, int liquidMole) {
        CGCMaterials.registerPhysicsProperty(GTMaterials.get(name), tier, formationEnthalpy, liquidMole);
    }

    public static void registerPhysicsPropertyFluidOrGas(String name, int tier, double formationEnthalpy) {
        CGCMaterials.registerPhysicsPropertyFluidOrGas(GTMaterials.get(name), tier, formationEnthalpy);
    }

    public static void registerPhysicsPropertyMetal(String name, int tier, double formationEnthalpy) {
        CGCMaterials.registerPhysicsPropertyMetal(GTMaterials.get(name), tier, formationEnthalpy);
    }

    public static void registerPhysicsPropertyNonmetal(String name, int tier, double formationEnthalpy) {
        CGCMaterials.registerPhysicsPropertyNonmetal(GTMaterials.get(name), tier, formationEnthalpy);
    }

    public static void registerSolutionProperty(String name, String solvent, String solution, String crystallizedSolution, List<String> dilutedSolutions) {
        CGCMaterials.registerSolutionProperty(GTMaterials.get(name), GTMaterials.get(solvent), GTMaterials.get(solution), GTMaterials.get(crystallizedSolution), dilutedSolutions.stream().map(GTMaterials::get).toList());
    }
}
