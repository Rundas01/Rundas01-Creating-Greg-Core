package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;

public record TFCProperty(int anvilTier, Material meltsInto, int meltingAmount) implements IMaterialProperty {
    @Override
    public void verifyProperty(MaterialProperties properties) {}
}
