package com.rundas.cgc.common.material.materials.sodium;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.changeComponentsAndFormula;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCSodiumOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Salt, -411.12);
        registerPhysicsPropertyOre(Sodalite, -13446.0);
    }

    public static void modify() {
        changeComponentsAndFormula(Sodalite, "Na8Cl2(AlSiO4)6", new MaterialStack(Sodium, 8), new MaterialStack(Chlorine, 2), new MaterialStack(Aluminium, 6), new MaterialStack(Silicon, 6), new MaterialStack(Oxygen, 24));
    }
}
