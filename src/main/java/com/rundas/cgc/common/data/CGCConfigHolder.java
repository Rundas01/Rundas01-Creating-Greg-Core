package com.rundas.cgc.common.data;

import com.rundas.cgc.CreatingGregCore;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = CreatingGregCore.MOD_ID)
public class CGCConfigHolder {

    public static CGCConfigHolder INSTANCE;
    private static final Object LOCK = new Object();

    public static void init() {
        synchronized (LOCK) {
            if (INSTANCE == null) {
                INSTANCE = Configuration.registerConfig(CGCConfigHolder.class, ConfigFormats.yaml())
                        .getConfigInstance();
            }
        }
    }

    @Configurable
    public MachineConfigs machines = new MachineConfigs();

    public static class MachineConfigs {

        @Configurable
        @Configurable.Comment({
                "Into how many daughter nuclei a mother nucleus can split in the Fission Reactor. Alongside the next config, this determines the maximum amount of recipes in the Fission Reactor and the Fuel Reprocessor.",
                "Default: 2" })
        public int maxCoreSplits = 2;

        @Configurable
        @Configurable.Comment({
                "Maximum amount of recipes per material in the Fission Reactor and Fuel Reprocessor. Capped at 32. Alongside the previous config, this determines the maximum amount of recipes in the Fission Reactor and the Fuel Reprocessor.",
                "Default: 5" })
        public int maxNuclearRecipesPerMaterial = 5;
    }
}
