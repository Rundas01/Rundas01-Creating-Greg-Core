package com.rundas.cgc.integration.forsetri.bee;

import forestry.api.genetics.ForestryTaxa;
import forestry.api.genetics.alleles.BeeChromosomes;
import forestry.api.genetics.alleles.ForestryAlleles;
import forestry.api.plugin.IGeneticRegistration;

public class CGCBeeTaxonomy {
    public static void defineTaxa(IGeneticRegistration genetics) {
        genetics.defineTaxon(ForestryTaxa.CLASS_INSECTS, ForestryTaxa.ORDER_HYMNOPTERA, order -> {
            order.defineSubTaxon(ForestryTaxa.FAMILY_BEES, family -> {
                family.defineSubTaxon(CGCBeeTaxa.GENUS_METALLIS_ALKALINE, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.CAVE_DWELLING, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_LONG);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_3);
                    genus.setDefaultChromosome(BeeChromosomes.ACTIVITY, ForestryAlleles.ACTIVITY_CATHEMERAL);
                    genus.setDefaultChromosome(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_UP_2);
                    genus.setDefaultChromosome(BeeChromosomes.FLOWER_TYPE, ForestryAlleles.FLOWER_TYPE_CORAL);
                });
                family.defineSubTaxon(CGCBeeTaxa.GENUS_METALLIS_ALKALINE_TERRAE, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.CAVE_DWELLING, ForestryAlleles.FALSE);
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_SHORT);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_3);
                    genus.setDefaultChromosome(BeeChromosomes.ACTIVITY, ForestryAlleles.ACTIVITY_DIURNAL);
                    genus.setDefaultChromosome(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_UP_2);
                    genus.setDefaultChromosome(BeeChromosomes.FLOWER_TYPE, ForestryAlleles.FLOWER_TYPE_CORAL);
                });
                family.defineSubTaxon(CGCBeeTaxa.GENUS_METALLIS, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_FAST);
                    genus.setDefaultChromosome(BeeChromosomes.SPEED, ForestryAlleles.SPEED_NORMAL);
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_SHORTENED);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_2);
                    genus.setDefaultChromosome(BeeChromosomes.ACTIVITY, ForestryAlleles.ACTIVITY_NOCTURNAL);
                    genus.setDefaultChromosome(BeeChromosomes.HUMIDITY_TOLERANCE, ForestryAlleles.TOLERANCE_UP_1);
                    genus.setDefaultChromosome(BeeChromosomes.TEMPERATURE_TOLERANCE, ForestryAlleles.TOLERANCE_UP_1);
                });
                family.defineSubTaxon(CGCBeeTaxa.GENUS_METALLORUM_TRANSITUS, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWEST);
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_LONGER);
                    genus.setDefaultChromosome(BeeChromosomes.SPEED, ForestryAlleles.SPEED_FASTEST);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_1);
                    genus.setDefaultChromosome(BeeChromosomes.TOLERATES_RAIN, ForestryAlleles.FALSE);
                    genus.setDefaultChromosome(BeeChromosomes.ACTIVITY, ForestryAlleles.ACTIVITY_CATHEMERAL);
                });
                family.defineSubTaxon(CGCBeeTaxa.GENUS_METALLA_NON, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_FAST);
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_NORMAL);
                    genus.setDefaultChromosome(BeeChromosomes.SPEED, ForestryAlleles.SPEED_FASTEST);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_2);
                    genus.setDefaultChromosome(BeeChromosomes.TOLERATES_RAIN, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.ACTIVITY, ForestryAlleles.ACTIVITY_METATURNAL);
                });
                family.defineSubTaxon(CGCBeeTaxa.GENUS_METALLA_SEMI, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWEST);
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_SHORT);
                    genus.setDefaultChromosome(BeeChromosomes.SPEED, ForestryAlleles.SPEED_FASTEST);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_5);
                    genus.setDefaultChromosome(BeeChromosomes.TOLERATES_RAIN, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.CAVE_DWELLING, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.ACTIVITY, ForestryAlleles.ACTIVITY_DIURNAL);
                });
                family.defineSubTaxon(CGCBeeTaxa.GENUS_HALOGENS, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWEST);
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_SHORT);
                    genus.setDefaultChromosome(BeeChromosomes.SPEED, ForestryAlleles.SPEED_FASTEST);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_5);
                    genus.setDefaultChromosome(BeeChromosomes.TOLERATES_RAIN, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.CAVE_DWELLING, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.ACTIVITY, ForestryAlleles.ACTIVITY_DIURNAL);
                });
                family.defineSubTaxon(CGCBeeTaxa.GENUS_GASA_NOBILIA, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWEST);
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_SHORT);
                    genus.setDefaultChromosome(BeeChromosomes.SPEED, ForestryAlleles.SPEED_FASTEST);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_5);
                    genus.setDefaultChromosome(BeeChromosomes.TOLERATES_RAIN, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.CAVE_DWELLING, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.ACTIVITY, ForestryAlleles.ACTIVITY_DIURNAL);
                });
                family.defineSubTaxon(CGCBeeTaxa.GENUS_LANTHANOIDA, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWEST);
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_SHORT);
                    genus.setDefaultChromosome(BeeChromosomes.SPEED, ForestryAlleles.SPEED_FASTEST);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_5);
                    genus.setDefaultChromosome(BeeChromosomes.TOLERATES_RAIN, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.CAVE_DWELLING, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.ACTIVITY, ForestryAlleles.ACTIVITY_DIURNAL);
                });
                family.defineSubTaxon(CGCBeeTaxa.GENUS_ACTINOIDA, genus -> {
                    genus.setDefaultChromosome(BeeChromosomes.POLLINATION, ForestryAlleles.POLLINATION_SLOWEST);
                    genus.setDefaultChromosome(BeeChromosomes.LIFESPAN, ForestryAlleles.LIFESPAN_SHORT);
                    genus.setDefaultChromosome(BeeChromosomes.SPEED, ForestryAlleles.SPEED_FASTEST);
                    genus.setDefaultChromosome(BeeChromosomes.FERTILITY, ForestryAlleles.FERTILITY_5);
                    genus.setDefaultChromosome(BeeChromosomes.TOLERATES_RAIN, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.CAVE_DWELLING, ForestryAlleles.TRUE);
                    genus.setDefaultChromosome(BeeChromosomes.ACTIVITY, ForestryAlleles.ACTIVITY_DIURNAL);
                });
            });

        });
    }
}
