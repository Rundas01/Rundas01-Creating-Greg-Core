package com.rundas.cgc.common.material.materials.manganese;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Pyrolusite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Spessartine;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCManganeseOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Pyrolusite, -521.0);
        registerPhysicsPropertyOre(Spessartine, -5693.6);
    }
}
