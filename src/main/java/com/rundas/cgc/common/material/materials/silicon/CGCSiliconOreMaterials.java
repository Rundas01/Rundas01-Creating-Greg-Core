package com.rundas.cgc.common.material.materials.silicon;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCSiliconOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Quartzite, -910.9);
        registerPhysicsPropertyOre(CertusQuartz, -910.9);
        registerPhysicsPropertyOre(NetherQuartz, -910.9);
    }
}
