package net.gamercave.thecursedmod;

import com.mojang.logging.LogUtils;
import net.gamercave.thecursedmod.block.ModBlocks;
import net.gamercave.thecursedmod.datagen.DataGenerators;
import net.gamercave.thecursedmod.item.ModCreativeModeTabs;
import net.gamercave.thecursedmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TheCursedMod.MOD_ID)
public class TheCursedMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "thecursedmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public TheCursedMod(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);


        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(DataGenerators::gatherData);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
       modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.CURSED_ITEM);
            event.accept(ModItems.CURSED_MODE);
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.FREDBEAR_PLUSH);
            event.accept(ModItems.CRYING_CHILD);
            event.accept(ModItems.UNFINISHED_FREDBEAR_PLUSH);
            event.accept(ModItems.RAW_CURSED_ITEM);
            event.accept(ModItems.FORGER);
            event.accept(ModItems.GOLDMAKER);
            event.accept(ModItems.SUPERSTAR);


        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.CURSED_BLOCK);
            event.accept(ModBlocks.CURSED_ORE);
            event.accept(ModBlocks.CURSED_DEEPSLATE_ORE);
            event.accept(ModBlocks.FREDBEAR_BLOCK);
            event.accept(ModBlocks.FREDBEAR_ORE);
            event.accept(ModBlocks.FREDBEAR_DEEPSLATE_ORE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}