package com.rundas.cgc.common.material.materials.tungsten;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Tungsten;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCTungstenMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Tungsten, 4, true);
    }
}
