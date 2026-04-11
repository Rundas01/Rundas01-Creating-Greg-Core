package com.rundas.cgc.common.machine.multiblock;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;

import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

import com.rundas.cgc.CreatingGregCore;
import com.rundas.cgc.api.ability.CGCPartAbilities;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GCYMBlocks.CASING_ATOMIC;
import static com.rundas.cgc.CreatingGregCore.id;
import static com.rundas.cgc.common.recipe.CGCRecipeTypes.FISSION_REACTOR_RECIPES;

public class FissionReactorMachine extends WorkableMultiblockMachine implements IFancyUIMachine {



    //////////////////////////////////////
    // ***** LDLib SyncData ******//
    //////////////////////////////////////

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(FissionReactorMachine.class,
            WorkableMultiblockMachine.MANAGED_FIELD_HOLDER);

    public FissionReactorMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    protected @NotNull RecipeLogic createRecipeLogic(Object @NotNull ... args) {
        return super.createRecipeLogic(args);
    }

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
                .multiblock("fission_reactor", FissionReactorMachine::new)
                .langValue("Fission Reactor")
                .tooltips(Component.translatable("cgc.machine.multiblock.fission_reactor.tooltip"))
                .appearanceBlock(casing)
                .rotationState(RotationState.NON_Y_AXIS)
                .recipeType(FISSION_REACTOR_RECIPES)
                .pattern(definition -> FactoryBlockPattern.start()
                        .aisle("CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC")
                        .aisle("CCCCC", "C###C", "C###C", "C###C", "CCCCC")
                        .aisle("CCCCC", "C###C", "C###C", "C###C", "CCCCC")
                        .aisle("CCCCC", "C###C", "C###C", "C###C", "CCCCC")
                        .aisle("CCCCC", "CCCCC", "CCSCC", "CCCCC", "CCCCC")
                        .where('S', controller(blocks(definition.get())))
                        .where('C', blocks(casing.get()))
                        .where('#',
                                any().or(abilities(CGCPartAbilities.FISSION_CHAMBER).setMinGlobalLimited(1))
                                        .or(abilities(CGCPartAbilities.COOLANT_CHAMBER).setMinGlobalLimited(1))
                                        .or(abilities(CGCPartAbilities.NEUTRON_EMITTER).setExactLimit(1)))
                        .build())
                .workableCasingModel(GTCEu.id("block/casings/gcym/atomic_casing"),
                        id("block/machines/multiblock/fission_reactor"))
                .register();
    }
}
