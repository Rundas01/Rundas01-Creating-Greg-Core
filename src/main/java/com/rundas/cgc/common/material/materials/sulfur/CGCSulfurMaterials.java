package com.rundas.cgc.common.material.materials.sulfur;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyFluidOrGas;

public class CGCSulfurMaterials {
    public static void preModify() {
        registerPhysicsPropertyElement(Sulfur, 1, 144, false);
        registerPhysicsPropertyFluidOrGas(SulfurDioxide, 1, -296.81, false);
        registerPhysicsPropertyFluidOrGas(SulfurTrioxide, 1, -395.7, false);
    }
}
