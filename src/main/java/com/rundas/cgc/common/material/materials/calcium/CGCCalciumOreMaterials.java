package com.rundas.cgc.common.material.materials.calcium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Calcite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Grossular;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCCalciumOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Calcite, -1207.6);
        registerPhysicsPropertyOre(Grossular, -6627.0);
    }
}
