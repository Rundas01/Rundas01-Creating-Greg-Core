package com.rundas.cgc.common.material.materials.copper;

import static com.gregtechceu.gtceu.common.data.GTMaterials.CupricOxide;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.*;

public class CGCCopperMaterials {

    public static void preModify() {
        registerPhysicsPropertyCompound(CupricOxide, -156.0);
    }

    public static void init() {}
}
