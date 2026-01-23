package com.rundas.cgc.util;

import com.google.common.collect.ImmutableList;
import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.common.unification.material.MaterialRegistryManager;

import com.rundas.cgc.CreatingGregCore;
import com.rundas.cgc.common.material.CGCMaterialFlags;
import com.rundas.cgc.common.material.PhysicsProperty;
import net.minecraft.util.Tuple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.rundas.cgc.CreatingGregCore.id;
import static com.rundas.cgc.common.material.CGCPropertyKeys.PHYSICS;

public class CGCMaterialUtil {

    public static int getMolarAmount(@NotNull Material material, int moles) {
        int amount = 1;
        for (MaterialStack stack : material.getMaterialComponents()) {
            amount += (int) (stack.amount() * molarDecomposer(stack.material()));
        }
        return moles * amount;
    }

    public static int getMolarAmount(ImmutableList<MaterialStack> stacks) {
        int amount = 1;
        for (MaterialStack stack : stacks) {
            amount += (int) (stack.amount() * molarDecomposer(stack.material()));
        }
        return amount;
    }

    public static int getMolarAmount(Material material) {
        return getMolarAmount(material, 1);
    }

    private static int molarDecomposer(@NotNull Material material) {
        int amount = 1;
        for (MaterialStack stack : material.getMaterialComponents()) {
            if (stack.material().isElement()) {
                amount += (int) stack.amount();
            } else {
                amount += molarDecomposer(stack.material());
            }
        }
        return amount;
    }

    public static ImmutableList<MaterialStack> convertComponents(List<Tuple<Material, Integer>> components) {
        if (components == null) {
            return null;
        }
        ImmutableList.Builder<MaterialStack> stacks = new ImmutableList.Builder<>();
        for (Tuple<Material, Integer> component : components) {
            stacks.add(new MaterialStack(component.getA(), component.getB()));
        }
        return stacks.build();
    }

    public static Double avgFormationEnthalpy(List<Tuple<Material, Integer>> components) {
        double formationEnthalpy = 0.0;
        int amount = 0;
        PhysicsProperty property;
        for (Tuple<Material, Integer> component : components) {
            property = component.getA().getProperty(PHYSICS);
            formationEnthalpy += property.formationEnthalpy() * component.getB();
            amount += component.getB();
        }
        return  formationEnthalpy / amount;
    }

    public static Double avgFormationEnthalpy(ImmutableList<MaterialStack> components) {
        double formationEnthalpy = 0.0;
        long amount = 0;
        PhysicsProperty property;
        for (MaterialStack component : components) {
            CreatingGregCore.LOGGER.debug("Current Material: " + component.material().getName());
            CreatingGregCore.LOGGER.debug("Has PP: " + component.material().hasProperty(PHYSICS));
            property = component.material().getProperty(PHYSICS);
            formationEnthalpy += property.formationEnthalpy() * component.amount();
            amount += component.amount();
        }
        return  formationEnthalpy / amount;
    }

    public static @Nullable Material getElementFromProtons(long protons, boolean onlyStable) {
        for (Material material : MaterialRegistryManager.getInstance().getRegisteredMaterials()) {
            if (material.isElement() && material.getProtons() == protons &&
                    (onlyStable && !material.isRadioactive()) | !onlyStable) {
                return material;
            }
        }
        return null;
    }

    public static @NotNull Material isotopeMaterial(@NotNull Material base, @NotNull Element element) {
        Material.Builder builder = new Material.Builder(id(base.getUnlocalizedName().split("\\.")[2] + element.mass()))
                .element(element).color(base.getMaterialRGB()).secondaryColor(base.getMaterialSecondaryRGB());
        if (base.hasProperty(PropertyKey.DUST)) {
            builder.dust();
        } else {
            builder.fluid();
        }
        Material material = builder.buildAndRegister();
        material.addFlags(CGCMaterialFlags.IS_NUCLEAR);
        return material;
    }

    public static int getMaxTier(List<MaterialStack> stacks) {
        int tier = 1;
        for (MaterialStack stack : stacks) {
            PhysicsProperty property = stack.material().getProperty(PHYSICS);
            tier = Math.max(property.tier(), tier);
        }
        return tier;
    }

    public static int getAtomAmount(Material material, Material atom) {
        long amount = 0;
        for (MaterialStack stack : material.getMaterialComponents()) {
            if (stack.material() == atom) {
                amount += stack.amount();
            }
        }
        return Math.toIntExact(amount);
    }

    public static int getTotalAtomAmount(Material material) {
        long amount = 0;
        for (MaterialStack stack : material.getMaterialComponents()) {
            if (stack.material().isElement()) {
                amount += stack.amount();
            } else {
                amount += getTotalAtomAmount(stack.material());
            }
        }
        return Math.toIntExact(amount);
    }
}
