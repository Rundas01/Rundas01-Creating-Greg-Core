package com.rundas.cgc.common.material.materials.barium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Barite;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCBariumOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Barite, -1469.1);
    }
}
