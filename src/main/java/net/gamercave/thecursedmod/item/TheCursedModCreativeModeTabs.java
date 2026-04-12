package net.gamercave.thecursedmod.item;

import net.gamercave.thecursedmod.TheCursedMod;
import net.gamercave.thecursedmod.block.TheCursedModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TheCursedModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheCursedMod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("cursed_mod_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab.thecursedmod.cursed_mod"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> TheCursedModItems.CURSED_MODE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(TheCursedModItems.CURSED_ITEM.get());
                output.accept(TheCursedModItems.RAW_CURSED_ITEM.get());
                output.accept(TheCursedModItems.FREDBEAR_PLUSH.get());
                output.accept(TheCursedModItems.UNFINISHED_FREDBEAR_PLUSH.get());
                output.accept(TheCursedModItems.CRYING_CHILD.get());
                output.accept(TheCursedModItems.FORGER.get());
                output.accept(TheCursedModItems.SUPERSTAR.get());

                output.accept(TheCursedModItems.GOLDMAKER.get());

                output.accept(TheCursedModBlocks.CURSED_BLOCK.get());
                output.accept(TheCursedModBlocks.TRANSFORMER_BLOCK.get());
                output.accept(TheCursedModBlocks.CURSED_ORE.get());
                output.accept(TheCursedModBlocks.CURSED_DEEPSLATE_ORE.get());
                output.accept(TheCursedModBlocks.FREDBEAR_BLOCK.get());
                output.accept(TheCursedModBlocks.FREDBEAR_DEEPSLATE_ORE.get());
                output.accept(TheCursedModBlocks.FREDBEAR_ORE.get());
            }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
