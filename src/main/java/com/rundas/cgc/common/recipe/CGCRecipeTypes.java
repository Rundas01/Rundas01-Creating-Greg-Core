package com.rundas.cgc.common.recipe;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class CGCRecipeTypes {

    public static void init() {}

    //Singleblock

    public static final GTRecipeType ROASTER_RECIPES = register("roaster", ELECTRIC)
            .setMaxIOSize(2,6,2,6)
            .setSlotOverlay(false, true, GuiTextures.FLUID_SLOT)
            .setSlotOverlay(true, true, GuiTextures.FLUID_SLOT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE)
            .setEUIO(IO.IN);

    public static final GTRecipeType CRYSTALLIZER_RECIPES = register("crystallizer", ELECTRIC)
            .setMaxIOSize(0,0,1,1)
            .setSlotOverlay(false, true, GuiTextures.FLUID_SLOT)
            .setSlotOverlay(true, true, GuiTextures.FLUID_SLOT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING)
            .setEUIO(IO.IN);

    public static final GTRecipeType DEHYDRATOR_RECIPES = register("dehydrator", ELECTRIC)
            .setMaxIOSize(1,6,1,6)
            .setSlotOverlay(false, true, GuiTextures.FLUID_SLOT)
            .setSlotOverlay(true, true, GuiTextures.FLUID_SLOT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL)
            .setEUIO(IO.IN);

    public static final GTRecipeType ISOTOPIC_STABILIZER_RECIPES = register("isotopic_stabilizer", ELECTRIC)
            .setMaxIOSize(1,1,2,2)
            .setSlotOverlay(false, true, GuiTextures.FLUID_SLOT)
            .setSlotOverlay(true, true, GuiTextures.FLUID_SLOT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.SCIENCE)
            .setEUIO(IO.IN);

    public static final GTRecipeType DECAY_HASTENER_RECIPES = register("decay_hastener", ELECTRIC)
            .setMaxIOSize(2,1,1,1)
            .setSlotOverlay(false, true, GuiTextures.FLUID_SLOT)
            .setSlotOverlay(true, true, GuiTextures.FLUID_SLOT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.SCIENCE)
            .setEUIO(IO.NONE);

    public static final GTRecipeType DECAY_GENERATOR_RECIPES = register("decay_generator", GENERATOR)
            .setMaxIOSize(2,1,1,1)
            .setSlotOverlay(false, true, GuiTextures.FLUID_SLOT)
            .setSlotOverlay(true, true, GuiTextures.FLUID_SLOT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.SCIENCE)
            .setEUIO(IO.OUT);

    //Multiblock
    public static final GTRecipeType FISSION_REACTOR_RECIPES = register("fission_reactor", MULTIBLOCK)
            .setMaxIOSize(2,1, 0,0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.SCIENCE)
            .setEUIO(IO.NONE);
}
