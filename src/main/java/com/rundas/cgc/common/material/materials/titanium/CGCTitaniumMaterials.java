package com.rundas.cgc.common.material.materials.titanium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Titanium;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCTitaniumMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Titanium, 3, true);
    }
}
