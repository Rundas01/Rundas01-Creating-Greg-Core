package com.rundas.cgc.common.material.materials.scandium;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;

public class CGCScandiumOreMaterials {

    public static Material Thortveitite;

    public static void init() {
        Thortveitite = cgcOreMaterial("thortveitite", 0xb38969, null, Arrays.asList(new MaterialStack(Scandium, 1), new MaterialStack(Yttrium, 1), new MaterialStack(Silicon, 2), new MaterialStack(Oxygen, 7)), 0.0);
    }
}
