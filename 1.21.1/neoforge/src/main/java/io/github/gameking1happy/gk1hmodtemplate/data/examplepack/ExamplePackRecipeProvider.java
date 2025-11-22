package io.github.gameking1happy.gk1hmodtemplate.data.examplepack;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static io.github.gameking1happy.gk1hmodtemplate.Main.MOD_ID;
import static io.github.gameking1happy.gk1hcore.Main.fNAP;

/**
 * Example Pack datagen.
 */
public class ExamplePackRecipeProvider extends RecipeProvider {
    /**
     * @param output Pack output.
     * @param lookupProvider Lookup provider.
     */
    public ExamplePackRecipeProvider(@NotNull PackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }
    @Override
    public @NotNull String getName() {
        return super.getName() + "-ExamplePack";
    }
    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.GRASS_BLOCK)
                .pattern(" D ")
                .pattern("DDD")
                .pattern(" D ")
                .define('D', Items.DIRT)
                .unlockedBy("has_dirt",has(Items.DIRT))
                .save(output, fNAP(MOD_ID,"examplerecipe"));
    }
}