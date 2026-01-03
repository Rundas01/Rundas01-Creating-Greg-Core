package com.rundas.cgc.common.machine.part;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.common.machine.multiblock.part.ItemBusPartMachine;

import net.minecraft.world.item.ItemStack;

import com.rundas.cgc.api.ability.CGCPartAbilities;
import com.rundas.cgc.api.widget.FilteredItemStackHandler;
import com.rundas.cgc.common.material.CGCPropertyKeys;
import com.rundas.cgc.common.material.NuclearProperty;
import org.jetbrains.annotations.NotNull;

import static com.rundas.cgc.CreatingGregCore.CGC_REGISTRATE;
import static com.rundas.cgc.CreatingGregCore.id;

public class BreedingChamberMachine extends ItemBusPartMachine {

    public BreedingChamberMachine(IMachineBlockEntity holder) {
        super(holder, 1, IO.BOTH);
    }

    @Override
    protected @NotNull NotifiableItemStackHandler createInventory(Object @NotNull... args) {
        return new FilteredItemStackHandler(this, 1, IO.IN, IO.BOTH, BreedingChamberMachine::isBreedable);
    }

    private static boolean isBreedable(ItemStack stack) {
        Material material = ChemicalHelper.getMaterialStack(stack).material();
        if (!material.hasProperty(CGCPropertyKeys.NUCLEAR)) {
            return false;
        }
        NuclearProperty property = material.getProperty(CGCPropertyKeys.NUCLEAR);
        return property.breedable();
    }

    public static MachineDefinition register() {
        return CGC_REGISTRATE.machine("breeding_chamber", BreedingChamberMachine::new)
                .langValue("Breeding Chamber")
                .rotationState(RotationState.ALL)
                .workableTieredHullModel(id("block/machines/part/breeding_chamber"))
                .abilities(CGCPartAbilities.BREEDING_CHAMBER)
                .register();
    }
}
