package com.rundas.cgc.common.material.materials.palladium;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;

public class CGCPalladiumOreMaterials {

    public static Material Polarite;

    public static void init() {
        Polarite = cgcOreMaterial("polarite", 0x2e360a, null, Arrays.asList(new MaterialStack(Palladium, 2), new MaterialStack(Lead, 1), new MaterialStack(Bismuth, 1)), 0.0);
    }
}
