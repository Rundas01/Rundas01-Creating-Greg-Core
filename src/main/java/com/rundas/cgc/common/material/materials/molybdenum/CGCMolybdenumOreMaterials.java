package com.rundas.cgc.common.material.materials.molybdenum;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Molybdenite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Powellite;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCMolybdenumOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Molybdenite, -235.1);
        registerPhysicsPropertyOre(Powellite, -1542.0);
    }
}
