package com.rundas.cgc.api.widget;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;

import net.minecraft.world.item.ItemStack;

import java.util.function.Predicate;

public class FilteredItemStackHandler extends NotifiableItemStackHandler {

    public FilteredItemStackHandler(MetaMachine machine, int slots, IO handlerIO, IO capabilityIO,
                                    Predicate<ItemStack> filter) {
        super(machine, slots, handlerIO, capabilityIO);
        this.setFilter(filter);
    }
}
