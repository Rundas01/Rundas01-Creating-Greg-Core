package com.rundas.cgc.common.data;

import com.gregtechceu.gtceu.data.lang.LangHandler;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class CGCLangHandler extends LangHandler {

    public static void init(RegistrateLangProvider provider) {
        processRecipeLang(provider);
        processRecipeTypeLang(provider);
        processMachineTooltipLang(provider);
        processMaterialTooltipLang(provider);
        // replace(provider, key, value), multiLang(provider, key, ...values)
    }

    private static void processRecipeLang(RegistrateLangProvider provider) {
        provider.add("cgc.recipe.energy", "Enthalpy Change: %d J");
    }

    private static void processMachineTooltipLang(RegistrateLangProvider provider) {
        provider.add("cgc.machine.multiblock.fission_reactor.tooltip",
                "Requires a Neutron Emitter, at least 1 Fission Chamber and at least 1 Coolant Chamber in its interior to function.");
    }

    private static void processMaterialTooltipLang(RegistrateLangProvider provider) {
        provider.add("cgc.tooltip.physics_property.formation_enthalpy",
                "Formation Enthalpy: %d EU/mol");
    }

    private static void processRecipeTypeLang(RegistrateLangProvider provider) {
        provider.add("cgc.roaster", "Roasting");
        provider.add("cgc.vacuum_filter", "Vacuum Filtration");
    }
}
