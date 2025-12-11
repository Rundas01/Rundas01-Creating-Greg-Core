package com.rundas.cgc.integration.forsetri;

import com.rundas.cgc.CreatingGregCore;
import com.rundas.cgc.integration.forsetri.bee.CGCBeeDefinitions;
import com.rundas.cgc.integration.forsetri.bee.CGCBeeTaxonomy;
import com.rundas.cgc.integration.forsetri.bee.item.CGCBeeItems;
import com.rundas.cgc.integration.forsetri.bee.item.CGCHoneyComb;
import forestry.api.client.plugin.IClientRegistration;
import forestry.api.plugin.IApicultureRegistration;
import forestry.api.plugin.IForestryPlugin;
import forestry.api.plugin.IGeneticRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CGCForestryPlugin implements IForestryPlugin {

    @Override
    public @NotNull ResourceLocation id() {
        return CreatingGregCore.id("core/cosmicore");
    }

    @Override
    public void registerApiculture(IApicultureRegistration apiculture) {
        CGCBeeDefinitions.defineBees(apiculture);
    }

    @Override
    public void registerGenetics(IGeneticRegistration genetics) {
        CGCBeeTaxonomy.defineTaxa(genetics);
    }

    @Override
    public void registerClient(Consumer<Consumer<IClientRegistration>> registrar) {
        //registrar.accept(new CosmicCoreClient.CosmicBeesClientRegistration());
    }

    private static Supplier<List<ItemStack>> getHoneyComb(CGCHoneyComb type) {
        return () -> List.of(CGCBeeItems.BEE_COMBS.stack(type));
    }
}
