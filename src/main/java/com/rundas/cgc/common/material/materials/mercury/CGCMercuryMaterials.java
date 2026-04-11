package com.rundas.cgc.common.material.materials.mercury;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Mercury;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCMercuryMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Mercury, 3, 1000, true);
    }
}
