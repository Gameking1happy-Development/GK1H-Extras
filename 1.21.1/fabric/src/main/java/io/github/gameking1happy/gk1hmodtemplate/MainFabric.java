package io.github.gameking1happy.gk1hmodtemplate;

import net.fabricmc.api.ModInitializer;

/**
 * The Fabric main class for the mod.
 */
@SuppressWarnings("unused")
public class MainFabric implements ModInitializer {
    /**
     * Runs the Fabric mod initializer.
     */
    @Override
    public void onInitialize() {
        Main.init();
    }
}