package com.rundas.cgc.common.material.materials.magnesium;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Magnesia;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Magnesium;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.*;

public class CGCMagnesiumMaterials {
    public static void preModify() {
        registerPhysicsPropertyCompound(Magnesia, -601.6);
    }
}
