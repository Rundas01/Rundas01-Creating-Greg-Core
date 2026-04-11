package com.rundas.cgc.common.material.materials.rhodium;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;

public class CGCRhodiumOreMaterials {

    public static Material Rhodplumsite;

    public static void init() {
        Rhodplumsite = cgcOreMaterial("rhodplumsite", 0x292726, null, Arrays.asList(new MaterialStack(Rhodium, 3), new MaterialStack(Lead, 2), new MaterialStack(Sulfur, 2)), 0.0);
    }
}
