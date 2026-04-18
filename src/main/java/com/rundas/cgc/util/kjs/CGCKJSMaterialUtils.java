package com.rundas.cgc.util.kjs;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.rundas.cgc.common.material.CGCPropertyKeys;
import com.rundas.cgc.common.material.PhysicsProperty;
import dev.architectury.fluid.FluidStack;
import net.minecraft.world.item.ItemStack;

import java.util.List;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Oxygen;
import static com.rundas.cgc.common.material.CGCPropertyKeys.PHYSICS;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.*;

public class CGCKJSMaterialUtils {

    public static int getMetalAmountFromOxide(String s) {
        Material oxide = GTMaterials.get(s);
        return getTotalAtomAmount(oxide) - getAtomAmount(oxide, Oxygen);
    }

    public static int getOxygenAmountFromOxide(String s) {
        Material oxide = GTMaterials.get(s);
        return getAtomAmount(oxide, Oxygen);
    }
}
