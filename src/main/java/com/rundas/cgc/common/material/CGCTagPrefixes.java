package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import com.rundas.cgc.client.CGCMaterialIconTypes;

import java.util.function.Predicate;

public class CGCTagPrefixes {

    public static TagPrefix nuclearFuel;
    public static TagPrefix depletedNuclearFuel;
    public static TagPrefix catalystBed;

    public static final Predicate<Material> isValidFuel = m -> m.hasProperty(CGCPropertyKeys.NUCLEAR) &&
            m.getProperty(CGCPropertyKeys.NUCLEAR).isFuel();
    public static final Predicate<Material> isCatalyst = m -> m.hasFlag(CGCMaterialFlags.IS_CATALYST);

    public static void init() {
        nuclearFuel = new TagPrefix("nuclearFuel")
                .idPattern("%s_nuclear_fuel")
                .defaultTagPath("nuclear_fuels/%s")
                .defaultTagPath("nuclear_fuels")
                .materialIconType(CGCMaterialIconTypes.nuclearFuel)
                .unificationEnabled(true)
                .generateItem(true)
                .generationCondition(isValidFuel);

        depletedNuclearFuel = new TagPrefix("depletedNuclearFuel")
                .idPattern("depleted_%s_nuclear_fuel")
                .defaultTagPath("depleted_nuclear_fuels/%s")
                .defaultTagPath("depleted_nuclear_fuels")
                .materialIconType(CGCMaterialIconTypes.nuclearFuel)
                .unificationEnabled(true)
                .generateItem(true)
                .generationCondition(isValidFuel);

        catalystBed = new TagPrefix("catalystBed")
                .idPattern("%s_catalyst_bed")
                .defaultTagPath("catalyst_beds/%s")
                .defaultTagPath("catalyst_beds")
                .materialIconType(CGCMaterialIconTypes.catalystBed)
                .unificationEnabled(true)
                .generateItem(true)
                .generationCondition(isCatalyst);
    }
}
