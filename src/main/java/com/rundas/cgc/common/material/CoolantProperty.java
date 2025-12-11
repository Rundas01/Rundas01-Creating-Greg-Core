package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

/**
 * @param specificHeatCapacity specific heat capacity of the material in kJ/(g * K) or EU/(g * K) respectively.
 * @param hotCoolant the corresponding hot coolant of the material.
 */
public record CoolantProperty(double specificHeatCapacity, Material hotCoolant) implements IMaterialProperty {

    @Override
    public void verifyProperty(MaterialProperties properties) {
        properties.ensureSet(PropertyKey.FLUID);
    }
}
