package com.rundas.cgc.common.material.materials.vanadium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Vanadium;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCVanadiumMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Vanadium, 4, true);
    }
}
