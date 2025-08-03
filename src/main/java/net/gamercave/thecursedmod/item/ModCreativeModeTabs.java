package net.gamercave.thecursedmod.item;

import net.gamercave.thecursedmod.TheCursedMod;
import net.gamercave.thecursedmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheCursedMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> CURSED_MOD_TAB = CREATIVE_MODE_TABS.register("cursed_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CURSED_MODE.get()))
                    .title(Component.translatable("creativetab.thecursedmod.cursed_mod"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CURSED_ITEM.get());
                        output.accept(ModItems.RAW_CURSED_ITEM.get());
                        output.accept(ModItems.FREDBEAR_PLUSH.get());
                        output.accept(ModItems.UNFINISHED_FREDBEAR_PLUSH.get());
                        output.accept(ModItems.CRYING_CHILD.get());

                        output.accept(ModBlocks.CURSED_BLOCK.get());
                        output.accept(ModBlocks.CURSED_ORE.get());
                        output.accept(ModBlocks.CURSED_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.FREDBEAR_BLOCK.get());
                        output.accept(ModBlocks.FREDBEAR_ORE.get());
                        output.accept(ModBlocks.FREDBEAR_DEEPSLATE_ORE.get());
                    })


                    .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
