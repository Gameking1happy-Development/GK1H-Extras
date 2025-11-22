package io.github.gameking1happy.gk1hmodtemplate;

import io.github.gameking1happy.gk1hmodtemplate.config.ServerConfig;
import io.github.gameking1happy.gk1hmodtemplate.packs.Packs;
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
    public static final String MOD_ID = "gk1hmodtemplate";
    /**
     * The mod name.
     */
    public static final String MOD_NAME = "GK1H Mod Template";
    /**
     * The mod logger.
     */
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    /**
     * The server configuration for the mod.
     */
    public static ServerConfig serverconfig = ConfigApiJava.registerAndLoadConfig(ServerConfig::new);
    /**
     * Example server configuration value.
     */
    public static boolean ExampleServer = serverconfig.ExampleServer.get();
    /**
     * Example pack configuration value.
     */
    public static boolean ExamplePack = serverconfig.ExamplePack.get();
    /**
     * Common method for initializing the mod.
     */
    public static void init() {
        LOG.info("Hello from Common init on {}! we are currently in a {} environment!", PLATFORM.getPlatformName(), PLATFORM.getEnvironmentName());
        addClass(new Packs());
        if (ExampleServer) {
            LOG.info("Example Server is true!");
        } else {
            LOG.info("Example Server is false!");
        }
    }
}