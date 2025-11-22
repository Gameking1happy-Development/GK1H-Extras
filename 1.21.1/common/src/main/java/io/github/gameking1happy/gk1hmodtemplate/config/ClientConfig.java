package io.github.gameking1happy.gk1hmodtemplate.config;

import me.fzzyhmstrs.fzzy_config.annotations.Comment;
import me.fzzyhmstrs.fzzy_config.annotations.RequiresAction;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedBoolean;

import static io.github.gameking1happy.gk1hmodtemplate.Main.MOD_ID;
import static io.github.gameking1happy.gk1hcore.Main.fNAP;
import static me.fzzyhmstrs.fzzy_config.annotations.Action.RELOG;

/**
 * The client configuration for the mod.
 */
@SuppressWarnings("CanBeFinal")
@RequiresAction(action = RELOG)
public class ClientConfig extends Config {
    /**
     * Example client configuration value.
     */
    @Comment("Example Client Config Value.")
    public ValidatedBoolean ExampleClient = new ValidatedBoolean(true);
    /**
     * The constructor method.
     */
    public ClientConfig() {
        super(fNAP(MOD_ID, "client_config"));
    }
}