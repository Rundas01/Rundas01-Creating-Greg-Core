package com.rundas.cgc.common.material;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

public class CGCPropertyKeys {

    public static final PropertyKey<PhysicsProperty> PHYSICS = new PropertyKey<>("physics", PhysicsProperty.class);
    public static final PropertyKey<SolutionProperty> SOLUTION = new PropertyKey<>("solution", SolutionProperty.class);
    public static final PropertyKey<NuclearProperty> NUCLEAR = new PropertyKey<>("nuclear", NuclearProperty.class);
    public static final PropertyKey<CoolantProperty> COOLANT = new PropertyKey<>("coolant", CoolantProperty.class);
    public static final PropertyKey<BeeProperty> BEE = new PropertyKey<>("bee", BeeProperty.class);
    public static final PropertyKey<OreprocProperty> OREPROC = new PropertyKey<>("oreproc", OreprocProperty.class);

}
