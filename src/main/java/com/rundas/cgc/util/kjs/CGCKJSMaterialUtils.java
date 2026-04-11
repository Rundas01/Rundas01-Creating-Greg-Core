package com.rundas.cgc.util.kjs;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.rundas.cgc.common.material.CGCPropertyKeys;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Oxygen;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.getAtomAmount;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.getTotalAtomAmount;

public class CGCKJSMaterialUtils {

    public static int getMetalAmountFromOxide(String s) {
        Material oxide = GTMaterials.get(s);
        return getTotalAtomAmount(oxide) - getAtomAmount(oxide, Oxygen);
    }

    public static int getOxygenAmountFromOxide(String s) {
        Material oxide = GTMaterials.get(s);
        return getAtomAmount(oxide, Oxygen);
    }

    public static int getSolidMole(String s) {
        Material material = GTMaterials.get(s);
        if (material.hasProperty(CGCPropertyKeys.PHYSICS)) {
            return material.getProperty(CGCPropertyKeys.PHYSICS).solidMole();
        }
        return 1;
    }

    public static int getLiquidMole(String s) {
        Material material = GTMaterials.get(s);
        if (material.hasProperty(CGCPropertyKeys.PHYSICS)) {
            return material.getProperty(CGCPropertyKeys.PHYSICS).liquidMole();
        }
        return 1000;
    }
}
