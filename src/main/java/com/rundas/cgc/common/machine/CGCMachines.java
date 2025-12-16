package com.rundas.cgc.common.machine;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;

import com.rundas.cgc.CreatingGregCore;
import com.rundas.cgc.common.CGCCreativeModeTab;
import com.rundas.cgc.common.recipe.CGCRecipeTypes;

import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.largeTankSizeFunction;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerSimpleMachines;

public class CGCMachines {

    public static void init() {
        CreatingGregCore.CGC_REGISTRATE.creativeModeTab(() -> CGCCreativeModeTab.MACHINES);
    }

    public static final MachineDefinition[] ROASTER = registerSimpleMachines("roaster", CGCRecipeTypes.ROASTER_RECIPES,
            largeTankSizeFunction);
}
