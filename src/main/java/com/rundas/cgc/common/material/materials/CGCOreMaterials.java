package com.rundas.cgc.common.material.materials;

import com.rundas.cgc.common.material.materials.copper.CGCCopperOreMaterials;
import com.rundas.cgc.common.material.materials.iron.CGCIronOreMaterials;
import com.rundas.cgc.common.material.materials.tin.CGCTinOreMaterials;

public class CGCOreMaterials {

    public static void init() {
        CGCCopperOreMaterials.init();
        CGCIronOreMaterials.init();
        CGCTinOreMaterials.init();
    }
}
