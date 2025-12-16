package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.DustProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.rundas.cgc.integration.forestry.bee.CGCBeeSpecies;
import com.rundas.cgc.integration.forestry.bee.item.CGCHoneyComb;
import forestry.api.apiculture.ForestryBeeSpecies;
import net.minecraft.util.Tuple;
import org.apache.commons.lang3.tuple.Triple;

import java.util.List;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.CreatingGregCore.id;
import static com.rundas.cgc.common.material.CGCNuclearMaterials.*;
import static com.rundas.cgc.integration.forestry.bee.CGCBeeTaxa.*;
import static com.rundas.cgc.util.CGCForestryUtil.combStack;
import static com.rundas.cgc.util.CGCForestryUtil.registerBeeProperty;
import static com.rundas.cgc.util.CGCNuclearUtil.registerNuclearProperty;

public class CGCMaterials {

    public static Material FreeProtonGas;
    public static Material FreeElectronGas;
    public static Material FreeNeutronGas;

    public static void init() {
        FreeProtonGas = new Material.Builder(id("free_proton_gas"))
                .gas().formula("p+")
                .color(0xAC1B1B).buildAndRegister();

        FreeElectronGas = new Material.Builder(id("free_electron_gas"))
                .gas().formula("e-")
                .color(0x044C4C).buildAndRegister();

        FreeNeutronGas = new Material.Builder(id("free_neutron_gas"))
                .gas().formula("n")
                .color(0x3C60E8).buildAndRegister();

        CGCNuclearMaterials.init();
    }

    public static void modify() {
        registerMissingProperties();
        //registerBeeProperties();
        //registerNuclearProperties();
    }

    private static void registerMissingProperties() {
        Scandium.setProperty(PropertyKey.DUST, new DustProperty());
        Germanium.setProperty(PropertyKey.DUST, new DustProperty());
        Selenium.setProperty(PropertyKey.DUST, new DustProperty());
        Rubidium.setProperty(PropertyKey.DUST, new DustProperty());
        Strontium.setProperty(PropertyKey.DUST, new DustProperty());
        Zirconium.setProperty(PropertyKey.DUST, new DustProperty());
        Technetium.setProperty(PropertyKey.DUST, new DustProperty());
        Tellurium.setProperty(PropertyKey.DUST, new DustProperty());
        Praseodymium.setProperty(PropertyKey.DUST, new DustProperty());
        Promethium.setProperty(PropertyKey.DUST, new DustProperty());
        Gadolinium.setProperty(PropertyKey.DUST, new DustProperty());
        Terbium.setProperty(PropertyKey.DUST, new DustProperty());
        Dysprosium.setProperty(PropertyKey.DUST, new DustProperty());
        Holmium.setProperty(PropertyKey.DUST, new DustProperty());
        Erbium.setProperty(PropertyKey.DUST, new DustProperty());
        Thulium.setProperty(PropertyKey.DUST, new DustProperty());
        Ytterbium.setProperty(PropertyKey.DUST, new DustProperty());
        Hafnium.setProperty(PropertyKey.DUST, new DustProperty());
        Rhenium.setProperty(PropertyKey.DUST, new DustProperty());
        Thallium.setProperty(PropertyKey.DUST, new DustProperty());
        Polonium.setProperty(PropertyKey.DUST, new DustProperty());
        Astatine.setProperty(PropertyKey.DUST, new DustProperty());
        Francium.setProperty(PropertyKey.DUST, new DustProperty());
        Radium.setProperty(PropertyKey.DUST, new DustProperty());
        Actinium.setProperty(PropertyKey.DUST, new DustProperty());
        Protactinium.setProperty(PropertyKey.DUST, new DustProperty());
        Neptunium.setProperty(PropertyKey.DUST, new DustProperty());
        Curium.setProperty(PropertyKey.DUST, new DustProperty());
        Berkelium.setProperty(PropertyKey.DUST, new DustProperty());
        Californium.setProperty(PropertyKey.DUST, new DustProperty());
        Einsteinium.setProperty(PropertyKey.DUST, new DustProperty());
        Fermium.setProperty(PropertyKey.DUST, new DustProperty());
        Mendelevium.setProperty(PropertyKey.DUST, new DustProperty());
        Nobelium.setProperty(PropertyKey.DUST, new DustProperty());
        Lawrencium.setProperty(PropertyKey.DUST, new DustProperty());
        Rutherfordium.setProperty(PropertyKey.DUST, new DustProperty());
        Dubnium.setProperty(PropertyKey.DUST, new DustProperty());
        Seaborgium.setProperty(PropertyKey.DUST, new DustProperty());
        Bohrium.setProperty(PropertyKey.DUST, new DustProperty());
        Hassium.setProperty(PropertyKey.DUST, new DustProperty());
        Meitnerium.setProperty(PropertyKey.DUST, new DustProperty());
        Roentgenium.setProperty(PropertyKey.DUST, new DustProperty());
        Copernicium.setProperty(PropertyKey.DUST, new DustProperty());
        Nihonium.setProperty(PropertyKey.DUST, new DustProperty());
        Flerovium.setProperty(PropertyKey.DUST, new DustProperty());
        Moscovium.setProperty(PropertyKey.DUST, new DustProperty());
        Livermorium.setProperty(PropertyKey.DUST, new DustProperty());
        Tennessine.setProperty(PropertyKey.DUST, new DustProperty());
        Oganesson.setProperty(PropertyKey.DUST, new DustProperty());
    }

