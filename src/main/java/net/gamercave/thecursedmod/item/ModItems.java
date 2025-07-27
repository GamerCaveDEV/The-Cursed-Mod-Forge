package net.gamercave.thecursedmod.item;

import net.gamercave.thecursedmod.TheCursedMod;
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

    public static final RegistryObject<Item> FREDBEAR_PLUSH = ITEMS.register("fredbear_plush",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CRYING_CHILD = ITEMS.register("crying_child",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CURSED_MODE = ITEMS.register("cursed_mode",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
