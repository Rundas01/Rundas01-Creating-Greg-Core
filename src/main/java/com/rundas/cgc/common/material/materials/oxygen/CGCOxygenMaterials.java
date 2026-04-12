package com.rundas.cgc.common.material.materials.oxygen;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.List;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Oxygen;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcGasMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.changeComponentsAndFormula;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCOxygenMaterials {

    public static Material Ozone;

    public static void preModify() {

    }

    public static void init() {
        Ozone = cgcGasMaterial("ozone", null, null, List.of(new MaterialStack(Oxygen, 3)), 3, 142.67);
    }

    public static void modify() {
        changeComponentsAndFormula(Oxygen, new MaterialStack(Oxygen, 2));
    }
}
