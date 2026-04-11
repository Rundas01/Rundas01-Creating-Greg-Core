package com.rundas.cgc.common.material.materials.tin;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCTinOreMaterials {

    public static Material Berndtite;

    public static void preModify() {
        registerPhysicsPropertyOre(Cassiterite, -577.6, Tin, 52.6, 1903);
        registerPhysicsPropertyOre(CassiteriteSand, -577.6, Tin, 52.6, 1903);
    }

    public static void init() {
        Berndtite = cgcOreMaterial("berndtite", null, null, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Sulfur, 4)), -131.0);
    }
}
