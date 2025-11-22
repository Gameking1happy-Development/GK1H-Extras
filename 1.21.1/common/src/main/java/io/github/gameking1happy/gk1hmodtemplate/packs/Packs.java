package io.github.gameking1happy.gk1hmodtemplate.packs;

import io.github.gameking1happy.gk1hcore.packs.AddPacks;
import org.jetbrains.annotations.NotNull;

import static io.github.gameking1happy.gk1hcore.packs.AddPackPreset.addCDP;
import static io.github.gameking1happy.gk1hmodtemplate.Main.*;

/**
 * Class to add packs.
 */
@SuppressWarnings("unused")
public class Packs implements AddPacks {
    /**
     * @param modContainerOrEvent ModContainer for Fabric, AddPackFindersEvent for NeoForge.
     */
    public void addPacks(@NotNull Object modContainerOrEvent) {
        if (ExamplePack) {
            addCDP(modContainerOrEvent, getModID(), "examplepack");
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
