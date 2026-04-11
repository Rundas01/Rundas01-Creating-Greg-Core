package com.rundas.cgc.common.material.materials.zinc;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Zinc;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCZincMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Zinc, 1, true);
    }
}
