package com.rundas.cgc.common.material.materials.magnesium;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.registerRoastedDusts;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCMagnesiumOreMaterials {
    public static void preModify() {
        registerPhysicsPropertyOre(Alunite, -5149.0);
        registerPhysicsPropertyOre(Asbestos, -4100.0);
        registerPhysicsPropertyOre(Magnesite, -1095.8);
        registerPhysicsPropertyOre(Pyrope, -72.01);
        registerPhysicsPropertyOre(Soapstone, -5900.6);
        registerPhysicsPropertyOre(Talc, -5900.6);
    }

    public static void init() {
        registerRoastedDusts(Asbestos, Arrays.asList(new MaterialStack(Magnesia, 3), new MaterialStack(SiliconDioxide, 2)), null);
    }
}
