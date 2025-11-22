package io.github.gameking1happy.gk1hmodtemplate.client;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.common.NeoForge;

import static io.github.gameking1happy.gk1hmodtemplate.Main.MOD_ID;

/**
 * NeoForge client-side code.
 */
@SuppressWarnings("unused")
@Mod(value = MOD_ID, dist = Dist.CLIENT)
public class NeoForgeClient {
    /**
     * Runs the NeoForge client-side mod initializer.
     */
    public NeoForgeClient() {
        Client.initclient();
        NeoForge.EVENT_BUS.addListener(NeoForgeClient::joinedWorld);
    }
    /**
     * Sends system message to chat when the client joins a world.
     * @param event ClientPlayerNetworkEvent.LoggingIn, is fired when player joins a world.
     */
    public static void joinedWorld(ClientPlayerNetworkEvent.LoggingIn event) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.sendSystemMessage(Component.nullToEmpty("test"));
    }
}
