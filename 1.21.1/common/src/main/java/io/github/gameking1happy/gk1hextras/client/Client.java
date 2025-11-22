package io.github.gameking1happy.gk1hextras.client;

import io.github.gameking1happy.gk1hextras.config.ClientConfig;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.api.RegisterType;

import static io.github.gameking1happy.gk1hextras.Main.LOG;

/**
 * Client-side code.
 */
@SuppressWarnings({"unused", "CanBeFinal"})
public class Client {
    /**
     * The client configuration for the mod.
     */
    public static ClientConfig clientconfig = ConfigApiJava.registerAndLoadConfig(ClientConfig::new, RegisterType.CLIENT);
    /**
     * Example client configuration value.
     */
    public static boolean ExampleClient = clientconfig.ExampleClient.get();
    /**
     * Client initialization.
     */
    public static void initclient() {
        LOG.info("Client-side.");
        if (ExampleClient) {
            LOG.info("Example Client is true!");
        } else {
            LOG.info("Example Client is false!");
        }
    }
}
