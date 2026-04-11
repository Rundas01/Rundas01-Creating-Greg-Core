package com.rundas.cgc.common.material.materials.sodium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Sodium;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCSodiumMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Sodium, 1, true);
    }
}
