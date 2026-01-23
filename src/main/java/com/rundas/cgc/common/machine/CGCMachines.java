package com.rundas.cgc.common.machine;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;

import com.rundas.cgc.common.CGCCreativeModeTab;
import com.rundas.cgc.common.machine.multiblock.FissionReactorMachine;
import com.rundas.cgc.common.machine.multiblock.ReactionFurnaceMachine;
import com.rundas.cgc.common.machine.part.BreedingChamberMachine;
import com.rundas.cgc.common.machine.part.CoolantChamberMachine;
import com.rundas.cgc.common.machine.part.FissionChamberMachine;
import com.rundas.cgc.common.machine.part.NeutronEmitterMachine;
import com.rundas.cgc.common.recipe.CGCRecipeTypes;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraftforge.fluids.FluidType;

import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.*;
import static com.rundas.cgc.CreatingGregCore.CGC_REGISTRATE;
import static com.rundas.cgc.util.CGCMachineUtil.*;

public class CGCMachines {

    public static void init() {
        CGC_REGISTRATE.creativeModeTab(() -> CGCCreativeModeTab.MACHINES);
    }

    private static final Int2IntFunction roasterTSF = tier -> (tier <= GTValues.LV ? 128 :
            tier == GTValues.MV ? 256 : 512) * FluidType.BUCKET_VOLUME;

    public static final MachineDefinition[] ROASTER = registerCGCSimpleMachines("roaster",
            CGCRecipeTypes.ROASTER_RECIPES,
            roasterTSF);

    public static final MachineDefinition[] BATCH_REACTOR = registerCGCSimpleMachines("batch_reactor",
            CGCRecipeTypes.BATCH_REACTOR_RECIPES,
            defaultTankSizeFunction);

    public static final MachineDefinition[] MIXING_REACTOR = registerCGCSimpleMachines("mixing_reactor",
            CGCRecipeTypes.MIXING_REACTOR_RECIPES,
            defaultTankSizeFunction);

    public static final MachineDefinition[] GAS_BUBBLE_REACTOR = registerCGCSimpleMachines("gas_bubble_reactor",
            CGCRecipeTypes.GAS_BUBBLE_REACTOR_RECIPES,
            defaultTankSizeFunction);

    public static final MachineDefinition[] DISSOLUTION_REACTOR = registerCGCSimpleMachines("dissolution_reactor",
            CGCRecipeTypes.DISSOLUTION_REACTOR_RECIPES,
            defaultTankSizeFunction);

    public static final MachineDefinition[] CATALYTIC_REACTOR = registerCGCSimpleMachines("catalytic_reactor",
            CGCRecipeTypes.CATALYTIC_REACTOR_RECIPES,
            defaultTankSizeFunction);

    public static final MachineDefinition[] VACUUM_FILTER = registerCGCSimpleMachines("vacuum_filter",
            CGCRecipeTypes.VACUUM_FILTER_RECIPES,
            defaultTankSizeFunction);

    public static final MachineDefinition[] DECAY_HASTENER = registerCGCSimpleMachines("decay_hastener",
            CGCRecipeTypes.DECAY_HASTENER_RECIPES,
            defaultTankSizeFunction);

    public static final MachineDefinition[] ISOTOPIC_STABILIZER = registerCGCSimpleMachines("isotopic_stabilizer",
            CGCRecipeTypes.ISOTOPIC_STABILIZER_RECIPES,
            defaultTankSizeFunction);

    public static final MachineDefinition NEUTRON_EMITTER = NeutronEmitterMachine.register();
    public static final MachineDefinition FISSION_CHAMBER = FissionChamberMachine.register();
    public static final MachineDefinition BREEDING_CHAMBER = BreedingChamberMachine.register();
    public static final MachineDefinition COOLANT_CHAMBER = CoolantChamberMachine.register();

    // Multiblocks

    public static final MultiblockMachineDefinition FISSION_REACTOR = FissionReactorMachine.register();
    public static final MultiblockMachineDefinition REACTION_FURNACE = ReactionFurnaceMachine.register();
}
