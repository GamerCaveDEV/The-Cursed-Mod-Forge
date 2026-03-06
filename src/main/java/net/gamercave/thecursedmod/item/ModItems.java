package net.gamercave.thecursedmod.item;

import net.gamercave.thecursedmod.TheCursedMod;
import net.gamercave.thecursedmod.item.custom.ForgerItem;
import net.gamercave.thecursedmod.item.custom.FuelItem;
import net.gamercave.thecursedmod.item.custom.GoldMakerItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheCursedMod.MOD_ID);

    public static final RegistryObject<Item> CURSED_ITEM = ITEMS.register("cursed_item",
             () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_CURSED_ITEM = ITEMS.register("raw_cursed_item",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FREDBEAR_PLUSH = ITEMS.register("fredbear_plush",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> UNFINISHED_FREDBEAR_PLUSH = ITEMS.register("unfinished_fredbear_plush",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRYING_CHILD = ITEMS.register("crying_child",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FORGER = ITEMS.register("forger",
            () -> new ForgerItem(new Item.Properties().durability(300)));

    public static final RegistryObject<Item> GOLDMAKER = ITEMS.register("goldmaker",
            () -> new GoldMakerItem(new Item.Properties().durability(200)));

    public static final RegistryObject<Item> SUPERSTAR = ITEMS.register("the_superstar",
            () -> new FuelItem(new Item.Properties(), 2300));


    public static final RegistryObject<Item> CURSED_MODE = ITEMS.register("cursed_mode",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
