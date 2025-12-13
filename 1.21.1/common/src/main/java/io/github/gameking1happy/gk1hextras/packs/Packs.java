package io.github.gameking1happy.gk1hextras.packs;

import io.github.gameking1happy.gk1hcore.packs.AddPacks;
import org.jetbrains.annotations.NotNull;

import static io.github.gameking1happy.gk1hcore.compat.CompatFlags.END_ZOO;
import static io.github.gameking1happy.gk1hcore.packs.AddPackPreset.*;
import static io.github.gameking1happy.gk1hextras.Main.*;

/**
 * Class to add packs.
 */
@SuppressWarnings("unused")
public class Packs implements AddPacks {
    /**
     * @param modContainerOrEvent ModContainer for Fabric, AddPackFindersEvent for NeoForge.
     */
    public void addPacks(@NotNull Object modContainerOrEvent) {
        if (maceBlock) {
            addCdp(modContainerOrEvent, getModID(), "maceblock");
        }
        if (END_ZOO) {
            addCrp(modContainerOrEvent, getModID(), "owlfix");
        }
    }
    /**
     * @return Returns the mod ID.
     */
    @Override
    public @NotNull String getModID() {
        return MOD_ID;
    }
}
