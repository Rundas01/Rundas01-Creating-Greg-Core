package com.rundas.cgc.common.material.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.rundas.cgc.common.material.materials.CGCElements.*;
import static com.rundas.cgc.util.gtceu.CGCMaterialUtil.isotopeMaterial;

public class CGCNuclearMaterials {

    public static Material Thallium208;
    public static Material Lead208;
    public static Material Lead212;
    public static Material Bismuth212;
    public static Material Polonium212;
    public static Material Polonium216;
    public static Material Radon220;
    public static Material Radium224;
    public static Material Thorium228;
    public static Material Protactinium233;
    public static Material Uranium232;
    public static Material Uranium237;
    public static Material Americium241;

    public static void init() {
        Thallium208 = isotopeMaterial(Thallium, Tl208);
        Lead208 = isotopeMaterial(Lead, Pb208);
        Lead212 = isotopeMaterial(Lead, Pb212);
        Bismuth212 = isotopeMaterial(Bismuth, Bi212);
        Polonium212 = isotopeMaterial(Polonium, Po212);
        Polonium216 = isotopeMaterial(Polonium, Po216);
        Radon220 = isotopeMaterial(Radon, Rn220);
        Radium224 = isotopeMaterial(Radium, Ra224);
        Thorium228 = isotopeMaterial(Thorium, Th228);
        Protactinium233 = isotopeMaterial(Protactinium, Pa233);
        Uranium237 = isotopeMaterial(Uranium238, U237);
        Americium241 = isotopeMaterial(Americium, Am241);
    }
}
