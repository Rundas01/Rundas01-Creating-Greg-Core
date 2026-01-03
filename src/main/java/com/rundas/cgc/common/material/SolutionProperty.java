package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

import java.util.List;

/**
 * @param solvent   Solvent of the Solution.
 * @param solution Normal Solution
 * @param crystallizedSolution The Crystallized Solution
 * @param dilutedSolutions If the material has diluted solutions, this list contains them
 */
public record SolutionProperty(Material solvent, Material solution, Material crystallizedSolution, List<Material> dilutedSolutions) implements IMaterialProperty {

    @Override
    public void verifyProperty(MaterialProperties properties) {
        properties.ensureSet(PropertyKey.DUST, true);
    }
}
