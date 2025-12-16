package com.rundas.cgc.integration.forestry.bee.item;

import forestry.modules.features.FeatureItemGroup;
import forestry.modules.features.FeatureProvider;
import forestry.modules.features.IFeatureRegistry;
import forestry.modules.features.ModFeatureRegistry;

import static com.rundas.cgc.CreatingGregCore.id;

@FeatureProvider
public class CGCBeeItems {

    public static final IFeatureRegistry REGISTRY = ModFeatureRegistry.get(id("core/cgc"));
    public static final FeatureItemGroup<CGCItemHoneyComb, CGCHoneyComb> BEE_COMBS = REGISTRY
            .itemGroup(CGCItemHoneyComb::new, "bee_comb", CGCHoneyComb.VALUES);

    /*
     * public static final FeatureItem<CosmicBeesItemHiveFraming> FRAME_WAILING = REGISTRY
     * .item(() -> new CosmicBeesItemHiveFraming.CosmicBeesItemHiveFrameBuilder(2048)
     * .setMutationMult(1000f)
     * .build(), "frame_wailing");
     */
}
