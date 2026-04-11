package com.rundas.cgc.common.material.materials.tantalum;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Tantalum;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCTantalumMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Tantalum, 3, true);
    }
}
