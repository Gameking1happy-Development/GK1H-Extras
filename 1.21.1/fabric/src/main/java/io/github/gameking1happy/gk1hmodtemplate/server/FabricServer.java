package io.github.gameking1happy.gk1hmodtemplate.server;

import net.fabricmc.api.DedicatedServerModInitializer;

/**
 * Fabric server-side code.
 */
@SuppressWarnings("unused")
public class FabricServer implements DedicatedServerModInitializer {
    /**
     * Runs the Fabric mod initializer on the server environment.
     */
    @Override
    public void onInitializeServer() {
        Server.initserver();
    }
}
