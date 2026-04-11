package com.rundas.cgc.common.material.materials.antimony;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Antimony;
import static com.gregtechceu.gtceu.common.data.GTMaterials.AntimonyTrioxide;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.*;

public class CGCAntimonyMaterials {
    public static void preModify() {
        registerPhysicsPropertyMetal(AntimonyTrioxide, 3, -709.7);
    }
}
