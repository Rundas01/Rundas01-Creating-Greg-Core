package com.rundas.cgc.common.material.materials.carbon;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyCompound;

public class CGCCarbonMaterials {
    public static void preModify() {
        registerPhysicsPropertyCompound(Methane, -74.6);
        registerPhysicsPropertyCompound(Ethane, -84.0);
        registerPhysicsPropertyCompound(Ethylene, 52.47);
        registerPhysicsPropertyCompound(Propane, -104.7);
        registerPhysicsPropertyCompound(Propene, 20.4);
        registerPhysicsPropertyCompound(Butane, -125.8);
        registerPhysicsPropertyCompound(Butene, -0.63);
        registerPhysicsPropertyCompound(Butadiene, 108.8);
        registerPhysicsPropertyCompound(Ethylbenzene, -12.5);
        registerPhysicsPropertyCompound(Dimethylbenzene, -25.0);
        registerPhysicsPropertyCompound(Nitrobenzene, 67.5);
    }
}
