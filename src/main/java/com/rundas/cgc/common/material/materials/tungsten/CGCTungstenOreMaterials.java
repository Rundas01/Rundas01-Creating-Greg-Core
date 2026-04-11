package com.rundas.cgc.common.material.materials.tungsten;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCTungstenOreMaterials {
    public static Material Ferberite, Huebnerite;

    public static void preModify() {
        registerPhysicsPropertyOre(Scheelite, -168.5);
    }

    public static void init() {
        Huebnerite = cgcOreMaterial("huebnerite", 0x1e1c36, null, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Tungsten, 1), new MaterialStack(Oxygen, 4)), -1145.8);
        Ferberite = cgcOreMaterial("ferberite", 0x1e1c36, null, Arrays.asList(new MaterialStack(Manganese, 1), new MaterialStack(Tungsten, 1), new MaterialStack(Oxygen, 4)), -1172.5);
    }
}
