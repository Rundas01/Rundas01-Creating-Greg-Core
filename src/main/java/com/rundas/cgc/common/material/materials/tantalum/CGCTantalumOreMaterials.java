package com.rundas.cgc.common.material.materials.tantalum;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Tantalite;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCTantalumOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Tantalite, -2480.0);
    }
}
