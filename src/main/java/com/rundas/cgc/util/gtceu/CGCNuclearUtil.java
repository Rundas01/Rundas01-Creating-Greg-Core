package com.rundas.cgc.util.gtceu;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.unification.material.MaterialRegistryManager;

import net.minecraft.util.Tuple;

import com.rundas.cgc.common.material.CGCMaterialFlags;
import com.rundas.cgc.common.material.CGCPropertyKeys;
import com.rundas.cgc.common.material.NuclearProperty;

import java.util.Collections;
import java.util.List;

public class CGCNuclearUtil {

    public static Material getNuclearMaterial(long protons, long neutrons) {
        for (Material material : MaterialRegistryManager.getInstance().getRegisteredMaterials()) {
            if (material.hasFlag(CGCMaterialFlags.IS_NUCLEAR)) {
                if (material.getProtons() == protons && material.getNeutrons() == neutrons) {
                    return material;
                }
            }
        }
        return null;
    }

    public static Material getAlphaDecayMaterial(Material material) {
        if (material == null) {
            return null;
        }
        return getNuclearMaterial(material.getProtons() - 2, material.getNeutrons() - 2);
    }

    public static Material getBetaPlusDecayMaterial(Material material) {
        if (material == null) {
            return null;
        }
        return getNuclearMaterial(material.getProtons() - 1, material.getNeutrons() + 1);
    }

    public static Material getBetaMinusDecayMaterial(Material material) {
        if (material == null) {
            return null;
        }
        return getNuclearMaterial(material.getProtons() + 1, material.getNeutrons() - 1);
    }

    public static void registerNuclearProperty(Material material, Material stable, double alphaE, double betaPlusE,
                                               double betaMinusE, boolean isFuel) {
        Tuple<Material, Double> alphaDecay = null, betaPlusDecay = null, betaMinusDecay = null;
        if (alphaE > 0) {
            alphaDecay = new Tuple<>(getAlphaDecayMaterial(material), alphaE);
        }
        if (betaPlusE > 0) {
            betaPlusDecay = new Tuple<>(getBetaPlusDecayMaterial(material), betaPlusE);
        }
        if (betaMinusE > 0) {
            betaMinusDecay = new Tuple<>(getBetaMinusDecayMaterial(material), betaMinusE);
        }
        material.setProperty(CGCPropertyKeys.NUCLEAR,
                new NuclearProperty(stable, alphaDecay, betaPlusDecay, betaMinusDecay, isFuel,
                        getBetaMinusDecayMaterial(
                                getNuclearMaterial(material.getProtons(), material.getNeutrons() + 1)) != null));
    }

    public static List<Tuple<List<Material>, Double>> getFissionReactions(Material material) {
        return Collections.emptyList();
    }
}
