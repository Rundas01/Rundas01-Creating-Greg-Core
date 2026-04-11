package com.rundas.cgc.common.material.materials.nickel;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Nickel;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCNickelMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Nickel, 1, true);
    }
}
