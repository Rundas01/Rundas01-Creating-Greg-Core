package com.rundas.cgc.common.machine.multiblock;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.rundas.cgc.CreatingGregCore;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GCYMBlocks.CASING_ATOMIC;
import static com.rundas.cgc.CreatingGregCore.id;
import static com.rundas.cgc.common.recipe.CGCRecipeTypes.REACTION_FURNACE_RECIPES;

public class ReactionFurnaceMachine extends WorkableElectricMultiblockMachine {

    public ReactionFurnaceMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    //////////////////////////////////////
    // ***** LDLib SyncData ******//
    //////////////////////////////////////

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ReactionFurnaceMachine.class,
            WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    //////////////////////////////////////
    // ***** Registration ******//
    //////////////////////////////////////

    private static final Supplier<? extends Block> casing = CASING_ATOMIC;

    public static MultiblockMachineDefinition register() {
        return CreatingGregCore.CGC_REGISTRATE
                .multiblock("reaction_furnace", ReactionFurnaceMachine::new)
                .langValue("Reaction Furnace")
                .appearanceBlock(casing)
                .rotationState(RotationState.NON_Y_AXIS)
                .recipeType(REACTION_FURNACE_RECIPES)
                .pattern(definition -> FactoryBlockPattern.start()
                        .aisle("CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC")
                        .aisle("CCCCC", "C###C", "C###C", "C###C", "CCCCC")
                        .aisle("CCCCC", "C###C", "C###C", "C###C", "CCCCC")
                        .aisle("CCCCC", "C###C", "C###C", "C###C", "CCCCC")
                        .aisle("CCCCC", "CCCCC", "CCSCC", "CCCCC", "CCCCC")
                        .where('S', controller(blocks(definition.get())))
                        .where('C', blocks(casing.get()).or(autoAbilities(definition.getRecipeTypes())))
                        .where('#', any())
                        .build())
                .workableCasingModel(GTCEu.id("block/casings/gcym/atomic_casing"),
                        id("block/machines/multiblock/reaction_furnace"))
                .register();
    }
}
