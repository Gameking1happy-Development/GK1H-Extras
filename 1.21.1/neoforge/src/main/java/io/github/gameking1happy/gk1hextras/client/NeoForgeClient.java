package io.github.gameking1happy.gk1hextras.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

import static io.github.gameking1happy.gk1hextras.Main.MOD_ID;

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
    }
}
