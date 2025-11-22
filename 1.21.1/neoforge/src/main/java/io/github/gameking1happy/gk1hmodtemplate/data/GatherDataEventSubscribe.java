package io.github.gameking1happy.gk1hmodtemplate.data;

import io.github.gameking1happy.gk1hmodtemplate.data.client.MyLanguageProvider;
import io.github.gameking1happy.gk1hmodtemplate.data.examplepack.ExamplePackRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static io.github.gameking1happy.gk1hmodtemplate.Main.MOD_ID;

/**
 * GatherDataEventSubscribe class for datagen.
 */
@EventBusSubscriber(modid = MOD_ID)
public class GatherDataEventSubscribe {
    /**
     * @param event GatherDataEvent.
     */
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        PackOutput ExamplePackOutput = generator.getPackOutput("examplepack");
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        BlockTagsProvider blockTagsProvider = new MyBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), new MyRecipeProvider(output, lookupProvider));
        generator.addProvider(event.includeClient(), new MyLanguageProvider(output));
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new MyItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ExamplePackRecipeProvider(ExamplePackOutput,lookupProvider));
    }
}