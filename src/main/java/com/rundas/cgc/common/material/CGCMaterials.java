package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import static com.rundas.cgc.CreatingGregCore.id;

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
    }

    public static void modify() {

    }
}
