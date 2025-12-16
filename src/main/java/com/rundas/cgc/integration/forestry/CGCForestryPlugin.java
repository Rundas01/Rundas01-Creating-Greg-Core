package com.rundas.cgc.integration.forestry;

import net.minecraft.resources.ResourceLocation;

import com.rundas.cgc.CreatingGregCore;
import com.rundas.cgc.integration.forestry.bee.CGCBeeDefinitions;
import com.rundas.cgc.integration.forestry.bee.CGCBeeTaxonomy;
import forestry.api.client.plugin.IClientRegistration;
import forestry.api.plugin.IApicultureRegistration;
import forestry.api.plugin.IForestryPlugin;
import forestry.api.plugin.IGeneticRegistration;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CGCForestryPlugin implements IForestryPlugin {

    @Override
    public @NotNull ResourceLocation id() {
        return CreatingGregCore.id("core/cgc");
    }

    @Override
    public void registerApiculture(@NotNull IApicultureRegistration apiculture) {
        CGCBeeDefinitions.defineBees(apiculture);
    }

    @Override
    public void registerGenetics(@NotNull IGeneticRegistration genetics) {
        CGCBeeTaxonomy.defineTaxa(genetics);
    }

    @Override
    public void registerClient(@NotNull Consumer<Consumer<IClientRegistration>> registrar) {}
}
