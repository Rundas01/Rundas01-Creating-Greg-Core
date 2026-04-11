package com.rundas.cgc.common.material.materials.cobalt;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Cobaltite;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCCobaltOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Cobaltite, -150.0);
    }
}
