package io.github.gameking1happy.gk1hextras.data.client.owlfix;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import org.jetbrains.annotations.NotNull;
import fuzs.enderzoology.init.ModSoundEvents;

import static io.github.gameking1happy.gk1hcore.data.CoreData.fnap;

/**
 * Owl Fix sound definitions datagen.
 */
public class OwlFixSoundDefinitionsProvider extends SoundDefinitionsProvider {
    /**
     * @param output Pack output.
     * @param existingFileHelper Existing file helper.
     */
    public OwlFixSoundDefinitionsProvider(@NotNull PackOutput output, @NotNull ExistingFileHelper existingFileHelper) {
        super(output, "enderzoology", existingFileHelper);
    }
    private static @NotNull ResourceLocation fP(@NotNull String path) {
        return fnap("enderzoology", path);
    }

    /**
     * Owl hurt Resource Location.
     */
    public static ResourceLocation owlHurt = fP("mob/owl/hurt");
    /**
     * Owl hoot 1 Resource Location.
     */
    public static ResourceLocation owlHoot1 = fP("mob/owl/hoot1");
    /**
     * Owl hoot 2 Resource Location.
     */
    public static ResourceLocation owlHoot2 = fP("mob/owl/hoot2");
    @Override
    public void registerSounds() {
        add(ModSoundEvents.OWL_DEATH_SOUND_EVENT.value(), SoundDefinition.definition()
                .with(
                        sound(owlHurt)
                                .volume(0.05f)
                )
                .subtitle("subtitles.entity.owl.death")
                .replace(true)
        );
        add(ModSoundEvents.OWL_HURT_SOUND_EVENT.value(), SoundDefinition.definition()
                .with(
                        sound(owlHurt)
                                .volume(0.05f)
                )
                .subtitle("subtitles.entity.owl.hurt")
                .replace(true)
        );
        add(ModSoundEvents.OWL_HOOT_SOUND_EVENT.value(), SoundDefinition.definition()
                .with(
                        sound(owlHoot1)
                                .volume(0.05f),
                        sound(owlHoot2)
                                .volume(0.05f)
                )
                .subtitle("subtitles.entity.owl.hoot")
                .replace(true)
        );
    }

    @Override
    public @NotNull String getName() {
        return super.getName() + "-OwlFix";
    }
}