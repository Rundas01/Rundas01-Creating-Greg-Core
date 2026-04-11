package com.rundas.cgc.common.material.materials.platinum;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Platinum;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCPlatinumMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Platinum, 5, true);
    }
}