    private static void registerNuclearProperties() {
        registerNuclearProperty(Thallium208, Thallium, 0, 0, 5.001, false);
        registerNuclearProperty(Lead208, Lead, 0, 0, 0, false);
        registerNuclearProperty(Lead212, Lead, 0, 0, 0.574, false);
        registerNuclearProperty(Bismuth212, Bismuth, 6.027, 0, 2.254, false);
        registerNuclearProperty(Polonium212, Polonium, 8.78, 0, 0, false);
        registerNuclearProperty(Polonium216, Polonium, 6.78, 0, 0, false);
        registerNuclearProperty(Radon220, Radon, 6.405, 0, 0, false);
        registerNuclearProperty(Radium224, Radium, 5.789, 0, 0, false);
        registerNuclearProperty(Thorium228, Thorium, 5.52, 0, 0, false);
        registerNuclearProperty(Protactinium233, Protactinium, 0, 0, 0.571, false);
        registerNuclearProperty(Uranium232, Uranium235, 5.414, 0, 0, false);
        registerNuclearProperty(Uranium235, Uranium235, 4.679, 0, 0, false);
        registerNuclearProperty(Uranium237, Uranium235, 0, 0, 0.519, false);
        registerNuclearProperty(Uranium238, Uranium235, 4.27, 0, 0, true);
        //Np237
        registerNuclearProperty(Neptunium, Neptunium, 4.959, 0, 0, false);
        registerNuclearProperty(Plutonium239, Plutonium239, 5.245, 0, 0, false);
        registerNuclearProperty(Plutonium241, Plutonium239, 5.14, 0, 0.021, true);
        //Am245
        registerNuclearProperty(Americium241, Americium, 5.486, 0, 0, true);
    }

