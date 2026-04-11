package com.rundas.cgc.common.material.materials.antimony;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCAntimonyOreMaterials {

    public static Material Livingstonite;

    public static void preModify() {
        registerPhysicsPropertyOre(Stibnite, -141.8);
    }

    public static void init() {
        Livingstonite = cgcOreMaterial("livingstonite", 0x5e5654, null, Arrays.asList(new MaterialStack(Mercury, 1), new MaterialStack(Antimony, 4), new MaterialStack(Sulfur, 8)), 0.0);
    }
}
