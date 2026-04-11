package com.rundas.cgc.common.material.materials.niobium;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.changeComponentsAndFormula;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCNiobiumOreMaterials {

    public static Material Samarskite;

    public static void preModify() {
        registerPhysicsPropertyOre(Pyrochlore, -3346.91);
    }

    public static void init() {
        Samarskite = cgcOreMaterial("samarskite", null, null, Arrays.asList(new MaterialStack(Yttrium, 1), new MaterialStack(Iron, 1), new MaterialStack(Niobium, 2), new  MaterialStack(Oxygen, 8)), -3315.0);
    }

    public static void modify() {
        changeComponentsAndFormula(Pyrochlore, new MaterialStack(Calcium, 2), new MaterialStack(Niobium, 2), new MaterialStack(Oxygen, 7));
    }
}
