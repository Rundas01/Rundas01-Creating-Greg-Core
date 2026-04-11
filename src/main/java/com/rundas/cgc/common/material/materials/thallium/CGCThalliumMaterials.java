package com.rundas.cgc.common.material.materials.thallium;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcDustMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerDustProperty;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCThalliumMaterials {

    public static Material ThalliumIIIOxide;

    public static void preModify() {
        registerDustProperty(Thallium);
        registerPhysicsPropertyElement(Thallium, 3, true);
    }

    public static void init() {
        ThalliumIIIOxide = cgcDustMaterial("thallium_iii_oxide", null, null, Arrays.asList(new MaterialStack(Thallium, 2), new MaterialStack(Oxygen, 3)), 1, 3, -390.4, null);
    }
}
