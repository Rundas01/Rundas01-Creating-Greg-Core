package com.rundas.cgc.util;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.rundas.cgc.common.material.BeeProperty;
import com.rundas.cgc.common.material.CGCPropertyKeys;
import com.rundas.cgc.integration.forestry.bee.item.CGCBeeItems;
import com.rundas.cgc.integration.forestry.bee.item.CGCHoneyComb;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.tuple.Triple;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rundas.cgc.integration.forestry.bee.CGCBeeSpecies.*;

public class CGCForestryUtil {

    public static Map<Integer, ResourceLocation> beeMap = new HashMap<>(118);

    static {
        beeMap.put(1, HYDROGEN);
        beeMap.put(2, HELIUM);
        beeMap.put(3, LITHIUM);
        beeMap.put(4, BERYLLIUM);
        beeMap.put(5, BORON);
        beeMap.put(6, CARBON);
        beeMap.put(7, NITROGEN);
        beeMap.put(8, OXYGEN);
        beeMap.put(9, FLUORINE);
        beeMap.put(10, NEON);
        beeMap.put(11, SODIUM);
        beeMap.put(12, MAGNESIUM);
        beeMap.put(13, ALUMINIUM);
        beeMap.put(14, SILICON);
        beeMap.put(15, PHOSPHORUS);
        beeMap.put(16, SULFUR);
        beeMap.put(17, CHLORINE);
        beeMap.put(18, ARGON);
        beeMap.put(19, POTASSIUM);
        beeMap.put(20, CALCIUM);
        beeMap.put(21, SCANDIUM);
        beeMap.put(22, TITANIUM);
        beeMap.put(23, VANADIUM);
        beeMap.put(24, CHROMIUM);
        beeMap.put(25, MANGANESE);
        beeMap.put(26, COBALT);
        beeMap.put(27, IRON);
        beeMap.put(28, NICKEL);
        beeMap.put(29, COPPER);
        beeMap.put(30, ZINC);
        beeMap.put(31, GALLIUM);
        beeMap.put(32, GERMANIUM);
        beeMap.put(33, ARSENIC);
        beeMap.put(34, SELENIUM);
        beeMap.put(35, BROMINE);
        beeMap.put(36, KRYPTON);
        beeMap.put(37, RUBIDIUM);
        beeMap.put(38, STRONTIUM);
        beeMap.put(39, YTTRIUM);
        beeMap.put(40, ZIRCONIUM);
        beeMap.put(41, NIOBIUM);
        beeMap.put(42, MOLYBDENUM);
        beeMap.put(43, TECHNETIUM);
        beeMap.put(44, RUTHENIUM);
        beeMap.put(45, RHODIUM);
        beeMap.put(46, PALLADIUM);
        beeMap.put(47, SILVER);
        beeMap.put(48, CADMIUM);
        beeMap.put(49, INDIUM);
        beeMap.put(50, TIN);
        beeMap.put(51, ANTIMONY);
        beeMap.put(52, TELLURIUM);
        beeMap.put(53, IODINE);
        beeMap.put(54, XENON);
        beeMap.put(55, CAESIUM);
        beeMap.put(56, BARIUM);
        beeMap.put(57, LANTHANUM);
        beeMap.put(58, CERIUM);
        beeMap.put(59, PRASEODYMIUM);
        beeMap.put(60, NEODYMIUM);
        beeMap.put(61, PROMETHIUM);
        beeMap.put(62, SAMARIUM);
        beeMap.put(63, EUROPIUM);
        beeMap.put(64, GADOLINIUM);
        beeMap.put(65, TERBIUM);
        beeMap.put(66, DYSPROSIUM);
        beeMap.put(67, HOLMIUM);
        beeMap.put(68, ERBIUM);
        beeMap.put(69, THULIUM);
        beeMap.put(70, YTTERBIUM);
        beeMap.put(71, LUTETIUM);
        beeMap.put(72, HAFNIUM);
        beeMap.put(73, TANTALUM);
        beeMap.put(74, TUNGSTEN);
        beeMap.put(75, RHENIUM);
        beeMap.put(76, OSMIUM);
        beeMap.put(77, IRIDIUM);
        beeMap.put(78, PLATINUM);
        beeMap.put(79, GOLD);
        beeMap.put(80, MERCURY);
        beeMap.put(81, THALLIUM);
        beeMap.put(82, LEAD);
        beeMap.put(83, BISMUTH);
        beeMap.put(84, POLONIUM);
        beeMap.put(85, ASTATINE);
        beeMap.put(86, RADON);
        beeMap.put(87, FRANCIUM);
        beeMap.put(88, RADIUM);
        beeMap.put(89, ACTINIUM);
        beeMap.put(90, THORIUM);
        beeMap.put(91, PROTACTINIUM);
        beeMap.put(92, URANIUM);
        beeMap.put(93, NEPTUNIUM);
        beeMap.put(94, PLUTONIUM);
        beeMap.put(95, AMERICIUM);
        beeMap.put(96, CURIUM);
        beeMap.put(97, BERKELIUM);
        beeMap.put(98, CALIFORNIUM);
        beeMap.put(99, EINSTEINIUM);
        beeMap.put(100, FERMIUM);
        beeMap.put(101, MENDELEVIUM);
        beeMap.put(102, NOBELIUM);
        beeMap.put(103, LAWRENCIUM);
        beeMap.put(104, RUTHERFORDIUM);
        beeMap.put(105, DUBNIUM);
        beeMap.put(106, SEABORGIUM);
        beeMap.put(107, BOHRIUM);
        beeMap.put(108, HASSIUM);
        beeMap.put(109, MEITNERIUM);
        beeMap.put(110, DARMSTADTIUM);
        beeMap.put(111, ROENTGENIUM);
        beeMap.put(112, COPERNICIUM);
        beeMap.put(113, NIHONIUM);
        beeMap.put(114, FLEROVIUM);
        beeMap.put(115, MOSCOVIUM);
        beeMap.put(116, LIVERMORIUM);
        beeMap.put(117, TENNESSINE);
        beeMap.put(118, OGANESSON);
    }

