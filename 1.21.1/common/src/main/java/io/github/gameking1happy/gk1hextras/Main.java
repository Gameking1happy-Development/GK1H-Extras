package io.github.gameking1happy.gk1hextras;

import io.github.gameking1happy.gk1hextras.config.ServerConfig;
import io.github.gameking1happy.gk1hextras.packs.Packs;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.gameking1happy.gk1hcore.Main.addClass;
import static io.github.gameking1happy.gk1hcore.platform.Services.PLATFORM;

/**
 * The main class for the mod.
 */
@SuppressWarnings("CanBeFinal")
public class Main {
    /**
     * The mod ID.
     */
    public static final String MOD_ID = "gk1hextras";
    /**
     * The mod name.
     */
    public static final String MOD_NAME = "GK1H Extras";
    /**
     * The mod logger.
     */
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    /**
     * The server configuration for the mod.
     */
    public static ServerConfig serverConfig = ConfigApiJava.registerAndLoadConfig(ServerConfig::new);
    /**
     * Sponge fishing configuration value.
     */
    public static boolean spongeFishing = serverConfig.spongeFishing.get();
    /**
     * Sponge chance configuration value.
     */
    public static float spongeChance = serverConfig.spongeChance.get();
    /**
     * Dragon drops head configuration value.
     */
    public static boolean dragonDropsHead = serverConfig.dragonDropsHead.get();
    /**
     * Mace blocking configuration value.
     */
    public static boolean maceBlock = serverConfig.maceBlock.get();
    /**
     * Common method for initializing the mod.
     */
    public static void init() {
        LOG.info("Hello from Common init on {}! we are currently in a {} environment!", PLATFORM.getPlatformName(), PLATFORM.getEnvironmentName());
        addClass(new Packs());
    }
}