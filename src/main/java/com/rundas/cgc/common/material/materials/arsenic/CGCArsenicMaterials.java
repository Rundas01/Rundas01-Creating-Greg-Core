package com.rundas.cgc.common.material.materials.arsenic;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Arsenic;
import static com.gregtechceu.gtceu.common.data.GTMaterials.ArsenicTrioxide;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyNonmetal;

public class CGCArsenicMaterials {
    public static void preModify() {
        registerPhysicsPropertyNonmetal(ArsenicTrioxide, 3, -657.4);
    }
}
