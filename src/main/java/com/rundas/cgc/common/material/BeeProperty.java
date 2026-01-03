package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.ItemStack;

import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

public record BeeProperty(String genus, int primaryColor, int secondaryColor,
                          List<Triple<ResourceLocation, ResourceLocation, Float>> mutations, boolean isShiny,
                          List<Tuple<ItemStack, Float>> products, List<Tuple<ItemStack, Float>> specialties)
        implements IMaterialProperty {

    @Override
    public void verifyProperty(MaterialProperties properties) {}
}
