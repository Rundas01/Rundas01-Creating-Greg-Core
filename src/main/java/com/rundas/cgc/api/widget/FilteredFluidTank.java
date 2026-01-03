package com.rundas.cgc.api.widget;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;

import net.minecraftforge.fluids.FluidStack;

import java.util.function.Predicate;

public class FilteredFluidTank extends NotifiableFluidTank {

    public FilteredFluidTank(MetaMachine machine, int slots, int capacity, IO io, Predicate<FluidStack> filter) {
        super(machine, slots, capacity, io);
        this.setFilter(filter);
    }
}
