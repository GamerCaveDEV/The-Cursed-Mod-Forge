package net.gamercave.thecursedmod.block;


import net.gamercave.thecursedmod.TheCursedMod;
import net.gamercave.thecursedmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TheCursedMod.MOD_ID);

    public static final RegistryObject<Block> CURSED_BLOCK = registerBlock("cursed_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).destroyTime(3).sound(SoundType.ANVIL)));

    public static final RegistryObject<Block> FREDBEAR_BLOCK = registerBlock("fredbear_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).destroyTime(6).sound(SoundType.ANVIL)));

    public static final RegistryObject<Block> CURSED_ORE = registerBlock("cursed_ore",
            () -> new DropExperienceBlock(UniformInt.of(9999, 99999), BlockBehaviour.Properties.of()
                    .strength(4f).destroyTime(3).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> CURSED_DEEPSLATE_ORE = registerBlock("cursed_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(999999999, 999999999), BlockBehaviour.Properties.of()
                    .strength(5f).destroyTime(3).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> FREDBEAR_ORE = registerBlock("fredbear_ore",
            () -> new DropExperienceBlock(UniformInt.of(99999, 99999), BlockBehaviour.Properties.of()
                    .strength(4f).destroyTime(3).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> FREDBEAR_DEEPSLATE_ORE = registerBlock("fredbear_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(999999999, 999999999), BlockBehaviour.Properties.of()
                    .strength(5f).destroyTime(3).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
