package com.rundas.cgc.common.tag;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import com.tterrag.registrate.providers.RegistrateTagsProvider;

public class CGCTagsHandler {

    public static void initItem(RegistrateTagsProvider<Item> provider) {
        CGCItemTagsLoader.init(provider);
    }

    public static void initBlock(RegistrateTagsProvider<Block> provider) {}

    public static void initFluid(RegistrateTagsProvider<Fluid> provider) {}
}
