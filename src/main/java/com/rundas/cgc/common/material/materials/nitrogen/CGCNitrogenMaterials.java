package com.rundas.cgc.common.material.materials.nitrogen;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Nitrogen;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.changeComponentsAndFormula;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCNitrogenMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Nitrogen, 1, 1000, false);
    }

    public static void modify() {
        changeComponentsAndFormula(Nitrogen, new MaterialStack(Nitrogen, 2));
    }
}
