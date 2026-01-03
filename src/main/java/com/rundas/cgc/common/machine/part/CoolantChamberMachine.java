package com.rundas.cgc.common.machine.part;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.gregtechceu.gtceu.api.transfer.fluid.CustomFluidTank;

import net.minecraft.network.chat.Component;

import com.rundas.cgc.api.ability.CGCPartAbilities;
import com.rundas.cgc.common.material.CGCPropertyKeys;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static com.rundas.cgc.CreatingGregCore.CGC_REGISTRATE;
import static com.rundas.cgc.CreatingGregCore.id;

public class CoolantChamberMachine extends TieredIOPartMachine {

    public CoolantChamberMachine(IMachineBlockEntity holder) {
        super(holder, 1, IO.BOTH);
    }

    private final List<CustomFluidTank> tanks = Arrays.asList(
            new CustomFluidTank(1000,
                    fluidStack -> ChemicalHelper.getMaterial(fluidStack.getFluid())
                            .hasProperty(CGCPropertyKeys.COOLANT)),
            new CustomFluidTank(1000));

    @Getter
    private final NotifiableFluidTank tank = new NotifiableFluidTank(this, tanks, IO.BOTH, IO.OUT);

    public static MachineDefinition register() {
        return CGC_REGISTRATE.machine("coolant_chamber", CoolantChamberMachine::new)
                .langValue("Coolant Chamber")
                .rotationState(RotationState.ALL)
                .tooltips(Component.translatable("gtceu.universal.tooltip.fluid_storage_capacity", 1000))
                .workableTieredHullModel(id("block/machines/part/coolant_chamber"))
                .abilities(CGCPartAbilities.COOLANT_CHAMBER)
                .register();
    }
}
