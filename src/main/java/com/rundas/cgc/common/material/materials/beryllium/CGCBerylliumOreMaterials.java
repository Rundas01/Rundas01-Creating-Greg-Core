package com.rundas.cgc.common.material.materials.beryllium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Emerald;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCBerylliumOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Emerald, -9033.4);
    }
}
