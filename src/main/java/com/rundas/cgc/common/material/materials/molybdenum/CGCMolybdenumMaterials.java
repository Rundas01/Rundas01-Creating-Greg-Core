package com.rundas.cgc.common.material.materials.molybdenum;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Molybdenum;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCMolybdenumMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Molybdenum, 4, true);
    }
}
