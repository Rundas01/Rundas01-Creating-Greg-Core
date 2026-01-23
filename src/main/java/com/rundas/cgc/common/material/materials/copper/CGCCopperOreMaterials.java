package com.rundas.cgc.common.material.materials.copper;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import net.minecraft.util.Tuple;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.CGCMaterialCreationUtil.cgcOreMaterial;
import static com.rundas.cgc.util.CGCMaterialCreationUtil.registerOreprocMaterials;

public class CGCCopperOreMaterials {

    public static Material Crookesite;
    public static Material Enargite;
    public static Material Stannite;

    public static void init() {
        Crookesite = cgcOreMaterial("crookesite", 0x3e4a3f, null, Arrays.asList(new Tuple<>(Copper, 7), new Tuple<>(Thallium, 1), new Tuple<>(Selenium, 4)), 4, -405.0, null);
        registerOreprocMaterials(Crookesite, Arrays.asList(new Tuple<>(CopperIINitrateTrihydrateWaterSolution, 7), new Tuple<>(ThalliumIIINitrateTrihydrateWaterSolution, 1), new Tuple<>(SelenousAcid, 1)), Arrays.asList(new Tuple<>(CupricOxide, 14), new Tuple<>(ThalliumIIIOxide, 1), new Tuple<>(SeleniumIVOxide, 8)));
        Enargite = cgcOreMaterial("enargite", 0xc9c7bd, null, Arrays.asList(new Tuple<>(Copper, 3), new Tuple<>(Arsenic, 1), new Tuple<>(Sulfur, 4)), 2, -179.0, null);
        registerOreprocMaterials(Enargite, Arrays.asList(new Tuple<>(CopperIINitrateTrihydrateWaterSolution, 9), new Tuple<>(ArsenicIIINitrateHexahydrateWaterSolution, 6)), Arrays.asList(new Tuple<>(CupricOxide, 6), new Tuple<>(ArsenicTrioxide, 1)));
        Stannite = cgcOreMaterial("stannite", 0x474f3e, null, Arrays.asList(new Tuple<>(Copper, 2), new Tuple<>(Iron, 1), new Tuple<>(Tin, 1), new Tuple<>(Sulfur, 4)), 1, -417.28, null);
        registerOreprocMaterials(Stannite, );
    }
}
