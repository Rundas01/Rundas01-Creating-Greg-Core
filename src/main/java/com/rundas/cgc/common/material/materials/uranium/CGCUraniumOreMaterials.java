package com.rundas.cgc.common.material.materials.uranium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Uraninite;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCUraniumOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Uraninite, -1085.0);
    }
}
