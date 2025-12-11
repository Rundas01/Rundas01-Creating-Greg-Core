package com.rundas.cgc.integration.forsetri.bee.item;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.rundas.cgc.common.material.CGCMaterialFlags;
import forestry.api.core.IItemSubtype;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Locale;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public enum CGCHoneyComb implements StringRepresentable, IItemSubtype {

    HYDROGEN(Hydrogen),
    HELIUM(Helium),
    LITHIUM(Lithium),
    BERYLLIUM(Beryllium),
    BORON(Boron),
    CARBON(Carbon),
    NITROGEN(Nitrogen),
    OXYGEN(Oxygen),
    FLUORINE(Fluorine),
    NEON(Neon),
    SODIUM(Sodium),
    MAGNESIUM(Magnesium),
    ALUMINIUM(Aluminium),
    SILICON(Silicon),
    PHOSPHORUS(Phosphorus),
    SULFUR(Sulfur),
    CHLORINE(Chlorine),
    ARGON(Argon),
    POTASSIUM(Potassium),
    CALCIUM(Calcium),
    SCANDIUM(Scandium),
    TITANIUM(Titanium),
    VANADIUM(Vanadium),
    CHROMIUM(Chromium),
    MANGANESE(Manganese),
    IRON(Iron),
    COBALT(Cobalt),
    NICKEL(Nickel),
    COPPER(Copper),
    ZINC(Zinc),
    GALLIUM(Gallium),
    GERMANIUM(Germanium),
    ARSENIC(Arsenic),
    SELENIUM(Selenium),
    BROMINE(Bromine),
    KRYPTON(Krypton),
    RUBIDIUM(Rubidium),
    STRONTIUM(Strontium),
    YTTRIUM(Yttrium),
    ZIRCONIUM(Zirconium),
    NIOBIUM(Niobium),
    MOLYBDENUM(Molybdenum),
    TECHNETIUM(Technetium),
    RUTHENIUM(Ruthenium),
    RHODIUM(Rhodium),
    PALLADIUM(Palladium),
    SILVER(Silver),
    CADMIUM(Cadmium),
    INDIUM(Indium),
    TIN(Tin),
    ANTIMONY(Antimony),
    TELLURIUM(Tellurium),
    IODINE(Iodine),
    XENON(Xenon),
    CAESIUM(Caesium),
    BARIUM(Barium),
    LANTHANUM(Lanthanum),
    CERIUM(Cerium),
    PRASEODYMIUM(Praseodymium),
    NEODYMIUM(Neodymium),
    PROMETHIUM(Promethium),
    SAMARIUM(Samarium),
    EUROPIUM(Europium),
    GADOLINIUM(Gadolinium),
    TERBIUM(Terbium),
    DYSPROSIUM(Dysprosium),
    HOLMIUM(Holmium),
    ERBIUM(Erbium),
    THULIUM(Thulium),
    YTTERBIUM(Ytterbium),
    LUTETIUM(Lutetium),
    HAFNIUM(Hafnium),
    TANTALUM(Tantalum),
    TUNGSTEN(Tungsten),
    RHENIUM(Rhenium),
    OSMIUM(Osmium),
    IRIDIUM(Iridium),
    PLATINUM(Platinum),
    GOLD(Gold),
    MERCURY(Mercury),
    THALLIUM(Thallium),
    LEAD(Lead),
    BISMUTH(Bismuth),
    POLONIUM(Polonium),
    ASTATINE(Astatine),
    RADON(Radon),
    FRANCIUM(Francium),
    RADIUM(Radium),
    ACTINIUM(Actinium),
    THORIUM(Thorium),
    PROTACTINIUM(Protactinium),
    URANIUM(Uranium238),
    NEPTUNIUM(Neptunium),
    PLUTONIUM(Plutonium241),
    AMERICIUM(Americium),
    CURIUM(Curium),
    BERKELIUM(Berkelium),
    CALIFORNIUM(Californium),
    EINSTEINIUM(Einsteinium),
    FERMIUM(Fermium),
    MENDELEVIUM(Mendelevium),
    NOBELIUM(Nobelium),
    LAWRENCIUM(Lawrencium),
    RUTHERFORDIUM(Rutherfordium),
    DUBNIUM(Dubnium),
    SEABORGIUM(Seaborgium),
    BOHRIUM(Bohrium),
    HASSIUM(Hassium),
    MEITNERIUM(Meitnerium),
    DARMSTADTIUM(Darmstadtium),
    ROENTGENIUM(Roentgenium),
    COPERNICIUM(Copernicium),
    NIHONIUM(Nihonium),
    FLEROVIUM(Flerovium),
    MOSCOVIUM(Moscovium),
    LIVERMORIUM(Livermorium),
    TENNESSINE(Tennessine),
    OGANESSON(Oganesson);

    public static final CGCHoneyComb[] VALUES = values();

    public final String name;
    public final int primaryColor;
    public final int secondaryColor;
    public final String compatName;
    public final Material material;

    CGCHoneyComb(Material material) {
        this(material, new Color(material.getMaterialRGB()), new Color(material.getMaterialSecondaryRGB()), material.getUnlocalizedName() + "_comb");
    }

    CGCHoneyComb(Color primary, Color secondary) {
        this(null, primary, secondary, null);
    }

    CGCHoneyComb(Material material, Color primary, Color secondary, String compatName) {
        this.material = material;
        if (material != null) {
            material.addFlags(CGCMaterialFlags.HAS_COMB);
        }
        this.name = toString().toLowerCase(Locale.ENGLISH);
        this.primaryColor = primary.getRGB();
        this.secondaryColor = secondary.getRGB();
        this.compatName = compatName;
    }

    @Override
    public @NotNull String getSerializedName() {
        return name;
    }

    public static CGCHoneyComb get(int meta) {
        if (meta >= VALUES.length) {
            meta = 0;
        }
        return VALUES[meta];
    }
}
