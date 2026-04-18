package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import com.rundas.cgc.client.CGCMaterialIconTypes;

import java.util.function.Predicate;

public class CGCTagPrefixes {

    public static TagPrefix nuclearFuel, depletedNuclearFuel;
    public static TagPrefix poorRawOre, richRawOre;
    public static TagPrefix catalystBed;

    public static final Predicate<Material> isValidFuel = m -> m.hasProperty(CGCPropertyKeys.NUCLEAR) &&
            m.getProperty(CGCPropertyKeys.NUCLEAR).isFuel();
    public static final Predicate<Material> isCatalyst = anyFlagPredicate(CGCMaterialFlags.IS_CATALYST);
    public static final Predicate<Material> isOre = propertyPredicate(PropertyKey.ORE);

    private static Predicate<Material> anyFlagPredicate(MaterialFlag... flags) {
        return m -> m.hasAnyOfFlags(flags);
    }

    private static Predicate<Material> allFlagPredicate(MaterialFlag... flags) {
        return m -> m.hasFlags(flags);
    }

    private static Predicate<Material> propertyPredicate(PropertyKey<?> property) {
        return m -> m.hasProperty(property);
    }

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

        poorRawOre = new TagPrefix("poorRaw")
                .idPattern("poor_raw_%s")
                .defaultTagPath("poor_raw_ores/%s")
                .defaultTagPath("poor_raw_ores")
                .materialIconType(CGCMaterialIconTypes.poorRawOre)
                .unificationEnabled(true)
                .generateItem(true)
                .generationCondition(isOre);

        richRawOre = new TagPrefix("richRaw")
                .idPattern("rich_raw_%s")
                .defaultTagPath("rich_raw_ores/%s")
                .defaultTagPath("rich_raw_ores")
                .materialIconType(CGCMaterialIconTypes.richRawOre)
                .unificationEnabled(true)
                .generateItem(true)
                .generationCondition(isOre);
    }
}
