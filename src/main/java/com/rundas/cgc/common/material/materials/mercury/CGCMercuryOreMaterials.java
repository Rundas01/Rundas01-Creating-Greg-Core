package com.rundas.cgc.common.material.materials.mercury;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Cinnabar;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCMercuryOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Cinnabar, -58.2);
    }
}
