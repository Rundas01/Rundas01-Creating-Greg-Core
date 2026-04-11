package com.rundas.cgc.common.material.materials.titanium;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCTitaniumOreMaterials {

    public static Material Perovskite, Titanomagnetite;

    public static void preModify() {
        registerPhysicsPropertyOre(Ilmenite, -1153.9);
    }

    public static void init() {
        Perovskite = cgcOreMaterial("perovskite", 0x0b3d1d, null, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Titanium, 1), new MaterialStack(Oxygen, 3)), -1662.7);
        Titanomagnetite = cgcOreMaterial("titanomagnetite", 0x555c45, null, Arrays.asList(new MaterialStack(Iron, 2), new MaterialStack(Titanium, 1), new MaterialStack(Oxygen, 4)), -1517.0);
    }
}
