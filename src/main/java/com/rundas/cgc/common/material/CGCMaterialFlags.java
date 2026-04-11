package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;

public class CGCMaterialFlags {

    public static final MaterialFlag HAS_COMB = new MaterialFlag.Builder("has_comb").build();
    public static final MaterialFlag IS_CATALYST = new MaterialFlag.Builder("is_catalyst").build();
    public static final MaterialFlag IS_NUCLEAR = new MaterialFlag.Builder("is_nuclear").build();
}
