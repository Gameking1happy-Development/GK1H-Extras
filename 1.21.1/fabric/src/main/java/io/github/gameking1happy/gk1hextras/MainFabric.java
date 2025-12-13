package io.github.gameking1happy.gk1hextras;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import static io.github.gameking1happy.gk1hextras.Main.*;


/**
 * The Fabric main class for the mod.
 */
@SuppressWarnings("unused")
public class MainFabric implements ModInitializer {
    /**
     * Runs the Fabric mod initializer.
     */
    @Override
    public void onInitialize() {
        Main.init();
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            /*
            Adds wet sponge to the fishing junk loot, with a chance of SpongeChance.
             */
            if(key.equals(BuiltInLootTables.FISHING_JUNK) && spongeFishing) {
                LootPool pool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1f))
                        .when(LootItemRandomChanceCondition.randomChance(spongeChance))
                        .add(LootItem.lootTableItem(Items.WET_SPONGE))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)))
                        .build();
                tableBuilder.pool(pool);
            }
            if(key.location().equals(ResourceLocation.parse("minecraft:entities/ender_dragon")) && dragonDropsHead)
            {
                LootPool pool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1f))
                        .when(LootItemRandomChanceCondition.randomChance(100f))
                        .add(LootItem.lootTableItem(Items.DRAGON_HEAD))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)))
                        .build();
                tableBuilder.pool(pool);
            }
        });
    }
}