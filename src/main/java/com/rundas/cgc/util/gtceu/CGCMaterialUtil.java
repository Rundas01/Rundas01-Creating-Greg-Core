package com.rundas.cgc.util.gtceu;

import com.google.common.collect.ImmutableList;
import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.DustProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.common.unification.material.MaterialRegistryManager;

import com.rundas.cgc.common.material.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.rundas.cgc.CreatingGregCore.id;
import static com.rundas.cgc.common.material.CGCPropertyKeys.PHYSICS;

public class CGCMaterialUtil {

    public static int getMolarAmount(@NotNull Material material, int moles) {

        long atomsPerMolecule = molarDecomposer(material);

        return Math.toIntExact(moles * atomsPerMolecule);
    }

    public static int getMolarAmount(@NotNull ImmutableList<MaterialStack> stacks) {
        long amount = 0;
        for (MaterialStack stack : stacks) {
            amount += stack.amount() * molarDecomposer(stack.material());
        }
        return Math.toIntExact(amount);
    }

    public static int getMolarAmount(Material material) {
        return getMolarAmount(material, 1);
    }

    private static long molarDecomposer(@NotNull Material material) {

        // Base case: element
        if (material.isElement()) {
            return 1;
        }

        long amount = 0;

        for (MaterialStack stack : material.getMaterialComponents()) {
            amount += stack.amount() * molarDecomposer(stack.material());
        }

        return amount;
    }

    public static ImmutableList<MaterialStack> convertComponents(List<MaterialStack> components) {
        if (components == null || components.isEmpty()) {
            return ImmutableList.of();
        }
        return ImmutableList.copyOf(components);
    }

    public static Double avgFormationEnthalpy(List<MaterialStack> components) {
        return avgFormationEnthalpy(convertComponents(components));
    }

