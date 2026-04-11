package com.rundas.cgc.common.material.materials.hydrogen;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.DistilledWater;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyFluidOrGas;

public class CGCHydrogenMaterials {
    public static void modify() {

    }

    public static void preModify() {
        registerPhysicsPropertyFluidOrGas(Steam, 1, -241.83, false);
        registerPhysicsPropertyFluidOrGas(Water, 1, -285.83, false);
        registerPhysicsPropertyFluidOrGas(DistilledWater, 1, -285.83, false);
    }
}
