package io.github.gameking1happy.gk1hmodtemplate.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.network.chat.Component;

/**
 * Fabric client-side code..
 */
@SuppressWarnings("unused")
public class FabricClient implements ClientModInitializer {
    /**
     * Runs the Fabric mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        Client.initclient();
        /*
         * Sends system message to chat when the client joins a world.
         */
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            var player = client.player;
            assert player != null;
            player.sendSystemMessage(Component.nullToEmpty("test"));
        });
    }
}
