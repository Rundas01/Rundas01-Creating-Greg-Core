package com.rundas.cgc.common.material.materials.lead;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCLeadOreMaterials {

    public static Material Vanadinite;

    public static void preModify() {
        registerPhysicsPropertyOre(Galena, -100.0);
        registerPhysicsPropertyOre(Wulfenite, -1051.2);
    }

    public static void init() {
        Vanadinite = cgcOreMaterial("vanadinite", 0xbf5915, null, Arrays.asList(new MaterialStack(Lead, 5), new MaterialStack(Vanadium, 4), new MaterialStack(Oxygen, 12), new MaterialStack(Chlorine, 1)), -3796.0, "Pb5(VO4)3Cl");
    }
}
