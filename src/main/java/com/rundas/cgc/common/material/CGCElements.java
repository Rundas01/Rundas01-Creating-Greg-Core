package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

import static com.gregtechceu.gtceu.common.data.GTElements.*;
import static com.rundas.cgc.util.CGCForestryUtil.registerBeeProperty;

public class CGCElements {

    public static final Element Tl208 = createAndRegisterIsotope(Tl, 208);
    public static final Element Pb208 = createAndRegisterIsotope(Pb, 208);
    public static final Element Pb212 = createAndRegisterIsotope(Pb, 212);
    public static final Element Bi212 = createAndRegisterIsotope(Bi, 212);
    public static final Element Po212 = createAndRegisterIsotope(Po, 212);
    public static final Element Po216 = createAndRegisterIsotope(Po, 216);
    public static final Element Rn220 = createAndRegisterIsotope(Rn, 220);
    public static final Element Ra224 = createAndRegisterIsotope(Ra, 224);
    public static final Element Th228 = createAndRegisterIsotope(Th, 228);
    public static final Element Pa233 = createAndRegisterIsotope(Pa, 233);
    public static final Element U237 = createAndRegisterIsotope(U, 237);
    public static final Element Am241 = createAndRegisterIsotope(Am, 241);

    public static Element createAndRegisterIsotope(Element element, long nucleons) {
        Element e = new Element(element.protons(), nucleons - element.protons(), 0, "", element.name() + "_" + nucleons, element.symbol(), true);
        GTRegistries.ELEMENTS.register(element.name() + "_" + nucleons, e);
        return e;
    }

    public static void init() {}
}
