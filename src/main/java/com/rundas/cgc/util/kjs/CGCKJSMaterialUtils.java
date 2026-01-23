package com.rundas.cgc.util.kjs;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Oxygen;
import static com.rundas.cgc.util.CGCMaterialUtil.getAtomAmount;
import static com.rundas.cgc.util.CGCMaterialUtil.getTotalAtomAmount;

public class CGCKJSMaterialUtils {

    public static int getMetalAmountFromOxide(String s) {
        Material oxide = GTMaterials.get(s);
        return getTotalAtomAmount(oxide) - getAtomAmount(oxide, Oxygen);
    }

    public static int getOxygenAmountFromOxide(String s) {
        Material oxide = GTMaterials.get(s);
        return getAtomAmount(oxide, Oxygen);
    }

}
