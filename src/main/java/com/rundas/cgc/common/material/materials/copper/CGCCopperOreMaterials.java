package com.rundas.cgc.common.material.materials.copper;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.common.material.materials.selenium.CGCSeleniumMaterials.SeleniumIVOxide;
import static com.rundas.cgc.common.material.materials.thallium.CGCThalliumMaterials.ThalliumIIIOxide;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.*;

public class CGCCopperOreMaterials {

    public static Material Crookesite;
    public static Material Enargite;
    public static Material Stannite;

    public static void preModify() {
        registerPhysicsPropertyOre(Bornite, -380.3, Copper, 242.9, 1173);
        registerPhysicsPropertyOre(Chalcocite, -53.0, Copper, 60.0, 1378);
        registerPhysicsPropertyOre(Chalcopyrite, -184.0, Copper, 95.67, 1223);
        registerPhysicsPropertyOre(Tetrahedrite, -1200.0, Copper, 455.0, 933);
        registerPhysicsPropertyOre(Malachite, -1054.0, Copper, 154.3, 434);
    }

    public static void init() {
        registerRoastedDusts(Chalcopyrite, Arrays.asList(new MaterialStack(CupricOxide, 4), new MaterialStack(Hematite, 2)), null);
        registerRoastedDusts(Tetrahedrite, Arrays.asList(new MaterialStack(CupricOxide, 12), new MaterialStack(AntimonyTrioxide, 2)), null);
        registerRoastedDusts(Bornite, Arrays.asList(new MaterialStack(CupricOxide, 10), new MaterialStack(Hematite, 1)), null);
        Crookesite = cgcOreMaterial("crookesite", 0x3e4a3f, null, Arrays.asList(new MaterialStack(Copper, 7), new MaterialStack(Thallium, 1), new MaterialStack(Selenium, 4)), -405.0, Copper, 0.2, 767);
        registerRoastedDusts(Crookesite, Arrays.asList(new MaterialStack(CupricOxide, 28), new MaterialStack(ThalliumIIIOxide, 2), new MaterialStack(SeleniumIVOxide, 16)), Selenium);
        Enargite = cgcOreMaterial("enargite", 0xc9c7bd, null, Arrays.asList(new MaterialStack(Copper, 3), new MaterialStack(Arsenic, 1), new MaterialStack(Sulfur, 4)), -179.0, Copper, 190.4, 952);
        registerRoastedDusts(Enargite, Arrays.asList(new MaterialStack(CupricOxide, 12), new MaterialStack(ArsenicTrioxide, 2)), null);
        Stannite = cgcOreMaterial("stannite", 0x474f3e, null, Arrays.asList(new MaterialStack(Copper, 2), new MaterialStack(Iron, 1), new MaterialStack(Tin, 1), new MaterialStack(Sulfur, 4)), -417.28, Copper, 157.0, 1118);
        registerRoastedDusts(Stannite, Arrays.asList(new MaterialStack(CupricOxide, 8), new MaterialStack(Cassiterite, 4), new MaterialStack(Hematite, 2)), Iron);
    }

    public static void modify() {
        changeComponentsAndFormula(Tetrahedrite, new MaterialStack(Copper, 12), new MaterialStack(Antimony, 4), new MaterialStack(Sulfur, 13));
        Malachite.setFormula("Cu2CO3(OH)2", true);
    }
}
