package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

import java.util.List;

/**
 * @param leach   The Leach that the Roaster produces.
 * @param impureSlag The impure slag that the Flotation Cell produces as a byproduct of separating solutions.
 * @param slag The Slag after vacuum filtration of the impure Slag
 * @param roastedDust If the material can be roasted, this param is not null.
 */
public record OreprocProperty(Material leach, Material impureSlag, Material slag, Material roastedDust) implements IMaterialProperty {

    @Override
    public void verifyProperty(MaterialProperties properties) {
        properties.ensureSet(PropertyKey.ORE, true);
    }
}
