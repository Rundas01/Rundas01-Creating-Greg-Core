package com.rundas.cgc.common.material.materials.potassium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.RockSalt;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Saltpeter;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCPotassiumOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(RockSalt, -436.7);
        registerPhysicsPropertyOre(Saltpeter, -494.5);
    }
}
