package com.rundas.cgc.integration.forestry.bee;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.unification.material.MaterialRegistryManager;

import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.ItemStack;

import com.rundas.cgc.CreatingGregCore;
import com.rundas.cgc.common.material.BeeProperty;
import com.rundas.cgc.common.material.CGCPropertyKeys;
import forestry.api.plugin.IApicultureRegistration;
import forestry.api.plugin.IBeeSpeciesBuilder;
import org.apache.commons.lang3.tuple.Triple;

import java.util.*;

public class CGCBeeDefinitions {

    public static void defineBees(IApicultureRegistration apicultureRegistration) {
        for (Material material : MaterialRegistryManager.getInstance().getRegisteredMaterials()) {
            if (material.hasProperty(CGCPropertyKeys.BEE)) {
                BeeProperty property = material.getProperty(CGCPropertyKeys.BEE);
                IBeeSpeciesBuilder builder = apicultureRegistration.registerSpecies(
                        CreatingGregCore.id("bee_" + material.getUnlocalizedName().split("\\.")[2]), property.genus(),
                        material.getName().toUpperCase(Locale.ENGLISH), property.isShiny(),
                        TextColor.fromRgb(property.primaryColor()));
                builder.setBody(TextColor.fromRgb(property.secondaryColor()));
                builder.setAuthority("Rundas");
                for (Triple<ResourceLocation, ResourceLocation, Float> mutation : property.mutations()) {
                    builder.addMutations(m -> m.add(mutation.getLeft(), mutation.getMiddle(), mutation.getRight()));
                }
                if (property.products() != null) {
                    for (Tuple<ItemStack, Float> product : property.products()) {
                        builder.addProduct(product.getA(), product.getB());
                    }
                }
                if (property.specialties() != null) {
                    for (Tuple<ItemStack, Float> specialty : property.specialties()) {
                        builder.addSpecialty(specialty.getA(), specialty.getB());
                    }
                }
            }
        }
    }
}
