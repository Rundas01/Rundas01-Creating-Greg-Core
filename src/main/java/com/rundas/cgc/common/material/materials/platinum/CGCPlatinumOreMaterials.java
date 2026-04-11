package com.rundas.cgc.common.material.materials.platinum;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.changeComponentsAndFormula;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCPlatinumOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Cooperite, -376.86);
    }

    public static void modify() {
        changeComponentsAndFormula(Cooperite, new MaterialStack(Platinum, 3), new MaterialStack(Palladium, 1), new MaterialStack(Nickel, 1), new MaterialStack(Sulfur, 5));
    }
}
