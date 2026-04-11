package com.rundas.cgc.util;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;

import java.util.HashMap;
import java.util.Map;

public class CGCTFCUtils {
    public static Map<TagPrefix, Double> tagMeltingModifiers = new HashMap<>(0);
    static {
        tagMeltingModifiers.put(dust, 1.0);
        tagMeltingModifiers.put(dustPure, 0.9);
        tagMeltingModifiers.put(dustImpure, 0.8);
        tagMeltingModifiers.put(crushedPurified, 0.7);
        tagMeltingModifiers.put(crushedRefined, 0.6);
        tagMeltingModifiers.put(crushed, 0.5);
    }
}
