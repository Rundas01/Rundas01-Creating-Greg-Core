package com.rundas.cgc.common.material.materials.iron;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.common.material.materials.aluminium.CGCAluminiumMaterials.AluminiumIIIOxide;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.registerRoastedDusts;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCIronOreMaterials {

    public static void preModify() {
        registerPhysicsPropertyOre(Hematite,-824.2);
        registerPhysicsPropertyOre(Goethite,-562.0);
        registerPhysicsPropertyOre(Limonite,-562.0);
        registerPhysicsPropertyOre(Magnetite,-1120.0);
        registerPhysicsPropertyOre(Pyrite,-179.0);
        registerPhysicsPropertyOre(Almandine,-5269.63);
    }

    public static void init() {
        registerRoastedDusts(Almandine, Arrays.asList(new MaterialStack(AluminiumIIIOxide, 4), new MaterialStack(Hematite, 6), new MaterialStack(SiliconDioxide, 12)), Iron);
    }
}
