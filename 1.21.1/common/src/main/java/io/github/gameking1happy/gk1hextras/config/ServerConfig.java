package io.github.gameking1happy.gk1hextras.config;

import me.fzzyhmstrs.fzzy_config.annotations.Comment;
import me.fzzyhmstrs.fzzy_config.annotations.RequiresAction;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedBoolean;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedCondition;
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedFloat;
import net.minecraft.network.chat.Component;

import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.SwoBloMec;
import static io.github.gameking1happy.gk1hextras.Main.MOD_ID;
import static io.github.gameking1happy.gk1hcore.data.CoreData.fNaP;
import static me.fzzyhmstrs.fzzy_config.annotations.Action.RELOG;

/**
 * The server configuration for the mod.
 */
@SuppressWarnings("CanBeFinal")
@RequiresAction(action = RELOG)
public class ServerConfig extends Config {
    /**
     * Sponge fishing configuration value.
     */
    @Comment("Add wet sponge to fishing junk loot.")
    public ValidatedBoolean SpongeFishing = new ValidatedBoolean(true);
    /**
     * Sponge chance configuration value.
     */
    @Comment("The chance that a junk loot roll will give a wet sponge.")
    public ValidatedCondition<Float> SpongeChance = new ValidatedFloat(0.12f, 25f, 0.01f).toCondition(SpongeFishing, Component.literal("Fishable Sponges is disabled."), () -> 0f);
    /**
     * Dragon drops head configuration value.
     */
    @Comment("Add dragon head to ender dragon drops.")
    public ValidatedBoolean DragonDropsHead = new ValidatedBoolean(true);
    /**
     * Mace blocking configuration value.
     */
    @Comment("Allows blocking with mace. Requires Sword Blocking Mechanics.")
    public ValidatedCondition<Boolean> MaceBlock = new ValidatedBoolean(true).toCondition(() -> SwoBloMec, Component.literal("Sword Blocking Mechanics not loaded."), () -> false);
    /**
     * The constructor method.
     */
    public ServerConfig() {
        super(fNaP(MOD_ID, "server_config"));
    }
}