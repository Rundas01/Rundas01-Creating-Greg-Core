package com.rundas.cgc.common.material.materials.zinc;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Sphalerite;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCZincOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Sphalerite, -204.6);
    }
}
