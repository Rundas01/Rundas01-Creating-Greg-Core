package com.rundas.cgc.common.material.materials.silver;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;

public class CGCSilverOreMaterials {

    public static Material Stephanite, Proustite;

    public static void init() {
        Stephanite = cgcOreMaterial("stephanite", 0x3d3d36, null, Arrays.asList(new MaterialStack(Silver, 5), new MaterialStack(Antimony, 1), new MaterialStack(Sulfur, 4)), -375.0);
        Proustite = cgcOreMaterial("proustite", 0x73142d, null, Arrays.asList(new MaterialStack(Silver, 3), new MaterialStack(Arsenic, 1), new MaterialStack(Sulfur, 3)), -111.3);
    }

    public static void preModify() {

    }
}