    public static Double avgFormationEnthalpy(ImmutableList<MaterialStack> components) {
        double formationEnthalpy = 0.0;
        long amount = 0;
        PhysicsProperty property;
        for (MaterialStack component : components) {
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

    public static boolean contains(Material compound, Material material) {
        for (MaterialStack stack : compound.getMaterialComponents()) {
            if (stack.material() == material) {
                return true;
            }
        }
        return false;
    }

    public static void changeComponentsAndFormula(Material material, MaterialStack... components) {
        changeComponentsAndFormula(material, null, components);
    }

    public static void changeComponentsAndFormula(Material material, String formula, MaterialStack... components) {
        if (formula != null) {
            material.setFormula(formula, true);
        } else {
            StringBuilder formula2 = new StringBuilder();
            for (MaterialStack stack : components) {
                if (stack.material().isElement()) {
                    formula2.append(stack.material().getChemicalFormula());
                    formula2.append(stack.amount());

                } else {
                    formula2.append("(");
                    formula2.append(stack.material().getChemicalFormula());
                    formula2.append(")");
                    formula2.append(stack.amount());
                }
            }
            material.setFormula(formula2.toString(), true);
        }

        material.setComponents(components);
    }

    public static void registerPhysicsPropertyFluidOrGas(Material material, int tier, Double formationEnthalpy, boolean isMetal, Double heatCapacity, Integer meltingPoint) {
        registerPhysicsProperty(material, tier, formationEnthalpy, 1000, isMetal, heatCapacity, meltingPoint);
    }

    public static void registerPhysicsPropertyFluidOrGas(Material material, int tier, Double formationEnthalpy, int liquidMole, boolean isMetal, Double heatCapacity, Integer meltingPoint) {
        registerPhysicsProperty(material, tier, formationEnthalpy, liquidMole, isMetal, heatCapacity, meltingPoint);
    }

    public static void registerPhysicsPropertyFluidOrGas(Material material, int tier, Double formationEnthalpy, int liquidMole, boolean isMetal) {
        registerPhysicsProperty(material, tier, formationEnthalpy, liquidMole, isMetal, 0.0, 273);
    }

    public static void registerPhysicsPropertyFluidOrGas(Material material, int tier, Double formationEnthalpy, boolean isMetal) {
        registerPhysicsProperty(material, tier, formationEnthalpy, 1000, isMetal, 0.0, 273);
    }

    public static void registerPhysicsPropertyMetal(Material material, int tier, Double formationEnthalpy, Double heatCapacity, Integer meltingPoint) {
        registerPhysicsProperty(material, tier, formationEnthalpy, 144, true, heatCapacity, meltingPoint);
    }

    public static void registerPhysicsPropertyMetal(Material material, int tier, Double formationEnthalpy) {
        registerPhysicsProperty(material, tier, formationEnthalpy, 144, true, 0.0, 273);
    }

    public static void registerPhysicsPropertyNonmetal(Material material, int tier, Double formationEnthalpy, Double heatCapacity, Integer meltingPoint) {
        registerPhysicsProperty(material, tier, formationEnthalpy, 0, false, heatCapacity, meltingPoint);
    }

    public static void registerPhysicsPropertyNonmetal(Material material, int tier, Double formationEnthalpy) {
        registerPhysicsProperty(material, tier, formationEnthalpy, 0, false, 0.0, 273);
    }

    public static void registerPhysicsPropertyOre(Material material, Double formationEnthalpy, @Nullable Material meltsInto, @Nullable Double heatCapacity, Integer meltingPoint) {
        int metalAmount = 0, increase = 0;
        for (MaterialStack ms : material.getMaterialComponents()) {
            if (ms.material().getProperty(PHYSICS).isMetal()) {
                metalAmount += 1;
            }
        }
        if (metalAmount > 1) {
            increase = 1;
        }
        int tier = getMaxTier(material.getMaterialComponents()) + increase;
        registerPhysicsPropertyMetal(material, tier, formationEnthalpy, heatCapacity, meltingPoint);
        registerTFCProperty(material, tier, meltsInto);
    }

    public static void registerPhysicsPropertyOre(Material material, Double formationEnthalpy) {
        registerPhysicsPropertyOre(material, formationEnthalpy, null, null, 273);
    }

    public static void registerPhysicsPropertyElement(Material material, int tier, int liquidMole, boolean isMetal, Double heatCapacity, Integer meltingPoint) {
        registerPhysicsProperty(material, tier, 0.0, liquidMole, isMetal, heatCapacity, meltingPoint);
    }

    public static void registerPhysicsPropertyElement(Material material, int tier, int liquidMole, boolean isMetal) {
        registerPhysicsProperty(material, tier, 0.0, liquidMole, isMetal, 0.0, 273);
    }

    public static void registerPhysicsPropertyElement(Material material, int tier, boolean isMetal, Double heatCapacity, Integer meltingPoint) {
        registerPhysicsPropertyElement(material, tier, 0, isMetal, heatCapacity, meltingPoint);
    }

    public static void registerPhysicsPropertyElement(Material material, int tier, boolean isMetal) {
        registerPhysicsPropertyElement(material, tier, 0, isMetal, 0.0, 273);
    }

    public static void registerPhysicsPropertyCompound(Material material, Integer tier, Double formationEnthalpy, Double heatCapacity, Integer meltingPoint) {
        int newTier = tier == null ? getMaxTier(material.getMaterialComponents()) : tier;
        double newFormationEnthalpy = formationEnthalpy == null ? avgFormationEnthalpy(material.getMaterialComponents()) : formationEnthalpy;
        boolean isMetal = material.getMaterialComponents().stream().filter(ms -> !ms.material().getProperty(PHYSICS).isMetal()).toList().isEmpty();
        if (isMetal) {
            registerPhysicsPropertyMetal(material, newTier, newFormationEnthalpy, heatCapacity, meltingPoint);
        } else {
            registerPhysicsPropertyNonmetal(material, newTier, newFormationEnthalpy, heatCapacity, meltingPoint);
        }
    }

    public static void registerPhysicsPropertyCompound(Material material, Integer tier, Double formationEnthalpy) {
        registerPhysicsPropertyCompound(material, tier, formationEnthalpy, null, null);
    }

    public static void registerPhysicsPropertyCompound(Material material, Integer tier) {
        registerPhysicsPropertyCompound(material, tier, null, null, null);
    }

    public static void registerPhysicsPropertyCompound(Material material, Double formationEnthalpy) {
        registerPhysicsPropertyCompound(material, null, formationEnthalpy, null, null);
    }

    public static void registerPhysicsPropertyCompound(Material material) {
        registerPhysicsPropertyCompound(material, null, null, null, null);
    }

    public static void registerPhysicsProperty(Material material, int tier, Double formationEnthalpy, int liquidMole, boolean isMetal, Double heatCapacity, Integer meltingPoint) {
        material.setProperty(PHYSICS,
                new PhysicsProperty(tier, formationEnthalpy != null ? formationEnthalpy : avgFormationEnthalpy(material.getMaterialComponents()), CGCMaterialUtil.getMolarAmount(material), liquidMole, isMetal, heatCapacity, meltingPoint));
    }

    public static void registerSolutionProperty(@NotNull Material material, @NotNull Material solvent, @NotNull Material solution, @NotNull Material crystallizedSolution, List<@NotNull Material> dilutedSolutions) {
        material.setProperty(CGCPropertyKeys.SOLUTION, new SolutionProperty(solvent, solution, crystallizedSolution, dilutedSolutions));
    }

    public static void registerTFCProperty(Material material, int tier, @Nullable Material meltsInto) {
        if (meltsInto != null) {
            material.setProperty(CGCPropertyKeys.TFC, new TFCProperty(tier, meltsInto, (int) (144 * getPercentageOfElementInCompound(material, meltsInto))));
        } else {
            material.setProperty(CGCPropertyKeys.TFC, new TFCProperty(tier, null, 0));
        }
    }

    public static void registerDustProperties(List<Material> materials) {
        materials.forEach(CGCMaterialUtil::registerDustProperty);
    }

    public static void registerDustProperty(Material material) {
        material.setProperty(PropertyKey.DUST, new DustProperty());
    }

    public static int getMetalAmountInCompound(ImmutableList<MaterialStack> components) {
        int amount = 0;
        for (MaterialStack stack : components) {
            if (stack.material().hasProperty(PHYSICS)) {
                if (stack.material().getProperty(PHYSICS).isMetal()) {
                    amount += 1;
                }
            }
        }
        return amount;
    }

    private static double getPercentageOfElementInCompound(Material material, Material element) {
        int total = getTotalAtomAmount(material);
        return (double) total / getAtomAmount(material, element);
    }
}