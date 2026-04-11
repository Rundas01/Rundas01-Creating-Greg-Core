package com.rundas.cgc.common.material.materials.iron;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcDustMaterial;

public class CGCIronMaterials {

    public static Material IronIIISilicate;

    public static void init() {
        IronIIISilicate = cgcDustMaterial("iron_iii_silicate", null, null, Arrays.asList(new MaterialStack(Iron, 2), new MaterialStack(Silicon, 4), new MaterialStack(Oxygen, 5)), 1, 3, -1625.0);
    }

    public static void preModify() {

    }
}
