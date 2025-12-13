package io.github.gameking1happy.gk1hextras.loot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import org.jetbrains.annotations.NotNull;

import static io.github.gameking1happy.gk1hextras.Main.*;


/**
 * Modify loot tables.
 */
public class ModifyLootTable {
    /**
     * @param event LootTableLoadEvent.
     */
    @SubscribeEvent
    public static void loadTables(@NotNull LootTableLoadEvent event) {
        /*
        Adds wet sponge to the fishing junk loot, with a chance of SpongeChance.
         */
        if (event.getKey().equals(BuiltInLootTables.FISHING_JUNK) && spongeFishing) {
            event.getTable().addPool(
                    LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1f))
                            .when(LootItemRandomChanceCondition.randomChance(spongeChance))
                            .add(LootItem.lootTableItem(Items.WET_SPONGE))
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)))
                            .build()
            );
        }
        /*
        Makes ender dragon have a 100% chance of dropping head.
         */
        if (event.getName().equals(ResourceLocation.parse("minecraft:entities/ender_dragon")) && dragonDropsHead) {
            event.getTable().addPool(
                    LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1f))
                            .when(LootItemRandomChanceCondition.randomChance(100f))
                            .add(LootItem.lootTableItem(Items.DRAGON_HEAD))
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)))
                            .build()
            );
        }
    }
}