    private static List<Triple<ResourceLocation, ResourceLocation, Float>> getElementMutations(long protons) {
        List<Triple<ResourceLocation, ResourceLocation, Float>> mutations = new ArrayList<>();
        for (int i = 1; i < protons; i++) {
            if (protons - i > i) {
                mutations.add(Triple.of(beeMap.get((int) (protons - i)), beeMap.get(i), i / 200f));
            }
        }
        return mutations;
    }

    public static ItemStack combStack(CGCHoneyComb comb) {
        return CGCBeeItems.BEE_COMBS.stack(comb);
    }

    public static void registerBeeProperty(Material material, String genus, boolean isShiny, List<Triple<ResourceLocation, ResourceLocation, Float>> mutations, List<Tuple<ItemStack, Float>> products, @Nullable List<Tuple<ItemStack, Float>> specialties) {
        material.setProperty(CGCPropertyKeys.BEE, new BeeProperty(genus, material.getMaterialRGB(), material.getMaterialSecondaryRGB(), mutations, isShiny, products, specialties));
    }

    public static void registerBeeProperty(Material material, String genus, boolean isShiny, List<Tuple<ItemStack, Float>> products, @Nullable List<Tuple<ItemStack, Float>> specialties) {
        material.setProperty(CGCPropertyKeys.BEE, new BeeProperty(genus, material.getMaterialRGB(), material.getMaterialSecondaryRGB(), getElementMutations(material.getProtons()), isShiny, products, specialties));
    }

    public static void registerBeeProperty(Material material, String genus, boolean isShiny, List<Tuple<ItemStack, Float>> products) {
        material.setProperty(CGCPropertyKeys.BEE, new BeeProperty(genus, material.getMaterialRGB(), material.getMaterialSecondaryRGB(), getElementMutations(material.getProtons()), isShiny, products, null));
    }
}
