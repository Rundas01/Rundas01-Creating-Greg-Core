package com.rundas.cgc.util;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.unification.material.MaterialRegistryManager;
import com.rundas.cgc.common.material.CGCPropertyKeys;

public class CGCNuclearUtil {
    public static Material getNuclearMaterial(long protons, long neutrons) {
        for (Material material : MaterialRegistryManager.getInstance().getRegisteredMaterials()) {
            if (material.hasProperty(CGCPropertyKeys.NUCLEAR)) {
                if (material.getProtons() == protons && material.getNeutrons() == neutrons) {
                    return material;
                }
            }
        }
        return null;
    }

    public static Material getAlphaDecayMaterial(Material material) {
        return getNuclearMaterial(material.getProtons() - 2, material.getNeutrons() - 2);
    }

    public static Material getBetaPlusDecayMaterial(Material material) {
        return getNuclearMaterial(material.getProtons() - 1, material.getNeutrons() + 1);
    }

    public static Material getBetaMinusDecayMaterial(Material material) {
        return getNuclearMaterial(material.getProtons() + 1, material.getNeutrons() - 1);
    }
}
