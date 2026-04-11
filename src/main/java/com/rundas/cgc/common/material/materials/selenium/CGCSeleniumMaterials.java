package com.rundas.cgc.common.material.materials.selenium;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import java.util.Arrays;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialCreationUtil.cgcDustMaterial;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerDustProperty;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.registerPhysicsPropertyElement;

public class CGCSeleniumMaterials {

    public static Material SeleniumIVOxide;

    public static void init() {
        SeleniumIVOxide = cgcDustMaterial("selenium_iv_oxide", null, null, Arrays.asList(new MaterialStack(Selenium, 1), new MaterialStack(Oxygen, 2)), 1, 4, -225.5, null);
    }

    public static void preModify() {
        registerDustProperty(Selenium);
        registerPhysicsPropertyElement(Selenium, 4, true);
    }
}
