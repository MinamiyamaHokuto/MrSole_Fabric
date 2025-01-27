package com.frankie.mr_sole.item;

import com.frankie.mr_sole.MrSole;
import com.frankie.mr_sole.entity.ModEntities;
import com.frankie.mr_sole.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
    public static final Item SOLE = registerItem("sole", new Item(new FabricItemSettings().food(ModFoodComponents.SOLE)), ItemGroups.FOOD_AND_DRINK, Items.COOKED_SALMON);
    public static final Item COOKED_SOLE = registerItem("cooked_sole", new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_SOLE)), ItemGroups.FOOD_AND_DRINK, SOLE);
    public static final Item MUSIC_DISC_DEEP_OCEAN = registerItem("music_disc_deep_ocean", new ModMusicDiscItem(6, ModSounds.MUSIC_DISC_DEEP_OCEAN, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 155), ItemGroups.TOOLS, Items.MUSIC_DISC_PIGSTEP);
    public static final Item MUSIC_DISC_IMAGINATION = registerItem("music_disc_imagination", new ModMusicDiscItem(7, ModSounds.MUSIC_DISC_IMAGINATION, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 155), ItemGroups.TOOLS, MUSIC_DISC_DEEP_OCEAN);
    public static final Item MUSIC_DISC_SEA_LEVEL = registerItem("music_disc_sea_level", new ModMusicDiscItem(8, ModSounds.MUSIC_DISC_SEA_LEVEL, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 140), ItemGroups.TOOLS, MUSIC_DISC_IMAGINATION);
    public static final Item SOLE_BUCKET = registerItem("sole_bucket", new ModEntityBucketItem(ModEntities.SOLE, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new FabricItemSettings().maxCount(1)), ItemGroups.TOOLS, Items.SALMON_BUCKET);
    public static final Item SOLE_SPAWN_EGG = registerItem("sole_spawn_egg", new SpawnEggItem(ModEntities.SOLE, 0x403221, 0x8f8b89, new FabricItemSettings()), ItemGroups.SPAWN_EGGS, Items.SALMON_SPAWN_EGG);

    // 注册物品的功能
    private static Item registerItem(String name, Item item, ItemGroup itemGroup, Item preItem) {
        // 注册这个物品，然后使之在创造模式的某个物品组中出现
        Registry.register(Registries.ITEM, new Identifier(MrSole.MOD_ID, name), item);
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> content.addAfter(preItem, item));
        // 返回创建的这个物品
        return item;
    }

    public static void init() {
    }
}
