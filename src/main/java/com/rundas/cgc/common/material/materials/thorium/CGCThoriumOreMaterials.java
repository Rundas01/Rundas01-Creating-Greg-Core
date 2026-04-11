package com.rundas.cgc.common.material.materials.thorium;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;

public class CGCThoriumOreMaterials {

    public static Material Lorandite, Hutchinsonite;

    public static void init() {
        Lorandite = cgcOreMaterial("lorandite", 0x913111, null, Arrays.asList(new MaterialStack(Thorium, 1), new MaterialStack(Arsenic, 1), new MaterialStack(Sulfur, 2)), 0.0);
        Hutchinsonite = cgcOreMaterial("hutchinsonite", 0x332f2e, null, Arrays.asList(new MaterialStack(Thorium, 1), new MaterialStack(Lead, 1), new MaterialStack(Arsenic, 5), new MaterialStack(Sulfur, 9)), 0.0);
    }
}
