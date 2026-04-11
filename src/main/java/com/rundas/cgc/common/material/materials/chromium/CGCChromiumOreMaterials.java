package com.rundas.cgc.common.material.materials.chromium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Chromite;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCChromiumOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Chromite, -1384.72);
    }
}
