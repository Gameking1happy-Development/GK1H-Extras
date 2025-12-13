package io.github.gameking1happy.gk1hextras.client;

import net.fabricmc.api.ClientModInitializer;

/**
 * Fabric client-side code.
 */
@SuppressWarnings("unused")
public class FabricClient implements ClientModInitializer {
    /**
     * Runs the Fabric mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        Client.initClient();
    }
}
