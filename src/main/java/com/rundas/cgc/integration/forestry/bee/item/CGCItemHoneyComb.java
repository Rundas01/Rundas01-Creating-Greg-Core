package com.rundas.cgc.integration.forestry.bee.item;

import net.minecraft.world.item.ItemStack;

import forestry.core.items.ItemForestry;
import forestry.core.items.definitions.IColoredItem;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class CGCItemHoneyComb extends ItemForestry implements IColoredItem {

    private final CGCHoneyComb type;

    public CGCItemHoneyComb(CGCHoneyComb type) {
        this.type = type;
    }

    @Override
    public int getColorFromItemStack(@NotNull ItemStack itemstack, int tintIndex) {
        CGCHoneyComb honeyComb = this.type;

        if (tintIndex == 1) {
            return honeyComb.primaryColor;
        } else {
            return honeyComb.secondaryColor;
        }
    }
}
