package com.rundas.cgc.common.material.materials.uranium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Uranium238;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCUraniumMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Uranium238, 5, true);
    }
}
