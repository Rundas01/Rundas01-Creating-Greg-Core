package com.rundas.cgc.common.material.materials.nickel;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.registerRoastedDusts;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.changeComponentsAndFormula;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCNickelOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Garnierite,-239.9, Nickel, 44.31, 2228);
        registerPhysicsPropertyOre(Pentlandite,-837.0, Nickel, 442.7, 1150);
    }

    public static void init() {
        registerRoastedDusts(Pentlandite, Arrays.asList(new MaterialStack(Nickel, 5), new MaterialStack(Iron, 4), new MaterialStack(Sulfur, 8)), null);
    }

    public static void modify() {
        changeComponentsAndFormula(Pentlandite, new MaterialStack(Nickel, 5), new MaterialStack(Iron, 4), new MaterialStack(Sulfur, 8));
    }
}
