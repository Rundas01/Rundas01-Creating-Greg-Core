package com.rundas.cgc.integration.forsetri.bee;

import com.rundas.cgc.integration.forsetri.bee.item.CGCBeeItems;
import com.rundas.cgc.integration.forsetri.bee.item.CGCHoneyComb;
import forestry.api.plugin.IApicultureRegistration;
import net.minecraft.network.chat.TextColor;

public class CGCBeeDefinitions {
    public static void defineBees(IApicultureRegistration apicultureRegistration) {
        apicultureRegistration
                .registerSpecies(CGCBeeSpecies.HYDROGEN, CGCBeeTaxa.GENUS_GASA_NOBILIA,
                        CGCBeeTaxa.SPECIES_HYDROGEN,
                        true, TextColor.fromRgb(0x6BD1D5))
                .setBody(TextColor.fromRgb(0x223149))
                .addProduct(CGCBeeItems.BEE_COMBS.stack(CGCHoneyComb.HYDROGEN), 0.9f)
                .setAuthority("Rundas");
    }
}
