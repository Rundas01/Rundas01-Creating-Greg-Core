package com.rundas.cgc.common.material.materials.lithium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Lithium;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCLithiumMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Lithium, 2, true);
    }
}
