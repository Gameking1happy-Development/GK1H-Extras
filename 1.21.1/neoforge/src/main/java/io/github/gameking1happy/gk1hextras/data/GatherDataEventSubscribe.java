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
        PackOutput MaceBlockOutput = generator.getPackOutput("maceblock");
        PackOutput OwlFixOutput = generator.getPackOutput("owlfix");
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        ExistingFileHelper OwlFixExistingFileHelper = event.getExistingFileHelper();
        OwlFixExistingFileHelper.trackGenerated(OwlHurt, PackType.CLIENT_RESOURCES, ".ogg", "sounds");
        OwlFixExistingFileHelper.trackGenerated(OwlHoot1, PackType.CLIENT_RESOURCES, ".ogg", "sounds");
        OwlFixExistingFileHelper.trackGenerated(OwlHoot2, PackType.CLIENT_RESOURCES, ".ogg", "sounds");
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        BlockTagsProvider blockTagsProvider = new MyBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeClient(), new MyLanguageProvider(output));
        generator.addProvider(event.includeClient(), new OwlFixSoundDefinitionsProvider(OwlFixOutput, OwlFixExistingFileHelper));
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new MaceBlockItemTagsProvider(MaceBlockOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
    }
}