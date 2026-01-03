package com.rundas.cgc.integration.forestry.bee.item;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.util.StringRepresentable;

import com.rundas.cgc.common.material.CGCMaterialFlags;
import forestry.api.core.IItemSubtype;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public enum CGCHoneyComb implements StringRepresentable, IItemSubtype {

    HYDROGEN("hydrogen"),
    HELIUM("helium"),
    LITHIUM("lithium"),
    BERYLLIUM("beryllium"),
    BORON("boron"),
    CARBON("carbon"),
    NITROGEN("nitrogen"),
    OXYGEN("oxygen"),
    FLUORINE("fluorine"),
    NEON("neon"),
    SODIUM("sodium"),
    MAGNESIUM("magnesium"),
    ALUMINIUM("aluminium"),
    SILICON("silicon"),
    PHOSPHORUS("phosphorus"),
    SULFUR("sulfur"),
    CHLORINE("chlorine"),
    ARGON("argon"),
    POTASSIUM("potassium"),
    CALCIUM("calcium"),
    SCANDIUM("scandium"),
    TITANIUM("titanium"),
    VANADIUM("vanadium"),
    CHROMIUM("chromium"),
    MANGANESE("manganese"),
    IRON("iron"),
    COBALT("cobalt"),
    NICKEL("nickel"),
    COPPER("copper"),
    ZINC("zinc"),
    GALLIUM("gallium"),
    GERMANIUM("germanium"),
    ARSENIC("arsenic"),
    SELENIUM("selenium"),
    BROMINE("bromine"),
    KRYPTON("krypton"),
    RUBIDIUM("rubidium"),
    STRONTIUM("strontium"),
    YTTRIUM("yttrium"),
    ZIRCONIUM("zirconium"),
    NIOBIUM("niobium"),
    MOLYBDENUM("molybdenum"),
    TECHNETIUM("technetium"),
    RUTHENIUM("ruthenium"),
    RHODIUM("rhodium"),
    PALLADIUM("palladium"),
    SILVER("silver"),
    CADMIUM("cadmium"),
    INDIUM("indium"),
    TIN("tin"),
    ANTIMONY("antimony"),
    TELLURIUM("tellurium"),
    IODINE("iodine"),
    XENON("xenon"),
    CAESIUM("caesium"),
    BARIUM("barium"),
    LANTHANUM("lanthanum"),
    CERIUM("cerium"),
    PRASEODYMIUM("praseodymium"),
    NEODYMIUM("neodymium"),
    PROMETHIUM("promethium"),
    SAMARIUM("samarium"),
    EUROPIUM("europium"),
    GADOLINIUM("gadolinium"),
    TERBIUM("terbium"),
    DYSPROSIUM("dysprosium"),
    HOLMIUM("holmium"),
    ERBIUM("erbium"),
    THULIUM("thulium"),
    YTTERBIUM("ytterbium"),
    LUTETIUM("lutetium"),
    HAFNIUM("hafnium"),
    TANTALUM("tantalum"),
    TUNGSTEN("tungsten"),
    RHENIUM("rhenium"),
    OSMIUM("osmium"),
    IRIDIUM("iridium"),
    PLATINUM("platinum"),
    GOLD("gold"),
    MERCURY("mercury"),
    THALLIUM("thallium"),
    LEAD("lead"),
    BISMUTH("bismuth"),
    POLONIUM("polonium"),
    ASTATINE("astatine"),
    RADON("radon"),
    FRANCIUM("francium"),
    RADIUM("radium"),
    ACTINIUM("actinium"),
    THORIUM("thorium"),
    PROTACTINIUM("protactinium"),
    URANIUM("uranium"),
    NEPTUNIUM("neptunium"),
    PLUTONIUM("plutonium"),
    AMERICIUM("americium"),
    CURIUM("curium"),
    BERKELIUM("berkelium"),
    CALIFORNIUM("californium"),
    EINSTEINIUM("einsteinium"),
    FERMIUM("fermium"),
    MENDELEVIUM("mendelevium"),
    NOBELIUM("nobelium"),
    LAWRENCIUM("lawrencium"),
    RUTHERFORDIUM("rutherfordium"),
    DUBNIUM("dubnium"),
    SEABORGIUM("seaborgium"),
    BOHRIUM("bohrium"),
    HASSIUM("hassium"),
    MEITNERIUM("meitnerium"),
    DARMSTADTIUM("darmstadtium"),
    ROENTGENIUM("roentgenium"),
    COPERNICIUM("copernicium"),
    NIHONIUM("nihonium"),
    FLEROVIUM("flerovium"),
    MOSCOVIUM("moscovium"),
    LIVERMORIUM("livermorium"),
    TENNESSINE("tennessine"),
    OGANESSON("oganesson");

    public static final CGCHoneyComb[] VALUES = values();

    public final String name;
    public int primaryColor;
    public int secondaryColor;
    public final String compatName;
    public Material material;

    CGCHoneyComb(String name) {
        this.name = name.toLowerCase(Locale.ENGLISH);
        this.compatName = this.name + "_honey_comb";
    }

    @Override
    public @NotNull String getSerializedName() {
        return name;
    }

    public void initCombs() {
        this.material = GTMaterials.get(getSerializedName());
        this.material.addFlags(CGCMaterialFlags.HAS_COMB);
        this.primaryColor = material.getMaterialRGB();
        this.secondaryColor = material.getMaterialSecondaryRGB();
    }
}
