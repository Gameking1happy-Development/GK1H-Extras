package io.github.gameking1happy.gk1hextras.data.client;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.jetbrains.annotations.NotNull;

import static io.github.gameking1happy.gk1hextras.Main.MOD_ID;

/**
 * Language datagen.
 */
public class MyLanguageProvider extends LanguageProvider {
    /**
     * @param output Pack output.
     */
    public MyLanguageProvider(@NotNull PackOutput output) {
        super(output, MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("gk1hextras.server_config", "Example Server Config");
        add("gk1hextras.server_config.SpongeFishing", "Fishable Sponge");
        add("gk1hextras.server_config.SpongeFishing.desc", "Add wet sponge to fishing junk loot.");
        add("gk1hextras.server_config.SpongeChance", "Sponge Chance");
        add("gk1hextras.server_config.SpongeChance.desc", "The chance that a junk loot roll will give a wet sponge.");
        add("gk1hextras.server_config.DragonDropsHead", "Dragon Drops Head");
        add("gk1hextras.server_config.DragonDropsHead.desc", "Add dragon head to ender dragon drops.");
        add("gk1hextras.server_config.MaceBlock", "Mace Blocking");
        add("gk1hextras.server_config.MaceBlock.desc", "Allows blocking with mace. Requires Sword Blocking Mechanics.");
    }
}