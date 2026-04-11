package com.rundas.cgc.common.material.materials.palladium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Palladium;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCPalladiumMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Palladium, 5, true);
    }
}
