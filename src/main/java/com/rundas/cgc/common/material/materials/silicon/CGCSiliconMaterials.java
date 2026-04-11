package com.rundas.cgc.common.material.materials.silicon;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcFluidMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.*;

public class CGCSiliconMaterials {

    public static Material OrthosilicicAcid;

    public static void preModify() {
        registerPhysicsPropertyCompound(SiliconDioxide, 2, -911.0);
    }

    public static void init() {
        OrthosilicicAcid = cgcFluidMaterial("orthosilicic_acid", null, null, Arrays.asList(new MaterialStack(Hydrogen, 4), new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 4)), 2, -1470.0);
    }
}
