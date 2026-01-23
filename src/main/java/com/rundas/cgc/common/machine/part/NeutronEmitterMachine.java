package com.rundas.cgc.common.machine.part;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.gregtechceu.gtceu.common.machine.multiblock.part.FluidHatchPartMachine;

import net.minecraft.network.chat.Component;

import com.rundas.cgc.api.ability.CGCPartAbilities;
import com.rundas.cgc.api.widget.FilteredFluidTank;
import org.jetbrains.annotations.NotNull;

import static com.rundas.cgc.CreatingGregCore.CGC_REGISTRATE;
import static com.rundas.cgc.CreatingGregCore.id;
import static com.rundas.cgc.common.material.materials.CGCMaterials.FreeNeutronGas;

public class NeutronEmitterMachine extends FluidHatchPartMachine {

    public NeutronEmitterMachine(IMachineBlockEntity holder) {
        super(holder, 1, IO.BOTH, 1000, 1);
    }

    @Override
    protected @NotNull NotifiableFluidTank createTank(int initialCapacity, int slots, Object @NotNull... args) {
        return new FilteredFluidTank(this, 1, 1000, IO.BOTH,
                fs -> ChemicalHelper.getMaterial(fs.getFluid()) == FreeNeutronGas);
    }

    public static MachineDefinition register() {
        return CGC_REGISTRATE.machine("neutron_emitter", NeutronEmitterMachine::new)
                .langValue("Neutron Emitter")
                .rotationState(RotationState.ALL)
                .tooltips(Component.translatable("gtceu.universal.tooltip.fluid_storage_capacity", 1000))
                .workableTieredHullModel(id("block/machines/part/neutron_emitter"))
                .abilities(CGCPartAbilities.NEUTRON_EMITTER)
                .register();
    }
}
