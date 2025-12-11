package com.rundas.cgc.integration.forsetri;
import net.minecraft.resources.ResourceLocation;

import forestry.api.modules.IForestryModule;
import org.jetbrains.annotations.NotNull;

import static com.rundas.cgc.CreatingGregCore.id;

public class CreatingGregCoreForestryAddon implements IForestryModule {
        @Override
        public @NotNull ResourceLocation getId() {
            return id("core/cgc");
        }
}
