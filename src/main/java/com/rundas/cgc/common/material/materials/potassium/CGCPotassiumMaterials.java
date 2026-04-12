package com.rundas.cgc.common.material.materials.potassium;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcDustMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyCompound;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCPotassiumMaterials {

    public static Material PotassiumPermanganate;

    public static void preModify() {
        registerPhysicsPropertyCompound(PotassiumSulfate, -1437.7);
    }

    public static void init() {}
}
