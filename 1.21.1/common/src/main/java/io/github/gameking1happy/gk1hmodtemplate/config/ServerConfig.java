package io.github.gameking1happy.gk1hmodtemplate.config;

import me.fzzyhmstrs.fzzy_config.annotations.Comment;
import me.fzzyhmstrs.fzzy_config.annotations.RequiresAction;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedBoolean;

import static io.github.gameking1happy.gk1hmodtemplate.Main.MOD_ID;
import static io.github.gameking1happy.gk1hcore.Main.fNAP;
import static me.fzzyhmstrs.fzzy_config.annotations.Action.RELOG;

/**
 * The server configuration for the mod.
 */
@SuppressWarnings("CanBeFinal")
@RequiresAction(action = RELOG)
public class ServerConfig extends Config {
    /**
     * Example server configuration value.
     */
    @Comment("Example Server Config Value.")
    public ValidatedBoolean ExampleServer = new ValidatedBoolean(true);
    /**
     * Example pack configuration value.
     */
    @Comment("Example Pack Config Value.")
    public ValidatedBoolean ExamplePack = new ValidatedBoolean(true);
    /**
     * The constructor method.
     */
    public ServerConfig() {
        super(fNAP(MOD_ID, "server_config"));
    }
}