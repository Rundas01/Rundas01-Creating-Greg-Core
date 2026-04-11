package com.rundas.cgc.common.material.materials.manganese;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcDustMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcFluidMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCManganeseMaterials {

    public static Material PotassiumPermanganate, PermanganicAcid;

    public static void init() {
        PotassiumPermanganate = cgcDustMaterial("potassium_permanganate", 0x320354, null, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Manganese, 1), new MaterialStack(Oxygen, 4)), 1, 3, -813.4);
        PermanganicAcid = cgcFluidMaterial("permanganic_acid", null, null, Arrays.asList(new MaterialStack(Hydrogen, 1), new MaterialStack(Manganese, 1), new MaterialStack(Oxygen, 4)), 3, -600.0);
    }

    public static void preModify() {
        registerPhysicsPropertyElement(Manganese, 3, true);
    }
}
