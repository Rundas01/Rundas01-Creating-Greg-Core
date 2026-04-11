package com.rundas.cgc.common.material.materials.aluminium;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcOreMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.changeComponentsAndFormula;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyOre;

public class CGCAluminiumOreMaterials {

    public static Material Kaolinite, Gibbsite, Diaspore, Bauxite;

    public static void preModify() {
        registerPhysicsPropertyOre(BlueTopaz, -3084.45);
        registerPhysicsPropertyOre(Kyanite, -2594.3);
        registerPhysicsPropertyOre(Mica, -5950.2);
        registerPhysicsPropertyOre(GlauconiteSand, -6150.0);
        registerPhysicsPropertyOre(Lepidolite, -6201.0);
        registerPhysicsPropertyOre(Spodumene, -3015.0);
        registerPhysicsPropertyOre(Sapphire, -1675.7);
        registerPhysicsPropertyOre(GreenSapphire, -1675.7);
        registerPhysicsPropertyOre(Lazurite, -12850.0);
        registerPhysicsPropertyOre(Ruby, -3082.0);
    }

    public static void init() {
        Kaolinite = cgcOreMaterial("kaolinite", null, null, Arrays.asList(new MaterialStack(Aluminium, 4), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 4), new MaterialStack(Oxygen, 14)), -4117.0, "Al4(OH)4Si4O10");
        Gibbsite = cgcOreMaterial("gibbsite", null, null, Arrays.asList(new MaterialStack(Aluminium, 1), new MaterialStack(Hydrogen, 3), new MaterialStack(Oxygen, 3)), -1293.18, "Al(OH)3");
        Diaspore = cgcOreMaterial("diaspore", null, null, Arrays.asList(new MaterialStack(Aluminium, 1), new MaterialStack(Hydrogen, 1), new MaterialStack(Oxygen, 2)), -1002.7);
        Bauxite = cgcOreMaterial("bauxite", null, null, Arrays.asList(new MaterialStack(Gibbsite, 4), new MaterialStack(Diaspore, 4), new MaterialStack(Goethite, 2), new MaterialStack(Hematite, 2), new MaterialStack(Kaolinite, 1), new MaterialStack(Rutile, 1)), null);
    }

    public static void modify() {
        changeComponentsAndFormula(Mica, "KAl2(AlSi3)O10(OH)2", new MaterialStack(Potassium, 1), new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12), new MaterialStack(Hydrogen, 2));
        changeComponentsAndFormula(Lazurite, "Na3Ca(Si3Al3)O12S", new MaterialStack(Sodium, 3), new MaterialStack(Calcium, 1), new MaterialStack(Silicon, 3), new MaterialStack(Aluminium, 3), new MaterialStack(Oxygen, 12), new MaterialStack(Sulfur, 1));
        changeComponentsAndFormula(Ruby, new MaterialStack(Chromium, 1), new MaterialStack(Aluminium, 3), new MaterialStack(Oxygen, 6));
    }
}