    private static void registerBeeProperties() {
        registerBeeProperty(Hydrogen, GENUS_METALLA_NON, true, List.of(Triple.of(ForestryBeeSpecies.INDUSTRIOUS, ForestryBeeSpecies.IMPERIAL, 0.05F)), List.of(new Tuple<>(combStack(CGCHoneyComb.HYDROGEN), 0.05F)), null);
        registerBeeProperty(Helium, GENUS_GASA_NOBILIA, false, List.of(Triple.of(CGCBeeSpecies.HYDROGEN, ForestryBeeSpecies.INDUSTRIOUS, 0.05F), Triple.of(CGCBeeSpecies.HYDROGEN, ForestryBeeSpecies.IMPERIAL, 0.05F)), List.of(new Tuple<>(combStack(CGCHoneyComb.HELIUM), 0.05F)), null);
        registerBeeProperty(Lithium, GENUS_METALLIS_ALKALINE, false, List.of(new Tuple<>(combStack(CGCHoneyComb.LITHIUM), 0.05F)));
        registerBeeProperty(Beryllium, GENUS_METALLIS_ALKALINE_TERRAE, false, List.of(new Tuple<>(combStack(CGCHoneyComb.BERYLLIUM), 0.05F)));
        registerBeeProperty(Boron, GENUS_METALLA_SEMI, false, List.of(new Tuple<>(combStack(CGCHoneyComb.BORON), 0.05F)));
        registerBeeProperty(Carbon, GENUS_METALLA_NON, false, List.of(new Tuple<>(combStack(CGCHoneyComb.CARBON), 0.05F)));
        registerBeeProperty(Nitrogen, GENUS_METALLA_NON, false, List.of(new Tuple<>(combStack(CGCHoneyComb.NITROGEN), 0.05F)));
        registerBeeProperty(Oxygen, GENUS_METALLA_NON, false, List.of(new Tuple<>(combStack(CGCHoneyComb.OXYGEN), 0.05F)));
        registerBeeProperty(Fluorine, GENUS_HALOGENS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.FLUORINE), 0.05F)));
        registerBeeProperty(Neon, GENUS_GASA_NOBILIA, true, List.of(new Tuple<>(combStack(CGCHoneyComb.NEON), 0.05F)));
        registerBeeProperty(Sodium, GENUS_METALLIS_ALKALINE, false, List.of(new Tuple<>(combStack(CGCHoneyComb.SODIUM), 0.05F)));
        registerBeeProperty(Magnesium, GENUS_METALLIS_ALKALINE_TERRAE, false, List.of(new Tuple<>(combStack(CGCHoneyComb.MAGNESIUM), 0.05F)));
        registerBeeProperty(Aluminium, GENUS_METALLIS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.ALUMINIUM), 0.05F)));
        registerBeeProperty(Silicon, GENUS_METALLA_SEMI, false, List.of(new Tuple<>(combStack(CGCHoneyComb.SILICON), 0.05F)));
        registerBeeProperty(Phosphorus, GENUS_METALLA_NON, false, List.of(new Tuple<>(combStack(CGCHoneyComb.PHOSPHORUS), 0.05F)));
        registerBeeProperty(Sulfur, GENUS_METALLA_NON, false, List.of(new Tuple<>(combStack(CGCHoneyComb.SULFUR), 0.05F)));
        registerBeeProperty(Chlorine, GENUS_HALOGENS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.CHLORINE), 0.05F)));
        registerBeeProperty(Argon, GENUS_GASA_NOBILIA, true, List.of(new Tuple<>(combStack(CGCHoneyComb.ARGON), 0.05F)));
        registerBeeProperty(Potassium, GENUS_METALLIS_ALKALINE, false, List.of(new Tuple<>(combStack(CGCHoneyComb.POTASSIUM), 0.05F)));
        registerBeeProperty(Calcium, GENUS_METALLIS_ALKALINE_TERRAE, false, List.of(new Tuple<>(combStack(CGCHoneyComb.CALCIUM), 0.05F)));
        registerBeeProperty(Scandium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.SCANDIUM), 0.05F)));
        registerBeeProperty(Titanium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.TITANIUM), 0.05F)));
        registerBeeProperty(Vanadium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.VANADIUM), 0.05F)));
        registerBeeProperty(Chromium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.CHROMIUM), 0.05F)));
        registerBeeProperty(Manganese, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.MANGANESE), 0.05F)));
        registerBeeProperty(Iron, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.IRON), 0.05F)));
        registerBeeProperty(Cobalt, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.COBALT), 0.05F)));
        registerBeeProperty(Nickel, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.NICKEL), 0.05F)));
        registerBeeProperty(Copper, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.COPPER), 0.05F)));
        registerBeeProperty(Zinc, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.ZINC), 0.05F)));
        registerBeeProperty(Gallium, GENUS_METALLIS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.GALLIUM), 0.05F)));
        registerBeeProperty(Germanium, GENUS_METALLA_SEMI, false, List.of(new Tuple<>(combStack(CGCHoneyComb.GERMANIUM), 0.05F)));
        registerBeeProperty(Arsenic, GENUS_METALLA_SEMI, false, List.of(new Tuple<>(combStack(CGCHoneyComb.ARSENIC), 0.05F)));
        registerBeeProperty(Selenium, GENUS_METALLA_SEMI, false, List.of(new Tuple<>(combStack(CGCHoneyComb.SELENIUM), 0.05F)));
        registerBeeProperty(Bromine, GENUS_HALOGENS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.BROMINE), 0.05F)));
        registerBeeProperty(Krypton, GENUS_GASA_NOBILIA, true, List.of(new Tuple<>(combStack(CGCHoneyComb.KRYPTON), 0.05F)));
        registerBeeProperty(Rubidium, GENUS_METALLIS_ALKALINE, false, List.of(new Tuple<>(combStack(CGCHoneyComb.RUBIDIUM), 0.05F)));
        registerBeeProperty(Strontium, GENUS_METALLIS_ALKALINE_TERRAE, false, List.of(new Tuple<>(combStack(CGCHoneyComb.STRONTIUM), 0.05F)));
        registerBeeProperty(Yttrium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.YTTRIUM), 0.05F)));
        registerBeeProperty(Zirconium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.ZIRCONIUM), 0.05F)));
        registerBeeProperty(Niobium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.NIOBIUM), 0.05F)));
        registerBeeProperty(Molybdenum, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.MOLYBDENUM), 0.05F)));
        registerBeeProperty(Technetium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.TECHNETIUM), 0.05F)));
        registerBeeProperty(Ruthenium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.RUTHENIUM), 0.05F)));
        registerBeeProperty(Rhodium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.RHODIUM), 0.05F)));
        registerBeeProperty(Palladium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.PALLADIUM), 0.05F)));
        registerBeeProperty(Silver, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.SILVER), 0.05F)));
        registerBeeProperty(Cadmium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.CADMIUM), 0.05F)));
        registerBeeProperty(Indium, GENUS_METALLIS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.INDIUM), 0.05F)));
        registerBeeProperty(Tin, GENUS_METALLIS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.TIN), 0.05F)));
        registerBeeProperty(Antimony, GENUS_METALLA_SEMI, false, List.of(new Tuple<>(combStack(CGCHoneyComb.ANTIMONY), 0.05F)));
        registerBeeProperty(Tellurium, GENUS_METALLA_SEMI, false, List.of(new Tuple<>(combStack(CGCHoneyComb.TELLURIUM), 0.05F)));
        registerBeeProperty(Iodine, GENUS_HALOGENS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.IODINE), 0.05F)));
        registerBeeProperty(Xenon, GENUS_GASA_NOBILIA, true, List.of(new Tuple<>(combStack(CGCHoneyComb.XENON), 0.05F)));
        registerBeeProperty(Caesium, GENUS_METALLIS_ALKALINE, false, List.of(new Tuple<>(combStack(CGCHoneyComb.CAESIUM), 0.05F)));
        registerBeeProperty(Barium, GENUS_METALLIS_ALKALINE_TERRAE, false, List.of(new Tuple<>(combStack(CGCHoneyComb.BARIUM), 0.05F)));
        registerBeeProperty(Lanthanum, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.LANTHANUM), 0.05F)));
        registerBeeProperty(Cerium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.CERIUM), 0.05F)));
        registerBeeProperty(Praseodymium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.PRASEODYMIUM), 0.05F)));
        registerBeeProperty(Neodymium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.NEODYMIUM), 0.05F)));
        registerBeeProperty(Promethium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.PROMETHIUM), 0.05F)));
        registerBeeProperty(Samarium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.SAMARIUM), 0.05F)));
        registerBeeProperty(Europium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.EUROPIUM), 0.05F)));
        registerBeeProperty(Gadolinium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.GADOLINIUM), 0.05F)));
        registerBeeProperty(Terbium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.TERBIUM), 0.05F)));
        registerBeeProperty(Dysprosium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.DYSPROSIUM), 0.05F)));
        registerBeeProperty(Holmium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.HOLMIUM), 0.05F)));
        registerBeeProperty(Erbium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.ERBIUM), 0.05F)));
        registerBeeProperty(Thulium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.THULIUM), 0.05F)));
        registerBeeProperty(Ytterbium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.YTTERBIUM), 0.05F)));
        registerBeeProperty(Lutetium, GENUS_LANTHANOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.LUTETIUM), 0.05F)));
        registerBeeProperty(Hafnium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.HAFNIUM), 0.05F)));
        registerBeeProperty(Tantalum, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.TANTALUM), 0.05F)));
        registerBeeProperty(Tungsten, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.TUNGSTEN), 0.05F)));
        registerBeeProperty(Rhenium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.RHENIUM), 0.05F)));
        registerBeeProperty(Osmium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.OSMIUM), 0.05F)));
        registerBeeProperty(Iridium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.IRIDIUM), 0.05F)));
        registerBeeProperty(Platinum, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.PLATINUM), 0.05F)));
        registerBeeProperty(Gold, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.GOLD), 0.05F)));
        registerBeeProperty(Mercury, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.MERCURY), 0.05F)));
        registerBeeProperty(Thallium, GENUS_METALLIS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.THALLIUM), 0.05F)));
        registerBeeProperty(Lead, GENUS_METALLIS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.LEAD), 0.05F)));
        registerBeeProperty(Bismuth, GENUS_METALLIS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.BISMUTH), 0.05F)));
        registerBeeProperty(Polonium, GENUS_METALLA_SEMI, false, List.of(new Tuple<>(combStack(CGCHoneyComb.POLONIUM), 0.05F)));
        registerBeeProperty(Astatine, GENUS_HALOGENS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.ASTATINE), 0.05F)));
        registerBeeProperty(Radon, GENUS_GASA_NOBILIA, true, List.of(new Tuple<>(combStack(CGCHoneyComb.RADON), 0.05F)));
        registerBeeProperty(Francium, GENUS_METALLIS_ALKALINE, false, List.of(new Tuple<>(combStack(CGCHoneyComb.FRANCIUM), 0.05F)));
        registerBeeProperty(Radium, GENUS_METALLIS_ALKALINE_TERRAE, false, List.of(new Tuple<>(combStack(CGCHoneyComb.RADIUM), 0.05F)));
        registerBeeProperty(Actinium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.ACTINIUM), 0.05F)));
        registerBeeProperty(Thorium, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.THORIUM), 0.05F)));
        registerBeeProperty(Protactinium, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.PROTACTINIUM), 0.05F)));
        registerBeeProperty(Uranium238, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.URANIUM), 0.05F)));
        registerBeeProperty(Neptunium, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.NEPTUNIUM), 0.05F)));
        registerBeeProperty(Plutonium239, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.PLUTONIUM), 0.05F)));
        registerBeeProperty(Americium, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.AMERICIUM), 0.05F)));
        registerBeeProperty(Curium, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.CURIUM), 0.05F)));
        registerBeeProperty(Berkelium, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.BERKELIUM), 0.05F)));
        registerBeeProperty(Californium, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.CALIFORNIUM), 0.05F)));
        registerBeeProperty(Einsteinium, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.EINSTEINIUM), 0.05F)));
        registerBeeProperty(Fermium, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.FERMIUM), 0.05F)));
        registerBeeProperty(Mendelevium, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.MENDELEVIUM), 0.05F)));
        registerBeeProperty(Nobelium, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.NOBELIUM), 0.05F)));
        registerBeeProperty(Lawrencium, GENUS_ACTINOIDA, false, List.of(new Tuple<>(combStack(CGCHoneyComb.LAWRENCIUM), 0.05F)));
        registerBeeProperty(Rutherfordium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.RUTHERFORDIUM), 0.05F)));
        registerBeeProperty(Dubnium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.DUBNIUM), 0.05F)));
        registerBeeProperty(Seaborgium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.SEABORGIUM), 0.05F)));
        registerBeeProperty(Bohrium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.BOHRIUM), 0.05F)));
        registerBeeProperty(Hassium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.HASSIUM), 0.05F)));
        registerBeeProperty(Meitnerium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.MEITNERIUM), 0.05F)));
        registerBeeProperty(Darmstadtium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.DARMSTADTIUM), 0.05F)));
        registerBeeProperty(Roentgenium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.ROENTGENIUM), 0.05F)));
        registerBeeProperty(Copernicium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.COPERNICIUM), 0.05F)));
        registerBeeProperty(Nihonium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.NIHONIUM), 0.05F)));
        registerBeeProperty(Flerovium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.FLEROVIUM), 0.05F)));
        registerBeeProperty(Moscovium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.MOSCOVIUM), 0.05F)));
        registerBeeProperty(Livermorium, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.LIVERMORIUM), 0.05F)));
        registerBeeProperty(Tennessine, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.TENNESSINE), 0.05F)));
        registerBeeProperty(Oganesson, GENUS_METALLORUM_TRANSITUS, false, List.of(new Tuple<>(combStack(CGCHoneyComb.OGANESSON), 0.05F)));
    }
}
