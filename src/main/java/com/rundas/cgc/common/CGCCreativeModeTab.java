package com.rundas.cgc.common;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.rundas.cgc.CreatingGregCore;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class CGCCreativeModeTab {
    public static RegistryEntry<CreativeModeTab> MACHINES = REGISTRATE.defaultCreativeTab("machines",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("machines", REGISTRATE))
                            .icon(() -> GTMachines.ELECTRIC_FURNACE[0].asStack())
                            .title(REGISTRATE.addLang("itemGroup", CreatingGregCore.id("machines"), "Creating Greg Core Machines"))
                            .build())
            .register();
}