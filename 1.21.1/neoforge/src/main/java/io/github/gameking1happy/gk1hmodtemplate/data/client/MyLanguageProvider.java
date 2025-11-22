package io.github.gameking1happy.gk1hmodtemplate.data.client;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.jetbrains.annotations.NotNull;

import static io.github.gameking1happy.gk1hmodtemplate.Main.MOD_ID;

/**
 * Language datagen.
 */
public class MyLanguageProvider extends LanguageProvider {
    /**
     * @param output Pack output.
     */
    public MyLanguageProvider(@NotNull PackOutput output) {
        super(output, MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("gk1hmodtemplate.server_config", "Example Server Config");
        add("gk1hmodtemplate.server_config.ExampleServer", "Example Server Config Value");
        add("gk1hmodtemplate.server_config.ExampleServer.desc", "Example Server Config Value Description.");
        add("gk1hmodtemplate.server_config.ExamplePack", "Example Pack Config Value");
        add("gk1hmodtemplate.server_config.ExamplePack.desc", "Example Pack Config Value Description.");
        add("gk1hmodtemplate.client_config", "Example Client Config");
        add("gk1hmodtemplate.client_config.ExampleClient", "Example Client Config Value");
        add("gk1hmodtemplate.client_config.ExampleClient.desc", "Example Client Config Value Description.");
    }
}