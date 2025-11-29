package io.github.gameking1happy.gk1hextras;

import io.github.gameking1happy.gk1hextras.loot.ModifyLootTable;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

import static io.github.gameking1happy.gk1hextras.Main.MOD_ID;

/**
 * The NeoForge main class for the mod.
 */
@SuppressWarnings("unused")
@Mod(MOD_ID)
public class MainNeoForge {
    /**
     * Runs the NeoForge mod initializer.
     */
    public MainNeoForge() {
        Main.init();
        NeoForge.EVENT_BUS.addListener(ModifyLootTable::loadTables);
    }

}
