package com.rundas.cgc.common.recipe;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeSerializer;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.rundas.cgc.CreatingGregCore.id;

public class CGCRecipeTypes {

    public static void init() {
        COMBUSTION_GENERATOR_FUELS.setMaxIOSize(0, 0, 2, 3);
        GAS_TURBINE_FUELS.setMaxIOSize(0, 0, 2, 3);
    }

    public static GTRecipeType registerMachine(String name, int mi, int mo, int mfi, int mfo, RecipeType<?>... proxyRecipes) {
        GTRecipeType type = register(name, ELECTRIC, mi, mo, mfi, mfo, proxyRecipes);
        type.setEUIO(IO.IN);
        return type;
    }

    public static GTRecipeType registerGenerator(String name, int mi, int mo, int mfi, int mfo, RecipeType<?>... proxyRecipes) {
        GTRecipeType type = register(name, ELECTRIC, mi, mo, mfi, mfo, proxyRecipes);
        type.setEUIO(IO.OUT);
        return type;
    }

    public static GTRecipeType registerMultiblockMachine(String name, int mi, int mo, int mfi, int mfo, RecipeType<?>... proxyRecipes) {
        GTRecipeType type = register(name, MULTIBLOCK, mi, mo, mfi, mfo, proxyRecipes);
        type.setEUIO(IO.IN);
        return type;
    }

    public static GTRecipeType registerMultiblockGenerator(String name, int mi, int mo, int mfi, int mfo, RecipeType<?>... proxyRecipes) {
        GTRecipeType type = register(name, MULTIBLOCK, mi, mo, mfi, mfo, proxyRecipes);
        type.setEUIO(IO.OUT);
        return type;
    }

    public static GTRecipeType register(String name, String group, int mi, int mo, int mfi, int mfo, RecipeType<?>... proxyRecipes) {
        var recipeType = new GTRecipeType(id(name), group, proxyRecipes);
        GTRegistries.register(BuiltInRegistries.RECIPE_TYPE, recipeType.registryName, recipeType);
        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, recipeType.registryName, new GTRecipeSerializer());
        GTRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
        recipeType.setMaxIOSize(mi, mo, mfi, mfo);
        if (mfi > 0) {
            recipeType.setSlotOverlay(false, true, GuiTextures.FLUID_SLOT);
        }
        if (mfo > 0) {
            recipeType.setSlotOverlay(true, true, GuiTextures.FLUID_SLOT);
        }
        return recipeType.addDataInfo(d -> {
            int energy = d.getInt("enthalpy");
            return LocalizationUtils.format("cgc.recipe.energy", energy);
        });
    }

    // Singleblock

    public static final GTRecipeType ROASTER_RECIPES = registerMachine("roaster", 2, 6, 2, 6)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE);

    public static final GTRecipeType CRYSTALLIZER_RECIPES = registerMachine("crystallizer", 0, 0, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType VACUUM_FILTER_RECIPES = registerMachine("vacuum_filter", 1, 6, 1, 6)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType ISOTOPIC_STABILIZER_RECIPES = registerMachine("isotopic_stabilizer", 1, 1, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.SCIENCE);

    public static final GTRecipeType DECAY_HASTENER_RECIPES = registerMachine("decay_hastener", 1, 1, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.SCIENCE)
            .setEUIO(IO.NONE);

    public static final GTRecipeType DECAY_GENERATOR_RECIPES = registerGenerator("decay_generator", 1, 1, 1, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.SCIENCE);

    public static final GTRecipeType BATCH_REACTOR_RECIPES = registerMachine("batch_reactor", 3, 3, 3, 3)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType GAS_BUBBLE_REACTOR_RECIPES = registerMachine("gas_bubble_reactor", 0, 2, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType DISSOLUTION_REACTOR_RECIPES = registerMachine("dissolution_reactor", 1, 2, 1,2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType MIX_REACTOR_RECIPES = registerMachine("mix_reactor", 0, 2, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType CATALYTIC_REACTOR_RECIPES = registerMachine("catalytic_reactor", 2, 2, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType FURNACE_REACTOR_RECIPES = registerMachine("furnace_reactor", 3, 6, 3, 6)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE);

    // Multiblock

    public static final GTRecipeType FISSION_REACTOR_RECIPES = register("fission_reactor", MULTIBLOCK, 1, 1, 0, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.SCIENCE)
            .setEUIO(IO.NONE);
}
