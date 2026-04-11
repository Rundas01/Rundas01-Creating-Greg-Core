package com.rundas.cgc.common.material.materials.lithium;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;

public class CGCLithiumOreMaterials {

    public static Material Petalite;

    public static void init() {
        Petalite = cgcOreMaterial("petalite", 0xd2f7f6, null, Arrays.asList(new MaterialStack(Lithium, 1), new MaterialStack(Aluminium, 1), new MaterialStack(Silicon, 4), new MaterialStack(Oxygen, 10)), -4886.5);
    }

    public static void preModify() {

    }
}
