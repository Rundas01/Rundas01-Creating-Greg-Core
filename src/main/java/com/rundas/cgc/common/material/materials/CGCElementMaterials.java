package com.rundas.cgc.common.material.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.*;

public class CGCElementMaterials {
    public static void preModify() {
        registerDustProperties(
                Arrays.asList(
                        Scandium, Germanium, Rubidium, Strontium, Zirconium, Technetium, Tellurium,
                        Praseodymium, Promethium, Gadolinium, Terbium, Dysprosium, Holmium, Erbium, Thulium, Ytterbium,
                        Hafnium, Rhenium, Polonium,
                        Astatine, Francium, Radium, Actinium, Protactinium, Neptunium, Curium, Berkelium, Californium,
                        Einsteinium, Fermium, Mendelevium,
                        Nobelium, Lawrencium, Rutherfordium, Dubnium, Seaborgium, Bohrium, Hassium, Meitnerium,
                        Roentgenium, Copernicium, Nihonium,
                        Flerovium, Moscovium, Livermorium, Tennessine, Oganesson
                )
        );
        registerPhysicsPropertyElement(Aluminium, 2, true);
        registerPhysicsPropertyElement(Antimony, 3, true);
        registerPhysicsPropertyElement(Argon, 5, 1000, false);
        registerPhysicsPropertyElement(Arsenic, 2, true);
        registerPhysicsPropertyElement(Barium, 3, true);
        registerPhysicsPropertyElement(Beryllium, 3, true);
        registerPhysicsPropertyElement(Bismuth, 3, true);
        registerPhysicsPropertyElement(Boron, 3, true);
        registerPhysicsPropertyElement(Bromine, 3, 1000, false);
        registerPhysicsPropertyElement(Caesium, 4, true);
        registerPhysicsPropertyElement(Calcium, 2, true);
        registerPhysicsPropertyElement(Carbon, 1, false);
        registerPhysicsPropertyElement(Cadmium, 3, true);
        registerPhysicsPropertyElement(Cerium, 4, true);
        registerPhysicsPropertyElement(Chlorine, 1, 1000, false);
        registerPhysicsPropertyElement(Chromium, 2, true);
        registerPhysicsPropertyElement(Cobalt, 3, true);
        registerPhysicsPropertyElement(Copper, 1, true, 24.47, 1358);
        registerPhysicsPropertyElement(Fluorine, 1, 1000, false);
        registerPhysicsPropertyElement(Gallium, 1, true);
        registerPhysicsPropertyElement(Gold, 3, true);
        registerPhysicsPropertyElement(Hydrogen, 1, false);
        registerPhysicsPropertyElement(Helium, 3, 1000, false);
        registerPhysicsPropertyElement(Indium, 4, true);
        registerPhysicsPropertyElement(Iron, 1, true);
        registerPhysicsPropertyElement(Lead, 2, true);
        registerPhysicsPropertyElement(Magnesium, 3, true);
        registerPhysicsPropertyElement(Manganese, 3, true);
        registerPhysicsPropertyElement(Niobium, 4, true);
        registerPhysicsPropertyElement(Oxygen, 1, false);
        registerPhysicsPropertyElement(Potassium, 2, true);
        registerPhysicsPropertyElement(Rhodium, 5, true);
        registerPhysicsPropertyElement(Scandium, 4, true);
        registerPhysicsPropertyElement(Sulfur, 1, 144, false);
        registerPhysicsPropertyElement(Silicon, 2, true);
        registerPhysicsPropertyElement(Silver, 3, true);
        registerPhysicsPropertyElement(Thorium, 5, true);
        registerPhysicsPropertyElement(Yttrium, 4, true);
    }

    public static void modify() {
        changeComponentsAndFormula(Bromine, new MaterialStack(Bromine, 2));
        changeComponentsAndFormula(Chlorine, new MaterialStack(Chlorine, 2));
        changeComponentsAndFormula(Fluorine, new MaterialStack(Fluorine, 2));
        changeComponentsAndFormula(Hydrogen, new MaterialStack(Hydrogen, 2));
        changeComponentsAndFormula(Oxygen, new MaterialStack(Oxygen, 2));
    }
}
