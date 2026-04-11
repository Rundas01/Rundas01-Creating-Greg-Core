package com.rundas.cgc.common.material.materials.cerium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Bastnasite;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCCeriumOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Bastnasite, -1808.4);
    }
}
