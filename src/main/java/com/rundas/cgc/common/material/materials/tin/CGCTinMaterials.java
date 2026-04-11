package com.rundas.cgc.common.material.materials.tin;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Tin;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCTinMaterials {

    public static void init() {}

    public static void preModify() {
        registerPhysicsPropertyElement(Tin, 1, true);
    }
}
