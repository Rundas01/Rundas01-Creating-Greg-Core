package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import net.minecraft.util.Tuple;

/**
 * @param stableMaterial the most stable isotope of the material.
 * @param alphaDecay Tuple of the alpha decay product and the corresponding decay energy.
 * @param betaPlusDecay Tuple of the beta plus decay product and the corresponding decay energy.
 * @param betaMinusDecay Tuple of the beta minus decay product and the corresponding decay energy.
 * @param isFuel whether the Material can be used as fuel for the Fission Reactor
 * @param breedable whether the Material is breedable in Breeding Chambers
 */
public record NuclearProperty(Material stableMaterial, Tuple<Material, Double> alphaDecay, Tuple<Material, Double> betaPlusDecay, Tuple<Material, Double> betaMinusDecay, boolean isFuel, boolean breedable) implements IMaterialProperty {

    @Override
    public void verifyProperty(MaterialProperties properties) {}
}
