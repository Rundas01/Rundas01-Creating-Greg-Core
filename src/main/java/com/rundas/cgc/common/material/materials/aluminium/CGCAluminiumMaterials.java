package com.rundas.cgc.common.material.materials.aluminium;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcDustMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCAluminiumMaterials {

    public static Material AluminiumIIIOxide;

    public static void preModify() {

    }

    public static void init() {
        AluminiumIIIOxide = cgcDustMaterial("aluminium_iii_oxide", null, null, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Oxygen, 3)), 1, 2, -1676.0);
    }
}
