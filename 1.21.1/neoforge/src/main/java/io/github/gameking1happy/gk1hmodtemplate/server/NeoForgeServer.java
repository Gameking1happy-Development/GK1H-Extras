package io.github.gameking1happy.gk1hmodtemplate.server;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

import static io.github.gameking1happy.gk1hmodtemplate.Main.MOD_ID;

/**
 * NeoForge server-side code.
 */
@SuppressWarnings("unused")
@Mod(value = MOD_ID, dist = Dist.DEDICATED_SERVER)
public class NeoForgeServer {
    /**
     * Runs the NeoForge server-side mod initializer.
     */
    public NeoForgeServer() {
        Server.initserver();
    }
}
