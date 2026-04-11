package com.rundas.cgc.common.material.materials.arsenic;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Realgar;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCArsenicOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Realgar, -138.1);
    }
}
