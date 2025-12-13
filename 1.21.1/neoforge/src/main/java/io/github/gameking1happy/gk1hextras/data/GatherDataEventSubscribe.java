package io.github.gameking1happy.gk1hextras.data;

import io.github.gameking1happy.gk1hextras.data.client.MyLanguageProvider;
import io.github.gameking1happy.gk1hextras.data.client.owlfix.OwlFixSoundDefinitionsProvider;
import io.github.gameking1happy.gk1hextras.data.maceblock.MaceBlockItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.PackType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static io.github.gameking1happy.gk1hextras.Main.MOD_ID;
import static io.github.gameking1happy.gk1hextras.data.client.owlfix.OwlFixSoundDefinitionsProvider.*;

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
        PackOutput maceBlockOutput = generator.getPackOutput("maceblock");
        PackOutput owlFixOutput = generator.getPackOutput("owlfix");
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        ExistingFileHelper owlFixExistingFileHelper = event.getExistingFileHelper();
        owlFixExistingFileHelper.trackGenerated(owlHurt, PackType.CLIENT_RESOURCES, ".ogg", "sounds");
        owlFixExistingFileHelper.trackGenerated(owlHoot1, PackType.CLIENT_RESOURCES, ".ogg", "sounds");
        owlFixExistingFileHelper.trackGenerated(owlHoot2, PackType.CLIENT_RESOURCES, ".ogg", "sounds");
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        BlockTagsProvider blockTagsProvider = new MyBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeClient(), new MyLanguageProvider(output));
        generator.addProvider(event.includeClient(), new OwlFixSoundDefinitionsProvider(owlFixOutput, owlFixExistingFileHelper));
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new MaceBlockItemTagsProvider(maceBlockOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
    }
}